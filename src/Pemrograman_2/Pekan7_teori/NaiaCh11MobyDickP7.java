package Pemrograman_2.Pekan7_teori;

import java.io.*;
import java.util.*;

public class NaiaCh11MobyDickP7 {
    public static void main(String []args) throws IOException {
        Map<String, Integer> allWords = new HashMap<>();

        BufferedReader viewer = new BufferedReader(new FileReader("D:/temp/MobyDick.txt"));

        // Hitung tiap kemunculan kata
        String baris;
        while((baris = viewer.readLine())!= null){
            String[] word = baris.split("\\s+");
            for(String w : word){
                w = w.toLowerCase();
                if(!allWords.containsKey(w)){
                    allWords.put(w, 1);
                } else {
                    allWords.put(w, allWords.get(w)+ 1);
                }
            }
        }
        viewer.close();

        // Cetak kata yang muncul lebih dari 1000 kali, diurutkan dari yang paling sedikit hingga paling banyak
        List<String> commonWord = new ArrayList<>();
            for(Map.Entry<String, Integer> entri : allWords.entrySet()) {
                if(entri.getValue() >= 1000){
                    commonWord.add(entri.getKey());
                }
            }
        Collections.sort(commonWord);
        System.out.println("Kata-kata yang sering muncul dalam text : ");
            for(String w : commonWord){
                System.out.println(w + " " + allWords.get(w));
            }
    }
}
