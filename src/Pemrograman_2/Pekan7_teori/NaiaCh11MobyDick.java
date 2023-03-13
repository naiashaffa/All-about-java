package Pemrograman_2.Pekan7_teori;

// Naia Shaffa Camila
// 22537144008

import java.io.*;
import java.util.*;

public class NaiaCh11MobyDick {
    public static void main(String[] args) {
        Map<String, Integer> allWords = new HashMap<>();
        
        try {
            // Scanner untuk membaca file
            Scanner console = new Scanner(new File("D:/temp/MobyDick.txt"));     // tag txt
            console.useDelimiter("\\s+"); // Pisah input berdasarkan spasi atau newline
            
            while (console.hasNext()) {
                String[] word = console.next().split("\\W+");
                for (String w : word) {
                    w = w.toLowerCase().replaceAll("[^a-zA-Z]", "");
                    if (!w.isEmpty()) {
                        allWords.put(w, allWords.getOrDefault(w, 0) + 1);
                    }
                }
            }
            console.close(); // Tutup scanner
            
            // Buat ArrayList dari Map.Entry
            List<Map.Entry<String, Integer>> kataList = new ArrayList<>(allWords.entrySet());
            kataList.sort(Map.Entry.comparingByValue());
            
            // Urutkan ArrayList berdasarkan nilai frekuensi sering muncul
            Collections.sort(kataList, new Comparator<Map.Entry<String, Integer>>() {
                public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
                    return e1.getValue().compareTo(e2.getValue());
                }
            });
            
            // Output
            System.out.println("Peringkat kata-kata yang sering muncul dalam text : ");
            int rank = 1;
            for (Map.Entry<String, Integer> entry : kataList) {
                if (entry.getValue() >= 1000) {
                    System.out.println(rank + ". " + entry.getKey() + " : " + entry.getValue());
                    rank++;
                }
            }
            } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
