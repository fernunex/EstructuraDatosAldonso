package tools.matematicas;

import edlineal.Arreglo;
import edlineal.PilaFija;
import entradasalida.Entrada;
import entradasalida.Salida;

public class TratamientoExpresiones {

    // Convertir una expresión infija a posfija
    public static String convertirInfijaPostfija(String infija){
            String token;
            String expPostfija = "";
            PilaFija pila = new PilaFija(infija.length());

        // Tokenizar de izquierda a derecha
        for (int posToken = 0; posToken < infija.length(); posToken++){

            // Tomamos un token
            token = infija.charAt(posToken) + "";

            // Checamos si es operando
            if (esOperando(token) == true){ // Es un numero, incluido el "."

                // Guardamos todito el número, incluido el "." eg 2.23
                expPostfija += token;
                posToken++;

                if (posToken < infija.length()){
                    token = infija.charAt(posToken) + "";
                    while (esOperando(token) == true && posToken < infija.length() - 1){
                        expPostfija += token;
                        posToken++;
                        token = infija.charAt(posToken) + "";
                    }
                    if (esOperando(token)){ // El ultimo numero de la cadena e.g del 2*39, es el 9
                        expPostfija += token;
                    }
                }


                // Le añadimos un separador al operando
                expPostfija += " ";
            }

            if (esOperando(token) == false) { // Si no es operando, es operador

                if (token.equalsIgnoreCase("(")){
                    // Simplemente la lo metemos a la pila
                    pila.poner(token);

                } else if (token.equalsIgnoreCase(")")) {
                    // Scacamos todos los operadores de la pila hasta llegar a "("
                    while (pila.verTope().toString().equalsIgnoreCase("(") == false){
                        expPostfija += pila.quitar();
                    }
                    // Al final tambien sacamos el "(" de la pila
                    pila.quitar();

                } else { // Entonces es un operador +,-,/,*, etc
                    // Sacamos los de mayor o igual prioridad al operador actual
                    while (pila.vacio() == false && mayorIgual(pila.verTope() + "", token) && pila.verTope().toString().equalsIgnoreCase("(") == false){
                        expPostfija += pila.quitar();
                    }
                    pila.poner(token); // Al final metemos el operador a la pila
                }
            }
        }

        // Mandamos a la expresion los operadores que se encuentren en la pila si es que los hay
        while (pila.vacio() == false){
            expPostfija += pila.quitar();
        }

        return expPostfija;
    }

    // Este metodo retorna si el operador 1 es mayor o igual en prioridad al operador 2
    private static boolean mayorIgual(String operator1, String operator2) {
        int prioridadOp1 = obtenerPrioridad(operator1);
        int prioridadOp2 = obtenerPrioridad(operator2);
        return prioridadOp1 >= prioridadOp2;
    }

    // Convertir una expresión infija en prefija

    // Evaluar una expresión infija
    public static Double evaluarInfija(String infija){
        // Convertir a prefija o postfija
        String postfija = convertirInfijaPostfija(infija);

        // Mandar llamar al de evaluar postfija o prefija
        return evaluarPostfija(postfija);
    }

    // Evaluar una expresión posfija
    public static Double evaluarPostfija(String postfija){
        PilaFija pila = new PilaFija(postfija.length());

        // 1. Tokenizar la EPOS de izq -> der
        for (int posToken = 0; posToken < postfija.length(); posToken++){

            char token = postfija.charAt(posToken);

            if (esOperando(token + "") == true){
                // Agarramos todito el operando
                String operando = "";
                while ((token + "").equalsIgnoreCase(" ") == false){
                    operando += token;
                    posToken++;
                    token = postfija.charAt(posToken);
                }

                //  a) Si es operando, se mete en la pila
                if (pila.poner(operando) == false){ //si hay un error salimos
                    return null;
                }

            } else { // Si no fue operando, es operador
                //  b) Si es operador, se extraen dos operandos de la pila (
                //     el primer operando es OP2), se calcula la operación con
                //     ese token y se mete el resultado en la pila
                String op2 = (String) pila.quitar();
                String op1 = (String) pila.quitar();

                Double numero1 = Double.parseDouble(op1);
                Double numero2 = Double.parseDouble(op2);

                Double resultado = operacionAritmetica(token, numero1, numero2);

                if (resultado == null) { // hay error
                    return null;
                }

                if (pila.poner(resultado + "") == false){ // Error
                    return null;
                }
            }
        }

        // 2. El resultado de la evaluación está en la pila
        String cadenaResultado = (String) pila.quitar();

        if (cadenaResultado == null){ // hay error, no hay nada en la pila
            return null;
        } else {
            return Double.parseDouble(cadenaResultado);
        }
    }

    public static Double operacionAritmetica(char operador, Double op1, Double op2){
        if (operador == '+'){
            return op1 + op2;
        } else if (operador == '-'){
            return op1 - op2;
        } else if (operador == '/'){
            if (op2 != 0){
                return op1 / op2;
            } else {
                return null;
            }
        } else if (operador == '*'){
            return op1 * op2;
        } else if (operador == '^'){
            return Math.pow(op1, op2);
        } else if (operador == '%'){
            return op1 % op2;
        } else { // otra cosa inválida
            return null;
        }
    }

    public static boolean esOperando(String token){
        if (token.equals("+") == true){
            return false;
        } else if (token.equals("-") == true){
            return false;
        } else if (token.equals("*") == true){
            return false;
        } else if (token.equals("/") == true){
            return false;
        } else if (token.equals("^") == true){
            return false;
        } else if (token.equals("%") == true){
            return false;
        } else if (token.equals("(") == true){
            return false;
        }else if (token.equals(")") == true){
            return false;
        } else {
            return true;
        }
    }

    // Evaluar una expresión prefija


    // Este metodo detecta las variables y pide los valores de esas variables
    // Este metodo retorna un arreglo con 2 arreglos, el primero con las variables y el segundo con sus respectivos
    // valores, estos son arreglos paralelos
    public static Arreglo pedirValoresVariables(String expr){
        Arreglo arrVariables = new Arreglo(expr.length()); // Guarda las letras
        Arreglo arrValores = new Arreglo(expr.length()); // Guarda los valores
        Arreglo result = new Arreglo(2); // Contiene los dos arreglos de arriba
        int indexVariable; // Para checar si ya se encuentra la variable en el arreglo
        double valorPedido; // Para pedirle al usuario el valor

        char token;
        for (int posToken = 0; posToken < expr.length(); posToken++){
            token = expr.charAt(posToken);

            if ((token >= 'a' && token <= 'z') || (token >= 'A' && token <= 'Z')){ // Verificamos si es una letra
                indexVariable = (int) arrVariables.buscar(token);

                if (indexVariable == -1){ // Si no se encuentra, entonces la agregamos y pedimos el valor correspondiente
                    arrVariables.poner(token);
                    Salida.salidaPorDefecto("Introduce el valor de " + token + ": ");
                    valorPedido = Entrada.terminalDouble();
                    arrValores.poner(valorPedido);
                }
            }
        }
        result.poner(arrVariables);
        result.poner(arrValores);

        return result;
    }

    // Este metodo remplaza las variables en una expresion aritmetica por valores numericos correspondientes
    // Arreglo de variables y Arreglo de valores son arreglos paralelos, en uno estan guardados las variables
    // en el otro los valores correspondientes
    public static String remplezarVariables(String expresion, Arreglo variables, Arreglo valores){
        String expresionNueva = "";
        char token;

        for (int posToken = 0; posToken < expresion.length(); posToken++){
            token = expresion.charAt(posToken);

            if ((token >= 'a' && token <= 'z') || (token >= 'A' && token <= 'Z')){ // Si es una variable
                expresionNueva += (double) valores.obtener((int) variables.buscar(token));
            } else {
                expresionNueva += token;
            }
        }
        return expresionNueva;
    }

    // Metodo para determinar prioridad
    // Este metodo retorna la prioridad de un operador
    // 0 -> + y -
    // 1 -> *, /, y %
    // 2 -> ^
    private static int obtenerPrioridad(String operator2) {
        if (operator2.equalsIgnoreCase("+") || operator2.equalsIgnoreCase("-")){
            return 0;
        } else if (operator2.equalsIgnoreCase("*") || operator2.equalsIgnoreCase("/")
                || operator2.equalsIgnoreCase("%")) {
            return 1;
        } else { // es una potencia ^
            return 2;
        }
    }
}
