/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * 幫忙把BAB資料在晚上10點時記錄到資料庫(晚上6點的job 只關閉燈號 txt 1 -> 0)
 */
package com.advantech.quartzJob;

import com.advantech.model.Bab;
import com.advantech.model.BabStatus;
import com.advantech.helper.ApplicationContextHelper;
import com.advantech.service.BabService;
import java.util.List;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 *
 * @author Wei.Cheng Auto close bab and set to abnormal sign on bab isused
 * 避免Auto close on working time, 使用者無法得知系統已經自動關閉逾期未關閉工單
 */
public class BabDataSaver extends QuartzJobBean {

    private static final Logger log = LoggerFactory.getLogger(BabDataSaver.class);

    private final BabService babService;

    public BabDataSaver() {
        babService = (BabService) ApplicationContextHelper.getBean("babService");
    }

    @Override
    public void executeInternal(JobExecutionContext jec) throws JobExecutionException {
        saveBABData();
    }

    //Auto save the data to Linebalancing_Main if user is not close the 工單.
    private void saveBABData() {

        List<Bab> unClosedBabs = this.getUnclosedBabs();
        log.info("Unclosed babList size = " + unClosedBabs.size());

        for (Bab bab : unClosedBabs) {
            log.info("Begin save unclose bab " + bab.getId());
            babService.closeBabDirectly(bab);
            bab.setBabStatus(BabStatus.UNFINSHED);
            babService.update(bab);
            log.info("Close bab status success");
        }

    }

    private List getUnclosedBabs() {
        return babService.findProcessing();
    }

}
