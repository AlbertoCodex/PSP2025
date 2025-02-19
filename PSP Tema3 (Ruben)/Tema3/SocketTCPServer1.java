package Tema3;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketTCPServer1 {
    private ServerSocket serverSocket;
    private Socket socket;
    private InputStream is;
    private OutputStream os;
    private InputStreamReader isr;
    private BufferedReader br;
    private PrintWriter pw;

    public SocketTCPServer1(int puerto) throws IOException {
        serverSocket = new ServerSocket(puerto);
    }

    public void start() throws IOException {
        System.out.println("servidor esperando conexiones...");
        socket=serverSocket.accept();
        is=socket.getInputStream();
        os=socket.getOutputStream();
        System.out.println("servidor conexion establecida");
    }

    public void stop() throws IOException{
        System.out.println("servidor cerrando conexiones...");
        is.close();
        os.close();
        socket.close();
        serverSocket.close();
        System.out.println("servidor conexiones cerradas");
    }

    public void abrirCanalesDeTexto(){
        System.out.println("servidor abriendo canales de texto....");
        isr=new InputStreamReader(is);
        br= new BufferedReader(isr);
        pw=new PrintWriter(os, true);
        System.out.println("servidor canales de textos abiertos");
    }

    public void cerrarCanalesDeTexto() throws IOException {
        System.out.println("servidor cerrando canales de texto...");
       isr.close();
       br.close();
       pw.close();
        System.out.println("Canales de textos cerrados");
    }

    public String leerMensajeTexto() throws IOException {
        System.out.println("Servidor Leyendo mensaje...");
        String mensaje = br.readLine();
        System.out.println("Servidor Mensaje leido");
        return mensaje;
    }

    public void enviarMensajeTexto(String mensaje){
        System.out.println("Servidor Enviando mensaje...");
        pw.println(mensaje);
        System.out.println("servidor mensaje enviado");
    }

    public static void main(String[] args) {
        try{
            SocketTCPServer1 servidor = new SocketTCPServer1(49171);
            servidor.start();
            servidor.abrirCanalesDeTexto();
            String mensajeRecibido = servidor.leerMensajeTexto();
            System.out.println("Servidor Mensaje recibido " + mensajeRecibido);
            servidor.enviarMensajeTexto("Mensaje enviado desde el servidor");
            servidor.cerrarCanalesDeTexto();
            servidor.stop();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
