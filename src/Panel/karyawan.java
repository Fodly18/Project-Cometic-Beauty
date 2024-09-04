package panel;
import Koneksi.Conek;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
public class karyawan extends javax.swing.JFrame {

     String Tanggal;
    public karyawan() {
        initComponents();
        datatable();
        tanggal();
        cmbjabat.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            cmbgajiActionPerformed(evt);
        }
    });
    }
    
    
    private void cmbgajiActionPerformed(java.awt.event.ActionEvent evt) {
    generateAutoNumber();
    
    }
    public void generateAutoNumber() {
    String prefix = "";
    if (cmbjabat.getSelectedItem().equals("Admin")) {
        prefix = "AD-0";
    } else if (cmbjabat.getSelectedItem().equals("Kasir")) {
        prefix = "KSR-0";
    }
    
    int maxId = 0;
    try {
        Statement statement = (Statement) Conek.GetConnection().createStatement();
        ResultSet res = statement.executeQuery("SELECT id FROM jabatan_karyawan WHERE id LIKE '" + prefix + "%'");
        while (res.next()) {
            String id = res.getString("id");
            int num = Integer.parseInt(id.substring(prefix.length()));
            if (num > maxId) {
                maxId = num;
            }
        }
        maxId++;
        txtid.setText(prefix + String.format("%02d", maxId));
    } catch (Exception e) {
        JOptionPane.showMessageDialog(rootPane, "Error generating auto number");
    }
}
    
    private void Clear(){
        txtid.setText("");
        txtnama.setText("");
        txtgaji.setText("");
        txuser.setText("");
        txpass.setText("");
        txtid.enable(true);
    }
    public void tanggal(){
        Date now = new Date();
        txtdate.setDate(now);
        txtdate.setEnabled(false);
    }
   public void datatable() {
        DefaultTableModel tbl = new DefaultTableModel();
        tbl.addColumn("Id_Karyawan");
        tbl.addColumn("Nama Karyawan");
        tbl.addColumn("Tgl_Keterima");
        tbl.addColumn("Jabatan");
        tbl.addColumn("Gaji");
        tbl.addColumn("Username");
        tbl.addColumn("Password");
        tabel.setModel(tbl);
        try {
            Statement statement = (Statement) Conek.GetConnection().createStatement();
            ResultSet res = statement.executeQuery("SELECT * FROM jabatan_karyawan");
            while (res.next()) {
                tbl.addRow(new Object[]{
                    res.getString("id"),
                    res.getString("nama"),
                    res.getString("tgl_keterima"),
                    res.getString("jabatan"),
                    res.getString("gaji"),
                    res.getString("Username"),
                    res.getString("Password")
                });
            }
            res.close();
            statement.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Error memuat data: " + e.getMessage());
        }
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        btn_simpan = new javax.swing.JButton();
        btn_edit = new javax.swing.JButton();
        btn_hapus = new javax.swing.JButton();
        txtid = new javax.swing.JTextField();
        txtnama = new javax.swing.JTextField();
        txtgaji = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        cmbjabat = new javax.swing.JComboBox<>();
        txtdate = new com.toedter.calendar.JDateChooser();
        txpass = new javax.swing.JTextField();
        txuser = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        txtsearch = new javax.swing.JTextField();
        btncari = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtgaji1 = new javax.swing.JTextField();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
                "Id", "Nama", "Tanggal Diterima", "Jabatan", "Gaji"
            }
        ));
        tabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabel);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 590, 270));

        btn_simpan.setText("Simpan");
        btn_simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_simpanActionPerformed(evt);
            }
        });
        add(btn_simpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 190, -1, -1));

        btn_edit.setText("Edit");
        btn_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editActionPerformed(evt);
            }
        });
        add(btn_edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 190, -1, -1));

        btn_hapus.setText("Hapus");
        btn_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapusActionPerformed(evt);
            }
        });
        add(btn_hapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 190, -1, -1));
        add(txtid, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 210, -1));
        add(txtnama, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, 210, -1));

        txtgaji.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtgajiActionPerformed(evt);
            }
        });
        add(txtgaji, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, 210, -1));

        jLabel17.setForeground(new java.awt.Color(0, 0, 0));
        jLabel17.setText("Id");
        add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 70, -1, -1));

        jLabel21.setForeground(new java.awt.Color(0, 0, 0));
        jLabel21.setText("Nama");
        add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, -1, -1));

        jLabel20.setForeground(new java.awt.Color(0, 0, 0));
        jLabel20.setText("Gaji");
        add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 190, -1, -1));

        jPanel2.setBackground(new java.awt.Color(255, 204, 204));
        jPanel2.setForeground(new java.awt.Color(255, 204, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cmbjabat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "Kasir" }));
        jPanel2.add(cmbjabat, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 160, 210, -1));
        jPanel2.add(txtdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 130, 210, -1));

        txpass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txpassActionPerformed(evt);
            }
        });
        jPanel2.add(txpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 110, 150, -1));
        jPanel2.add(txuser, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 70, 150, -1));

        jLabel3.setText("Password");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 110, 70, -1));

        jLabel18.setForeground(new java.awt.Color(0, 0, 0));
        jLabel18.setText("Id");
        jPanel2.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, -1, -1));

        jLabel19.setForeground(new java.awt.Color(0, 0, 0));
        jLabel19.setText("Jabatan");
        jPanel2.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 160, -1, -1));

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Username");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 70, 70, -1));

        jLabel24.setForeground(new java.awt.Color(0, 0, 0));
        jLabel24.setText("Tanggal Diterima");
        jPanel2.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 130, -1, -1));

        jLabel22.setForeground(new java.awt.Color(0, 0, 0));
        jLabel22.setText("Nama");
        jPanel2.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 100, -1, -1));

        jLabel23.setForeground(new java.awt.Color(0, 0, 0));
        jLabel23.setText("Gaji");
        jPanel2.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 190, -1, -1));

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
        jPanel2.add(txtsearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, 350, 30));

        btncari.setText("Cari");
        btncari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncariActionPerformed(evt);
            }
        });
        jPanel2.add(btncari, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 10, 60, 30));

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel26.setText("Admin");
        jPanel2.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 10, 40, 30));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/[removal 10.png"))); // NOI18N
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 0, 50, -1));

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-180, 0, 820, 530));

        txtgaji1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtgaji1ActionPerformed(evt);
            }
        });
        add(txtgaji1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, 210, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void tabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelMouseClicked
        int baris = tabel.rowAtPoint(evt.getPoint());
        String id = tabel.getValueAt(baris, 0).toString();
        txtid.setText(id);
        String nama = tabel.getValueAt(baris, 1).toString();
        txtnama.setText(nama);
        String jabatan = tabel.getValueAt(baris, 3).toString();
        cmbjabat.setSelectedItem(jabatan);
        String gaji = tabel.getValueAt(baris, 4).toString();
        txtgaji.setText(gaji);
        String Username = tabel.getValueAt(baris, 5).toString();
        txuser.setText(Username);
        String Password = tabel.getValueAt(baris, 6).toString();
        txpass.setText(Password);

        // Ensure the correct format of date is set
        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(tabel.getValueAt(baris, 2).toString());
            txtdate.setDate(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_tabelMouseClicked

    private void txtsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsearchActionPerformed

    private void txtsearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtsearchKeyReleased
        // TODO add your handling code here:
        DefaultTableModel cari=(DefaultTableModel) tabel.getModel();
        TableRowSorter<DefaultTableModel> obj=new TableRowSorter<>(cari);
        tabel.setRowSorter(obj);
        obj.setRowFilter(RowFilter.regexFilter(txtsearch.getText()));
    }//GEN-LAST:event_txtsearchKeyReleased

    private void btncariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncariActionPerformed
        // TODO add your handling code here:
        DefaultTableModel cari=(DefaultTableModel) tabel.getModel();
        TableRowSorter<DefaultTableModel> obj=new TableRowSorter<>(cari);
        tabel.setRowSorter(obj);
        obj.setRowFilter(RowFilter.regexFilter(txtsearch.getText()));
    }//GEN-LAST:event_btncariActionPerformed

    private void btn_simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_simpanActionPerformed
        generateAutoNumber();
        String idkar = txtid.getText();
        String Nama = txtnama.getText();
        String Jabatan = (String)cmbjabat.getSelectedItem();
        String Gaji = txtgaji.getText();
        String Username = txuser.getText();
        String password = txpass.getText();
        if (txtdate.getDate() !=null){
            String p = "yyyy-MM-dd";
            SimpleDateFormat sd = new SimpleDateFormat(p);
            Tanggal = String.valueOf(sd.format(txtdate.getDate()));
        }

        try {
            Statement statement = (Statement) Conek.GetConnection().createStatement();
            statement.executeUpdate("insert into jabatan_karyawan VALUES ('" + idkar + "','" + Nama + "',"
                + "'" + Tanggal + "','" + Jabatan + "','" + Gaji + "','"+Username+"','"+password+"');");
            statement.close();
            JOptionPane.showMessageDialog(null, "Data Berhasil tersimpan");
        } catch (Exception t) {
            JOptionPane.showMessageDialog(null, "Data Gagal disimpan");
        }
        datatable();
        Clear();
    }//GEN-LAST:event_btn_simpanActionPerformed

    private void btn_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editActionPerformed
        // TODO add your handling code here:
        if (txtdate.getDate() !=null){
            String p = "yyyy-MM-dd";
            SimpleDateFormat sd = new SimpleDateFormat(p);
            Tanggal = String.valueOf(sd.format(txtdate.getDate()));
        }
        try {
            Statement statement = (Statement) Conek.GetConnection().createStatement();
            statement.executeUpdate("UPDATE jabatan_karyawan SET nama='" + txtnama.getText() + "', tgl_keterima='" + Tanggal + "',"
                + " jabatan='" + cmbjabat.getSelectedItem() + "', gaji='" + txtgaji.getText() + "', Username='"+ txuser.getText()+ "',Password='"+ txpass.getText()+ "' WHERE id='" + txtid.getText() + "'");
            statement.close();
            JOptionPane.showMessageDialog(this, "Berhasil Dirubah");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Gagal Dirubah");
        }
        datatable();
        Clear();
    }//GEN-LAST:event_btn_editActionPerformed

    private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusActionPerformed
        // TODO add your handling code here:
        String id = txtid.getText();
        if (id.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Pilih data yang ingin dihapus");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin menghapus data ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            try {
                Statement statement = (Statement) Conek.GetConnection().createStatement();
                int rowsDeleted = statement.executeUpdate("DELETE from jabatan_karyawan where id='" + id + "'");
                if (rowsDeleted > 0) {
                    JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
                } else {
                    JOptionPane.showMessageDialog(null, "Data tidak ditemukan atau sudah dihapus");
                }
                statement.close();
            } catch (Exception t) {
                JOptionPane.showMessageDialog(null, "Data gagal dihapus: " + t.getMessage());
            }
            datatable();
            Clear();// Memuat ulang data di tabel
        }
    }//GEN-LAST:event_btn_hapusActionPerformed

    private void txtgajiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtgajiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtgajiActionPerformed

    private void txtgaji1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtgaji1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtgaji1ActionPerformed

    private void txpassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txpassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txpassActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_edit;
    private javax.swing.JButton btn_hapus;
    private javax.swing.JButton btn_simpan;
    private javax.swing.JButton btncari;
    private javax.swing.JComboBox<String> cmbjabat;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabel;
    private javax.swing.JTextField txpass;
    private com.toedter.calendar.JDateChooser txtdate;
    private javax.swing.JTextField txtgaji;
    private javax.swing.JTextField txtgaji1;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtnama;
    private javax.swing.JTextField txtsearch;
    private javax.swing.JTextField txuser;
    // End of variables declaration//GEN-END:variables
}
