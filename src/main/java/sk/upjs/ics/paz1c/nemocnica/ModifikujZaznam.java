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
public class ModifikujZaznam extends javax.swing.JDialog {

    /**
     * Creates new form ModifikujZaznam
     */
    
     private LekarComboBoxModel lekarComboBoxModel = new LekarComboBoxModel();
    private LiekComboBoxModel liekComboBoxModel = new LiekComboBoxModel();
    private LiecbaComboBoxModel liecbaComboBoxModel = new LiecbaComboBoxModel();
    private DiagnozaComboBoxModel diagnozaComboBoxModel = new DiagnozaComboBoxModel();
    private PacientComboBoxModel pacientComboBoxModel = new PacientComboBoxModel();
    ZaznamDAO zaznamDao = DaoFactory.INSTANCE.getZaznamDao();
    private boolean uprav;
    private Zaznam zaznam;
    private Pouzivatel pouzivatel;
    public ModifikujZaznam(java.awt.Dialog parent, boolean modal,  Boolean uprav, Zaznam zaznam, Pouzivatel pouzivatel) {
        super(parent, modal);
        initComponents();
        this.setSize(640, 470);
        this.uprav=uprav;
        this.zaznam=zaznam;
        this.pouzivatel=pouzivatel;
        if(uprav){
        LekarComboBox.setSelectedItem(zaznam.getLekar());
        DiagnozaComboBox.setSelectedItem(zaznam.getDiagnoza());
        LiekComboBox.setSelectedItem(zaznam.getLiek());
        LiecbaComboBox.setSelectedItem(zaznam.getLiecba());
        PacientComboBox.setSelectedItem(zaznam.getPacient());
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

        jLabel2 = new javax.swing.JLabel();
        lekarjLabel = new javax.swing.JLabel();
        LekarComboBox = new javax.swing.JComboBox<>();
        PacientComboBox = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        DiagnozaComboBox = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        LiekComboBox = new javax.swing.JComboBox<>();
        LiecbaLabel = new javax.swing.JLabel();
        LiecbaComboBox = new javax.swing.JComboBox<>();
        PridatUpravitZaznamButton = new javax.swing.JButton();
        PacientLabel = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Background.jpg"))); // NOI18N
        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        lekarjLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lekarjLabel.setForeground(new java.awt.Color(0, 102, 0));
        lekarjLabel.setText("LEKÁR");
        getContentPane().add(lekarjLabel);
        lekarjLabel.setBounds(10, 10, 52, 17);

        LekarComboBox.setModel(lekarComboBoxModel);
        LekarComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LekarComboBoxActionPerformed(evt);
            }
        });
        getContentPane().add(LekarComboBox);
        LekarComboBox.setBounds(10, 30, 602, 35);

        PacientComboBox.setModel(pacientComboBoxModel);
        getContentPane().add(PacientComboBox);
        PacientComboBox.setBounds(10, 100, 602, 35);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 0));
        jLabel1.setText("DIAGNÓZA");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 140, 78, 17);

        DiagnozaComboBox.setModel(diagnozaComboBoxModel);
        getContentPane().add(DiagnozaComboBox);
        DiagnozaComboBox.setBounds(10, 160, 602, 35);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 0));
        jLabel3.setText("LIEK");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(10, 200, 34, 17);

        LiekComboBox.setModel(liekComboBoxModel);
        getContentPane().add(LiekComboBox);
        LiekComboBox.setBounds(10, 230, 602, 35);

        LiecbaLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        LiecbaLabel.setForeground(new java.awt.Color(0, 102, 0));
        LiecbaLabel.setText("LIECBA");
        getContentPane().add(LiecbaLabel);
        LiecbaLabel.setBounds(10, 280, 54, 17);

        LiecbaComboBox.setModel(liecbaComboBoxModel);
        getContentPane().add(LiecbaComboBox);
        LiecbaComboBox.setBounds(10, 300, 602, 35);

        PridatUpravitZaznamButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        PridatUpravitZaznamButton.setText("OK");
        PridatUpravitZaznamButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PridatUpravitZaznamButtonActionPerformed(evt);
            }
        });
        getContentPane().add(PridatUpravitZaznamButton);
        PridatUpravitZaznamButton.setBounds(270, 380, 84, 31);

        PacientLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        PacientLabel.setForeground(new java.awt.Color(0, 102, 0));
        PacientLabel.setText("PACIENT");
        getContentPane().add(PacientLabel);
        PacientLabel.setBounds(10, 70, 75, 17);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Background.jpg"))); // NOI18N
        jLabel4.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        getContentPane().add(jLabel4);
        jLabel4.setBounds(0, 0, 640, 440);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LekarComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LekarComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LekarComboBoxActionPerformed

    private void PridatUpravitZaznamButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PridatUpravitZaznamButtonActionPerformed
        if (uprav){

            Lekar lekar = lekarComboBoxModel.getElementAt(LekarComboBox.getSelectedIndex());
            Diagnoza diagnoza = diagnozaComboBoxModel.getElementAt(DiagnozaComboBox.getSelectedIndex());
            Pacient pacient = pacientComboBoxModel.getElementAt(PacientComboBox.getSelectedIndex());
            Liek liek = liekComboBoxModel.getElementAt(LiekComboBox.getSelectedIndex());
            Liecba liecba = liecbaComboBoxModel.getElementAt(LiecbaComboBox.getSelectedIndex());

            // nastavenie parametrov
            zaznam.setLekar(lekar);
            zaznam.setPacient(pacient);
            zaznam.setDiagnoza(diagnoza);
            zaznam.setLiek(liek);
            zaznam.setLiecba(liecba);
            zaznam.setPouzivatel(pouzivatel);
            zaznamDao.upravZaznam(zaznam);
            
            this.setVisible(false);
        } else {
            zaznam = new Zaznam();
            Lekar lekar = lekarComboBoxModel.getElementAt(LekarComboBox.getSelectedIndex());
            Diagnoza diagnoza = diagnozaComboBoxModel.getElementAt(DiagnozaComboBox.getSelectedIndex());
            Pacient pacient = pacientComboBoxModel.getElementAt(PacientComboBox.getSelectedIndex());
            Liek liek = liekComboBoxModel.getElementAt(LiekComboBox.getSelectedIndex());
            Liecba liecba = liecbaComboBoxModel.getElementAt(LiecbaComboBox.getSelectedIndex());
            zaznam.setLekar(lekar);
            zaznam.setPacient(pacient);
            zaznam.setDiagnoza(diagnoza);
            zaznam.setLiek(liek);
            zaznam.setLiecba(liecba);
            zaznam.setPouzivatel(pouzivatel);
            zaznamDao.pridajZaznam(zaznam);
            
            this.setVisible(false);
        }
        // pridanie do zoznamu

    }//GEN-LAST:event_PridatUpravitZaznamButtonActionPerformed

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<Diagnoza> DiagnozaComboBox;
    private javax.swing.JComboBox<Lekar> LekarComboBox;
    private javax.swing.JComboBox<Liecba> LiecbaComboBox;
    private javax.swing.JLabel LiecbaLabel;
    private javax.swing.JComboBox<Liek> LiekComboBox;
    private javax.swing.JComboBox<Pacient> PacientComboBox;
    private javax.swing.JLabel PacientLabel;
    private javax.swing.JButton PridatUpravitZaznamButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lekarjLabel;
    // End of variables declaration//GEN-END:variables
}
