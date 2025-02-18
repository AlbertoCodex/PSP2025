import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CifradorAESSimple {
    public static void main(String[] args) {
        try {
            String password = "1234567890123456"; // Clave de 16 bytes
            SecretKeySpec clave = AESSimpleManager.obtenerClave(password);

            String texto = "ESTE ES EL TEXTO DEL DOCUMENTO";
            String textoCifrado = AESSimpleManager.cifrar(texto, clave);

            Files.write(Paths.get("texto_cifrado.txt"), textoCifrado.getBytes(StandardCharsets.UTF_8));
            System.out.println("Texto cifrado guardado en texto_cifrado.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
