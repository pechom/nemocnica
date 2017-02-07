/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.upjs.ics.paz1c.nemocnica;

import java.util.List;
import javax.swing.DefaultComboBoxModel;
/**
 *
 * @author szoplakz
 */



public class LekarComboBoxModel extends DefaultComboBoxModel<Lekar> {
    
    
private List<Lekar> lekari;
   
    private LekarDAO lekarDAO = DaoFactory.INSTANCE.getLekarDao();
    
    private void natiahniZDb() {
        lekari = lekarDAO.dajLekarov();
    }
        public LekarComboBoxModel() {
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
    
}
