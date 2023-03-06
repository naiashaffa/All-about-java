package Struktur_data;

import java.util.Scanner;

// queue atau antrian
////////////////////////////////////////////////////////////////

// clas queue atau antrian
    // class untuk menyimpan data pasien 
    class pasien { // pasien mempunyai 3 data: nama, keluhan, dan alamt
	    private String namaPas;
	    private String keluhanPas;
	    private String alamatPas;
//--------------------------------------------------------------
    // berguna juga untuk "memasukkan" data pasien
    public pasien(String nama, String keluhan, String alamat) {
        namaPas = nama;
        keluhanPas = keluhan;
        alamatPas = alamat;
}
//--------------------------------------------------------------
    //method untuk menampilkan data pasien
    public void lihatData(){
        System.out.println("Nama : " + namaPas + "|| Keluhan : " + keluhanPas + "|| Alamat : " + alamatPas);
        System.out.println("____________________________________________________");
}
//--------------------------------------------------------------
    //method mengambil data nama pasien
    public String getNama(){
        return namaPas;
    }
//--------------------------------------------------------------
    //method mengambil data keluhan pasien
    public String getKeluhan(){
        return keluhanPas;
    }
//--------------------------------------------------------------
    //method mengambil data alamat pasien
    public String getAlamat(){
        return alamatPas;
    }
} // end class pasien
////////////////////////////////////////////////////////////////

//class untuk menyimpan data para pasien menggunakan queue
class queue {
    private pasien[] antrian;                   // array dengan tipe data ADT
    private int max;                            // nilai jumlah maksimal data yang disimpan
    private int ekor;                           // indeks terakhir dari antrian                         
//--------------------------------------------------------------
    public queue(int m){
        max = m;
        antrian = new pasien[max];
        ekor = -1;
    }
//--------------------------------------------------------------
    public void enQueue(pasien data){
        antrian[++ekor] = data;
    }

    public pasien deQueue(){
        pasien terpanggil = antrian[0];
        for(int i = 0; i < ekor; i++){
            antrian[i] = antrian[i+1];
            ekor--;
        }
        return terpanggil;
    }
    public pasien peek(){
        return antrian[0];
    }
    public boolean isFull(){
        return (ekor == max-1);
    }
    public boolean isEmpty(){
        return (ekor == -1);
    }
//--------------------------------------------------------------
    public void daftar(String nama, String keluhan, String alamat){
        pasien data = new pasien(nama, keluhan, alamat);
        enQueue(data);
    }
    public pasien dipanggil(){
        return deQueue();
    }
    public void lihat(){
        for(int i = 0; i <= ekor; i++){
            antrian[i].lihatData();
        }
    }
    public pasien cari(String nama){
        for(int i = 0; i<= ekor; i++){
            if(antrian[i].getNama().equals(nama)){
                return antrian[i];
            }
        }
        return null;
    }
//--------------------------------------------------------------
    public String nama(){
        return antrian[0].getNama();
    }
//--------------------------------------------------------------
    public String keluhan(){
        return antrian[0].getKeluhan();
    }
//--------------------------------------------------------------
    public String alamat(){
        return antrian[0].getAlamat();
    }
}  // end class arrai

public class prak03_22537144008 {
	public static void main(String[] args) {
        int i = 0, max = 101;
        Scanner sken = new Scanner(System.in);
		queue queue = new queue(max); // queue menampung sampai 5 data
        String nama, keluhan, alamat;
//--------------------------------------------------------------
		int menu;
		do {			
            System.out.println("######################################");
			System.out.println("Pilih Menu");
			System.out.println("1. Pendaftaran Pasien");
			System.out.println("2. Pemanggilan Pasien");
			System.out.println("3. Daftar Antrian Pasien");
			System.out.println("4. Cari Pasien");
			System.out.println("5. Keluar");
            System.out.println("######################################");
			System.out.print("Menu yang dipilih : ");
  	    	menu = sken.nextInt();
  	    	System.out.println("");
//--------------------------------------------------------------
			switch(menu) {
				case 1 : {
					if(!queue.isFull()){
                        System.out.println("----------------------");
                        System.out.println("  PENDAFTARAN PASIEN  ");
                        System.out.println("");
                        System.out.println("Masukan Data Pasien Baru");
                        System.out.print("Nama : ");
                        nama = sken.next();
                        System.out.print("Keluhan : ");
                        keluhan = sken.next();
                        System.out.print("Alamat : ");
                        alamat = sken.next();
                        queue.daftar(nama, keluhan, alamat);
                        System.out.println("");
                    } else {
                        System.out.println("ANTRIAN PENUH !!!");
                    }
					break;
				}
				case 2 : {
					if(!queue.isEmpty()){
                        pasien terpanggil = queue.dipanggil();
                        System.out.println("Panggilan kepada pasien atas nama " + terpanggil.getNama() + " diharap menuju ruang 1.");
                        System.out.println("");
                        i--;
                    }else {
                        System.out.println("Daftar antian kosong.");
                        System.out.println("");
                        System.out.println("");
                        
                    }
					break;
				}
				case 3 : {
					System.out.println("----------------------");
                    if(!queue.isEmpty()){
                        System.out.println("    DAFTAR PASIEN ");
                        System.out.println("");
                        queue.lihat();
                        System.out.println("");
                        System.out.println("");
                    }else {
                        System.out.println("xx ANTRIAN KOSONG xx ");
                        System.out.println("");
                        System.out.println("");
                    }
					break;
				}
				case 4 : {
                    System.out.println("");
                    System.out.println("");
                    System.out.println("");
                    System.out.println("");
                    String cari = sken.next();
                    pasien hasilCari = queue.cari(cari);
                    if(hasilCari != null){
                        hasilCari.lihatData();
                        System.out.println("");
                        System.out.println("");
                    }else {
                        System.out.println("Pasien tida ditemukan pada daftar.");
                        System.out.println("");
                        System.out.println("");
                    }
                }
            }
        } while(menu >= 1 && menu < 5);
    }
} // end class javaQueue
