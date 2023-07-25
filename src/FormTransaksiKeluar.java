
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.sql.*;
import java.util.HashMap;
import javax.swing.JOptionPane;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author ASUS
 */
public class FormTransaksiKeluar extends javax.swing.JDialog {

    /**
     * Creates new form FormTransaksiKeluar
     *
     * @param parent
     * @param modal
     */
    KoneksiMySql koneksi = new KoneksiMySql();
    PetugasSession PetugasSession = new PetugasSession();

    public FormTransaksiKeluar(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        initUI();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();

        txtTgl.setText(dateFormat.format(cal.getTime()));
        txtnm_petugas.setText(PetugasSession.getU_nama());
        txtid_petugas.setText(Integer.toString(PetugasSession.getU_id()));

        SelectPelanggan();
        TxtEmpty();
    }

    private void initUI() {
        Dimension windowSize = getSize();
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Point centerPoint = ge.getCenterPoint();
        int dx = centerPoint.x - windowSize.width / 2;
        int dy = centerPoint.y - windowSize.height / 2;
        setLocation(dx, dy);
    }

    private void SelectPelanggan() {
        try {
            Connection conn = koneksi.getConnection();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet rs = stm.executeQuery("SELECT * FROM indpelanggan");

            cmbid_pelanggan.addItem("Pilih");
            while (rs.next()) {
                cmbid_pelanggan.addItem(rs.getString("kode") + " " + rs.getString("nama"));
            }
            koneksi.getConnection();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Eror " + e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FormBarang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void TxtEmpty() {
        TableEmpty();
        BtnEnabled(false);
        lblnama_barang.setText("-");
        txtid_selected.setText("");
        txtid_pelanggan.setVisible(false);
        txtid_petugas.setVisible(false);
        txtid_barang.setVisible(false);
        txtjumlah_barang_max.setVisible(false);
        cmbid_pelanggan.setSelectedItem("Pilih");
        cmbid_pelanggan.requestFocus();
    }

    private void TableEmpty() {
        DefaultTableModel model = (DefaultTableModel) datatable.getModel();
        int rowCount = model.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            model.removeRow(i);
        }
    }

    private void BtnEnabled(boolean x) {
        btnDelRow.setEnabled(x);
    }

    private void GetData_View() {
        String row = Integer.toString(datatable.getSelectedRow());
        txtid_selected.setText(row);
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
        txtTgl = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        cmbid_pelanggan = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtkode_barang = new javax.swing.JTextField();
        lblnama_barang = new javax.swing.JLabel();
        txtid_barang = new javax.swing.JTextField();
        txtjumlah_barang_max = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtjumlah_barang = new javax.swing.JTextField();
        btnok = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        datatable = new javax.swing.JTable();
        btnTableEmpty = new javax.swing.JButton();
        btnDelRow = new javax.swing.JButton();
        txtid_selected = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtnm_petugas = new javax.swing.JTextField();
        btnsave = new javax.swing.JButton();
        txtid_petugas = new javax.swing.JTextField();
        txtid_pelanggan = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Transaksi Barang Keluar");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        txtTgl.setEditable(false);

        jPanel4.setBackground(new java.awt.Color(0, 102, 204));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Transaksi Barang Keluar");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(322, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addGap(320, 320, 320))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel12)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        cmbid_pelanggan.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbid_pelangganItemStateChanged(evt);
            }
        });

        jLabel5.setText("Kode Barang");

        txtkode_barang.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtkode_barangFocusLost(evt);
            }
        });

        lblnama_barang.setText("Nama Barang");

        jLabel7.setText("Jumlah");

        txtjumlah_barang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtjumlah_barangKeyTyped(evt);
            }
        });

        btnok.setText("OK");
        btnok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnokActionPerformed(evt);
            }
        });

        datatable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Kode", "Nama Barang", "Jumlah"
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

        btnTableEmpty.setText("Hapus Semuanya");
        btnTableEmpty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTableEmptyActionPerformed(evt);
            }
        });

        btnDelRow.setText("Hapus yang terpilih");
        btnDelRow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelRowActionPerformed(evt);
            }
        });

        txtid_selected.setEditable(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnTableEmpty, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDelRow, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtid_selected, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtkode_barang, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblnama_barang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(txtid_barang, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtjumlah_barang_max, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtjumlah_barang, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnok, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtkode_barang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblnama_barang)
                    .addComponent(txtid_barang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtjumlah_barang_max, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtjumlah_barang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnok))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTableEmpty)
                    .addComponent(btnDelRow)
                    .addComponent(txtid_selected, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Logo_Indomaret (2).png"))); // NOI18N

        jLabel2.setText("Nama Petugas");

        jLabel3.setText("Nama Pelanggan");

        jLabel8.setText("Bersihkan inputan transaksi");
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });

        txtnm_petugas.setEditable(false);

        btnsave.setText("Simpan Transaksi");
        btnsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsaveActionPerformed(evt);
            }
        });

        jLabel4.setText("Tanggal");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(245, 245, 245))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jLabel8)
                        .addGap(420, 420, 420)
                        .addComponent(btnsave, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtnm_petugas, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbid_pelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtid_petugas, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtid_pelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtTgl, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtnm_petugas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(cmbid_pelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtid_petugas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtid_pelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(txtTgl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(btnsave))
                .addGap(96, 96, 96))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsaveActionPerformed
        // TODO add your handling code here:
        String row_tgl = txtTgl.getText();
        String row_idpelanggan = txtid_pelanggan.getText();
        String row_idpetugas = txtid_petugas.getText();

        String id, kode;
        Integer id_barang_masuk = 0, jumlah, stok, not_found, empty = 0;

        DefaultTableModel model = (DefaultTableModel) datatable.getModel();
        int rowCount = model.getRowCount();

        if (rowCount > 0 && !"".equals(row_tgl) && !"".equals(row_idpelanggan) && !"".equals(row_idpetugas)) {
            try {
                Connection conn = koneksi.getConnection();
                java.sql.Statement stm = conn.createStatement();
                stm.executeUpdate("INSERT INTO indbarang_keluar(tgl, id_petugas, id_pelanggan) VALUES ('" + row_tgl + "', '" + row_idpetugas + "', '" + row_idpelanggan + "')");
                koneksi.closeConnection();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error " + e);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(FormBarang.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                Connection conn = koneksi.getConnection();
                java.sql.Statement stm = conn.createStatement();
                java.sql.ResultSet sql = stm.executeQuery("SELECT MAX(id) as max FROM indbarang_keluar");
                sql.next();
                id_barang_masuk = sql.getInt("max");
                koneksi.closeConnection();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error " + e);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(FormBarang.class.getName()).log(Level.SEVERE, null, ex);
            }

            for (int i = 0; i < rowCount; i++) {
                not_found = 0;
                stok = 0;
                id = (datatable.getModel().getValueAt(i, 0).toString());
                kode = (datatable.getModel().getValueAt(i, 1).toString());
                jumlah = Integer.parseInt((String) datatable.getModel().getValueAt(i, 3));

                try {
                    Connection conn = koneksi.getConnection();
                    java.sql.Statement stm = conn.createStatement();
                    java.sql.ResultSet sql = stm.executeQuery("SELECT stok FROM indbarang WHERE id = '" + id + "'");

                    sql.next();
                    //sql.last();
                    if (sql.getRow() == 1) {
                        stok = (sql.getInt("stok") - jumlah);
                    } else {
                        not_found = 1;
                    }
                    koneksi.closeConnection();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Error " + e);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(FormLoginPetugas.class.getName()).log(Level.SEVERE, null, ex);
                }

                if (not_found == 0) {
                    //------- Mengupdate jumlah stok barang
                    try {
                        Connection conn = koneksi.getConnection();
                        java.sql.Statement stm = conn.createStatement();
                        stm.executeUpdate("UPDATE indbarang SET stok='" + stok + "' WHERE id = '" + id + "'");
                        koneksi.closeConnection();
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, "Error " + e);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(FormBarang.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    //------- Memasukan pada table transaksi detail
                    try {
                        Connection conn = koneksi.getConnection();
                        java.sql.Statement stm = conn.createStatement();
                        stm.executeUpdate("INSERT INTO indbarang_keluar_detail(id_barang_keluar, id_barang, jumlah) VALUES ('" + id_barang_masuk + "', '" + id + "', '" + jumlah + "')");
                        empty = 1;
                        koneksi.closeConnection();
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, "Error " + e);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(FormBarang.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Sistem tidak menemukan barang dengan kode = " + kode, "Barang " + kode + " Gagal Disimpan", JOptionPane.ERROR_MESSAGE);
                }

                //------- Opsi jika terdapat barang yang belum satupun di masukan
                if (empty == 0) {
                    try {
                        Connection conn = koneksi.getConnection();
                        java.sql.Statement stm = conn.createStatement();
                        stm.executeUpdate("DELETE FROM indbarang_keluar WHERE id = '" + id_barang_masuk + "'");
                        koneksi.closeConnection();
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, "Error " + e);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(FormBarang.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {

                }
            }
            JOptionPane.showMessageDialog(null, "Berhasil menyimpan data transaksi");

            try {
                this.setVisible(false);
                HashMap hash = new HashMap();
                hash.put("nm_supplier", cmbid_pelanggan.getSelectedItem().toString());
                hash.put("id", id_barang_masuk);

                InputStream file = getClass().getResourceAsStream("/report/report_transaksiKeluar.jrxml");
                JasperDesign jasperDesign = JRXmlLoader.load(file);
                JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, hash, koneksi.getConnection());
                JasperViewer.viewReport(jasperPrint, false);
            } catch (ClassNotFoundException | JRException e) {
                JOptionPane.showMessageDialog(null, e);
            }
            this.hide();
        } else {
            JOptionPane.showMessageDialog(null, "Terdapat inputan yang kosong.");
        }
    }//GEN-LAST:event_btnsaveActionPerformed

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        // TODO add your handling code here:
        TxtEmpty();
    }//GEN-LAST:event_jLabel8MouseClicked

    private void btnDelRowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelRowActionPerformed
        // TODO add your handling code here:
        int ok = JOptionPane.showConfirmDialog(null, "Anda yakin ingin menghapus baris ini?", "Konfirmasi", JOptionPane.OK_CANCEL_OPTION);
        if (ok == 0) {
            int row = Integer.parseInt(txtid_selected.getText());
            DefaultTableModel model = (DefaultTableModel) datatable.getModel();
            model.removeRow(row);
            BtnEnabled(false);
        }
    }//GEN-LAST:event_btnDelRowActionPerformed

    private void btnTableEmptyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTableEmptyActionPerformed
        // TODO add your handling code here:
        int ok = JOptionPane.showConfirmDialog(null, "Anda yakin ingin menghapus semua baris ini?", "Konfirmasi", JOptionPane.OK_CANCEL_OPTION);
        if (ok == 0) {
            TableEmpty();
        }
    }//GEN-LAST:event_btnTableEmptyActionPerformed

    private void datatableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_datatableKeyReleased
        // TODO add your handling code here:
        GetData_View();
    }//GEN-LAST:event_datatableKeyReleased

    private void datatableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_datatableMouseClicked
        // TODO add your handling code here:
        GetData_View();
    }//GEN-LAST:event_datatableMouseClicked

    private void datatableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_datatableMouseReleased
        // TODO add your handling code here:
        GetData_View();
    }//GEN-LAST:event_datatableMouseReleased

    private void btnokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnokActionPerformed
        // TODO add your handling code here:
        String data1 = txtid_barang.getText();
        String data2 = txtkode_barang.getText();
        String data3 = lblnama_barang.getText();
        String data4 = txtjumlah_barang.getText();

        if (!(data1.equals("")) && !(data2.equals("")) && !(data3.equals("")) && !(data4.equals(""))) {
            int jumlah = Integer.parseInt(data4);
            int jumlah_max = Integer.parseInt(txtjumlah_barang_max.getText());
            if (jumlah <= jumlah_max) {
                Object[] row = {data1, data2, data3, data4};
                DefaultTableModel model = (DefaultTableModel) datatable.getModel();
                model.addRow(row);
                txtid_barang.setText("");
                txtkode_barang.setText("");
                lblnama_barang.setText("-");
                txtjumlah_barang.setText("");
                txtjumlah_barang_max.setText("");
                txtkode_barang.requestFocus();
            } else {
                JOptionPane.showMessageDialog(null, "Jumlah melebihi stok barang.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Terdapat inputan yang kosong.");
        }
    }//GEN-LAST:event_btnokActionPerformed

    private void txtjumlah_barangKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtjumlah_barangKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c)) && !(c == KeyEvent.VK_BACK_SPACE)) {
            JOptionPane.showMessageDialog(null, "Inputan hanya boleh angka", "Ilegal Input", JOptionPane.ERROR_MESSAGE);
            evt.consume();
        }
    }//GEN-LAST:event_txtjumlah_barangKeyTyped

    private void txtkode_barangFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtkode_barangFocusLost
        // TODO add your handling code here:
        String kode = txtkode_barang.getText();
        if (!kode.equals("")) {
            Integer same_kode = 0;
            DefaultTableModel model = (DefaultTableModel) datatable.getModel();
            int rowCount = model.getRowCount();
            for (int i = 0; i < rowCount; i++) {
                if (kode.equals(datatable.getModel().getValueAt(i, 1).toString())) {
                    same_kode = 1;
                }
            }

            if (same_kode == 0) {
                try {
                    Connection conn = koneksi.getConnection();
                    java.sql.Statement stm = conn.createStatement();
                    java.sql.ResultSet sql = stm.executeQuery("SELECT * FROM indbarang WHERE kode='" + kode + "'");
                    if (sql.next()) {
                        txtid_barang.setText(sql.getString("id"));
                        lblnama_barang.setText(sql.getString("nama"));
                        txtjumlah_barang_max.setText(sql.getString("stok"));
                    } else {
                        JOptionPane.showMessageDialog(null, "Kode barang tidak ditemukan.");
                        txtid_barang.setText("");
                        lblnama_barang.setText("-");
                        txtkode_barang.setText("");
                        txtjumlah_barang_max.setText("");
                    }
                    koneksi.closeConnection();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Error " + e);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(FormTransaksiMasuk.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Kode barang sudah pernah ditambah.");
                txtkode_barang.setText("");
            }
        } else {
            txtid_barang.setText("");
            lblnama_barang.setText("-");
            txtjumlah_barang_max.setText("");
        }
    }//GEN-LAST:event_txtkode_barangFocusLost

    private void cmbid_pelangganItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbid_pelangganItemStateChanged
        // TODO add your handling code here:
        String[] nama_kategori = cmbid_pelanggan.getSelectedItem().toString().split("\\s+");
        String kode = nama_kategori[0];
        if (!kode.equals("Pilih")) {
            try {
                Connection conn = koneksi.getConnection();
                java.sql.Statement stm = conn.createStatement();
                java.sql.ResultSet sql = stm.executeQuery("SELECT id FROM indpelanggan WHERE kode='" + kode + "'");
                if (sql.next()) {
                    txtid_pelanggan.setText(sql.getString("id"));
                }
                koneksi.closeConnection();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error " + e);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(FormTransaksiKeluar.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            txtid_pelanggan.setText("");
        }
    }//GEN-LAST:event_cmbid_pelangganItemStateChanged

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
            java.util.logging.Logger.getLogger(FormTransaksiKeluar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormTransaksiKeluar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormTransaksiKeluar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormTransaksiKeluar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
            FormTransaksiKeluar dialog = new FormTransaksiKeluar(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnDelRow;
    private javax.swing.JButton btnTableEmpty;
    private javax.swing.JButton btnok;
    private javax.swing.JButton btnsave;
    private javax.swing.JComboBox<String> cmbid_pelanggan;
    private javax.swing.JTable datatable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblnama_barang;
    private javax.swing.JTextField txtTgl;
    private javax.swing.JTextField txtid_barang;
    private javax.swing.JTextField txtid_pelanggan;
    private javax.swing.JTextField txtid_petugas;
    private javax.swing.JTextField txtid_selected;
    private javax.swing.JTextField txtjumlah_barang;
    private javax.swing.JTextField txtjumlah_barang_max;
    private javax.swing.JTextField txtkode_barang;
    private javax.swing.JTextField txtnm_petugas;
    // End of variables declaration//GEN-END:variables
}