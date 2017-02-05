
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
        MysqlLiekDao instance = new MysqlLiekDao(DaoFactory.INSTANCE.getJdbcTemplate());
        liek.setId(1);
        liek.setNazov("paralen");
        List<Liek> lieky = instance.dajLieky();
        instance.pridajLiek(liek);
    }
    
    @Test
    public void testDajLieky(){
        System.out.println("Daj liek");
        MysqlLiekDao dao = new MysqlLiekDao(DaoFactory.INSTANCE.getJdbcTemplate());
        List<Liek> lieky = dao.dajLieky();
    }
    
     @Test
    public void testUpravLiek() {
        System.out.println("Edituj liek");
        Liek liek = new Liek();
        MysqlLiekDao instance = new MysqlLiekDao(DaoFactory.INSTANCE.getJdbcTemplate());
        liek.setId(1);
        liek.setNazov("ibalgin");
        instance.upravLiek(liek);
    }
       
}
