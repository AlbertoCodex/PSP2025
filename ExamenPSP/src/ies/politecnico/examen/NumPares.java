package ies.politecnico.examen;

public class NumPares {
    public static void main(String[] args) {
        int contPar = 0;
        int contImpar = 0;
        int[] numeros = {3,5,8};
z
        // ** LEER EL ARRAY DE ARGS Y PARSEARLO A INT**
        // int[] numeros = args[0];

        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] % 2 == 0) {
                System.out.println("El número " + numeros[i] + " es par");
                contPar++;
            } else {
                System.out.println("El número " + numeros[i] + " es impar");
                contImpar++;
            }
        }
        System.out.println("Hay un total de " + contPar + " números pares");
        System.out.println("Hay un total de " + contImpar + " números impares");

    }
}
