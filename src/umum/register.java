
package umum;
import Koneksi.Conek;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import java.sql.*;
import java.sql.Connection;

public class register extends javax.swing.JFrame {
    public Connection con;
    public Statement stt;
    public ResultSet rs;
    
    public admin1 supervisior;
    public kasir1 kasir;

    public register() {
        initComponents();
    }
    private void config(){
            try{
                   Class.forName("com.mysql.jdbc.Driver");
                   con = DriverManager.getConnection("jdbc:mysql://localhost:3306/kosmetikk","root","");
                   stt = con.createStatement();
            } catch (Exception e ) {
                    JOptionPane.showConfirmDialog(null, "Tidak Berhasil");
            }
        }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        t_username = new javax.swing.JTextField();
        t_password = new javax.swing.JPasswordField();
        comboboxjabatan = new javax.swing.JComboBox<>();
        register = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        back = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        background = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        login = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        t_username.setBackground(new java.awt.Color(211, 211, 211));
        t_username.setForeground(new java.awt.Color(0, 0, 0));
        t_username.setText("username");
        t_username.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                t_usernameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                t_usernameFocusLost(evt);
            }
        });
        t_username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_usernameActionPerformed(evt);
            }
        });
        getContentPane().add(t_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 200, 200, 30));

        t_password.setBackground(new java.awt.Color(211, 211, 211));
        t_password.setForeground(new java.awt.Color(0, 0, 0));
        t_password.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                t_passwordFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                t_passwordFocusLost(evt);
            }
        });
        t_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_passwordActionPerformed(evt);
            }
        });
        getContentPane().add(t_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 240, 200, 30));

        comboboxjabatan.setBackground(new java.awt.Color(255, 255, 255));
        comboboxjabatan.setForeground(new java.awt.Color(0, 0, 0));
        comboboxjabatan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "admin", "kasir" }));
        comboboxjabatan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboboxjabatanActionPerformed(evt);
            }
        });
        getContentPane().add(comboboxjabatan, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 280, 200, 30));

        register.setBackground(new java.awt.Color(255, 102, 0));
        register.setForeground(new java.awt.Color(255, 255, 255));
        register.setText("REGISTER");
        register.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerActionPerformed(evt);
            }
        });
        getContentPane().add(register, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 370, 170, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("REGISTER");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, -1, -1));

        back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Who_Hd_Transparent__A_Woman_Who_Is_Doing_Makeup__Girl__Makeup__Powder_PNG_Image_For_Free_Download-removebg-preview 1.png"))); // NOI18N
        getContentPane().add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Username ");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 200, 80, 30));

        background.setBackground(new java.awt.Color(255, 204, 204));
        background.setForeground(new java.awt.Color(255, 204, 204));
        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Rectangle 109.png"))); // NOI18N
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 410, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Password ");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 240, 80, 30));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Jabatan ");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 280, 80, 30));

        jPanel3.setBackground(new java.awt.Color(255, 204, 204));
        jPanel3.setForeground(new java.awt.Color(255, 204, 204));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("SILAHKAN ISI DATA!!!");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 30, -1, 60));

        login.setBackground(new java.awt.Color(255, 255, 0));
        login.setForeground(new java.awt.Color(0, 0, 0));
        login.setText("kembali");
        login.setBorderPainted(false);
        login.setFocusPainted(false);
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });
        jPanel3.add(login, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 420, 100, 30));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 520));

        jLabel7.setForeground(new java.awt.Color(255, 51, 51));
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 330, 300, 30));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void t_usernameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t_usernameFocusGained
        String username=t_username.getText();
        if(username.equals("username")){
            t_username.setText("");
        }
    }//GEN-LAST:event_t_usernameFocusGained

    private void t_usernameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t_usernameFocusLost
        String username=t_username.getText();
        if(username.equals("")||username.equals("username")){
            t_username.setText("username");
        }
    }//GEN-LAST:event_t_usernameFocusLost

    private void t_usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_usernameActionPerformed

    private void t_passwordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t_passwordFocusGained
        String pass=t_password.getText();
        if(pass.equals("*****")){
            t_password.setText("");
        }
    }//GEN-LAST:event_t_passwordFocusGained

    private void t_passwordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t_passwordFocusLost
        String pass=t_password.getText();
        if(pass.equals("")||pass.equals("*****")){
            t_password.setText("*****");
        }
    }//GEN-LAST:event_t_passwordFocusLost

    private void t_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_passwordActionPerformed

    private void comboboxjabatanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboboxjabatanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboboxjabatanActionPerformed

    private void registerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerActionPerformed
        try {
            String sql = "INSERT INTO login_admin VALUES ('"+t_username.getText()+"','"+t_password.getText()+"','"+comboboxjabatan.getSelectedItem()+"')";

            java.sql.Connection conn=(java.sql.Connection)Conek.GetConnection();
            java.sql.PreparedStatement pst = conn.prepareCall(sql);
            pst.execute();

            JOptionPane.showMessageDialog(null,"Penyimpanan Data Berhasil");
            this.setVisible(false);
            new login_admin().setVisible(true);
        }catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }

    }//GEN-LAST:event_registerActionPerformed

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed
        int confirm = JOptionPane.showConfirmDialog(this, "Apakah Anda yakin ingin kembali?", "Konfirmasi Logout", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            this.setVisible(false);
            new login_admin().setVisible(true);
        }
    }//GEN-LAST:event_loginActionPerformed

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
            java.util.logging.Logger.getLogger(register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new register().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel back;
    private javax.swing.JLabel background;
    private javax.swing.JComboBox<String> comboboxjabatan;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton login;
    private javax.swing.JButton register;
    private javax.swing.JPasswordField t_password;
    private javax.swing.JTextField t_username;
    // End of variables declaration//GEN-END:variables
}
