package Tema3;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class EjemploUno {
    public static void main(String[] args) {
        try {
            InetAddress direccion = InetAddress.getByName("www.elpais.es");
            System.out.println(direccion);
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }

    }
}
