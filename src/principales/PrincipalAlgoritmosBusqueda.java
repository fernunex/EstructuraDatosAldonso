package principales;

import edlineal.ArregloNumerico;
import entradasalida.Salida;
import static tools.algoritmosUtileria.AlgoritmosBusqueda.*;

public class PrincipalAlgoritmosBusqueda {
    public static void main(String[] args) {
        ArregloNumerico arr1, arr2;

        arr1 = new ArregloNumerico(12);
        arr2 = new ArregloNumerico(14);


        // Busqueda Secuencial / Lineal
        // desordenados
        arr1.poner(1.0);
        arr1.poner(2.0);
        arr1.poner(48.0);
        arr1.poner(35.0);
        arr1.poner(46.0);
        arr1.poner(67.0);
        arr1.poner(12.0);
        arr1.poner(68.0);
        arr1.poner(47.0);
        arr1.poner(68.0);
        arr1.poner(20.0);
        arr1.poner(3.0);

//        arr1.imprimir();
//        Salida.salidaPorDefecto("\n\nBuscando el 99.0: " + busquedaSecuencial(arr1, 99.0));
//        Salida.salidaPorDefecto("\nBuscando el 0.0: " + busquedaSecuencial(arr1, 0.0));
//        Salida.salidaPorDefecto("\nBuscando el 46.0: " + busquedaSecuencial(arr1, 46.0));

        //--------------------------------------------------------------------------------------------------------------
        // ordenados
        arr2.poner(12.0);
        arr2.poner(13.0);
        arr2.poner(18.0);
        arr2.poner(19.0);
        arr2.poner(26.0);
        arr2.poner(42.0);
        arr2.poner(50.0);
        arr2.poner(56.0);
        arr2.poner(60.0);
        arr2.poner(78.0);
        arr2.poner(79.0);
        arr2.poner(80.0);
        arr2.poner(85.0);
        arr2.poner(90.0);

        arr2.imprimir();
        Salida.salidaPorDefecto("\n\nBuscando el 99.0: " + busquedaBinaria(arr2, 99.0));
        Salida.salidaPorDefecto("\nBuscando el 20.0: " + busquedaBinaria(arr2, 20.0));
        Salida.salidaPorDefecto("\nBuscando el 19.0: " + busquedaBinaria(arr2, 19.0));

    }
}
