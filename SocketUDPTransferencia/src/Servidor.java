import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Servidor {
    private static final int port = 55555;

    public static void main(String[] args) {
        try {
            // Crear un socket UDP
            DatagramSocket serverSocket = new DatagramSocket(port);
            System.out.println("Servidor escuchando...");

            // Escuchando conexiones
            while (true) {
                // Crear un buffer para recibir los datos del cliente
                byte[] receiveData = new byte[1024];
                // Crear un paquete para almacenar los datos recibidos del cliente
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                // Recibir los datos del cliente
                serverSocket.receive(receivePacket);
                // Convertir los datos recibidos a String y mostrarlos
                String text = new String(receivePacket.getData());
                System.out.println("Recibido del cliente: " + text.trim());
                if (text.trim().equals("FIN")) {
                    serverSocket.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}