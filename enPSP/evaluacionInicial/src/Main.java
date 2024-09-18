import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Habitacion> habitaciones = new ArrayList<>();
        ArrayList<Aparcamiento> aparcamientos = new ArrayList<>();

        // Generar 5 habitaciones ocupadas y 3 libres
        generarHabitaciones(habitaciones);
        // Generamos 2 aparcamientos
        generarAparcamiento(aparcamientos);
        // 2 aparcamientos asignados a algun viajero
        asignarAparcamiento(habitaciones, aparcamientos);
        // Imprimir habitaciones y aparcamientos
        for (Habitacion ha : habitaciones) {
            System.out.println(ha.toString());
        }
        for (Aparcamiento ap : aparcamientos) {
            System.out.println(ap.toString());
        }

    }
    public static void generarHabitaciones(ArrayList<Habitacion> habitaciones) {
        Habitacion h1 = new Habitacion(1,1,true,1,true, true, "123456789A");
        habitaciones.add(h1);
        Habitacion h2 = new Habitacion(2,2,true,1,true, true, "123456789B");
        habitaciones.add(h2);
        Habitacion h3 = new Habitacion(3,3,true,1,true, true, "123456789C");
        habitaciones.add(h3);
        Habitacion h4 = new Habitacion(4,4,true,1,true, true, "123456789D");
        habitaciones.add(h4);
        Habitacion h5 = new Habitacion(5,5,true,1,true, true, "123456789E");
        habitaciones.add(h5);

        Habitacion h6 = new Habitacion(6,6,true,1,true, false, "123456789F");
        habitaciones.add(h6);
        Habitacion h7 = new Habitacion(7,7,true,1,true, false, "123456789G");
        habitaciones.add(h7);
        Habitacion h8 = new Habitacion(8,8,true,1,true, false, "123456789H");
        habitaciones.add(h8);
    }

    public static void generarAparcamiento(ArrayList<Aparcamiento> aparcamientos) {
        Aparcamiento a1 = new Aparcamiento(1, 15, true, "");
        aparcamientos.add(a1);
        Aparcamiento a2 = new Aparcamiento(2, 15, true, "");
        aparcamientos.add(a2);
    }

    public static void asignarAparcamiento(ArrayList<Habitacion> habitaciones, ArrayList<Aparcamiento> aparcamientos) {
        String ap1 = habitaciones.get(0).getPasaporte_ciudadano();
        aparcamientos.get(0).setPasaporte_ciudadano(ap1);

        String ap2 = habitaciones.get(1).getPasaporte_ciudadano();
        aparcamientos.get(1).setPasaporte_ciudadano(ap2);
    }

}