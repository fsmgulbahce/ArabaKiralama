/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kullanicilar.Ekranlar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.WindowConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Rosegarden
 */
public class ArabaKirala extends javax.swing.JFrame {

    static int kacGun;
    LocalDate localDate = LocalDate.now();
    int yil = localDate.getYear();
    int ay = localDate.getMonthValue();
    int gun = localDate.getDayOfMonth();

    /**
     * Creates new form ArabaKiralama
     */
    DefaultTableModel dtm = new DefaultTableModel();

    public ArabaKirala() {
        initComponents();
        this.setTitle("Araba Kiralama");
        tarih();
        this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        dtm.setColumnIdentifiers(new Object[]{"Araba Modeli", "Günlük Ücret"});
        sistemdeBulunanArabalarTable.setModel(dtm);

        ArabaListesi.arabaYukle();
        for (int i = 0; i < ArabaListesi.arabalarim.size(); i++) {
            dtm.addRow(new Object[]{ArabaListesi.arabalarim.get(i).model, ArabaListesi.arabalarim.get(i).fiyat});
        }

        sistemdeBulunanArabalarTable.setCellSelectionEnabled(true);
        ListSelectionModel cellSelectionModel = sistemdeBulunanArabalarTable.getSelectionModel();
        cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        cellSelectionModel.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {

                int selectedData = 0;
                int[] selectedRow = sistemdeBulunanArabalarTable.getSelectedRows();

                for (int i = 0; i < selectedRow.length; i++) {
                    selectedData = Integer.parseInt(sistemdeBulunanArabalarTable.getValueAt(selectedRow[i], 1).toString());
                }
                try {

                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    Date alisTarihi = sdf.parse(alinabilecekTarihCombo.getSelectedItem().toString());
                    Date verilisTarihi = sdf.parse(verilebilecekTarihCombo.getSelectedItem().toString());
                    //int gunUcret = Integer.parseInt(dtm.getValueAt(sistemdeBulunanArabalarTable.getSelectedRow(), 1).toString());
                    if (alisTarihi.compareTo(verilisTarihi) < 0) {
                        long diff = verilisTarihi.getTime() - alisTarihi.getTime();
                        long gun = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
                        double fiyat = gun * selectedData;
                        fiyatTxt.setText(String.valueOf(fiyat));

                    } else {
                        JOptionPane.showMessageDialog(arabaKiralaBtn, "Veriliş Tarihi, Alış Tarihinden önce olamaz!...", "TARİH HATASI", JOptionPane.WARNING_MESSAGE);
                    }

                } catch (ParseException ex) {
                    Logger.getLogger(ArabaKirala.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        sistemdeBulunanArabalarTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        alinabilecekTarihCombo = new javax.swing.JComboBox<>();
        verilebilecekTarihCombo = new javax.swing.JComboBox<>();
        arabaKiralaBtn = new javax.swing.JButton();
        aramaTxt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        araBtn = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        fiyatTxt = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        hepsiniGosterBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(null);

        sistemdeBulunanArabalarTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(sistemdeBulunanArabalarTable);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 190, 520, 290);

        jLabel1.setText("Alınabilecek Tarih:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 110, 120, 16);

        jLabel2.setText("Verilebiecek Tarih: ");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(350, 110, 120, 16);

        getContentPane().add(alinabilecekTarihCombo);
        alinabilecekTarihCombo.setBounds(140, 100, 190, 30);

        getContentPane().add(verilebilecekTarihCombo);
        verilebilecekTarihCombo.setBounds(480, 100, 190, 30);

        arabaKiralaBtn.setText("Araba Kirala");
        arabaKiralaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                arabaKiralaBtnActionPerformed(evt);
            }
        });
        getContentPane().add(arabaKiralaBtn);
        arabaKiralaBtn.setBounds(540, 190, 120, 25);
        getContentPane().add(aramaTxt);
        aramaTxt.setBounds(140, 10, 410, 30);

        jLabel3.setText("Arama:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(20, 10, 110, 30);

        araBtn.setText("Ara");
        araBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                araBtnActionPerformed(evt);
            }
        });
        getContentPane().add(araBtn);
        araBtn.setBounds(570, 10, 80, 30);

        jLabel4.setText("Fiyat:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(10, 160, 70, 16);

        fiyatTxt.setEnabled(false);
        getContentPane().add(fiyatTxt);
        fiyatTxt.setBounds(140, 160, 150, 22);

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Modele göre veya girilen değer ve altındaki değerleri gösterir.");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(140, 50, 400, 16);

        hepsiniGosterBtn.setText("Hepsini Göster");
        hepsiniGosterBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hepsiniGosterBtnActionPerformed(evt);
            }
        });
        getContentPane().add(hepsiniGosterBtn);
        hepsiniGosterBtn.setBounds(540, 230, 120, 25);

        setSize(new java.awt.Dimension(751, 541));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_formWindowClosing

    private void arabaKiralaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_arabaKiralaBtnActionPerformed
        // TODO add your handling code here:
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date alisTarihi = sdf.parse(alinabilecekTarihCombo.getSelectedItem().toString());
            Date verilisTarihi = sdf.parse(verilebilecekTarihCombo.getSelectedItem().toString());
            if (alisTarihi.compareTo(verilisTarihi) < 0) {
                MusteriEkrani.dtm2.addRow(new Object[]{dtm.getValueAt(sistemdeBulunanArabalarTable.getSelectedRow(), 0), fiyatTxt.getText(),
                    alinabilecekTarihCombo.getSelectedItem(), verilebilecekTarihCombo.getSelectedItem()});
            } else {
                JOptionPane.showMessageDialog(arabaKiralaBtn, "Veriliş Tarihi, Alış Tarihinden önce olamaz!...", "Tarih Hatası", JOptionPane.WARNING_MESSAGE);
            }
        } catch (ParseException ex) {
            Logger.getLogger(ArabaKirala.class.getName()).log(Level.SEVERE, null, ex);
        }
        dtm.removeRow(sistemdeBulunanArabalarTable.getSelectedRow());
    }//GEN-LAST:event_arabaKiralaBtnActionPerformed
    ArabaListesi bulunanAraba = null;
    private void araBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_araBtnActionPerformed
        // TODO add your handling code here:
        if (aramaTxt.getText().isEmpty()) {
            JOptionPane.showMessageDialog(arabaKiralaBtn, "Arama Kısmı Boş Bırakılamaz!.. ", "Arama Boş Hatası", JOptionPane.WARNING_MESSAGE);
        } else {
            dtm.setRowCount(0);

            try {
                for (ArabaListesi araba : ArabaListesi.arabalarim) {
                    if (aramaTxt.getText().equals(araba.model) || araba.fiyat <= Integer.parseInt(aramaTxt.getText())) {
                        dtm.addRow(new Object[]{araba.model, araba.fiyat});
                        bulunanAraba = araba;
                    }
                }
            } catch (NumberFormatException ex) {

            }

        }
        if (bulunanAraba == null) {
            JOptionPane.showMessageDialog(araBtn, "Arama Kısmı Boş Bırakılamaz!.. ", "Arama Boş Hatası", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_araBtnActionPerformed

    private void hepsiniGosterBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hepsiniGosterBtnActionPerformed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_hepsiniGosterBtnActionPerformed
    private void tarih() {

        for (int i = 0; i < 14; i++) {

            alinabilecekTarihCombo.addItem(gun + "/" + ay + "/" + yil);
            gun++;

            switch (ay) {
                case 1:
                    if (gun > 31) {
                        gun = 1;
                        ay += 1;
                    }
                case 2:

                    if ((yil % 4 == 0) && (!(yil % 100 == 0) || (yil % 400 == 0))) {
                        if (gun > 29) {
                            gun = 1;
                            ay += 1;
                        }
                    } else {
                        if (gun > 28) {
                            gun = 1;
                            ay += 1;
                        }
                    }

                case 3:
                    if (gun > 31) {
                        gun = 1;
                        ay += 1;
                    }
                case 4:
                    if (gun > 30) {
                        gun = 1;
                        ay += 1;
                    }
                case 5:
                    if (gun > 31) {
                        gun = 1;
                        ay += 1;
                    }
                case 6:
                    if (gun > 30) {
                        gun = 1;
                        ay += 1;
                    }
                case 7:
                    if (gun > 31) {
                        gun = 1;
                        ay += 1;
                    }
                case 8:
                    if (gun > 31) {
                        gun = 1;
                        ay += 1;
                    }
                case 9:
                    if (gun > 30) {
                        gun = 1;
                        ay += 1;
                    }
                case 10:
                    if (gun > 31) {
                        gun = 1;
                        ay += 1;
                    }
                case 11:
                    if (gun > 30) {
                        gun = 1;
                        ay += 1;
                    }
                case 12:
                    if (gun > 31) {
                        gun = 1;
                        ay = 1;
                        yil += 1;
                    }
            }

            verilebilecekTarihCombo.addItem(gun + "/" + ay + "/" + yil);

        }

    }

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
            java.util.logging.Logger.getLogger(ArabaKirala.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ArabaKirala.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ArabaKirala.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ArabaKirala.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ArabaKirala().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> alinabilecekTarihCombo;
    private javax.swing.JButton araBtn;
    private javax.swing.JButton arabaKiralaBtn;
    private javax.swing.JTextField aramaTxt;
    private javax.swing.JTextField fiyatTxt;
    private javax.swing.JButton hepsiniGosterBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable sistemdeBulunanArabalarTable;
    private javax.swing.JComboBox<String> verilebilecekTarihCombo;
    // End of variables declaration//GEN-END:variables
}
