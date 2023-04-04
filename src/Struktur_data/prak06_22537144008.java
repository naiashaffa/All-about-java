package Struktur_data;

import java.util.Scanner;

class Node {
    public int kodeMK;
    public String namaMK;

    public Node next;
    public Node previous;
// -------------------------------------------------------------
    // constructor (memasukan data matkul)
    public Node (int kodeMK, String namaMK) {
        this.kodeMK = kodeMK;
        this.namaMK = namaMK;
    }
// -------------------------------------------------------------
    // method untuk mengambil data kode matkul
    public int getKode() {
        return kodeMK;
    }

    // method untuk mengambil data nama matkul
    public String getNama() {
        return namaMK;
    }
// -------------------------------------------------------------
    // method untuk menampilkan data matkul
    public void lihatData() {
    System.out.printf("|%-12d|%-12d| \n",kodeMK, namaMK);       //
   }

} // end class mata kuliah
// -------------------------------------------------------------
// class untuk menyimpan data matkul menggunakan double link
class doubleLink {
    private Node first;         // pointer menunjuk data pertama
    private Node last;          // pointer menunjuk data terakhir
    private Node temp;
// -------------------------------------------------------------
    // constructor
    public doubleLink() {
        first = null;
        last = null;
    }
// -------------------------------------------------------------
    // method untuk mengetahui kondisi data kosong atau ada
    public boolean isEmpty() {
        return first == null;
    }
// -------------------------------------------------------------
    // method untuk memasukan data di awal list
    public void insertFirst(int kodeMK, String namaMK) {
        Node newNode = new Node(kodeMK, namaMK);
        if (isEmpty()) {
            last = newNode;
        } else {
            first.previous = newNode;
            newNode.next = first;
        }
        first = newNode;
    }

    // method untuk memasukan data di akhir list
    public void insertLast(int kodeMK, String namaMK) {
        Node newNode = new Node(kodeMK, namaMK);
        if (isEmpty()) {
            first = newNode;
        } else {
            last.next = newNode;
            newNode.previous = last;
        }
        last = newNode;
    }
// -------------------------------------------------------------
    // mehhod unntuk menghapus data di awal list
    public Node deleteFirst() {
        Node temp = first;
        if (first.next == null) {
            last = null;
        } else {
            first.next.previous = null;
            first = first.next;
        }
        return temp;
    }

    // method untuk mengahpus data di akhir list
    public Node deleteLast() {
        Node temp = last;
        if (last.next == null) {
            first = null;
        } else {
            last.next.previous = null;
            last = last.previous;
        }
        return temp;
    }
// -------------------------------------------------------------
    // method untuk memasukan data setelah data tertentu
    public boolean insertAfter() {
        Node index = first;
        while (index.kodeMK != ) {
            
        }
    }

    // method untuk memasukan data sebelum data tertentu
    public boolean insertBefore() {
        Node index = first;
        while (index.kodeMK) {
            
        }
    }
// -------------------------------------------------------------
    // method untuk menghapus data tertentu (tidak di awal da di akhir list)
    public Node delete() {
        Node index = first;
        while (index.kodeMK) {
            
        }
    } 
// -------------------------------------------------------------
    // method untuk menampilkan data dari awal list
    public void tampilMaju() {
        System.out.println("Menampilkan data di tinjau dari awal : ");
        Node index = first;
        while (index != null) {
            index.lihatData();
            index =index.next;
        }
        System.out.println("");
    }

    // method untuk menampilkan data dari akhir list
    public void tampilMundur() {
        System.out.println("Menampilkan data di tinjau dari akhir : ");
        Node index = last;
        while (index != null) {
            index.lihatData();
            index = index.previous;
        }
        System.out.println("");
    }
}   // end class doubleLink

public class prak06_22537144008 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);


        int menu;

        do {
            System.out.println("==================================");
            System.out.println("Pilih Menu");
            System.out.println("1. Memasukan Data Mata Kuliah");
            System.out.println("2. Menghapus Data Mata Kuliah");
            System.out.println("3. Menampilkan Data Mata Kuliah");
            System.out.println("5. Keluar");
            System.out.println("==================================");
            System.out.print("Menu yang dipilih : ");
            menu = input.nextInt();
            System.out.println("");

            switch(menu) {
                case 1: {
                    if() {
                        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
                        System.out.println("   PENDAFTARAN MATA KULIAH  ");
                        System.out.println("Memasukan data berdasarkan : ");
                        System.out.println("1. Kode Mata Kuliah");
                        System.out.println("2. Nama Mata Kuliah");
                        System.out.print("Pilih : ");
                        menu = input.nextInt();
                        System.out.println("");

                        switch(menu) {
                            case 1: {
                                System.out.print("Masukan Kode Mata Kuliah : ");
                                    break;
                            }
                            case 2: {
                                System.out.print("Masukan Nama Mata Kuliah");
                                    break;
                            }
                        }
                    }
                    break;
                }
                case 2: {
                    if (condition) {
                        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^");
                        System.out.println("   MENGHAPUS DATA MATA KULIAH");
                        System.out.println("Menghapus data berdasarkan : ");
                        System.out.println("1. Kode Mata Kuliah");
                        System.out.println("2. Nama Mata Kuliah");
                        System.out.print("Pilih : ");
                        menu = input.nextInt();
                        System.out.println("");

                        switch (menu) {
                            case 1: {
                                System.out.print("Masukan Kode Mata Kuliah : ");
                                break;
                            }

                            case 2: {
                                System.out.print("Masukan Nama Mata Kuliah : ");
                                break;
                            }
                        }
                    }
                }
                case 3: {
                    if (condition) {
                        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^");
                        System.out.println("   Data Mata Kuliah ");  
                    }
                }
            }
        } while(menu >= 1 && menu < 4);
        System.out.println("Program dihentikan. ");
        System.out.println("");
    }
}
