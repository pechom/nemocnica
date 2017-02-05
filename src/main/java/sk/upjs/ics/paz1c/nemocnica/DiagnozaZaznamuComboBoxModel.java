
package sk.upjs.ics.paz1c.nemocnica;

import java.util.List;
import javax.swing.DefaultComboBoxModel;

public class DiagnozaZaznamuComboBoxModel extends DefaultComboBoxModel<Diagnoza> {
  
    private List<Diagnoza> diagnozy;
    private int predchadzajuciVyber;
    private DiagnozaDAO diagnozaDAO = DaoFactory.INSTANCE.getDiagnozaDao();

    // zobrazenie vsetkych diagnoz v comboboxe
    private void natiahniZDb() {
        diagnozy = diagnozaDAO.dajDiagnozy();
        Diagnoza prazdna = new Diagnoza();
        prazdna.setNazov("<<nová diagnoza>>");
        diagnozy.add(0,prazdna);
    }
    
    public DiagnozaZaznamuComboBoxModel() {
        natiahniZDb();
    }   
    
    @Override
    public int getSize(){
        return diagnozy.size();
    }
    
    @Override
    public Diagnoza getElementAt(int index) {
        return diagnozy.get(index);
    }
    
    public void setPredchadzajuciVyber(int predchadzajuciVyber){
        this.predchadzajuciVyber=predchadzajuciVyber;
    }

    public Diagnoza getVybrataDiagnoza() {
        return diagnozy.get(predchadzajuciVyber);
    }
    
    // ak sa vyberie "<<nova>>" tak nam prida novu diagnozu inak ju upravi
    void pridatAleboUpravitDiagnozu(Diagnoza vybrataDiagnoza) {
        if(predchadzajuciVyber == 0 ) {
            diagnozaDAO.pridajDiagnozu(vybrataDiagnoza);
            predchadzajuciVyber = diagnozy.size() -1;
        } else {
            diagnozaDAO.ulozDiagnozu(vybrataDiagnoza);
        }
        natiahniZDb();
        fireContentsChanged(this, 0, diagnozy.size());
    }

} 

