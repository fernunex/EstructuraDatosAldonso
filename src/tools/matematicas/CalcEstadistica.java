package tools.matematicas;

import edlineal.ListaDinNumerica;

// Esta es una calculadora estadistica
// Calcula pearson media, moda, desviacion, etc (aún no esta completa)
public class CalcEstadistica {

    // Calcula la media de la lista numerica actual
    static public double calcularMedia(ListaDinNumerica x){
        double suma = x.calcularSumatoria();
        return suma / x.noElementos();
    }

    // Este metodo calcula la correlacion de pearson r
    static public double coeficientRPearson(ListaDinNumerica x, ListaDinNumerica y){
        double sumatoriaX = x.calcularSumatoria();
        double sumatoriaY = y.calcularSumatoria();

        ListaDinNumerica x_y = ((ListaDinNumerica) x.clonar());
        x_y.multiplicarPorLista(y);

        double sumatoriaX_Y = x_y.calcularSumatoria();

        int n = x.noElementos();

        ListaDinNumerica xSquared = ((ListaDinNumerica) x.clonar());
        xSquared.elevarAPotencia(2);
        ListaDinNumerica ySquared = ((ListaDinNumerica) y.clonar());
        ySquared.elevarAPotencia(2);

        double sumatoriaSquaX = xSquared.calcularSumatoria();
        double sumatoriaSquaY = ySquared.calcularSumatoria();

        double numerator = n*(sumatoriaX_Y)-(sumatoriaX*sumatoriaY);
        double den1 = n*(sumatoriaSquaX) - (sumatoriaX*sumatoriaX);
        double den2 = n*(sumatoriaSquaY) - (sumatoriaY*sumatoriaY);
        double denominator = Math.sqrt(den1*den2);

        return numerator/denominator;
    }

    // Este metodo interpreta un valor del Coeficiente de Pearson
    static public String interpreteCoefPearson(double coef){
        coef = round(coef, 1); // 1
        if (coef == 0.0){
            return "Ninguna correlación";
        } else if (coef == 1.0) {
            return "Correlación positiva perfecta";
        }else if (coef > 0.0 && coef < 1.0) {
            return "Correlación positiva";
        }else if (coef == -1.0) {
            return "Correlación negativa perfecta";
        }else{
            return "Correlación negativa";
        }
    }

    // Este metodo redondea un double a una cantidad de decimales especificada
    static public double round(double valor, int decimales){
        double escalador = Math.pow(10, decimales);
        double redondeado = Math.round(valor * escalador) / escalador;
        return redondeado;
    }

}
