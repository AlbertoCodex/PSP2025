package ies.politecnico.examen;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {
    private static String[] cmdArray;
    private static BufferedReader stdInput = null;
    public static void main(String[] args) throws IOException {
        ejercicio1();
    }

    public static void ejercicio1() throws IOException {
        System.out.println("Ejecutando punto 1 del examen:");
        cmdArray = new String[3];
        int[] numeros = {3,5,8};
        cmdArray[0] = "java";
        cmdArray[1] = "NumPares.java";
        cmdArray[2] = Arrays.toString(numeros);
        String line = "";

        Process proceso = Runtime.getRuntime().exec(cmdArray);
        stdInput = new BufferedReader(new InputStreamReader(proceso.getInputStream()));

        while ((line = stdInput.readLine()) != null) {
            System.err.println(line);
        }
    }
}