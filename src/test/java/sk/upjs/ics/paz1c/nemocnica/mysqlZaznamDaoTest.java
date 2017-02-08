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
import org.springframework.jdbc.core.JdbcTemplate;

public class mysqlZaznamDaoTest {

    private String setup;
    private String after;
    private JdbcTemplate jdbcTemplate;
    private Diagnoza diagnoza;
    private List<Diagnoza> diagnozy;
    private MysqlDiagnozaDao diagnozaDao;
    private Lekar lekar;
    private List<Lekar> lekari;
    private MysqlLekarDao lekarDao;
    private Liecba liecba;
    private List<Liecba> liecby;
    private MysqlLiecbaDao liecbaDao;
    private Liek liek;
    private List<Liek> lieky;
    private MysqlLiekDao LiekDao;
    private Pacient pacient;
    private List<Pacient> pacienti;
    private MysqlPacientDao pacientDao;
    private Pouzivatel pouzivatel;
    private List<Pouzivatel> pouzivatelia;
    private MysqlPouzivatelDao pouzivatelDao;
    private List<Zaznam> zaznamy;
    private MysqlZaznamDao zaznamDao;
    private Zaznam zaznam;

    public mysqlZaznamDaoTest() {
    }

    @Before
    public void setUp() {
        jdbcTemplate = TestFactory.INSTANCE.getJdbcTemplate();
        setup = "insert into pouzivatel (login, password) values (\"peter\", \"yareyare\");";
        jdbcTemplate.update(setup);
        diagnoza = new Diagnoza();
        diagnoza.setNazov("horúčka");
        diagnozaDao = new MysqlDiagnozaDao(TestFactory.INSTANCE.getJdbcTemplate());
        diagnozaDao.pridajDiagnozu(diagnoza);
        diagnozy = diagnozaDao.dajDiagnozy();
        lekar = new Lekar();
        lekar.setMeno("Jozef");
        lekar.setPriezvisko("Malý");
        lekar.setSpecializacia("obvodný");
        lekarDao = new MysqlLekarDao(TestFactory.INSTANCE.getJdbcTemplate());
        lekarDao.pridajLekara(lekar);
        lekari = lekarDao.dajLekarov();
        liecba = new Liecba();
        liecbaDao = new MysqlLiecbaDao(TestFactory.INSTANCE.getJdbcTemplate());
        liecba.setNazov("masaz");
        liecbaDao.pridajLiecbu(liecba);
        liecby = liecbaDao.dajLiecby();
        liek = new Liek();
        LiekDao = new MysqlLiekDao(TestFactory.INSTANCE.getJdbcTemplate());
        liek.setNazov("paralen");
        LiekDao.pridajLiek(liek);
        lieky = LiekDao.dajLieky();
        pacient = new Pacient();
        pacient.setMeno("Jozef");
        pacient.setPriezvisko("Malý");
        pacient.setVek(2);
        pacientDao = new MysqlPacientDao(TestFactory.INSTANCE.getJdbcTemplate());
        pacientDao.pridajPacienta(pacient);
        pacienti = pacientDao.dajPacietov();
        pouzivatelDao = new MysqlPouzivatelDao(TestFactory.INSTANCE.getJdbcTemplate());
        pouzivatelia = pouzivatelDao.dajPouzivatelov();
        pouzivatel = pouzivatelia.get(0);
        zaznam = new Zaznam();
        zaznamDao = new MysqlZaznamDao(TestFactory.INSTANCE.getJdbcTemplate());
        zaznam.setDiagnoza(diagnozy.get(0));
        zaznam.setLekar(lekari.get(0));
        zaznam.setLiecba(liecby.get(0));
        zaznam.setLiek(lieky.get(0));
        zaznam.setPacient(pacienti.get(0));
        zaznam.setPouzivatel(pouzivatelia.get(0));
    }

    @Test
    public void testPridajZaznam() {
        zaznamDao.pridajZaznam(zaznam);
        zaznamy = zaznamDao.dajZaznamy();
        assertEquals(zaznamy.size(), 1);
        zaznamDao.vymazZaznam(zaznamy.get(0));
    }

    @Test
    public void testDajZaznamy() {
        System.out.println("Daj zaznamy");
        zaznamDao.pridajZaznam(zaznam);
        zaznamy = zaznamDao.dajZaznamy();
        assertEquals(zaznamy.size(), 1);
        zaznamDao.vymazZaznam(zaznamy.get(0));
    }


    @Test
    public void vymazZaznam() {
        zaznamDao.pridajZaznam(zaznam);
        zaznamy = zaznamDao.dajZaznamy();
        zaznamDao.vymazZaznam(zaznamy.get(0));
        zaznamy = zaznamDao.dajZaznamy();
        assertEquals(zaznamy.size(), 0);
    }


    @After
    public void TearUp() {
        diagnozaDao.vymazDiagnozu(diagnozy.get(0));
        lekarDao.vymazLekara(lekari.get(0));
        liecbaDao.vymazLiecbu(liecby.get(0));
        LiekDao.vymazLiek(lieky.get(0));
        pacientDao.vymazPacienta(pacienti.get(0));
        after = "delete from pouzivatel where id=?;";
        jdbcTemplate.update(after, pouzivatelia.get(0).getId());
    }

}
