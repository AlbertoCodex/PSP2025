public class Habitacion {
    private int id_habitacion;
    private int numero;
    private boolean cocina;
    private int baño;
    private boolean salon;
    private boolean ocupada;
    private String pasaporte_ciudadano;

    public Habitacion(int id_habitacion, int numero, boolean cocina, int baño, boolean salon, boolean ocupada, String pasaporte_ciudadano) {
        this.id_habitacion = id_habitacion;
        this.numero = numero;
        this.cocina = cocina;
        this.baño = baño;
        this.salon = salon;
        this.ocupada = ocupada;
        this.pasaporte_ciudadano = pasaporte_ciudadano;
    }
    public int getId_habitacion() {
        return id_habitacion;
    }

    public void setId_habitacion(int id_habitacion) {
        this.id_habitacion = id_habitacion;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public boolean isCocina() {
        return cocina;
    }

    public void setCocina(boolean cocina) {
        this.cocina = cocina;
    }

    public int getBaño() {
        return baño;
    }

    public void setBaño(int baño) {
        this.baño = baño;
    }

    public boolean isSalon() {
        return salon;
    }

    public void setSalon(boolean salon) {
        this.salon = salon;
    }

    public boolean isOcupada() {
        return ocupada;
    }

    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }

    public String getPasaporte_ciudadano() {
        return pasaporte_ciudadano;
    }

    public void setPasaporte_ciudadano(String pasaporte_ciudadano) {
        this.pasaporte_ciudadano = pasaporte_ciudadano;
    }

    @Override
    public String toString() {
        return "Habitacion{" +
                "id_habitacion=" + id_habitacion +
                ", numero=" + numero +
                ", cocina=" + cocina +
                ", baño=" + baño +
                ", salon=" + salon +
                ", ocupada=" + ocupada +
                ", pasaporte_ciudadano='" + pasaporte_ciudadano + '\'' +
                '}';
    }
}
