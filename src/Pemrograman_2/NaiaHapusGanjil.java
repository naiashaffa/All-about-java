package Pemrograman_2;

import java.util.*;
public class NaiaHapusGanjil {
    public static void main(String [] args) {
        ArrayList<Integer> list = new ArrayList<Integer> ();
        System.out.print ("Data integer = ");
        System.out.println (integer(list));
        System.out.println();
        System.out.print("Data setelah bilangan ganjil di hapus = ");
        System.out.println(delGanjil (list));
    }
    public static ArrayList integer (ArrayList<Integer> list) {
        for (int i = 1; i <=10; i++)
            list.add(i);
        return list;
    }
    public static ArrayList delGanjil (ArrayList<Integer> list){
        for (int j= 0; j < list.size(); j++ ){
            if (list.get(j) % 2 != 0){
                list.remove(j);
                j--;
            }
        }
        return list;
    }
}

/*
Data integer = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

Data setelah bilangan ganjil di hapus = [2, 4, 6, 8, 10] 
*/