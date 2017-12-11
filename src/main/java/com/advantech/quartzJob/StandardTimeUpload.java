/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.advantech.quartzJob;

import com.advantech.helper.MailManager;
import com.advantech.jqgrid.PageInfo;
import com.advantech.model.User;
import com.advantech.model.Worktime;
import com.advantech.service.AuditService;
import com.advantech.service.UserNotificationService;
import com.advantech.service.WorktimeService;
import com.advantech.webservice.port.StandardtimeUploadPort;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.annotation.PostConstruct;
import javax.mail.MessagingException;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Wei.Cheng Upload standard time to mes
 */
public class StandardTimeUpload {

    private static final Logger log = LoggerFactory.getLogger(StandardTimeUpload.class);

    @Autowired
    private AuditService auditService;

    @Autowired
    private UserNotificationService userNotificationService;

    @Autowired
    private MailManager mailManager;

    @Autowired
    private WorktimeService worktimeService;

    @Autowired
    private StandardtimeUploadPort port;

    private DateTimeFormatter df;

    private PageInfo tempInfo;

    @PostConstruct
    public void init() {
        df = DateTimeFormat.forPattern("yyyy-MM-dd");
        tempInfo = new PageInfo();
        tempInfo.setRows(-1);
        tempInfo.setSearchField("modifiedDate");
        tempInfo.setSearchOper("gt");
    }

    public void uploadToMes() {
        List<String> errorMessages = new ArrayList();
        this.updatePageInfo();
        List<Worktime> modifiedWorktimes = worktimeService.findAll(tempInfo);

        log.info("Begin upload standardtime to mes: " + modifiedWorktimes.size() + " datas.");

        port.initSettings();

        for (Worktime w : modifiedWorktimes) {
            try {
                Worktime rowLastStatus = (Worktime) auditService.findLastStatusBeforeUpdate(Worktime.class, w.getId());
                if (isStandardTimeChanged(rowLastStatus, w)) {
                    port.update(w);
                }
            } catch (Exception e) {
                String errorMessage = w.getModelName() + " upload fail: " + e.getMessage();
                errorMessages.add(errorMessage);
                log.error(errorMessage);
            }
        }

        this.notifyUser(errorMessages);

        log.info("Upload standardtime job finished.");
    }

    private boolean isStandardTimeChanged(Worktime prev, Worktime current) {
        return !Objects.equals(prev.getTotalModule(), current.getTotalModule())
                || !Objects.equals(prev.getCleanPanel(), current.getCleanPanel())
                || !Objects.equals(prev.getAssy(), current.getAssy())
                || !Objects.equals(prev.getT1(), current.getT1())
                || !Objects.equals(prev.getT2(), current.getT2())
                || !Objects.equals(prev.getT3(), current.getT3())
                || !Objects.equals(prev.getT4(), current.getT4())
                || !Objects.equals(prev.getHiPotLeakage(), current.getHiPotLeakage())
                || !Objects.equals(prev.getColdBoot(), current.getColdBoot())
                || !Objects.equals(prev.getWarmBoot(), current.getWarmBoot())
                || !Objects.equals(prev.getVibration(), current.getVibration())
                || !Objects.equals(prev.getUpBiRi(), current.getUpBiRi())
                || !Objects.equals(prev.getDownBiRi(), current.getDownBiRi())
                || !Objects.equals(prev.getPacking(), current.getPacking())
                || !Objects.equals(prev.getAssyStation(), current.getAssyStation())
                || !Objects.equals(prev.getPackingStation(), current.getPackingStation());
    }

    public void updatePageInfo() {
        tempInfo.setSearchString(df.print(new DateTime().minusWeeks(1)));
    }

    public void notifyUser(List<String> l) {
        String[] to = getMailByNotification("worktime_upload_alarm");
        String[] cc = new String[0];

        String subject = "【系統訊息】大表上傳";
        String text = generateTextBody(l);

        try {
            mailManager.sendMail(to, cc, subject, text);
        } catch (MessagingException ex) {
            log.error("Send mail fail when upload mes job fail." + ex.toString());
        }
    }

    private String generateTextBody(List<String> l) {
        StringBuilder sb = new StringBuilder();
        sb.append("<p>Dear All:</p>");
        if (l.isEmpty()) {
            sb.append("<p>大表標工上傳成功於下列時間</p><p>");
            sb.append(new DateTime());
            sb.append("</p>");
        } else {
            sb.append("<p>上傳至大表發生了異常，訊息清單如下</p>");
            for (String st : l) {
                sb.append("<p>");
                sb.append(st);
                sb.append("</p>");
            }
            sb.append("<p>請相關人員至系統確認大表設定是否正確。</p>");
        }
        return sb.toString();
    }

    private String[] getMailByNotification(String notification) {
        List<User> users = userNotificationService.findUsersByNotification(notification);
        String[] mails = new String[users.size()];
        for (int i = 0; i < mails.length; i++) {
            String mail = users.get(i).getEmail();
            if (mail != null && !"".equals(mail)) {
                mails[i] = mail;
            }
        }
        return mails;
    }
}
