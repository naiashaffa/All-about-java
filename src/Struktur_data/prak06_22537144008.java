package Struktur_data;

import java.util.Scanner;

import javafx.scene.chart.PieChart.Data;

class Node06 {
    private int kodeMK;
    private String namaMK;

    public Node06 next;
    public Node06 previous;
// -------------------------------------------------------------
    // constructor (memasukan data matkul)
    public Node06 (int kodeMK, String namaMK) {
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
    private Node06 first;         // pointer menunjuk data pertama
    private Node06 last;          // pointer menunjuk data terakhir
    private Node06 temp;
// -------------------------------------------------------------
    // constructor      (mengambil data)
    public doubleLink() {
        first = null;           // pointer first menunjuk ke null
        last = null;            // pointer lastmenunjuk ke null
    }
// -------------------------------------------------------------
    // method untuk mengetahui kondisi data kosong atau ada
    public boolean isEmpty() {
        return first == null;       // jika pointer first menunjuk null maka list kosong
    }
// -------------------------------------------------------------
    // method untuk memasukan data di awal list
    public void insertFirst(int kodeMK, String namaMK) {
        Node06 newNode = new Node06 (kodeMK, namaMK);       // menyimpan data baru
        if (isEmpty()) {        // jika list kosong
            last = newNode;     // pointer last menunjuk ke newNode (data baru)
        } else {                // jika tidak, maka
            first.previous = newNode;   // first.previous menunjuk ke newNode (data baru)
            newNode.next = first;       // newNode (data baru) menunjuk ke data yang ditunjuk oleh first
        }
        first = newNode;        // pointer fisrt menunjuk ke newNode (data baru)
    }

    // method untuk memasukan data di akhir list
    public void insertLast(int kodeMK, String namaMK) {
        Node06 newNode = new Node06 (kodeMK, namaMK);           // menyimpan data baru
        if (isEmpty()) {        // jika list kosong
            first = newNode;    // pointer first menunjuk ke newNode (data baru)
        } else {                // jika tidak, maka
            last.next = newNode;        // last.next menunjuk ke newNode (data baru)
            newNode.previous = last;    // newNode.previous menunjuk ke data yang ditunjuk oleh last
        }
        last = newNode;         // pointer last menunjuk ke newNode (data baru)
    }
// -------------------------------------------------------------
    // mehhod unntuk menghapus data di awal list
    public Node06 deleteFirst() {
        Node06 temp = first;            // node temp (sementara) untuk menyimpan data yang akan di hapus
        if (first.next == null) {       // jika first.next sama dengan null 
            last = null;                // pointer last menunjuk ke null
        } else {                        // jika tidak, maka
            first.next.previous = null; // first.next.previous menunjuk ke null
            first = first.next;         // pointer first menunjuk data yang ditunjuk pointer first.next
        }
        return temp;        // return data yang dihapus
    }

    // method untuk mengahpus data di akhir list
    public Node06 deleteLast() {
        Node06 temp = last;             // node temp (sementara) untuk menyimpan data yang akan dihapus
        if (last.next == null) {        // jika last.next sama dengan null
            first = null;               // pointer first menunjuk ke null         
        } else {                        // jika tidak, maka
            last.next.previous = null;      // last.next.previous menunjuk ke null
            last = last.previous;           // pointer last menunjuk data yang ditunjuk pointer last.previous
        }
        return temp;        // return data yang dihapus
    }
// -------------------------------------------------------------
    // method untuk memasukan data setelah data tertentu
    public boolean insertAfter(int data, int kodeMK, String namaMK) {
        Node06 newNode = new Node06(kodeMK, namaMK);        // menyimpan data baru
        Node06 index = first;               // pointer index menunjuk data yang ditunjuk oleh pointer first
        while (index.getKode() != data) {   
            index = index.next;         // pointer index menunjuk ke data berikutnya

            if (index == null) {        // jika index sama dengan null
                return false;           // data me-return false (data tidak ditemukan)
            }
        }
        if (index == last) {            // jika index sama dnegan data yang ditunjuk oleh pointer last
            last = newNode;             // pointer last menunjuk ke newNode (data baru)
        } else {                        // jika tidak, maka
            newNode.next = index.next;  // newNode.next menunjuk newNode yang ditunjuk oleh pointer indext.next
            index.next.previous = newNode;  // indext.next.previous menunjuk ke newNode (data baru)
        }
        newNode.previous = index;       // newNode.previous menunjuk data yang ditunjuk oleh pointer index
        index.next = newNode;           // index.next menunjuk ke newNode (data baru)

        return true;        // return true, penambahan data berhasil
    }

    // method untuk memasukan data sebelum data tertentu
    public boolean insertBefore(int data, int kodeMK, String namaMK) {
        Node06 newNode = new Node06(kodeMK, namaMK);            // menyimpan data baru
        Node06 index = first;               // pointer index menunjuk data yang ditunjuk oleh pointer first
        while (index.getKode() != data) {
            index = index.next;         // index menunjuk menunjuk ke data berikutnya
    
            if (index == null) {        // jika index sama dengan null
                return false;           // data me-return false (data tidak ditemukan)
            }
        }
        if (index == first) {           // jika index sama dengan data yang ditunjuk oleh pointer first
            first = newNode;            // pointer first menunjuk ke newNode (data baru)
        } else {                        // jika tidak, maka
            newNode.previous = index.previous;      // newNode.previous menunjuk data yang ditunjuk pointer index.previous
            index.previous.next = newNode;          // index.previous.next menunjuk ke newNode (data baru)
        }
        newNode.next = index;           // newNode.next menunjuk data yang ditunjuk oleh pointer index
        index.previous = newNode;       // index.previous menunjuk ke newNode (data baru)
    
        return true;    
    }
// -------------------------------------------------------------
    // method untuk menghapus data tertentu (tidak di awal da di akhir list)
    public Node06 delete(int data) {
        Node06 index = first;           // pointer index menunjuk data yang ditunjuk oleh pointer first
        while (index.getKode() != data) {
            index = index.next;         // index menunjuk menunjuk ke data berikutnya

            if (index == null) {        // jika index sama dengan null
                return null;            // data me-return false (data tidak ditemukan)
            }
        }
        if (index == first) {           // jika index sama dengan data yang ditunjuk oleh pointer first
            first = index.next;         // pointer first menunjuk data yang ditunjuk pointer index.next
        } else {                        // jika tidak, maka
            index.previous.next = index.next;     // indext.previous.next menunjuk data yang ditunjuk oleh pointer index.next  
        }
        
        if (index == last) {            // jika index sama dnegan null
            last = index.previous;      // pointer last menunjuk data yang ditunjuk oleh pointer index.previous
        } else {                        // jika tidak, maka
            index.previous.next = index.previous;   // index.previous.next menunjuk data yang ditunjuk oleh indext.previous
        }
        return index;       // me-return data yang dihapus
    } 
// -------------------------------------------------------------
    // method untuk menampilkan data dari awal list
    public void tampilMaju() {
        System.out.println("Menampilkan data di tinjau dari awal : ");
        Node06 index = first;       // pointer index menunjuk data yang ditunjuk oleh pointer first
        while (index != null) {
            index.lihatData();      // memanggil method untuk menampilkan data (lihatData)
            index =index.next;      
        }
        System.out.println("");
    }

    // method untuk menampilkan data dari akhir list
    public void tampilMundur() {
        System.out.println("Menampilkan data di tinjau dari akhir : ");
        Node06 index = last;        // pointer index menunjuk data yang ditunjuk oleh pointer last
        while (index != null) {
            index.lihatData();      // memanggil method untuk menampilkan data (lihatData)
            index = index.previous;
        }
        System.out.println("");
    }
}   // end class doubleLink

public class prak06_22537144008 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);


        int menu, menuA;

        do {
            System.out.println("==================================");
            System.out.println("Pilih Menu");
            System.out.println("1. Memasukan Data Mata Kuliah");
            System.out.println("2. Menghapus Data Mata Kuliah");
            System.out.println("3. Menampilkan Data Mata Kuliah");
            System.out.println("4. Keluar");
            System.out.println("==================================");
            System.out.print("Menu yang dipilih : ");
            menu = input.nextInt();
            System.out.println("");

            switch(menu) {
                case 1: {
                    do {
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