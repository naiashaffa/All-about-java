package Pemrograman_2;

import java.util.ArrayList;

public class NaiaAddStars {
    public static void main(String [] args) {
        ArrayList<String> list = new ArrayList<String>();

        list.add("the");
        list.add("quick");
        list.add("brown");
        list.add("fox");

        System.out.print("List awal : ");
        System.out.println(list);

        addStars(list);
        System.out.print("List setelah di add stars : ");
        System.out.print(list);

    }
    public static void addStars(ArrayList<String> list){
        for(int i = 0; i < list.size(); i +=2){
            list.add(i+1, "*");
        }
    }
}

/*List awal : [the, quick, brown, fox]
List setelah di add stars : [the, *, quick, *, brown, *, fox, *] */