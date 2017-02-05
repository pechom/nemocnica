package sk.upjs.ics.paz1c.nemocnica;

import java.util.List;
import javax.swing.AbstractListModel;

public class LiecbaListModel extends AbstractListModel<Liecba>{
    
    private LiecbaDAO dao;
    private List<Liecba> liecby;
    
    public LiecbaListModel() {
        dao = DaoFactory.INSTANCE.getLiecbaDao();
        liecby = dao.dajLiecby();
    }

    @Override
    public int getSize() {
        return dao.dajLiecby().size();
    }

    @Override
    public Liecba getElementAt(int index) {
        return dao.dajLiecby().get(index);
    }
    
    // metoda na pridavanie záznamu na koniec zoznamu
    public void pridajLiek(Liecba liecba){
        int pozicia = dao.dajLiecby().size();
        dao.pridajLiecbu(liecba);
        liecby = dao.dajLiecby();
        fireIntervalAdded(this, pozicia, pozicia);
    }
    
    // obnovenie zaznamov ak sa niečo v zozname zmeni
    public void refresh() {
        liecby = dao.dajLiecby();
        fireContentsChanged(this, 0, getSize());
    }
    
}
