
import Koneksi.Conek;
import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;


public class karyawanAdmin extends javax.swing.JFrame {

    
    public karyawanAdmin() {
        initComponents();
        datatable();
      
        
        tabel.getTableHeader().setFont(new Font("Segoe UI",Font.BOLD,12));
        tabel.getTableHeader().setOpaque(false);
        tabel.getTableHeader().setBackground(new Color (192, 193, 195));
        tabel.getTableHeader().setForeground(new Color(13, 9, 9));
        tabel.setRowHeight(25);
        
    }
    public void datatable(){
        DefaultTableModel tbl=new DefaultTableModel();
        tbl.addColumn("Id");
        tbl.addColumn("Nama");
        tbl.addColumn("Tgl_diterima");
        tbl.addColumn("Jabatan");
        tbl.addColumn("Gaji");
        tabel.setModel(tbl);
        try{
            Statement statement=(Statement)Conek.GetConnection().createStatement();
            ResultSet res=statement.executeQuery("SELECT * FROM jabatan_karyawan");
            while(res.next())
            {
                tbl.addRow(new Object[]{
                    res.getString("id"),
                    res.getString("nama"),
                    res.getString("tgl_keterima"),
                    res.getString("jabatan"),
                    res.getString("gaji")      
                });
            }
        }catch (Exception e){
             JOptionPane.showMessageDialog(rootPane,e.toString());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtsearch = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        login = new javax.swing.JButton();
        jButton25 = new javax.swing.JButton();
        jButton27 = new javax.swing.JButton();
        jButton28 = new javax.swing.JButton();
        jButton32 = new javax.swing.JButton();
        jButton33 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 204, 204));
        jPanel2.setForeground(new java.awt.Color(255, 204, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabel.setBackground(new java.awt.Color(217, 217, 217));
        tabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "1", "2", "3"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tabel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tabel.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        tabel.setFocusable(false);
        tabel.setRowHeight(25);
        tabel.setSelectionBackground(new java.awt.Color(198, 189, 189));
        jScrollPane2.setViewportView(tabel);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 570, 350));

        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 20, -1, 30));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setText("Daftar Karyawan");
        jLabel8.setPreferredSize(new java.awt.Dimension(90, 20));
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 60, 160, 26));

        txtsearch.setBackground(new java.awt.Color(217, 217, 217));
        txtsearch.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtsearch.setText("Search");
        txtsearch.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsearchActionPerformed(evt);
            }
        });
        txtsearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtsearchKeyReleased(evt);
            }
        });
        jPanel2.add(txtsearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, 380, 30));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel19.setText("Kasir");
        jPanel2.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 10, 40, 30));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/[removal 10.png"))); // NOI18N
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 0, 50, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, 620, 520));

        jPanel3.setBackground(new java.awt.Color(255, 153, 153));
        jPanel3.setForeground(new java.awt.Color(255, 153, 153));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/[removal 35.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 130));

        login.setBackground(new java.awt.Color(255, 51, 51));
        login.setForeground(new java.awt.Color(255, 255, 255));
        login.setText("LOGOUT");
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });
        jPanel3.add(login, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 480, 160, 30));

        jButton25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Group 6.png"))); // NOI18N
        jButton25.setBorderPainted(false);
        jButton25.setContentAreaFilled(false);
        jButton25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton25ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton25, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 160, 40));

        jButton27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Group 1.png"))); // NOI18N
        jButton27.setBorderPainted(false);
        jButton27.setContentAreaFilled(false);
        jButton27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton27ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton27, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, -1, 50));

        jButton28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Group 21.png"))); // NOI18N
        jButton28.setBorderPainted(false);
        jButton28.setContentAreaFilled(false);
        jButton28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton28ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton28, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, -1, 40));

        jButton32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Group 4 (2).png"))); // NOI18N
        jButton32.setBorderPainted(false);
        jButton32.setContentAreaFilled(false);
        jButton32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton32ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton32, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, -1, 40));

        jButton33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Group 5.png"))); // NOI18N
        jButton33.setBorderPainted(false);
        jButton33.setContentAreaFilled(false);
        jButton33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton33ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton33, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, -1, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 520));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed
        int confirm = JOptionPane.showConfirmDialog(this, "Apakah Anda yakin ingin logout?", "Konfirmasi Logout", JOptionPane.YES_NO_OPTION);
    if (confirm == JOptionPane.YES_OPTION) {
        this.setVisible(false);
        new login_admin().setVisible(true);
    }
    }//GEN-LAST:event_loginActionPerformed

    private void txtsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsearchActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        DefaultTableModel cari=(DefaultTableModel) tabel.getModel();
        TableRowSorter<DefaultTableModel> obj=new TableRowSorter<>(cari);
        tabel.setRowSorter(obj);
        obj.setRowFilter(RowFilter.regexFilter(txtsearch.getText()));
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtsearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtsearchKeyReleased
        // TODO add your handling code here:
        DefaultTableModel cari=(DefaultTableModel) tabel.getModel();
        TableRowSorter<DefaultTableModel> obj=new TableRowSorter<>(cari);
        tabel.setRowSorter(obj);
        obj.setRowFilter(RowFilter.regexFilter(txtsearch.getText()));
    }//GEN-LAST:event_txtsearchKeyReleased

    private void jButton25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton25ActionPerformed
        this.setVisible(false);
        new karyawanAdmin().setVisible(true);
    }//GEN-LAST:event_jButton25ActionPerformed

    private void jButton27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton27ActionPerformed
        this.setVisible(false);
        new Dashboard_Kasir().setVisible(true);
    }//GEN-LAST:event_jButton27ActionPerformed

    private void jButton28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton28ActionPerformed
        this.setVisible(false);
        new transaksi().setVisible(true);
    }//GEN-LAST:event_jButton28ActionPerformed

    private void jButton32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton32ActionPerformed
        this.setVisible(false);
        new DataProdukKasir().setVisible(true);
    }//GEN-LAST:event_jButton32ActionPerformed

    private void jButton33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton33ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new laporan().setVisible(true);
    }//GEN-LAST:event_jButton33ActionPerformed

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
            java.util.logging.Logger.getLogger(karyawanAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(karyawanAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(karyawanAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(karyawanAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new karyawanAdmin().setVisible(true);
            }
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton28;
    private javax.swing.JButton jButton32;
    private javax.swing.JButton jButton33;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton login;
    private javax.swing.JTable tabel;
    private javax.swing.JTextField txtsearch;
    // End of variables declaration//GEN-END:variables

    
}
