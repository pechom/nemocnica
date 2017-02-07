
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
    
    @Test
    public void testPridajLieka(){
        System.out.println("Pridaj liek");
        Liek liek = new Liek();
        MysqlLiekDao instance = new MysqlLiekDao(TestFactory.INSTANCE.getJdbcTemplate());
        liek.setId(1);
        liek.setNazov("paralen");
        List<Liek> lieky1 = instance.dajLieky();
        instance.pridajLiek(liek);
         List<Liek> lieky2 = instance.dajLieky();
         Assert.assertEquals(lieky2.size(), lieky1.size()+1);
    }
    
    @Test
    public void testDajLieky(){
        System.out.println("Daj liek");
        MysqlLiekDao dao = new MysqlLiekDao(TestFactory.INSTANCE.getJdbcTemplate());
        List<Liek> lieky = dao.dajLieky();
        Assert.assertEquals(lieky.size(),1);
    }
    
     @Test
    public void testUpravLiek() {
        System.out.println("Edituj liek");
        
        MysqlLiekDao instance = new MysqlLiekDao(TestFactory.INSTANCE.getJdbcTemplate());
        List<Liek> lieky = instance.dajLieky();
        Liek liek = lieky.get(0);
        liek.setNazov("ibalgin");
        instance.upravLiek(liek);
         Assert.assertEquals(lieky.get(0).getNazov(),"ibalgin");
    }
    
     @Test
    public void testVymazLiek(){
        
        
        MysqlLiekDao instance = new MysqlLiekDao(TestFactory.INSTANCE.getJdbcTemplate());
        
        
        List<Liek> lieky1 = instance.dajLieky();
        Liek liek = lieky1.get(0);
        
        instance.vymazLiek(liek);
         List<Liek> lieky2 = instance.dajLieky();
         Assert.assertEquals(lieky2.size()+1, lieky1.size());
    }
    
       
}
