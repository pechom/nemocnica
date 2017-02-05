package sk.upjs.ics.paz1c.nemocnica;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
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
        MysqlLekarDao instance = new MysqlLekarDao(DaoFactory.INSTANCE.getJdbcTemplate());
        lekar.setId(1);
        lekar.setMeno("Jozef");
        lekar.setPriezvisko("Malý");
        lekar.setSpecializacia("obvodný");
        List<Lekar> lekari = instance.dajLekarov();
        instance.pridajLekara(lekar);
    }
    
    @Test
    public void testDajLekarov(){
        System.out.println("Daj lekárov");
        MysqlLekarDao dao = new MysqlLekarDao(DaoFactory.INSTANCE.getJdbcTemplate());
        List<Lekar> liekylekari = dao.dajLekarov();
    }
    
     @Test
    public void testUpravLekara() {
        System.out.println("Edituj lekára");
        Lekar lekar = new Lekar();
        MysqlLekarDao instance = new MysqlLekarDao(DaoFactory.INSTANCE.getJdbcTemplate());
        lekar.setId(1);
        lekar.setMeno("Jožko");
        lekar.setPriezvisko("Malý");
        lekar.setSpecializacia("obvodný");
        instance.upravLekara(lekar);
    }
}
