package principales;

import edlineal.Arreglo;
import edlineal.ListaDinNumerica;
import entradasalida.Salida;
import entradasalida.archivos.ArchivoTextoD;
import tools.matematicas.CalcEstadistica;

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
//        lista.poner(3.0);
//        lista.poner(4.0);
//        lista.imprimir();
//        System.out.println();
//        System.out.println(CalcEstadistica.calcularMedia(lista));

        // -------------------- Testing Calcular resta escalar
//                ListaDinNumerica lista = new ListaDinNumerica();
//
//        lista.poner(1.0);
//        lista.poner(2.0);
//        lista.poner(3.0);
//        lista.poner(3.0);
//        lista.poner(4.0);
//        lista.imprimir();
//        System.out.println();
//        lista.restarEscalar(1.0);
//        lista.imprimir();

        // ------------------------------ ACTIVIDAD 2 ----------------------------------------------------------------------
        // ---------------------- Leyendo los datos -----------------------------------------------------------------------
//        String PATH_DATOS = "/home/fernunex/Documents/Uni/4_sem/EstructuraDatos/" +
//                "ed_aldonso_2025/src/media/datosEstadistica/";
//        // Leyendo los datos en un Arreglo
//        Arreglo xHabitacionesArreglo = ArchivoTextoD.leer(PATH_DATOS + "x_Cuartos.txt");
//        Arreglo yPreciosArreglo = ArchivoTextoD.leer(PATH_DATOS + "y_precios.txt");
//
//        // Convirtiendo esos arreglos a Listas Ligadas
//        ListaDinNumerica xHabitaciones = new ListaDinNumerica();
//        xHabitaciones.agregarLista(xHabitacionesArreglo);
//        ListaDinNumerica yPrecios = new ListaDinNumerica();
//        yPrecios.agregarLista(yPreciosArreglo);
//
////      Calculando el coeficiente r de Pearson usando la fórmula
//        double coefPearson = CalcEstadistica.coeficientRPearson(xHabitaciones, yPrecios);
//        Salida.salidaPorDefecto("Valor del Coeficiente de Pearson: " +
//                coefPearson);
//        Salida.salidaPorDefecto("\nEl grado de Correlación entre las " +
//                        "Variables es: " +
//                        CalcEstadistica.interpreteCoefPearson(coefPearson) +
//                "\n");


        // ------------------------------ ACTIVIDAD 3 ----------------------------------------------------------------------
        // ---------------------- Leyendo los datos -----------------------------------------------------------------------
        String PATH_DATOS = "/home/fernunex/Documents/Uni/4_sem/EstructuraDatos/" +
                "ed_aldonso_2025/src/media/datosEstadistica/";
        // Leyendo los datos en un Arreglo
        Arreglo xHabitacionesArreglo = ArchivoTextoD.leer(PATH_DATOS + "x_Cuartos.txt");
        Arreglo yPreciosArreglo = ArchivoTextoD.leer(PATH_DATOS + "y_precios.txt");

        // Convirtiendo esos arreglos a Listas Ligadas
        ListaDinNumerica xHabitaciones = new ListaDinNumerica();
        xHabitaciones.agregarLista(xHabitacionesArreglo);
        ListaDinNumerica yPrecios = new ListaDinNumerica();
        yPrecios.agregarLista(yPreciosArreglo);

        // Calculando la Covarianza muestral
//        double covMuestral = CalcEstadistica.covarianza(
//                (ListaDinNumerica) xHabitaciones.clonar(),
//                (ListaDinNumerica) yPrecios.clonar());
//
//        System.out.println(covMuestral);

        // C)
        // Calculando el Coeficiente de Pearson Poblacional
//        double pearsonPoblacional = CalcEstadistica.pearsonPoblacional(
//                xHabitaciones,
//                yPrecios
//        );
//        System.out.println(pearsonPoblacional);
        // Calculando el Coeficiente de Pearson Muestral

//        CalcEstadistica.imprimirPromedios(xHabitaciones, yPrecios);

//        CalcEstadistica.imprimirMinMax(xHabitaciones, yPrecios);

        System.out.println(
                CalcEstadistica.pearsonMuestral(
                        xHabitaciones,
                        yPrecios
                )
        );


    }
}
