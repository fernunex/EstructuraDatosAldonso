package principales;

import edlineal.Arreglo;
import edlineal.ListaDinNumerica;
import entradasalida.Salida;
import entradasalida.archivos.ArchivoTextoD;
import registros.graphs.GraficaDispersion;
import tools.matematicas.CalcEstadistica;

import javax.swing.*;

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

        // Descomentar para ejecutar la Actividad 2
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

        // A)
        Salida.salidaPorDefecto("A)" +
                "Calcule el valor promedio de las casas de acuerdo con cada número de\n" +
                "habitaciones existente:\n");
        CalcEstadistica.imprimirPromedios(xHabitaciones, yPrecios);

        // B)
        Salida.salidaPorDefecto("\nB)" +
                "Determine el valor máximo y mínimo que alguien tendría que pagar para cada\n" +
                "tipo de casa (cada tipo depende del número de habitaciones).\n");
        CalcEstadistica.imprimirMinMax(xHabitaciones, yPrecios);

        // C)
        Salida.salidaPorDefecto("\nC)" +
                "Calcule el coeficiente de correlación considerando: i) asumiendo que los dato son\n" +
                "una muestra, ii) asumiendo que los datos son la población total. Compare los\n" +
                "resultados de los incisos anteriores. Saque sus conclusiones.\n");

        // Calculando el Coeficiente de Pearson Poblacional
        double pearsonPoblacional = CalcEstadistica.pearsonPoblacional(
                xHabitaciones,
                yPrecios
        );
        Salida.salidaPorDefecto("Pearson Poblacional: " + pearsonPoblacional + "\n");
        Salida.salidaPorDefecto("\tInterpretación: " + CalcEstadistica.interpreteAsociacion(
                pearsonPoblacional
        ) + "\n");

        double pearsonMuestral = CalcEstadistica.pearsonMuestral(
                xHabitaciones,
                yPrecios
        );
        Salida.salidaPorDefecto("\nPearson Muestral: " + pearsonMuestral + "\n");
        Salida.salidaPorDefecto("\tInterpretación: " + CalcEstadistica.interpreteAsociacion(
                pearsonMuestral
        ) + "\n");

        // Mostrando la Gráfica
        GraficaDispersion ventana = new GraficaDispersion(
                xHabitaciones,
                yPrecios,
                "Gráfica de dispersión: Cantidad Habitaciones vs Precio",
                "Cantidad Habitaciones",
                "Precio de Casa"
        );
        ventana.setSize(800, 600);
        ventana.setLocationRelativeTo(null);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);
    }
}
