package sk.upjs.ics.paz1c.nemocnica;

import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class MysqlLekarDao implements LekarDAO {

    private JdbcTemplate jdbcTemplate;
    
    public MysqlLekarDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Lekar> dajLekarov() {
        String sql = "SELECT * FROM lekar";
        // rovnake pomenovanie stlpcov v tabulke a jej hodnotami
        BeanPropertyRowMapper<Lekar> rowMapper = new BeanPropertyRowMapper<>(Lekar.class); //lekar parameter
        return jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public void pridajLekara(Lekar lekar) {
       String sql = "INSERT INTO lekar (meno, priezvisko, specializacia) VALUES (?,?,?)";
        jdbcTemplate.update(sql, lekar.getMeno(), lekar.getPriezvisko(), lekar.getSpecializacia());
    }

    @Override
    public void upravLekara(Lekar lekar) {
       String sql = "UPDATE lekar SET meno=?, priezvisko=?, specializacia=? WHERE id=? ";
       jdbcTemplate.update(sql,lekar.getMeno(), lekar.getPriezvisko(), lekar.getSpecializacia(), lekar.getId());
   }

    @Override
    public void ulozLekara(Lekar lekar) {
        if(lekar.getId() == 0) {
            String sqlInsert = "INSERT INTO lekar (meno, priezvisko, specializacia) VALUES (?,?,?)";
            jdbcTemplate.update(sqlInsert, lekar.getMeno(), lekar.getPriezvisko(), lekar.getSpecializacia());
        } else {
           String sql = "UPDATE lekar SET meno=?, priezvisko=?, specializacia=? WHERE id=? ";
           jdbcTemplate.update(sql,lekar.getMeno(), lekar.getPriezvisko(), lekar.getSpecializacia(), lekar.getId()); 
        }
    }
     @Override
    public void vymazLekara(Lekar lekar) {
        String sql = "DELETE FROM lekar WHERE id=? LIMIT 1";
        jdbcTemplate.update(sql, lekar.getId());
    }
}
