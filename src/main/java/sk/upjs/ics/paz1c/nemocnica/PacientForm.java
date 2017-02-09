/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.upjs.ics.paz1c.nemocnica;

import java.awt.Dialog;
import javax.swing.JOptionPane;

/**
 *
 * @author szoplakz
 */
public class PacientForm extends javax.swing.JDialog {

    /**
     * Creates new form LekarForm
     */
    private PacientDAO pacientDao = DaoFactory.INSTANCE.getPacientDao();
    
    public PacientForm(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setSize(650, 310);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        PacientTable = new javax.swing.JTable();
        PridajButton = new javax.swing.JButton();
        UpravButton = new javax.swing.JButton();
        VymazDiagnozuButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        PacientTable.setModel(new PacientTableModel());
        jScrollPane1.setViewportView(PacientTable);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 11, 452, 250);

        PridajButton.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        PridajButton.setForeground(new java.awt.Color(0, 102, 0));
        PridajButton.setText("Pridaj");
        PridajButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PridajButtonActionPerformed(evt);
            }
        });
        getContentPane().add(PridajButton);
        PridajButton.setBounds(470, 30, 100, 47);

        UpravButton.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        UpravButton.setForeground(new java.awt.Color(0, 102, 0));
        UpravButton.setText("Uprav");
        UpravButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpravButtonActionPerformed(evt);
            }
        });
        getContentPane().add(UpravButton);
        UpravButton.setBounds(470, 100, 100, 47);

        VymazDiagnozuButton.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        VymazDiagnozuButton.setForeground(new java.awt.Color(0, 102, 0));
        VymazDiagnozuButton.setText("Vymaz");
        VymazDiagnozuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VymazDiagnozuButtonActionPerformed(evt);
            }
        });
        getContentPane().add(VymazDiagnozuButton);
        VymazDiagnozuButton.setBounds(470, 170, 100, 47);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Background.jpg"))); // NOI18N
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 830, 440);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    
    private void PridajButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PridajButtonActionPerformed
       PridajUpravPacientaForm pridatForm = new PridajUpravPacientaForm(this,true,false,null);
        pridatForm.setVisible(true);
    }//GEN-LAST:event_PridajButtonActionPerformed

    private void UpravButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpravButtonActionPerformed
       if(PacientTable.getSelectedRow()==-1){
            JOptionPane.showMessageDialog(null, "Je potrebné najskôr označiť pacienta.");
        } else {
            // vybratie zaznamu v tabulke
            int riadok = PacientTable.getSelectedRow();
            Pacient pacient = ( (PacientTableModel) PacientTable.getModel()).getPacientAt(riadok);
        
        PridajUpravPacientaForm pridatForm = new PridajUpravPacientaForm(this,true,true,pacient);
        pridatForm.setVisible(true); 
        } 
    }//GEN-LAST:event_UpravButtonActionPerformed

    private void VymazDiagnozuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VymazDiagnozuButtonActionPerformed
         if(PacientTable.getSelectedRow()==-1){
            JOptionPane.showMessageDialog(null, "Je potrebné najskôr označiť lekára.");
        } else {
            // vybratie zaznamu v tabulke
            int riadok = PacientTable.getSelectedRow();
            Pacient pacient = ( (PacientTableModel) PacientTable.getModel()).getPacientAt(riadok);

            pacientDao.vymazPacienta(pacient);
            PacientForm pacientForm = new PacientForm((Dialog) this.getParent(),true);
            this.setVisible(false);
            pacientForm.setVisible(true);
        }
    }//GEN-LAST:event_VymazDiagnozuButtonActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable PacientTable;
    private javax.swing.JButton PridajButton;
    private javax.swing.JButton UpravButton;
    private javax.swing.JButton VymazDiagnozuButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
