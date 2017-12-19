/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kullanicilar;

import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import kullanicilar.Ekranlar.MusteriEkrani;
import kullanicilar.uyeOl.MusteriUyeOl;

/**
 *
 * @author Rosegarden
 */
public class MüsteriGiris extends javax.swing.JFrame {

    /**
     * Creates new form MüsteriGiris
     */
    public MüsteriGiris() {
        initComponents();
        this.getContentPane().setBackground(Color.WHITE);
        this.setTitle("Müşteri Girişi");
        this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
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
        jLabel2 = new javax.swing.JLabel();
        kimlikNoTxt = new javax.swing.JTextField();
        sifreTxt = new javax.swing.JPasswordField();
        uyeOlBtn = new javax.swing.JButton();
        girisBtn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(null);

        jLabel1.setText("Kimlik No:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(90, 140, 75, 16);

        jLabel2.setText("Şifre:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(90, 190, 56, 16);

        kimlikNoTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                kimlikNoTxtKeyTyped(evt);
            }
        });
        getContentPane().add(kimlikNoTxt);
        kimlikNoTxt.setBounds(180, 130, 200, 30);
        getContentPane().add(sifreTxt);
        sifreTxt.setBounds(180, 180, 200, 30);

        uyeOlBtn.setText("Üye Ol");
        uyeOlBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uyeOlBtnActionPerformed(evt);
            }
        });
        getContentPane().add(uyeOlBtn);
        uyeOlBtn.setBounds(180, 220, 100, 25);

        girisBtn.setText("Giriş");
        girisBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                girisBtnActionPerformed(evt);
            }
        });
        getContentPane().add(girisBtn);
        girisBtn.setBounds(300, 220, 80, 25);

        jLabel3.setBackground(new java.awt.Color(51, 204, 0));
        jLabel3.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 23)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("MÜŞTERİ GİRİŞİ");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(190, 50, 210, 30);

        setSize(new java.awt.Dimension(565, 425));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void uyeOlBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uyeOlBtnActionPerformed
        // TODO add your handling code here:
        MusteriUyeOl musteriUyeOl = new kullanicilar.uyeOl.MusteriUyeOl();
        musteriUyeOl.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_uyeOlBtnActionPerformed

    private void girisBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_girisBtnActionPerformed
        // TODO add your handling code here:
        if (!(kimlikNoTxt.getText().length() < 11 && kimlikNoTxt.getText().length() > 10)) {
             JOptionPane.showMessageDialog(uyeOlBtn, "Eksik kimlik numarası girdiniz", "Kimlik Numarası Hatası", JOptionPane.WARNING_MESSAGE);
        }
        else if(kimlikNoTxt.getText().isEmpty() && sifreTxt.getText().isEmpty()){
            JOptionPane.showMessageDialog(uyeOlBtn, "Kimlik No ve Şifre alanları boş bırakılamaz.", "Boş Alan Hatası", JOptionPane.WARNING_MESSAGE);
        }
        else{
            musteriKontrol();
        }
    }//GEN-LAST:event_girisBtnActionPerformed
private void musteriKontrol() {

        boolean kontrol = false;
        for (int i = 0; i < Musteri.musteriler.size(); i++) {
            Musteri musteri1 = Musteri.musteriler.get(i);
            if ((musteri1.isim.equals(kimlikNoTxt.getText())) && (musteri1.sife.equals(sifreTxt.getText()))) {
                kontrol = true;
                break;
            }
        }
        if (kontrol) {
            MusteriEkrani personelEkrani = new kullanicilar.Ekranlar.MusteriEkrani();
            personelEkrani.setVisible(true);
            this.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(girisBtn, "Girilen Musteri İsmi Veya Şifreniz Yanlış.", "Musteri Bulunamadı", JOptionPane.WARNING_MESSAGE);
        }
    }
    private void kimlikNoTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_kimlikNoTxtKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE)) {
            getToolkit().beep();
            evt.consume();
        }
        if (!(kimlikNoTxt.getText().length() < 11)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_kimlikNoTxtKeyTyped

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
         String[] options = {"ÇIKIŞ", "İPTAL"};
        int i = JOptionPane.showOptionDialog(this, "Bu işlem sizi şuan açık olan ekrandan çıkarır." + "\n" + "Tekrar Kullanıcı Seçimi yapmak için ekranına dönersiniz." + "\n" + "Devam etmek istiyormusunuz?", "Müşteri Girişinden Çıkış", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

        if (i == 0) {
            this.setVisible(false);
            new KullaniciGirisi().setVisible(true);
        }
    }//GEN-LAST:event_formWindowClosing

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
            java.util.logging.Logger.getLogger(MüsteriGiris.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MüsteriGiris.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MüsteriGiris.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MüsteriGiris.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MüsteriGiris().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton girisBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField kimlikNoTxt;
    private javax.swing.JPasswordField sifreTxt;
    private javax.swing.JButton uyeOlBtn;
    // End of variables declaration//GEN-END:variables
}
