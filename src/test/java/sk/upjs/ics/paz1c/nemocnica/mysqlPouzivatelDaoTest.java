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
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author szoplakz
 */
public class mysqlPouzivatelDaoTest {

     private String setup;
     private String after;
    private JdbcTemplate jdbcTemplate;

    public mysqlPouzivatelDaoTest() {
    }

    @Before
    public void setUp() {
        //vzhladom na to ze pouzivatel sa pridava len v databaze tak sucastou tohto testu je aj databazovy script 
        //ktory musi byt spusteny pred testami
        jdbcTemplate = TestFactory.INSTANCE.getJdbcTemplate();
        setup = "insert into pouzivatel (login, password) values (\"peter\", \"yareyare\");";
        jdbcTemplate.update(setup);
        after = "delete from pouzivatel where id=?;";
    }

    @Test
    public void testDajPouzivatelov() {
        MysqlPouzivatelDao pouzivatelDao = new MysqlPouzivatelDao(TestFactory.INSTANCE.getJdbcTemplate());
        List<Pouzivatel> pouzivatelia = pouzivatelDao.dajPouzivatelov();
        Assert.assertEquals(1, pouzivatelia.size());
        jdbcTemplate.update(after, pouzivatelia.get(0).getId());
    }

    @Test
    public void testUpravPouzivatela() {
        MysqlPouzivatelDao pouzivatelDao = new MysqlPouzivatelDao(TestFactory.INSTANCE.getJdbcTemplate());
        List<Pouzivatel> pouzivatelia = pouzivatelDao.dajPouzivatelov();
        Pouzivatel pouzivatel = pouzivatelia.get(0);
        pouzivatel.setLogin("zoli");
        pouzivatelDao.upravPouzivatela(pouzivatel);
        pouzivatelia = pouzivatelDao.dajPouzivatelov();
        Assert.assertEquals("zoli", pouzivatelia.get(0).getLogin());
        jdbcTemplate.update(after, pouzivatelia.get(0).getId());
    }

    @Test
    public void testZmenHeslo() {
        MysqlPouzivatelDao pouzivatelDao = new MysqlPouzivatelDao(TestFactory.INSTANCE.getJdbcTemplate());
        List<Pouzivatel> pouzivatelia = pouzivatelDao.dajPouzivatelov();
        Pouzivatel pouzivatel = pouzivatelia.get(0);
        pouzivatel.setPassword("zoli");
        pouzivatelDao.zmenHeslo(pouzivatel);
        pouzivatelia = pouzivatelDao.dajPouzivatelov();
        Assert.assertEquals("zoli", pouzivatelia.get(0).getPassword());
        jdbcTemplate.update(after, pouzivatelia.get(0).getId());
    }

    @Test
    public void najdiPouzivatela() {
        MysqlPouzivatelDao pouzivatelDao = new MysqlPouzivatelDao(TestFactory.INSTANCE.getJdbcTemplate());
        List<Pouzivatel> pouzivatelia = pouzivatelDao.dajPouzivatelov();
        Pouzivatel pouzivatel = pouzivatelDao.najdiPouzivatela(pouzivatelia.get(0).getLogin());
        assertNotEquals(pouzivatel, null);
        jdbcTemplate.update(after, pouzivatelia.get(0).getId());
    }

    @Test
    public void checkMenoAHeslo() {
        MysqlPouzivatelDao pouzivatelDao = new MysqlPouzivatelDao(TestFactory.INSTANCE.getJdbcTemplate());
        List<Pouzivatel> pouzivatelia = pouzivatelDao.dajPouzivatelov();
        Pouzivatel pouzivatel = pouzivatelia.get(0);
        boolean check1 = pouzivatelDao.checkMenoAHeslo(pouzivatel.getLogin(), pouzivatel.getPassword());
        boolean check2 = pouzivatelDao.checkMenoAHeslo(pouzivatel.getLogin(), null);
        boolean check3 = pouzivatelDao.checkMenoAHeslo(null, pouzivatel.getPassword());
        boolean check4 = pouzivatelDao.checkMenoAHeslo(null, null);
        assertEquals(check1, true);
        assertEquals(check2, false);
        assertEquals(check3, false);
        assertEquals(check4, false);
        jdbcTemplate.update(after, pouzivatelia.get(0).getId());
    }

}
