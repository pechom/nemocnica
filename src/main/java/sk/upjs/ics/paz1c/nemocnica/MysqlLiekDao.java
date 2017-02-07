/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.upjs.ics.paz1c.nemocnica;

import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Judita
 */
public class MysqlLiekDao implements LiekDAO {
    
    private JdbcTemplate jdbcTemplate;

    public MysqlLiekDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public MysqlLiekDao() {
    }

    @Override
    public List<Liek> dajLieky() {
        String sql = "SELECT * FROM liek";
        BeanPropertyRowMapper<Liek> rowMapper = new BeanPropertyRowMapper(Liek.class);
        return jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public void pridajLiek(Liek liek) {
        String sql = "INSERT INTO liek (nazov) VALUES (?)";
        jdbcTemplate.update(sql, liek.getNazov());
    }

    @Override
    public void upravLiek(Liek liek) {
        String sql = "UPDATE liek SET nazov=? WHERE id=?";
        jdbcTemplate.update(sql, liek.getNazov(), liek.getId());
    }

    @Override
    public void ulozLiek(Liek liek) {
        if(liek.getId() == 0) {
            String sqlInsert = "INSERT INTO liek (nazov) VALUES (?)";
            jdbcTemplate.update(sqlInsert, liek.getNazov());
        } else {
           String sql = "UPDATE lekar SET nazov=? WHERE id=? ";
           jdbcTemplate.update(sql,liek.getNazov(),liek.getId()); 
        }
    }
      @Override
     public void vymazLiek(Liek liek) {
        String sql = "DELETE FROM liek WHERE id=? LIMIT 1";
        jdbcTemplate.update(sql, liek.getId());
    }
     
      
}
