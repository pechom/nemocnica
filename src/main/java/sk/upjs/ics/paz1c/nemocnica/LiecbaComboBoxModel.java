/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.upjs.ics.paz1c.nemocnica;

import java.util.List;
import javax.swing.DefaultComboBoxModel;

public class LiecbaComboBoxModel  extends DefaultComboBoxModel<Liecba>{
    
    private List<Liecba> liecby;
   
    private LiecbaDAO liecbaDAO = DaoFactory.INSTANCE.getLiecbaDao();
    
    private void natiahniZDb() {
        liecby = liecbaDAO.dajLiecby();
    }
        public LiecbaComboBoxModel() {
        natiahniZDb();
    }
    @Override
         public int getSize(){
        return liecby.size();
    }
    
    @Override
    public Liecba getElementAt(int index) {
        return liecby.get(index);
    }
    
}
