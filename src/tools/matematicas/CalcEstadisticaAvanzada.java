package tools.matematicas;

import edlineal.ArregloNumerico;

public class CalcEstadisticaAvanzada {
    // Metodos estáticos avanzados estadisticos/machinelearning

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
