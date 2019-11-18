/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import akun.LoginForm;
import bagasapplapor.BagasAppLapor;

/**
 *
 * @author bagas
 */
public class Tambah extends javax.swing.JFrame {

    /**
     * Creates new form Tambah
     */
    private NikService service;
    private int tag = 0;
    private int index;
    DefaultTableModel dtm;
    
    public Tambah() {
        initComponents();
        service = new NikServiceImp();
        setLocationRelativeTo(null);
        tfNik.requestFocus();
        this.view();
    }
    
        public void view() {
        //menghubungkan komponen table dan tabelmodel
        Table.setModel(service.view());
    }
    
     public void save() {
        Nik p = new Nik();
        int i = 1;
        p.setIdnik(String.valueOf(tfNik.getText()));
        p.setLaporan(tfBox.getText());
        boolean already_exists = false;

        if (tag == 0) {
            //insert
            for (Nik m : Data.list) { //melakukan perulangan pada sejumlah object data pada listregistrasi
                if (m.getIdnik().equals(tfNik.getText())) { //jika data pada object dan inputan itu sama, maka
                    already_exists = true; //mengubah variabel already_exists menjadi true 
                    JOptionPane.showMessageDialog(null, "Data sudah tersedia", "Warning", JOptionPane.WARNING_MESSAGE); //maka muncul warning bahwa data sudah tersedia
                    tfNik.requestFocus();
                    break; //langsung menghentikan perulangan
                }
            }

            if (Data.list.isEmpty()) { //jika data pada listmahasiswa kosong, maka 
                service.insert(p); //melakukan penambahan data arraylist
                reset();
            } else if (!Data.list.isEmpty() && !already_exists) { //jika data tidak kosong dan already_exists masih false, maka
                service.insert(p); //bisa menambahkan data pada arraylist
                reset();
            }

        } else if (tag == 1) {
            //update
            String samaJenis = "... Pilih jenis product ...";
            if (tfNik.getText().trim().equals("") || tfBox.getText().trim().equals("")) {
                JOptionPane.showMessageDialog(null, "Maaf... Data belum lengkap!");
                tfNik.requestFocus();
            } else {
                index = Table.getSelectedRow();
                service.update(index, p);
                reset();
            }
        }
        view();

        tfNik.setEnabled(true);
    }

    public void getRecord() {
        int record = Table.getRowCount();
        if (record > 0) {
            int seleksi = Table.getSelectedRowCount();
            if (seleksi > 0) {
                tag = 1;
                index = Table.getSelectedRow();
                tfNik.setText(Table.getValueAt(index, 0).toString());
               tfNik.setEnabled(false);
                tfBox.setText(Table.getValueAt(index, 1).toString());
            } else {
                JOptionPane.showMessageDialog(null, "Pilih data yang ingin diubah!", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Data masih kosong!", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void delete() {

        service.delete(index);
        view();

    }

    public void reset() {
        tag = 0;
        tfNik.setText("");
        tfNik.requestFocus();
        tfNik.setEnabled(true);
                tfBox.setText("");
    }
    
    public void logOut() {
     
              }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tfNik = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tfBox = new javax.swing.JTextArea();
        btnSimpan2 = new javax.swing.JToggleButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnLogout = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tfBox.setColumns(20);
        tfBox.setRows(5);
        jScrollPane1.setViewportView(tfBox);

        btnSimpan2.setText("Simpan");
        btnSimpan2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpan2ActionPerformed(evt);
            }
        });

        Table.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(Table);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Project/2.png"))); // NOI18N

        jLabel2.setText("MASUKKAN NIK");

        jLabel3.setText("MASUKAN LAPORAN");

        btnLogout.setText("LOGOUT");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        jButton1.setText("Hapus");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnLogout)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnSimpan2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(tfNik)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(1, 1, 1)
                .addComponent(tfNik, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addGap(4, 4, 4)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSimpan2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLogout)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSimpan2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpan2ActionPerformed
        // TODO add your handling code here:
         String samaJenis = "... Pilih jenis product ...";
        if (tfNik.getText().trim().equals("") || tfBox.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Maaf... Data belum lengkap!");
            tfNik.requestFocus();
        } else {
            save();
        }
    }                                         

    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {                                        
        getRecord();
    }                                       

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {                                         
        reset();
        int record = Table.getRowCount();
        if (record > 0) {
            int seleksi = Table.getSelectedRowCount();
            if (seleksi > 0) {
                int konfirmasi = JOptionPane.showConfirmDialog(rootPane, "Data akan dihapus?", "konfirmasi", JOptionPane.YES_NO_OPTION);
                if (konfirmasi == JOptionPane.YES_OPTION) {
                    delete();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Pilih data yang ingin dihapus!", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        }
    }                                        

    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {                                         
        reset();
        this.setVisible(false);
    }//GEN-LAST:event_btnSimpan2ActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        // TODO add your handling code here:
        int konfirmasi = JOptionPane.showConfirmDialog(rootPane, "Anda akan logout?", "konfirmasi", JOptionPane.YES_NO_OPTION);
        if (konfirmasi == JOptionPane.YES_OPTION) {
            logOut();
            new akun.LoginForm().setVisible(true);
            this.hide();
        }
    }//GEN-LAST:event_btnLogoutActionPerformed

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
            java.util.logging.Logger.getLogger(Tambah.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tambah.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tambah.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tambah.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tambah().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Table;
    private javax.swing.JButton btnLogout;
    private javax.swing.JToggleButton btnSimpan2;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea tfBox;
    private javax.swing.JTextField tfNik;
    // End of variables declaration//GEN-END:variables

   
}