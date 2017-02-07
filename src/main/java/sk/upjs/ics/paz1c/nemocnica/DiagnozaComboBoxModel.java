/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.upjs.ics.paz1c.nemocnica;

/**
 *
 * @author szoplakz
 */
import java.util.List;
import javax.swing.DefaultComboBoxModel;

public class DiagnozaComboBoxModel  extends DefaultComboBoxModel<Diagnoza>{
    
    private List<Diagnoza> diagnozy;
   
    private DiagnozaDAO diagnozaDAO = DaoFactory.INSTANCE.getDiagnozaDao();
    
    private void natiahniZDb() {
        diagnozy = diagnozaDAO.dajDiagnozy();
    }
        public DiagnozaComboBoxModel() {
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
    
}
