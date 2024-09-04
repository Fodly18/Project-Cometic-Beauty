
package Panel;
import Koneksi.Conek;

import java.sql.*;
import Koneksi.Conek;
import java.text.SimpleDateFormat;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class supplier extends javax.swing.JFrame {
String Tanggal;
String Tanggal1;

    /**
     * Creates new form DataProdukKasir
     */
    public supplier() {
        initComponents();
        datatable();
    }
    
     private String generateKodeBarang() {
    String kodeBarang = "BRG"; // Prefiks
    int number = 0;
     try {
        Connection conn = Conek.GetConnection();
        Statement statement = conn.createStatement();
        ResultSet res = statement.executeQuery("SELECT COUNT(*) FROM barang");
        
        if (res.next()) {
            number = res.getInt(1) + 1; // Menambah 1 dari total barang yang ada
        }
        
        res.close();
        statement.close();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(rootPane, "Error: " + e.getMessage());
    }

    // Menggabungkan prefiks dengan angka
    return kodeBarang + String.format("%04d", number); // BRG0001, BRG0002, dst.
}
    
      private void clear() {
    txtnamabarang.setText("");
    txtharga.setText("");
    txtstok.setText("");
    cmbjenis.setSelectedIndex(0); // Mengatur combobox ke nilai default, asumsi index 0 adalah nilai default
    txtdate.setDate(null); // Mengatur tanggal ke null
}
     
     
     public void tanggal(){
    java.util.Date now = new java.util.Date();
    txtdate.setDate(now);
    txtdate.setEnabled(false);
    
    
    
    }
    public void datatable(){
        DefaultTableModel tbl=new DefaultTableModel();
        tbl.addColumn("Kode Barang");
        tbl.addColumn("Nama Barang");
        tbl.addColumn("Harga");
        tbl.addColumn("Stok");
        tbl.addColumn("Jenis");
        tbl.addColumn("Expired");
        tabel.setModel(tbl);
        try{
            Statement statement=(Statement)Conek.GetConnection().createStatement();
            ResultSet res=statement.executeQuery("SELECT * FROM barang");
            while(res.next())
            {
                tbl.addRow(new Object[]{
                    res.getString("Kode_barang"),
                    res.getString("Nama_barang"),
                    res.getString("Harga"),
                    res.getString("Stok"),
                    res.getString("Jenis"),
                    res.getString("Expied")
                });
            }
         res.close();
        statement.close();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(rootPane, "Error: " + e.getMessage());
    }

    }
    
    void bersih(){
      txt_search.setText("Search");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmbjenis = new javax.swing.JComboBox<>();
        jButton6 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        btnkutek = new javax.swing.JButton();
        btnlipstik = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        txtharga = new javax.swing.JTextField();
        txtkodebarang = new javax.swing.JTextField();
        txtnamabarang = new javax.swing.JTextField();
        txtstok = new javax.swing.JTextField();
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

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cmbjenis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Padat", "Cair" }));
        getContentPane().add(cmbjenis, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 290, -1, -1));

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Group 9.png"))); // NOI18N
        jButton6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButton6.setBorderPainted(false);
        jButton6.setContentAreaFilled(false);
        jButton6.setFocusPainted(false);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 60, 90, 90));

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Group 8.png"))); // NOI18N
        jButton5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButton5.setBorderPainted(false);
        jButton5.setContentAreaFilled(false);
        jButton5.setFocusPainted(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 60, 90, 90));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Group 17.png"))); // NOI18N
        jButton3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButton3.setBorderPainted(false);
        jButton3.setContentAreaFilled(false);
        jButton3.setFocusPainted(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 60, 90, 90));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Group 10.png"))); // NOI18N
        jButton2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setFocusPainted(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 60, 90, 90));

        btnkutek.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Group 18.png"))); // NOI18N
        btnkutek.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnkutek.setBorderPainted(false);
        btnkutek.setContentAreaFilled(false);
        btnkutek.setFocusPainted(false);
        btnkutek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnkutekActionPerformed(evt);
            }
        });
        getContentPane().add(btnkutek, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, 90, 90));

        btnlipstik.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Group 20.png"))); // NOI18N
        btnlipstik.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnlipstik.setBorderPainted(false);
        btnlipstik.setContentAreaFilled(false);
        btnlipstik.setFocusPainted(false);
        btnlipstik.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlipstikActionPerformed(evt);
            }
        });
        getContentPane().add(btnlipstik, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, 90));

        jLabel5.setBackground(new java.awt.Color(51, 51, 51));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Rectangle 50.png"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 580, 170));
        getContentPane().add(txtharga, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 230, 200, -1));

        txtkodebarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtkodebarangActionPerformed(evt);
            }
        });
        getContentPane().add(txtkodebarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, 200, -1));

        txtnamabarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnamabarangActionPerformed(evt);
            }
        });
        getContentPane().add(txtnamabarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 200, 200, -1));

        txtstok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtstokActionPerformed(evt);
            }
        });
        getContentPane().add(txtstok, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 260, 200, -1));

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

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-190, 0, 820, 540));
    }// </editor-fold>//GEN-END:initComponents

    private void txt_searchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_searchFocusGained
        // TODO add your handling code here:
        String Search=txt_search.getText();
        if(Search.equals("Search")){
            txt_search.setText("");
        }
    }//GEN-LAST:event_txt_searchFocusGained

    private void txt_searchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_searchFocusLost
        String Search=txt_search.getText();
        if(Search.equals("")||Search.equals("Search")){
            txt_search.setText("Search");
        }
    }//GEN-LAST:event_txt_searchFocusLost

    private void txt_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_searchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_searchActionPerformed

    private void txt_searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_searchKeyReleased
        // TODO add your handling code here:
        DefaultTableModel cari=(DefaultTableModel) tabel.getModel();
        TableRowSorter<DefaultTableModel> obj=new TableRowSorter<>(cari);
        tabel.setRowSorter(obj);
        obj.setRowFilter(RowFilter.regexFilter(txt_search.getText()));
    }//GEN-LAST:event_txt_searchKeyReleased

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnkutekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnkutekActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnkutekActionPerformed

    private void btnlipstikActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlipstikActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnlipstikActionPerformed

    private void tabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelMouseClicked
        // TODO add your handling code here:
        int baris = tabel.rowAtPoint(evt.getPoint());
        String kodebarang = tabel.getValueAt(baris, 0).toString();
        txtkodebarang.setText(kodebarang);
        String namabarang = tabel.getValueAt(baris, 1).toString();
        txtnamabarang.setText(namabarang);
        String harga = tabel.getValueAt(baris, 2).toString();
        txtharga.setText(harga);
        String stok = tabel.getValueAt(baris, 3).toString();
        txtstok.setText(stok);
        String jenis = tabel.getValueAt(baris, 4).toString();
        cmbjenis.getSelectedItem();

        try {
            java.util.Date date = new SimpleDateFormat("yyyy-MM-dd").parse(tabel.getValueAt(baris, 5).toString());
            txtdate.setDate(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_tabelMouseClicked

    private void btncariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncariActionPerformed
        DefaultTableModel cari=(DefaultTableModel) tabel.getModel();
        TableRowSorter<DefaultTableModel> obj=new TableRowSorter<>(cari);
        tabel.setRowSorter(obj);
        obj.setRowFilter(RowFilter.regexFilter(txt_search.getText()));

    }//GEN-LAST:event_btncariActionPerformed

    private void txtkodebarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtkodebarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtkodebarangActionPerformed

    private void txtnamabarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnamabarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnamabarangActionPerformed

    private void txtstokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtstokActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtstokActionPerformed

    private void btnsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsimpanActionPerformed
        // TODO add your handling code here:
        String kodebarang = txtkodebarang.getText();
        String namabarang = txtnamabarang.getText();
        String harga = txtharga.getText();
        String stok = txtstok.getText();
        String jenis = (String) cmbjenis.getSelectedItem();
        String keterangan = txtket.getText();
        if (txtdate.getDate() !=null){
            String p = "yyyy-MM-dd";
            SimpleDateFormat sd = new SimpleDateFormat(p);
            Tanggal = String.valueOf(sd.format(txtdate.getDate()));
        }

        try{
            Statement statement = (Statement) Conek.GetConnection().createStatement();
            statement.executeUpdate("insert into barang VALUES ('"+ kodebarang +"','"+ namabarang +"'"
                + ",'"+ harga+"','"+stok +"','"+jenis +"','"+Tanggal+"');");
            statement.close();
            JOptionPane.showMessageDialog(null, "Data Barang Berhasil tersimpan");
        }catch (Exception t){
            JOptionPane.showMessageDialog(null, "Data Barang Gagal disimpan");
        }
        if (txtdate.getDate() !=null){
            String p = "yyyy-MM-dd";
            SimpleDateFormat sd = new SimpleDateFormat(p);
            Tanggal1 = String.valueOf(sd.format(txt_tglmasuk.getDate()));
        }
        try {

            Connection c = Conek.GetConnection();
            int baris = tabel.getRowCount();

            for (int i = 0; i < baris; i++) {
                String sql = "INSERT INTO riwayat(kode_barang, nama_barang, harga, stok, jenis, tanggal_masuk, keterangan) VALUES('"
                + tabel.getValueAt(i, 0) +"','"+ tabel.getValueAt(i, 1)
                +"','"+ tabel.getValueAt(i, 2) +"','"+ tabel.getValueAt(i, 3) +"','"+ tabel.getValueAt(i, 4)
                +Tanggal1 +"','"+ tabel.getValueAt(i, 6)+"')";
                PreparedStatement p = c.prepareStatement(sql);
                p.executeUpdate();
                p.close();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        datatable();
    }//GEN-LAST:event_btnsimpanActionPerformed

    private void btneditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditActionPerformed
        // TODO add your handling code here:
         // Mendapatkan indeks baris yang dipilih dari JTable
    int selectedRow = tabel.getSelectedRow();
    
    // Pastikan ada baris yang dipilih
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(this, "Pilih baris yang ingin diedit terlebih dahulu.");
        return;
    }

    // Mendapatkan nilai Kode_barang dari baris yang dipilih
    String kodebarang = (String) tabel.getValueAt(selectedRow, 0); // Asumsikan kolom 0 adalah Kode_barang

    try {
        // Buat koneksi dan statement
        Connection conn = Conek.GetConnection();
        Statement statement = conn.createStatement();

        // Mendapatkan nilai dari form input yang diubah
        String namabarang = txtnamabarang.getText();
        String harga = txtharga.getText();
        String stok = txtstok.getText();
        String jenis = (String) cmbjenis.getSelectedItem();
        String tanggal = "";

        if (txtdate.getDate() != null) {
            SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
            tanggal = sd.format(txtdate.getDate());
        }

        // Jalankan query UPDATE hanya untuk nilai yang diubah
        String query = "UPDATE barang SET ";
        boolean dataChanged = false;
        
        if (!namabarang.isEmpty()) {
            query += "Nama_barang='" + namabarang + "', ";
            dataChanged = true;
        }
        if (!harga.isEmpty()) {
            query += "Harga='" + harga + "', ";
            dataChanged = true;
        }
        if (!stok.isEmpty()) {
            query += "Stok='" + stok + "', ";
            dataChanged = true;
        }
        if (jenis != null) {
            query += "Jenis='" + jenis + "', ";
            dataChanged = true;
        }
        if (!tanggal.isEmpty()) {
            query += "Expired='" + tanggal + "', ";
            dataChanged = true;
        }
        
        // Hapus koma terakhir
        if (dataChanged) {
            query = query.substring(0, query.length() - 2);
        }

        // Tambahkan kondisi WHERE
        query += " WHERE Kode_barang='" + kodebarang + "'";

        // Jalankan query UPDATE jika ada perubahan data
        if (dataChanged) {
            int updatedRows = statement.executeUpdate(query);
            
            if (updatedRows > 0) {
                JOptionPane.showMessageDialog(this, "Data Berhasil Diubah");
            } else {
                JOptionPane.showMessageDialog(this, "Data tidak ditemukan atau gagal diubah");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Tidak ada data yang diubah");
        }

        // Tutup statement dan koneksi
        statement.close();
        conn.close();

        // Perbarui data tabel
        datatable();
    } catch (Exception e) {
        // Tampilkan pesan jika terjadi kesalahan
        JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat mengubah data: " + e.getMessage());
    }
    
    }//GEN-LAST:event_btneditActionPerformed

    private void hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusActionPerformed
        // TODO add your handling code here:

        String kodebarang = txtkodebarang.getText();
        try {
            Statement statement = (Statement) Conek.GetConnection().createStatement();
            int confirm = JOptionPane.showConfirmDialog(this, "Yakin Ingin Menghapus Data ?",
                "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (confirm == JOptionPane.YES_OPTION) {
                // Jalankan query DELETE
                int deletedRows = statement.executeUpdate("DELETE FROM barang WHERE Kode_barang = '" + kodebarang + "'");
                if (deletedRows > 0) {
                    JOptionPane.showMessageDialog(this, "Data Berhasil Dihapus");
                } else {
                    JOptionPane.showMessageDialog(this, "Data tidak ditemukan atau gagal dihapus");
                }
            }
            statement.close();
        } catch (Exception t) {
            // Tampilkan pesan jika terjadi kesalahan
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan saat menghapus data: " + t.getMessage());
        }
        // Panggil method datatable() untuk memperbarui tampilan data
        datatable();

    }//GEN-LAST:event_hapusActionPerformed

    private void pindahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pindahActionPerformed
        int selectedRow = tabel.getSelectedRow();
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(this, "Pilih baris yang ingin dipindahkan terlebih dahulu.");
        return;
}

        String kodeBarang = (String) tabel.getValueAt(selectedRow, 0); // Asumsikan kolom 0 adalah Kode_Barang

    // Memindahkan data ke tabel tbldiskon
    Connection conn = null;
    PreparedStatement pstSelect = null;
    PreparedStatement pstInsert = null;
    PreparedStatement pstDelete = null;
    ResultSet rs = null;

        try {
    conn = Conek.GetConnection();

    // 1. Pilih data dari tabel barang
    String sqlSelect = "SELECT * FROM barang WHERE Kode_Barang = ?";
    pstSelect = conn.prepareStatement(sqlSelect);
    pstSelect.setString(1, kodeBarang);
    rs = pstSelect.executeQuery();

    if (rs.next()) {
        // 2. Cek apakah data sudah ada di tabel tbldiskon
        String sqlCheck = "SELECT COUNT(*) FROM tbldiskon WHERE Kode_Barang = ?";
        PreparedStatement pstCheck = conn.prepareStatement(sqlCheck);
        pstCheck.setString(1, kodeBarang);
        ResultSet rsCheck = pstCheck.executeQuery();
        rsCheck.next();
        int count = rsCheck.getInt(1);
        rsCheck.close();
        pstCheck.close();

        if (count == 0) {
            // 3. Sisipkan data ke tabel tbldiskon jika belum ada
            String sqlInsert = "INSERT INTO tbldiskon (Kode_Barang, Nama_Barang, Harga, Stock, Jenis, Expired) VALUES (?, ?, ?, ?, ?, ?)";
            pstInsert = conn.prepareStatement(sqlInsert);
            pstInsert.setString(1, rs.getString("Kode_Barang"));
            pstInsert.setString(2, rs.getString("Nama_Barang"));
            pstInsert.setString(3, rs.getString("Harga"));
            pstInsert.setString(4, rs.getString("Stok"));
            pstInsert.setString(5, rs.getString("Jenis"));
            pstInsert.setString(6, rs.getString("Expired"));
            pstInsert.executeUpdate();
        }

        // 4. Hapus data dari tabel barang
        String sqlDelete = "DELETE FROM barang WHERE Kode_Barang = ?";
        pstDelete = conn.prepareStatement(sqlDelete);
        pstDelete.setString(1, kodeBarang);
        pstDelete.executeUpdate();

        JOptionPane.showMessageDialog(null, "Data berhasil dipindahkan ke tabel diskon.");

        // Perbarui tabel barang
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

    
    }//GEN-LAST:event_pindahActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncari;
    private javax.swing.JButton btnedit;
    private javax.swing.JButton btnkutek;
    private javax.swing.JButton btnlipstik;
    private javax.swing.JButton btnsimpan;
    private javax.swing.JComboBox<String> cmbjenis;
    private javax.swing.JButton hapus;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton pindah;
    private javax.swing.JTable tabel;
    private javax.swing.JTextField txt_search;
    private com.toedter.calendar.JDateChooser txt_tglmasuk;
    private com.toedter.calendar.JDateChooser txtdate;
    private javax.swing.JTextField txtharga;
    private javax.swing.JTextField txtket;
    private javax.swing.JTextField txtkodebarang;
    private javax.swing.JTextField txtnamabarang;
    private javax.swing.JTextField txtstok;
    // End of variables declaration//GEN-END:variables
}
