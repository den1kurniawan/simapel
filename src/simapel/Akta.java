/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package simapel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import java.io.*;
import com.itextpdf.text.pdf.draw.LineSeparator;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.awt.Desktop;

public class Akta extends javax.swing.JFrame {
DefaultTableModel model;

    public Akta() {
        initComponents();
    // Set NIK dan Nama dari session
    txtNik.setText(Session.get_nik());
    txtNama.setText(Session.get_nama());

    // Biar tidak bisa diedit manual
    txtNik.setEnabled(false);
    txtNama.setEnabled(false);

String[] judul = {
    "ID", "Layanan", "NIK", "Nama", "TTL", "Alamat", "Jenis Kelamin",
    "Golongan Darah", "RT/RW", "Desa", "Kecamatan", "Agama",
    "Pekerjaan", "Status Validasi", "Alasan Penolakn", "Waktu Pengajuan"
};

model = new DefaultTableModel(judul, 0);
tblPermohonan.setModel(model);
getData(); // memuat data dari database ke tabel

        
        cmbGolda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{
         "A", "B", "AB", "O"}));
        
        bgJK.add(rbLaki);
        bgJK.add(rbPerem);

tblPermohonan.addMouseListener(new MouseAdapter() {
    public void mouseClicked(MouseEvent e) {
        int row = tblPermohonan.getSelectedRow();
        if (row != -1) {
            txtNik.setText(tblPermohonan.getValueAt(row, 2).toString()); // NIK
            txtNama.setText(tblPermohonan.getValueAt(row, 3).toString()); // Nama
            txtTTL.setText(tblPermohonan.getValueAt(row, 4).toString()); // TTL
            txtAlamt.setText(tblPermohonan.getValueAt(row, 5).toString()); // Alamat
            
            String jk = tblPermohonan.getValueAt(row, 6).toString();
            if (jk.equals("Laki-laki")) {
                rbLaki.setSelected(true);
            } else {
                rbPerem.setSelected(true);
            }

            cmbGolda.setSelectedItem(tblPermohonan.getValueAt(row, 7).toString()); // Gol Darah
            txtRt.setText(tblPermohonan.getValueAt(row, 8).toString()); // RT/RW
            txtDesa.setText(tblPermohonan.getValueAt(row, 9).toString()); // Desa
            txtKec.setText(tblPermohonan.getValueAt(row, 10).toString()); // Kecamatan
            txtAgama.setText(tblPermohonan.getValueAt(row, 11).toString()); // Agama
            txtKerja.setText(tblPermohonan.getValueAt(row, 12).toString()); // Pekerjaan
       

    }
    }
    });
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgJK = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        nik = new javax.swing.JLabel();
        nama = new javax.swing.JLabel();
        txtNik = new javax.swing.JTextField();
        txtNama = new javax.swing.JTextField();
        ttl = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        alamat = new javax.swing.JLabel();
        Golda = new javax.swing.JLabel();
        txtTTL = new javax.swing.JTextField();
        txtAlamt = new javax.swing.JTextField();
        txtRt = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtAgama = new javax.swing.JTextField();
        txtKec = new javax.swing.JTextField();
        txtDesa = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txtKerja = new javax.swing.JTextField();
        rbLaki = new javax.swing.JRadioButton();
        rbPerem = new javax.swing.JRadioButton();
        cmbGolda = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPermohonan = new javax.swing.JTable();
        btnKirim = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnSimpan = new javax.swing.JButton();
        btnPrint = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jmenuRefresh = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jmenuKeluar = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jmenuKtp = new javax.swing.JMenuItem();
        jmenuKK = new javax.swing.JMenuItem();
        jmenuAkta = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(52, 116, 51));

        nik.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        nik.setForeground(new java.awt.Color(255, 255, 255));
        nik.setText("NIK");

        nama.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        nama.setForeground(new java.awt.Color(255, 255, 255));
        nama.setText("Nama");

        ttl.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ttl.setForeground(new java.awt.Color(255, 255, 255));
        ttl.setText("Tempat/Tgl Lahir");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Alamat");

        alamat.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        alamat.setForeground(new java.awt.Color(255, 255, 255));
        alamat.setText("Jenis Kelamin");

        Golda.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Golda.setForeground(new java.awt.Color(255, 255, 255));
        Golda.setText("Golongan Darah");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Agama");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Kecamatan");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Kel/Desa");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("RT/RW");

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Pekerjaan");

        rbLaki.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        rbLaki.setForeground(new java.awt.Color(255, 255, 255));
        rbLaki.setText("Laki-laki");

        rbPerem.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        rbPerem.setForeground(new java.awt.Color(255, 255, 255));
        rbPerem.setText("Perempuan");

        jPanel2.setBackground(new java.awt.Color(164, 180, 101));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("AKTA KELAHIRAN");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(394, 394, 394)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel3)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        tblPermohonan.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblPermohonan);

        btnKirim.setBackground(new java.awt.Color(164, 180, 101));
        btnKirim.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnKirim.setForeground(new java.awt.Color(255, 255, 255));
        btnKirim.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/kirim.png"))); // NOI18N
        btnKirim.setText("KIRIM");
        btnKirim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKirimActionPerformed(evt);
            }
        });

        btnEdit.setBackground(new java.awt.Color(164, 180, 101));
        btnEdit.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnEdit.setForeground(new java.awt.Color(255, 255, 255));
        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/EDIT.png"))); // NOI18N
        btnEdit.setText("EDIT");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnHapus.setBackground(new java.awt.Color(164, 180, 101));
        btnHapus.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnHapus.setForeground(new java.awt.Color(255, 255, 255));
        btnHapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/delete.png"))); // NOI18N
        btnHapus.setText("DELETE");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        btnSimpan.setBackground(new java.awt.Color(164, 180, 101));
        btnSimpan.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSimpan.setForeground(new java.awt.Color(255, 255, 255));
        btnSimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/SIMPAN.png"))); // NOI18N
        btnSimpan.setText("SIMPAN");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        btnPrint.setBackground(new java.awt.Color(164, 180, 101));
        btnPrint.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnPrint.setForeground(new java.awt.Color(255, 255, 255));
        btnPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/printing.png"))); // NOI18N
        btnPrint.setText("PRINT");
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnPrint)
                        .addGap(37, 37, 37)
                        .addComponent(btnKirim))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jScrollPane1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(nik, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(66, 66, 66))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(nama, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel9)
                                            .addComponent(alamat))
                                        .addGap(39, 39, 39))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(ttl)
                                        .addGap(18, 18, 18)))))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNik, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTTL, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAlamt, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(rbLaki, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Golda)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbGolda, 0, 1, Short.MAX_VALUE))
                            .addComponent(rbPerem))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 138, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(btnSimpan)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(btnHapus))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtAgama, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtKec, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtDesa, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtRt, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtKerja, javax.swing.GroupLayout.Alignment.LEADING))))))
                .addGap(31, 31, 31))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtRt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDesa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtKec)
                            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtAgama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtKerja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNik)
                            .addComponent(nik, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtTTL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ttl)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nama))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtAlamt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rbLaki)
                            .addComponent(Golda)
                            .addComponent(cmbGolda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(alamat))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbPerem)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnHapus)
                    .addComponent(btnEdit)
                    .addComponent(btnSimpan))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnKirim)
                    .addComponent(btnPrint))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        jMenu1.setText("Beranda");

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/beranda.png"))); // NOI18N
        jMenuItem1.setText("Beranda");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jmenuRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/refresh.png"))); // NOI18N
        jmenuRefresh.setText("Refresh");
        jmenuRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmenuRefreshActionPerformed(evt);
            }
        });
        jMenu1.add(jmenuRefresh);
        jMenu1.add(jSeparator1);

        jmenuKeluar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/exit.png"))); // NOI18N
        jmenuKeluar.setText("Keluar");
        jmenuKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmenuKeluarActionPerformed(evt);
            }
        });
        jMenu1.add(jmenuKeluar);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Layanan");

        jmenuKtp.setText("KTP");
        jmenuKtp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmenuKtpActionPerformed(evt);
            }
        });
        jMenu2.add(jmenuKtp);

        jmenuKK.setText("Kartu Keluarga");
        jmenuKK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmenuKKActionPerformed(evt);
            }
        });
        jMenu2.add(jmenuKK);

        jmenuAkta.setText("Akta Kelahiran");
        jmenuAkta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmenuAktaActionPerformed(evt);
            }
        });
        jMenu2.add(jmenuAkta);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        Permohonan newWin = new Permohonan();
        newWin.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jmenuRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmenuRefreshActionPerformed
        getData();
    }//GEN-LAST:event_jmenuRefreshActionPerformed

    private void jmenuKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmenuKeluarActionPerformed
        Login newWin = new Login();
        newWin.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jmenuKeluarActionPerformed

    private void jmenuKtpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmenuKtpActionPerformed
        Ktp newWin = new Ktp();
        newWin.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jmenuKtpActionPerformed

    private void jmenuKKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmenuKKActionPerformed
        Kk newWin = new Kk();
        newWin.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jmenuKKActionPerformed

    private void jmenuAktaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmenuAktaActionPerformed
        Akta newWin = new Akta();
        newWin.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jmenuAktaActionPerformed

    private void btnKirimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKirimActionPerformed
        try {
            int selectedRow = tblPermohonan.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(this, "Pilih data yang akan dikirim!");
                return;
            }

            String id = tblPermohonan.getValueAt(selectedRow, 0).toString();

            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/simapel", "root", "");
            String sql = "UPDATE permohonan SET status_validasi_admin = 'menunggu' WHERE id_permohonan = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, id);
            pst.executeUpdate();

            JOptionPane.showMessageDialog(this, "Permohonan berhasil dikirim ke admin!");

            getData(); // refresh tabel
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Gagal mengirim permohonan: " + e.getMessage());
        }

    }//GEN-LAST:event_btnKirimActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        try {
            int selectedRow = tblPermohonan.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(null, "Pilih baris yang akan diedit!");
                return;
            }

            String id = tblPermohonan.getValueAt(selectedRow, 0).toString();
            String nama = txtNama.getText();
            String ttl = txtTTL.getText();
            String alamat = txtAlamt.getText();
            String jenisKelamin = rbLaki.isSelected() ? "Laki-laki" : "Perempuan";
            String golDarah = cmbGolda.getSelectedItem().toString();
            String rtRw = txtRt.getText();
            String kelDesa = txtDesa.getText();
            String kecamatan = txtKec.getText();
            String agama = txtAgama.getText();
            String pekerjaan = txtKerja.getText();

            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/simapel", "root", "");
            cn.createStatement().executeUpdate(
                "UPDATE permohonan SET " +
                "nama='" + nama + "', " +
                "ttl='" + ttl + "', " +
                "alamat='" + alamat + "', " +
                "jenis_kelamin='" + jenisKelamin + "', " +
                "gol_darah='" + golDarah + "', " +
                "rt_rw='" + rtRw + "', " +
                "kel_desa='" + kelDesa + "', " +
                "kecamatan='" + kecamatan + "', " +
                "agama='" + agama + "', " +
                "pekerjaan='" + pekerjaan + "' " +
                "WHERE id_permohonan=" + id
            );

            JOptionPane.showMessageDialog(null, "Data berhasil diubah!");
            getData(); // atau getData(), sesuai nama method-mu untuk refresh tabel
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        try {
    int selectedRow = tblPermohonan.getSelectedRow();
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(null, "Pilih baris yang akan dihapus!");
        return;
    }

    String nik = txtNik.getText();

    int confirm = JOptionPane.showConfirmDialog(null,
        "Apakah yakin ingin menghapus permohonan Akta dengan NIK: " + nik + "?",
        "Konfirmasi Hapus",
        JOptionPane.YES_NO_OPTION);

    if (confirm == JOptionPane.YES_OPTION) {
        Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/simapel", "root", "");
        String sql = "DELETE FROM permohonan WHERE nik = ? AND layanan = 'Akta'";
        PreparedStatement pst = cn.prepareStatement(sql);
        pst.setString(1, nik);
        pst.executeUpdate();

        JOptionPane.showMessageDialog(null, "Permohonan Akta berhasil dihapus!");
        getData(); // refresh tabel
    }
} catch (Exception ex) {
    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
}

    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/simapel", "root", "");

            String layanan = "Akta";
            String nik = txtNik.getText();
            String nama = txtNama.getText();
            String ttl = txtTTL.getText();
            String alamat = txtAlamt.getText();
            String jenisKelamin = rbLaki.isSelected() ? "Laki-laki" : "Perempuan";
            String golDarah = cmbGolda.getSelectedItem().toString();
            String rtRw = txtRt.getText();
            String desa = txtDesa.getText();
            String kecamatan = txtKec.getText();
            String agama = txtAgama.getText();
            String pekerjaan = txtKerja.getText();

            cn.createStatement().executeUpdate(
                "INSERT INTO permohonan (layanan, nik, nama, ttl, alamat, jenis_kelamin, gol_darah, rt_rw, kel_desa, kecamatan, agama, pekerjaan, status_validasi_admin, waktu_pengajuan) VALUES (" +
                "'" + layanan + "'," +
                "'" + nik + "'," +
                "'" + nama + "'," +
                "'" + ttl + "'," +
                "'" + alamat + "'," +
                "'" + jenisKelamin + "'," +
                "'" + golDarah + "'," +
                "'" + rtRw + "'," +
                "'" + desa + "'," +
                "'" + kecamatan + "'," +
                "'" + agama + "'," +
                "'" + pekerjaan + "'," +
                "'Menunggu'," +
                "NOW()" +
                ")"
            );

            JOptionPane.showMessageDialog(null, "Data berhasil disimpan!");
            getData(); // refresh tabel

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Gagal Simpan: " + ex.getMessage());
        }
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
   btnPrint.addActionListener(e -> {
       int selectedRow = tblPermohonan.getSelectedRow();
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(this, "Silakan pilih data permohonan terlebih dahulu.");
        return;
    }

    String status = tblPermohonan.getValueAt(selectedRow, 13).toString(); // indeks ke-13 = status_validasi_admin
    if (!status.equalsIgnoreCase("selesai")) {
        JOptionPane.showMessageDialog(this, "❌ Data belum bisa dicetak. Status permohonan '" + status + "'.");
        return;
    }
    
    try {
        String filePath = System.getProperty("user.home") + "/Downloads/surat_keterangan_AKTA.pdf";
        Document document = new Document(PageSize.A4, 40, 40, 30, 30); // Margin 4-4-3-3 kira-kira
        PdfWriter.getInstance(document, new FileOutputStream(filePath));
        document.open();

        // Font
        Font bold16 = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD);
        Font bold14 = new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD);
        Font bold12 = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
        Font normal12 = new Font(Font.FontFamily.TIMES_ROMAN, 12);

        // === KOP SURAT (Logo + Header Tengah) ===
        PdfPTable kop = new PdfPTable(2);
        kop.setWidthPercentage(100);
        kop.setWidths(new float[]{1.5f, 6.5f});

        // Logo
        InputStream logoStream = getClass().getResourceAsStream("/simapel/logo.png");
        PdfPCell logoCell;
        if (logoStream != null) {
            Image logo = Image.getInstance(javax.imageio.ImageIO.read(logoStream), null);
            logo.scaleAbsolute(70, 70);
            logoCell = new PdfPCell(logo, false);
        } else {
            logoCell = new PdfPCell(new Phrase(""));
        }
        logoCell.setBorder(Rectangle.NO_BORDER);
        logoCell.setRowspan(4);
        logoCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        logoCell.setHorizontalAlignment(Element.ALIGN_CENTER);
        kop.addCell(logoCell);

        // Header Teks
        PdfPCell teksKop = new PdfPCell();
        teksKop.setBorder(Rectangle.NO_BORDER);
        teksKop.setHorizontalAlignment(Element.ALIGN_CENTER);
        teksKop.addElement(new Paragraph("PEMERINTAH KOTA PALOPO", bold16));
        teksKop.addElement(new Paragraph("DINAS KEPENDUDUKAN DAN PENCATATAN SIPIL", bold14));
        teksKop.addElement(new Paragraph("Jl. K.H. Moh. Hasyim No.54, Tompotikka, Kec. Wara Sel., Kota Palopo 91922", normal12));
        kop.addCell(teksKop);
        document.add(kop);

        LineSeparator garis = new LineSeparator();
        garis.setLineWidth(1.2f);
        document.add(new Chunk(garis));
        document.add(Chunk.NEWLINE);
        
        // Judul
        Paragraph judul = new Paragraph("SURAT KETERANGAN\nAKTA KELAHIRAN\n\n", bold14);
        judul.setAlignment(Element.ALIGN_CENTER);
        document.add(judul);

        // Isi pembuka
        document.add(new Paragraph("Yang bertanda tangan di bawah ini menerangkan bahwa data berikut adalah benar dan telah "
                + "didaftarkan dalam sistem administrasi kependudukan sebagai syarat penerbitan Akta Kelahiran:\n", normal12));

        // === TABEL IDENTITAS ===
        PdfPTable identitas = new PdfPTable(2);
        identitas.setWidths(new float[]{3f, 7f});
        identitas.setWidthPercentage(100);

        identitas.setSpacingBefore(10f);
        identitas.setSpacingAfter(10f);

        String[][] data = {
                {"NIK", txtNik.getText()},
                {"Nama", txtNama.getText()},
                {"Tempat/Tgl Lahir", txtTTL.getText()},
                {"Jenis Kelamin", rbLaki.isSelected() ? "Laki-laki" : "Perempuan"},
                {"Agama", txtAgama.getText()},
                {"Alamat", txtAlamt.getText()},
                {"RT/RW", txtRt.getText()},
                {"Kelurahan", txtDesa.getText()},
                {"Kecamatan", txtKec.getText()},
                {"Golongan Darah", cmbGolda.getSelectedItem().toString()},
                {"Pekerjaan", txtKerja.getText()}
        };

        for (String[] row : data) {
            PdfPCell label = new PdfPCell(new Phrase(row[0], normal12));
            label.setBorder(Rectangle.NO_BORDER);
            PdfPCell value = new PdfPCell(new Phrase(": " + row[1], normal12));
            value.setBorder(Rectangle.NO_BORDER);
            identitas.addCell(label);
            identitas.addCell(value);
        }

        document.add(identitas);

        // Kalimat penutup resmi
        document.add(new Paragraph(
                "Demikian surat keterangan ini dibuat untuk digunakan sebagai persyaratan dalam penerbitan atau pembaruan "
                + "Akta Kelahiran di lingkungan Pemerintah Kota Palopo. Segala bentuk informasi yang tercantum adalah hasil "
                + "dari proses verifikasi dan perekaman data secara elektronik.", normal12));

        document.add(Chunk.NEWLINE);

        // === TANDA TANGAN PIMPINAN (RATA KANAN) ===
        PdfPTable ttd = new PdfPTable(1);
        ttd.setWidthPercentage(40);
        ttd.setHorizontalAlignment(Element.ALIGN_RIGHT);

        PdfPCell ttdCell = new PdfPCell();
        ttdCell.setBorder(Rectangle.NO_BORDER);
        String tanggal = new SimpleDateFormat("dd MMMM yyyy").format(new Date());
        ttdCell.addElement(new Paragraph("Palopo, " + tanggal, normal12));
        ttdCell.addElement(new Paragraph("Mengetahui,", normal12));
        ttdCell.addElement(new Paragraph("Pimpinan", normal12));
        ttdCell.addElement(new Paragraph("\n"));

        InputStream ttdStream = getClass().getResourceAsStream("/simapel/ttd.png");
        if (ttdStream != null) {
            Image ttdImg = Image.getInstance(javax.imageio.ImageIO.read(ttdStream), null);
            ttdImg.scaleAbsolute(100, 50);
            ttdCell.addElement(ttdImg);
        }

        ttdCell.addElement(new Paragraph("Prof. Dr. Deni Kurniawan, M.Kom", bold12));
        ttdCell.addElement(new Paragraph("NIP. 19780410 200501 1 001", normal12));
        ttd.addCell(ttdCell);
        document.add(ttd);

        document.close();

        int pilihan = JOptionPane.showConfirmDialog(this,
                "✅ Surat berhasil dibuat!\nFile disimpan di:\n" + filePath + "\n\nIngin membukanya sekarang?",
                "Surat Keterangan KK",
                JOptionPane.YES_NO_OPTION);
        if (pilihan == JOptionPane.YES_OPTION && Desktop.isDesktopSupported()) {
            Desktop.getDesktop().open(new File(filePath));
        }

    } catch (Exception ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(this, "❌ Gagal membuat surat: " + ex.getMessage());
    }
});
    }//GEN-LAST:event_btnPrintActionPerformed

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
            java.util.logging.Logger.getLogger(Akta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Akta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Akta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Akta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Akta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Golda;
    private javax.swing.JLabel alamat;
    private javax.swing.ButtonGroup bgJK;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnKirim;
    private javax.swing.JButton btnPrint;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JComboBox<String> cmbGolda;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JMenuItem jmenuAkta;
    private javax.swing.JMenuItem jmenuKK;
    private javax.swing.JMenuItem jmenuKeluar;
    private javax.swing.JMenuItem jmenuKtp;
    private javax.swing.JMenuItem jmenuRefresh;
    private javax.swing.JLabel nama;
    private javax.swing.JLabel nik;
    private javax.swing.JRadioButton rbLaki;
    private javax.swing.JRadioButton rbPerem;
    private javax.swing.JTable tblPermohonan;
    private javax.swing.JLabel ttl;
    private javax.swing.JTextField txtAgama;
    private javax.swing.JTextField txtAlamt;
    private javax.swing.JTextField txtDesa;
    private javax.swing.JTextField txtKec;
    private javax.swing.JTextField txtKerja;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtNik;
    private javax.swing.JTextField txtRt;
    private javax.swing.JTextField txtTTL;
    // End of variables declaration//GEN-END:variables

    private void getData() {
    DefaultTableModel model = (DefaultTableModel) tblPermohonan.getModel();
    model.setRowCount(0); // hapus isi tabel lama

    try {
        String nikLogin = Session.get_nik(); // ambil nik dari session login
        Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/simapel", "root", "");
        String sql = "SELECT * FROM permohonan WHERE layanan = 'Akta' AND nik = ?";
        PreparedStatement pst = cn.prepareStatement(sql);
        pst.setString(1, nikLogin);

        ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            String data[] = {
                rs.getString("id_permohonan"),
                rs.getString("layanan"),
                rs.getString("nik"),
                rs.getString("nama"),
                rs.getString("ttl"),
                rs.getString("alamat"),
                rs.getString("jenis_kelamin"),
                rs.getString("gol_darah"),
                rs.getString("rt_rw"),
                rs.getString("kel_desa"),
                rs.getString("kecamatan"),
                rs.getString("agama"),
                rs.getString("pekerjaan"),
                rs.getString("status_validasi_admin"),
                rs.getString("alasan_penolakan"),
                rs.getString("waktu_pengajuan")
            };
            model.addRow(data);
        }

    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, ex.getMessage());
    }
}
}

