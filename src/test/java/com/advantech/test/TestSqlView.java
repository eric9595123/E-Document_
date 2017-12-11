/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.advantech.test;

import com.advantech.dao.SqlViewDAO;
import com.advantech.helper.HibernateObjectPrinter;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Wei.Cheng
 */
@WebAppConfiguration
@ContextConfiguration(locations = {
    "classpath:servlet-context.xml"
})
@RunWith(SpringJUnit4ClassRunner.class)
public class TestSqlView {
    
    @Autowired
    private SqlViewDAO sqlViewDAO;

    @Test
    @Transactional
    @Rollback(true)
    public void testFindBabLastGroupStatus() throws JsonProcessingException {
        List l = sqlViewDAO.findSensorCurrentGroupStatus(11240);
        assertEquals(2, l.size());
        HibernateObjectPrinter.print(l);
    }
}
