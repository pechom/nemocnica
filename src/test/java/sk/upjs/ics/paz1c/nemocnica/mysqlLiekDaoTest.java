package sk.upjs.ics.paz1c.nemocnica;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class mysqlLiekDaoTest {

    LiekDAO liekDao = DaoFactory.INSTANCE.getLiekDao();

    public mysqlLiekDaoTest() {
    }

    @Before
    public void setUp() {

    }

    @Test
    public void testPridajLieka() {
        System.out.println("Pridaj liek");
        Liek liek = new Liek();
        MysqlLiekDao LiekDao = new MysqlLiekDao(TestFactory.INSTANCE.getJdbcTemplate());
        liek.setNazov("paralen");
        List<Liek> lieky1 = LiekDao.dajLieky();
        LiekDao.pridajLiek(liek);
        List<Liek> lieky2 = LiekDao.dajLieky();
        Assert.assertEquals(lieky2.size(), lieky1.size() + 1);
        LiekDao.vymazLiek(lieky2.get(0));
    }

    @Test
    public void testDajLieky() {
        System.out.println("Daj liek");
        Liek liek = new Liek();
        MysqlLiekDao LiekDao = new MysqlLiekDao(TestFactory.INSTANCE.getJdbcTemplate());
        liek.setNazov("paralen");
        LiekDao.ulozLiek(liek);
        List<Liek> lieky = LiekDao.dajLieky();
        Assert.assertEquals(1, lieky.size());
        LiekDao.vymazLiek(lieky.get(0));
    }

    @Test
    public void testUpravLiek() {
        System.out.println("Edituj liek");
        Liek liek = new Liek();
        MysqlLiekDao LiekDao = new MysqlLiekDao(TestFactory.INSTANCE.getJdbcTemplate());
        liek.setNazov("paralen");
        LiekDao.ulozLiek(liek);
        List<Liek> lieky = LiekDao.dajLieky();
        liek = lieky.get(0);
        liek.setNazov("ibalgin");
        LiekDao.upravLiek(liek);
        lieky = LiekDao.dajLieky();
        Assert.assertEquals("ibalgin", lieky.get(0).getNazov());
        LiekDao.vymazLiek(lieky.get(0));
    }

    @Test
    public void testVymazLiek() {
        System.out.println("Vymaz liek");
        Liek liek = new Liek();
        liek.setNazov("paralen");
        MysqlLiekDao LiekDao = new MysqlLiekDao(TestFactory.INSTANCE.getJdbcTemplate());
        LiekDao.pridajLiek(liek);
        List<Liek> lieky1 = LiekDao.dajLieky();
        LiekDao.vymazLiek(lieky1.get(0));
        List<Liek> lieky2 = LiekDao.dajLieky();
        Assert.assertEquals(lieky2.size() + 1, lieky1.size());
    }

}
