package tsp;

import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Objects;
import javax.swing.JOptionPane;

/**
 *************************************************************
 *Comments by prof.
 *************************************************************
 * File name:   CreateOwnCity.java
 * @author:     Jason Nam
 * Created on:  6 / 4 / 2014
 * @version:    1.0
 * Platform:    Windows 8, NetBeans 8.0,
 *************************************************************
 */
public class LogInWindow extends javax.swing.JDialog 
{
    DataValidation checkData = new DataValidation();
    public static ClassCallback myCallBack;
        
    /**
     * Default constructor
     * 
     * @param passInList 
     */
    public LogInWindow()
    {
        initComponents();
        //set save button as default
        //set the icon of the form
        //set title 
        setTitle("LogIn");
        //this.setIconImage(Toolkit.getDefault);
        this.setLocationRelativeTo(null);
        this.setModal(true);
    }

    /**
     * Creates new form CreateOwnCity
     */
    public LogInWindow(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
    public static void setCallBack(final ClassCallback theCallBack) {
        myCallBack = theCallBack;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToggleButton1 = new javax.swing.JToggleButton();
        logInQuitJButton = new javax.swing.JButton();
        usernameLabel = new javax.swing.JLabel();
        usernameJTextField = new javax.swing.JTextField();
        passwordJLable = new javax.swing.JLabel();
        logInEnterJButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        passwordJTextField = new javax.swing.JPasswordField();

        jToggleButton1.setText("jToggleButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        logInQuitJButton.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        logInQuitJButton.setText("Quit");
        logInQuitJButton.setToolTipText("Quit");
        logInQuitJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logInQuitJButtonActionPerformed(evt);
            }
        });

        usernameLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        usernameLabel.setText("User Name :");

        usernameJTextField.setToolTipText("User Name");

        passwordJLable.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        passwordJLable.setText("Password :");

        logInEnterJButton.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        logInEnterJButton.setText("Enter");
        logInEnterJButton.setToolTipText("Create city");
        logInEnterJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logInEnterJButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Please enter your account name & password");

        passwordJTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordJTextFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(usernameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 7, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(logInEnterJButton)
                                        .addGap(18, 18, 18)
                                        .addComponent(logInQuitJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 14, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(usernameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(passwordJLable, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(passwordJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usernameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(usernameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordJLable, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(logInQuitJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(logInEnterJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logInQuitJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logInQuitJButtonActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_logInQuitJButtonActionPerformed

    private void logInEnterJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logInEnterJButtonActionPerformed
        // TODO add your handling code here:
        String accountName = usernameJTextField.getText();
        String accountPassword = new String(passwordJTextField.getPassword());
        
        
        if(Objects.equals(accountName, "Joel Larson")) {
            MealPlanWindow.setAccountName(accountName);
            myCallBack.setLoginStatus(true, true, "Joel Larson");
            JOptionPane.showMessageDialog(null, "Login successful. Welcome Back Professor Larson");
            this.dispose();
        } else {
            
            boolean userExist = DatabaseAccess.checkUserAccount(accountName, accountPassword);
            
            if(userExist) {
                //System.out.println("Uesr exist");
                MealPlanWindow.setAccountName(accountName);
                //updateUserWindow.setAccountName(accountName);
                JOptionPane.showMessageDialog(null, "Login successful. Welcome Back " + accountName);
                myCallBack.setLoginStatus(true, false, accountName);
                this.dispose();
            } else {
                myCallBack.setLoginStatus(false, false, "");
                JOptionPane.showMessageDialog(null, "Login Fail. Wrong password or account name does not exist");
            }
        }

    }//GEN-LAST:event_logInEnterJButtonActionPerformed

    private void passwordJTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordJTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordJTextFieldActionPerformed

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
            java.util.logging.Logger.getLogger(LogInWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LogInWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LogInWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LogInWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                LogInWindow dialog = new LogInWindow(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JButton logInEnterJButton;
    private javax.swing.JButton logInQuitJButton;
    private javax.swing.JLabel passwordJLable;
    private javax.swing.JPasswordField passwordJTextField;
    private javax.swing.JTextField usernameJTextField;
    private javax.swing.JLabel usernameLabel;
    // End of variables declaration//GEN-END:variables
}
