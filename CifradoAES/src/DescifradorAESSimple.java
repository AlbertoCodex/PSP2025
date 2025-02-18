import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DescifradorAESSimple {
    public static void main(String[] args) {
        try {
            String password = "1234567890123456"; // Clave de 16 bytes
            SecretKeySpec clave = AESSimpleManager.obtenerClave(password);

            String textoCifrado = new String(Files.readAllBytes(Paths.get("texto_cifrado.txt")), StandardCharsets.UTF_8);
            String textoDescifrado = AESSimpleManager.descifrar(textoCifrado, clave);

            System.out.println("Texto descifrado: " + textoDescifrado);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
