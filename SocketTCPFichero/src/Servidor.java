import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    private ServerSocket serverSocket;
    private Socket socket;
    private BufferedReader br;
    private PrintWriter pw;

    public Servidor(int puerto) throws IOException {
        serverSocket = new ServerSocket(puerto);
    }
    // Establecer conexion
    public void start() throws IOException {
        System.out.println("Servidor esperando conexiones...");
        socket = serverSocket.accept();
        System.out.println("Servidor conexión establecida");
        abrirCanalesDeTexto();
    }
    public void stop() throws IOException {
        System.out.println("Servidor cerrando conexiones...");
        cerrarCanalesDeTexto();
        socket.close();
        serverSocket.close();
        System.out.println("Servidor conexiones cerradas");
    }
    // Establecer canales
    private void abrirCanalesDeTexto() throws IOException {
        System.out.println("Servidor abriendo canales de texto...");
        br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        pw = new PrintWriter(socket.getOutputStream(), true);
        System.out.println("Servidor canales de texto abiertos");
    }
    private void cerrarCanalesDeTexto() throws IOException {
        System.out.println("Servidor cerrando canales de texto...");
        br.close();
        pw.close();
        System.out.println("Canales de texto cerrados");
    }
    // Leer el fichero e imprimirlo por consola
    private void procesarSolicitud() throws IOException {
        String rutaArchivo = br.readLine();
        System.out.println("Solicitud recibida para: " + rutaArchivo);

        File archivo = new File(rutaArchivo);
        if (archivo.exists() && archivo.isFile()) {
            try (BufferedReader fileReader = new BufferedReader(new FileReader(archivo))) {
                String linea;
                while ((linea = fileReader.readLine()) != null) {
                    pw.println(linea);
                }
            }
        } else {
            pw.println("ERROR: El archivo no existe.");
        }
    }

    public static void main(String[] args) throws IOException {
        Servidor servidor = new Servidor(55555);
        servidor.start();
        servidor.procesarSolicitud();
        servidor.stop();
    }
}