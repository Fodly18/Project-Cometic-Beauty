
import Koneksi.Conek;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.opencsv.CSVWriter;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;


public class DataProdukAdmin2 extends javax.swing.JFrame {
private DefaultTableModel tableModel;
private TableRowSorter<DefaultTableModel> sorter;
    /**
     * Creates new form DataProdukAdmin2
     */
    public DataProdukAdmin2() {
        initComponents();
        datatable();
    }
private void saveToCSV() {
    String query = "SELECT * FROM barang"; 
    String csvFilePath = "E:/Java Project/kosmetik terbaru20/Kosmetik1/src/csv/output.csv";

    try {
        Connection conn = Conek.GetConnection();
        Statement statement = conn.createStatement();
        ResultSet res = statement.executeQuery(query);

        FileWriter fileWriter = new FileWriter(csvFilePath);
        CSVWriter writer = new CSVWriter(fileWriter);

        // Menulis header
        String[] header = {"Kode Barang", "Nama Barang", "Harga", "Stok", "Jenis", "Expired"};
        writer.writeNext(header);

        // Menulis data
        while (res.next()) {
            String[] rowData = {
                res.getString("Kode_barang"),
                res.getString("Nama_barang"),
                res.getString("Harga"),
                res.getString("Stok"),
                res.getString("Jenis"),
                res.getString("Expired")
            };
            writer.writeNext(rowData);
        }

        writer.close();
        res.close();
        statement.close();
        conn.close();

        JOptionPane.showMessageDialog(rootPane, "Data berhasil disimpan ke CSV.");
    } catch (Exception e) {
        JOptionPane.showMessageDialog(rootPane, "Terjadi kesalahan: " + e.getMessage());
    }
}

// Metode untuk menyimpan data ke dalam file XLSX
private void saveToXLSX() {
    String query = "SELECT * FROM barang"; 
    String xlsxFilePath = "E:/Java Project/kosmetik terbaru20/Kosmetik1/src/xlsx/output.xlsx";

    try {
        Connection conn = Conek.GetConnection();
        Statement statement = conn.createStatement();
        ResultSet res = statement.executeQuery(query);

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Data");

        // Menulis header
        Row headerRow = sheet.createRow(0);
        String[] columns = {"Kode Barang", "Nama Barang", "Harga", "Stok", "Jenis", "Expired"};
        for (int i = 0; i < columns.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(columns[i]);
        }

        // Menulis data
        int rowNum = 1;
        while (res.next()) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(res.getString("Kode_barang"));
            row.createCell(1).setCellValue(res.getString("Nama_barang"));
            row.createCell(2).setCellValue(res.getString("Harga"));
            row.createCell(3).setCellValue(res.getString("Stok"));
            row.createCell(4).setCellValue(res.getString("Jenis"));
            row.createCell(5).setCellValue(res.getString("Expired"));
        }

        // Menyimpan workbook ke dalam file
        FileOutputStream fileOut = new FileOutputStream(xlsxFilePath);
        workbook.write(fileOut);
        fileOut.close();
        workbook.close();

        res.close();
        statement.close();
        conn.close();

        JOptionPane.showMessageDialog(rootPane, "Data berhasil disimpan ke XLSX.");
    } catch (Exception e) {
        JOptionPane.showMessageDialog(rootPane, "Terjadi kesalahan: " + e.getMessage());
    }
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
                    res.getString("Expired")
                });
            }
        }catch (Exception e){
             JOptionPane.showMessageDialog(rootPane, "Error: " + e.getMessage());
        }
    }
    public void initializeTableModelAndSorter() {
    tableModel = new DefaultTableModel();
    tableModel.addColumn("Kode Barang");
    tableModel.addColumn("Nama Barang");
    tableModel.addColumn("Harga");
    tableModel.addColumn("Stok");
    tableModel.addColumn("Jenis");
    tableModel.addColumn("Expired");
    
    tabel.setModel(tableModel);
    
    sorter = new TableRowSorter<>(tableModel);
    tabel.setRowSorter(sorter);
}
    private void applyFilter(String query) {
    RowFilter<DefaultTableModel, Object> rowFilter = RowFilter.regexFilter(query, 0, 1, 2, 3, 4, 5); // Menyesuaikan kolom yang ingin Anda cari
    sorter.setRowFilter(rowFilter);
}
    
    void bersih(){
      txt_search.setText("Search");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel19 = new javax.swing.JLabel();
        login = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jButton30 = new javax.swing.JButton();
        jButton27 = new javax.swing.JButton();
        jButton25 = new javax.swing.JButton();
        jButton31 = new javax.swing.JButton();
        jButton33 = new javax.swing.JButton();
        jButton34 = new javax.swing.JButton();
        jButton32 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        Print = new javax.swing.JButton();
        Cari = new javax.swing.JButton();
        txt_search = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel19.setText("Admin");
        getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 10, 40, 30));

        login.setBackground(new java.awt.Color(255, 51, 51));
        login.setForeground(new java.awt.Color(255, 255, 255));
        login.setText("LOGOUT");
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });
        getContentPane().add(login, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, 160, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/[removal 35.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 150));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/[removal 10.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 0, 50, -1));

        jPanel1.setLayout(new java.awt.BorderLayout());
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 410, -1, -1));

        jPanel3.setBackground(new java.awt.Color(255, 153, 153));
        jPanel3.setForeground(new java.awt.Color(255, 153, 153));

        jButton30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Group 5.png"))); // NOI18N
        jButton30.setBorderPainted(false);
        jButton30.setContentAreaFilled(false);
        jButton30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton30ActionPerformed(evt);
            }
        });

        jButton27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Group 1.png"))); // NOI18N
        jButton27.setBorderPainted(false);
        jButton27.setContentAreaFilled(false);
        jButton27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton27ActionPerformed(evt);
            }
        });

        jButton25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Group 6.png"))); // NOI18N
        jButton25.setBorderPainted(false);
        jButton25.setContentAreaFilled(false);
        jButton25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton25ActionPerformed(evt);
            }
        });

        jButton31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Group 4 (2).png"))); // NOI18N
        jButton31.setBorderPainted(false);
        jButton31.setContentAreaFilled(false);
        jButton31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton31ActionPerformed(evt);
            }
        });

        jButton33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Group 59.png"))); // NOI18N
        jButton33.setBorderPainted(false);
        jButton33.setContentAreaFilled(false);
        jButton33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton33ActionPerformed(evt);
            }
        });

        jButton34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Group 61.png"))); // NOI18N
        jButton34.setBorderPainted(false);
        jButton34.setContentAreaFilled(false);
        jButton34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton34ActionPerformed(evt);
            }
        });

        jButton32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Group 63.png"))); // NOI18N
        jButton32.setBorderPainted(false);
        jButton32.setContentAreaFilled(false);
        jButton32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton32ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(220, 218, 218));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Group 95 (2).png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jButton27, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton25, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton31, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton30, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton32, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton34, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton33, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(114, 114, 114)
                .addComponent(jButton27, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jButton25, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jButton31, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jButton30, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jButton33, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton34, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(202, 202, 202)
                .addComponent(jButton32, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 520));

        jPanel2.setBackground(new java.awt.Color(255, 204, 204));
        jPanel2.setForeground(new java.awt.Color(255, 204, 204));

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
                "Kode Barang", "Nama Barang", "Harga", "Stok", "Jenis"
            }
        ));
        jScrollPane1.setViewportView(tabel);

        Print.setText("Print");
        Print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrintActionPerformed(evt);
            }
        });

        Cari.setText("Cari");
        Cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CariActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(Print)
                        .addGap(24, 24, 24)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Cari, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(155, 155, 155))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Cari, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Print)
                .addContainerGap(188, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, 620, 520));

        pack();
        setLocationRelativeTo(null);
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

    private void CariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CariActionPerformed
      String query = txt_search.getText().trim(); // Dapatkan teks pencarian dari JTextField
    applyFilter(query); // Terapkan filter 
   
    }//GEN-LAST:event_CariActionPerformed

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed
        int confirm = JOptionPane.showConfirmDialog(this, "Apakah Anda yakin ingin logout?", "Konfirmasi Logout", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            this.setVisible(false);
            new login_admin().setVisible(true);
        }
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

    private void PrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrintActionPerformed
        String[] options = {"CSV", "XLSX"};
        int choice = javax.swing.JOptionPane.showOptionDialog(this,
            "Pilih jenis file yang ingin Anda buat:",
            "Pilih Format File",
            javax.swing.JOptionPane.YES_NO_OPTION,
            javax.swing.JOptionPane.QUESTION_MESSAGE,
            null,
            options,
            options[0]);

        // Menangani pilihan yang dibuat oleh pengguna
        switch (choice) {
            case 0: // Jika CSV dipilih
            saveToCSV();
            break;
            case 1: // Jika XLSX dipilih
            saveToXLSX();
            break;
            case -1: // Jika dialog ditutup tanpa memilih
            System.out.println("Dialog ditutup tanpa memilih.");
            break;
            default:
            break;
        }

    }//GEN-LAST:event_PrintActionPerformed

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
            java.util.logging.Logger.getLogger(DataProdukAdmin2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DataProdukAdmin2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DataProdukAdmin2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DataProdukAdmin2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DataProdukAdmin2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Cari;
    private javax.swing.JButton Print;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton login;
    private javax.swing.JTable tabel;
    private javax.swing.JTextField txt_search;
    // End of variables declaration//GEN-END:variables
}
