package sk.upjs.ics.paz1c.nemocnica;

import sk.upjs.ics.paz1c.nemocnica.Pacient;
import java.util.List;

public interface PacientDAO {
 
    List<Pacient> dajPacietov();
    
    void pridajPacienta(Pacient pacient);
   
    void upravPacienta(Pacient pacient);
    
    public void ulozPacienta(Pacient pacient);
    
}
