package Struktur_data;

// NAMA  : NAIA SHAFFA CAMILA
// NIM   : 22537144008
// PRODI : TEKNOLOGI INFORMASI/ I.2

import java.util.Scanner;

//class digunakan untuk menyimpan data
class Node {       
     int data;
     int before;
     Node next;

     public Node(int data){
        this.data = data;
        this.next = null;
     }

     // method untuk mengambil data
     public int getData() {
        return data;
     }
}

// class linkedList
class LinkedList {   
    Node first;

    public LinkedList() {
        this.first = null; 
    }

    // method untuk memasukkan data pada awal list
    public void insertFirst(int data) {     
        Node newNode = new Node(data);
        if (first == null) {
            first = newNode;
        } else {
            Node temp = first;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    // method untuk memasukkan data sebelum
    public void insertBefore(int data, int before) {  
        Node indek = first;
        Node indekBefore = first;
            
        while(indek.getData() != before){
            indekBefore = indek;
            indek = indek.next;

            if (indek == null){
                Node temp = indek;
                Node newNode = new Node(data);
                indekBefore.next = newNode;
                newNode.next = temp;
            }
        }
    }

    // method untuk menampilkan list
    public void lihatData() {   
        Node temp = first;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}
///////////////////////////////////////////////////////////////////////////////////////
// client code
public class prak07_22537144008 {             
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);  
        LinkedList list = new LinkedList();

        System.out.println("PROGRAM MEMASUKAN DATA");
        System.out.println("**Memasukan data sebelum data tertentu**");

        // input data awal
        System.out.print("Berapa jumlah data yang ingin dimasukkan? ");
        int n = input.nextInt();


        for (int i = 0; i < n; i++) {
            System.out.print("Masukkan data ke-" + (i + 1) + ": ");
            int data = input.nextInt();
            list.insertFirst(data);
        }

        // untuk melihat data
        System.out.println("");
        System.out.print("Data : ");
        list.lihatData();           


        // inputan baru (memasukan sebelum data " ")
        System.out.println("");
        System.out.print("Masukkan Data Baru: ");
        int data = input.nextInt();

        System.out.println("");
        System.out.print("Data Baru Ingin Dimasukkan Sebelum Data? ");
        int before = input.nextInt();
        list.insertBefore(data, before);

        System.out.println("");
        System.out.print("Data setelah dimasukkan: ");
        list.lihatData();           // kembali melihat data setelah di beri input baru
    }
} // end class utama