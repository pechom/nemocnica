package sk.upjs.ics.paz1c.nemocnica;

import sk.upjs.ics.paz1c.nemocnica.Zaznam;
import java.util.List;

public interface ZaznamDAO {

    List<Zaznam> dajZaznamy();
          
    void pridajZaznam(Zaznam zaznam);
    
    void upravZaznam(Zaznam zaznam);
    
    void vymazZaznam(Zaznam zaznam);
    
    
}
