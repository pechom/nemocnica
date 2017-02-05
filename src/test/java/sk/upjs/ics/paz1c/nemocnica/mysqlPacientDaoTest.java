package sk.upjs.ics.paz1c.nemocnica;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
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
        MysqlPacientDao instance = new MysqlPacientDao(DaoFactory.INSTANCE.getJdbcTemplate());
        pacient.setId(1);
        pacient.setMeno("Jozef");
        pacient.setPriezvisko("Malý");
        pacient.setVek(2);
        List<Pacient> pacienti = instance.dajPacietov();
        instance.pridajPacienta(pacient);
    }
    
    @Test
    public void testDajPacientov(){
        System.out.println("Daj pacientov");
        MysqlPacientDao dao = new MysqlPacientDao(DaoFactory.INSTANCE.getJdbcTemplate());
        List<Pacient> pacienti = dao.dajPacietov();
    }

     @Test
    public void testUpravPacienta() {
        System.out.println("Edituj pacienta");
        Pacient pacient = new Pacient();
        MysqlPacientDao instance = new MysqlPacientDao(DaoFactory.INSTANCE.getJdbcTemplate());
        pacient.setId(1);
        pacient.setMeno("Jozef");
        pacient.setPriezvisko("Malý");
        pacient.setVek(2);
        instance.upravPacienta(pacient);
    }

}
