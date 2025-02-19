import java.security.MessageDigest;
import java.security.Provider;
import java.security.Security;
import java.util.Set;

public class VisualizadorAlgoritmosHash {
    public static void main(String[] args) {
        // Se define el tipo de algoritmo como MessageDigest
        final String TIPO_MESSAGE_DIGEST = MessageDigest.class.getSimpleName();

        // Se obtiene la lista de los proveedores de seguridad instalados
        Provider[] proveedores = Security.getProviders();

        for (Provider proveedor:proveedores){ // Por cada proveedor se obtiene el conjunto de servicios
            Set<Provider.Service> servicios = proveedor.getServices();
            for (Provider.Service servicio:servicios){
                if (servicio.getType().equals(TIPO_MESSAGE_DIGEST)){ // Se filtran los servicios por el tipo
                    System.out.println(servicio.getAlgorithm());
                }
            }
        }
    }
}