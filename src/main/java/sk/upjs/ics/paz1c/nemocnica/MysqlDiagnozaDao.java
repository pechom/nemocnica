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
public class MysqlDiagnozaDao implements DiagnozaDAO {

    private JdbcTemplate jdbcTemplate;
    
    public MysqlDiagnozaDao(){
    }
    
    public MysqlDiagnozaDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<Diagnoza> dajDiagnozy() {
        String sql = "SELECT * FROM diagnoza";
        // rovnake pomenovanie stlpcov v tabulke a jej hodnotami
        BeanPropertyRowMapper<Diagnoza> rowMapper = new BeanPropertyRowMapper<>(Diagnoza.class);
        return jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public void pridajDiagnozu(Diagnoza diagnoza) {
        String sql = "INSERT INTO diagnoza (nazov) VALUES (?)";
        jdbcTemplate.update(sql, diagnoza.getNazov());
    }

    @Override
    public void upravDiagnozu(Diagnoza diagnoza) {
        String sql = "UPDATE diagnoza SET nazov=? WHERE id=? ";
        jdbcTemplate.update(sql, diagnoza.getNazov(), diagnoza.getId());
    }

    @Override
    public void ulozDiagnozu(Diagnoza diagnoza) {
        if(diagnoza.getId() == 0) {
            String sqlInsert = "INSERT INTO diagnoza (nazov) VALUES (?)";
            jdbcTemplate.update(sqlInsert, diagnoza.getNazov());
        } else {
            String sql = "UPDATE diagnoza SET nazov=? WHERE id=? ";
            jdbcTemplate.update(sql, diagnoza.getNazov(), diagnoza.getId());
        }
    }
    
   public void vymazDiagnozu(Diagnoza diagnoza) {
        String sql = "DELETE FROM diagnoza WHERE id=? LIMIT 1";
        jdbcTemplate.update(sql, diagnoza.getId());
    }
    
}
