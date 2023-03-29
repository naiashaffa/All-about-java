package Struktur_data;
//NAMA  : NAIA SHAFFA CAMILA
//NIM   : 22537122008

import java.util.*;
//class untuk menyimpan data pasien
class NodePas {
    public String namaPas;
    public String keluhanPas;
    public String alamatPas;
    public NodePas next;

// -------------------------------------------------------------
    // constructor (memasukan data pasien)
    public NodePas (String nama, String keluhan, String alamat){
        namaPas = nama;
        keluhanPas = keluhan;
        alamatPas = alamat;
    }
// -------------------------------------------------------------
    // method untuk menampilkan data pasien
    public void lihatData(){
        System.out.println("Nama : " + namaPas + " || Keluhan : " + keluhanPas + " || Alamat : " + alamatPas);
        System.out.println("--------------------------------------------------------------------");
    }
// -------------------------------------------------------------
    // method untuk mengambil data  nama pasien
    public String getNama() {
        return namaPas;
    }

    // method untuk mengambil data keluhan pasien
    public String getKeluhan() {
        return keluhanPas;
    }

    // method untuk mengambil data alamat pasien
    public String getAlamat() {
        return alamatPas;
    }   
} //end class pasien
// -------------------------------------------------------------
// class untuk menyimoan data pasien menggunnakan 'queue'
class LinkQueue {
    private NodePas first;          // pointer menunjuk data pertama
    private NodePas last;           // pointer menunjuk data terakhir
// -------------------------------------------------------------
    // constructor
    public LinkQueue() {
        first = null;
        last = null;
    }
// -------------------------------------------------------------
    // method untuk mengetahui kondisi antrian kosong atau ada
    public boolean isEmpty(){
        return (first == null);
    }
// -------------------------------------------------------------
    // method untuk menambah data pada queue (urutan paling belakang)
    public void enQueue (NodePas PasienBaru) {
        if(isEmpty()) {
            first = PasienBaru;
        } else {
            last.next = PasienBaru;
        }
        last = PasienBaru;          // data yang di input terakhir akan otomatis ditunjuk oleh pointer last
        System.out.println("");
        System.out.println("Data pasien telah disimpan dan masuk ke dalam antrian.");
    }
// -------------------------------------------------------------
    // method input untuk memasukan data ke dalam array
    public void add (String namaPas, String keluhanPas, String alamatPas) {
        NodePas dataBaru = new NodePas(namaPas, keluhanPas, alamatPas);
        enQueue(dataBaru);          // memanggil method enQueue menggunakan parameter data baru untuk di masukan dalam antrian
    }
// -------------------------------------------------------------
    // method untuk mengeluarkann data pada awal antrian
    public NodePas deQueue() {
        NodePas temp = first;
        if(first.next == null) {
            last = null;
        }
        first = first.next;

        return temp;
    }
// -------------------------------------------------------------
    // method untuk melihat data awal pada antrian pasien
    public void lihat() {
        NodePas index = first;
        while(index != null) {
            index.lihatData();
            index = index.next;
        }
        System.out.println("");
    }
// -------------------------------------------------------------
    // method untuk memanggil pasien pada antrian selanjutnya
    public NodePas terpanggil() {
        return deQueue();       // memmangggil method deQueue untuk memanggil data pasien selanjutnya
    }
// -------------------------------------------------------------
    // method untuk mengosongkan antrian pasien
    public void clear() {
        while(!isEmpty()) {
            deQueue();
        }
    }
// -------------------------------------------------------------
    // method untuk mengetahui antrian pasien sudah penuh 
    public boolean isFull(int cont, int max) {
        if (cont == max) {
            return true;
        } else {
            return false;
        }
    }
// -------------------------------------------------------------
    // method untuk mengambil data nama pasien
    public String namaPas() {
        return first.getNama();
    }

    // method untuk mengambil data keluhan pasien
    public String keluhanPas() {
        return first.getKeluhan();
    }

    // method untuk mengambil data alamat pasien
    public String alamatPas() {
        return first.getAlamat();
    }
} // end class Queue
// -------------------------------------------------------------
public class prak05_22537144008 {
    public static void main(String[] args) {
        LinkQueue queue = new LinkQueue();
        System.out.print("Masukan jumlah Antrian maksimal = ");
        Scanner input = new Scanner(System.in);
        int max = input.nextInt();      // nilai max jumlah antrian
        int counter = 0;        

        LinkQueue antrian = new LinkQueue();
        String nama, keluhan, alamat;

        int menu;

        do {
            // berbagai menu yang tersedia dan dapat dipilih
            System.out.println("================================");
			System.out.println("Pilih Menu");
			System.out.println("1. Pendaftaran Pasien");
			System.out.println("2. Daftar Antrian Pasien");
			System.out.println("3. Reset Antrian");
			System.out.println("4. Pemanggilan Pasien");
			System.out.println("5. Keluar");            // program dihentikan 
            System.out.println("================================");
			System.out.print("Menu yang dipilih : ");
  	    	menu = input.nextInt();     // input menu yang dipilih
  	    	System.out.println("");
//--------------------------------------------------------------
			switch(menu) {
				case 1 : {          // menu untuk menambahkan data pasien pada antrian
					if(!queue.isFull(counter, max) == true) {       // memperhatikan jumlah data yang dapat diinput berdasarkan menthod isFull
                        System.out.println("----------------------");
                        System.out.println("  PENDAFTARAN PASIEN  ");
                        System.out.println("");
                        System.out.println("Masukan Data Pasien Baru");
                        System.out.print("Nama : ");
                        nama = input.next();        // input nama pasien
                        System.out.print("Keluhan : ");
                        keluhan = input.next();     // input keluhan pasien
                        System.out.print("Alamat : ");
                        alamat = input.next();      // input alamat pasien
                        queue.add(nama, keluhan, alamat);         // memanggil method add yang ada dalam class queue
                        System.out.println("");
                        counter++;      // nilai counter akan bertambah dan akan berhenti saat nilai nya sama dengan max 
                    } else {        // untuk memberitahu bahwa tidak dapat menambah data lagi karena antrian sudah penuh berdasarkan nilai max yang telah di input di awal
                        System.out.println("ANTRIAN PENUH !!!");
                        System.out.println("");
                    }
					break;
				}
// -------------------------------------------------------------
				case 2 : {      // menu untuk melihat daftar data pasien yang telah di input
					System.out.println("----------------------");
                    if(!queue.isEmpty()){       // saat antrian tidak kosong maka akan ditampilkan seluruh data pasien yang telah tersimpan
                        System.out.println("    DAFTAR PASIEN ");
                        System.out.println("----------------------");
                        queue.lihat();          // memanggil method lihat yang ada pada class queue
                        System.out.println("");
                        System.out.println("");
                    } else {        // untuk memberitahu kondisi data antrian yang tersimpan kosong
                        System.out.println("xx ANTRIAN KOSONG xx ");
                        System.out.println("");
                    }
					break;
				}
// -------------------------------------------------------------
				case 3 : {      // menu untuk mereset data atau menghapus semua data pasien tanpa terkecuali
                    queue.clear();      // memanggil method clear yand ada pada class queue
                    System.out.println("Daftar Antrian Telah di Reset");
                    System.out.println("");
					break;
				}
// -------------------------------------------------------------
				case 4 : {      // menu untuk memanggil pasien 
                    if(!queue.isEmpty()){       // dapat memanggil pasien saat antrian tidak kosong
                        NodePas terpanggil = queue.terpanggil();        // memanggil method terpanggil yang ada pada class queue
                        System.out.println("Panggilan kepada pasien atas nama " + terpanggil.getNama() + " diharap menuju ruang 1.");
                        System.out.println("");
                        counter--;      // nilai counter akan berkurang (karena pasien setelah terpanggil akann di hapus)
                    }else {     // untuk memberitahu kondisi data antrian yang tersimpan kosong
                        System.out.println("xx DAFTAR ANTRIAN KOSONG xx ");
                        System.out.println("");
                    }
                }
// -------------------------------------------------------------
            }
        } while(menu >= 1 && menu < 5);         // mneu dapat dijalankan pada menu 1-4, 5 program berhenti
        System.out.println("Progam sudah dihentikan. ");
        System.out.println("");
    } // end public void main
} // end class

