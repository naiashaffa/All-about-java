package Struktur_data;


import java.lang.reflect.Method;
import java.util.List;
// Simple Linked List
import java.util.Scanner;

//untuk menyimpan data mahasiswa
class mahasiswa {                   
	public String nimMhs;
	public String namaMhs;
    public String kotaMhs;
	public mahasiswa next;
// -------------------------------------------------------------
	public mahasiswa(String nim, String nama, String kota) { // constructor
		nimMhs = nim;
		namaMhs = nama;
        kotaMhs = kota;
	}
// -------------------------------------------------------------
    public void lihatData(){
        System.out.println("NIM : " + nimMhs + " || Nama : " + namaMhs + " || Asal Kota : " + kotaMhs);
        System.out.println("--------------------------------------------------------------------");

    }
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
	private mahasiswa first;
	public LinkList() { // constructor
		first = null;
	}
// -------------------------------------------------------------
	public boolean isEmpty() { 
		return (first == null);
	}
// -------------------------------------------------------------
    public void insertFirst(String nimMhs, String namaMhs, String kotaMhs) {
        mahasiswa newmahasiswa = new mahasiswa(nimMhs, namaMhs, kotaMhs);
        newmahasiswa = first;

        first = newmahasiswa;
    }
// -------------------------------------------------------------
    public mahasiswa delete() {
        mahasiswa temp = first;
        first = first.next;

        return temp;
    }
// -------------------------------------------------------------
    public LinkList cari(String cari, int method) {
        LinkList result = new LinkList();
        mahasiswa index = first;
        while(index != null){
        switch(method){
            case 1 : 
                if(index.getNim().equals(cari)){
                    result.insertFirst(index.getNim(), index.getNama(), index.getKota());
                }
                break;
                

                case 2 : 
                    if(index.getNama().equals(cari)){
                        result.insertFirst(index.getNim(), index.getNama(), index.getKota());
                    }
                    break;
                

                case 3 : 
                    if(index.getKota().equals(cari)){
                        result.insertFirst(index.getNim(), index.getNama(), index.getKota());
                    }
                    break; 
            }  
            index = index.next;
        }
        return result;
    }
    public void lihatData(){
        mahasiswa index = first;
        while(index != null){
            index.lihatData();
            index = index.next;
        }
        System.out.println("");
    }   
} // end class LinkList
////////////////////////////////////////////////////////////////

public class prak04_22537144008 {
	public static void main(String[] args) {
        LinkList theList = new LinkList();              //membuat list baru
        Scanner sken = new Scanner(System.in);
        String nim, nama, kota;
        int i, Pilih, jumlah = 0 ;

        int menu;
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
  	    	menu = sken.nextInt();
  	    	System.out.println("");
        }

        switch(menu) {
            case 1 : {
                System.out.println("Masukkan data mahasiswa ");
                System.out.println("Jumlah input = ");                  //diawal ditanya jumlah inputan data
                int jmlData = sken.nextInt();
                System.out.println("");

            for(i = 0; i < jmlData; i++){
                System.out.println("Data mahasiswa ke-" + ++jumlah + " : ");
                System.out.print("NIM  : ");
                nim = sken.next();
                System.out.print("Nama : ");
                nama = sken.next();
                System.out.print("Asal Kota  : ");
                kota = sken.next();
                System.out.println("");

              if(theList.cari(nim, 1 ).isEmpty()){
                  theList.insertFirst(nim, nama, kota);
              }
            }
                
            }

            case 2 : {
                System.out.println("Data mahasasis yang Anda cari")
            }

            case 3 : {
                System.out.println("Menghapus data mahasiswa");
            }

            case 4 : {
                System.out.println("Data Mahasiswa");
            }
        } while (menu >= 1 && menu < 5);
	} // end main()
} // end class LinkListApp
////////////////////////////////////////////////////////////////

