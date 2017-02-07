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
    
    @Test
    public void testPridajLekara(){
        System.out.println("Pridaj lekára");
        Lekar lekar = new Lekar();
        MysqlLekarDao instance = new MysqlLekarDao(TestFactory.INSTANCE.getJdbcTemplate());
        lekar.setId(1);
        lekar.setMeno("Jozef");
        lekar.setPriezvisko("Malý");
        lekar.setSpecializacia("obvodný");
        List<Lekar> lekari1 = instance.dajLekarov();
        instance.pridajLekara(lekar);
        List<Lekar> lekari2 = instance.dajLekarov();
        Assert.assertEquals(lekari1.size()+1, lekari2.size());
    }
    
    @Test
    public void testDajLekarov(){
        System.out.println("Daj lekárov");
        MysqlLekarDao dao = new MysqlLekarDao(TestFactory.INSTANCE.getJdbcTemplate());
        List<Lekar> lekari = dao.dajLekarov();
        Assert.assertEquals(1, lekari.size());
    }
    
     @Test
    public void testUpravLekara() {
        System.out.println("Edituj lekára");
        
        MysqlLekarDao instance = new MysqlLekarDao(TestFactory.INSTANCE.getJdbcTemplate());
        List<Lekar> lekari1 = instance.dajLekarov();
        Lekar lekar = lekari1.get(0);
        lekar.setMeno("Jožko");
        lekar.setPriezvisko("Malý");
        lekar.setSpecializacia("obvodný");
        instance.upravLekara(lekar);
        Assert.assertEquals("Jožko", lekari1.get(0).getMeno());
    }
    @Test
    public void testVymazLekara(){
        MysqlLekarDao instance = new MysqlLekarDao(TestFactory.INSTANCE.getJdbcTemplate());
        
        
        List<Lekar> lekari1 = instance.dajLekarov();
        Lekar lekar = lekari1.get(0);
        instance.vymazLekara(lekar);
        List<Lekar> lekari2 = instance.dajLekarov();
        Assert.assertEquals(lekari1.size(), lekari2.size()+1);
    
    
    }
    
    
}
