package Tema3;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketTCPServer {
    private ServerSocket serverSocket;
    private Socket socket;
    private InputStream is;
    private OutputStream os;

    public SocketTCPServer (int puerto) throws IOException{
        serverSocket = new ServerSocket(puerto);
    }

    public void start() throws IOException{
        System.out.println("Servidor, Esperando conexiones");
        socket = serverSocket.accept();
        is = socket.getInputStream();
        os = socket.getOutputStream();
        System.out.println("Servidor, conexion establecida.");
    }

    public void stop() throws IOException {
        System.out.println("Servidor cerrando conexiones...");
        is.close();
        os.close();
        socket.close();
        serverSocket.close();
        System.out.println("servidor conexiones cerradas");
    }

    public static void main(String[] args) {
        try{
            SocketTCPServer servidor = new SocketTCPServer(49171);
            servidor.start();
            System.out.println("Mensaje del cliente: " +  servidor.is.read());
            servidor.os.write(200);
            servidor.stop();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
