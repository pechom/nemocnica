package sk.upjs.ics.paz1c.nemocnica;

import java.util.List;
import javax.swing.AbstractListModel;

public class LiekListModel extends AbstractListModel<Liek>{
    
    private LiekDAO dao;
    private List<Liek> lieky;
    
    public LiekListModel() {
        dao = DaoFactory.INSTANCE.getLiekDao();
        lieky = dao.dajLieky();
    }

    @Override
    public int getSize() {
        return dao.dajLieky().size();
    }

    @Override
    public Liek getElementAt(int index) {
        return dao.dajLieky().get(index);
    }
    
    // metoda na pridavanie záznamu na koniec zoznamu
    public void pridajLiek(Liek liek){
        int pozicia = dao.dajLieky().size();
        dao.pridajLiek(liek);
        lieky = dao.dajLieky();
        fireIntervalAdded(this, pozicia, pozicia);
    }
    
    // obnovenie zaznamov ak sa niečo v zozname zmeni
    public void refresh() {
        lieky = dao.dajLieky();
        fireContentsChanged(this, 0, getSize());
    }
    
}
