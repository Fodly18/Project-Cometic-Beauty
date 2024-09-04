
import Koneksi.Conek;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.print.*;
import Koneksi.Conek;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class transaksi extends javax.swing.JFrame {

     String Tanggal;
    private DefaultTableModel model;
    
   private class PrintableNota implements Printable {
    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        if (pageIndex > 0) {
            return Printable.NO_SUCH_PAGE;
        }

        Graphics2D g2d = (Graphics2D) graphics;
        // Setting the origin to the top-left corner
        g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());

        // Adjust the width of the printable area to fit the 80mm paper width
        double paperWidth = 80 * 1.835; // 80mm to points conversion
        double imageableWidth = pageFormat.getImageableWidth();
        double scaleX = paperWidth / imageableWidth;
        g2d.scale(scaleX, 1);

        // Judul Nota
        Font judulFont = new Font("Arial", Font.BOLD, 10); 
        g2d.setFont(judulFont);
        g2d.drawString("NOTA TRANSAKSI BEAUTY COSMETIC", -10, 20); // Adjust position here

        // Garis pemisah
        g2d.drawLine(-10, 30, (int) paperWidth, 30);

        // Informasi transaksi
        Font infoFont = new Font("Arial", Font.PLAIN, 5); 
        g2d.setFont(infoFont);

        int yPos = 10; // Starting y position

        g2d.drawString("Kode Transaksi: " + txkodetransaksi.getText(), -10, yPos);
        yPos += 20;
        g2d.drawString("Tanggal: " + Tanggal, -10, yPos);
        yPos += 20;

        // Informasi barang
        g2d.drawString("-------------------------------------------------", -10, yPos);
        yPos += 20;
        g2d.drawString("Kode Barang: " + txkodebarang.getText(), -10, yPos);
        yPos += 20;
        g2d.drawString("Nama Barang: " + txnamabarang.getText(), -10, yPos);
        yPos += 20;
        g2d.drawString("Jenis: " + txtjenis.getText(), -10, yPos);
        yPos += 20;
        g2d.drawString("Harga: " + txtharga.getText(), -10, yPos);
        yPos += 20;
        g2d.drawString("Jumlah: " + txtjumlahbarangingindibeli.getText(), -10, yPos);
        yPos += 20;

        // Total biaya, pembayaran, dan kembalian
        g2d.drawString("-------------------------------------------------", -10, yPos);
        yPos += 20;
        g2d.drawString("Total Biaya: Rp. " + txtotalbayar.getText(), -10, yPos);
        yPos += 20;
        g2d.drawString("Bayar: Rp. " + txbayar.getText(), -10, yPos);
        yPos += 20;
        g2d.drawString("Kembalian: Rp. " + txkembalian.getText(), -10, yPos);

        return Printable.PAGE_EXISTS;
    }
}

    private void cetakNota() {
        PrinterJob printerJob = PrinterJob.getPrinterJob();
        printerJob.setPrintable(new PrintableNota());

        try {
            if (printerJob.printDialog()) {
                printerJob.print();
            }
        } catch (PrinterException ex) {
            JOptionPane.showMessageDialog(this, "Gagal mencetak: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Metode lainnya dan komponen lainnya di kelas transaksi

 
    public void totalBiaya() {
    int jumlahBaris = table.getRowCount();
        int totalBiaya = 0;
        int jumlahBarang, hargaBarang;
        for (int i = 0; i < jumlahBaris; i++) {
            jumlahBarang = Integer.parseInt(table.getValueAt(i, 5).toString());
            hargaBarang = Integer.parseInt(table.getValueAt(i, 4).toString());
            totalBiaya = totalBiaya + (jumlahBarang * hargaBarang);
        }
        txtotalbayar.setText(String.valueOf(totalBiaya));
        txtampil.setText("Rp "+ totalBiaya +",00");
    }
    public void tanggal(){
        Date now = new Date();
        jTanggaltransaksi.setDate(now);
        jTanggaltransaksi.setEnabled(false);
        txkodetransaksi.setEnabled(false);
        txtharga.setEnabled(false);
        txkodebarang.setEnabled(false);
        txtotalbayar.setEnabled(false);
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
                txkodetransaksi.setText("TR" + Nol + TR);
            } else {
                txkodetransaksi.setText("TR0001");
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
            txkodetransaksi.getText(),
            txkodebarang.getText(),
            txnamabarang.getText(),
            txtjenis.getText(),
            txtharga.getText(),
            txtjumlahbarangingindibeli.getText(),
            txtotalbayar.getText()
        });
}




    public void kosong(){
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        
        while (model.getRowCount()>0) {
            model.removeRow(0);
        }
    }
    
    public void utama(){
        txkodetransaksi.setText("");
        txkodebarang.setText("");
        txnamabarang.setText("");
        txtjenis.setText("");
        txtharga.setText("");
        txtjumlahbarangingindibeli.setText("");
        autonumber();
        txkodetransaksi.setEnabled(false);
        txtampil.setEnabled(false);
    }
    
    public void clear(){
        txtotalbayar.setText("0");
        txbayar.setText("0");
        txkembalian.setText("0");
        txtampil.setText("0");
    }
    
    public void clear2(){
        txkodebarang.setText("");
        txnamabarang.setText("");
        txtjenis.setText("");
        txtharga.setText("");
        txtjumlahbarangingindibeli.setText("");
        
    }
    
    public void tambahTransaksi() {
    int jumlah, harga, total;
    
    // Ambil nilai dari input pengguna
    jumlah = Integer.valueOf(txtjumlahbarangingindibeli.getText());
    harga = Integer.valueOf(txtharga.getText());
    total = jumlah * harga;
    
    txtotalbayar.setText(String.valueOf(total));
    
    // Mendapatkan model tabel
    DefaultTableModel model = (DefaultTableModel) table.getModel();
    
    // Pencarian apakah item sudah ada dalam tabel
    boolean itemDitemukan = false;
    int baris = model.getRowCount();
    for (int i = 0; i < baris; i++) {
        if (txkodebarang.getText().equals(model.getValueAt(i, 1))) {
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
            txkodetransaksi.getText(),
            txkodebarang.getText(),
            txnamabarang.getText(),
            txtjenis.getText(),
            txtharga.getText(),
            txtjumlahbarangingindibeli.getText(),
            txtotalbayar.getText()
        });
    }
    
    // Hitung ulang total biaya
    totalBiaya();
    
    // Bersihkan input setelah penambahan
   
    txkodebarang.requestFocus();
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
       
        if (jTanggaltransaksi.getDate() !=null){
            String p = "yyyy-MM-dd";
            SimpleDateFormat sd = new SimpleDateFormat(p);
            Tanggal = String.valueOf(sd.format(jTanggaltransaksi.getDate()));
        }
        txtotalbayar.setText("0");
        txbayar.setText("0");
        txkembalian.setText("0");
        txkodebarang.requestFocus();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        bttambah = new javax.swing.JButton();
        txkodetransaksi = new javax.swing.JTextField();
        txkembalian = new javax.swing.JTextField();
        txtharga = new javax.swing.JTextField();
        txbayar = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtotalbayar = new javax.swing.JTextField();
        txtjumlahbarangingindibeli = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txkodebarang = new javax.swing.JTextField();
        txnamabarang = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btsimpan = new javax.swing.JButton();
        bthapus = new javax.swing.JButton();
        txtampil = new javax.swing.JTextField();
        bthitumg = new javax.swing.JButton();
        btcari = new javax.swing.JButton();
        txtjenis = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTanggaltransaksi = new com.toedter.calendar.JDateChooser();
        jLabel14 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        Cetak = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jButton26 = new javax.swing.JButton();
        jButton25 = new javax.swing.JButton();
        jButton31 = new javax.swing.JButton();
        jButton30 = new javax.swing.JButton();
        jButton27 = new javax.swing.JButton();
        login = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(177, 173, 173));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 204, 204));
        jPanel2.setForeground(new java.awt.Color(255, 204, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setText("Jumlah");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 100, -1, -1));

        bttambah.setText("Tambah");
        bttambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttambahActionPerformed(evt);
            }
        });
        jPanel2.add(bttambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 290, -1, -1));

        txkodetransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txkodetransaksiActionPerformed(evt);
            }
        });
        jPanel2.add(txkodetransaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, 90, -1));
        jPanel2.add(txkembalian, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 400, 100, -1));
        jPanel2.add(txtharga, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 70, 90, -1));
        jPanel2.add(txbayar, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 370, 100, -1));

        jLabel4.setText("Jenis");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 40, -1, -1));

        jLabel5.setText("Harga");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 70, -1, -1));

        jLabel8.setText("Total Bayar");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, -1, -1));

        jLabel10.setText("Kembalian");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 400, -1, -1));

        jLabel2.setText("Kode Barang");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, -1, -1));

        jLabel3.setText("Nama Barang");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, -1));
        jPanel2.add(txtotalbayar, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 340, 100, -1));
        jPanel2.add(txtjumlahbarangingindibeli, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 100, 90, -1));

        jLabel9.setText("Bayar");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 370, -1, -1));
        jPanel2.add(txkodebarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 90, -1));

        txnamabarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txnamabarangActionPerformed(evt);
            }
        });
        jPanel2.add(txnamabarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, 90, -1));

        jLabel1.setText("Kode Transaksi");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, -1, -1));

        btsimpan.setText("Simpan");
        btsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btsimpanActionPerformed(evt);
            }
        });
        jPanel2.add(btsimpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 290, -1, -1));

        bthapus.setText("Hapus");
        bthapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bthapusActionPerformed(evt);
            }
        });
        jPanel2.add(bthapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 290, -1, -1));

        txtampil.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txtampil.setText("Rp.0");
        txtampil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtampilActionPerformed(evt);
            }
        });
        jPanel2.add(txtampil, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 370, 270, 70));

        bthitumg.setText("Hitung");
        bthitumg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bthitumgActionPerformed(evt);
            }
        });
        jPanel2.add(bthitumg, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 400, -1, -1));

        btcari.setText("Cari");
        btcari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btcariActionPerformed(evt);
            }
        });
        jPanel2.add(btcari, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 70, 60, -1));

        txtjenis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtjenisActionPerformed(evt);
            }
        });
        jPanel2.add(txtjenis, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 40, 90, -1));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel16.setText("Transaksi");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, -1, -1));

        jLabel7.setText("Tanggal");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 40, -1, -1));
        jPanel2.add(jTanggaltransaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 60, 140, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel14.setText("Kasir");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 0, 40, 50));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/—Pngtree—avatar icon profile icon member_5247852 3.png"))); // NOI18N
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 0, -1, 50));

        Cetak.setText("Cetak");
        Cetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CetakActionPerformed(evt);
            }
        });
        jPanel2.add(Cetak, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 460, -1, -1));

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

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 147, 560, 120));

        jButton1.setText("Clear");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 290, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, 640, 520));

        jPanel3.setBackground(new java.awt.Color(255, 153, 153));
        jPanel3.setForeground(new java.awt.Color(255, 153, 153));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/[removal 35.png"))); // NOI18N
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 160));

        jButton26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Group 1.png"))); // NOI18N
        jButton26.setBorderPainted(false);
        jButton26.setContentAreaFilled(false);
        jButton26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton26ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton26, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, -1, 40));

        jButton25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Group 21.png"))); // NOI18N
        jButton25.setBorderPainted(false);
        jButton25.setContentAreaFilled(false);
        jButton25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton25ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton25, new org.netbeans.lib.awtextra.AbsoluteConstraints(9, 290, 180, 40));

        jButton31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Group 4 (2).png"))); // NOI18N
        jButton31.setBorderPainted(false);
        jButton31.setContentAreaFilled(false);
        jButton31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton31ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton31, new org.netbeans.lib.awtextra.AbsoluteConstraints(9, 330, 180, 40));

        jButton30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Group 5.png"))); // NOI18N
        jButton30.setBorderPainted(false);
        jButton30.setContentAreaFilled(false);
        jButton30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton30ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton30, new org.netbeans.lib.awtextra.AbsoluteConstraints(9, 370, 180, -1));

        jButton27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Group 6.png"))); // NOI18N
        jButton27.setBorderPainted(false);
        jButton27.setContentAreaFilled(false);
        jButton27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton27ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton27, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 160, 40));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 520));

        login.setBackground(new java.awt.Color(255, 255, 255));
        login.setText("LOGOUT");
        login.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                loginMouseEntered(evt);
            }
        });
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });
        getContentPane().add(login, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, 160, 30));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txkodetransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txkodetransaksiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txkodetransaksiActionPerformed

    private void txnamabarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txnamabarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txnamabarangActionPerformed

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

    private void txtampilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtampilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtampilActionPerformed

    private void bthitumgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bthitumgActionPerformed
int total, bayar, kembalian;
        
        total = Integer.valueOf(txtotalbayar.getText());
        bayar = Integer.valueOf(txbayar.getText());
        
        if (total > bayar) {
            JOptionPane.showMessageDialog(null, "Uang tidak cukup untuk melakukan pembayaran");
        } else {
            kembalian = bayar - total;
            txkembalian.setText(String.valueOf(kembalian));
        }        // TODO add your handling code here:
    }//GEN-LAST:event_bthitumgActionPerformed

    private void btsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btsimpanActionPerformed
   DefaultTableModel model = (DefaultTableModel) table.getModel();

        if (jTanggaltransaksi.getDate() !=null){
            String p = "yyyy-MM-dd";
            SimpleDateFormat sd = new SimpleDateFormat(p);
            Tanggal = String.valueOf(sd.format(jTanggaltransaksi.getDate()));
        }

        String kode_transaksi = txkodetransaksi.getText();
        int Total = Integer.parseInt(txtotalbayar.getText());
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
    String Totalbayar = txtotalbayar.getText();

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
        clear2();
        utama();
        autonumber();
        kosong();
        txtampil.setText("Rp. 0");        // TODO add your handling code here:
           // TODO add your handling code here:
    }//GEN-LAST:event_btsimpanActionPerformed

    private void btcariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btcariActionPerformed
        // TODO add your handling code here:
        listbarang a = new listbarang();
        a.setVisible(true);
    }//GEN-LAST:event_btcariActionPerformed

    private void txtjenisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtjenisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtjenisActionPerformed

    private void jButton26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton26ActionPerformed
        this.setVisible(false);
        new Dashboard_Kasir().setVisible(true);
    }//GEN-LAST:event_jButton26ActionPerformed

    private void jButton25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton25ActionPerformed
           this.setVisible(false);
        new transaksi().setVisible(true);
    }//GEN-LAST:event_jButton25ActionPerformed

    private void jButton31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton31ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new DataProdukKasir().setVisible(true);
    }//GEN-LAST:event_jButton31ActionPerformed

    private void jButton30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton30ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new laporan().setVisible(true);
    }//GEN-LAST:event_jButton30ActionPerformed

    private void loginMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_loginMouseEntered

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed
       int confirm = JOptionPane.showConfirmDialog(this, "Apakah Anda yakin ingin logout?", "Konfirmasi Logout", JOptionPane.YES_NO_OPTION);
    if (confirm == JOptionPane.YES_OPTION) {
        this.setVisible(false);
        new login_admin().setVisible(true);
    }
    
    }//GEN-LAST:event_loginActionPerformed

    private void CetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CetakActionPerformed
        cetakNota();
        
    }//GEN-LAST:event_CetakActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         clear2();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton27ActionPerformed
        this.setVisible(false);
        new karyawanAdmin().setVisible(true);
    }//GEN-LAST:event_jButton27ActionPerformed

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
            java.util.logging.Logger.getLogger(transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new transaksi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Cetak;
    private javax.swing.JButton btcari;
    private javax.swing.JButton bthapus;
    private javax.swing.JButton bthitumg;
    private javax.swing.JButton btsimpan;
    private javax.swing.JButton bttambah;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton30;
    private javax.swing.JButton jButton31;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser jTanggaltransaksi;
    private javax.swing.JButton login;
    private javax.swing.JTable table;
    private javax.swing.JTextField txbayar;
    private javax.swing.JTextField txkembalian;
    public static javax.swing.JTextField txkodebarang;
    private javax.swing.JTextField txkodetransaksi;
    public static javax.swing.JTextField txnamabarang;
    private javax.swing.JTextField txtampil;
    public static javax.swing.JTextField txtharga;
    public static javax.swing.JTextField txtjenis;
    private javax.swing.JTextField txtjumlahbarangingindibeli;
    private javax.swing.JTextField txtotalbayar;
    // End of variables declaration//GEN-END:variables
}
