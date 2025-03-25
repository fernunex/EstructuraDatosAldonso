package tools.matematicas;

import edlineal.PilaFija;

public class TratamientoExpresiones {

    // Convertir una expresión infija a posfija
    public static String convertirInfijaPostfija(String infija){
        return null;
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
                //  a) Si es operando, se mete en la pila
                if (pila.poner(token + "") == false){
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
}
