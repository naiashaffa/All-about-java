package Struktur_data;

import java.util.Scanner;

/////////////////////////////////////////////////////////////////
class metod {
	private int[] dt; // array
	private int jml_data;
	private int i;
//--------------------------------------------------------------
	public metod() { // constructor
		dt = new int[100]; // array sebanyak 100 indek
		jml_data = 0; // jumlah data mula-mula nol
	}
//--------------------------------------------------------------
// method input untuk memasukkan data ke dalam array
	public void input(int data) {
		dt[jml_data] = data;
		jml_data++;
	}
//--------------------------------------------------------------
// method untuk menampilkan data yang ada dalam array
// method tidak mengembalikan nilai (menggunakan void) --> PROCEDURE
	public void lihat () {
		for(i=0; i<jml_data; i++) // menampilkan data
			System.out.println(dt[i]);
        System.out.println("");
	}
//--------------------------------------------------------------
// method untuk mencari data yang ada dalam array
// method mengembalikan nilai (tidak menggunakan void) --> FUNCTION
	public int cari(int cr) {
        int hitung = 0;
		for(i=0; i<jml_data; i++){ // mencari data pada setiap elemen array
			if(dt[i] == cr) // data pada array sama dengan data yang dicari?
                hitung++;
        }
		return hitung; // mengembalikan nilai
	}
//--------------------------------------------------------------
// method untuk menghapus data yang ada dalam array
// method mengembalikan nilai (tidak menggunakan void) --> FUNCTION
	public int hapus(int hps) {
		int cri = cari(hps);
		for(i=0; i<jml_data; i++){ // mencari data yang akan dihapus
            if(dt[i] == hps){ 
                for(int j = i; j < jml_data; j++) // melakukan penimpaan data
                    dt[j] = dt[j + 1]; // menimpa data
                jml_data--; // mengurangi panjang array
                i--; // pengecekan ulang pada index
            }
        }
		return cri; // mengembalikan nilai
	}
} // end class metod

/////////////////////////////////////////////////////////////////////////
class prak01_22537144008 {
	public static void main(String[] args) {
		int i = 1, dat, cariData;
		Scanner sken = new Scanner(System.in); // deklarasi scanner
		metod md = new metod(); // memanggil class metod dengan variabel md
		
//----------------------------------------------------------------------

		int menu;
		do {
			System.out.println("******************************");
			System.out.println("Pilih Menu di bawah ini");
			System.out.println("1. Memasukkan data");
			System.out.println("2. Pencarian data");
			System.out.println("3. Penghapusan data");
			System.out.println("4. Penampilan data");
			System.out.println("5. Keluar");
			System.out.println("******************************");
			System.out.print("Anda memilih : ");
	  		menu = sken.nextInt();
	  			  		
	  		if (menu==1){ // input data
				System.out.print("Jumlah data yang akan dimasukan = "); 
				int jum = sken.nextInt(); // Scanner untuk jumlah data yang akan ditambahkan
				for(int j = 0; j < jum; j++){
					System.out.print("Masukkan data ke-" + i++ + " = ");
					dat = sken.nextInt(); // input data baru
					md.input(dat); // memanggil method input pada class metod
				}
				System.out.println(jum + " data baru telah disimpan"); // memberikan informasi bahwa data telah dimasukan
				System.out.println("");
			}
			
			if (menu==2) { // mencari data
	  			System.out.print("Data yang anda cari = ");
	 		 	cariData = sken.nextInt(); // Scanner untuk data yang akan dicari
	  		 	int hasil = md.cari(cariData); // memanggil method cari pada class metod
	  		 	if (hasil != 0){ // memberikan informasi jika data ditemukan 
	  		 		System.out.println("Data " + cariData + " ditemukan dengan jumlah " + hasil); 
                }else // memberikan informasi jika data tidak ditemukan 
	  		 		System.out.println("Data " + cariData + " tidak ditemukan ");
	  		 	System.out.println("");
	  		 				
			} else if (menu==3) { // menghapus data
				System.out.print("Data yang anda hapus = ");
	  		 	cariData = sken.nextInt(); // Scanner untuk data yang akan dihapus
	  		 	int sts = md.hapus(cariData); // memanggil method hapus pada class metod
	  		 	if (sts != 0){ // memberikan informasi jika data telah dihapus
	  		 		System.out.println("Data " + cariData + " sejumlah " + sts + " berhasil dihapus.");
					i -= sts; 
				}
	  		 	else // memberikan informasi jika data yang akan dihapus tidak ditemukan
	  		 		System.out.println("Data " + cariData + " TIDAK ditemukan");
				
				System.out.println("");
	
			} else if (menu==4) { // menampilkan data
				md.lihat(); // memanggil method lihat pada class metod
			}
		} while (menu >= 1 && menu < 5);
		System.out.println("Program Dihentikan"); // memberikan informasi bahwa program telah dihentikan
		System.out.println("");
	} // end main()
} // end class tgsPertamaOK

