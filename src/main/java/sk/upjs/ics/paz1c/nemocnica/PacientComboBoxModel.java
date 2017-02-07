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


public class PacientComboBoxModel extends DefaultComboBoxModel<Pacient>{
    
    private List<Pacient> pacienti;
   
    private PacientDAO pacientDAO = DaoFactory.INSTANCE.getPacientDao();
    
    private void natiahniZDb() {
        pacienti = pacientDAO.dajPacietov();
    }
        public PacientComboBoxModel() {
        natiahniZDb();
    }
    @Override
         public int getSize(){
        return pacienti.size();
    }
    
    @Override
    public Pacient getElementAt(int index) {
        return pacienti.get(index);
    }
}
