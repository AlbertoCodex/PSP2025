
/**
 *
 * @author Alberto
 */

public class Main extends Thread {
    private String nombre;

    public Main(String nombre) {
        super();
        this.nombre = nombre;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("Soy " + nombre + " y estoy trabajando");
                Thread.sleep((int) (Math.random()*10000+1000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            Main hilo = new Main("Hilo " + i);
            hilo.start();
        }
    }
}