package ies.politecnico.examen;

public class Embarque implements Runnable{
    private int id;
    public Embarque(int id) {
        super();
        this.id = id;
    }
    public static void main(String[] args) {
        Embarque pasajero;
        for (int i = 0; i < 5; i++) {
            pasajero = new Embarque(i);
            new Thread(pasajero).start();
        }
    }

    @Override
    public void run() {
        revision();
    }

    public synchronized void revision() {
       try {
           int num = (int) (Math.random() * 2) +1;
           if (num == 1) {
               System.out.println("La azafata 1 revisando el pasaporte del pasajero " + this.id);
           } else {
               System.out.println("La azafata 2 revisando el pasaporte del pasajero " + this.id);
           }
           Thread.sleep(3000);
        }catch (InterruptedException e){
            return;
        }
        System.out.println("Se ha revisado correctamente");
    }
}
