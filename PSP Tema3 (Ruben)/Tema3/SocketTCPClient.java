package Tema3;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketTCPClient {
    private String serverIP;
    private int serverPort;
    private Socket socket;
    private InputStream is;
    private OutputStream os;

    public SocketTCPClient(String serverIP, int serverPort){
        this.serverIP = serverIP;
        this.serverPort = serverPort;
    }

    public void start() throws IOException {
        System.out.println("cliente estableciendo conexion...");
        socket = new Socket(serverIP, serverPort);
        os = socket.getOutputStream();
        is = socket.getInputStream();
        System.out.println("cliente conexion establecida");
    }

    public void stop() throws IOException {
        System.out.println("cliente cerrando conexion...");
        is.close();
        os.close();
        socket.close();
        System.out.println("Cliente conexiones cerradas");
    }

    public static void main(String[] args) {
        SocketTCPClient cliente = new SocketTCPClient("localhost", 49171);
        try {
            cliente.start();
            cliente.os.write(100);
            System.out.println("Mensaje del servidor: " + cliente.is.read());
            cliente.stop();
        }catch (UnknownHostException e){
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
