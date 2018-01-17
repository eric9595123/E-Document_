/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.advantech.service;

import com.advantech.model.BabSettingHistory;
import com.advantech.dao.BabSettingHistoryDAO;
import com.advantech.model.Bab;
import com.advantech.model.BabSensorLoginRecord;
import com.advantech.model.SensorTransform;
import com.advantech.model.TagNameComparison;
import static com.google.common.base.Preconditions.*;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Wei.Cheng Please keep one setting per bab and station
 */
@Service
@Transactional
public class BabSettingHistoryService {

    @Autowired
    private BabSettingHistoryDAO babSettingHistoryDAO;

    @Autowired
    private SensorTransformService sensorTransformService;

    @Autowired
    private BabSensorLoginRecordService babSensorLoginRecordService;

    @Autowired
    private TagNameComparisonService tagNameComparisonService;

    public List<BabSettingHistory> findAll() {
        return babSettingHistoryDAO.findAll();
    }

    public BabSettingHistory findByPrimaryKey(Object obj_id) {
        return babSettingHistoryDAO.findByPrimaryKey(obj_id);
    }

    public List<BabSettingHistory> findByBab(Bab b) {
        return babSettingHistoryDAO.findByBab(b);
    }

    public List<BabSettingHistory> findProcessing() {
        return babSettingHistoryDAO.findProcessing();
    }

    public BabSettingHistory findProcessingByTagName(String tagName) {
        SensorTransform sensor = sensorTransformService.findByPrimaryKey(tagName);
        checkArgument(sensor != null, "Can't find sensor named " + tagName);
        return babSettingHistoryDAO.findProcessingByTagName(sensor);
    }

    public int insert(BabSettingHistory pojo) {
        return babSettingHistoryDAO.insert(pojo);
    }

    public int insertByBab(Bab b, TagNameComparison tag) {
        List<BabSensorLoginRecord> babLogins = babSensorLoginRecordService.findByLine(b.getLine().getId());

        //Find setting in setting and check users in lists are login or not
        List<TagNameComparison> tagNameSetting = tagNameComparisonService.findInRange(tag, b.getPeople());
        int i = 1;
        for (TagNameComparison tagNameComp : tagNameSetting) {
            SensorTransform sensor = tagNameComp.getId().getLampSysTagName();
            BabSensorLoginRecord rec = babLogins.stream()
                    .filter(r -> r.getTagName().equals(sensor))
                    .findFirst().orElse(null);
            checkArgument(rec != null, "Can't find user login in tagName " + sensor.getName());
            BabSettingHistory setting = new BabSettingHistory(b, i++, sensor, rec.getJobnumber());
            this.insert(setting);
        }
        return 1;
    }

    //Record jobnumber by "Hibernate Audit" audit jobnumber change event in sql.
    public int changeUser(Bab b, String jobnumber, int station) throws Exception {
        BabSettingHistory setting = babSettingHistoryDAO.findByBabAndStation(b, station);
        checkArgument(setting != null, "Prev user setting in this station not found");
        checkArgument(setting.getLastUpdateTime() == null, "This station is already finished");
        checkArgument(!jobnumber.equals(setting.getJobnumber()), "Jobnumber is the same");
        setting.setJobnumber(jobnumber);
        babSettingHistoryDAO.update(setting);
        return 1;
    }

    public int update(BabSettingHistory pojo) {
        return babSettingHistoryDAO.update(pojo);
    }

    public int delete(BabSettingHistory pojo) {
        return babSettingHistoryDAO.delete(pojo);
    }

    public int init() {
        List<BabSettingHistory> l = babSettingHistoryDAO.findProcessing();
        Date d = new Date();
        for (BabSettingHistory b : l) {
            b.setLastUpdateTime(d);
            babSettingHistoryDAO.update(b);
        }
        return 1;
    }

}
