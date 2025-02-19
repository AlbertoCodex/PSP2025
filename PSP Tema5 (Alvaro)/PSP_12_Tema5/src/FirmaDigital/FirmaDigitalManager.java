package FirmaDigital;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.Signature;

public class FirmaDigitalManager {
    private static String MENSAJE_ORIGINAL = "El número premiado es el 23";
    private static String MENSAJE_MODIFICADO = "El número premiado es el 32";

    public static void main(String[] args) {
        try{
            Signature signature = Signature.getInstance("DSA");
            signature.initSign(ClavesManagerFirmaDigital.getClavePrivada());
            signature.update(MENSAJE_ORIGINAL.getBytes());
            byte[] firma = signature.sign();

            signature.initVerify(ClavesManagerFirmaDigital.getClavePublica());
            signature.update(MENSAJE_MODIFICADO.getBytes());

            if (signature.verify(firma))
                System.out.println("Mensaje verificado");
            else
                System.err.println("Atención: el mensaje no es fiable");
        } catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
