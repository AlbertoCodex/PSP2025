import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Cliente {
    private static final int port = 55555;
    private static final String ip = "127.0.0.1";

    public static void main(String[] args) {
        int i = 0;
        String text;
        byte[] sendData;
        DatagramPacket sendPacket;
        try {
            // Crear un socket UDP
            System.out.println("Estableciendo conexion");
            DatagramSocket clientSocket = new DatagramSocket();
            // Convertir la dirección IP del servidor a un objeto InetAddress
            InetAddress serverIP = InetAddress.getByName(ip);

            // Enviar 10000 mensajes
            System.out.println("Enviando mensajes...");
            while (i < 9999) {
                text = "Mensaje: " + i;
                sendData = text.getBytes();
                // Crear un paquete con los datos y la dirección del servidor
                sendPacket = new DatagramPacket(sendData, sendData.length, serverIP, port);
                // Enviar el paquete al servidor
                clientSocket.send(sendPacket);
                i++;
            }
            // Cuando ha enviado todos los numeros manda "FIN"
            if (i == 9999) {
                text = "FIN";
                sendData = text.getBytes();
                // Crear un paquete con los datos y la dirección del servidor
                sendPacket = new DatagramPacket(sendData, sendData.length, serverIP, port);
                // Enviar el paquete al servidor
                clientSocket.send(sendPacket);
                System.out.println("Se han enviado todos los paquetes.");
            }
            // Cerrar el socket del cliente
            System.out.println("Cerrando conexion");
            clientSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}