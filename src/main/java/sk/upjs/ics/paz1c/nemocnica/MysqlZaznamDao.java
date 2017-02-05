package sk.upjs.ics.paz1c.nemocnica;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

public class MysqlZaznamDao implements ZaznamDAO {
    
    private JdbcTemplate jdbcTmplate;

    public MysqlZaznamDao() {
    }
    
    MysqlZaznamDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTmplate = jdbcTemplate;
    }

    @Override
    public List<Zaznam> dajZaznamy() {
        String sql = "SELECT lekar_id,pacient_id,diagnoza_id,liek_id,liecba_id,liecba_id,pouzivatel_id FROM zaznam";
        return jdbcTmplate.query(sql, new ZaznamResultSetExtractor());       
    }


    @Override
    public void pridajZaznam(Zaznam zaznam) { 
        
        
        String sql = "INSERT INTO zaznam (lekar_id, pacient_id, diagnoza_id, liek_id, liecba_id, pouzivatel_id) VALUES (?,?,?,?,?,?)";
        jdbcTmplate.update(sql,zaznam.getLekar().getId(),
                zaznam.getPacient().getId(), 
                zaznam.getDiagnoza().getId(),
                zaznam.getLiek().getId(),
                 zaznam.getLiecba().getId(),
                 zaznam.getPouzivatel().getId());
    }

    @Override
    public void upravZaznam(Zaznam zaznam) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void vymazZaznam(Zaznam zaznam) {
        String sql = "DELETE FROM zaznam WHERE lekar_id=? AND pacient_id=? AND diagnoza_id=? AND liek_id=? AND liecba_id=? AND pouzivatel_id=? LIMIT 1";
        jdbcTmplate.update(sql, zaznam.getLekar().getId(), zaznam.getPacient().getId(), 
                                zaznam.getDiagnoza().getId(), zaznam.getLiek().getId(), zaznam.getLiecba().getId(),zaznam.getPouzivatel().getId());
    }


    private static class ZaznamResultSetExtractor implements ResultSetExtractor<List<Zaznam>> {

        @Override
        public List<Zaznam> extractData(ResultSet rs) throws SQLException, DataAccessException {
            List<Zaznam> zaznamy = new ArrayList<>();
            
            List<Lekar> lekari = DaoFactory.INSTANCE.getLekarDao().dajLekarov();
            Map<Integer,Lekar> lekariMap = new HashMap<>();
            for(Lekar lekar : lekari) {
                lekariMap.put(lekar.getId(), lekar);
            } 
            
            List<Pacient> pacienti = DaoFactory.INSTANCE.getPacientDao().dajPacietov();
            Map<Integer,Pacient> pacientiMap = new HashMap<>();
            for(Pacient pacient: pacienti){
                pacientiMap.put(pacient.getId(), pacient);
            }
            
            List<Diagnoza> diagnozy = DaoFactory.INSTANCE.getDiagnozaDao().dajDiagnozy();
            Map<Integer,Diagnoza> diagnozyMap = new HashMap<>();
            for(Diagnoza diagnoza: diagnozy){
                diagnozyMap.put(diagnoza.getId(), diagnoza);
            }
            
            List<Liek> lieky = DaoFactory.INSTANCE.getLiekDao().dajLieky();
            Map<Integer,Liek> liekyMap = new HashMap<>();
            for(Liek liek: lieky){
                liekyMap.put(liek.getId(), liek);
            }
            
             List<Liecba> liecby = DaoFactory.INSTANCE.getLiecbaDao().dajLiecby();
            Map<Integer,Liecba> liecbyMap = new HashMap<>();
            for(Liecba liecba: liecby){
                liecbyMap.put(liecba.getId(), liecba);
            }
            
              List<Pouzivatel> pouzivatelia = DaoFactory.INSTANCE.getPouzivatelDao().dajPouzivatelov();
            Map<Integer,Pouzivatel> pouzivateliaMap = new HashMap<>();
            for(Pouzivatel pouzivatel: pouzivatelia){
                pouzivateliaMap.put(pouzivatel.getId(), pouzivatel);
            }
            
            
            
          
            // nastavenie ideciek pre zaznam
            while(rs.next()) {
                Zaznam zaznam = new Zaznam();
                int lekarId = rs.getInt("lekar_id");
                int pacientId = rs.getInt("pacient_id");
                int diagnozaId = rs.getInt("diagnoza_id");
                int liekId = rs.getInt("liek_id");
                int liecbaId = rs.getInt("liecba_id");
                int pouzivatelId = rs.getInt("pouzivatel_id");
                zaznam.setLekar(lekariMap.get(lekarId));         
                zaznam.setPacient(pacientiMap.get(pacientId));
                zaznam.setDiagnoza(diagnozyMap.get(diagnozaId));
                zaznam.setLiek(liekyMap.get(liekId));
                zaznam.setLiecba(liecbyMap.get(liecbaId));
                zaznam.setPouzivatel(pouzivateliaMap.get(pouzivatelId));
                zaznamy.add(zaznam);
            }
            return zaznamy;
        }
    }
}
