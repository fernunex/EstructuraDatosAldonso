package registros.machineLearning;

import edlineal.ArregloNumerico;
import static tools.matematicas.CalcEstadisticaAvanzada.*;

public class RegresionLineal {
    protected double theta0; // p
    protected double theta1; // b
    protected int numReps;
    protected ArregloNumerico x;
    protected ArregloNumerico y;
    protected double alpha;

    public RegresionLineal(ArregloNumerico x, ArregloNumerico y) {
        this(x, y, 0.009, 100_000);
    }

    public RegresionLineal( ArregloNumerico x, ArregloNumerico y, double alpha, int numReps) {
        this.alpha = alpha;
        this.y = y;
        this.x = x;
        this.numReps = numReps;

        this.theta0 = 0.0;
        this.theta1 = 0.0;

        ajustar(); // Este metodo optimiza la regresion lineal según los datos pasados
    }

    // Este metodo predice y_h segun su regresion lineal interna
    public double predice(double x_valor){
        return theta0 + theta1*x_valor;
    }

    // Este metodo predice y_h segun su regresion lineal interna para un arreglo de datos
    public ArregloNumerico predice(ArregloNumerico x_valores){
        ArregloNumerico y_predichas = new ArregloNumerico(x_valores.cantidad());

        for (int x_index = 0; x_index < x_valores.cantidad(); x_index++){
            y_predichas.poner(predice(x_valores.obtener(x_index)));
        }
        return y_predichas;
    }


    // Este metodo aplica el descenso del gradiente para optimizar la regresion lineal
    private void ajustar(){
        ArregloNumerico y_predichas;
        double parcialTheta0, parcialTheta1;
        for (int iteracion = 0; iteracion < this.numReps; iteracion++){
            y_predichas = predice(this.x);

            // Derivada parcial de thetha 0 o p
            parcialTheta0 = ECM_theta0(y_predichas, this.y);


            // Derivada parcial de thetha 1 o b
            parcialTheta1 = ECM_theta1(y_predichas, this.x, this.y);

            // Actualizando
            this.theta0 = theta0 - parcialTheta0*alpha;
            this.theta1 = theta1 - parcialTheta1*alpha;
        }
    }

    public double getTheta0() {
        return theta0;
    }

    public void setTheta0(double theta0) {
        this.theta0 = theta0;
    }

    public double getTheta1() {
        return theta1;
    }

    public void setTheta1(double theta1) {
        this.theta1 = theta1;
    }
}
