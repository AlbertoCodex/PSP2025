package Tema3;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketTCPServerMultihilo {
    private ServerSocket serverSocket;

    public SocketTCPServerMultihilo(int puerto) throws IOException{
        serverSocket = new ServerSocket(puerto);

        while (true){
            Socket socket = serverSocket.accept();
            System.out.println("Servidor, conexión establecida");
            new GestorProcesos(socket).start();
        }
    }

    public void stop() throws IOException{
        serverSocket.close();
    }

    public static void main(String[] args) {
        try{
            SocketTCPServerMultihilo servidor = new SocketTCPServerMultihilo(49171);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
