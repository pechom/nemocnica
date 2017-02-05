package sk.upjs.ics.paz1c.nemocnica;

import sk.upjs.ics.paz1c.nemocnica.Diagnoza;
import java.util.List;

public interface DiagnozaDAO {
    
    List<Diagnoza> dajDiagnozy();
    
    void pridajDiagnozu(Diagnoza diagnoza);
    
    void upravDiagnozu(Diagnoza diagnoza);

    public void ulozDiagnozu(Diagnoza diagnoza);
}
