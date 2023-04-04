package Struktur_data;

import java.util.*;
// Single Linked List
/*
NAMA    : Naia Shaffa Camila 
NIM     : 22537144008
*/

//untuk menyimpan data mahasiswa
class Node {                   
	private int num;
	public Node next;            //pointer untuk menunjuk node berikutnya
// -------------------------------------------------------------
    // constructor
	public Node(int num) { 
		this.num = num;
        this.next = null;
	}
// -------------------------------------------------------------
    //method untuk menampilkan data yg tersimpan
    public void lihatData(){
        System.out.println("Data : ");
    }
// -------------------------------------------------------------
    //method untuk mengambil data mahasiswa berdasarkan;
    public int getNum(){
        return num; 
    }
} // end class node
////////////////////////////////////////////////////////////////

class SingleLL {
	private Node first;      //pointer first untuk menunjuk node pertama

public SingleLL() { // constructor
	first = null;       //pinter menunjuk null maka list kosong
}
// -------------------------------------------------------------
	public boolean isEmpty() { 
		return (first == null);     // pointer == null makan list kosong
	}
// -------------------------------------------------------------
    //metode untuk menambahkan data sebelum data tertentu
    public boolean insertBefore(int newNum, int before) {
        Node newNode = new Node(newNum);
        Node index = first;
        Node indexBefore = first;

        // cari data sebelum
        while (index.getNum() != before) {
            indexBefore = index;
            index = index.next;

            if (index == null) {
                return false;
            }
        }
        // untuk memasukan data
        if(index == first) {
            newNode.next = first;
            first = newNode;
        } else {
            newNode.next = index;
            indexBefore.next = newNode;
        }
        return true;
    }
// -------------------------------------------------------------
    //metode untuk melihat data
    public void lihatData() {
        System.out.print("Output --> ");

        Node index = first;
        while(index != null) {
            index.lihatData();
            index = index.next;
        }
        System.out.println("Null");
        System.out.println("");
    }
} // end class LinkList
////////////////////////////////////////////////////////////////

//client class (menu(choose))
public class prak07_22537144008 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        SingleLL linkedList = new SingleLL();
        int num, before;
        int menu, i, jml;

        do {
            System.out.println("==================================");
            System.out.println("Pilih Menu");
            System.out.println("1. Memasukan Data");
            System.out.println("2. Menampilkan Data ");
            System.out.println("3. Keluar");
            System.out.println("==================================");
            System.out.print("Menu yang dipilih : ");
            menu = input.nextInt();
            System.out.println("");

            switch (menu) {
                case 1:
                        System.out.println("| Memasukan data spesial |");
                        System.out.println("** Data baru akan disimpan sebelum data tertentu");
                        System.out.print("Jumlah data input : ");
                        jml = input.nextInt();
                        System.out.println("");

                        for(i = 1; i <= jml; i++) {
                            System.out.print("Data ke-" + i + " : ");
                            num = input.nextInt();
                            System.out.print("Data akan disimpan sebelum : ");
                            before = input.nextInt();

                            if (linkedList.insertBefore(num, before)) {
                                System.out.println("Data Berhasil Diinput");
                                System.out.println("");
                            } else {
                                System.out.println("Data Tidak Ada");
                                System.out.println("");
                            }
                        }
                        System.out.println("Data Baru Berhasil diinput");
                        System.out.println("");
                    break;

                case 2:
                    System.out.println("| Menampilkan Data |");
                    if (linkedList.isEmpty()) {
                        System.out.println("Data kosong");
                    } else {
                        System.out.println("");
                        linkedList.lihatData();
                    }
                    System.out.println("");
                break;
            }
        } while (menu >=1 && menu < 3);
    }
}
