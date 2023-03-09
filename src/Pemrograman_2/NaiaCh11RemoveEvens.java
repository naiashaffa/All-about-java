package Pemrograman_2;

import java.util.*;

public class NaiaCh11RemoveEvens {
    public static void main(String [] args){
        Set<Integer> s1 = new HashSet<Integer>();
        Scanner console = new Scanner(System.in);

        //inputan data menggunakan scanner
        System.out.print("Jumlah data yang akan di input: ");
        int jumlahData = console.nextInt();

        for(int i = 0; i < jumlahData; i++){
            System.out.printf("Masuka data ke-%d: ", i+1);
            s1.add(console.nextInt());
        }

        System.out.println("Tampilkan data = " + s1);
        Set<Integer> s2 = removeEvens(s1);
        System.out.println("Data ganjil = " + s1);
        System.out.print("Data genap = " + s2);
    }
    public static Set<Integer> removeEvens (Set<Integer> s1){
        Set<Integer> s2 = new TreeSet<Integer>();
        Iterator<Integer> ganjil = s1.iterator();          // iterator karena memilah data (eliminate)
        while (ganjil.hasNext()){
            int num = ganjil.next();
            if(num % 2 == 0){
                s2.add(num);
                ganjil.remove();
            }
        }
        return s2;
    }
}
