package sk.upjs.ics.paz1c.nemocnica;

import java.util.Arrays;
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
 * @author erika
 */
public class mysqlDiagnozaDaoTest {

    public mysqlDiagnozaDaoTest() {
    }

    @Before
    public void setUp() {

    }

    @Test
    public void testPridajDiagnozu() {
        System.out.println("Pridaj diagnózu");
        Diagnoza diagnoza = new Diagnoza();
        MysqlDiagnozaDao diagnozaDao = new MysqlDiagnozaDao(TestFactory.INSTANCE.getJdbcTemplate());
        diagnoza.setNazov("horúčka");
        List<Diagnoza> diagnozy1 = diagnozaDao.dajDiagnozy();
        diagnozaDao.pridajDiagnozu(diagnoza);
        List<Diagnoza> diagnozy2 = diagnozaDao.dajDiagnozy();
        Assert.assertEquals(diagnozy1.size() + 1, diagnozy2.size());
        diagnozaDao.vymazDiagnozu(diagnozy2.get(0));
    }

    @Test
    public void testDajDiagnozy() {
        System.out.println("Daj diagnózy");
        Diagnoza diagnoza = new Diagnoza();
        diagnoza.setNazov("horúčka");
        MysqlDiagnozaDao diagnozaDao = new MysqlDiagnozaDao(TestFactory.INSTANCE.getJdbcTemplate());
        diagnozaDao.pridajDiagnozu(diagnoza);
        List<Diagnoza> diagnozy = diagnozaDao.dajDiagnozy();
        Assert.assertEquals(1, diagnozy.size());
        diagnozaDao.vymazDiagnozu(diagnozy.get(0));
    }

    @Test
    public void testUpravDiagnozu() {
        System.out.println("Edituj diagnózu");
        Diagnoza diagnoza = new Diagnoza();
        diagnoza.setNazov("horúčka");
        MysqlDiagnozaDao diagnozaDao = new MysqlDiagnozaDao(TestFactory.INSTANCE.getJdbcTemplate());
        diagnozaDao.ulozDiagnozu(diagnoza);
        List<Diagnoza> diagnozy = diagnozaDao.dajDiagnozy();
        Diagnoza diag = diagnozy.get(0);
        diag.setNazov("chrípka");
        diagnozaDao.upravDiagnozu(diag);
        diagnozy = diagnozaDao.dajDiagnozy();
        Assert.assertEquals("chrípka", diagnozy.get(0).getNazov());
        diagnozaDao.vymazDiagnozu(diagnozy.get(0));
    }

    @Test
    public void testVymazDiagnozu() {
        System.out.println("Vymaz diagnózu");
        Diagnoza diagnoza = new Diagnoza();
        diagnoza.setNazov("horúčka");
        MysqlDiagnozaDao diagnozaDao = new MysqlDiagnozaDao(TestFactory.INSTANCE.getJdbcTemplate());
        diagnozaDao.pridajDiagnozu(diagnoza);
        List<Diagnoza> diagnozy1 = diagnozaDao.dajDiagnozy();
        diagnozaDao.vymazDiagnozu(diagnozy1.get(0));
        List<Diagnoza> diagnozy2 = diagnozaDao.dajDiagnozy();
        Assert.assertEquals(diagnozy1.size(), diagnozy2.size() + 1);
    }
}
