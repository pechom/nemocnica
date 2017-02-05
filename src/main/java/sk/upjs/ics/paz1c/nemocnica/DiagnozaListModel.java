package sk.upjs.ics.paz1c.nemocnica;

import java.util.List;
import javax.swing.AbstractListModel;

public class DiagnozaListModel extends AbstractListModel<Diagnoza>{
    
    private DiagnozaDAO dao;
    private List<Diagnoza> diagnozy;
    
    public DiagnozaListModel() {
        dao = DaoFactory.INSTANCE.getDiagnozaDao();
        diagnozy = dao.dajDiagnozy();
    }

    

    @Override
    public int getSize() {
        return dao.dajDiagnozy().size();
    }

    @Override
    public Diagnoza getElementAt(int index) {
        return dao.dajDiagnozy().get(index);
    }
    
    // metoda na pridavanie záznamu na koniec zoznamu
    public void pridajLiek(Diagnoza diagnoza){
        int pozicia = dao.dajDiagnozy().size();
        dao.pridajDiagnozu(diagnoza);
        diagnozy = dao.dajDiagnozy();
        fireIntervalAdded(this, pozicia, pozicia);
    }
    
    // obnovenie zaznamov ak sa niečo v zozname zmeni
    public void refresh() {
        diagnozy = dao.dajDiagnozy();
        fireContentsChanged(this, 0, getSize());
    }
    
}
