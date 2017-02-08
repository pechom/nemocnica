package sk.upjs.ics.paz1c.nemocnica;

import javax.swing.JOptionPane;

public class LoginForm extends javax.swing.JFrame {

   private PouzivatelDAO pouzivatelDao = DaoFactory.INSTANCE.getPouzivatelDao();
    
    public LoginForm() {
        
       
        initComponents();
        this.setSize(480, 280);
        
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPasswordField1 = new javax.swing.JPasswordField();
        jPasswordField2 = new javax.swing.JPasswordField();
        prihlasenieLabel = new javax.swing.JLabel();
        prihlasovacieMenoLabel = new javax.swing.JLabel();
        PasswordField = new javax.swing.JPasswordField();
        prihlasovacieHesloLabel = new javax.swing.JLabel();
        prihlasovacieMenoTextField = new javax.swing.JTextField();
        prihlasitButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        jPasswordField1.setText("jPasswordField1");

        jPasswordField2.setText("jPasswordField2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(204, 255, 204));
        getContentPane().setLayout(null);

        prihlasenieLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        prihlasenieLabel.setForeground(new java.awt.Color(0, 102, 0));
        prihlasenieLabel.setText("Zadajte prihlasovacie údaje");
        getContentPane().add(prihlasenieLabel);
        prihlasenieLabel.setBounds(101, 21, 250, 22);

        prihlasovacieMenoLabel.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        prihlasovacieMenoLabel.setForeground(new java.awt.Color(0, 102, 0));
        prihlasovacieMenoLabel.setText("Prihlasovacie meno:");
        getContentPane().add(prihlasovacieMenoLabel);
        prihlasovacieMenoLabel.setBounds(40, 80, 140, 30);
        getContentPane().add(PasswordField);
        PasswordField.setBounds(190, 120, 220, 30);

        prihlasovacieHesloLabel.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        prihlasovacieHesloLabel.setForeground(new java.awt.Color(0, 102, 0));
        prihlasovacieHesloLabel.setText("Prihlasovacie heslo:");
        getContentPane().add(prihlasovacieHesloLabel);
        prihlasovacieHesloLabel.setBounds(37, 120, 140, 26);

        prihlasovacieMenoTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prihlasovacieMenoTextFieldActionPerformed(evt);
            }
        });
        getContentPane().add(prihlasovacieMenoTextField);
        prihlasovacieMenoTextField.setBounds(190, 80, 220, 32);

        prihlasitButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        prihlasitButton.setForeground(new java.awt.Color(0, 102, 0));
        prihlasitButton.setText("PRIHLÁSIŤ");
        prihlasitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prihlasitButtonActionPerformed(evt);
            }
        });
        getContentPane().add(prihlasitButton);
        prihlasitButton.setBounds(164, 192, 103, 32);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Background.jpg"))); // NOI18N
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        getContentPane().add(jLabel1);
        jLabel1.setBounds(-10, 0, 480, 260);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void prihlasovacieMenoTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prihlasovacieMenoTextFieldActionPerformed

    }//GEN-LAST:event_prihlasovacieMenoTextFieldActionPerformed

    private void prihlasitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prihlasitButtonActionPerformed
        
        char[] zapisaneHeslo =PasswordField.getPassword();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < zapisaneHeslo.length; i++) {
            sb.append(zapisaneHeslo[i]);
        }
        String heslo = sb.toString();
        System.out.println(heslo);
        if(pouzivatelDao.checkMenoAHeslo(prihlasovacieMenoTextField.getText(), heslo)) {
           Pouzivatel pouzivatel = pouzivatelDao.najdiPouzivatela(prihlasovacieMenoTextField.getText());
            ProfilForm profilForm = new ProfilForm(this, true, pouzivatel);
            profilForm.setVisible(true);
            this.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(null, "Nesprávne zadané prihlasovacie meno alebo heslo !");
        }
    }//GEN-LAST:event_prihlasitButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField PasswordField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JPasswordField jPasswordField2;
    private javax.swing.JLabel prihlasenieLabel;
    private javax.swing.JButton prihlasitButton;
    private javax.swing.JLabel prihlasovacieHesloLabel;
    private javax.swing.JLabel prihlasovacieMenoLabel;
    private javax.swing.JTextField prihlasovacieMenoTextField;
    // End of variables declaration//GEN-END:variables
}
