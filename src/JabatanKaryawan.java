import Koneksi.Conek;
import java.util.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import java.text.ParseException;
public class JabatanKaryawan extends javax.swing.JFrame {
private String currentEmployeeId;
private String initialNama;
private String initialTanggal;
private String initialJabatan;
private String initialGaji;

private javax.swing.JLabel tglKeterima;
String Tanggal;


    public JabatanKaryawan() {
        initComponents();
        datatable();
        tanggal();
        cmbjabat.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            cmbgajiActionPerformed(evt);
        }
    });
    }
    private boolean isDataExists(String nama) {
    boolean exists = false;
    try {
        Statement statement = (Statement) Conek.GetConnection().createStatement();
        String query = "SELECT * FROM jabatan_karyawan WHERE nama = '" + nama + "'";
        ResultSet res = statement.executeQuery(query);
        exists = res.next();
        res.close();
        statement.close();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error checking data: " + e.getMessage());
    }
    return exists;
}

    
    private void cmbgajiActionPerformed(java.awt.event.ActionEvent evt) {
   
    }
    
    private void selectEmployee(String employeeId) {
    this.currentEmployeeId = employeeId; // Pastikan currentEmployeeId diatur dengan benar

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    try {
        connection = Conek.GetConnection();
        
        String sql = "SELECT nama, tgl_keterima, jabatan, gaji FROM jabatan_karyawan WHERE id=?";
        
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, employeeId);

        resultSet = preparedStatement.executeQuery();
        
        if (resultSet.next()) {
            txtnama.setText(resultSet.getString("nama"));
            
            String tglKeterimaStr = resultSet.getString("tglketerima");
            java.util.Date tglKeterimaDate = new SimpleDateFormat("yyyy-MM-dd").parse(tglKeterimaStr);
            txtdate.setDate(tglKeterimaDate);
            
            cmbjabat.setSelectedItem(resultSet.getString("jabatan"));
            txtgaji.setText(resultSet.getString("gaji"));
        } else {
            JOptionPane.showMessageDialog(this, "Karyawan tidak ditemukan.");
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error saat mengambil data karyawan: " + e.getMessage());
    } finally {
       
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error saat menutup koneksi: " + e.getMessage());
        }
    }
}
    private void Clear(){
      
        txtnama.setText("");
        txtgaji.setText("");
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
                    res.getString("gaji")
                });
            }
            res.close();
            statement.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Error memuat data: " + e.getMessage());
        }
    }
    private void filterNamaKaryawan(String cariNama) {
        DefaultTableModel model = (DefaultTableModel) tabel.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        tabel.setRowSorter(sorter);
        
        if (cariNama.trim().length() == 0) {
            sorter.setRowFilter(null); // Jika JTextField kosong, tampilkan semua data
        } else {
            sorter.setRowFilter(RowFilter.regexFilter("(?i)" + cariNama, 1)); // Filter berdasarkan kolom Nama Karyawan
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        login = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txtsearch = new javax.swing.JTextField();
        btncari = new javax.swing.JButton();
        txtnama = new javax.swing.JTextField();
        txtdate = new com.toedter.calendar.JDateChooser();
        cmbjabat = new javax.swing.JComboBox<>();
        txtgaji = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        btn_hapus = new javax.swing.JButton();
        btn_edit = new javax.swing.JButton();
        btn_simpan = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jButton27 = new javax.swing.JButton();
        jButton25 = new javax.swing.JButton();
        jButton31 = new javax.swing.JButton();
        jButton30 = new javax.swing.JButton();
        jButton33 = new javax.swing.JButton();
        jButton34 = new javax.swing.JButton();
        jButton32 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/[removal 35.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 200, 140));

        login.setBackground(new java.awt.Color(255, 51, 51));
        login.setForeground(new java.awt.Color(255, 255, 255));
        login.setText("LOGOUT");
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });
        getContentPane().add(login, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, 160, 30));

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel22.setText("Admin");
        getContentPane().add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 10, 40, 30));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/[removal 10.png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 0, 50, -1));

        jPanel2.setBackground(new java.awt.Color(255, 204, 204));
        jPanel2.setForeground(new java.awt.Color(255, 204, 204));

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

        btncari.setText("Cari");
        btncari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncariActionPerformed(evt);
            }
        });

        cmbjabat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "Kasir" }));

        txtgaji.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtgajiActionPerformed(evt);
            }
        });

        jLabel20.setText("Gaji");

        jLabel19.setText("Jabatan");

        jLabel24.setText("Tanggal Diterima");

        jLabel21.setText("Nama");

        btn_hapus.setText("Hapus");
        btn_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapusActionPerformed(evt);
            }
        });

        btn_edit.setText("Edit");
        btn_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editActionPerformed(evt);
            }
        });

        btn_simpan.setText("Simpan");
        btn_simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_simpanActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel21)
                                .addGap(78, 78, 78)
                                .addComponent(txtnama, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel24)
                                .addGap(20, 20, 20)
                                .addComponent(txtdate, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addGap(70, 70, 70)
                                .addComponent(cmbjabat, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addGap(90, 90, 90)
                                .addComponent(txtgaji, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn_hapus)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_edit)
                                .addGap(27, 27, 27)
                                .addComponent(btn_simpan))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btncari)))
                        .addGap(0, 37, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btncari, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(txtsearch, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE))
                .addGap(13, 13, 13)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21)
                    .addComponent(txtnama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel24)
                    .addComponent(txtdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19)
                    .addComponent(cmbjabat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtgaji, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_hapus))
                    .addComponent(btn_edit)
                    .addComponent(btn_simpan))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(81, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, 620, 520));

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
        jPanel3.add(jButton27, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 160, 40));

        jButton25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Group 6.png"))); // NOI18N
        jButton25.setBorderPainted(false);
        jButton25.setContentAreaFilled(false);
        jButton25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton25ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton25, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 160, 40));

        jButton31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Group 4 (2).png"))); // NOI18N
        jButton31.setBorderPainted(false);
        jButton31.setContentAreaFilled(false);
        jButton31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton31ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton31, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 160, 40));

        jButton30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Group 5.png"))); // NOI18N
        jButton30.setBorderPainted(false);
        jButton30.setContentAreaFilled(false);
        jButton30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton30ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton30, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 160, 40));

        jButton33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Group 59.png"))); // NOI18N
        jButton33.setBorderPainted(false);
        jButton33.setContentAreaFilled(false);
        jButton33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton33ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton33, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 160, 40));

        jButton34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Group 61.png"))); // NOI18N
        jButton34.setBorderPainted(false);
        jButton34.setContentAreaFilled(false);
        jButton34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton34ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton34, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 160, 40));

        jButton32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Group 63.png"))); // NOI18N
        jButton32.setBorderPainted(false);
        jButton32.setContentAreaFilled(false);
        jButton32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton32ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton32, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, 160, 40));

        jButton2.setBackground(new java.awt.Color(220, 218, 218));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Group 95 (2).png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, 160, 30));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 520));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_simpanActionPerformed
     String Nama = txtnama.getText();       
    String Jabatan = (String)cmbjabat.getSelectedItem();
    String Gaji = txtgaji.getText();
    String Tanggal = "";

    if (txtdate != null && txtdate.getDate() != null) {
        String p = "yyyy-MM-dd";
        SimpleDateFormat sd = new SimpleDateFormat(p);
        Tanggal = String.valueOf(sd.format(txtdate.getDate()));
    }

    if (isDataExists(Nama)) {
        JOptionPane.showMessageDialog(null, "Data dengan nama karyawan ini sudah ada.");
        return;
    }

    try {
        Statement statement = (Statement) Conek.GetConnection().createStatement();
        statement.executeUpdate("INSERT INTO jabatan_karyawan (nama, tgl_keterima, jabatan, gaji) VALUES ('" + Nama + "',"
                + "'" + Tanggal + "','" + Jabatan + "','" + Gaji + "');");
        statement.close();
        JOptionPane.showMessageDialog(null, "Data Berhasil tersimpan");
    } catch (Exception t) {
        JOptionPane.showMessageDialog(null, "Data Gagal disimpan");
    }
    datatable();
    Clear();
    }//GEN-LAST:event_btn_simpanActionPerformed

    private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusActionPerformed
        int selectedRow = tabel.getSelectedRow();
    
    // Pastikan ada baris yang dipilih
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(this, "Pilih baris yang ingin dihapus terlebih dahulu.");
        return;
    }

    int confirm = JOptionPane.showConfirmDialog(this, "Apakah Anda yakin ingin menghapus data karyawan?", "Konfirmasi Hapus Data Karyawan", JOptionPane.YES_NO_OPTION);
    if (confirm == JOptionPane.YES_OPTION) {
        // Ambil ID karyawan dari baris yang dipilih dalam tabel
        String currentEmployeeId = tabel.getValueAt(selectedRow, 0).toString();

        Connection connection = null;
        PreparedStatement preparedStatementKaryawan = null;
        System.out.println("Menghapus karyawan dengan ID: " + currentEmployeeId);

        try {
            // Mendapatkan koneksi ke database
            connection = Conek.GetConnection();
            
            // SQL untuk menghapus data karyawan
            String sqlKaryawan = "DELETE FROM jabatan_karyawan WHERE id=?";
            preparedStatementKaryawan = connection.prepareStatement(sqlKaryawan);
            preparedStatementKaryawan.setString(1, currentEmployeeId); // Menggunakan currentEmployeeId yang sudah diisi

            // Eksekusi query DELETE
            int affectedRows = preparedStatementKaryawan.executeUpdate();
            
            if (affectedRows > 0) {
                JOptionPane.showMessageDialog(this, "Data Karyawan Berhasil Dihapus");
            } else {
                JOptionPane.showMessageDialog(this, "Data Karyawan tidak ditemukan atau gagal dihapus");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error saat menghapus data karyawan: " + e.getMessage());
        } finally {
            // Menutup prepared statement dan koneksi
            try {
                if (preparedStatementKaryawan != null) {
                    preparedStatementKaryawan.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Error saat menutup koneksi: " + e.getMessage());
            }
        }
        
        // Memperbarui tabel data
        datatable();
    }
    }//GEN-LAST:event_btn_hapusActionPerformed

    private void txtgajiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtgajiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtgajiActionPerformed

    private void btn_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editActionPerformed
        int selectedRow = tabel.getSelectedRow();

    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(this, "Pilih baris yang ingin diedit terlebih dahulu.");
        return;
    }
    
    // Ambil nilai input dari form
    String Nama = txtnama.getText();
    String Tanggal = "";
    if (txtdate.getDate() != null) {
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
        Tanggal = sd.format(txtdate.getDate());
    } else {
        JOptionPane.showMessageDialog(this, "Pilih tanggal terlebih dahulu.");
        return;
    }
    String Jabatan = (String) cmbjabat.getSelectedItem();
    String Gaji = txtgaji.getText();
    
    // Validasi jika data nama tidak diisi
    if (Nama.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Nama harus diisi.");
        return;
    }

    // Cek apakah ada perubahan data
    if (Nama.equals(initialNama) && Tanggal.equals(initialTanggal) && Jabatan.equals(initialJabatan) && Gaji.equals(initialGaji)) {
        JOptionPane.showMessageDialog(this, "Tidak ada perubahan pada data.");
        return;
    }
    
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    
    try {
        connection = Conek.GetConnection();
        
        String sql = "UPDATE jabatan_karyawan SET nama=?, tgl_keterima=?, jabatan=?, gaji=? WHERE id=?";
        
        preparedStatement = connection.prepareStatement(sql);
        
        preparedStatement.setString(1, Nama);
        preparedStatement.setString(2, Tanggal);
        preparedStatement.setString(3, Jabatan);
        preparedStatement.setString(4, Gaji);
        preparedStatement.setString(5, currentEmployeeId);
        
        preparedStatement.executeUpdate();
        
        JOptionPane.showMessageDialog(this, "Berhasil Dirubah");
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error saat mengubah data: " + e.getMessage());
    } finally {
        try {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error saat menutup koneksi: " + e.getMessage());
        }
    }
    
    datatable();
    Clear();
    }//GEN-LAST:event_btn_editActionPerformed

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed
        int confirm = JOptionPane.showConfirmDialog(this, "Apakah Anda yakin ingin logout?", "Konfirmasi Logout", JOptionPane.YES_NO_OPTION);
    if (confirm == JOptionPane.YES_OPTION) {
        this.setVisible(false);
        new login_admin().setVisible(true);
    }
    }//GEN-LAST:event_loginActionPerformed

    private void tabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelMouseClicked
        int selectedRow = tabel.getSelectedRow();
    if (selectedRow != -1) {
        // Simpan data awal saat baris dipilih
        currentEmployeeId = tabel.getValueAt(selectedRow, 0).toString();
        initialNama = tabel.getValueAt(selectedRow, 1).toString();
        initialTanggal = tabel.getValueAt(selectedRow, 2).toString();
        initialJabatan = tabel.getValueAt(selectedRow, 3).toString();
        initialGaji = tabel.getValueAt(selectedRow, 4).toString();
        
        // Isi field dengan data yang dipilih
        txtnama.setText(initialNama);
        // Konversi string tanggal ke Date untuk setDate
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = sdf.parse(initialTanggal);
            txtdate.setDate(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        cmbjabat.setSelectedItem(initialJabatan);
        txtgaji.setText(initialGaji);
    }
    }//GEN-LAST:event_tabelMouseClicked

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

    private void btncariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncariActionPerformed
       String cariNama = txtsearch.getText(); // Ambil teks dari JTextField
        filterNamaKaryawan(cariNama);
    }//GEN-LAST:event_btncariActionPerformed

    private void txtsearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtsearchKeyReleased
        // TODO add your handling code here:
        DefaultTableModel cari=(DefaultTableModel) tabel.getModel();
        TableRowSorter<DefaultTableModel> obj=new TableRowSorter<>(cari);
        tabel.setRowSorter(obj);
        obj.setRowFilter(RowFilter.regexFilter(txtsearch.getText()));
    }//GEN-LAST:event_txtsearchKeyReleased

    private void txtsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsearchActionPerformed

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
            java.util.logging.Logger.getLogger(JabatanKaryawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JabatanKaryawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JabatanKaryawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JabatanKaryawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JabatanKaryawan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_edit;
    private javax.swing.JButton btn_hapus;
    private javax.swing.JButton btn_simpan;
    private javax.swing.JButton btncari;
    private javax.swing.JComboBox<String> cmbjabat;
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
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton login;
    private javax.swing.JTable tabel;
    private com.toedter.calendar.JDateChooser txtdate;
    private javax.swing.JTextField txtgaji;
    private javax.swing.JTextField txtnama;
    private javax.swing.JTextField txtsearch;
    // End of variables declaration//GEN-END:variables

    
}
