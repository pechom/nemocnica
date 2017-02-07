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

public class LiekComboBoxModel  extends DefaultComboBoxModel<Liek>{
    
    private List<Liek> lieky;
   
    private LiekDAO liekDAO = DaoFactory.INSTANCE.getLiekDao();
    
    private void natiahniZDb() {
        lieky = liekDAO.dajLieky();
    }
        public LiekComboBoxModel() {
        natiahniZDb();
    }
    @Override
         public int getSize(){
        return lieky.size();
    }
    
    @Override
    public Liek getElementAt(int index) {
        return lieky.get(index);
    }
}
