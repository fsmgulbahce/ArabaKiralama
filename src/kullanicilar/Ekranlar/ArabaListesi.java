/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kullanicilar.Ekranlar;

import java.util.ArrayList;


/**
 *
 * @author Rosegarden
 */
public class ArabaListesi {
    String model;
    int fiyat;
    public static ArrayList<ArabaListesi> arabalarim = new ArrayList<>();
     static void arabaYukle() {
        ArabaListesi a1 = new ArabaListesi();
        a1.model = "mercedes";
        a1.fiyat = 300;

        ArabaListesi a2 = new ArabaListesi();
        a2.model = "şahin";
        a2.fiyat = 50;

        ArabaListesi a3 = new ArabaListesi();
        a3.model = "porsche";
        a3.fiyat = 1050;

       arabalarim.add(a1);
        arabalarim.add(a2);
        arabalarim.add(a3);

      
    }
}
