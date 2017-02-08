package sk.upjs.ics.paz1c.nemocnica;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class mysqlPacientDaoTest {

    public mysqlPacientDaoTest() {
    }

    @Before
    public void setUp() {

    }

    @Test
    public void testPridajPacienta() {
        System.out.println("Pridaj pacienta");
        Pacient pacient = new Pacient();
        MysqlPacientDao pacientDao = new MysqlPacientDao(TestFactory.INSTANCE.getJdbcTemplate());
        pacient.setMeno("Jozef");
        pacient.setPriezvisko("Malý");
        pacient.setVek(2);
        List<Pacient> pacienti1 = pacientDao.dajPacietov();
        pacientDao.pridajPacienta(pacient);
        List<Pacient> pacienti2 = pacientDao.dajPacietov();
        Assert.assertEquals(pacienti1.size() + 1, pacienti2.size());
        pacientDao.vymazPacienta(pacienti2.get(0));
    }

    @Test
    public void testDajPacientov() {
        System.out.println("Daj pacienta");
        Pacient pacient = new Pacient();
        MysqlPacientDao pacientDao = new MysqlPacientDao(TestFactory.INSTANCE.getJdbcTemplate());
        pacient.setMeno("Jozef");
        pacient.setPriezvisko("Malý");
        pacient.setVek(2);
        pacientDao.pridajPacienta(pacient);
        List<Pacient> pacienti = pacientDao.dajPacietov();
        Assert.assertEquals(1, pacienti.size());
        pacientDao.vymazPacienta(pacienti.get(0));
    }

    @Test
    public void testUpravPacienta() {
        System.out.println("Edituj pacienta");
        Pacient pacient = new Pacient();
        MysqlPacientDao pacientDao = new MysqlPacientDao(TestFactory.INSTANCE.getJdbcTemplate());
        pacient.setMeno("Jozef");
        pacient.setPriezvisko("Malý");
        pacient.setVek(2);
        pacientDao.pridajPacienta(pacient);
        List<Pacient> pacienti1 = pacientDao.dajPacietov();
        pacient = pacienti1.get(0);
        pacient.setMeno("Jozko");
        pacientDao.upravPacienta(pacient);
        pacienti1 = pacientDao.dajPacietov();
        Assert.assertEquals("Jozko", pacienti1.get(0).getMeno());
        pacientDao.vymazPacienta(pacienti1.get(0));
    }

    @Test
    public void testVymazPacienta() {
        Pacient pacient = new Pacient();
        MysqlPacientDao pacientDao = new MysqlPacientDao(TestFactory.INSTANCE.getJdbcTemplate());
        pacient.setMeno("Jozef");
        pacient.setPriezvisko("Malý");
        pacient.setVek(2);
        pacientDao.pridajPacienta(pacient);
        List<Pacient> pacienti1 = pacientDao.dajPacietov();
        pacient = pacienti1.get(0);
        pacientDao.vymazPacienta(pacient);
        List<Pacient> pacienti2 = pacientDao.dajPacietov();
        Assert.assertEquals(pacienti1.size(), pacienti2.size() + 1);

    }

}
