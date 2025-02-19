package Tema3;

import java.io.IOException;
import java.net.*;

public class SocketUDPClient {

    public static void main(String[] args) {

        String strMensaje = "Mensaje enviado desde el cliente utilizando UDP para el ejercicio UDP";
        DatagramSocket socketUDP;
        try{
            System.out.println("Cliente, Estableciendo parámetros de conexión...");
            InetAddress hostServidor = InetAddress.getByName("localhost");
            int puertoServidor = 49171;
            System.out.println("Cliente, creando socket....");
            socketUDP = new DatagramSocket();
            System.out.println("cliente, Enviando datagrama...");
            byte[] mensaje = strMensaje.getBytes();
            DatagramPacket peticion = new DatagramPacket(mensaje, mensaje.length, hostServidor, puertoServidor);
            socketUDP.send(peticion);
            System.out.println("cliente, recibiendo datagrama...");
            byte[] buffer = new byte[128];
            DatagramPacket respuesta = new DatagramPacket(buffer, buffer.length, hostServidor, puertoServidor);
            socketUDP.receive(respuesta);
            System.out.println("cliente, mensaje recibido: " + new String(buffer));
            System.out.println("cliente, cerrando socket");
            socketUDP.close();
            System.out.println("cliente, socket cerrado");
        }catch (SocketException e){
            e.printStackTrace();
        }catch (UnknownHostException e){
            e.printStackTrace();
        }catch (IOException e ){
            e.printStackTrace();
        }
    }
}
