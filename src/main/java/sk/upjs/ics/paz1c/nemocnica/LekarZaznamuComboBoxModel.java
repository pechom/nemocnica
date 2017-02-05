package sk.upjs.ics.paz1c.nemocnica;

import java.util.List;
import javax.swing.DefaultComboBoxModel;

public class LekarZaznamuComboBoxModel extends DefaultComboBoxModel<Lekar> {
  
    private List<Lekar> lekari;
    private int predchadzajuciVyber;
    private LekarDAO lekarDao = DaoFactory.INSTANCE.getLekarDao();
    
    // zobrazenie vsetkych lekarov v comboboxe
    private void natiahniZDb(){
        lekari = lekarDao.dajLekarov();
        Lekar novy = new Lekar();
        
    }

    public LekarZaznamuComboBoxModel() {
        natiahniZDb();
    }   
    
    @Override
    public int getSize(){
        return lekari.size();
    }
    
    @Override
    public Lekar getElementAt(int index) {
        return lekari.get(index);
    }
    
    public void setPredchadzajuciVyber(int predchadzajuciVyber){
        this.predchadzajuciVyber=predchadzajuciVyber;
    }
    
    public Lekar getVybratyLekar(){
        return lekari.get(predchadzajuciVyber);
    }

    // ak sa vyberie "<<novy>>" tak nam prida noveho lekara inak ho upravi
    void pridatAleboUpravitLekara(Lekar vybratyLekar) {
        if(predchadzajuciVyber == 0 ){
            lekarDao.pridajLekara(vybratyLekar);
            predchadzajuciVyber = lekari.size() -1;
        } else {
            lekarDao.upravLekara(vybratyLekar);
        }
        natiahniZDb();
        fireContentsChanged(this, 0, lekari.size());
    }

}
