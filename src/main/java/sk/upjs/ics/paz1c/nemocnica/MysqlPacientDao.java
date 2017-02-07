package sk.upjs.ics.paz1c.nemocnica;

import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;


public class MysqlPacientDao implements PacientDAO {
    
    private JdbcTemplate jdbcTemplate;

    public MysqlPacientDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Pacient> dajPacietov() {
       String sql = "SELECT * FROM pacient";
        BeanPropertyRowMapper<Pacient> rowMapper = new BeanPropertyRowMapper<>(Pacient.class);
        return jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public void pridajPacienta(Pacient pacient) {
        String sql = "INSERT INTO pacient (meno, priezvisko, vek) VALUES (?,?,?)";
        jdbcTemplate.update(sql, pacient.getMeno(), pacient.getPriezvisko(), pacient.getVek());
    }

    @Override
    public void upravPacienta(Pacient pacient) {
        String sql = "UPDATE pacient SET meno=?, priezvisko=?, vek=? WHERE id=? ";
        jdbcTemplate.update(sql, pacient.getMeno(), pacient.getPriezvisko(), pacient.getVek(), pacient.getId());
    }

    @Override
    public void ulozPacienta(Pacient pacient) {
        if(pacient.getId() == 0) {
            String sqlInsert = "INSERT INTO pacient (meno, priezvisko, vek) VALUES (?,?,?)";
            jdbcTemplate.update(sqlInsert, pacient.getMeno(), pacient.getPriezvisko(), pacient.getVek());
        } else {
           String sql = "UPDATE pacient SET meno=?, priezvisko=?, vek=? WHERE id=? ";
           jdbcTemplate.update(sql,pacient.getMeno(), pacient.getPriezvisko(), pacient.getVek(), pacient.getId()); 
        }
    }
     @Override
     public void vymazPacienta(Pacient pacient) {
        String sql = "DELETE FROM pacient WHERE id=? LIMIT 1";
        jdbcTemplate.update(sql, pacient.getId());
    }
    
}
