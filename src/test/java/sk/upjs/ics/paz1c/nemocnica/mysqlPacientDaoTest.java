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
    
    @Test
    public void testPridajPacienta(){
        System.out.println("Pridaj pacienta");
        Pacient pacient = new Pacient();
        MysqlPacientDao instance = new MysqlPacientDao(TestFactory.INSTANCE.getJdbcTemplate());
        pacient.setId(1);
        pacient.setMeno("Jozef");
        pacient.setPriezvisko("Malý");
        pacient.setVek(2);
        List<Pacient> pacienti1 = instance.dajPacietov();
        instance.pridajPacienta(pacient);
        List<Pacient> pacienti2 = instance.dajPacietov();
        Assert.assertEquals(pacienti1.size()+1, pacienti2.size());
    }
    
    @Test
    public void testDajPacientov(){
        System.out.println("Daj pacientov");
        MysqlPacientDao dao = new MysqlPacientDao(TestFactory.INSTANCE.getJdbcTemplate());
        
        List<Pacient> pacienti = dao.dajPacietov();
        Assert.assertEquals(pacienti.size(),1);
    }

     @Test
    public void testUpravPacienta() {
        System.out.println("Edituj pacienta");
        
        MysqlPacientDao instance = new MysqlPacientDao(TestFactory.INSTANCE.getJdbcTemplate());
        
        List<Pacient> pacienti1 = instance.dajPacietov();
        Pacient pacient = pacienti1.get(0);
       
        pacient.setMeno("Jozko");
      
        instance.upravPacienta(pacient);
        Assert.assertEquals(pacienti1.get(0).getMeno(),"Jozko");
        
    }
    @Test
    public void testVymazPacienta() {
       
        
        MysqlPacientDao instance = new MysqlPacientDao(TestFactory.INSTANCE.getJdbcTemplate());
        
        List<Pacient> pacienti1 = instance.dajPacietov();
        Pacient pacient = pacienti1.get(0);
       
        instance.vymazPacienta(pacient);
        List<Pacient> pacienti2 = instance.dajPacietov();
        Assert.assertEquals(pacienti1.size(), pacienti2.size()+1);        
      
       
        
    }
    
    

}
