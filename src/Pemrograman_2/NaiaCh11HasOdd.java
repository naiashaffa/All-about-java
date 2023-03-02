package Pemrograman_2;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

// Nama : Naia Shaffa Camila
// NIM  : 22537144008
public class NaiaCh11HasOdd {
    public static void main(String []args){
        Set<Integer> number = new HashSet<Integer>();
        Scanner console = new Scanner(System.in);

        //input data menggunakan scanner
        System.out.print("Jumlah data yang akan di input: ");               
        int jumlahData = console.nextInt();

        for(int i = 0; i < jumlahData; i++){
            System.out.printf("Masukan data ke-%d:", i +1);
            number.add(console.nextInt());
        }
        System.out.println("Tampilkan data = " + number);
        System.out.println("Data memiliki bilangan ganjil = " + hasOdd(number));
    }
    public static boolean hasOdd (Set<Integer> number){
        for(int val : number){
            if(val % 2 == 1){         //diarahkan ke bilangan ganjil
                return true;
            }
        }
        return false;
    }
}

/*
Jumlah data yang akan di input: 5
Masukan data ke-1:2
Masukan data ke-2:4
Masukan data ke-3:6
Masukan data ke-4:8
Masukan data ke-5:15
Tampilkan data = [2, 4, 6, 8, 15]
Data memiliki bilangan ganjil = true 

Jumlah data yang akan di input: 5
Masukan data ke-1:2
Masukan data ke-2:4
Masukan data ke-3:6
Masukan data ke-4:8
Masukan data ke-5:15
Tampilkan data = [2, 4, 6, 8, 15]
Data memiliki bilangan ganjil = true
*/