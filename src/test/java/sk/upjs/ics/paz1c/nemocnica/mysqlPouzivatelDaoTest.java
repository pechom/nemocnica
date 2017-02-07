/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.upjs.ics.paz1c.nemocnica;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 *
 * @author szoplakz
 */
public class mysqlPouzivatelDaoTest {
  
 public mysqlPouzivatelDaoTest() {
    }
    
 @Test
    public void testDajPouzivatelov(){
        
        MysqlPouzivatelDao dao = new MysqlPouzivatelDao(TestFactory.INSTANCE.getJdbcTemplate());
        
        List<Pouzivatel> pouzivatelia = dao.dajPouzivatelov();
        Assert.assertEquals(pouzivatelia.size(),1);
    }
    
    @Test
    public void testUpravPouzivatela(){
       MysqlPouzivatelDao dao = new MysqlPouzivatelDao(TestFactory.INSTANCE.getJdbcTemplate());
        
        List<Pouzivatel> pouzivatelia = dao.dajPouzivatelov();
        Pouzivatel pouzivatel = pouzivatelia.get(0);
        pouzivatel.setLogin("zoli");
        dao.upravPouzivatela(pouzivatel);
        Assert.assertEquals(pouzivatelia.get(0).getLogin(),"zoli");
    }
    
    @Test
    public void testZmenHeslo(){
       MysqlPouzivatelDao dao = new MysqlPouzivatelDao(TestFactory.INSTANCE.getJdbcTemplate());
        
        List<Pouzivatel> pouzivatelia = dao.dajPouzivatelov();
        Pouzivatel pouzivatel = pouzivatelia.get(0);
        pouzivatel.setPassword("zoli");
        dao.zmenHeslo(pouzivatel);
        Assert.assertEquals(pouzivatelia.get(0).getPassword(),"zoli");
    }
}

