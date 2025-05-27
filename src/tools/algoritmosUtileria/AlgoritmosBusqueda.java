package tools.algoritmosUtileria;

import edlineal.ArregloNumerico;

// Esta clase contiene diferentes algoritmos de busqueda
public class AlgoritmosBusqueda {

    // Este metodo implementea la busqueda secuencial
    static public int busquedaSecuencial(ArregloNumerico arr, double objetivo){
        for (int index = 0; index < arr.cantidad(); index++) { // Vamos uno por uno hasta el infinito
            if (arr.obtener(index) == objetivo) {
                return index; // Encontrado
            }
        }
        return -1; // No encontrado
    }

    // Este metodo implementea la busqueda binaria
    static public int busquedaBinaria(ArregloNumerico arreglo, double objetivo) {
        int izquierda = 0;
        int derecha = arreglo.cantidad() - 1;

        while (izquierda <= derecha) {
            int medio = (izquierda + derecha) / 2;
            double valorMedio = arreglo.obtener(medio);

            if (valorMedio == objetivo) {
                return medio; // Encontrado
            } else if (valorMedio < objetivo) { // Se busca en la mitad derecha
                                                // porque objetivo es mayor que el valor medio
                izquierda = medio + 1;
            } else { // Se busca en la mitad izquierda porque objetivo es menor que el valor medio
                derecha = medio - 1;
            }
        }

        return -1; // No encontrado
    }

}
