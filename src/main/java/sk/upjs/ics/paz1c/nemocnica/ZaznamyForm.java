package sk.upjs.ics.paz1c.nemocnica;

import java.util.List;
import javax.swing.JOptionPane;

import javax.swing.table.DefaultTableCellRenderer;

public class ZaznamyForm extends javax.swing.JDialog {

    private ZaznamTableModel model;
    private Pouzivatel pouzivatel;
    
    public ZaznamyForm(java.awt.Dialog parent, boolean modal, Pouzivatel pouzivatel) {
        super(parent, modal);
        initComponents();
        this.pouzivatel=pouzivatel;
        this.setSize(590, 410);
        aktualizovatZaznamy();
        


    }
    
    private void aktualizovatZaznamy() {
        // ziskanie modelu
       model = (ZaznamTableModel) zaznamyjTable.getModel();        
        // aktualizovanie modelu
        model.aktualizovat();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        zaznamyLabel = new javax.swing.JLabel();
        pridatButton = new javax.swing.JButton();
        zmazatButton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        refreshjButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        zaznamyjTable = new javax.swing.JTable();
        PridatLabel = new javax.swing.JLabel();
        PridatLabel1 = new javax.swing.JLabel();
        PridatLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        getContentPane().setLayout(null);

        zaznamyLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        zaznamyLabel.setForeground(new java.awt.Color(0, 102, 0));
        zaznamyLabel.setText("Záznamy");
        getContentPane().add(zaznamyLabel);
        zaznamyLabel.setBounds(200, 0, 118, 32);

        pridatButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        pridatButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddIcon.png"))); // NOI18N
        pridatButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pridatButtonActionPerformed(evt);
            }
        });
        getContentPane().add(pridatButton);
        pridatButton.setBounds(470, 50, 90, 80);

        zmazatButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        zmazatButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/DeleteIcon.png"))); // NOI18N
        zmazatButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zmazatButtonActionPerformed(evt);
            }
        });
        getContentPane().add(zmazatButton);
        zmazatButton.setBounds(470, 160, 90, 80);

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/HelpIcon.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(470, 270, 90, 80);

        refreshjButton.setBackground(new java.awt.Color(0, 102, 51));
        refreshjButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        refreshjButton.setForeground(new java.awt.Color(0, 102, 0));
        refreshjButton.setText("REFRESH");
        refreshjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshjButtonActionPerformed(evt);
            }
        });
        getContentPane().add(refreshjButton);
        refreshjButton.setBounds(0, 20, 81, 30);

        zaznamyjTable.setBackground(new java.awt.Color(204, 255, 204));
        zaznamyjTable.setModel(new ZaznamTableModel());
        zaznamyjTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                zaznamyjTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(zaznamyjTable);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(0, 50, 450, 300);

        PridatLabel.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        PridatLabel.setForeground(new java.awt.Color(0, 102, 0));
        PridatLabel.setText("Nápoveda:");
        getContentPane().add(PridatLabel);
        PridatLabel.setBounds(470, 250, 90, 17);

        PridatLabel1.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        PridatLabel1.setForeground(new java.awt.Color(0, 102, 0));
        PridatLabel1.setText("Pridať:");
        getContentPane().add(PridatLabel1);
        PridatLabel1.setBounds(470, 30, 60, 17);

        PridatLabel2.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        PridatLabel2.setForeground(new java.awt.Color(0, 102, 0));
        PridatLabel2.setText("Vymazať:");
        getContentPane().add(PridatLabel2);
        PridatLabel2.setBounds(470, 140, 80, 17);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Background.jpg"))); // NOI18N
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 590, 360);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // zobrazenie pridat formu
    private void pridatButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pridatButtonActionPerformed
        ModifikujZaznam pridajUpravZaznamForm = new ModifikujZaznam(this, true, false, null,pouzivatel);
        pridajUpravZaznamForm.setVisible(true);
        
    }//GEN-LAST:event_pridatButtonActionPerformed

    // zmazanie zaznamu, je potrebne oznacit zaznam
    private void zmazatButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zmazatButtonActionPerformed
        if(zaznamyjTable.getSelectedRow()==-1){
            JOptionPane.showMessageDialog(null, "Je potrebné najskôr označiť záznam.");
        } else {
            // vybratie zaznamu v tabulke
            int riadok = zaznamyjTable.getSelectedRow();
            Zaznam zaznam = ((ZaznamTableModel) zaznamyjTable.getModel()).getZaznamAt(riadok);
            // okno ano nie
            int odpoved = JOptionPane.YES_NO_OPTION;
            int otazka = JOptionPane.showConfirmDialog(this, "Ste si istý?", "Vymazať" ,odpoved);
            // ak je odpoved ano, tak vymaze zoznam a refreshne list zoznamov
            if(otazka == 0){            
                DaoFactory.INSTANCE.getZaznamDao().vymazZaznam(zaznam);
                model.aktualizovat();
             }
        }
    }//GEN-LAST:event_zmazatButtonActionPerformed

    // napoveda
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JOptionPane.showMessageDialog(null, "Všetky záznamy, ktoré sa nachádzajú v systéme. \n"
                                    +"Po dvojkliknutí na záznam sa Vám zobrazí podrobné informácie o zázname.  \n"
                                    + "Tlačidlo pridať Vám umožní pridať nový záznam "
                                        + "a tlačidlo vymazať Vám umožní vymazať aktuálny vybratý záznam. \n"
                                     + "Po pridaní záznamu je potrebné stlačiť tlačidlo refresh pre zobrazenie nového záznamu.");
    }//GEN-LAST:event_jButton1ActionPerformed

    // refresh tabulky zoznamov 
    private void refreshjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshjButtonActionPerformed
        model.aktualizovat();
    }//GEN-LAST:event_refreshjButtonActionPerformed

    private void zaznamyjTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_zaznamyjTableMouseClicked
        // ked sa dvakrat klikne na nejaky riadok v tabulke, tak sa zobrazi detail danneho zaznamu
        if ( evt.getClickCount() == 2) {
            int riadok = zaznamyjTable.getSelectedRow();
            Zaznam zaznam = ((ZaznamTableModel) zaznamyjTable.getModel()).getZaznamAt(riadok);
            
            ZobrazZaznamForm zobrazForm = new ZobrazZaznamForm(this,true,zaznam,pouzivatel);
            
            zobrazForm.setVisible(true);
            
            aktualizovatZaznamy();
        }
    }//GEN-LAST:event_zaznamyjTableMouseClicked

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel PridatLabel;
    private javax.swing.JLabel PridatLabel1;
    private javax.swing.JLabel PridatLabel2;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton pridatButton;
    private javax.swing.JButton refreshjButton;
    private javax.swing.JLabel zaznamyLabel;
    private javax.swing.JTable zaznamyjTable;
    private javax.swing.JButton zmazatButton;
    // End of variables declaration//GEN-END:variables
}
