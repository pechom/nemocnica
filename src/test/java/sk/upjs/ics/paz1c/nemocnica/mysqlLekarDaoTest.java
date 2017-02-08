package sk.upjs.ics.paz1c.nemocnica;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class mysqlLekarDaoTest {

    public mysqlLekarDaoTest() {
    }

    @Before
    public void setUp() {

    }

    @Test
    public void testPridajLekara() {
        System.out.println("Pridaj lekára");
        Lekar lekar = new Lekar();
        MysqlLekarDao lekarDao = new MysqlLekarDao(TestFactory.INSTANCE.getJdbcTemplate());
        lekar.setMeno("Jozef");
        lekar.setPriezvisko("Malý");
        lekar.setSpecializacia("obvodný");
        List<Lekar> lekari1 = lekarDao.dajLekarov();
        lekarDao.pridajLekara(lekar);
        List<Lekar> lekari2 = lekarDao.dajLekarov();
        Assert.assertEquals(lekari1.size() + 1, lekari2.size());
        lekarDao.vymazLekara(lekari2.get(0));
    }

    @Test
    public void testDajLekarov() {
        System.out.println("Daj lekárov");
        Lekar lekar = new Lekar();
        lekar.setMeno("Jozef");
        lekar.setPriezvisko("Malý");
        lekar.setSpecializacia("obvodný");
        MysqlLekarDao lekarDao = new MysqlLekarDao(TestFactory.INSTANCE.getJdbcTemplate());
        lekarDao.pridajLekara(lekar);
        List<Lekar> lekari = lekarDao.dajLekarov();
        Assert.assertEquals(1, lekari.size());
        lekarDao.vymazLekara(lekari.get(0));
    }

    @Test
    public void testUpravLekara() {
        System.out.println("Edituj lekára");
        Lekar lekar = new Lekar();
        lekar.setMeno("Jozef");
        lekar.setPriezvisko("Malý");
        lekar.setSpecializacia("obvodný");
        MysqlLekarDao lekarDao = new MysqlLekarDao(TestFactory.INSTANCE.getJdbcTemplate());
        lekarDao.pridajLekara(lekar);
        List<Lekar> lekari1 = lekarDao.dajLekarov();
        lekar = lekari1.get(0);
        lekar.setMeno("Jožko");
        lekar.setPriezvisko("Malý");
        lekar.setSpecializacia("obvodný");
        lekarDao.upravLekara(lekar);
        Assert.assertEquals("Jožko", lekari1.get(0).getMeno());
        lekarDao.vymazLekara(lekari1.get(0));
    }

    @Test
    public void testVymazLekara() {
        Lekar lekar = new Lekar();
        lekar.setMeno("Jozef");
        lekar.setPriezvisko("Malý");
        lekar.setSpecializacia("obvodný");
        MysqlLekarDao lekarDao = new MysqlLekarDao(TestFactory.INSTANCE.getJdbcTemplate());
        lekarDao.pridajLekara(lekar);
        List<Lekar> lekari1 = lekarDao.dajLekarov();
        lekar = lekari1.get(0);
        lekarDao.vymazLekara(lekar);
        List<Lekar> lekari2 = lekarDao.dajLekarov();
        Assert.assertEquals(lekari1.size(), lekari2.size() + 1);

    }

}
