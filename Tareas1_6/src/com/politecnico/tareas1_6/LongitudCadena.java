package com.politecnico.tareas1_6;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;

/**
 *
 * @author alberto
 */

public class LongitudCadena {
    public static void main (String args[]) throws FileNotFoundException, IOException {
        File delFile = new File("cadenas.txt");
        BufferedReader br = new BufferedReader(new FileReader(delFile));
        String str1length = null;
        String str2length = null;
        int sumLength;
        
        for (int i = 0; i < 2; i++) {
            if (i == 0) {
                str1length = br.readLine();
                System.out.println("La longitud de la primera cadena es: " + str1length.length());
            } else {
                str2length = br.readLine();
                System.out.println("La longitud de la segunda cadena es: " + str2length.length());
            }
        }
        sumLength = str1length.length() + str2length.length();
        System.out.println("La suma de la longitud de las cadenas es: " + sumLength);
        delFile.delete();
    } 
}