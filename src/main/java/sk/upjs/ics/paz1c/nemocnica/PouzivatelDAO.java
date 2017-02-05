
package sk.upjs.ics.paz1c.nemocnica;

import java.util.List;

public interface PouzivatelDAO {
    
    List<Pouzivatel> dajPouzivatelov();
    
    void upravPouzivatela(Pouzivatel pouzivatel);
    
    void zmenHeslo(Pouzivatel pouzivatel);
    
    Boolean checkMenoAHeslo(String meno, String heslo);
    }

