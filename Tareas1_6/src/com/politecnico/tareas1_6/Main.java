package com.politecnico.tareas1_6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *
 * @author alberto
 */

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        menu();
    }
    public static void menu() throws IOException, InterruptedException {
        Scanner sc = new Scanner(System.in);
        String[] cmdArray = new String[2];
        Process proceso = null;
        BufferedReader stdInput = null;
        int x = -1;

        while (x != 0) {
            cmdArray[0] = "java";
            menuStrings(); // Crear opciones | 0 para salir, 1 para ejercicio1 ...
            x = sc.nextInt();

            switch (x) {
                case 1:
                    // Llamada a Media.Java
                    System.out.println("Ejercicio 1");
                    cmdArray[1] = "Media.java";
                    String line;
                    proceso = Runtime.getRuntime().exec(cmdArray);
                    stdInput = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
                    
                    checkProcess(proceso, stdInput);
                    while ((line = stdInput.readLine()) != null) { 
                        System.err.println(line);
                    }
                    break;
                case 2:
                    // Llamada a RandomNotepad.Java
                    System.out.println("Ejercicio 2");
                    cmdArray[1] = "RandomNotepad.java";
                    String[] notepad = {"Notepad.exe", "new"};
                    proceso = Runtime.getRuntime().exec(cmdArray);
                    stdInput = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
                    checkProcess(proceso, stdInput);
                    int n = Integer.parseInt(stdInput.readLine());
                    
                    System.out.println("Se va a ejecutar el Notepad " + n + " veces");
                    for (int i = 1; i <= n; i++) { 
                        notepad[1] = "new"+i;
                        Runtime.getRuntime().exec(notepad);
                    }
                    break;
                case 3:
                    // Llamada a ExecutorMensajes.Java
                    System.out.println("Ejercicio 3");
                    cmdArray[1] = "ExecutorMensajes.java";
                    String executorLines;
                    proceso = Runtime.getRuntime().exec(cmdArray);
                    stdInput = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
                    
                    checkProcess(proceso, stdInput);
                    while ((executorLines = stdInput.readLine()) != null) {
                        System.err.println(executorLines);
                    }
                    break;
                case 4:
                    // Llamada a LongitudCadena.Java || Crea un archivo para escribir/leer los strings y luego lo borra
                    System.out.println("Ejercicio 4");
                    line = "";
                    cmdArray[1] = "LongitudCadena.java";
                    String str1 = "String 1";
                    String str2 = "String 2";
                    FileWriter fw = new FileWriter("cadenas.txt", false);
                    BufferedWriter stdOutput = new BufferedWriter(fw);
                    stdOutput.write(str1);
                    stdOutput.newLine();
                    stdOutput.write(str2);
                    stdOutput.close();
                    proceso = Runtime.getRuntime().exec(cmdArray);
                    stdInput = new BufferedReader(new InputStreamReader(proceso.getInputStream()));

                    checkProcess(proceso, stdInput);
                    while ((line = stdInput.readLine()) != null) { 
                        System.err.println(line);
                    }
                    break;
                case 5:
                    System.out.println("Ejercicio 5");
                    String[] notas = {"Notepad.exe", "new"};
                    proceso = Runtime.getRuntime().exec(notas);
                    stdInput = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
                    
                    System.out.println("Se ha ejecutado un bloc de notas");
                    checkProcess(proceso, stdInput);
                    Runtime.getRuntime().exec("taskkill /F /IM notepad.exe");
                    proceso.destroy();
                    System.out.println("Se ha cerrado el bloc de notas");
                    break;
                case 6:
                    // Llamada a Jugadores.py || Esta vez usando python3 !!!
                    System.out.println("Ejercicio 6");
                    line = "";
                    cmdArray[0] = "python3";
                    cmdArray[1] = "Jugadores.py";
                    proceso = Runtime.getRuntime().exec(cmdArray);
                    stdInput = new BufferedReader(new InputStreamReader(proceso.getInputStream()));

                    checkProcess(proceso, stdInput);
                    while ((line = stdInput.readLine()) != null) { 
                        System.err.println(line);
                    }
                    break;
            }
        }
    }
// Index de los ejercicios
    public static void menuStrings() {
        System.out.println("0 para salir" + '\n'
                + "1 para Ejercicio 1" + '\n'
                + "2 para Ejercicio 2" + '\n'
                + "3 para Ejercicio 3" + '\n'
                + "4 para Ejercicio 4" + '\n'
                + "5 para Ejercicio 5" + '\n'
                + "6 para Ejercicio 6");
    }
// Comprueba si ha terminado correctamente
    public static void checkProcess(Process proceso, BufferedReader stdInput) throws InterruptedException, IOException {
        int valorRetorno = proceso.waitFor();
        if (valorRetorno == 0) {
            System.out.println("Proceso completado, su salida fue: ");
        } else {
            System.out.println("Proceso fallado. Código error: " + valorRetorno);
            System.out.println("Se produjo un error, la salida fue: " + stdInput.readLine());
        }
    }
}