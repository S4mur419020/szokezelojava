package org.example.modell;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class FajlBeolvaso {

    public List<String> beolvas(String fajlNev) {
        List<String> sorok = new ArrayList<>();
        Path filePath = Path.of(fajlNev);

        try {
            sorok = Files.readAllLines(filePath);
        } catch (IOException e) {
            System.out.println("Hiba a fájl olvasásakor!");
        }

        return sorok;
    }
}