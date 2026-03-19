import org.example.controller.SzoKezelo;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class FeladatokTest {

    static List<String> szavak;
    SzoKezelo feladatok;

    @BeforeAll
    static void feltolt() {
        szavak = new ArrayList<>();
        //beolvasás, teszt adattal feltölés
        szavak = new ArrayList<>();
        szavak.add("alma;korte;barack;citrom;narancs");
        szavak.add("alma;eper;kiwi;ribizli");
        szavak.add("szilva;cseresznye;dinnye");
    }

    @BeforeEach
    void setUp() {
        feladatok = new SzoKezelo(szavak);
    }

    @Test
    void szavakSzama() {
        assertEquals(12, feladatok.szoDarab());
    }

    @Test
    void leghosszabbSzoIndexe() {
        assertEquals("cseresznye", feladatok.leghosszabbSzo());
    }

    @Test
    void betukSzama() {
        assertEquals(7, feladatok.eBetukSzama());
    }

    @Test
    void csere() {
        assertEquals("sarancn", feladatok.elsoUtolsoCsereSorszammal(4));
    }

    @Test
    void egyformaSzavak() {
        assertTrue(feladatok.VanIsmetlodoSzo());
    }

    @Test
    void betuStatisztika() {
        Map<Character, Integer> stat = assertDoesNotThrow(() -> feladatok.betuStat());

        assertEquals(7, stat.getOrDefault('e', 0));
        assertEquals(9, stat.getOrDefault('a', 0));

        int osszesBetu = stat.values().stream().mapToInt(Integer::intValue).sum();
        assertEquals(69, osszesBetu);
    }
}
