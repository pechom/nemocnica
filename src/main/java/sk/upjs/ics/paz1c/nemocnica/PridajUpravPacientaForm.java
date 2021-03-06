package sk.upjs.ics.paz1c.nemocnica;

import java.awt.Dialog;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author szoplakz
 */
public class PridajUpravPacientaForm extends javax.swing.JDialog {

    /**
     * Creates new form PridajUpravLekara
     */
    
    private Pacient pacient;
    private Boolean uprav;
    PacientDAO pacientDao = DaoFactory.INSTANCE.getPacientDao();
    
    public PridajUpravPacientaForm(java.awt.Dialog parent, boolean modal, boolean uprav, Pacient pacient) {
        super(parent, modal);
        initComponents();
        this.setSize(520, 250);
        this.uprav = uprav;
        
         if(uprav){
         this.pacient=pacient;    
         MenoTextField.setText(pacient.getMeno());
         PriezviskoTextField.setText(pacient.getPriezvisko());
         
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

        MenoLabel = new javax.swing.JLabel();
        PriezviskoLabel = new javax.swing.JLabel();
        VekLabel = new javax.swing.JLabel();
        MenoTextField = new javax.swing.JTextField();
        PriezviskoTextField = new javax.swing.JTextField();
        PridajUpravButton = new javax.swing.JButton();
        VekSpinner = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        MenoLabel.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        MenoLabel.setForeground(new java.awt.Color(0, 102, 0));
        MenoLabel.setText("Meno:");
        getContentPane().add(MenoLabel);
        MenoLabel.setBounds(0, 11, 97, 28);

        PriezviskoLabel.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        PriezviskoLabel.setForeground(new java.awt.Color(0, 102, 0));
        PriezviskoLabel.setText("Priezvisko:");
        getContentPane().add(PriezviskoLabel);
        PriezviskoLabel.setBounds(0, 55, 97, 28);

        VekLabel.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        VekLabel.setForeground(new java.awt.Color(0, 102, 0));
        VekLabel.setText("Vek:");
        getContentPane().add(VekLabel);
        VekLabel.setBounds(0, 105, 97, 28);
        getContentPane().add(MenoTextField);
        MenoTextField.setBounds(115, 11, 379, 33);
        getContentPane().add(PriezviskoTextField);
        PriezviskoTextField.setBounds(115, 55, 379, 33);

        PridajUpravButton.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        PridajUpravButton.setForeground(new java.awt.Color(0, 102, 0));
        PridajUpravButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PridajUpravButtonActionPerformed(evt);
            }
        });
        getContentPane().add(PridajUpravButton);
        PridajUpravButton.setBounds(188, 149, 100, 43);

        VekSpinner.setModel(new javax.swing.SpinnerNumberModel());
        getContentPane().add(VekSpinner);
        VekSpinner.setBounds(120, 100, 380, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Background.jpg"))); // NOI18N
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 510, 230);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PridajUpravButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PridajUpravButtonActionPerformed
        if(uprav){
          pacient.setMeno(MenoTextField.getText());
          pacient.setPriezvisko(PriezviskoTextField.getText());
          pacient.setVek( (Integer)VekSpinner.getValue());
          pacientDao.upravPacienta(pacient);
        } else {
            pacient = new Pacient();
             pacient.setMeno(MenoTextField.getText());
          pacient.setPriezvisko(PriezviskoTextField.getText());
         pacient.setVek((Integer)(VekSpinner.getValue()));
          pacientDao.pridajPacienta(pacient);
        }
        
        PacientForm pacientform = new PacientForm((Dialog) this.getParent().getParent(),true);
            this.getParent().setVisible(false);
            pacientform.setVisible(true);
            
            this.setVisible(false);
            
    }//GEN-LAST:event_PridajUpravButtonActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel MenoLabel;
    private javax.swing.JTextField MenoTextField;
    private javax.swing.JButton PridajUpravButton;
    private javax.swing.JLabel PriezviskoLabel;
    private javax.swing.JTextField PriezviskoTextField;
    private javax.swing.JLabel VekLabel;
    private javax.swing.JSpinner VekSpinner;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
