package AES;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.security.Key;

public class DescifradorAESSimple {
    public static void main(String[] args) throws Exception {
        final int LONGITUD_BLOQUE = 16; // Expresado en bytes
        final String NOMBRE_FICHERO = "mensaje_cifrado.txt";
        // Si pongo MeLlamoSpiderman1 tambien lo acepta, al ser 16 bytes lo que ponga de más tambien...
        // 16 bytes son MeLlamoSpiderman, entonces si pongo algun caracter más lo acepta, ya que se corta en MeLlamoSpiderman y lo demas no se acep...
        final String PASSWORD = "MeLlamoSpiderman";

        File file = new File(NOMBRE_FICHERO);
        Key clave = AESSimpleManager.obtenerClave(PASSWORD, LONGITUD_BLOQUE);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String textoCIfrado = br.readLine();
        String textoEnClaro = AESSimpleManager.descifrar(textoCIfrado, clave);
        br.close();
        System.out.println("El texto descifrado es: " + textoEnClaro);
    }
}
