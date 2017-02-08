/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.upjs.ics.paz1c.nemocnica;

import java.awt.Dialog;

/**
 *
 * @author szoplakz
 */
public class PridajUpravDatabazuForm extends javax.swing.JDialog {

    /**
     * Creates new form PridajUpravDatabazuForm
     */
    
    private Diagnoza diagnoza;
    private Liek liek;
    private Liecba liecba;
    private String vec;
    private Boolean uprav;
    DiagnozaDAO diagnozaDao = DaoFactory.INSTANCE.getDiagnozaDao();
    LiekDAO liekDao = DaoFactory.INSTANCE.getLiekDao();
    LiecbaDAO liecbaDao = DaoFactory.INSTANCE.getLiecbaDao();
    
    public PridajUpravDatabazuForm(java.awt.Dialog parent, boolean modal, boolean uprav, String vec, Diagnoza diagnoza, Liek liek, Liecba liecba) {
        super(parent, modal);
        initComponents();
        this.setSize(500, 120);
        this.diagnoza=diagnoza;
        this.vec=vec;
        this.liek=liek;
        this.liecba=liecba;
        this.uprav=uprav;
        if(uprav){
        if (vec.equals("diagnoza")){
        NázovTextfield.setText(diagnoza.getNazov());
        }
        if (vec.equals("liek")){
        NázovTextfield.setText(liek.getNazov());
        }
        if (vec.equals("liecba")){
        NázovTextfield.setText(liecba.getNazov());
        }
        PridajUpravButton.setText("Uprav");
        } else {
        PridajUpravButton.setText("Pridaj");
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        NázovLabel = new javax.swing.JLabel();
        NázovTextfield = new javax.swing.JTextField();
        PridajUpravButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        NázovLabel.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        NázovLabel.setForeground(new java.awt.Color(0, 102, 0));
        NázovLabel.setText("Názov:");
        getContentPane().add(NázovLabel);
        NázovLabel.setBounds(10, 19, 76, 28);
        getContentPane().add(NázovTextfield);
        NázovTextfield.setBounds(90, 17, 353, 36);

        PridajUpravButton.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        PridajUpravButton.setForeground(new java.awt.Color(0, 102, 0));
        PridajUpravButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PridajUpravButtonActionPerformed(evt);
            }
        });
        getContentPane().add(PridajUpravButton);
        PridajUpravButton.setBounds(168, 64, 100, 43);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Background.jpg"))); // NOI18N
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 500, 120);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PridajUpravButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PridajUpravButtonActionPerformed
       if(uprav){
        if (vec.equals("diagnoza")){
        diagnoza.setNazov(NázovTextfield.getText());
        diagnozaDao.upravDiagnozu(diagnoza);
        DatabazaForm databazaForm = new DatabazaForm((Dialog) this.getParent().getParent(), true);
        this.setVisible(false);
        databazaForm.setVisible(true);
        }
        if (vec.equals("liek")){
        liek.setNazov(NázovTextfield.getText());
        liekDao.upravLiek(liek);
        DatabazaForm databazaForm = new DatabazaForm((Dialog) this.getParent().getParent(), true);
        this.setVisible(false);
         databazaForm.setVisible(true);
        }
        if (vec.equals("liecba")){
        liecba.setNazov(NázovTextfield.getText());
        liecbaDao.upravLiecbu(liecba);
        DatabazaForm databazaForm = new DatabazaForm((Dialog) this.getParent().getParent(), true);
        this.setVisible(false);
         databazaForm.setVisible(true);;
        }
       } else {
       if (vec.equals("diagnoza")){
            diagnoza = new Diagnoza();
           diagnoza.setNazov(NázovTextfield.getText());
           diagnozaDao.pridajDiagnozu(diagnoza);
           DatabazaForm databazaForm = new DatabazaForm((Dialog) this.getParent().getParent(), true);
        this.setVisible(false);
         databazaForm.setVisible(true);
       }
        if (vec.equals("liek")){
        liek = new Liek();
           liek.setNazov(NázovTextfield.getText());
           liekDao.pridajLiek(liek);
           DatabazaForm databazaForm = new DatabazaForm((Dialog) this.getParent().getParent(), true);
        this.setVisible(false);
         databazaForm.setVisible(true);
       }
        if (vec.equals("liecba")){
        liecba = new Liecba();
           liecba.setNazov(NázovTextfield.getText());
           liecbaDao.pridajLiecbu(liecba);
           DatabazaForm databazaForm = new DatabazaForm((Dialog) this.getParent().getParent(), true);
        this.setVisible(false);
         databazaForm.setVisible(true);
        }
        
       }
       this.setVisible(false);
    }//GEN-LAST:event_PridajUpravButtonActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel NázovLabel;
    private javax.swing.JTextField NázovTextfield;
    private javax.swing.JButton PridajUpravButton;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
