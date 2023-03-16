package Pemrograman_2;

import java.util.*;
// Naia Shaffa Camila
// 22537144008

public class NaiaCh12WriteChars {
    public static void main(String []args) {
        Scanner console = new Scanner(System.in);
        System.out.print("Input : ");
        int all = console.nextInt();
        System.out.print("Output : ");
        writeChars(all);

    } 
    public static void writeChars (int n ) {
        if (n < 1){
            throw new IllegalArgumentException();
        } else if (n == 1) {
            System.out.print("*");
        } else if (n == 2) {
            System.out.print("**");
        } else {
            System.out.print("<");
            writeChars(n - 2);
            System.out.print(">");
        }
    } 
}

/* 
Input : 0
Output : Exception in thread "main" java.lang.IllegalArgumentException 

Input : 4
Output : <**>
*/