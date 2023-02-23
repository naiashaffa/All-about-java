package Pemrograman_2;

import java.util.ArrayList;

public class NaiaIntersect {
    public static void main(String [] args){
        ArrayList<Integer>list1 = new ArrayList<Integer>();              // list data pertama
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);
        list1.add(6);
        list1.add(7);
        list1.add(8);
        list1.add(9);

        ArrayList<Integer>list2 = new ArrayList<Integer>();             // list data kedua
        list2.add(11);
        list2.add(10);
        list2.add(9);
        list2.add(8);
        list2.add(7);
        list2.add(12);
        list2.add(13);
        list2.add(14);
        list2.add(1);
        list2.add(2);

        System.out.println("Data list pertama = " + list1);
        System.out.println("Data list kedua = " + list2);
        System.out.println("Data list gabungan yang sama = " + intersect(list1, list2));   // menampilkan list data baru
        

    }
    public static ArrayList<Integer> intersect (ArrayList<Integer>list1, ArrayList<Integer>list2){
        ArrayList<Integer>list = new ArrayList<Integer>();      // membuat list baru
        if(list1.size() < list2.size()){
            for(int i=0; i < list2.size(); i++){
                int temporary = list2.get(i);
                if(list1.contains(temporary)){          //jika nilai temporary terdapat pada list1 makan bernilai true dpt di eksekusi
                    list.add(temporary);                //data temporary dimasukan ke dalam list
            }
        }
    }
        if(list1.size()> list2.size() || list1.size() == list2.size()){
            for(int i=0; i < list1.size(); i++){
                int temporary = list1.get(i);
                if(list2.contains(temporary)){          //jika nilai temporary terdapat pada list2 makan bernilai true dpt di eksekusi
                    list.add(temporary);                //data temporary dimasukan ke dalam list
                }
            }
        }
        return list;                //me-return 
    }
}

/*
Data list pertama = [1, 2, 3, 4, 5, 6, 7, 8, 9]
Data list kedua = [11, 10, 9, 8, 7, 12, 13, 14, 1, 2]
Data list gabungan yang sama = [9, 8, 7, 1, 2] 
*/