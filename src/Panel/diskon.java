package Panel;
import java.sql.*;

import Koneksi.Conek;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class diskon extends javax.swing.JFrame {
    public diskon() {
        initComponents();
        datatable();
    }
        public void datatable() {
    DefaultTableModel tbl = new DefaultTableModel();
    tbl.addColumn("Kode_Barang");
    tbl.addColumn("Nama_Barang");
    tbl.addColumn("Harga");
    tbl.addColumn("Stock");
    tbl.addColumn("Jenis");
    tbl.addColumn("Expired");
    tabel.setModel(tbl);

    try {
        Connection conn = Conek.GetConnection();
        if (conn == null) {
            throw new SQLException("Gagal terhubung ke database.");
        }
        
        Statement statement = conn.createStatement();
        ResultSet res = statement.executeQuery("SELECT * FROM tbldiskon");
        
        while (res.next()) {
            tbl.addRow(new Object[]{
                res.getString("Kode_Barang"),
                res.getString("Nama_Barang"),
                res.getString("Harga"),
                res.getString("Stock"),
                res.getString("Jenis"),
                res.getString("Expired")
            });
        }
        
        res.close();
        statement.close();
        conn.close();
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(rootPane, "Error: " + e.getMessage());
    } catch (Exception e) {
        JOptionPane.showMessageDialog(rootPane, "Unexpected Error: " + e.getMessage());
    }
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        txtdate = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        btnsimpan = new javax.swing.JButton();
        btnedit = new javax.swing.JButton();
        hapus = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txt_tglmasuk = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        txtket = new javax.swing.JTextField();
        btncari = new javax.swing.JButton();
        txt_search = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        pindah = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        tambah = new javax.swing.JButton();
        diskon = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        login = new javax.swing.JButton();

        jPanel2.setBackground(new java.awt.Color(255, 204, 204));
        jPanel2.setForeground(new java.awt.Color(255, 204, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(txtdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 170, 150, -1));

        jLabel1.setText("Keterangan");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 230, -1, -1));

        btnsimpan.setText("Simpan");
        btnsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsimpanActionPerformed(evt);
            }
        });
        jPanel2.add(btnsimpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 310, -1, -1));

        btnedit.setText("Edit");
        btnedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditActionPerformed(evt);
            }
        });
        jPanel2.add(btnedit, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 310, -1, -1));

        hapus.setText("Hapus");
        hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusActionPerformed(evt);
            }
        });
        jPanel2.add(hapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 310, -1, -1));

        jLabel4.setText("Exp");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 170, 40, -1));
        jPanel2.add(txt_tglmasuk, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 200, 150, -1));

        jLabel6.setText("Tgl Masuk");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 200, 60, -1));
        jPanel2.add(txtket, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 230, 150, -1));

        btncari.setText("Cari");
        btncari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncariActionPerformed(evt);
            }
        });
        jPanel2.add(btncari, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 20, 60, -1));

        txt_search.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_search.setText("Search");
        txt_search.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_searchFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_searchFocusLost(evt);
            }
        });
        txt_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_searchActionPerformed(evt);
            }
        });
        txt_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_searchKeyReleased(evt);
            }
        });
        jPanel2.add(txt_search, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, 390, 40));

        jLabel21.setText("Kode Barang");
        jPanel2.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 170, -1, -1));

        jLabel22.setText("Nama Barang");
        jPanel2.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 200, -1, -1));

        jLabel23.setText("Harga");
        jPanel2.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 230, -1, -1));

        jLabel24.setText("Stok");
        jPanel2.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 260, 50, -1));

        jLabel20.setText("Jenis");
        jPanel2.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 280, 50, 30));

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel25.setText("Admin");
        jPanel2.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 10, 40, 30));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/[removal 10.png"))); // NOI18N
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 0, 50, -1));

        pindah.setText("pindah");
        pindah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pindahActionPerformed(evt);
            }
        });
        jPanel2.add(pindah, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 310, -1, -1));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "1", "2", "3", "4", "5"
            }
        ));
        tabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabel);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 580, 170));

        tambah.setText("Tambah");
        tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahActionPerformed(evt);
            }
        });
        getContentPane().add(tambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(432, 276, -1, -1));

        diskon.setText("Diskon");
        getContentPane().add(diskon, new org.netbeans.lib.awtextra.AbsoluteConstraints(517, 276, -1, -1));

        jPanel3.setBackground(new java.awt.Color(255, 204, 204));
        jPanel3.setForeground(new java.awt.Color(255, 204, 204));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        login.setBackground(new java.awt.Color(255, 51, 51));
        login.setForeground(new java.awt.Color(255, 255, 255));
        login.setText("LOGOUT");
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });
        jPanel3.add(login, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, 160, 30));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 620, 520));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelMouseClicked
    
    }//GEN-LAST:event_tabelMouseClicked

    private void tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tambahActionPerformed

    private void pindahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pindahActionPerformed

    }//GEN-LAST:event_pindahActionPerformed

    private void txt_searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_searchKeyReleased
        // TODO add your handling code here:
     
    }//GEN-LAST:event_txt_searchKeyReleased

    private void txt_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_searchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_searchActionPerformed

    private void txt_searchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_searchFocusLost
    
    }//GEN-LAST:event_txt_searchFocusLost

    private void txt_searchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_searchFocusGained
      
    }//GEN-LAST:event_txt_searchFocusGained

    private void btncariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncariActionPerformed
        
    }//GEN-LAST:event_btncariActionPerformed

    private void hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusActionPerformed
     
    }//GEN-LAST:event_hapusActionPerformed

    private void btneditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditActionPerformed
      
    }//GEN-LAST:event_btneditActionPerformed

    private void btnsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsimpanActionPerformed
     
    }//GEN-LAST:event_btnsimpanActionPerformed

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed
        this.setVisible(false);
        new supplier().setVisible(true);
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
            java.util.logging.Logger.getLogger(diskon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(diskon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(diskon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(diskon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new diskon().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncari;
    private javax.swing.JButton btnedit;
    private javax.swing.JButton btnsimpan;
    private javax.swing.JButton diskon;
    private javax.swing.JButton hapus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton login;
    private javax.swing.JButton pindah;
    private javax.swing.JTable tabel;
    private javax.swing.JButton tambah;
    private javax.swing.JTextField txt_search;
    private com.toedter.calendar.JDateChooser txt_tglmasuk;
    private com.toedter.calendar.JDateChooser txtdate;
    private javax.swing.JTextField txtket;
    // End of variables declaration//GEN-END:variables
}
