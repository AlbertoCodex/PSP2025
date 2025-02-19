package Tema3;

import java.io.*;
import java.net.Socket;
import java.time.chrono.MinguoChronology;

public class SocketTCPClientMultihilo {

    private String serverIP;
    private int serverPort;
    private Socket socket;
    private InputStream is;


    public SocketTCPClientMultihilo(String serverIP, int serverPort){
        this.serverIP=serverIP;
        this.serverPort=serverPort;
    }

    public void start() throws IOException{
        System.out.println("Cliente estableciendo conexion...");
        socket=new Socket(serverIP, serverPort);
        is= socket.getInputStream();
        System.out.println("Cliente conexión establecida");
    }

    public void stop() throws IOException {
        System.out.println("cliente cerrando conexion...");
        is.close();
        socket.close();
        System.out.println("Cliente conexiones cerradas");
    }


    public static void main(String[] args) {
        SocketTCPClientMultihilo cliente = new SocketTCPClientMultihilo("localhost", 49171);
        try{
            cliente.start();
            System.out.println("Mensaje del servidor" + cliente.is.read());
            cliente.stop();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}

