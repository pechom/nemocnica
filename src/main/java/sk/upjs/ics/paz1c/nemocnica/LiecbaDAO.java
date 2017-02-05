
package sk.upjs.ics.paz1c.nemocnica;

import java.util.List;

   
   

import sk.upjs.ics.paz1c.nemocnica.Liecba;
import java.util.List;

public interface LiecbaDAO {
    
    List<Liecba> dajLiecby();   
    
    void pridajLiecbu(Liecba liecba);
      
    void upravLiecbu(Liecba liecba);
    
    public void ulozLiecbu(Liecba liecba);
}

