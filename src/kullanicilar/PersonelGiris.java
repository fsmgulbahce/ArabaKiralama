/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kullanicilar;

import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import kullanicilar.Ekranlar.PersonelEkrani;
import static kullanicilar.Personel.personelListem;

/**
 *
 * @author Rosegarden
 */
public class PersonelGiris extends javax.swing.JFrame {
    public static int a = 0;
    /**
     * Creates new form PersonelGiris
     */
    public PersonelGiris() {
        initComponents();
        this.getContentPane().setBackground(Color.GRAY);
        this.setTitle("Personel Girişi");
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

        kullaniciIsmiLbl = new javax.swing.JLabel();
        kullaniciIsmiTxt = new javax.swing.JTextField();
        sifreLbl = new javax.swing.JLabel();
        sifreTxt = new javax.swing.JPasswordField();
        girisBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(null);

        kullaniciIsmiLbl.setBackground(new java.awt.Color(51, 204, 0));
        kullaniciIsmiLbl.setForeground(new java.awt.Color(255, 255, 255));
        kullaniciIsmiLbl.setText("Kullanıcı İsmi:");
        getContentPane().add(kullaniciIsmiLbl);
        kullaniciIsmiLbl.setBounds(60, 150, 110, 16);
        getContentPane().add(kullaniciIsmiTxt);
        kullaniciIsmiTxt.setBounds(190, 140, 230, 31);

        sifreLbl.setBackground(new java.awt.Color(51, 204, 0));
        sifreLbl.setForeground(new java.awt.Color(255, 255, 255));
        sifreLbl.setText("Şifre:");
        getContentPane().add(sifreLbl);
        sifreLbl.setBounds(60, 190, 110, 16);
        getContentPane().add(sifreTxt);
        sifreTxt.setBounds(190, 180, 230, 30);

        girisBtn.setBackground(new java.awt.Color(102, 102, 102));
        girisBtn.setForeground(new java.awt.Color(255, 255, 255));
        girisBtn.setText("Giriş");
        girisBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                girisBtnActionPerformed(evt);
            }
        });
        getContentPane().add(girisBtn);
        girisBtn.setBounds(320, 240, 100, 25);

        jLabel1.setBackground(new java.awt.Color(51, 204, 0));
        jLabel1.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 23)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("PERSONEL GİRİŞİ");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(190, 50, 210, 20);

        setSize(new java.awt.Dimension(542, 429));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void girisBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_girisBtnActionPerformed
        // TODO add your handling code here:
        personelKontrol();
    }//GEN-LAST:event_girisBtnActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        String[] options = {"ÇIKIŞ", "İPTAL"};
        int i = JOptionPane.showOptionDialog(this, "Bu işlem sizi şuan açık olan ekrandan çıkarır." + "\n" + "Tekrar Kullanıcı Seçimi yapmak için ekranına dönersiniz." + "\n" + "Devam etmek istiyormusunuz?", "Personel Girişinden Çıkış", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

        if (i == 0) {
            this.setVisible(false);
            new KullaniciGirisi().setVisible(true);
        }
    }//GEN-LAST:event_formWindowClosing

    private void personelKontrol() {
        Personel p1 = new Personel();
        p1.isim = "destan";
        p1.sifre = "102361";

        Personel p2 = new Personel();
        p2.isim = "b";
        p2.sifre = "1";

        Personel.personelListem.add(p1);
        Personel.personelListem.add(p2);

        boolean kontrol = false;
        for (int i = 0; i < Personel.personelListem.size(); i++) {
            Personel personel1 = Personel.personelListem.get(i);
            if ((personel1.isim.equals(kullaniciIsmiTxt.getText())) && (personel1.sifre.equals(sifreTxt.getText()))) {
                kontrol = true;
                break;
            }
        }
        if (kontrol) {
            PersonelEkrani personelEkrani = new kullanicilar.Ekranlar.PersonelEkrani();
            personelEkrani.setVisible(true);
            this.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(girisBtn, "Girilen Personel İsmi Veya Şifreniz Yanlış.", "Personel Bulunamadı", JOptionPane.WARNING_MESSAGE);
        }
    }

//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(PersonelGiris.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(PersonelGiris.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(PersonelGiris.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(PersonelGiris.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new PersonelGiris().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton girisBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel kullaniciIsmiLbl;
    private javax.swing.JTextField kullaniciIsmiTxt;
    private javax.swing.JLabel sifreLbl;
    private javax.swing.JPasswordField sifreTxt;
    // End of variables declaration//GEN-END:variables
}
