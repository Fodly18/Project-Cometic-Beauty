import Koneksi.Conek;
import java.io.File;
import java.io.IOException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

public class laporanSupervisor extends javax.swing.JFrame {

    
    public laporanSupervisor() {
        initComponents();
        datatable("SELECT * FROM detail_transaksi");
    }

    private void createPDF(File file) throws IOException {
    try (PDDocument document = new PDDocument()) {
        PDPage page = new PDPage(PDRectangle.LETTER);
        document.addPage(page);

        try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) {
            // Mengatur ukuran font
            int fontSize = 8; // Ukuran font 10pt
            contentStream.setFont(PDType1Font.HELVETICA_BOLD, fontSize);
            contentStream.beginText();
            contentStream.newLineAtOffset(50, 750); // Posisi awal teks
            contentStream.showText("Data Produk"); // Title
            contentStream.endText();

            // Draw table headers
            int[] columnWidths = {100, 250, 80, 60, 80, 100}; // Lebar kolom
            int startX = 50;
            int startY = 730;
            int rowHeight = 20;
            for (int i = 0; i < tbl1.getColumnCount(); i++) {
                contentStream.beginText();
                contentStream.newLineAtOffset(startX, startY);
                contentStream.showText(tbl1.getColumnName(i));
                contentStream.endText();
                startX += columnWidths[i];
            }

            // Draw table content
            for (int i = 0; i < tbl1.getRowCount(); i++) {
                startX = 50;
                for (int j = 0; j < tbl1.getColumnCount(); j++) {
                    String cellValue = tbl1.getValueAt(i, j).toString();
                    contentStream.beginText();
                    contentStream.newLineAtOffset(startX, startY - ((i + 1) * rowHeight));
                    contentStream.showText(cellValue);
                    contentStream.endText();
                    startX += columnWidths[j];
                }
            }
        }

        document.save(file);
    }
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        btncari = new javax.swing.JButton();
        tanggal = new com.toedter.calendar.JDateChooser();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        txtotal = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl1 = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        pdf = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jButton25 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton31 = new javax.swing.JButton();
        jButton27 = new javax.swing.JButton();
        jButton30 = new javax.swing.JButton();
        jButton33 = new javax.swing.JButton();
        jButton32 = new javax.swing.JButton();
        jButton34 = new javax.swing.JButton();
        login = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 204, 204));
        jPanel2.setForeground(new java.awt.Color(255, 204, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btncari.setText("Cari");
        btncari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncariActionPerformed(evt);
            }
        });
        jPanel2.add(btncari, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 110, 80, -1));
        jPanel2.add(tanggal, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 110, 140, -1));
        jPanel2.add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, 140, -1));

        txtotal.setBackground(new java.awt.Color(204, 204, 204));
        txtotal.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtotalActionPerformed(evt);
            }
        });
        jPanel2.add(txtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 450, 140, 40));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setText("Total");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 460, -1, 20));

        jLabel6.setFont(new java.awt.Font("Rockwell", 0, 14)); // NOI18N
        jLabel6.setText("Pilih Rentang Tanggal Untuk Melihat Total Transaksi yg di Butuhkan");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, 490, -1));

        jLabel7.setFont(new java.awt.Font("Rockwell", 0, 14)); // NOI18N
        jLabel7.setText("Dari");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, 40, 40));

        jLabel9.setFont(new java.awt.Font("Rockwell", 0, 14)); // NOI18N
        jLabel9.setText("Sampai");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 100, 60, 40));

        tbl1.setBackground(new java.awt.Color(204, 204, 204));
        tbl1.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                tbl1AncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane1.setViewportView(tbl1);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 580, 270));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel11.setText("LAPORAN");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, -1, -1));

        pdf.setText("PDf");
        pdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pdfActionPerformed(evt);
            }
        });
        jPanel2.add(pdf, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 450, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Rectangle 79.png"))); // NOI18N
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 600, 480));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel19.setText("Admin");
        jPanel2.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 10, 40, 30));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/[removal 10.png"))); // NOI18N
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 0, 50, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, 620, 520));

        jPanel3.setBackground(new java.awt.Color(255, 153, 153));
        jPanel3.setForeground(new java.awt.Color(255, 153, 153));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Group 6.png"))); // NOI18N
        jButton25.setBorderPainted(false);
        jButton25.setContentAreaFilled(false);
        jButton25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton25ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton25, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 160, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/[removal 35.png"))); // NOI18N
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 150));

        jButton31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Group 4 (2).png"))); // NOI18N
        jButton31.setBorderPainted(false);
        jButton31.setContentAreaFilled(false);
        jButton31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton31ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton31, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 160, 40));

        jButton27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Group 1.png"))); // NOI18N
        jButton27.setBorderPainted(false);
        jButton27.setContentAreaFilled(false);
        jButton27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton27ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton27, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 160, 40));

        jButton30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Group 5.png"))); // NOI18N
        jButton30.setBorderPainted(false);
        jButton30.setContentAreaFilled(false);
        jButton30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton30ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton30, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 160, 40));

        jButton33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Group 59.png"))); // NOI18N
        jButton33.setBorderPainted(false);
        jButton33.setContentAreaFilled(false);
        jButton33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton33ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton33, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 160, 40));

        jButton32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Group 63.png"))); // NOI18N
        jButton32.setBorderPainted(false);
        jButton32.setContentAreaFilled(false);
        jButton32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton32ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton32, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 160, 40));

        jButton34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Group 61.png"))); // NOI18N
        jButton34.setBorderPainted(false);
        jButton34.setContentAreaFilled(false);
        jButton34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton34ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton34, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 160, 40));

        login.setBackground(new java.awt.Color(255, 51, 51));
        login.setText("LOGOUT");
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });
        jPanel3.add(login, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 470, 160, 30));

        jButton2.setBackground(new java.awt.Color(220, 218, 218));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Group 95 (2).png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, 150, 30));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 520));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

     public void totalBiaya() {
    int jumlahBaris = tbl1.getRowCount();
        int totalBiaya = 0;
        int jumlahBarang;
        for (int i = 0; i < jumlahBaris; i++) {
            jumlahBarang = Integer.parseInt(tbl1.getValueAt(i, 4).toString());
            totalBiaya = totalBiaya + jumlahBarang ;
        }
        txtotal.setText(String.valueOf(totalBiaya));
        txtotal.setText("Rp "+ totalBiaya +",00");
    }
     
     public void datatable(String query){
        DefaultTableModel tbl=new DefaultTableModel();
        tbl.addColumn("Kode Transaksi");
        tbl.addColumn("Nama Barang");
        tbl.addColumn("Hari/Tanggal");
        tbl.addColumn("Terjual");
        tbl.addColumn("Total");
        tbl1.setModel(tbl);
        try{
            Statement statement=(Statement)Conek.GetConnection().createStatement();
            ResultSet res=statement.executeQuery(query);
            while(res.next())
            {
                tbl.addRow(new Object[]{
                    res.getString("kode_transaksi"),
                    res.getString("nama_barang"),
                    res.getString("tanggal"),
                    res.getString("jumlah"),
                    res.getString("total")
                });
            }
        }catch (Exception e){
             JOptionPane.showMessageDialog(rootPane,e.toString());
        }
    }
    private void btncariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncariActionPerformed

        try{
            tbl1.setModel(new DefaultTableModel(null, new Object[]{
                "Kode Barang","Nama Barang","Hari/Tanggal","Terjual","Total"
            }));
         SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            String d1 = df.format(tanggal.getDate());
            String d2 = df.format(jDateChooser1.getDate());
            System.out.println(d1 + " " + d2);
            datatable("select * from detail_transaksi where tanggal between '"+ d2 +"' and '"+ d1 +"'");
        }catch (Exception e){
            JOptionPane.showMessageDialog(rootPane, e.toString());
        }
        totalBiaya();
    }//GEN-LAST:event_btncariActionPerformed

    private void txtotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtotalActionPerformed

    }//GEN-LAST:event_txtotalActionPerformed

    private void tbl1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_tbl1AncestorAdded

    }//GEN-LAST:event_tbl1AncestorAdded

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed
        this.setVisible(false);
        new login_admin().setVisible(true);
    }//GEN-LAST:event_loginActionPerformed

    private void jButton25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton25ActionPerformed
        this.setVisible(false);
        new JabatanKaryawan().setVisible(true);
    }//GEN-LAST:event_jButton25ActionPerformed

    private void jButton27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton27ActionPerformed
        this.setVisible(false);
        new Dashboard_admin().setVisible(true);
    }//GEN-LAST:event_jButton27ActionPerformed

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

    private void jButton32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton32ActionPerformed
        this.setVisible(false);
        new DataSupplier().setVisible(true);
    }//GEN-LAST:event_jButton32ActionPerformed

    private void jButton34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton34ActionPerformed
        this.setVisible(false);
        new pengeluaran().setVisible(true);
    }//GEN-LAST:event_jButton34ActionPerformed

    private void pdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pdfActionPerformed
      javax.swing.JFileChooser fileChooser = new javax.swing.JFileChooser();
    fileChooser.setDialogTitle("Simpan sebagai PDF");
    
    // Tentukan filter agar hanya file dengan ekstensi .pdf yang bisa dipilih
    FileNameExtensionFilter filter = new FileNameExtensionFilter("PDF files", "pdf");
    fileChooser.setFileFilter(filter);
    
    int userSelection = fileChooser.showSaveDialog(this);
    if (userSelection == javax.swing.JFileChooser.APPROVE_OPTION) {
        File fileToSave = fileChooser.getSelectedFile();
        
        // Pastikan file yang dipilih memiliki ekstensi .pdf
        if (!fileToSave.getAbsolutePath().toLowerCase().endsWith(".pdf")) {
            // Tambahkan ekstensi .pdf jika belum ada
            fileToSave = new File(fileToSave.getAbsolutePath() + ".pdf");
        }
        
        try {
            createPDF(fileToSave);
            javax.swing.JOptionPane.showMessageDialog(this, "PDF berhasil dibuat.");
        } catch (IOException ex) {
            javax.swing.JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat membuat PDF.");
            System.out.println("Error: " + ex.getMessage());
        }
    }
    }//GEN-LAST:event_pdfActionPerformed

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
            java.util.logging.Logger.getLogger(laporanSupervisor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(laporanSupervisor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(laporanSupervisor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(laporanSupervisor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new laporanSupervisor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncari;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton30;
    private javax.swing.JButton jButton31;
    private javax.swing.JButton jButton32;
    private javax.swing.JButton jButton33;
    private javax.swing.JButton jButton34;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton login;
    private javax.swing.JButton pdf;
    private com.toedter.calendar.JDateChooser tanggal;
    private javax.swing.JTable tbl1;
    private javax.swing.JTextField txtotal;
    // End of variables declaration//GEN-END:variables
}
