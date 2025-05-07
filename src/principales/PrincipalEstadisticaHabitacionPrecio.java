package principales;

import edlineal.Arreglo;
import edlineal.ListaDinNumerica;
import entradasalida.archivos.ArchivoTextoD;

public class PrincipalEstadisticaHabitacionPrecio {
    public static void main(String[] args) {
//        ListaDinNumerica lista = new ListaDinNumerica();
//
//        lista.poner(1.0);
//        lista.poner(2.0);
//        lista.poner(3.0);
//        lista.poner(3.0);
//        lista.imprimir();
//        System.out.println();
//
//        ListaDinNumerica lista2 = new ListaDinNumerica();
//
//        lista2.poner(4.0);
//        lista2.poner(5.0);
//        lista2.poner(8.0);
//        lista2.poner(1.0);
//        lista2.imprimir();
//        System.out.println();
//        System.out.println("Multiplicada");
//        lista.multiplicarPorLista(lista2);
//        lista.imprimir();

        // ------------------ Testing Potencia
//        ListaDinNumerica lista = new ListaDinNumerica();
//
//        lista.poner(1.0);
//        lista.poner(2.0);
//        lista.poner(3.0);
//        lista.poner(4.0);
//        lista.imprimir();
//        System.out.println();
//        lista.elevarAPotencia(2);
//        lista.imprimir();

        // -------------------- Testing Calcular Media
//                ListaDinNumerica lista = new ListaDinNumerica();
//
//        lista.poner(1.0);
//        lista.poner(2.0);
//        lista.poner(3.0);
//        lista.poner(4.0);
//        lista.imprimir();
//        System.out.println();
//        System.out.println(lista.calcularMedia());

        // ---------------------- Leyendo los datos
        String PATH_DATOS = "/home/fernunex/Documents/Uni/4_sem/EstructuraDatos/ed_aldonso_2025/src/media/datosEstadistica/";
        // Leyendo los datos en un Arreglo
        Arreglo xHabitacionesArreglo = ArchivoTextoD.leer(PATH_DATOS + "x_Cuartos.txt");
        Arreglo yPreciosArreglo = ArchivoTextoD.leer(PATH_DATOS + "y_precios.txt");

        // Convirtiendo esos arreglos a Listas Ligadas
        ListaDinNumerica xHabitaciones = new ListaDinNumerica();
        xHabitaciones.agregarLista(xHabitacionesArreglo);
        ListaDinNumerica yPrecios = new ListaDinNumerica();
        yPrecios.agregarLista(yPreciosArreglo);





    }
}
