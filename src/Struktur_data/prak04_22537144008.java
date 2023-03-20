package Struktur_data;

import java.util.*;
// Simple Linked List
/*
NAMA    : Naia Shaffa Camila 
NIM     : 22537144008
*/

//untuk menyimpan data mahasiswa
class NodeMhs {                   
	public String nimMhs;
	public String namaMhs;
    public String kotaMhs;
	public NodeMhs next;            //pointer untuk menunjuk node berikutnya
// -------------------------------------------------------------
	public NodeMhs(String nim, String nama, String kota) { // constructor
		nimMhs = nim;
		namaMhs = nama;
        kotaMhs = kota;
	}
// -------------------------------------------------------------
    //method untuk menampilkan data yg tersimpan
    public void lihatData(){
        System.out.println("NIM : " + nimMhs + " || Nama : " + namaMhs + " || Asal Kota : " + kotaMhs);
        System.out.println("--------------------------------------------------------------------");

    }
// -------------------------------------------------------------
    //method untuk mengambil data mahasiswa berdasarkan;

    public String getNim(){
        return nimMhs; 
    }

    public String getNama() {
        return namaMhs; 
    }

    public String getKota() {
        return kotaMhs; 
    }
} // end class mahasiswa
////////////////////////////////////////////////////////////////

class LinkList {
	private NodeMhs first;      //pointer first untuk menunjuk node pertama

public LinkList() { // constructor
	first = null;       //pinter menunjuk null maka list kosong
}
// -------------------------------------------------------------
	public boolean isEmpty() { 
		return (first == null);     // pointer == null makan list kosong
	}
// -------------------------------------------------------------
    //metode menambah data awal list
    public void insertFirst(String nimMhs, String namaMhs, String kotaMhs) {        
        NodeMhs newNodeMhs = new NodeMhs(nimMhs, namaMhs, kotaMhs);         //deklarasi untuk menyimmpan data baru
        newNodeMhs.next = first;        //pointer next baru menunjuk ke node yang ditunjuk oleh first

        first = newNodeMhs;
    }
// -------------------------------------------------------------
    //metode menghapus data
    public NodeMhs delete() {
        NodeMhs temp = first;       //menyipan node sementara (yg ditunjuk oleh first)
        first = first.next;

        return temp;        //mereturn list
    }
// -------------------------------------------------------------
   //metode mencari data 
    public LinkList cari(String cari, int method) {
        LinkList result = new LinkList();
        NodeMhs index = first;
        while(index != null){           //terjadi loop jika index tidak sama dnegan null
        switch(method){
            case 1 :                    //mencari data berdasarkan nim
                if(index.getNim().equals(cari)){
                    result.insertFirst(index.getNim(), index.getNama(), index.getKota());
                }
                break;
                

                case 2 :                //mencari data berdasarkan nama
                    if(index.getNama().equals(cari)){
                        result.insertFirst(index.getNim(), index.getNama(), index.getKota());
                    }
                    break;
                

                case 3 :                //mencari data berdasarkan kota
                    if(index.getKota().equals(cari)){
                        result.insertFirst(index.getNim(), index.getNama(), index.getKota());
                    }
                    break; 
            }  
            index = index.next;
        }
        return result;
    }
// -------------------------------------------------------------
    //metode untuk menampilkan data tersimpan
    public void lihatData(){
        NodeMhs index = first;
        while(index != null){
            index.lihatData();
            index = index.next;
        }
        System.out.println("");
    }   
} // end class LinkList
////////////////////////////////////////////////////////////////

//client class (menu(choose))
public class prak04_22537144008 {
	public static void main(String[] args) {
        Scanner sken = new Scanner(System.in);
        //membuat list baru
        LinkList theList = new LinkList();              
        String nimMhs, namaMhs, kotaMhs;
        int i, choose, jumlah = 0 ;

        do{
            System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
			System.out.println("Pilih Menu");
			System.out.println("1. Masukan Data Mahasiswa ");
			System.out.println("2. Mencari Data Mahasiswa ");
			System.out.println("3. Menghapus Data Mahasiswa");
			System.out.println("4. Tampilkan Data Mahasiswa");
			System.out.println("5. Keluar");
            System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
			System.out.print("Menu yang dipilih : ");
  	    	choose = sken.nextInt();
  	    	System.out.println("");
        

        switch(choose) {
            case 1 : {
                System.out.println("Masukkan data mahasiswa ");
                System.out.print("Jumlah input = ");                  //diawal ditanya jumlah inputan data
                int jmlData = sken.nextInt();
                System.out.println("");

            // kode untuk bentuk inputan
            for(i = 0; i < jmlData; i++){                   
                System.out.println("Data mahasiswa ke-" + ++jumlah + " : ");
                System.out.print("NIM  : ");
                nimMhs = sken.next();
                System.out.print("Nama : ");
                namaMhs = sken.next();
                System.out.print("Asal Kota  : ");
                kotaMhs = sken.next();
                System.out.println("");

            // kode untuk rule yang dibuat
              if(theList.cari(nimMhs, 1 ).isEmpty()){
                  theList.insertFirst(nimMhs, namaMhs, kotaMhs);
                  System.out.println("Data Mahasiswa Tersebut Telah Tersimpan");
              } else {
                System.out.println("NIM Sudah Terdaftar");
              }
              System.out.println("");
            } 
            }
            break;

            case 2 : {
                String cari;
                LinkList hasil;

                //untuk menu cari akan ada submenu untuk memilih mencari data berdasarkan kategori
                System.out.println("Data mahasasis yang Anda cari");
                System.out.println("Mencari berdasarkan : ");
                System.out.println("1. NIM");
                System.out.println("2. Nama");
                System.out.println("3. Kota");
                System.out.print("Pilih : ");
                choose = sken.nextInt();
                System.out.println("");

                switch(choose){
                    
                case 1:
                System.out.print("Masukan NIM Mahasiswa : ");
                cari = sken.next();
                System.out.println("");
                
                hasil = theList.cari(cari, choose);
                if(!hasil.isEmpty()){
                    System.out.println("Data Mahasiswa yang ditemukan : ");
                    hasil.lihatData();
                }else {
                    System.out.println("Data Mahasiswa dengan NIM " + cari + " Tidak ditemukan");
                }
                break;

                case 2:
                System.out.print("Masukan NAMA Mahasiswa : ");
                cari = sken.next();
                System.out.println("");
                
                hasil = theList.cari(cari, choose);
                if(!hasil.isEmpty()){
                    System.out.println("Data Mahasiswa yang ditemukan : ");
                    hasil.lihatData();
                }else {
                    System.out.println("Data Mahasiswa dengan NAMA " + cari + " Tidak ditemukan");
                }
                break;

                case 3:
                System.out.print("Masukan NAMA KOTA Mahasiswa : ");
                cari = sken.next();
                System.out.println("");
                
                hasil = theList.cari(cari, choose);
                if(!hasil.isEmpty()){
                    System.out.println("Data Mahasiswa yang ditemukan : ");
                    hasil.lihatData();
                }else {
                    System.out.println("Data Mahasiswa dengan NAMA KOTA " + cari + " Tidak ditemukan");
                }
                }
            }
            break;

            case 3 : {
                if(!theList.isEmpty()){
                    System.out.println("Menghapus data mahasiswa");
                    System.out.println("DATA MAHASISWA YANG DIHAPUS ADALAH YANG TERAKHIR DISIMPAN");
                    NodeMhs delete = theList.delete();
                    jumlah--;
                    System.out.println("Data Mahasiswa Telah di Hapus");
                } else {
                    System.out.println("Tidak ada data Mahasiswa yang tersimpan!");
                }
                System.out.println("");
            }
            break;
            case 4 : {
                System.out.println("Data Mahasiswa");
                theList.lihatData();    //memanggil method 'lihatData' 
                System.out.println("");
            }
            break;
        } 
	} while (choose >= 1 && choose < 5);
  } // end main()
} // end class LinkListApp
////////////////////////////////////////////////////////////////

