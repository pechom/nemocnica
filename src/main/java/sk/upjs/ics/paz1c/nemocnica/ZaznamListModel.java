package sk.upjs.ics.paz1c.nemocnica;

import java.util.List;
import javax.swing.AbstractListModel;

public class ZaznamListModel extends AbstractListModel<Zaznam>{
    
    private ZaznamDAO dao;
    private List<Zaznam> zaznamy;
    
    public ZaznamListModel() {
        dao = DaoFactory.INSTANCE.getZaznamDao();
        zaznamy = dao.dajZaznamy();
    }

    @Override
    public int getSize() {
        return dao.dajZaznamy().size();
    }

    @Override
    public Zaznam getElementAt(int index) {
        return dao.dajZaznamy().get(index);
    }
    
    // metoda na pridavanie záznamu na koniec zoznamu
    public void pridajZaznam(Zaznam zaznam){
        int pozicia = dao.dajZaznamy().size();
        dao.pridajZaznam(zaznam);
        zaznamy = dao.dajZaznamy();
        fireIntervalAdded(this, pozicia, pozicia);
    }
    
    // obnovenie zaznamov ak sa niečo v zozname zmeni
    public void refresh() {
        zaznamy = dao.dajZaznamy();
        fireContentsChanged(this, 0, getSize());
    }
    
}
