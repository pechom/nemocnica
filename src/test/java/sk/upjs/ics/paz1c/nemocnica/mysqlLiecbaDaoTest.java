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
    
    @Test
    public void testPridajLiecbu(){
        System.out.println("Pridaj liecbu");
        Liecba liecba = new Liecba();
        MysqlLiecbaDao instance = new MysqlLiecbaDao(TestFactory.INSTANCE.getJdbcTemplate());
        liecba.setId(1);
        liecba.setNazov("masaz");
        List<Liecba> liecby1 = instance.dajLiecby();
        instance.pridajLiecbu(liecba);
         List<Liecba> liecby2 = instance.dajLiecby();
         Assert.assertEquals(liecby2.size(), liecby1.size()+1);
    }
    
    @Test
    public void testDajLiecby(){
        System.out.println("Daj liecbu");
        MysqlLiecbaDao dao = new MysqlLiecbaDao(TestFactory.INSTANCE.getJdbcTemplate());
        List<Liecba> liecby = dao.dajLiecby();
        Assert.assertEquals(liecby.size(),1);
    }
    
     @Test
    public void testUpravLiek() {
        System.out.println("Edituj liecbu");
        
        MysqlLiecbaDao instance = new MysqlLiecbaDao(TestFactory.INSTANCE.getJdbcTemplate());
        List<Liecba> liecby = instance.dajLiecby();
        Liecba liecba = liecby.get(0);
        liecba.setNazov("akupunktura");
        instance.upravLiecbu(liecba);
         Assert.assertEquals(liecby.get(0).getNazov(),"akupunktura");
    }
    
     @Test
    public void testVymazLiek(){
        
        
        MysqlLiecbaDao instance = new MysqlLiecbaDao(TestFactory.INSTANCE.getJdbcTemplate());
        
        
        List<Liecba> liecby1 = instance.dajLiecby();
        Liecba liecba = liecby1.get(0);
        
        instance.vymazLiecbu(liecba);
         List<Liecba> liecby2 = instance.dajLiecby();
         Assert.assertEquals(liecby2.size()+1, liecby1.size());
    }
    
       

}
