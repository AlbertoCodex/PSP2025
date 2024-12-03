package com.politecnico.tareas1_6;

/**
 *
 * @author alberto
 */

public class Media {
    public static void main (String args[]) {
        int n = 10;
        int result = 0;
        for (int i = 0; i <= n; i++) {
            result += i;
        }
        result = result / n;
        System.out.println("La media de los " + n + " primeros enteros es: " + result);
    }
}