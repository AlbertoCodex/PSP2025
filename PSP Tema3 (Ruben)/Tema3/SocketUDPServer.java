package Tema3;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class SocketUDPServer {


    public static void main(String[] args) {
        DatagramSocket socket;
        try{
            System.out.println("Servidor creando socket...");
            socket = new DatagramSocket(49171);
            System.out.println("servidor, recibieno datagrama");
            byte[] bufferLectura = new byte[182];
            DatagramPacket datagramEntrada = new DatagramPacket(bufferLectura, bufferLectura.length);
            socket.receive(datagramEntrada);
            System.out.println("servidor, mensaje recibido"+ new String(bufferLectura));
            System.out.println("servidor enviando datagrama...");
            byte[] mensajeEnviado = new String("Mensaje enviado desde el servidor mendiante UDP para el ejercicio UDP").getBytes();
            DatagramPacket datagramSalida= new DatagramPacket(mensajeEnviado,mensajeEnviado.length,datagramEntrada.getAddress(),datagramEntrada.getPort());

            socket.send(datagramSalida);
            System.out.println("servidor, cerrando socket...");
            socket.close();
            System.out.println("servidor, socket cerrado");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
