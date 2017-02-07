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
    
    @Test
    public void testPridajDiagnozu(){
        System.out.println("Pridaj diagnózu");
        Diagnoza diagnoza = new Diagnoza();
        MysqlDiagnozaDao instance = new MysqlDiagnozaDao(TestFactory.INSTANCE.getJdbcTemplate());
        diagnoza.setId(1);
        diagnoza.setNazov("horúčka");
        List<Diagnoza> diagnozy1 = instance.dajDiagnozy();
        instance.pridajDiagnozu(diagnoza);
         List<Diagnoza> diagnozy2 = instance.dajDiagnozy();
         Assert.assertEquals(diagnozy1.size()+1,diagnozy2.size());
    }
    
    @Test
    public void testDajDiagnozy(){
        System.out.println("Daj diagnózy");
        MysqlDiagnozaDao dao = new MysqlDiagnozaDao(TestFactory.INSTANCE.getJdbcTemplate());
        List<Diagnoza> diagnozy = dao.dajDiagnozy();
        Assert.assertEquals(0,diagnozy.size());
    }
    
     @Test
    public void testUpravDiagnozu() {
        System.out.println("Edituj diagnózu");
        
        MysqlDiagnozaDao instance = new MysqlDiagnozaDao(TestFactory.INSTANCE.getJdbcTemplate());
         List<Diagnoza> diagnozy = instance.dajDiagnozy();
         Diagnoza diagnoza = diagnozy.get(0);       
        diagnoza.setNazov("chrípka");
        instance.upravDiagnozu(diagnoza);
        Assert.assertEquals("chrípka",diagnozy.get(0).getNazov());
    }
    @Test
    public void testVymazDiagnozu() {
        
        MysqlDiagnozaDao instance = new MysqlDiagnozaDao(TestFactory.INSTANCE.getJdbcTemplate());
        List<Diagnoza> diagnozy1 = instance.dajDiagnozy();
        Diagnoza diagnoza = diagnozy1.get(0); 
        
        instance.vymazDiagnozu(diagnoza);
        
         List<Diagnoza> diagnozy2 = instance.dajDiagnozy();
         Assert.assertEquals(diagnozy1.size(),diagnozy2.size()+1);
    }
}
