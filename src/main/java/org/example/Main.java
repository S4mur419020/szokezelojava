package org.example;

import org.example.controller.SzoKezelo;
import org.example.modell.FajlBeolvaso;

import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        try {
            FajlBeolvaso beolvaso = new FajlBeolvaso();
            List<String> sorok = beolvaso.beolvas("szavak.txt");

            SzoKezelo kezelo = new SzoKezelo(sorok);
            int sorszam = 2;
            String modositott = kezelo.elsoUtolsoCsereSorszammal(sorszam);

            System.out.println("Szavak száma: " + kezelo.szoDarab());
            System.out.println("Leghosszabb szó: " + kezelo.leghosszabbSzo());
            System.out.println("A teljes fájlban hány 'e' van: " + kezelo.eBetukSzama());
            System.out.println("Van-e ismétlődő szó: " + kezelo.VanIsmetlodoSzo());
            System.out.println("Módosított szó: " + modositott);

            System.out.println("\n--- Szavankénti betűk ---");
            kezelo.szavakBetui();

            System.out.println("--- Összes betű darabszám ---");
            kezelo.osszesBetuDarab();


        } catch (Exception e) {
            System.out.println("Hiba történt: " + e.getMessage());
        }
    }
}