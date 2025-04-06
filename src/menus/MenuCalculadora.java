package menus;

import edlineal.Arreglo;
import entradasalida.Entrada;
import entradasalida.Salida;
import tools.matematicas.TratamientoExpresiones;

// Aun no tiene muchas funcionalidades, pero este podria ser un menu donde el usuario
// pueda seleccionar si imprimir la expresion infija a postfija o evaluar una expresion
// en forma prefija o postfija. Por ahora solo pide una expresion infija y si tiene variables
// las pide y la resuelve.
public class MenuCalculadora {

    // Este metodo corre el menu principal en un bucle
    public void execute(){
        String opcion;
        while (true){
            imprimirMenuBasico();
            opcion = Entrada.terminalCadenas();
            if (opcion.equalsIgnoreCase("x")){
                System.out.println("Saliendo del sistema.........");
                break;
            }
            evaluarExprInfija(opcion);
        }
    }

    private void evaluarExprInfija(String expr){
        Arreglo resultado = TratamientoExpresiones.pedirValoresVariables(expr);
        Arreglo var = (Arreglo) resultado.obtener(0);
        Arreglo val = (Arreglo) resultado.obtener(1);

        String exprSustituida = TratamientoExpresiones.remplezarVariables(expr,
                var,
                val);

        Salida.salidaPorDefecto(
                "\nResultado: " + TratamientoExpresiones.evaluarInfija(exprSustituida));

    }

    // Este metodo imprime el menu basico
    private void imprimirMenuBasico(){
        Salida.salidaPorDefecto("""
                \n--------------------------------------------------------------------------------
                \nIntroduce una expresión infija sin espacios a ser evaluada (e.g '(2+8.9)*14.5')
                ('x' Para Salir):
                """);
    }

}
