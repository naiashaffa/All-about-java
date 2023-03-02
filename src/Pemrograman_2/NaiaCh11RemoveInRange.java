package Pemrograman_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NaiaCh11RemoveInRange {
    public static void main(String []args){
        ArrayList<Integer>list = new ArrayList<Integer>();
            Scanner console = new Scanner(System.in);
    
            //input data menggunakan scanner
            System.out.print("Jumlah data yang akan di input: ");               
            int jumlahData = console.nextInt();
    
            for(int i = 0; i < jumlahData; i++){
                System.out.printf("Masukan data ke-%d:", i +1);
                list.add(console.nextInt());
            }
            System.out.print("Nilai yang ingin dihapus = ");            //nilai yang ingin di hapus dalam list
            int delnum = console.nextInt();
            System.out.print("Nilai start indeks yang diinginkan = ");  //nilai mulai indeks yang diperhitungkan
            int start = console.nextInt();
            System.out.print("Nilai end indeks yang diinginkan = ");    //nilai akhir indeks yang diperhitungkan  
            int end = console.nextInt();

            System.out.println("Tampilkan data = " + list);

            removeInRange(list, delnum, start, end);
            System.out.print("Tampilkan data setelah diproses = ");
            System.out.println(list);
    }
    public static ArrayList<Integer> removeInRange (ArrayList<Integer>list, int delnum, int start, int end){
        for(int i = start; i < end; i++){
            if(list.get(i) == delnum ){
                list.remove(i);
                i -= 1;
                end -= 1;
            }
        }
        return list;
    }
}

/*
Jumlah data yang akan di input: 17
Masukan data ke-1:0
Masukan data ke-2:0
Masukan data ke-3:2
Masukan data ke-4:0
Masukan data ke-5:4
Masukan data ke-6:0
Masukan data ke-7:6
Masukan data ke-8:0
Masukan data ke-9:8
Masukan data ke-10:0
Masukan data ke-11:10
Masukan data ke-12:0
Masukan data ke-13:12
Masukan data ke-14:0
Masukan data ke-15:14
Masukan data ke-16:0
Masukan data ke-17:16
Nilai yang ingin dihapus = 0
Nilai start indeks yang diinginkan = 5
Nilai end indeks yang diinginkan = 13
Tampilkan data = [0, 0, 2, 0, 4, 0, 6, 0, 8, 0, 10, 0, 12, 0, 14, 0, 16]
Tampilkan data setelah diproses = [0, 0, 2, 0, 4, 6, 8, 10, 12, 0, 14, 0, 16] 
*/