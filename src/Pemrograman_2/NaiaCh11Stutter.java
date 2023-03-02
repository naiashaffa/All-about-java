package Pemrograman_2;

import java.util.ArrayList;
import java.util.Scanner;

// Nama : Naia Shaffa Camila
// NIM  : 22537144008

public class NaiaCh11Stutter {
    public static void main(String [] args){
        ArrayList<Integer>newnum = new ArrayList<Integer>();
        Scanner console = new Scanner(System.in);

        //input data menggunakan scanner
        System.out.print("Jumlah data yang akan di input: ");               
        int jumlahData = console.nextInt();

        for(int i = 0; i < jumlahData; i++){
            System.out.printf("Masukan data ke-%d:", i +1);
            newnum.add(console.nextInt());
        }
        System.out.println("Tampilkan data = " + newnum);
        System.out.println("Tampilkan data setelah di duplikasi = " + stutter(newnum));
    }


    public static ArrayList<Integer> stutter (ArrayList<Integer> newnum){
        for(int i = 1; i <= newnum.size(); i +=2 ){
            newnum.add(i, newnum.get(i-1));
        }
        return newnum;
    }
}
/*
Jumlah data yang akan di input: 8
Masukan data ke-1:1
Masukan data ke-2:2
Masukan data ke-3:3
Masukan data ke-4:4
Masukan data ke-5:5
Masukan data ke-6:6
Masukan data ke-7:7
Masukan data ke-8:8
Tampilkan data = [1, 2, 3, 4, 5, 6, 7, 8]
Tampilkan data setelah di duplikasi = [1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8] 
*/