/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.upjs.ics.paz1c.nemocnica;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class mysqlZaznamDaoTest {
    
    public mysqlZaznamDaoTest() {
    }
    
     @Test
    public void testDajZaznamy(){
        System.out.println("Daj zaznamy");
        MysqlZaznamDao dao = new MysqlZaznamDao(DaoFactory.INSTANCE.getJdbcTemplate());
        List<Zaznam> zaznamy = dao.dajZaznamy();
    }
    
}
