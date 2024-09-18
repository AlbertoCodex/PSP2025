public class Aparcamiento {
    private int id_aparcamiento;
    private int metros;
    private boolean ocupada;
    private String pasaporte_ciudadano;

    public Aparcamiento(int aparcamiento, int metros, boolean ocupada, String pasaporte_ciudadano) {
        this.id_aparcamiento = aparcamiento;
        this.metros = metros;
        this.ocupada = ocupada;
        this.pasaporte_ciudadano = pasaporte_ciudadano;
    }

    public int getId_aparcamiento() {
        return id_aparcamiento;
    }

    public void setId_aparcamiento(int id_aparcamiento) {
        this.id_aparcamiento = id_aparcamiento;
    }

    public int getMetros() {
        return metros;
    }

    public void setMetros(int metros) {
        this.metros = metros;
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
        return "Aparcamiento{" +
                "id_aparcamiento=" + id_aparcamiento +
                ", metros=" + metros +
                ", ocupada=" + ocupada +
                ", pasaporte_ciudadano='" + pasaporte_ciudadano + '\'' +
                '}';
    }
}
