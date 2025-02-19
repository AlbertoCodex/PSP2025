package Tema3;

import java.io.*;
import java.net.Socket;

public class SocketTCPClient1 {
    private String serverIP;
    private int serverPort;
    private Socket socket;
    private InputStream is;
    private OutputStream os;
    private InputStreamReader isr;
    private BufferedReader br;
    private PrintWriter pw;

    public SocketTCPClient1(String serverIP, int serverPort){
        this.serverIP=serverIP;
        this.serverPort=serverPort;
    }
    public void start() throws IOException{
        System.out.println("cliente estableciendo conexion");
        socket = new Socket(serverIP, serverPort);
        os = socket.getOutputStream();
        is = socket.getInputStream();
        System.out.println("cliente conexion establecida");
    }
    public void stop() throws IOException{
        System.out.println("cliente cerrando conexiones");
        is.close();
        os.close();
        socket.close();
        System.out.println("cliente conexiones cerradas");
    }

    public void abrirCanalesDeTexto(){
        System.out.println("cliente abriendo canales de texto...");
        isr=new InputStreamReader(is);
        br= new BufferedReader(isr);
        pw=new PrintWriter(os, true);
        System.out.println("cliente canales de texto abiertos");
    }

    public void cerrarCanalesDeTexto() throws IOException {
        System.out.println("cliente cerrando canales de texto");
        isr.close();
        br.close();
        pw.close();
        System.out.println("cliente canales cerrados");
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
        SocketTCPClient1 cliente = new SocketTCPClient1("localhost", 49171);
        try{
            cliente.start();
            cliente.abrirCanalesDeTexto();
            cliente.enviarMensajeTexto("mensaje enviado desde el cliente");
            String mensajeRecibido = cliente.leerMensajeTexto();
            System.out.println("cliente mensaje recibido "+ mensajeRecibido);
            cliente.cerrarCanalesDeTexto();
            cliente.stop();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
