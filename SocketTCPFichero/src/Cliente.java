import java.io.*;
import java.net.Socket;

public class Cliente {
    private String serverIP;
    private int serverPort;
    private Socket socket;
    private BufferedReader br;
    private PrintWriter pw;

    public Cliente(String serverIP, int serverPort) {
        this.serverIP = serverIP;
        this.serverPort = serverPort;
    }

    public void start() throws IOException {
        System.out.println("Cliente estableciendo conexión");
        socket = new Socket(serverIP, serverPort);
        System.out.println("Cliente conexión establecida");
        abrirCanalesDeTexto();
    }

    public void stop() throws IOException {
        System.out.println("Cliente cerrando conexiones");
        cerrarCanalesDeTexto();
        socket.close();
        System.out.println("Cliente conexiones cerradas");
    }

    private void abrirCanalesDeTexto() throws IOException {
        System.out.println("Cliente abriendo canales de texto...");
        br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        pw = new PrintWriter(socket.getOutputStream(), true);
        System.out.println("Cliente canales de texto abiertos");
    }

    private void cerrarCanalesDeTexto() throws IOException {
        System.out.println("Cliente cerrando canales de texto...");
        br.close();
        pw.close();
        System.out.println("Cliente canales cerrados");
    }

    private String leerMensajeTexto() throws IOException {
        System.out.println("Cliente leyendo mensaje...");
        return br.readLine();
    }

    private void enviarMensajeTexto(String mensaje) {
        System.out.println("Cliente enviando mensaje...");
        pw.println(mensaje);
        System.out.println("Cliente mensaje enviado");
    }

    private void solicitarArchivo(String rutaArchivo) throws IOException {
        enviarMensajeTexto(rutaArchivo);
        System.out.println("Contenido del archivo:");
        String linea;
        while ((linea = leerMensajeTexto()) != null) {
            System.out.println(linea);
        }
    }

    public static void main(String[] args) {
        Cliente cliente = new Cliente("localhost", 55555);
        try {
            cliente.start();
            BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Ingrese la ruta del archivo en el servidor: ");
            String rutaArchivo = teclado.readLine();
            cliente.solicitarArchivo(rutaArchivo);
            cliente.stop();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
