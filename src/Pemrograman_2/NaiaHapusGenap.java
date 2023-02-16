package Pemrograman_2;

import java.util.*;
public class NaiaHapusGenap {
    public static void main(String [] args) {
        ArrayList<Integer> list = new ArrayList<Integer> ();
        System.out.print ("Data integer = ");
        System.out.println (integer(list));
        System.out.println();
        System.out.print("Data setelah bilangan genap di hapus = ");
        System.out.println(delGenap (list));
    }
    public static ArrayList integer (ArrayList<Integer> list) {
        for (int i = 1; i <=10; i++)
            list.add(i);
        return list;
    }
    public static ArrayList delGenap (ArrayList<Integer> list){
        for (int j= 0; j < list.size(); j++ ){
            if (list.get(j) % 2 == 0){
                list.remove(j);
                j--;
            }
        }
        return list;
    }
}

/*
Data integer = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

Data setelah bilangan genap di hapus = [1, 3, 5, 7, 9]
*/