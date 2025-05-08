package com.edisa.formacion.mayo2025EjersDia1;


/*1.- Crea un programa en java que se ejecutará desde línea de comandos y recibirá como argumentos el ancho y alto de un cuadrado.
El programa debe mostrar en pantalla el área del cuadrado. Si alguno de los argumentos viene vacío,
deberá lanzar una excepción indicando cuál de ellos viene vacío y un ejemplo de invocación al programa pasándole esos parámetros.
Si alguno de los parámetros es un número no válido, deberá lanzar una excepción indicando cuál de los parámetros es incorrecto
(se entiende que son valores válidos cualquier número decimal del 0 en adelante)
*/
public class Ejer1_parte1 {
    public static void main(String[] args) {

        try {
            if (args.length < 2) {
                System.out.println("Faltan argumentos. (ancho - largo)");
                return;
            }

            String anchoStr = args[0];
            String largoStr = args[1];

            if(anchoStr.isEmpty()) {
                throw new IllegalArgumentException("El argumento 'ancho' esta vacio");
            }

            if (largoStr.isEmpty()) {
                throw new IllegalArgumentException("El argumento 'largo' esta vacio");
            }

            double ancho;
            double largo;

            try {
                ancho = Double.parseDouble(anchoStr);
                if (ancho < 0) {
                    throw new IllegalArgumentException(("El argumento ANCHO debe ser mayor o igual a 0"));
                }

            }catch (NumberFormatException e) {
                throw new IllegalArgumentException("El argumento 'ancho' no es un número válido");
            }

            try {
                largo = Double.parseDouble(largoStr);
                if (largo < 0) {
                    throw new IllegalArgumentException("El argumento LARGO debe ser mayor o igual a 0");
                }
            }catch (NumberFormatException e) {
                throw new IllegalArgumentException("El argumento LARGO no es un número válido");
            }

            double area = ancho * largo;

            System.out.println("El area del cuadrado es: " + area);

        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}