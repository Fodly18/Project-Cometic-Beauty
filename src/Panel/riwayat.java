/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Panel;
 import Koneksi.Conek;
import com.sun.jdi.connect.spi.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.view.JasperViewer;

public class riwayat extends javax.swing.JFrame {
    public riwayat() {
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
        tbl.addColumn("tanggal_masuk");
        tbl.addColumn("keterangan");
        tabel.setModel(tbl);
        try{
            Statement statement=(Statement)Conek.GetConnection().createStatement();
            ResultSet res=statement.executeQuery("SELECT * FROM riwayat");
            while(res.next())
            {
                tbl.addRow(new Object[]{
                    res.getString("kode_barang"),
                    res.getString("nama_barang"),
                    res.getString("harga"),
                    res.getString("stok"),
                    res.getString("jenis"),
                    res.getString("tanggal_masuk"),
                    res.getString("keterangan")
                });
            }
        }catch (Exception e){
             JOptionPane.showMessageDialog(rootPane,"salah");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        Cetak = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 204, 204));
        jPanel3.setForeground(new java.awt.Color(255, 204, 204));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel21.setText("Admin");
        jPanel3.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 10, 40, 30));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/[removal 10.png"))); // NOI18N
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 0, 50, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/[removal 10.png"))); // NOI18N
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 0, 50, -1));

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel22.setText("Admin");
        jPanel3.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 10, 40, 30));

        tabel.setBackground(new java.awt.Color(217, 217, 217));
        tabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "1", "2", "3", "4", "5", "6", "7", "8"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class
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

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 570, 350));

        Cetak.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Group 60.png"))); // NOI18N
        Cetak.setBorderPainted(false);
        Cetak.setContentAreaFilled(false);
        Cetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CetakActionPerformed(evt);
            }
        });
        jPanel3.add(Cetak, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 460, 110, 40));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("RIWAYAT PEMBELIAN");
        jLabel8.setPreferredSize(new java.awt.Dimension(90, 20));
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 30, 190, 26));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 620, 520));
    }// </editor-fold>//GEN-END:initComponents

    private void CetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CetakActionPerformed

    }//GEN-LAST:event_CetakActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Cetak;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabel;
    // End of variables declaration//GEN-END:variables
}
