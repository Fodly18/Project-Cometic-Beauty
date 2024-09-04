/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Panel;
import Koneksi.Conek;
import com.mysql.cj.jdbc.Driver;
import com.sun.jdi.connect.spi.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
public class laporan extends javax.swing.JFrame {

    /**
     * Creates new form laporanSupervisor
     */
    public laporan() {
        initComponents();
        datatable("SELECT * FROM detail_transaksi");
    }
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
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel11 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        tanggal = new com.toedter.calendar.JDateChooser();
        btncari = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl1 = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        txtotal = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("LAPORAN");
        add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 0, -1, -1));

        jLabel6.setFont(new java.awt.Font("Rockwell", 0, 14)); // NOI18N
        jLabel6.setText("Pilih Rentang Tanggal Untuk Melihat Total Transaksi yg di Butuhkan");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, 450, -1));

        jLabel9.setFont(new java.awt.Font("Rockwell", 0, 14)); // NOI18N
        jLabel9.setText("Sampai");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 90, 60, 40));

        jLabel7.setFont(new java.awt.Font("Rockwell", 0, 14)); // NOI18N
        jLabel7.setText("Dari");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 40, 40));
        add(tanggal, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 100, 140, -1));

        btncari.setText("Cari");
        btncari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncariActionPerformed(evt);
            }
        });
        add(btncari, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 100, 80, -1));
        add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, 140, -1));

        tbl1.setBackground(new java.awt.Color(204, 204, 204));
        tbl1.setForeground(new java.awt.Color(0, 0, 0));
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

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 570, 300));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Total");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 460, -1, 20));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/[removal 10.png"))); // NOI18N
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 0, 50, -1));

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel22.setText("Admin");
        add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 10, 40, 30));

        txtotal.setBackground(new java.awt.Color(204, 204, 204));
        txtotal.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtotalActionPerformed(evt);
            }
        });
        add(txtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 450, 140, 40));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Rectangle 79.png"))); // NOI18N
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 610, 480));

        jPanel3.setBackground(new java.awt.Color(255, 204, 204));
        jPanel3.setForeground(new java.awt.Color(255, 204, 204));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel21.setText("Admin");
        jPanel3.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 10, 40, 30));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/[removal 10.png"))); // NOI18N
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 0, 50, -1));

        add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 620, 520));
    }// </editor-fold>//GEN-END:initComponents

    private void tbl1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_tbl1AncestorAdded

    }//GEN-LAST:event_tbl1AncestorAdded

    private void txtotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtotalActionPerformed

    }//GEN-LAST:event_txtotalActionPerformed

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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncari;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser tanggal;
    private javax.swing.JTable tbl1;
    private javax.swing.JTextField txtotal;
    // End of variables declaration//GEN-END:variables
}
