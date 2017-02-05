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
public class MysqlLiecbaDao implements LiecbaDAO {
    
    private JdbcTemplate jdbcTemplate;

    public MysqlLiecbaDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public MysqlLiecbaDao() {
    }

    @Override
    public List<Liecba> dajLiecby() {
        String sql = "SELECT * FROM liecba";
        BeanPropertyRowMapper<Liecba> rowMapper = new BeanPropertyRowMapper(Liecba.class);
        return jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public void pridajLiecbu(Liecba liecba) {
        String sql = "INSERT INTO liecba (nazov) VALUES (?)";
        jdbcTemplate.update(sql, liecba.getNazov());
    }

    @Override
    public void upravLiecbu(Liecba liecba) {
        String sql = "UPDATE liecba SET nazov=? WHERE id=?";
        jdbcTemplate.update(sql, liecba.getNazov(), liecba.getId());
    }

    @Override
    public void ulozLiecbu(Liecba liecba) {
        if(liecba.getId() == 0) {
            String sqlInsert = "INSERT INTO liecba (nazov) VALUES (?)";
            jdbcTemplate.update(sqlInsert, liecba.getNazov());
        } else {
           String sql = "UPDATE lekar SET nazov=? WHERE id=? ";
           jdbcTemplate.update(sql,liecba.getNazov(),liecba.getId()); 
        }
    }

    public void vymazLiecbu(Liecba liecba) {
        String sql = "DELETE FROM liecba WHERE id=? LIMIT 1";
        jdbcTemplate.update(sql, liecba.getId());
    }
   
    
}