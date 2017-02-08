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

public class mysqlLiecbaDaoTest {

    LiekDAO liekDao = DaoFactory.INSTANCE.getLiekDao();

    public mysqlLiecbaDaoTest() {
    }

    @Before
    public void setUp() {

    }

    @Test
    public void testPridajLiecbu() {
        System.out.println("Pridaj liecbu");
        Liecba liecba = new Liecba();
        MysqlLiecbaDao liecbaDao = new MysqlLiecbaDao(TestFactory.INSTANCE.getJdbcTemplate());
        liecba.setNazov("masaz");
        List<Liecba> liecby1 = liecbaDao.dajLiecby();
        liecbaDao.pridajLiecbu(liecba);
        List<Liecba> liecby2 = liecbaDao.dajLiecby();
        Assert.assertEquals(liecby2.size(), liecby1.size() + 1);
        liecbaDao.vymazLiecbu(liecby2.get(0));
    }

    @Test
    public void testDajLiecby() {
        System.out.println("Daj liecbu");
        Liecba liecba = new Liecba();
        MysqlLiecbaDao liecbaDao = new MysqlLiecbaDao(TestFactory.INSTANCE.getJdbcTemplate());
        liecba.setNazov("masaz");
        liecbaDao.pridajLiecbu(liecba);
        List<Liecba> liecby = liecbaDao.dajLiecby();
        Assert.assertEquals(1, liecby.size());
        liecbaDao.vymazLiecbu(liecby.get(0));
    }

    @Test
    public void testUpravLiecbu() {
        System.out.println("Edituj liecbu");
        Liecba liecba = new Liecba();
        MysqlLiecbaDao liecbaDao = new MysqlLiecbaDao(TestFactory.INSTANCE.getJdbcTemplate());
        liecba.setNazov("masaz");
        liecbaDao.pridajLiecbu(liecba);
        List<Liecba> liecby = liecbaDao.dajLiecby();
        liecba = liecby.get(0);
        liecba.setNazov("akupunktura");
        liecbaDao.upravLiecbu(liecba);
        liecby = liecbaDao.dajLiecby();
        Assert.assertEquals("akupunktura", liecby.get(0).getNazov());
        liecbaDao.vymazLiecbu(liecby.get(0));
    }

    @Test
    public void testVymazLiecbu() {
        Liecba liecba = new Liecba();
        MysqlLiecbaDao liecbaDao = new MysqlLiecbaDao(TestFactory.INSTANCE.getJdbcTemplate());
        liecba.setNazov("masaz");
        liecbaDao.pridajLiecbu(liecba);
        List<Liecba> liecby1 = liecbaDao.dajLiecby();
        liecba = liecby1.get(0);
        liecbaDao.vymazLiecbu(liecba);
        List<Liecba> liecby2 = liecbaDao.dajLiecby();
        Assert.assertEquals(liecby2.size() + 1, liecby1.size());
    }

}
