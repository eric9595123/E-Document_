/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.advantech.dao;

import com.advantech.model.Bab;
import com.advantech.model.BabSettingHistory;
import com.advantech.model.SensorTransform;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.joda.time.DateTime;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Wei.Cheng
 */
@Repository
public class BabSettingHistoryDAO extends AbstractDao<Integer, BabSettingHistory> implements BasicDAO_1<BabSettingHistory> {

    @Override
    public List<BabSettingHistory> findAll() {
        return super.createEntityCriteria().list();
    }

    @Override
    public BabSettingHistory findByPrimaryKey(Object obj_id) {
        return super.getByKey((int) obj_id);
    }

    public List<BabSettingHistory> findByBab(Bab b) {
        return super.createEntityCriteria()
                .add(Restrictions.eq("bab.id", b.getId()))
                .list();
    }

    public BabSettingHistory findByBabAndStation(Bab b, int station) {
        Criteria c = super.createEntityCriteria();
        c.add(Restrictions.eq("bab.id", b.getId()));
        c.add(Restrictions.eq("station", station));
        return (BabSettingHistory) c.uniqueResult();
    }
    
    public List<BabSettingHistory> findProcessing(){
        Criteria c = super.createEntityCriteria();
        c.add(Restrictions.isNull("lastUpdateTime"));
        return c.list();
    }
    
    public BabSettingHistory findProcessingByTagName(SensorTransform tagName){
        Criteria c = super.createEntityCriteria();
        c.add(Restrictions.eq("tagName", tagName));
        c.add(Restrictions.isNull("lastUpdateTime"));
        c.add(Restrictions.gt("createTime", new DateTime().withHourOfDay(0).toDate()));
        c.setMaxResults(1);
        return (BabSettingHistory) c.uniqueResult();
    }

    @Override
    public int insert(BabSettingHistory pojo) {
        super.getSession().save(pojo);
        return 1;
    }

    @Override
    public int update(BabSettingHistory pojo) {
        super.getSession().update(pojo);
        return 1;
    }

    @Override
    public int delete(BabSettingHistory pojo) {
        super.getSession().delete(pojo);
        return 1;
    }

}
