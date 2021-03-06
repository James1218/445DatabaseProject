package tsp;

import java.awt.Toolkit;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;
import javax.swing.JOptionPane;
import static tsp.LogInWindow.myCallBack;

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
public class RegisterWindow extends javax.swing.JDialog 
{ 
    public static ClassCallback myCallBack;
    /**
     * Default constructor
     * 
     * @param passInList 
     */
    public RegisterWindow()
    {
        initComponents();
        //set save button as default
        //set the icon of the form
        //set title 
        setTitle("Register");
        //this.setIconImage(Toolkit.getDefault);
        this.setLocationRelativeTo(null);
        this.setModal(true);
    }

    /**
     * Creates new form CreateOwnCity
     */
    public RegisterWindow(java.awt.Frame parent, boolean modal) {
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
        jLabel3 = new javax.swing.JLabel();
        quitJButton = new javax.swing.JButton();
        accountNameLabel = new javax.swing.JLabel();
        usernameJTextField = new javax.swing.JTextField();
        userPasswordJLable = new javax.swing.JLabel();
        registerEnterJButton = new javax.swing.JButton();
        confirmPasswordJLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        accountDNameJLabel = new javax.swing.JLabel();
        addressJLabel = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        addressJTextArea = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        dashboardNameTextField = new javax.swing.JTextField();
        emailJTextField = new javax.swing.JTextField();
        phoneJTextField = new javax.swing.JTextField();
        passwordJPasswordField = new javax.swing.JPasswordField();
        passwordConfirmJPasswordField = new javax.swing.JPasswordField();

        jToggleButton1.setText("jToggleButton1");

        jLabel3.setText("jLabel3");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        quitJButton.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        quitJButton.setText("Quit");
        quitJButton.setToolTipText("Quit");
        quitJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitJButtonActionPerformed(evt);
            }
        });

        accountNameLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        accountNameLabel.setText("User Name :");

        usernameJTextField.setToolTipText("User Name");

        userPasswordJLable.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        userPasswordJLable.setText("Password :");

        registerEnterJButton.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        registerEnterJButton.setText("Register");
        registerEnterJButton.setToolTipText("Create city");
        registerEnterJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerEnterJButtonActionPerformed(evt);
            }
        });

        confirmPasswordJLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        confirmPasswordJLabel.setText("Confirm Password :");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Register");

        accountDNameJLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        accountDNameJLabel.setText("Dashboard Name : ");

        addressJLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        addressJLabel.setText("Address :");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Email :");

        addressJTextArea.setColumns(20);
        addressJTextArea.setRows(5);
        jScrollPane1.setViewportView(addressJTextArea);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Phone :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(userPasswordJLable, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(accountNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(usernameJTextField)
                            .addComponent(passwordJPasswordField, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(registerEnterJButton)
                                .addGap(18, 18, 18)
                                .addComponent(quitJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(addressJLabel, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(accountDNameJLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(dashboardNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(confirmPasswordJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(passwordConfirmJPasswordField))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(emailJTextField)
                                    .addComponent(phoneJTextField)))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING))
                        .addContainerGap(19, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(accountNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(usernameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userPasswordJLable, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordJPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(confirmPasswordJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordConfirmJPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(accountDNameJLabel)
                    .addComponent(dashboardNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(emailJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(phoneJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addressJLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(quitJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(registerEnterJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void quitJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitJButtonActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_quitJButtonActionPerformed

    private void registerEnterJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerEnterJButtonActionPerformed
        // TODO add your handling code here:
        
        if(Arrays.equals(passwordJPasswordField.getPassword(),
                passwordConfirmJPasswordField.getPassword())) {
            
            Date date = new Date();
            SimpleDateFormat  sdf = new SimpleDateFormat("yyyy/MM/dd");
            sdf.format(date);
        
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.DATE, 0); 
            cal.getTime(); 
            
            String userName = usernameJTextField.getText();
            String userPassword = String.valueOf(passwordJPasswordField.getPassword());
            String userDashBoardName = dashboardNameTextField.getText();
            String userEmail = emailJTextField.getText();
            String userPhone = phoneJTextField.getText();
            String userAddress = addressJTextArea.getText();
            
            String createdTime = sdf.format(cal.getTime());

            //String theAccountName, String theAccountPW,
                //String theAccountSbName, String theAccountSbAddress, String theAccountSbPhone,
                //String theAccountSbEmail, String theCreatedTime
                
            boolean insertResult = DatabaseAccess.insertNewUser(userName, userPassword, userDashBoardName,
                    userAddress, userPhone, userEmail,
                    createdTime);
            
            if(insertResult) {
                JOptionPane.showMessageDialog(null, "Register successful!");
                myCallBack.setLoginStatus(true, false, userName);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Register fail!");
            }
            
        } else {
            JOptionPane.showMessageDialog(null, "Register fail! Password doesn't match");
        }
    }//GEN-LAST:event_registerEnterJButtonActionPerformed

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
            java.util.logging.Logger.getLogger(RegisterWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegisterWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegisterWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegisterWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                RegisterWindow dialog = new RegisterWindow(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel accountDNameJLabel;
    private javax.swing.JLabel accountNameLabel;
    private javax.swing.JLabel addressJLabel;
    private javax.swing.JTextArea addressJTextArea;
    private javax.swing.JLabel confirmPasswordJLabel;
    private javax.swing.JTextField dashboardNameTextField;
    private javax.swing.JTextField emailJTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JPasswordField passwordConfirmJPasswordField;
    private javax.swing.JPasswordField passwordJPasswordField;
    private javax.swing.JTextField phoneJTextField;
    private javax.swing.JButton quitJButton;
    private javax.swing.JButton registerEnterJButton;
    private javax.swing.JLabel userPasswordJLable;
    private javax.swing.JTextField usernameJTextField;
    // End of variables declaration//GEN-END:variables
}
