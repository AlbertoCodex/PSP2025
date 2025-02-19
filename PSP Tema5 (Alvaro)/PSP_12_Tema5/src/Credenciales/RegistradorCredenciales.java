package Credenciales;

import java.io.File;
import java.math.BigInteger;
import java.nio.file.Files;
import java.util.Scanner;

public class RegistradorCredenciales {
    private static final String ENCODING_TYPE="UTF-8";

    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce identificador (email): ");
        String identificador = sc.nextLine();
        System.out.println("Introduce contraseña:");
        String password = sc.nextLine();

        try{
            byte[] resumen = HASHManager.getDigest(password.getBytes(ENCODING_TYPE));
            Files.write(new File(identificador + ".credencial").toPath(), resumen);
            mostrarResumenHexadecimal(resumen);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private static void mostrarResumenHexadecimal(byte[] resumen){
        String resumenHexadecimal = String.format("%64x", new BigInteger(1, resumen));
        System.out.println(resumenHexadecimal);
    }
}
