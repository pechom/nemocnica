/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.upjs.ics.paz1c.nemocnica;

import com.mysql.cj.jdbc.MysqlDataSource;
import java.io.File;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Judita
 */
public enum TestFactory {
    
    
    INSTANCE;
    
    private ZaznamDAO mysqlZaznamDao;
    private LekarDAO lekarDao;
    private PacientDAO pacientDao;
    private LiekDAO liekDao;
    private DiagnozaDAO diagnozaDao;
    private LiecbaDAO liecbaDao;
    private PouzivatelDAO pouzivatelDao;
    public ZaznamDAO getZaznamDao(){
        return getMysqlZaznamDao();
    }

    private ZaznamDAO getMysqlZaznamDao() {
        if(mysqlZaznamDao == null){
            mysqlZaznamDao = new MysqlZaznamDao(getJdbcTemplate());
        }
        return mysqlZaznamDao;
    }
    
    // prepojenie k databáze
    public JdbcTemplate getJdbcTemplate(){
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setDatabaseName("nemocnica-test");
        dataSource.setURL("jdbc:mysql://localhost/databaza-knih?serverTimezone=Europe/Bratislava");
        dataSource.setUser("root");
        dataSource.setPassword("yareyare");
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        return jdbcTemplate;
    }
    
    public LekarDAO getLekarDao(){
        if(lekarDao == null){
            lekarDao = new MysqlLekarDao(getJdbcTemplate());
        }
        return lekarDao;
    }
    
    public PacientDAO getPacientDao(){
        if(pacientDao == null){
            pacientDao = new MysqlPacientDao(getJdbcTemplate());
        }
        return pacientDao;
    }
      
    public DiagnozaDAO getDiagnozaDao(){
        if(diagnozaDao == null){
            diagnozaDao = new MysqlDiagnozaDao(getJdbcTemplate());
        }
        return diagnozaDao;
    }
        
    public LiekDAO getLiekDao(){
        if(liekDao == null){
            liekDao = new MysqlLiekDao(getJdbcTemplate());
        }
        return liekDao;
    }
    public LiecbaDAO getLiecbaDao(){
        if(liecbaDao == null){
            liecbaDao = new MysqlLiecbaDao(getJdbcTemplate());
        }
        return liecbaDao;
    }
    
     public PouzivatelDAO getPouzivatelDao(){
        if(pouzivatelDao == null){
            pouzivatelDao = new MysqlPouzivatelDao(getJdbcTemplate());
        }
        return pouzivatelDao;
    }

   
}

