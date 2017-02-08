/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.upjs.ics.paz1c.nemocnica;

import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;


public class MysqlPouzivatelDao implements PouzivatelDAO {
    
    private JdbcTemplate jdbcTemplate;

    public MysqlPouzivatelDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
   
    @Override
    public List<Pouzivatel> dajPouzivatelov() {
       String sql = "SELECT * FROM pouzivatel";
        BeanPropertyRowMapper<Pouzivatel> rowMapper = new BeanPropertyRowMapper<>(Pouzivatel.class);
        return jdbcTemplate.query(sql, rowMapper);
    }
    
    @Override
    public void upravPouzivatela(Pouzivatel pouzivatel) {
        String sql = "UPDATE pouzivatel SET login=? WHERE id=?";
        jdbcTemplate.update(sql, pouzivatel.getLogin(), pouzivatel.getId());
    }
    
     @Override
    public void zmenHeslo(Pouzivatel pouzivatel) {
        String sql    = "UPDATE pouzivatel SET "
            + "password=? "
            + "WHERE id=?";
    
     jdbcTemplate.update(sql, pouzivatel.getPassword(), pouzivatel.getId());
    }
    
     @Override
    public Boolean checkMenoAHeslo(String meno, String heslo) {
        Pouzivatel zadany = null;
        for (Pouzivatel pouzivatel : dajPouzivatelov()) {
            System.out.println(pouzivatel.getLogin());
            System.out.println(pouzivatel.getPassword());
            if ((pouzivatel.getLogin() != null) && (pouzivatel.getLogin().equals(meno))) {
                zadany = pouzivatel;
                break;
            }
        }
        
        if (zadany == null) {
            return false;
        } else {
            if (zadany.getPassword().equals(heslo)){
            return true;
            } else {
           return false;
        }
        }
    }
    
     @Override
     public Pouzivatel najdiPouzivatela(String meno){
     Pouzivatel hladany = null;
     for (Pouzivatel pouzivatel : dajPouzivatelov()) {
     if  (pouzivatel.getLogin().equals(meno)) {
         hladany = pouzivatel;
     }
     }
     return hladany;
     }
      
}
