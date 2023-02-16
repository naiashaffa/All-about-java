package Pemrograman_2;

import java.util.*;
public class NaiaListInteger {
    public static void main(String [] args) {
        ArrayList<Integer> list = new ArrayList<Integer> ();
        System.out.println ("Data integer : ");
        System.out.println (integer(list));
    }
    public static ArrayList integer (ArrayList<Integer> list) {
        for (int i = 1; i <=10; i++)
            list.add(i);
        return list;
    }
}

/* 
Data integer : 
[1, 2, 3, 4, 5, 6, 7, 8, 9, 10] 
*/