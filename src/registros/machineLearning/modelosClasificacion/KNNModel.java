package registros.machineLearning.modelosClasificacion;

import edlineal.Arreglo;
import edlineal.ArregloNumerico;
import static tools.matematicas.CalcEstadisticaAvanzada.*;

public class KNNModel {
    protected Arreglo variablesPredictoras; // Arreglo que contiene las X1, X2, X3, etc
    protected Arreglo clasesMuestras; // Clase de cada registro x1,x2,x3... = c1
    protected int numMuestras; // Numero de muestras o datos
    protected int numVariablesPredictorias; // numero de variables predictorias

    protected Arreglo clasesPosibles; // Clases posibles de clasificar
    protected int numClasesPosibles; // Cantidad de clases a clasificar

    protected boolean usarPesadoVariables; // si se desea calcular el peso de cada variable
    protected ArregloNumerico pesoVariables; // Se le asignara un peso a cada variable predictora
                                            // si no se desea calcular un pesado de variables, entonces se
                                            // asignara 1 a todas las variables, es decir, misma importancia.

    protected int numeroVecinos; // k vecinos que se buscaran

    public KNNModel(Arreglo variablesPredictoras, Arreglo clasesMuestras, Arreglo clasesPosibles, boolean usarPesadoVariables, int numeroVecinos) {
        this.variablesPredictoras = variablesPredictoras;
        this.clasesMuestras = clasesMuestras;
        this.clasesPosibles = clasesPosibles;
        this.usarPesadoVariables = usarPesadoVariables;
        this.numeroVecinos = numeroVecinos;

        numMuestras = clasesMuestras.cantidad();
        numClasesPosibles = clasesPosibles.cantidad();
        numVariablesPredictorias = variablesPredictoras.cantidad();

        this.pesoVariables = new ArregloNumerico(numVariablesPredictorias);
        this.pesoVariables.rellenar(1.0);
        if (usarPesadoVariables == true){ // Si se pide que se calculen pesos usando la medida de información mutua
            calcularPesos();
        }
    }

    // Este metodo retorna que clase pertenece ese nuevo dato a predecir
    public Object predecirClase(ArregloNumerico xPredecir){
        Arreglo kDistanciasClasesVecinas = kDistanciasClasesCercanas(xPredecir);
        return claseMasFrecuente((Arreglo) kDistanciasClasesVecinas.obtener(1));
    }

    // Este metodo retorna un Arreglo con dos arreglos paralelos: {Distancias, Clases} estos
    // son los k vecinos mas cercanos al dato a predecir
    Arreglo kDistanciasClasesCercanas(ArregloNumerico xPredecir){
        Arreglo res = new Arreglo(2);
        ArregloNumerico kDistancias = new ArregloNumerico(this.numeroVecinos);
        Arreglo kClases = new Arreglo(this.numeroVecinos);
        ArregloNumerico todasDistancias = new ArregloNumerico(this.numMuestras);
        double distancia;

        for (int indexMuestra = 0; indexMuestra < this.numMuestras; indexMuestra++){
            ArregloNumerico muestra = new ArregloNumerico(this.numVariablesPredictorias);

            for (int indexVariablePre = 0; indexVariablePre < numVariablesPredictorias; indexVariablePre++){
                muestra.poner(
                        ((ArregloNumerico) this.variablesPredictoras.obtener(indexVariablePre)).obtener(indexMuestra)
                );
            }
            distancia = distanciaEuclideanaPonderada(
                    muestra,
                    xPredecir,
                    this.pesoVariables
            );
            todasDistancias.poner(distancia);
        }
        insertarDistanciaClase(todasDistancias, kDistancias, kClases);
        res.poner(kDistancias);
        res.poner(kClases);
        return res;
    }

    // Este metodo encuentra las k distancias y clases mas cercanas y las agrega a la lista
    protected void insertarDistanciaClase(ArregloNumerico distancias,
                                          ArregloNumerico kDistancias,
                                          Arreglo kClases){
        int indexMin;
        for (int indexVecino = 0; indexVecino < this.numeroVecinos; indexVecino++){
            indexMin = distancias.indexMin();
            kDistancias.poner(distancias.obtener(indexMin));
            kClases.poner(this.clasesMuestras.obtener(indexMin));
            distancias.poner(indexMin, Double.POSITIVE_INFINITY);
        }
    }

    // Este metodo retorna la clase más frecuente en un set de clases pasadas de los vecinos del dato
    //  a predecir
    protected Object claseMasFrecuente(Arreglo clasesVecinas){
        int numApariciones;
        ArregloNumerico apariciones = new ArregloNumerico(this.numClasesPosibles);
        for (int indexClase = 0; indexClase < this.numClasesPosibles; indexClase++){
            numApariciones = clasesVecinas.contar(clasesPosibles.obtener(indexClase));
            apariciones.poner((double) numApariciones);
        }

        int indexMaxApariciones = apariciones.indexMax();
        return clasesPosibles.obtener(indexMaxApariciones);
    }

    // Este metodo calcula los pesos que se le asignara a cada variable predictoria. Se utiliza la
    // medida de informacion mutua. Requiere que las variables predictorias sean discretas.
    // Todo: Falta implementarse
    protected void calcularPesos(){
        for (int indexVariable = 0; indexVariable < this.numVariablesPredictorias; indexVariable++){
            this.pesoVariables.poner(1.0); // Por el momento todas las variables tienen el mismo
                                                // peso

            // Aquí deberíamos de colocar
            //  this.pesoVariables.poner(
            //      calcularMedidaInfoMutua(........args)
            //  );
            // Pero aun no está implementada esa funcion

        }
    }
}
