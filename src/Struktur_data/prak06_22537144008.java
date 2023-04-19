package Struktur_data;

import java.util.Scanner;

// Nama : Naia Shaffa Camila
// Nim  : 22537144008

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
    public void lihatList() {
    System.out.println("KODE : " + kodeMK + "   | Mata Kuliah : " + namaMK);       //
   }
} // end class mata kuliah
// -------------------------------------------------------------
// class untuk menyimpan data matkul menggunakan double link
class doubleLink {
    private Node06 first;         // pointer menunjuk data pertama
    private Node06 last;          // pointer menunjuk data terakhir
    private Node06 temp;          // pointer menunjuk data sementara
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
            last.previous.next = null;      // last.previous.next menunjuk ke null
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
    // method untuk menghapus data tertentu (tidak di awal dan di akhir list)
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
            index.next.previous = index.previous;   // index.next.previous menunjuk data yang ditunjuk oleh indext.previous
        }
        return index;       // me-return data yang dihapus
    } 
// -------------------------------------------------------------
    // method untuk menampilkan data dari awal list
    public void tampilMaju() {
        System.out.println("Menampilkan data di tinjau dari awal : ");
        Node06 index = first;       // pointer index menunjuk data yang ditunjuk oleh pointer first
        while (index != null) {
            index.lihatList();      // memanggil method untuk menampilkan data (lihatData)
            index =index.next;      
        }
        System.out.println("");
    }

    // method untuk menampilkan data dari akhir list
    public void tampilMundur() {
        System.out.println("Menampilkan data di tinjau dari akhir : ");
        Node06 index = last;        // pointer index menunjuk data yang ditunjuk oleh pointer last
        while (index != null) {
            index.lihatList();      // memanggil method untuk menampilkan data (lihatData)
            index = index.previous;
        }
        System.out.println("");
    }
}   // end class doubleLink
// -------------------------------------------------------------

public class prak06_22537144008 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);        
        int i = 0;
        doubleLink list = new doubleLink();
        int kodeMK, data;
        String namaMk;

        int menu, subMenu;      // terdapat menu sebanyak 4 dengan submenu tergantung menu yang di pilih

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
            
// -------------------------------------------------------------
            // submenu yang terdapat dalam menu opsi 1
            switch (menu) {
                case 1:
                System.out.println("---------- MEMASUKAN DATA ----------");
                System.out.println("1. Tambah data pada awal list");   
                System.out.println("2. Tambah data pada akhir list");    
                System.out.println("3. Tambah data setelah data tertentu");    
                System.out.println("4. Tambah data sebelum data tertentu");
                System.out.println("5. Kembali");    
                System.out.print("Menu yang dipilih : ");
                subMenu = input.nextInt();
                System.out.println("");
                System.out.println("------------------------------------");
                
                switch (subMenu) {
                    case 1:
                        System.out.println(" Data Ditambahkan Pada Awal List");
                        System.out.println("");
                        break;
                    case 2:
                        System.out.println(" Data Ditambahkan Pada Akhir List");
                        System.out.println("");
                        break;
                    case 3:
                        System.out.println(" Data Ditambahkan Setelah Data Tertentu");
                        System.out.println("");
                        break;
                    case 4:
                        System.out.println(" Data Ditambahkan Sebelum Data Tertentu");
                        System.out.println("");
                        break;
                    case 5:
                        break;
                }
                if (subMenu != 5) {
                    System.out.print("Jumlah data yang di input : ");       // menanyakan jumlah inputan
                    int jumlah = input.nextInt();
                    System.out.println("");

                    for(i = 1; i <= jumlah ; i++) {             // akan looping sebanyak jumlah inputan yg sudah di isi di atas
                        System.out.println("Data ke-" + i );
                        System.out.print("Kode Mata Kuliah : ");
                        kodeMK = input.nextInt();
                        System.out.print("Nama Mata Kuliah (hanya bisa 1 kata): ");
                        namaMk = input.next();          // dapat menyimpan inputan hanya 1 kata
                        System.out.println("");

                        switch (subMenu) {
                            case 1:             // memasukan data di awal
                                list.insertFirst(kodeMK, namaMk);
                                System.out.println("");
                                System.out.println("!!!! Berhasil Ditambahkan !!!!");
                                System.out.println("");
                                break;
                            case 2:             // memasukan data di akhir
                                list.insertLast(kodeMK, namaMk);
                                System.out.println("");
                                System.out.println("!!!! Berhasil Ditambahkan !!!!");
                                System.out.println("");
                                break;
                            case 3:             // memasukan data setelah data tertentu
                                System.out.print("Data Ditambahkan Setelah (kode) : ");
                                data =  input.nextInt();

                                if(!list.insertAfter(data, kodeMK, namaMk)) {
                                    System.out.println(" || !! DATA TIDAK DITEMUKAN !! ||");
                                } else {
                                    System.out.println("");
                                    System.out.println("!!!! Berhasil Ditambahkan !!!!");
                                }
                                break;
                            case 4:             // memasukan data sebelum data tertentu
                                System.out.print("Data Ditambahkan Sebelum (kode) : ");
                                data =  input.nextInt();

                                if(!list.insertBefore(data, kodeMK, namaMk)) {
                                    System.out.println(" || !! DATA TIDAK DITEMUKAN !! ||");
                                } else {
                                    System.out.println("");
                                    System.out.println("!!!! Berhasil Ditambahkan !!!!");
                                }
                            case 5:
                                break;    
                        default:
                            System.out.println("|||| ERROR ||||");      // jika inputan tidak sesuai
                                break;
                        }
                    }
                    System.out.println("");
                }
                break;

// -------------------------------------------------------------
            // submenu yang terdapat dalam menu opsi 2
                case 2: 
                System.out.println("---------- MENGHAPUS DATA ----------");
                System.out.println("1. Hapus data pada awal list");   
                System.out.println("2. Hapus data pada akhir list");    
                System.out.println("3. Hapus data tertentu");    
                System.out.println("4. Kembali");    
                System.out.print("Menu yang dipilih : ");
                subMenu = input.nextInt();
                System.out.println("");
                System.out.println("------------------------------------");
                
                switch (subMenu) {
                    case 1:             // hapus data awal lkist
                        if(list.deleteFirst() == null) {
                            System.out.println("|| !! Tidak Ada Data !! ||");
                        } else {
                            System.out.println(" Data Dihapus Pada Awal List");
                        }
                        break;
                    case 2:             // hapus data akhir list
                        if(list.deleteLast() == null) {         
                            System.out.println("|| !! Tidak Ada Data !! ||");
                        } else {
                            System.out.println(" Data Dihapus Pada Akhir List");
                        }
                        break;
                    case 3:             // hapus data berdasarkan inputan (kode)
                        System.out.print("Data Yang Dihapus (kode) : ");
                        data =  input.nextInt();        // memasukan inputan berupa kode yang ingin di hapus

                        if(list.delete(data) == null) {
                            System.out.println(" || !! DATA TIDAK DITEMUKAN !! ||");
                        } else {
                            System.out.println("!!!! Berhasil Ditambahkan !!!!");
                        }
                    case 4: 
                        break;
                    default:
                        System.out.println("|||| ERROR ||||");      //jika inputan tidak sesuai
                        break;
                }
                System.out.println("");
                break;

// -------------------------------------------------------------
            // submenu yang terdapat dalam menu opsi 3                
                case 3:
                System.out.println("---------- MENAMPILKAN DATA ----------");
                System.out.println("1. Lihat data dari awal list");   
                System.out.println("2. Lihat data pada akhir list");    
                System.out.println("3. Kembali");    
                System.out.print("Menu yang dipilih : ");
                subMenu = input.nextInt();
                System.out.println("");
                System.out.println("------------------------------------");
                
                if (!list.isEmpty()) {
                    switch (subMenu) {
                        case 1:         // menampilkan list dari awal
                            list.tampilMaju();              // memanggil method
                            break;
                        case 2:         // menampilkan list dari akhir
                            list.tampilMundur();
                            break;
                        case 3: 
                            break;
                        default:
                        System.out.println("|||| ERROR ||||");      // jika inputan tidak sesuai
                        break;
                }
                System.out.println("");
                break;    
                }
            }   
        } while(menu >= 1 && menu < 4);
        System.out.println("Program dihentikan. ");
        System.out.println("");
    }
}
