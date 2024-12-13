package ies.politecnico.examen;

import java.util.concurrent.Semaphore;

public class Taller implements Runnable{
    Semaphore semaforo = new Semaphore(1);

    public static void main(String[] args) {
        Taller taller = new Taller();
        for (int i=0; i < 5; i++) {
            new Thread(taller).start();
        }
    }

    // Creo el vehiculo con el estado random (1-10)
    // que luego voy a usar para comprobar si da tiempo a repararlo

    @Override
    public void run() {
        try {
            semaforo.acquire();
            Vehiculo vehiculo = new Vehiculo((int) (Math.random() * 10) +1, "1234 ABC", "Mercedes", "CLA 45");
            this.reparar(vehiculo);
            semaforo.release();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void reparar(Vehiculo vehiculo) throws InterruptedException {
        int tiempoReparacion = 5;
        System.out.println("Se está empezando a reparar el vehículo");
        Thread.sleep(5000);
        if (vehiculo.getEstado() < 2) {
            System.out.println("El estado del vehículo es bueno");
        } else if(vehiculo.getEstado() < 4) {
            System.out.println("El estado del vehículo es regular");
        } else {
            System.out.println("El estado del vehículo es malo");
        }
    }
}