package ies.politecnico.examen;

public class Vehiculo {
    private int estado;
    private String matricula;
    private String marca;
    private String modelo;

    public Vehiculo(int estado, String matricula, String marca, String modelo) {
        this.estado = estado;
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
}
