package sk.upjs.ics.paz1c.nemocnica;

import sk.upjs.ics.paz1c.nemocnica.Liek;
import java.util.List;

public interface LiekDAO {
    
    List<Liek> dajLieky();   
    
    void pridajLiek(Liek liek);
      
    void upravLiek(Liek liek);
    
    public void ulozLiek(Liek liek);
}
