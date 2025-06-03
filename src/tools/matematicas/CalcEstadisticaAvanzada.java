package tools.matematicas;

import edlineal.Arreglo;
import edlineal.ArregloNumerico;

// Metodos estáticos avanzados estadisticos/machinelearning
public class CalcEstadisticaAvanzada {

    // Este metodo calcula la distancia entre dos puntos ponderando cada uno de los pesos de sus variables
    public static double distanciaEuclideanaPonderada(
            ArregloNumerico x1, ArregloNumerico x2, ArregloNumerico pesos
    ){
        ArregloNumerico x1_copy = (ArregloNumerico) x1.clonar();
        x1_copy.restarLista(x2);
        x1_copy.aplicarPotencia(2);
        x1_copy.multiplicar(pesos);
        double x1_sumatoria = x1_copy.sumatoria();

        return Math.sqrt(x1_sumatoria);
    }

    // Este metodo calcula la medida de informacion mutua entre 2 variables
    // I(Xi,C)
    public double calcularMedidaInfoMutua(
            ArregloNumerico x1, ArregloNumerico x1_clasesUnicas, Arreglo etiquetas, Arreglo posiblesEtiquetas
    ){
        // Todo: Falta implementarse
        return 1.0; // Por el momento retorna 1 y esto significa que todas las variables tendran el mismo peso
                    // por lo tanto todas tendran la misma importancia.
    }


    // Este metodo calcula la derivada parcial de theta 0 de la funcion de Costo Error Cuadratico Medio
    public static double ECM_theta0(ArregloNumerico y_predicha, ArregloNumerico y_originales){
        ArregloNumerico res = (ArregloNumerico) y_predicha.clonar();
        res.restarLista(y_originales);
        double res_suma = res.sumatoria();
        return res_suma/res.cantidad();
    }

    // Este metodo calcula la derivada parcial de theta 1 de la funcion de Costo Error Cuadratico Medio
    public static double ECM_theta1(ArregloNumerico y_predicha, ArregloNumerico x_values, ArregloNumerico y_originales){
        ArregloNumerico res = (ArregloNumerico) y_predicha.clonar();
        res.restarLista(y_originales);
        res.multiplicar(x_values);
        double res_suma = res.sumatoria();
        return res_suma / res.cantidad();
    }

}
