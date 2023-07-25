
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author ASUS
 */
public class FormKategoriBarang extends javax.swing.JDialog {

    /**
     * Creates new form FormKategoriBarang
     *
     * @param parent
     * @param modal
     */
    KoneksiMySql koneksi = new KoneksiMySql();

    public FormKategoriBarang(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        centerUI();
        txttemp_nama.hide();
        GetData();
        BtnEnabled(false);
        aktif(false);
    }

    private void centerUI() {
        Dimension windowSize = getSize();
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Point centerPoint = ge.getCenterPoint();
        int dx = centerPoint.x - windowSize.width / 2;
        int dy = centerPoint.y - windowSize.height / 2;
        setLocation(dx, dy);
    }

    private void TxtEmpty() {
        txtID.setText("");
        txtNama.setText("");
        txtNoRak.setText("");
        txttemp_nama.setText("");
    }

    private void BtnEnabled(boolean x) {
        btnEdit.setEnabled(x);
        btnHapus.setEnabled(x);
    }
    
    private void aktif(boolean t) {
        txtNama.setEnabled(t);
        txtNoRak.setEnabled(t);
        btnCancel.setEnabled(t);
        btnSimpan.setEnabled(t);
    }

    private void GetData() {
        try {
            Connection conn = koneksi.getConnection();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet sql = stm.executeQuery("SELECT indkategori.id, indkategori.nama, indkategori.no_rak FROM indkategori");
            datatable.setModel(DbUtils.resultSetToTableModel(sql));
            datatable.getColumnModel().getColumn(0).setPreferredWidth(5);
            datatable.getColumnModel().getColumn(1).setPreferredWidth(100);
            datatable.getColumnModel().getColumn(2).setPreferredWidth(50);

            //sql.last();
            String count_rows = String.valueOf(datatable.getRowCount());
            labelCountRows.setText("Jumlah Data : " + count_rows);
            koneksi.closeConnection();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error " + e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FormKategoriBarang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void GetData_View() {
        int row = datatable.getSelectedRow();
        String row_id = (datatable.getModel().getValueAt(row, 0).toString());
        txtID.setText(row_id);
        BtnEnabled(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnSimpan = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        labelCountRows = new javax.swing.JLabel();
        txtID = new javax.swing.JTextPane();
        jLabel9 = new javax.swing.JLabel();
        txttemp_nama = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        labelAction = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtNama = new javax.swing.JTextField();
        txtNoRak = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        btnTambah = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        datatable = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        }
        ;

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Data Kategori Barang Indomaret");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        btnCancel.setText("Batal");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        labelCountRows.setText("Jumlah Data");

        jLabel9.setText("Terpilih:");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/refresh (4).png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        labelAction.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        labelAction.setText("Tambah Data Kategori Barang");

        jLabel4.setText("Nama");

        jLabel6.setText("No Rak");

        txtNama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNamaActionPerformed(evt);
            }
        });

        txtNoRak.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNoRakKeyTyped(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Logo_Indomaret (2).png"))); // NOI18N

        jPanel4.setBackground(new java.awt.Color(0, 102, 204));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Data Kategori Barang Indomaret");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addGap(321, 321, 321))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel12)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        btnTambah.setText("Tambah");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });

        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        datatable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Kode", "Nama", "Kategori", "Satuan", "Stok"
            }
        ));
        datatable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                datatableMouseReleased(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                datatableMouseClicked(evt);
            }
        });
        datatable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                datatableKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(datatable);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(labelCountRows, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(239, 239, 239)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(74, 74, 74)
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(50, 50, 50)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelAction)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtNoRak))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(txttemp_nama, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(90, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(289, 289, 289))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(24, 24, 24)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnTambah)
                        .addComponent(btnEdit)
                        .addComponent(btnHapus)))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(labelAction)
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtNoRak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSimpan)
                            .addComponent(btnCancel))
                        .addGap(18, 18, 18)
                        .addComponent(txttemp_nama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                                    .addComponent(labelCountRows, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
        String row_id = txtID.getText();
        String row_txttemp_kode = txttemp_nama.getText();
        String row_txtnama = txtNama.getText();
        String row_txtrak = txtNoRak.getText();
        int c_kode = 0;

        if (!"".equals(row_txtnama) && !"".equals(row_txtrak)) {
            try {
                Connection conn = koneksi.getConnection();
                java.sql.Statement stm = conn.createStatement();
                java.sql.ResultSet sql = stm.executeQuery("SELECT COUNT(indkategori.id) as count FROM indkategori WHERE indkategori.nama='" + row_txtnama + "'");
                sql.next();
                c_kode = sql.getInt("count");
                koneksi.closeConnection();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error " + e);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(FormKategoriBarang.class.getName()).log(Level.SEVERE, null, ex);
            }

            if ("".equals(row_id)) {
                if (c_kode == 0) {
                    try {
                        Connection conn = koneksi.getConnection();
                        java.sql.Statement stm = conn.createStatement();
                        stm.executeUpdate("INSERT INTO indkategori(nama, no_rak) VALUES ('" + row_txtnama + "', '" + row_txtrak + "')");
                        JOptionPane.showMessageDialog(null, "Berhasil menyimpan data.");
                        btnTambah.doClick();
                        aktif(false);
                        btnTambah.requestFocus();
                        koneksi.closeConnection();
                        GetData();
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, "Error " + e);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(FormKategoriBarang.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Nama kategori sudah pernah disimpan.", "Gagal Disimpan", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                if (c_kode == 0 || row_txtnama.equals(row_txttemp_kode)) {
                    try {
                        Connection conn = koneksi.getConnection();
                        java.sql.Statement stm = conn.createStatement();
                        stm.executeUpdate("UPDATE indkategori SET nama='" + row_txtnama + "',no_rak='" + row_txtrak + "' WHERE id = '" + row_id + "'");
                        JOptionPane.showMessageDialog(null, "Berhasil mengubah data.");
                        btnTambah.doClick();
                        btnTambah.setEnabled(true);
                        aktif(false);
                        BtnEnabled(false);
                        btnTambah.requestFocus();
                        koneksi.closeConnection();
                        GetData();
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, "Error " + e);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(FormKategoriBarang.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Nama kategori sudah pernah disimpan.", "Gagal Disimpan", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Terdapat inputan yang kosong.");
        }

    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
        btnTambah.doClick();
        btnTambah.setEnabled(true);
        BtnEnabled(false);
        aktif(false);
        TxtEmpty();
        btnTambah.requestFocus();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        GetData();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtNamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNamaActionPerformed

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        // TODO add your handling code here:
        labelAction.setText("Tambah Data Kategori Barang");
        datatable.clearSelection();
        TxtEmpty();
        aktif(true);
        BtnEnabled(false);
        txtNama.requestFocus();
    }//GEN-LAST:event_btnTambahActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
        String row_id = txtID.getText();
        if (!"0".equals(row_id)) {
            try {
                Connection conn = koneksi.getConnection();
                java.sql.Statement stm = conn.createStatement();
                java.sql.ResultSet sql = stm.executeQuery("SELECT indkategori.id, indkategori.nama, indkategori.no_rak FROM indkategori WHERE indkategori.id='" + row_id + "'");
                if (sql.next()) {
                    aktif(true);
                    btnTambah.setEnabled(false);
                    String kode = sql.getString("nama");
                    labelAction.setText("Edit Data Kategori Barang || " + kode);
                    txtID.setText(sql.getString("id"));
                    txtNama.setText(sql.getString("nama"));
                    txtNoRak.setText(sql.getString("no_rak"));
                    txttemp_nama.setText(kode);
                }
                koneksi.closeConnection();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error " + e);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(FormBarang.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Terdapat kesalahan id null!");
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
        int ok = JOptionPane.showConfirmDialog(null, "Anda yakin ingin menghapus data ini?", "Konfirmasi", JOptionPane.OK_CANCEL_OPTION);
        if (ok == 0) {
            try {
                String row_id = txtID.getText();
                Connection conn = koneksi.getConnection();
                java.sql.Statement stm = conn.createStatement();
                stm.executeUpdate("DELETE FROM indbarang WHERE id = '" + row_id + "'");
                JOptionPane.showMessageDialog(null, "Berhasil menghapus data.");
                btnTambah.doClick();
                btnTambah.setEnabled(true);
                BtnEnabled(false);
                aktif(false);
                btnTambah.requestFocus();
                koneksi.closeConnection();
                GetData();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error " + e);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(FormBarang.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnHapusActionPerformed

    private void datatableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_datatableMouseReleased
        // TODO add your handling code here:
        GetData_View();
    }//GEN-LAST:event_datatableMouseReleased

    private void datatableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_datatableMouseClicked
        // TODO add your handling code here:
        GetData_View();
    }//GEN-LAST:event_datatableMouseClicked

    private void datatableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_datatableKeyReleased
        // TODO add your handling code here:
        GetData_View();
    }//GEN-LAST:event_datatableKeyReleased

    private void txtNoRakKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNoRakKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c)) && !(c == KeyEvent.VK_BACK_SPACE)) {
            JOptionPane.showMessageDialog(null, "Inputan hanya boleh angka", "Ilegal Input", JOptionPane.ERROR_MESSAGE);
            evt.consume();
        }
    }//GEN-LAST:event_txtNoRakKeyTyped

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
            java.util.logging.Logger.getLogger(FormKategoriBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormKategoriBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormKategoriBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormKategoriBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(() -> {
            FormKategoriBarang dialog = new FormKategoriBarang(new javax.swing.JFrame(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnTambah;
    private javax.swing.JTable datatable;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelAction;
    private javax.swing.JLabel labelCountRows;
    private javax.swing.JTextPane txtID;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtNoRak;
    private javax.swing.JTextField txttemp_nama;
    // End of variables declaration//GEN-END:variables
}
