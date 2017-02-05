package sk.upjs.ics.paz1c.nemocnica;

import sk.upjs.ics.paz1c.nemocnica.Lekar;
import java.util.List;

public interface LekarDAO {
    
    List<Lekar> dajLekarov();
    
    void pridajLekara(Lekar lekar);
    
    void upravLekara(Lekar lekar);
    
    public void ulozLekara(Lekar lekar);
    
}
