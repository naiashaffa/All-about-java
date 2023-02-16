package Pemrograman_2;

import java.util.ArrayList;

public class NaiaAcronymFor {
    public static void main(String [] args){
        ArrayList<String> list = new ArrayList <String>();

        list.add("laughing");
        list.add("out");
        list.add("loud");

        System.out.print("List pertama : ");
        System.out.println(list);

        System.out.print("Acronym dari list : ");
        System.out.print(acronymFor(list));
    }
    public static String acronymFor(ArrayList<String> list){
        String set = "";
        for (String srg : list){
            set += srg.charAt(0);
        }
        return set.toUpperCase();
    }
}

/*List pertama : [laughing, out, loud]
Acronym dari list : LOL */