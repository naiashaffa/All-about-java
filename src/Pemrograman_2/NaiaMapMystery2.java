package Pemrograman_2;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class NaiaMapMystery2 {
    public static void main(String []args){
        Set<String> si = new HashSet<String>();

        si.add("sheep=wool");
        si.add("house=brick");
        si.add("cast=plaster");
        si.add("wool=wool");

        System.out.print("List awal : ");
        System.out.println(si);

        mapMystery2(m);
        System.out.print("List hasil : ");

    }
    public static void mapMystery2(Map<String, String> m) {
        Set<String> si = new TreeSet<String>();
        for (String key : m.keySet()) {
            if (!m.get(key).equals(key)) {
                si.add(m.get(key));
            } else {
                si.remove(m.get(key));
            }
        }
        System.out.println(si);
    }
}
