import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

class AESSimpleManager {
    private static final String ALGORITHM = "AES";

    public static SecretKeySpec obtenerClave(String password) throws Exception {
        byte[] key = password.getBytes(StandardCharsets.UTF_8);
        if (key.length != 16) {
            throw new IllegalArgumentException("La clave debe tener exactamente 16 bytes.");
        }
        return new SecretKeySpec(key, ALGORITHM);
    }

    public static String cifrar(String texto, SecretKeySpec clave) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, clave);
        byte[] textoCifrado = cipher.doFinal(texto.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(textoCifrado);
    }

    public static String descifrar(String textoCifrado, SecretKeySpec clave) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, clave);
        byte[] textoDescifrado = cipher.doFinal(Base64.getDecoder().decode(textoCifrado));
        return new String(textoDescifrado, StandardCharsets.UTF_8);
    }
}