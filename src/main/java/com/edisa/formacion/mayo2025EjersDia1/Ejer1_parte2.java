package com.edisa.formacion.mayo2025EjersDia1;


/*2.- Modifica el programa anterior para que, reciba como primer argumento una figura (valores posibles rectángulo o círculo).
Si el primer argumento es “circulo”, deberá recibir un argumento más con la longitud del radio del círculo. Si el primer argumento es “rectángulo”,
deberá recibir dos argumentos más con el ancho y el alto del rectángulo. Según los argumentos indicados,
deberá mostrar el área de la figura que haya indicado el usuario.*/
public class Ejer1_parte2 {

    public static void main(String[] args){

        try {
            if (args.length < 1) {
                throw new IllegalArgumentException("Falta el tipo de figura");
            }

            String figura = args[0];

            if(figura.equalsIgnoreCase("circulo")){
                if(args.length != 2){
                    throw new IllegalArgumentException("Para el circulo, se debe pasar el radio como argumento");
                }

                String radioStr = args[1];

                if(radioStr.isEmpty()){
                    throw new IllegalArgumentException("El argumento RADIO esta vacio");
                }

                double radio;

                try{
                    radio = Double.parseDouble(radioStr);
                    if(radio < 0){
                        throw new IllegalArgumentException("El argumento radio debe ser mayor o igual a 0");
                    }
                }catch (NumberFormatException e) {
                    throw new IllegalArgumentException("El argumento 'radio' no es un número válido. Ejemplo de uso: java Main circulo 5.0");
                }

                double areaCirculo = Math.PI * Math.pow(radio, 2);
                System.out.println("El area del circulo es: " + areaCirculo);
            }
            else if(figura.equalsIgnoreCase("rectangulo")){
                if(args.length != 3){
                    throw new IllegalArgumentException("Para el rectangulo se debe pasar ancho y el largo como argumentos");
                }

                String anchoStr = args[1];
                String largoStr = args[2];

                if(anchoStr.isEmpty()) {
                    throw new IllegalArgumentException("El argumento ancho esta vacio");
                }

                if(largoStr.isEmpty()) {
                    throw new IllegalArgumentException("El argumeto largo esta vacio");
                }

                double ancho;
                double largo;

                try{
                    ancho = Double.parseDouble(anchoStr);
                    if(ancho < 0){
                        throw new IllegalArgumentException("El argumento 'ancho' debe ser mayor o igual a 0");
                    }
                }catch (NumberFormatException e) {
                    throw new IllegalArgumentException("El argumento 'ancho' no es un número válido");
                }

                try{
                    largo = Double.parseDouble(largoStr);
                    if (largo < 0) {
                        throw new IllegalArgumentException("El argumento 'alto' debe ser mayor o igual a 0.");
                    }
                }catch (NumberFormatException e) {
                    throw new IllegalArgumentException("El argumento 'alto' no es un número válido. Ejemplo de uso: java Main rectangulo 5.0 3.0");
                }

                double areaRectangulo = ancho * largo;

                System.out.println("El area del rectangulo es: " + areaRectangulo);

            } else {
                throw new IllegalArgumentException("Figura no reconocida. Solo se permiten 'circulo' o 'rectangulo'");
            }
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
