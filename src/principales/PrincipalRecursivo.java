package principales;


import entradasalida.Salida;

public class PrincipalRecursivo {
    public static void main(String[] args) {
        // Obteniendo el mayor
        int nums[] = {9, 3, 2, 10, 1};
        Salida.salidaPorDefecto("El mayor: " + mayor(nums, 0, nums.length - 1));
        System.out.println();

        // Obteniendo el promedio
        int nums2[] = {8, 3, 1, 4};
        Salida.salidaPorDefecto("El promedio es: " + promediar(nums2, 0, nums2.length - 1));
    }

    public static int mayor(int array[], int pos, int lim){
        if (pos == lim){ // Caso base
            return array[pos];
        } else { // Caso Recursivo
            return Math.max(array[pos], mayor(array, pos + 1, lim));
        }
    }

    public static double promediar(int array[], int pos, int lim){
        return sumar(array, pos, lim) / (lim + 1);
    }

    public static int sumar(int array[], int pos, int lim){
        if (pos == lim){
            return array[pos];
        } else {
            return array[pos] + sumar(array, pos + 1, lim);
        }
    }
}
