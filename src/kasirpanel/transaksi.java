
package kasirpanel;
import Koneksi.Conek;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static kasirpanel.transaksi.txharga;
import static kasirpanel.transaksi.txjenis;
import static kasirpanel.transaksi.txkodeb;
import static kasirpanel.transaksi.txnamab;

public class transaksi extends javax.swing.JFrame {

     String Tanggal;
    private DefaultTableModel model;
 
    public void totalBiaya() {
    int jumlahBaris = table.getRowCount();
        int totalBiaya = 0;
        int jumlahBarang, hargaBarang;
        for (int i = 0; i < jumlahBaris; i++) {
            jumlahBarang = Integer.parseInt(table.getValueAt(i, 5).toString());
            hargaBarang = Integer.parseInt(table.getValueAt(i, 4).toString());
            totalBiaya = totalBiaya + (jumlahBarang * hargaBarang);
        }
        txtotal.setText(String.valueOf(totalBiaya));
        txtampil.setText("Rp "+ totalBiaya +",00");
    }
    public void tanggal(){
        Date now = new Date();
        jDate.setDate(now);
        jDate.setEnabled(false);
        txkodet.setEnabled(false);
        txharga.setEnabled(false);
        txkodeb.setEnabled(false);
        txtotal.setEnabled(false);
        txkembalian.setEnabled(false);
        txtampil.setEnabled(false);
    }

    
    private void autonumber(){
        try {
            Connection c = Conek.GetConnection();
            Statement s = c.createStatement();
            String sql = "SELECT * FROM transaksikw ORDER BY kode_transaksi DESC";
            ResultSet r = s.executeQuery(sql);
            if (r.next()) {
                String kode_transaksi = r.getString("kode_transaksi").substring(2);
                String TR = "" +(Integer.parseInt(kode_transaksi)+1);
                String Nol = "";
                
                if(TR.length()==1)
                {Nol = "000";}
                else if(TR.length()==2)
                {Nol = "00";}
                else if(TR.length()==3)
                {Nol = "0";}
                else if(TR.length()==4)
                {Nol = "";}
                txkodet.setText("TR" + Nol + TR);
            } else {
                txkodet.setText("TR0001");
            }
            r.close();
            s.close();
        } catch (Exception e) {
            System.out.println("autonumber error");
        }
    }
    
     public void autonumber2(){
    try {
            Connection c = Conek.GetConnection();
            Statement s = c.createStatement();
            String sql = "SELECT * FROM transaksikw ORDER BY kode_transaksi DESC";
            ResultSet r = s.executeQuery(sql);
            if (r.next()) {
                String kode_transaksi = r.getString("kode_transaksi").substring(2);
                String TR = "" +(Integer.parseInt(kode_transaksi)+1);
                String Nol = "";
                
                if(TR.length()==1)
                {Nol = "000";}
                else if(TR.length()==2)
                {Nol = "00";}
                else if(TR.length()==3)
                {Nol = "0";}
                else if(TR.length()==4)
                {Nol = "";}
                txprint.setText("TR" + Nol + TR);
            } else {
                txprint.setText("TR0001");
            }
            r.close();
            s.close();
        } catch (Exception e) {
            System.out.println("autonumber error");
        }    
    }
   
   public void loadData() {
    DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.addRow(new Object[]{
            txkodet.getText(),
            txkodeb.getText(),
            txnamab.getText(),
            txjenis.getText(),
            txharga.getText(),
            txjumlah.getText(),
            txtotal.getText()
        });
}




    public void kosong(){
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        
        while (model.getRowCount()>0) {
            model.removeRow(0);
        }
    }
    
    public void utama(){
        txkodet.setText("");
        txkodeb.setText("");
        txnamab.setText("");
        txjenis.setText("");
        txharga.setText("");
        txjumlah.setText("");
        autonumber();
        txkodet.setEnabled(false);
        txtampil.setEnabled(false);
    }
    
    public void clear(){
        txtotal.setText("0");
        txbayar.setText("0");
        txkembalian.setText("0");
        txtampil.setText("0");
    }
    
    public void clear2(){
        txkodeb.setText("");
        txnamab.setText("");
        txjenis.setText("");
        txharga.setText("");
        txjumlah.setText("");
        
    }
    
    public void tambahTransaksi() {
    int jumlah, harga, total;
    
    // Ambil nilai dari input pengguna
    jumlah = Integer.valueOf(txjumlah.getText());
    harga = Integer.valueOf(txharga.getText());
    total = jumlah * harga;
    
    txtotal.setText(String.valueOf(total));
    
    // Mendapatkan model tabel
    DefaultTableModel model = (DefaultTableModel) table.getModel();
    
    // Pencarian apakah item sudah ada dalam tabel
    boolean itemDitemukan = false;
    int baris = model.getRowCount();
    for (int i = 0; i < baris; i++) {
        if (txkodeb.getText().equals(model.getValueAt(i, 1))) {
            // Jika item sudah ada, tambahkan jumlahnya
            int jumlahSebelumnya = Integer.parseInt(model.getValueAt(i, 5).toString());
            int totalSebelumnya = Integer.parseInt(model.getValueAt(i, 6).toString());
            model.setValueAt(jumlahSebelumnya + jumlah, i, 5); // Update jumlah
            model.setValueAt(totalSebelumnya + total, i, 6);   // Update total
            itemDitemukan = true;
            break;
        }
    }
    
    // Jika item belum ada, tambahkan item baru ke dalam tabel
    if (!itemDitemukan) {
        model.addRow(new Object[]{
            txkodet.getText(),
            txkodeb.getText(),
            txnamab.getText(),
            txjenis.getText(),
            txharga.getText(),
            txjumlah.getText(),
            txtotal.getText()
        });
    }
    
    // Hitung ulang total biaya
    totalBiaya();
    
    // Bersihkan input setelah penambahan
    clear2();
    txkodeb.requestFocus();
}



    
    public transaksi() {
        initComponents();
        tanggal();
        
        model = new DefaultTableModel();
        
        table.setModel(model);
        
        model.addColumn("Kode Transaksi");
        model.addColumn("Kode Barang");
        model.addColumn("Nama Barang");
        model.addColumn("Jenis");
        model.addColumn("Harga");
        model.addColumn("Jumlah");
        model.addColumn("Total");
        
        utama();
       
        if (jDate.getDate() !=null){
            String p = "yyyy-MM-dd";
            SimpleDateFormat sd = new SimpleDateFormat(p);
            Tanggal = String.valueOf(sd.format(jDate.getDate()));
        }
        txtotal.setText("0");
        txbayar.setText("0");
        txkembalian.setText("0");
        txkodeb.requestFocus();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txkodet = new javax.swing.JTextField();
        txkodeb = new javax.swing.JTextField();
        txnamab = new javax.swing.JTextField();
        txharga = new javax.swing.JTextField();
        txjumlah = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtotal = new javax.swing.JTextField();
        txbayar = new javax.swing.JTextField();
        txkembalian = new javax.swing.JTextField();
        bttambah = new javax.swing.JButton();
        bthapus = new javax.swing.JButton();
        btsimpan = new javax.swing.JButton();
        txtampil = new javax.swing.JTextField();
        bthitumg = new javax.swing.JButton();
        btcari = new javax.swing.JButton();
        txjenis = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        txprint = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jDate = new com.toedter.calendar.JDateChooser();
        jLabel12 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Kode Transaksi");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        jLabel2.setText("Kode Barang");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        jLabel3.setText("Nama Barang");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        jLabel4.setText("Jenis");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 60, -1, -1));

        jLabel5.setText("Harga");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 90, -1, -1));

        jLabel6.setText("Jumlah");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 120, -1, -1));

        txkodet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txkodetActionPerformed(evt);
            }
        });
        add(txkodet, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, 90, -1));

        txkodeb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txkodebActionPerformed(evt);
            }
        });
        add(txkodeb, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, 90, -1));

        txnamab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txnamabActionPerformed(evt);
            }
        });
        add(txnamab, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, 90, -1));
        add(txharga, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 90, 90, -1));
        add(txjumlah, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 120, 90, -1));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(table);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 560, 120));

        jLabel8.setText("Total Bayar");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, -1, -1));

        jLabel9.setText("Bayar");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 390, -1, -1));

        jLabel10.setText("Kembalian");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 420, -1, -1));
        add(txtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 360, 100, -1));
        add(txbayar, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 390, 100, -1));
        add(txkembalian, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 420, 100, -1));

        bttambah.setText("Tambah");
        bttambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttambahActionPerformed(evt);
            }
        });
        add(bttambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 290, -1, -1));

        bthapus.setText("Hapus");
        bthapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bthapusActionPerformed(evt);
            }
        });
        add(bthapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 290, -1, -1));

        btsimpan.setText("Simpan");
        btsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btsimpanActionPerformed(evt);
            }
        });
        add(btsimpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 290, -1, -1));

        txtampil.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txtampil.setText("Rp.0");
        txtampil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtampilActionPerformed(evt);
            }
        });
        add(txtampil, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 370, 270, 70));

        bthitumg.setText("Hitung");
        bthitumg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bthitumgActionPerformed(evt);
            }
        });
        add(bthitumg, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 390, -1, -1));

        btcari.setText("Cari");
        btcari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btcariActionPerformed(evt);
            }
        });
        add(btcari, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 90, 60, -1));

        txjenis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txjenisActionPerformed(evt);
            }
        });
        add(txjenis, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 60, 90, -1));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel16.setText("Transaksi");
        add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 20, -1, -1));

        jButton1.setText("Print");
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 290, 90, -1));

        txprint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txprintActionPerformed(evt);
            }
        });
        add(txprint, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 290, 130, -1));

        jPanel2.setBackground(new java.awt.Color(255, 204, 204));
        jPanel2.setForeground(new java.awt.Color(255, 204, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setText("Tanggal");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 60, -1, -1));
        jPanel2.add(jDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 80, 140, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setText("Kasir");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 10, 40, 30));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/—Pngtree—avatar icon profile icon member_5247852 3.png"))); // NOI18N
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 0, -1, 50));

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-190, 0, 820, 530));
    }// </editor-fold>//GEN-END:initComponents

    private void txkodetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txkodetActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txkodetActionPerformed

    private void txnamabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txnamabActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txnamabActionPerformed

    private void bttambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttambahActionPerformed
        tambahTransaksi();

        // TODO add your handling code here:
    }//GEN-LAST:event_bttambahActionPerformed

    private void bthapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bthapusActionPerformed
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        int row = table.getSelectedRow();
        model.removeRow(row);
        totalBiaya();
        txbayar.setText("0");
        txkembalian.setText("0");        // TODO add your handling code here:
    }//GEN-LAST:event_bthapusActionPerformed

    private void btsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btsimpanActionPerformed
        DefaultTableModel model = (DefaultTableModel) table.getModel();

        if (jDate.getDate() !=null){
            String p = "yyyy-MM-dd";
            SimpleDateFormat sd = new SimpleDateFormat(p);
            Tanggal = String.valueOf(sd.format(jDate.getDate()));
        }

        String kode_transaksi = txkodet.getText();
        int Total = Integer.parseInt(txtotal.getText());
        try{
            Connection c = Conek.GetConnection();
            String sql = "INSERT INTO transaksikw VALUES ('"+ kode_transaksi +"','"+ Tanggal +"','"+ Total +"')";
            Statement s = c.createStatement();
            s.executeUpdate(sql);

        }catch(Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }

    String bayar = txbayar.getText();
String kembalian = txkembalian.getText();
String Totalbayar = txtotal.getText();

try {
    Connection c = Conek.GetConnection();
    int baris = table.getRowCount();

    String sqlDetail = "INSERT INTO detail_transaksi (kode_transaksi, tanggal, Kode_barang, Nama_barang, Jenis, Harga, jumlah, total, total_bayar, bayar, kembalian) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    PreparedStatement psDetail = c.prepareStatement(sqlDetail);

    for (int i = 0; i < baris; i++) {
        psDetail.setString(1, table.getValueAt(i, 0).toString());
        psDetail.setString(2, Tanggal);
        psDetail.setString(3, table.getValueAt(i, 1).toString());
        psDetail.setString(4, table.getValueAt(i, 2).toString());
        psDetail.setString(5, table.getValueAt(i, 3).toString());
        psDetail.setString(6, table.getValueAt(i, 4).toString());
        psDetail.setString(7, table.getValueAt(i, 5).toString());
        psDetail.setString(8, table.getValueAt(i, 6).toString());
        psDetail.setString(9, Totalbayar);
        psDetail.setString(10, bayar);
        psDetail.setString(11, kembalian);
        psDetail.addBatch();
    }
    psDetail.executeBatch();
    psDetail.close();
} catch (Exception e) {
    JOptionPane.showMessageDialog(this, "Error saat menyimpan ke tabel detail_transaksi: " + e.getMessage());
}
        clear();
        utama();
        autonumber();
        kosong();
        txtampil.setText("Rp. 0");        // TODO add your handling code here:
    }//GEN-LAST:event_btsimpanActionPerformed

    private void txtampilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtampilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtampilActionPerformed

    private void bthitumgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bthitumgActionPerformed
        int total, bayar, kembalian;

        total = Integer.valueOf(txtotal.getText());
        bayar = Integer.valueOf(txbayar.getText());

        if (total > bayar) {
            JOptionPane.showMessageDialog(null, "Uang tidak cukup untuk melakukan pembayaran");
        } else {
            kembalian = bayar - total;
            txkembalian.setText(String.valueOf(kembalian));
        }        // TODO add your handling code here:
    }//GEN-LAST:event_bthitumgActionPerformed

    private void btcariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btcariActionPerformed
        // TODO add your handling code here:
        listbarang a = new listbarang();
        a.setVisible(true);
    }//GEN-LAST:event_btcariActionPerformed

    private void txjenisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txjenisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txjenisActionPerformed

    private void txprintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txprintActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txprintActionPerformed

    private void txkodebActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txkodebActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txkodebActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btcari;
    private javax.swing.JButton bthapus;
    private javax.swing.JButton bthitumg;
    private javax.swing.JButton btsimpan;
    private javax.swing.JButton bttambah;
    private javax.swing.JButton jButton1;
    private com.toedter.calendar.JDateChooser jDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    private javax.swing.JTextField txbayar;
    public static javax.swing.JTextField txharga;
    public static javax.swing.JTextField txjenis;
    private javax.swing.JTextField txjumlah;
    private javax.swing.JTextField txkembalian;
    public static javax.swing.JTextField txkodeb;
    private javax.swing.JTextField txkodet;
    public static javax.swing.JTextField txnamab;
    private javax.swing.JTextField txprint;
    private javax.swing.JTextField txtampil;
    private javax.swing.JTextField txtotal;
    // End of variables declaration//GEN-END:variables
}
