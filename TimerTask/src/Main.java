import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Alberto
 */

public class Main extends TimerTask{
    @Override
    public void run() {
        System.out.println("Aviso: Es momento de andar durante 5 minutos.");
    }

    public static void main(String[] args) {
        Timer temporizador = new Timer();
        temporizador.schedule(new Main(), 1000, 1800000);
    }
}