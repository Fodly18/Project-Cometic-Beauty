package umum;

import Koneksi.Conek;
import Panel.Dashboard_Admin1;
import kasirpanel.dashboardkasir;
import java.sql.*;
import javax.swing.JOptionPane;
import java.sql.SQLDataException;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.*;

import java.awt.HeadlessException;
import kasirpanel.dashboardkasir;
public class login_admin extends javax.swing.JFrame {
    public Connection con;
    public Statement stt;
    public ResultSet rs;
    
    public admin1 admin;
    public kasir1 kasir;
    
    public login_admin () {
        initComponents();
        config ();
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
    void bersih(){
    t_username.setText("username");
    t_password.setText("*****");
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        t_username = new javax.swing.JTextField();
        t_password = new javax.swing.JPasswordField();
        jLabel7 = new javax.swing.JLabel();
        login = new javax.swing.JButton();
        register = new javax.swing.JButton();
        welcome_admin = new javax.swing.JLabel();
        gambar_cewe = new javax.swing.JLabel();
        persegi_di_bawh_admin1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Password.png"))); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 230, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("LOGIN");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 50, -1, -1));

        t_username.setBackground(new java.awt.Color(211, 211, 211));
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
        getContentPane().add(t_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 190, 280, 30));

        t_password.setBackground(new java.awt.Color(211, 211, 211));
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
        getContentPane().add(t_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 252, 280, 30));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Username.png"))); // NOI18N
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 160, -1, -1));

        login.setBackground(new java.awt.Color(29, 133, 56));
        login.setForeground(new java.awt.Color(255, 255, 255));
        login.setText("Login");
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });
        getContentPane().add(login, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 310, 170, 30));

        register.setBackground(new java.awt.Color(153, 153, 0));
        register.setForeground(new java.awt.Color(255, 255, 255));
        register.setText("Daftar");
        register.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerActionPerformed(evt);
            }
        });
        getContentPane().add(register, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 460, 80, 30));

        welcome_admin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Semprotkan_Makeup_Kecantikan_Pelembab__Ilustrasi_Semprotan_Hidrasi__Ilustrasi_Kartun__Rias_Kecantikan_PNG_Transparan_Clipart_dan_File_PSD_untuk_Unduh_Gratis-removebg-preview 1.png"))); // NOI18N
        getContentPane().add(welcome_admin, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, -1, -1));

        gambar_cewe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Welcome to Pegawai.png"))); // NOI18N
        getContentPane().add(gambar_cewe, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, -1, -1));

        persegi_di_bawh_admin1.setBackground(new java.awt.Color(255, 204, 204));
        persegi_di_bawh_admin1.setForeground(new java.awt.Color(255, 204, 204));
        persegi_di_bawh_admin1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Rectangle 109.png"))); // NOI18N
        getContentPane().add(persegi_di_bawh_admin1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 410, -1));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 1, -1, 520));

        jPanel2.setBackground(new java.awt.Color(255, 204, 204));
        jPanel2.setForeground(new java.awt.Color(255, 204, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("belum punya akun?");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 460, -1, 30));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 530));

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

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed
        try {
    String sql = "SELECT * FROM login_admin WHERE username = ? AND password = ?";
    PreparedStatement pstmt = con.prepareStatement(sql);
    pstmt.setString(1, t_username.getText());
    pstmt.setString(2, String.valueOf(t_password.getPassword()));
    
    ResultSet rs = pstmt.executeQuery();
    if (rs.next()) {
        String level = rs.getString("level");
        if ("admin".equals(level)) {
            admin1 admin = new admin1();
            admin.setVisible(true);
            this.dispose();
        } else if ("kasir".equals(level)) {
            kasir1 kasir = new kasir1();
            kasir.setVisible(true);
            this.dispose();
        }
    } else {
        JOptionPane.showMessageDialog(null, "GAGAL LOGIN");
        t_username.setText("");
        t_password.setText("");
        t_username.requestFocus();
    }
} catch (SQLException e) {
    JOptionPane.showMessageDialog(null, "Terjadi kesalahan pada database: " + e.getMessage());
} catch (Exception e) {
    JOptionPane.showMessageDialog(null, "Terjadi kesalahan: " + e.getMessage());
}

    }//GEN-LAST:event_loginActionPerformed

    private void registerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new register().setVisible(true);
    }//GEN-LAST:event_registerActionPerformed

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
            java.util.logging.Logger.getLogger(login_admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login_admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login_admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login_admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login_admin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel gambar_cewe;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton login;
    private javax.swing.JLabel persegi_di_bawh_admin1;
    private javax.swing.JButton register;
    private javax.swing.JPasswordField t_password;
    private javax.swing.JTextField t_username;
    private javax.swing.JLabel welcome_admin;
    // End of variables declaration//GEN-END:variables
}
