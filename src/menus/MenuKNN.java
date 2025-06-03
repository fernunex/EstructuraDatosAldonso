package menus;

import edlineal.Arreglo;
import edlineal.ArregloNumerico;
import entradasalida.Entrada;
import entradasalida.Salida;
import registros.machineLearning.modelosClasificacion.KNNModel;

public class MenuKNN {
    private KNNModel model;
    private Arreglo caracteristicas; // Estas son cada una de las caracteristicas y en ese mismo
                                    // orden se va a pedir los valores de las caracteristicas
                                    // para el dato (x_predict) a predecir.
    private Arreglo posiblesEtiquetas; // Las etiquetas posibles
    private String title;

    public MenuKNN(String titulo, KNNModel modelo, Arreglo caracteristicas, Arreglo posiblesEtiquetas) {
        this.model = modelo;
        this.caracteristicas = caracteristicas;
        this.posiblesEtiquetas = posiblesEtiquetas;
        this.title = titulo;
    }

    // Este metodo corre el menu principal en un bucle
    public void execute(){
        String option;
        imprimirMenuBasico();
        while (true){
            option = leerX();
            if (option.equalsIgnoreCase("x")){
                Salida.salidaPorDefecto("\n Bye. ¡Espero y vuelvas pronto :)!");
                return;
            }
            predecir();
            Salida.salidaPorDefecto("\n");
        }
    }

    // Este metodo imprime el menu basico
    private void imprimirMenuBasico(){
        Salida.salidaPorDefecto("" +
                "\n--------------------------------------------------------------------------------"
                + "\n Bienvenido al modelo KNN para predecir " + this.title
                + "\n"
                + "('x' Para Salir)"
                + "\n");
    }

    // Eset metodo imprime la prediccion
    private void predecir(){
        ArregloNumerico x_predict = pedirDatoAPredecir();
        Salida.salidaPorDefecto("\n-----------------------------\n" +
                "El dato ingresado pertenece a la clase: " + model.predecirClase(x_predict)
                + "\n----------------------------------------\n"
        );
        Salida.salidaPorDefecto("De las posibles clases:\n");
        imprimirClases();

        Salida.salidaPorDefecto("----------------------------------------\n");

    }

    // Este metodo imprime las posibles clases
    private void imprimirClases(){
        for (int indexClase = 0; indexClase <posiblesEtiquetas.cantidad(); indexClase++){
            Salida.salidaPorDefecto(posiblesEtiquetas.obtener(indexClase) + "\n");
        }
    }

    // Este metodo pide los datos para el nuevo dato a predecir
    ArregloNumerico pedirDatoAPredecir(){
        ArregloNumerico valoresDato = new ArregloNumerico(caracteristicas.cantidad());
        double valor;
        for (int indexCaracteristica = 0; indexCaracteristica < caracteristicas.cantidad(); indexCaracteristica++){
            Salida.salidaPorDefecto("Introduce el valor de '" +
                    caracteristicas.obtener(indexCaracteristica) + "': ");
            valor = Entrada.terminalDouble();
            valoresDato.poner(valor);
        }
        return valoresDato;
    }

    // Este metodo solicita ingresar una opcion numero
    private String leerX(){
        Salida.salidaPorDefecto("\nIngresa 'x' para salir o cualquier caracter para continuar:");
        return Entrada.terminalCadenas();
    }


    // Este metodo le pide una cadena al usuario,
    private String pedirCadena(String cadena){
        Salida.salidaPorDefecto(cadena);
        return Entrada.terminalCadenas();
    }
}
