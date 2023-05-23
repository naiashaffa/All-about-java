package Struktur_data;
/*
 * Nama     : Naia Shaffa Camila
 * NIM      : 22537144008
 */

import java.util.*;
// menu
public class uas_22537144008 {
    public static void main(String[] args) {
        Tree tree = new Tree();
        Scanner input = new Scanner(System.in);
        int data;
        int i ;
        int menu, subMenu;

        do {                    // pilihan menu
            System.out.println("==================================");
            System.out.println("        Menu Binary Tree");
            System.out.println("1. Insert");
            System.out.println("2. Delete");
            System.out.println("3. Traversal");
            System.out.println("4. Leaves");
            System.out.println("5. Min and Max");
            System.out.println("6. Exit");
            System.out.println("==================================");
            System.out.print("Pilih menu : ");
            menu = input.nextInt();
            System.out.println("");   
            
            switch (menu) {
                case 1:
                // menu memasukan data
                    System.out.println("============== INSERT =============="); 
                    System.out.print("Jumlah data yang akan dimasukkan : ");
                    int s = input.nextInt();        // jumlah daya yg akan di input
                    for (i = 0; i < s; i++) {
                        System.out.print("Data ke-" + i + " : ");   // looping sampai nilai s terpenuhi
                        data = input.nextInt();
                        if (tree.insert(data)) {        // saat data baru di input, makan akan disimpan
                            System.out.println("DATA BERHASIL DI SIMPAN");
                            System.out.println();
                        } else {        // jika data sudah tersimpan di tree
                            System.out.println(" **DATA SUDAH ADA**");
                            System.out.println();
                        }
                    }
                    System.out.println("====================================");
                    System.out.println();
                    break;

                case 2:
                // menu untuk menghapus data tertentu
                System.out.println("============== DELETE ==============");
                if (tree.isEmpty()) {       // jika tree masih kosong, maka...
                    System.out.println("xxxxxxxxxxx BINNARY TREE KOSONG xxxxxxxxxxx ");
                    System.out.println();
                    break;
                }
                System.out.print("Data yang akan dihapus : ");
                data = input.nextInt();
                if (tree.delete(data) != null) {        // jika data terdapat dalam tree, maka...
                    System.out.println("------------ DATA BERHASIL DIHAPUS ------------");
                } else {
                    System.out.println("------------ DATA GAGAL DIHAPUS ------------");
                    System.out.println("------------ Data Tidak Ditemukan ------------");
                }
                System.out.println("====================================");
                System.out.println();
                break;
            
                case 3:
                // menu traversal
                System.out.println("============== TRAVERSAL ==============");
                System.out.println("Submenu Traversal");
                System.out.println("1. Preorder");
                System.out.println("2. Inorder");
                System.out.println("3. Postorder");
                System.out.print("Pilih menu : ");
                subMenu = input.nextInt();      // menu yg dipilih
                System.out.println();

                switch (subMenu) {
                    case 1:         // jika memilih submenu 1 yaitu Preorder, akan memunculkan data dg NLR
                        System.out.println("----------- Preorder ----------- ");
                        tree.preOrder(tree.getRoot());      // memanggil method preorder
                        System.out.println("---------------------------------");
                        break;
                        
                    case 2:         // jika memilih submenu 1 yaitu Inorder, akan memunculkan data dg LNR
                        System.out.println("----------- Ineorder ----------- ");
                        tree.inOrder(tree.getRoot());       // memanggil method inorder
                        System.out.println("---------------------------------");
                        break;

                    case 3:         // jika memilih submenu 1 yaitu Postorder, akan memunculkan data dg LRN
                        System.out.println("----------- Postorder ----------- ");
                        tree.postOrder(tree.getRoot());     // memanggil method postorder
                        System.out.println("---------------------------------");
                        break;

                    default : // jika inputan tidak sesuai
                    System.out.println("!! INPUTAN ANDA SALAH, COBA ULANG !!");
                        break;
                } 
                System.out.println("====================================");
                System.out.println(); 
                break;

                case 4:
                // menu menampilkan leave
                System.out.println("============== LEAVES ==============");
                if (tree.isEmpty()) {       // jika tree masih kosong, maka..
                    System.out.println("xxxxxxxxxxx BINNARY TREE KOSONG xxxxxxxxxxx ");
                    System.out.println();
                    break;
                }
                System.out.print("Leaves : ");
                tree.leaves(tree.getRoot());        // memanggil method leaves
                System.out.println("====================================");
                System.out.println();
                break;

                case 5: 
                // menu menampilkan data terkecil dan terbesar yang ada dalam tree
                System.out.println("============== MIN AND MAX ==============");
                if (tree.isEmpty()) {       // jika tree masih kosong, maka...
                    System.out.println("xxxxxxxxxxx BINNARY TREE KOSONG xxxxxxxxxxx ");
                    System.out.println(); 
                    break;
                }
                System.out.print("MIN : ");
                tree.getMIn().displayTree();        // memanggil method min
                System.out.print("MAX : ");
                tree.getMax().displayTree();        // memanggil method max
                System.out.println("====================================");
                System.out.println();
                break;

            }
        } while(menu >= 1 && menu < 5);     // jika menu yg dipilih 5, maka akan keluar dari program
        System.out.println("Program dihentikan. ");
        System.out.println("");
    }
}

class NodeUas {
    private final int data;         // yg disimpan dalam 'data' adalah data fix(sudah melalui proses)

    private NodeUas left;
    private NodeUas right;

    public NodeUas (int data) {
        this.data = data;
    }
    public void leftChild (NodeUas left){ // menunjuk Node kiri
        this.left = left;
    } 
    public void rightChild (NodeUas right){ // menunjuk Node kanan
        this.right = right;
    } 

    // metode untuk mengambil data
    public int getData(){
        return data;
    }
    public NodeUas getLeft(){
        return left;
    }
    public NodeUas getRight(){
        return right;
    }

    public void displayTree(){
        System.out.println("DATA : [" + data + "]");
    }
}

class Tree {
    private NodeUas root;

    public Tree(){
        root = null;
    }

    public boolean isEmpty(){
        return root == null;
    }

    private NodeUas search(int data){
        NodeUas index = root;
        while (index.getData() != data) {
            if (data < index.getData()) {
                index = index.getLeft();
            } else {
                index = index.getRight();
            }
            if (index == null) {
                return null;
            }
        }
        return index;
    }

    public boolean insert(int data) {
        NodeUas newNode = new NodeUas(data);        // membuat node baru

        if (root == null) {         // jika belum terdapat data, tree masih kosong
            root = newNode;     // node dijadikan root
        } else {        // jika sudah terdapat root
            if (search(data) != null) {
                return false;
            }
        NodeUas index = root;       // pointer index yang diarahkan ke node yg ditunjuk oleh pointer root
        NodeUas parent;             // pointer parent

        while (true) {      // ketika bernilai true
            parent = index;     // pointer parent akan diarahkan ke node yang ditunjuk oleh index

            if (data < index.getData()) {       // jika data yang dimasukan lebih kecil dari data pointer index, maka
                index = index.getLeft();        // pointer index di set untuk menunjuk node disebelah kiri node (leftchild)
                if (index == null) {        // jika pointer tidak menunjuk siapa", maka
                    parent.leftChild(newNode);      // masukan data (node baru) dikiri pointer yang menunjuk parent
                    return true;
                }
            } else { // jika data yang dimasukan lebih besar dari data pointer index, maka
                index = index.getRight();       // pointer index diset untuk menunjuk node diseblah kanan node (rightchild)
                if (index == null) {        // jika pointer tifak menunjuk siap", maka
                    parent.rightChild(newNode);     // masukan data (node baru) dikanan pointer yang menunjuk parent
                    return true;
                }
            }
        }
    } 
    return true;
    }

    public NodeUas delete(int data){
        NodeUas index = root;           // pointer index diarahkan ke node yang ditunjuk oleh pointer root
        NodeUas parent = root;          // pointer parent diarahkan ke node yang ditunjuk oleh pointer root

        boolean leftChild = true;       // di sini variabel leftchild bernilai true

        while (index.getData() != data) {       // ketika data pada pointer index tidak sama dg data yang akan di hapus, maka
            parent = index;             // pointer parent akan diarahkan ke node yang ditunjuk oleh pointer inndex
            if (data < index.getData()) {       //jika data yang akan di hapus lebih kecil dari data yang di tunjuk oleh pointer index, maka
                leftChild = true;           // variabel leftchild akan bernilai true
                index = index.getLeft();       // pointer index akan diarahkan ke node sebelah kiri
            } else {        // jika data yang akan di hapus lebih besar dari data yang ditunjuk oleh pointer index, maka
                leftChild = false;          // variabel leftchild akan bernilai false
                index = index.getRight();       // pointer index akan diarahkan ke node sebelah kanan
            }
            if (index == null) {        // jika pointer index sama dengan null, maka
                return null;            // data yang akan di hapus tidak ditemukan
            }
        }

        // jika data yang akan di hapus ada dan terletak di Leaf (node yang tdk memiliki child)
        if (index.getLeft() == null && index.getRight() == null) {  
            if (index == root) {        // jika data yang akan di hapus terletak pada root (hanya ada 1 data dalam tree)
                root = null;    
            } else {
                if (leftChild) {        // jika data yang akan dihapus terletak disebelah kiri pointer parent, maka
                    parent.leftChild(null); // pointer leftchild dari node yang ditunjuk oleh pointer parent akan di set NULL
                } else {        // jika data yang akan dihapus terletak disebelah kanan pointer parent, maka
                    parent.rightChild(null);        // pointer rightchild dari node yang ditunjuk oleh pointer parent akan di set NULL
                }
            }

        // jika data yang akan dihapus ada dan HANYA mempunyai leftchild
        } else if (index.getLeft() == null) {
            if (index == root) {            // jika data yang akan dihapus terletak pada root, maka
                root = index.getLeft();         // pointer root di set menunjuk ke node yg ditunjuk oleh pointer leftchild dari node yang ditunjuk oleh pointer index
            } else {            // jika data yang dihapus tidak terletak pada root, maka
                if (leftChild) {            // jika terletak di child sebelah kiri, maka
                    parent.leftChild(index.getLeft());      // child kiri dari node yg dihapus menjadi child kiri dari pointer parent
                } else {        // jika tereletak di child sebelah kanan, maka
                    parent.rightChild(index.getLeft());     // child kiri dari node yg dihapus menjadi child kanan dari pointer parent
                }
            }

        // jika data yang akan dihapus ada dan HANYA mempunyai leftchild
        } else if (index.getLeft() == null) {
            if (index == root) {        // jika data yang akan dihapus terletak pada root, maka
                root = index.getRight();      // pointer root di set menunjuk ke node yg ditunjuk oleh pointer rightchild dari node yang ditunjuk oleh pointer index
            } else {        // jika data yang dihapus tidak terletak pada root, maka
                if (leftChild) {        // jika terletak di child sebelah kiri, maka
                    parent.leftChild(index.getRight());     // child kanan dari node yg dihapus menjadi child kiri dari pointer parent
                } else {        // jika tereletak di child sebelah kanan, maka
                    parent.rightChild(index.getRight());    // child kanan dari node yg dihapus menjadi child kanan dari pointer parent
                }
            }

        // jika data yang akan dihapus ada dan MEMPUNYAI leftchild and rightchild
        } else {        // cari successor
            NodeUas successor = getSuccessor(index);       // cari successor dari data yg akan dihapus, memanggil method successor
            if (index == root) {        // jika data yg akan dihapus terletak pada root, maka
                root = successor;     // pointer root akan diarahkan ke node yang ditunjuk oleh pointer successor
            } else {        // jika data yg akan dihapus tidak terletak pada root, maka
                if (leftChild) {        //jika disebelah kiri parent
                    parent.leftChild(successor);
                } else {        // jika disebelah kanan parent
                    parent.leftChild(successor);
                }
                successor.leftChild(index.getLeft());
            }
        }
        return index;           // me-return index
    }
    private NodeUas getSuccessor(NodeUas data){
        NodeUas parent = data;              // pointer parent diarahkan ke node yang ditunjuk oleh pointer data
        NodeUas successor = data;           // pointer successor diarahkan ke node yang ditunjuk oleh pointer data
        NodeUas index = data.getRight();

        while (index != null) {         // jika pointer index sama dengan null, maka
            parent = successor;
            successor = index;
            index = index.getLeft();
        }
        if (successor != data.getRight()) {
            parent.leftChild(successor.getRight());
            successor.rightChild(data.getRight());
        }
        return successor;
    }
    
    // preoder NODE-LEFT-RIGTH
     public void preOrder(NodeUas node) {
        if (node != null) {
            System.out.println(node.getData() + " ");
            preOrder(node.getLeft());
            preOrder(node.getRight());
        }
     }

     // inorder LEFT-NODE-RIGHT
     public void inOrder(NodeUas node) {
        if (node != null) {
            inOrder(node.getLeft());
            System.out.println(node.getData() + " ");
            inOrder((node.getRight()));
        }
     }

     // postorder LEFT-RIGHT-NODE
     public void postOrder(NodeUas node) {
        if (node != null) {
            postOrder(node.getLeft());
            postOrder(node.getRight());
            System.out.println(node.getData() + " ");
        }
     }

     public void leaves (NodeUas node) {        // mencari data yang tidak punya anak
        if (node != null) {
            leaves(node.getLeft());
            if (node.getLeft() == null && node.getRight() == null) {
                System.out.println(node.getData() + " ");
            }
            leaves(node.getRight());
        }
     }

     public NodeUas getMIn() {
        NodeUas index = root;

        while (index != null) {             // ketika kondisi index tidak sama dg null, maka
            if (index.getLeft() == null) {      // jika node paling kiri adalah node pertama
                return index;           // menampilkan nilai terendah
            }
            index = index.getLeft();        // jika tidak, pointer index akan menunjuk ke node sebelah kirinya
        }
        return null;
     }

     public NodeUas getMax() {
        NodeUas index = root;

        while (index != null) {     // ketika kondisi index tidak sama dg null, maka
            if (index.getRight() == null) {    // jika node paling kanan adalah node terakhir
                return index;       // menampilkan nilai tertinggi
            }
            index = index.getRight();       // jika tidak, pointer index akan menunjuk ke node sebelah kanannya
        }
        return null;
     }

        

     
     public NodeUas getRoot() {
        return root;
     }
}
