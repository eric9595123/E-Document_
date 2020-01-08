/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.advantech.dao;

import com.advantech.model.Line;
import com.advantech.model.LineUserReference;
import com.advantech.model.LineUserReferenceId;
import java.util.List;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Wei.Cheng
 */
@Repository
public class LineUserReferenceDAO extends AbstractDao<LineUserReferenceId, LineUserReference> implements BasicDAO_1<LineUserReference> {

    @Override
    public List<LineUserReference> findAll() {
        return super.createEntityCriteria().list();
    }

    @Override
    public LineUserReference findByPrimaryKey(Object obj_id) {
        return super.getByKey((LineUserReferenceId) obj_id);
    }

    public List<LineUserReference> findByLine(Line line) {
        return super.createEntityCriteria()
                .add(Restrictions.eq("id.line", line))
                .addOrder(Order.asc("station"))
                .list();
    }
    
    public List<LineUserReference> findByLines(List<Line> line) {
        return super.createEntityCriteria()
                .add(Restrictions.in("id.line", line))
                .addOrder(Order.asc("station"))
                .list();
    }

    @Override
    public int insert(LineUserReference pojo) {
        super.getSession().save(pojo);
        return 1;
    }

    @Override
    public int update(LineUserReference pojo) {
        super.getSession().update(pojo);
        return 1;
    }

    @Override
    public int delete(LineUserReference pojo) {
        super.getSession().delete(pojo);
        return 1;
    }

}
