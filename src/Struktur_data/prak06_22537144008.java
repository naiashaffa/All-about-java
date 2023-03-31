package Struktur_data;

import java.util.Scanner;

class Node {
    public int kodeMK;
    public String namaMK;

    public Node next;
    public Node previous;
// -------------------------------------------------------------
    public Node (int kodeMK, String namaMK) {
        this.kodeMK = kodeMK;
        this.namaMK = namaMK;
    }
// -------------------------------------------------------------
   public void lihatData() {
    System.out.printf("|%-12d|%-12d| \n",kodeMK, namaMK);
   }

} // end class mata kuliah

class doubleLink {
    private Node first;
    private Node last;
    private Node temp;

    public boolean isEmpty() {
        return first == null;
    }

    public void insertFirst(int kodeMK, String namaMK) {
        Node newNode = new Node(kodeMK, namaMK);
        if (isEmpty()) {
            last = newNode;
        } else {
            first.previous = newNode;
            newNode.next = first;
        }
        first = newNode;
        count++;
    }
}

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
            System.out.println("Menu yang dipilih : ");
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
