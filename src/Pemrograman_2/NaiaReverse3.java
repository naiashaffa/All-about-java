package Pemrograman_2;
import java.util.*;

/* 
Nama : Naia Shaffa Camila
NIM  : 22537144008
*/

public class NaiaReverse3 {
    public static void main(String [] args){
        ArrayList<Integer>list = new ArrayList<Integer>();
        Scanner console = new Scanner(System.in);

        System.out.print("Jumlah data yang akan di input: ");
        int jumlahData = console.nextInt();

        for(int i = 0; i < jumlahData; i++){
            System.out.printf("Masukan data ke-%d:", i +1);
            list.add(console.nextInt());
        }
        System.out.println("Tampilkan data = " + list);
        System.out.println("Tampilkan data setelah di balik =" + reverse3(list));

    }
    public static ArrayList<Integer> reverse3 (ArrayList<Integer>list){
        for(int i = 0; i <= list.size()-3; i += 3){
            Integer s = list.get(i+2);
            list.set(i+2, list.get(i));
            list.set(i,s);
        }
        return list;
    }
}

/*
Jumlah data yang akan di input: 9
Masukan data ke-1:9
Masukan data ke-2:8
Masukan data ke-3:7
Masukan data ke-4:6
Masukan data ke-5:5
Masukan data ke-6:4
Masukan data ke-7:3
Masukan data ke-8:2
Masukan data ke-9:1
Tampilkan data = [9, 8, 7, 6, 5, 4, 3, 2, 1]
Tampilkan data setelah di balik =[7, 8, 9, 4, 5, 6, 1, 2, 3] 
*/