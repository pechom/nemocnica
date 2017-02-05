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
        String sql = "UPDATE pouzivatel SET meno=? WHERE id=?";
        jdbcTemplate.update(sql, pouzivatel.getMeno(), pouzivatel.getId());
    }

    @Override
    public void zmenHeslo(Pouzivatel pouzivatel) {
        String sql = "UPDATE pouzivatel SET "
                + "heslo=? "
                + "WHERE id=?";

        jdbcTemplate.update(sql, pouzivatel.getHeslo(), pouzivatel.getId());
    }

    @Override
    public Boolean checkMenoAHeslo(String meno, String heslo) {
        Pouzivatel zadany = null;
        for (Pouzivatel pouzivatel : dajPouzivatelov()) {
           System.out.println(pouzivatel.getMeno());
            if ((pouzivatel.getMeno() != null) && (pouzivatel.getMeno().equals(meno))) {
                zadany = pouzivatel;
                break;
            }
        }
        if (zadany == null) {
            return false;
        }
        return zadany.getHeslo().equals(heslo);
    }
}
