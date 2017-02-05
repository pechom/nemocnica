package sk.upjs.ics.paz1c.nemocnica;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
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
    
    @Test
    public void testPridajDiagnozu(){
        System.out.println("Pridaj diagnózu");
        Diagnoza diagnoza = new Diagnoza();
        MysqlDiagnozaDao instance = new MysqlDiagnozaDao(DaoFactory.INSTANCE.getJdbcTemplate());
        diagnoza.setId(1);
        diagnoza.setNazov("horúčka");
        List<Diagnoza> diagnozy = instance.dajDiagnozy();
        instance.pridajDiagnozu(diagnoza);
    }
    
    @Test
    public void testDajDiagnozy(){
        System.out.println("Daj diagnózy");
        MysqlDiagnozaDao dao = new MysqlDiagnozaDao(DaoFactory.INSTANCE.getJdbcTemplate());
        List<Diagnoza> diagnozy = dao.dajDiagnozy();
    }
    
     @Test
    public void testUpravDiagnozu() {
        System.out.println("Edituj diagnózu");
        Diagnoza diagnoza = new Diagnoza();
        MysqlDiagnozaDao instance = new MysqlDiagnozaDao(DaoFactory.INSTANCE.getJdbcTemplate());
        diagnoza.setId(1);
        diagnoza.setNazov("chrípka");
        instance.upravDiagnozu(diagnoza);
    }
}
