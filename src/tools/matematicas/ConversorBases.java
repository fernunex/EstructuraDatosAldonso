package tools.matematicas;

public class ConversorBases {
    static public String num16[] = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};

    // Este método comprueba si un numero es binario
    public static boolean esBinario(long number){
        long divisor = number / 10;
        if (divisor == 0){
            return number == 1 || number == 0; // que sea 0 o 1
        }else {
            return (number % divisor) < 2 && esBinario(divisor); // Caso recursivo
        }
    }

    // Este metodo retorna una cadena con el numero decimal pasado a hexadecimal
    public static String decimalAHexa(long number){
        if (number < 16){ // Caso base
            return num16[(int) number];
        } else { // Caso recursivo El último va primero, por eso colocamos la llamada primero
            return decimalAHexa(number/16) + num16[(int) (number % 16)];
        }
    }

    // Este metodo retorna una cadena con el numero decimal pasado a binario
    public static String decimalABinario(long number){
        if (number < 2){ // Caso base
            return number + ""; // Convertido a cadena
        } else { // Caso recursivo El último va primero, por eso colocamos la llamada primero
            return decimalABinario(number/2) + ((int) (number % 2) + "");
        }
    }

}
