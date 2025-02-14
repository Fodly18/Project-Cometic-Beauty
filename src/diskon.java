import Koneksi.Conek;
import java.sql.*;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class diskon extends javax.swing.JFrame {

    /**
     * Creates new form diskon
     */
    public diskon() {
        initComponents();
        datatable();
    }
        
    public void datatable(){
        DefaultTableModel tbl=new DefaultTableModel();
        tbl.addColumn("Kode Barang");
        tbl.addColumn("Nama Barang");
        tbl.addColumn("Harga");
        tbl.addColumn("Stok");
        tbl.addColumn("Jenis");
        tbl.addColumn("Expired");
        tabelD.setModel(tbl);
        
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
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelD = new javax.swing.JTable();
        jLabel19 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Tambah = new javax.swing.JButton();
        Diskon = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jButton27 = new javax.swing.JButton();
        jButton25 = new javax.swing.JButton();
        jButton31 = new javax.swing.JButton();
        jButton30 = new javax.swing.JButton();
        jButton33 = new javax.swing.JButton();
        jButton34 = new javax.swing.JButton();
        jButton32 = new javax.swing.JButton();
        login = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 204, 204));
        jPanel2.setForeground(new java.awt.Color(255, 204, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabelD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Kode Barang", "Nama Barang", "Harga", "Stok", "Jenis", "Title 6"
            }
        ));
        tabelD.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tabelDFocusGained(evt);
            }
        });
        jScrollPane1.setViewportView(tabelD);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 590, 240));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel19.setText("Admin");
        jPanel2.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 10, 40, 30));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/[removal 10.png"))); // NOI18N
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 0, 50, -1));

        Tambah.setText("Tambah");
        Tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TambahActionPerformed(evt);
            }
        });
        jPanel2.add(Tambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 300, 80, -1));

        Diskon.setText("Diskon");
        Diskon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DiskonActionPerformed(evt);
            }
        });
        jPanel2.add(Diskon, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 300, 80, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, 620, 520));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/[removal 35.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 120));

        jPanel3.setBackground(new java.awt.Color(255, 153, 153));
        jPanel3.setForeground(new java.awt.Color(255, 153, 153));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Group 1.png"))); // NOI18N
        jButton27.setBorderPainted(false);
        jButton27.setContentAreaFilled(false);
        jButton27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton27ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton27, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 150, 40));

        jButton25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Group 6.png"))); // NOI18N
        jButton25.setBorderPainted(false);
        jButton25.setContentAreaFilled(false);
        jButton25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton25ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton25, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 150, 40));

        jButton31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Group 4 (2).png"))); // NOI18N
        jButton31.setBorderPainted(false);
        jButton31.setContentAreaFilled(false);
        jButton31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton31ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton31, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 150, 40));

        jButton30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Group 5.png"))); // NOI18N
        jButton30.setBorderPainted(false);
        jButton30.setContentAreaFilled(false);
        jButton30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton30ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton30, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 150, 40));

        jButton33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Group 59.png"))); // NOI18N
        jButton33.setBorderPainted(false);
        jButton33.setContentAreaFilled(false);
        jButton33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton33ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton33, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 150, 40));

        jButton34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Group 61.png"))); // NOI18N
        jButton34.setBorderPainted(false);
        jButton34.setContentAreaFilled(false);
        jButton34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton34ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton34, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 150, 40));

        jButton32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Group 63.png"))); // NOI18N
        jButton32.setBorderPainted(false);
        jButton32.setContentAreaFilled(false);
        jButton32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton32ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton32, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 150, 40));

        login.setBackground(new java.awt.Color(255, 51, 51));
        login.setForeground(new java.awt.Color(255, 255, 255));
        login.setText("LOGOUT");
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });
        jPanel3.add(login, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 480, 160, 30));

        jButton2.setBackground(new java.awt.Color(220, 218, 218));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Group 95 (2).png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 150, 30));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 520));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tabelDFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tabelDFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_tabelDFocusGained

    private void TambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TambahActionPerformed
        int selectedRow = tabelD.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Pilih baris yang ingin dipindahkan terlebih dahulu.");
            return;
        }

        String kodeBarang = (String) tabelD.getValueAt(selectedRow, 0); // Asumsikan kolom 0 adalah Kode_Barang

        // Memindahkan data ke tabel barang
        Connection conn = null;
        PreparedStatement pstSelect = null;
        PreparedStatement pstInsert = null;
        PreparedStatement pstDelete = null;
        ResultSet rs = null;

        try {
            conn = Conek.GetConnection();

            // 1. Pilih data dari tabel tbldiskon
            String sqlSelect = "SELECT * FROM tbldiskon WHERE Kode_Barang = ?";
            pstSelect = conn.prepareStatement(sqlSelect);
            pstSelect.setString(1, kodeBarang);
            rs = pstSelect.executeQuery();

            if (rs.next()) {
                // 2. Cek apakah data sudah ada di tabel barang
                String sqlCheck = "SELECT COUNT(*) FROM barang WHERE Kode_Barang = ?";
                PreparedStatement pstCheck = conn.prepareStatement(sqlCheck);
                pstCheck.setString(1, kodeBarang);
                ResultSet rsCheck = pstCheck.executeQuery();
                rsCheck.next();
                int count = rsCheck.getInt(1);
                rsCheck.close();
                pstCheck.close();

                if (count == 0) {
                    // 3. Sisipkan data ke tabel barang jika belum ada
                    String sqlInsert = "INSERT INTO barang (Kode_Barang, Nama_Barang, Harga, Stok, Jenis, Expired) VALUES (?, ?, ?, ?, ?, ?)";
                    pstInsert = conn.prepareStatement(sqlInsert);
                    pstInsert.setString(1, rs.getString("Kode_Barang"));
                    pstInsert.setString(2, rs.getString("Nama_Barang"));
                    pstInsert.setString(3, rs.getString("Harga"));
                    pstInsert.setString(4, rs.getString("Stock"));
                    pstInsert.setString(5, rs.getString("Jenis"));
                    pstInsert.setString(6, rs.getString("Expired"));
                    pstInsert.executeUpdate();
                }

                // 4. Hapus data dari tabel tbldiskon
                String sqlDelete = "DELETE FROM tbldiskon WHERE Kode_Barang = ?";
                pstDelete = conn.prepareStatement(sqlDelete);
                pstDelete.setString(1, kodeBarang);
                pstDelete.executeUpdate();

                JOptionPane.showMessageDialog(null, "Data berhasil dipindahkan ke tabel barang.");

                // Perbarui tabel diskon
                datatable();
            } else {
                JOptionPane.showMessageDialog(null, "Data tidak ditemukan.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan saat memindahkan data: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstSelect != null) pstSelect.close();
                if (pstInsert != null) pstInsert.close();
                if (pstDelete != null) pstDelete.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Terjadi kesalahan saat menutup koneksi: " + e.getMessage());
            }

        }

    }//GEN-LAST:event_TambahActionPerformed

    private void DiskonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DiskonActionPerformed
        try {
            // Dapatkan nilai diskon dari pengguna
            int diskon = Integer.parseInt(JOptionPane.showInputDialog("Masukkan nilai diskon (dalam persen): "));

            // Ambil indeks baris yang dipilih dari tabel
            int selectedRow = tabelD.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(rootPane, "Pilih barang terlebih dahulu!");
                return;
            }

            // Ambil harga dari tabel
            double harga = Double.parseDouble(tabelD.getValueAt(selectedRow, 2).toString());

            // Hitung harga baru setelah diskon
            double hargaSetelahDiskon = harga - (harga * (diskon / 100.0));

            // Konversi harga setelah diskon ke integer
            int hargaInteger = (int) Math.round(hargaSetelahDiskon);

            // Perbarui harga dalam tabel
            tabelD.setValueAt(hargaInteger, selectedRow, 2);

            // Perbarui harga dalam database (jika diperlukan)
            Connection conn = Conek.GetConnection();
            if (conn == null) {
                throw new SQLException("Gagal terhubung ke database.");
            }

            PreparedStatement statement = conn.prepareStatement("UPDATE tbldiskon SET Harga = ? WHERE Kode_Barang = ?");
            statement.setInt(1, hargaInteger);
            statement.setString(2, tabelD.getValueAt(selectedRow, 0).toString());
            statement.executeUpdate();

            JOptionPane.showMessageDialog(rootPane, "Diskon berhasil diterapkan!");

            statement.close();
            conn.close();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(rootPane, "Masukkan nilai diskon dalam format yang benar!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(rootPane, "Error: " + e.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Unexpected Error: " + e.getMessage());
        }

    }//GEN-LAST:event_DiskonActionPerformed

    private void jButton27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton27ActionPerformed
        this.setVisible(false);
        new Dashboard_admin().setVisible(true);
    }//GEN-LAST:event_jButton27ActionPerformed

    private void jButton25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton25ActionPerformed
        this.setVisible(false);
        new JabatanKaryawan().setVisible(true);
    }//GEN-LAST:event_jButton25ActionPerformed

    private void jButton31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton31ActionPerformed
        this.setVisible(false);
        new DataProdukAdmin2().setVisible(true);
    }//GEN-LAST:event_jButton31ActionPerformed

    private void jButton30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton30ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new laporanSupervisor().setVisible(true);
    }//GEN-LAST:event_jButton30ActionPerformed

    private void jButton33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton33ActionPerformed
        this.setVisible(false);
        new RiwayatPembelianAdmin().setVisible(true);
    }//GEN-LAST:event_jButton33ActionPerformed

    private void jButton34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton34ActionPerformed
       this.setVisible(false);
        new pengeluaran().setVisible(true);
    }//GEN-LAST:event_jButton34ActionPerformed

    private void jButton32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton32ActionPerformed
        this.setVisible(false);
        new DataSupplier().setVisible(true);
    }//GEN-LAST:event_jButton32ActionPerformed

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed
        int confirm = JOptionPane.showConfirmDialog(this, "Apakah Anda yakin ingin logout?", "Konfirmasi Logout", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            this.setVisible(false);
            new login_admin().setVisible(true);
        }
    }//GEN-LAST:event_loginActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.setVisible(false);
        new diskon().setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new diskon().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Diskon;
    private javax.swing.JButton Tambah;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton30;
    private javax.swing.JButton jButton31;
    private javax.swing.JButton jButton32;
    private javax.swing.JButton jButton33;
    private javax.swing.JButton jButton34;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton login;
    private javax.swing.JTable tabelD;
    // End of variables declaration//GEN-END:variables
}
