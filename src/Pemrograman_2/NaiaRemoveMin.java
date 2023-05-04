package Pemrograman_2;

// NAMA : NAIA SHAFFA CAMILA 
// NIM  : 22537144008
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class NaiaRemoveMin {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<Integer>();
        // data :
        s.push(2);
        s.push(8);
        s.push(3);
        s.push(19);
        s.push(2);
        s.push(3);
        s.push(2);
        s.push(7);
        s.push(12);
        s.push(-8);
        s.push(4);

        // output :
        System.out.println("Stack before removeMin: " + s);     // menampilkan stack awal
        int min = removeMin(s);
        System.out.println("Minimum value removed: " + min);    // menampilkan data min yg akan di hapus
        System.out.println("Stack after removeMin: " + s);      // menampilkan stack setelah data min di hapus
        System.out.println("");

        // tambahan 
        // untuk cek apakah tetap berhasil di hapus dg list baru setelahnya
        min = removeMin(s);
        System.out.println("Minimum value removed: " + min);
        System.out.println("Stack after removeMin: " + s);
        System.out.println("");
        min = removeMin(s);
        System.out.println("Minimum value removed: " + min);
        System.out.println("Stack after removeMin: " + s);
    }
    public static int removeMin(Stack<Integer> s) {
        Queue<Integer> q = new LinkedList<Integer>();
        int min = s.peek();     

        while(!s.isEmpty()) {
            int n = s.pop();

            if(n < min)
                min = n;

            q.add(n);
        }

        while(!q.isEmpty()) {
            int n = q.remove();

            if(n > min)
                s.push(n);
        }

        while(!s.isEmpty())
            q.add(s.pop());

        while(!q.isEmpty())
            s.push(q.remove());

        return min;     // me-return
    }
}

/*
 * Stack before removeMin: [2, 8, 3, 19, 2, 3, 2, 7, 12, -8, 4]
 * Minimum value removed: -8
 * 
 * Stack after removeMin: [2, 8, 3, 19, 2, 3, 2, 7, 12, 4]
 * Minimum value removed: 2
 * 
 * Stack after removeMin: [8, 3, 19, 3, 7, 12, 4]
 * Minimum value removed: 3
 * Stack after removeMin: [8, 19, 7, 12, 4]
 */
        