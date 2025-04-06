package registros.encriptador;

import edlineal.ArregloOrdenado;
import edlineal.PilaFija;

public class EncriptadorTextoBasico {


    // Este metodo encripta un texto plano. Le añade parentesis a la sección
    // indicada en el arreglo de índices e invierte esa seccion de texto
    // El arreglo toma 2 posiciones consecutivas como índice inicial e índice final.
    public static String encriptar(String text, ArregloOrdenado indices){
        String textoEnc = "";
        int indexInicial = 0;
        int indexFinal = 1;
        int valorIndexInicial, valorIndexFinal;
        char token;
        PilaFija pila = new PilaFija(text.length());

        for (int posToken = 0; posToken < text.length(); posToken++){
            token = text.charAt(posToken);

            if (indexInicial < indices.capacidad()){ // Aún hay segmentos o secciones que encriptar
                valorIndexInicial = ((int) indices.obtener(indexInicial)) - 1;
                valorIndexFinal = ((int) indices.obtener(indexFinal)) - 1;

                if (posToken == valorIndexInicial){ // Inicia una sección  a encriptar
                    textoEnc += "(";
                    // Guardamos esa cantidad de valores a encripar en una pila
                    for (int indexEncriptar = valorIndexInicial; indexEncriptar <= valorIndexFinal; indexEncriptar++){
                        pila.poner(token);
                        posToken++;
                        if (posToken < text.length()){
                            token = text.charAt(posToken);
                        }
                    }

                    // Los sacamos de la pila y va van a estar colocados al reves
                    for (int indexEncriptar = valorIndexInicial; indexEncriptar <= valorIndexFinal; indexEncriptar++){
                        textoEnc += pila.quitar();
                    }

                    // Corregimos el index del token
                    posToken--;
                    textoEnc += ")"; // Cerramos el segmento encriptado
                    indexInicial += 2; // Actualizamos los indices al siguiente segmento a encripar (si lo hay)
                    indexFinal += 2;
                } else { // Refactorizar esto. En algun momento de la vida. Pero basicamente insertamos el token en el texto enc
                    textoEnc += token;
                }
            } else { // Refactorizar esto. En algun momento de la vida.
                textoEnc += token;
            }
        }
        return textoEnc;
    }

    // Este metodo desencripta un texto encriptado basico
    public static String desencriptar(String textEnc){
        String texto = "";
        char token;
        PilaFija miPila = new PilaFija(textEnc.length());

        for (int posToken = 0; posToken < textEnc.length(); posToken++){
            token = textEnc.charAt(posToken);

            if (token == '('){ // Hay un fragmento de texto al reves
                posToken++;
                token = textEnc.charAt(posToken);

                while (token != ')'){ // Mientras no lleguemos al parentesis de cierre, meteremos to a la pila
                    miPila.poner(token);
                    posToken++;
                    token = textEnc.charAt(posToken);
                }

                while (miPila.vacio() == false){ // Al sacarlo de la pila ya lo sacaremos en orden
                    texto += miPila.quitar();
                }

            } else { // Simplemente ponemos el token
                texto += token;
            }
        }
        return texto;
    }
}
