import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    public StringBuilder getContenidoMetodoGet(String direccion) throws Exception {
        StringBuilder respuesta = new StringBuilder();
        URL url=new URL(direccion);
        HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
        conexion.setRequestMethod("GET");
        conexion.setRequestProperty("Content-Type", "text/plain");
        conexion.setRequestProperty("charset", "utf-8");
        conexion.setRequestProperty("User-Agent","Mozilla/5.0");
        int estado = conexion.getResponseCode();
        Reader streamReader;
        if (estado == HttpURLConnection.HTTP_OK){
            streamReader = new InputStreamReader(conexion.getInputStream());
            int caracter;
            caracter = streamReader.read();
            while (caracter!=-1){
                respuesta.append((char)caracter);
                caracter = streamReader.read();
            }
        }else{
            throw new Exception("Error HTTP"+estado);
        }
        conexion.disconnect();
        return respuesta;
    }

    public static void writeFile(String strPath, String contenido) throws IOException {
        Path path = Paths.get(strPath);
        byte[] strToBytes=contenido.getBytes();
        Files.write(path, strToBytes);
    }

    public static void main(String[] args){
        try{
            String esquema ="https://";
            String servidor ="dle.rae.es/";
            String recurso= URLEncoder.encode("katana", StandardCharsets.UTF_8.name());
            Main gp = new Main();
            String direccion = esquema+servidor+recurso;
            StringBuilder resultado=gp.getContenidoMetodoGet(direccion);
            Main.writeFile("C:\\Users\\Alberto\\Downloads\\katana.html", resultado.toString());
            System.out.println("descarga finalizada");
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}