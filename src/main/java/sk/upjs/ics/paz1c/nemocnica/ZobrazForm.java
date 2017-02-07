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
public class ZobrazForm extends javax.swing.JDialog {

    /**
     * Creates new form ZobrazForm
     */
    private Zaznam zaznam;
    private Pouzivatel pouzivatel;
    
        
    
    public ZobrazForm(java.awt.Dialog parent, boolean modal,Zaznam zaznam, Pouzivatel pouzivatel) {
        super(parent, modal);
        initComponents();
        
        
        this.setSize(830, 470);
        this.zaznam = zaznam;
        this.pouzivatel=pouzivatel;
        
        menoLekarDetailjLabel.setText("Meno : " + zaznam.getLekar().getMeno());
        priezviskoLekarDetailjLabel.setText("Priezvisko : " + zaznam.getLekar().getPriezvisko());
        specLekarDetailjLabel.setText("Špecializácia : " + zaznam.getLekar().getSpecializacia());
        
        menoPacientDetailjLabel.setText("Meno : " + zaznam.getPacient().getMeno());
        priezviskoPacientDetailjLabel.setText("Priezvisko : " + zaznam.getPacient().getPriezvisko());
        vekPacientDetailjLabel.setText("Vek : " + Integer.toString(zaznam.getPacient().getVek()));
        
        diagnozaNazovDetailjLabel.setText("Názov : " + zaznam.getDiagnoza().getNazov());
        
        nazovLiekDetailjLabel.setText("Názov : " + zaznam.getLiek().getNazov());
        
        liecbaNazovDetailjLabel.setText("Názov : " + zaznam.getLiecba().getNazov());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lekarDetailjLabel = new javax.swing.JLabel();
        detailLabel = new javax.swing.JLabel();
        pacientDetailjLabel = new javax.swing.JLabel();
        menoPacientDetailjLabel = new javax.swing.JLabel();
        priezviskoPacientDetailjLabel = new javax.swing.JLabel();
        vekPacientDetailjLabel = new javax.swing.JLabel();
        specLekarDetailjLabel = new javax.swing.JLabel();
        priezviskoLekarDetailjLabel = new javax.swing.JLabel();
        menoLekarDetailjLabel = new javax.swing.JLabel();
        diagnozaDetailjLabel = new javax.swing.JLabel();
        diagnozaNazovDetailjLabel = new javax.swing.JLabel();
        liecbaDetailjLabel = new javax.swing.JLabel();
        liecbaNazovDetailjLabel = new javax.swing.JLabel();
        liekDetailjLabel = new javax.swing.JLabel();
        nazovLiekDetailjLabel = new javax.swing.JLabel();
        upravitjButton = new javax.swing.JButton();
        okDetailButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        lekarDetailjLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lekarDetailjLabel.setForeground(new java.awt.Color(0, 102, 0));
        lekarDetailjLabel.setText("Lekár ");
        lekarDetailjLabel.setToolTipText("");
        getContentPane().add(lekarDetailjLabel);
        lekarDetailjLabel.setBounds(10, 39, 56, 22);

        detailLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        detailLabel.setForeground(new java.awt.Color(0, 102, 0));
        detailLabel.setText("Detail záznamu");
        getContentPane().add(detailLabel);
        detailLabel.setBounds(302, 11, 139, 22);

        pacientDetailjLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        pacientDetailjLabel.setForeground(new java.awt.Color(0, 102, 0));
        pacientDetailjLabel.setText("Pacient ");
        getContentPane().add(pacientDetailjLabel);
        pacientDetailjLabel.setBounds(418, 42, 73, 17);

        menoPacientDetailjLabel.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        menoPacientDetailjLabel.setForeground(new java.awt.Color(0, 102, 0));
        menoPacientDetailjLabel.setText("Meno : ");
        getContentPane().add(menoPacientDetailjLabel);
        menoPacientDetailjLabel.setBounds(448, 79, 371, 20);

        priezviskoPacientDetailjLabel.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        priezviskoPacientDetailjLabel.setForeground(new java.awt.Color(0, 102, 0));
        priezviskoPacientDetailjLabel.setText("Priezvisko :");
        getContentPane().add(priezviskoPacientDetailjLabel);
        priezviskoPacientDetailjLabel.setBounds(448, 120, 371, 20);

        vekPacientDetailjLabel.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        vekPacientDetailjLabel.setForeground(new java.awt.Color(0, 102, 0));
        vekPacientDetailjLabel.setText("Vek :");
        getContentPane().add(vekPacientDetailjLabel);
        vekPacientDetailjLabel.setBounds(448, 170, 371, 20);

        specLekarDetailjLabel.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        specLekarDetailjLabel.setForeground(new java.awt.Color(0, 102, 0));
        specLekarDetailjLabel.setText("Špecializácia :");
        getContentPane().add(specLekarDetailjLabel);
        specLekarDetailjLabel.setBounds(31, 170, 351, 20);

        priezviskoLekarDetailjLabel.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        priezviskoLekarDetailjLabel.setForeground(new java.awt.Color(0, 102, 0));
        priezviskoLekarDetailjLabel.setText("Priezvisko :");
        getContentPane().add(priezviskoLekarDetailjLabel);
        priezviskoLekarDetailjLabel.setBounds(31, 120, 351, 20);

        menoLekarDetailjLabel.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        menoLekarDetailjLabel.setForeground(new java.awt.Color(0, 102, 0));
        menoLekarDetailjLabel.setText("Meno :");
        getContentPane().add(menoLekarDetailjLabel);
        menoLekarDetailjLabel.setBounds(31, 79, 351, 20);

        diagnozaDetailjLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        diagnozaDetailjLabel.setForeground(new java.awt.Color(0, 102, 0));
        diagnozaDetailjLabel.setText("Diagnóza ");
        getContentPane().add(diagnozaDetailjLabel);
        diagnozaDetailjLabel.setBounds(10, 237, 89, 22);

        diagnozaNazovDetailjLabel.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        diagnozaNazovDetailjLabel.setForeground(new java.awt.Color(0, 102, 0));
        diagnozaNazovDetailjLabel.setText("Názov :");
        getContentPane().add(diagnozaNazovDetailjLabel);
        diagnozaNazovDetailjLabel.setBounds(33, 277, 349, 20);

        liecbaDetailjLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        liecbaDetailjLabel.setForeground(new java.awt.Color(0, 102, 0));
        liecbaDetailjLabel.setText("Liečba");
        getContentPane().add(liecbaDetailjLabel);
        liecbaDetailjLabel.setBounds(20, 316, 58, 22);

        liecbaNazovDetailjLabel.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        liecbaNazovDetailjLabel.setForeground(new java.awt.Color(0, 102, 0));
        liecbaNazovDetailjLabel.setText("Názov :");
        getContentPane().add(liecbaNazovDetailjLabel);
        liecbaNazovDetailjLabel.setBounds(43, 356, 349, 20);

        liekDetailjLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        liekDetailjLabel.setForeground(new java.awt.Color(0, 102, 0));
        liekDetailjLabel.setText("Liek ");
        getContentPane().add(liekDetailjLabel);
        liekDetailjLabel.setBounds(418, 237, 42, 22);

        nazovLiekDetailjLabel.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        nazovLiekDetailjLabel.setForeground(new java.awt.Color(0, 102, 0));
        nazovLiekDetailjLabel.setText("Názov :");
        getContentPane().add(nazovLiekDetailjLabel);
        nazovLiekDetailjLabel.setBounds(446, 277, 373, 20);

        upravitjButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        upravitjButton.setForeground(new java.awt.Color(0, 102, 0));
        upravitjButton.setText("UPRAVIŤ");
        upravitjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                upravitjButtonActionPerformed(evt);
            }
        });
        getContentPane().add(upravitjButton);
        upravitjButton.setBounds(256, 412, 94, 33);

        okDetailButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        okDetailButton.setForeground(new java.awt.Color(0, 102, 0));
        okDetailButton.setText("OK");
        okDetailButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okDetailButtonActionPerformed(evt);
            }
        });
        getContentPane().add(okDetailButton);
        okDetailButton.setBounds(418, 412, 93, 33);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Background.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 700, 460);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void upravitjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_upravitjButtonActionPerformed
        ModifikujZaznam pridajUpravZaznamForm = new ModifikujZaznam(this, true, true, zaznam,pouzivatel);
        pridajUpravZaznamForm.setVisible(true);

        this.setVisible(false);
    }//GEN-LAST:event_upravitjButtonActionPerformed

    private void okDetailButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okDetailButtonActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_okDetailButtonActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel detailLabel;
    private javax.swing.JLabel diagnozaDetailjLabel;
    private javax.swing.JLabel diagnozaNazovDetailjLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lekarDetailjLabel;
    private javax.swing.JLabel liecbaDetailjLabel;
    private javax.swing.JLabel liecbaNazovDetailjLabel;
    private javax.swing.JLabel liekDetailjLabel;
    private javax.swing.JLabel menoLekarDetailjLabel;
    private javax.swing.JLabel menoPacientDetailjLabel;
    private javax.swing.JLabel nazovLiekDetailjLabel;
    private javax.swing.JButton okDetailButton;
    private javax.swing.JLabel pacientDetailjLabel;
    private javax.swing.JLabel priezviskoLekarDetailjLabel;
    private javax.swing.JLabel priezviskoPacientDetailjLabel;
    private javax.swing.JLabel specLekarDetailjLabel;
    private javax.swing.JButton upravitjButton;
    private javax.swing.JLabel vekPacientDetailjLabel;
    // End of variables declaration//GEN-END:variables
}