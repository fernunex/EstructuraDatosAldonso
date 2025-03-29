package ednolineal;

import edlineal.ArregloNumerico;

public class Arreglo2DNumerico extends Arreglo2D{

    // Punto 2 -----------------------------------------------------
    // Este constructor inicializa el arreglo con 0
    public Arreglo2DNumerico(int filas, int columnas){
        super(filas, columnas);
        rellenar(0.0);
    }

    // Punto 3
    // Este metodo inicializa un arreglo con el valor indicado si es numerico
    // si no, entonces estara inicializado con nulos solamente
    public Arreglo2DNumerico(int filas, int columnas, Object valor){
        super(filas, columnas);

        if(valor instanceof Number){ // Si valor es numerico entonces lo inicializamos
            rellenar((double) valor);
        }
    }


    // Punto 1 Sobreescritura ----------------------------------
    // Este metodo obtiene un dato del arreglo 2d numerico
    @Override
    public Double obtener(int fila, int col) {
        return (double) super.obtener(fila, col);
    }

    // Este metodo guarda solo numeros en el arreglo 2d numerico en la posicion indicada
    @Override
    public boolean cambiar(int fila, int col, Object valor) {
        if (valor instanceof Number){
            return super.cambiar(fila, col, (double) valor);
        } else {
            return false;
        }
    }

    @Override
    public void rellenar(Object valor) {
        if (valor instanceof Number){
            super.rellenar((double) valor);
        } else {
            return;
        }

    }

    @Override
    public Arreglo2DNumerico clonar() {
        return (Arreglo2DNumerico) super.clonar();
    }

    // Punto 4 --------------------------------------------------------------
    // Este metodo multiplica cada elemento de la matriz por el escalar indicado
    public boolean porEscalar(Number escalar){
        double escal = (double) escalar;

        for (int indexFila = 0; indexFila < filasDim; indexFila++){
            for (int indexCol = 0; indexCol < columnasDim; indexCol++){
                cambiar(indexFila, indexCol, obtener(indexFila, indexCol) * escal);
            }
        }
        return true;
    }

    // Punto 5 --------------------------------------------------------------
    // Este metodo multiplica cada elemento de la matriz por el arreglo de escalares indicados
    public boolean porEscalares(ArregloNumerico escalares){
        // Validar dimensiones
        if (escalares.capacidad() == (filasDim * columnasDim)){
            int indexEscalar = 0;

            for (int indexFila = 0; indexFila < filasDim; indexFila++){
                for (int indexCol = 0; indexCol < columnasDim; indexCol++){
                    cambiar(indexFila, indexCol, obtener(indexFila, indexCol) * escalares.obtener(indexEscalar));
                    indexEscalar++;
                }
            }
            return true;
        } else {
            return false;
        }
    }

    // Punto 6 --------------------------------------------------------------
    // Este metodo suma cada elemento de la matriz por el escalar indicado
    public boolean sumarEscalar(Number escalar){
        double escal = (double) escalar;

        for (int indexFila = 0; indexFila < filasDim; indexFila++){
            for (int indexCol = 0; indexCol < columnasDim; indexCol++){
                cambiar(indexFila, indexCol, obtener(indexFila, indexCol) + escal);
            }
        }
        return true;
    }



    // Punto 7 --------------------------------------------------------------
    // Este metodo multiplica cada elemento de la matriz por el arreglo de escalares indicados
    public boolean sumarEscalares(ArregloNumerico escalares){
        // Validar dimensiones
        if (escalares.capacidad() == (filasDim * columnasDim)){
            int indexEscalar = 0;

            for (int indexFila = 0; indexFila < filasDim; indexFila++){
                for (int indexCol = 0; indexCol < columnasDim; indexCol++){
                    cambiar(indexFila, indexCol, obtener(indexFila, indexCol) + escalares.obtener(indexEscalar));
                    indexEscalar++;
                }
            }
            return true;
        } else {
            return false;
        }
    }

    // Punto 8
    // Este metodo multiplica una matriz por otra
    public boolean multiplicar(Arreglo2DNumerico matriz2){
        // Verificar dimensiones para multiplicacion
        if (columnasDim == matriz2.obtenerRenglones()){

            // Creamos un nuevo Arreglo2DNumerico
            Arreglo2DNumerico result = new Arreglo2DNumerico(filasDim, matriz2.obtenerColumnas());
            double suma;
            double dato1, dato2;

            // Multiplicamos (Dot product; fila x columna)
            for (int indexFila = 0; indexFila < filasDim; indexFila++){
                for (int indexColumna = 0; indexColumna < matriz2.obtenerColumnas(); indexColumna++){
                    suma = 0;
                    for (int indexElemento = 0; indexElemento < columnasDim; indexElemento++){ // Dot product
                        dato1 = obtener(indexFila, indexElemento);
                        dato2 = matriz2.obtener(indexElemento, indexColumna);

                        suma += dato1 * dato2;
                    }
                    result.cambiar(indexFila, indexColumna, suma);
                }
            }

            // Reasignamos el resultado a la actual
            this.datos = result.getDatos();
            this.columnasDim = matriz2.obtenerColumnas();
            return true;

        } else {
            return false;
        }
    }













}
