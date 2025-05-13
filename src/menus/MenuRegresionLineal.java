package menus;

import entradasalida.Entrada;
import entradasalida.Salida;
import registros.machineLearning.RegresionLineal;


public class MenuRegresionLineal {
    private RegresionLineal regresionLineal;
    public MenuRegresionLineal(RegresionLineal regLineal) {
        regresionLineal = regLineal;
    }

    // Este metodo corre el menu principal en un bucle
    public void execute(){
        String xApredecir;
        imprimirMenuBasico();
        while (true){
            xApredecir = leerX();
            if (xApredecir.equalsIgnoreCase("x")){
                Salida.salidaPorDefecto("\n Bye. ¡Espero y vuelvas pronto :)!");
                return;
            }
            predecirY(Double.parseDouble(xApredecir));
            Salida.salidaPorDefecto("\n");
        }
    }

    // Este metodo imprime el menu basico
    private void imprimirMenuBasico(){
        Salida.salidaPorDefecto("" +
                "\n--------------------------------------------------------------------------------"
                + "\nLa regresión lineal es: y = " + regresionLineal.getTheta0() + " + (" + regresionLineal.getTheta1() + "x)"
                + "\n"
                + "('x' Para Salir)"
                + "\n");
    }

    // Eset metodo imprime la prediccion
    private void predecirY(double x){
        Salida.salidaPorDefecto("y_h(" + x + ")= " + regresionLineal.predice(x)
        );
    }

    // Este metodo solicita ingresar una opcion numero
    private String leerX(){
        Salida.salidaPorDefecto("\nIntroduce una x (cantidad habitaciones): ");
        return Entrada.terminalCadenas();
    }


    // Este metodo le pide una cadena al usuario, ademas se le pueden pasar algunas indicaciones
    private String pedirCadena(String cadena){
        Salida.salidaPorDefecto(cadena);
        return Entrada.terminalCadenas();
    }

}