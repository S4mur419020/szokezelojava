package org.example.controller;

import java.util.*;

public class SzoKezelo {
    private List<String> sorok;

    public SzoKezelo(List<String> sorok) {
        this.sorok = sorok;
    }

    public List<String> osszesSzo() {
        List<String> szavak = new ArrayList<>();

        for (String sor : sorok) {
            String[] darabok = sor.split(";");
            for (String szo : darabok) {
                szo = szo.trim();
                if (!szo.isEmpty()) {
                    szavak.add(szo);
                }
            }
        }
        return szavak;
    }

    public int szoDarab() {
        return osszesSzo().size();
    }

    public String leghosszabbSzo() {
        List<String> szavak = osszesSzo();
        if (szavak.isEmpty()) {
            return "";
        }
        String leghosszabb = szavak.get(0);
        for (String szo : szavak) {
            if (szo.length() > leghosszabb.length()) {
                leghosszabb = szo;
            }
        }
        return leghosszabb;
    }

    public int eBetukSzama() {
        int count = 0;
        for (String sor : sorok) {
            for (char c : sor.toCharArray()) {
                if (c == 'e' || c == 'E') {
                    count++;
                }
            }
        }
        return count;
    }

    public boolean VanIsmetlodoSzo() {
        Set<String> szavakSet = new HashSet<>();
        for (String szo : osszesSzo()) {
            if (!szavakSet.add(szo)) {
                return true;
            }
        }
        return false;
    }

    public String elsoUtolsoCsereSorszammal(int sorszam) {
        List<String> szavak = osszesSzo();
        if (sorszam < 0 || sorszam >= szavak.size()) {
            throw new IndexOutOfBoundsException("A megadott sorszám nagyobb mint a fájlban szereplő adatok hossza!");
        }
        String szo = szavak.get(sorszam);
        if (szo.length() < 2) {
            return szo;
        }
        char[] chars = szo.toCharArray();
        char temp = chars[0];
        chars[0] = chars[chars.length - 1];
        chars[chars.length - 1] = temp;

        return new String(chars);
    }

    public void szavakBetui() {
        List<String> szavak = osszesSzo();
        for (String szo : szavak) {
            System.out.println("Szó: " + szo);
            System.out.println("Betűk száma: " + szo.length());
            for (char c : szo.toCharArray()) {
                System.out.print(c + " ");
            }
            System.out.println("\n");
        }
    }

    public void osszesBetuDarab() {
        Map<Character, Integer> betuk = new TreeMap<>();

        for (String szo : osszesSzo()) {
            for (char c : szo.toCharArray()) {
                betuk.put(c, betuk.getOrDefault(c, 0) + 1);
            }
        }
        for (Map.Entry<Character, Integer> entry : betuk.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    public Map<Character, Integer> betuStat() {
        Map<Character, Integer> stat = new TreeMap<>();
        for (String szo : osszesSzo()) {
            for (char c : szo.toCharArray()) {
                c = Character.toLowerCase(c); // kisbetűsítés
                stat.put(c, stat.getOrDefault(c, 0) + 1);
            }
        }
        return stat;
    }
}