package Pemrograman_2;
import java.util.ArrayList;

/* 
Nama : Naia Shaffa Camila
NIM  : 22537144008
*/
public class NaiaSwitchPairs {
    public static void main(String [] args){
        ArrayList<String>list = new ArrayList<String>();

        list.add("Talk");
        list.add("Song");
        list.add("Can");
        list.add("Be");
        list.add("Life");
        list.add("Control");

        System.out.print("List awal : ");
        System.out.println(list);

        switchPairs(list);
        System.out.print("List hasil setelah dibalik: ");
        System.out.print(list);

    }
    public static ArrayList<String> switchPairs (ArrayList<String>list){
        for(int i = 0; i <= list.size()-2; i+=2){
            String s = list.get(i+1);
            list.set(i+1, list.get(i));
            list.set(i,s);
        }
        return list;
    }
}

/*
List awal : [Talk, Song, Can, Be, Life, Control]
List hasil setelah dibalik: [Song, Talk, Be, Can, Control, Life] 
*/