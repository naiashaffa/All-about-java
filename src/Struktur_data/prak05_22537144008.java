package Struktur_data;
//NAMA  : NAIA SHAFFA CAMILA
//NIM   : 22537122008

import java.util.*;
class NodePas {
    public String namaPas;
    public String keluhanPas;
    public String alamatPas;

    public NodePas (String nama, String keluhan, String alamat){
        namaPas = nama;
        keluhanPas = keluhan;
        alamatPas = alamat;
    }

    public void lihatData(){
        System.out.println("Nama : " + namaPas + " || Keluhan : " + keluhanPas + " || Alamat : " + alamatPas);
        System.out.println("--------------------------------------------------------------------");
    }
}
class fisrtEndList {
    private NodePas first;
    private NodePas last;

    public fisrtEndList() {
        first = null;
        last = null;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public void insertLast (String nama, String keluhan, String alamat) {
        NodePas newNodePas = new NodePas(nama, keluhan, alamat);
        if(isEmpty()) {
            first = newNodePas;
        } else {
            last.next = newNodePas;
            last = newNodePas;
        }
    }

    public String hapusFirst() {
        String temp = first.namaPas;
        if(first.next == null) {
            last = null;
            first =first.next;
        }
        return temp;
    }

    public void lihat() {
        NodePas index = first;
        while(index != null) {
            index.lihatData();
            index = index.next;
        }
        System.out.println("");
    }
}
class LinkQueue {
    private fisrtEndList list;

    public LinkQueue() {
        list = new fisrtEndList();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public boolean isFull(String a, String) {
        if
    }

    public void enQueue(Strig namaPas, String keluhanPas, String alamatPas) {
        list.insertLast(alamatPas, keluhanPas, alamatPas);
    }

    public long deQueue() {
        return  list.hapusFirst();
    }

    public boolean clear() {
        while (!list.isEmpty()) {
            list.hapusFirst();
        }
        return list.isEmpty();
    }

    public lihatQueue() {
        System.out.println("Antrian (awal ke akhir) = ");
        list.lihat();
    }
}
public class prak05_22537144008 {
    public static void main(String[] args) {
        LinkQueue queue = new LinkQueue();
        System.out.print("Masukan jumlah Antrian maksimal = ");
        Scanner input = new Scanner(System.in);
        int max = input.nextInt();
        int counter = 0;

        int menu;

        do {
            System.out.println("######################################");
			System.out.println("Pilih Menu");
			System.out.println("1. Pendaftaran Pasien");
			System.out.println("2. Daftar Antrian Pasien");
			System.out.println("3. Cari Pasien");
			System.out.println("4. Pemanggilan Pasien");
			System.out.println("5. Keluar");
            System.out.println("######################################");
			System.out.print("Menu yang dipilih : ");
  	    	menu = input.nextInt();
  	    	System.out.println("");
//--------------------------------------------------------------
			switch(menu) {
				case 1 : {
					if(!queue.isFull()) {
                        System.out.println("----------------------");
                        System.out.println("  PENDAFTARAN PASIEN  ");
                        System.out.println("");
                        System.out.println("Masukan Data Pasien Baru");
                        System.out.print("Nama : ");
                        nama = input.next();
                        System.out.print("Keluhan : ");
                        keluhan = input.next();
                        System.out.print("Alamat : ");
                        alamat = input.next();
                        queue.daftar(nama, keluhan, alamat);
                        System.out.println("");
                    } else {
                        System.out.println("ANTRIAN PENUH !!!");
                    }
					break;
				}
				case 2 : {
					System.out.println("----------------------");
                    if(!queue.isEmpty()){
                        System.out.println("    DAFTAR PASIEN ");
                        System.out.println("----------------------");
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
				case 3 : {
                    System.out.print("Nama Pasien :");
                    String cari = input.next();
                    pasien hasilCari = queue.cari(cari);
                    if(hasilCari != null){
                        hasilCari.lihatData();
                        System.out.println("");
                    }else {
                        System.out.println("");
                        System.out.println("Pasien tidak ditemukan pada daftar.");
                        System.out.println("");
                    }
					break;
				}
				case 4 : {
                    if(!queue.isEmpty()){
                        pasien terpanggil = queue.dipanggil();
                        System.out.println("Panggilan kepada pasien atas nama " + terpanggil.getNama() + " diharap menuju ruang 1.");
                        System.out.println("");
                        i--;
                    }else {
                        System.out.println("xx DAFTAR ANTRIAN KOSONG xx ");
                        System.out.println("");
                        System.out.println("");
                    }
                }
            }
        } while(menu >= 1 && menu < 5);
    }
}

