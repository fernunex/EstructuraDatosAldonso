package ednolineal;

import edlineal.Arreglo;
import entradasalida.Salida;
import tools.enumerados.TipoColumna;
import tools.enumerados.TipoRenglon;

public class Arreglo2D {
    protected int columnasDim;
    protected int filasDim;

    protected Object datos[][];

    // 1 Constructor
    public Arreglo2D(int filasDim, int columnasDim) {
        this.columnasDim = columnasDim;
        this.filasDim = filasDim;

        datos = new Object[filasDim][columnasDim];
    }

    // 2 Constructor con relleno por defecto
    public Arreglo2D(int filasDim, int columnasDim, Object valor) {
        this(filasDim, columnasDim);
        rellenar(valor);
    }

    // 3. Este metodo retorna un valor que este almacenado en la fila y columna indicada
    public Object obtener(int fila, int col){
        if (esIndexValido(fila, col)){
            return datos[fila][col];
        } else {
            return null;
        }
    }

    private boolean esIndexValido(int indexFila, int indexCol){
        if (esColumnaValida(indexCol) && esFilaValida(indexFila)){
            return true;
        } else {
            return false;
        }
    }

    private boolean esColumnaValida(int indexCol){
        if (indexCol >= 0 && indexCol < columnasDim){
            return true;
        } else {
            return false;
        }
    }

    private boolean esFilaValida(int indexFila){
        if (indexFila >= 0 && indexFila < filasDim){
            return true;
        } else {
            return false;
        }
    }

    // 4. Este metodo cambia el valor en la fila y columna indicada por otro valor indicado
    public boolean cambiar(int fila, int col, Object valor){
        if (esIndexValido(fila, col)){
            datos[fila][col] = valor;
            return true;
        } else {
            return false;
        }
    }

    // 5. Columnas y Renglones
        // Este metodo retorna la dimension de las columnas
    public int obtenerColumnas(){
        return columnasDim;
    }

        // Este metodo retorna la dimension de las filas
    public int obtenerRenglones(){
        return filasDim;
    }

    // 6. Este metodo imprime la matriz por renglones
    public void imprimirXRenglones(){
        Object dato;

        for (int indexFila = 0; indexFila < filasDim; indexFila++){

            for (int indexColumna = 0; indexColumna < columnasDim; indexColumna++){
                dato = datos[indexFila][indexColumna];
                Salida.salidaPorDefecto(dato + " ");
            }
            Salida.salidaPorDefecto("\n");
        }

    }

    // 7. Este metodo imprime la matriz por columas
    public void imprimirXColumnas(){

        Object dato;

        for (int indexColumna = 0; indexColumna < columnasDim; indexColumna++){

            for (int indexFila = 0; indexFila < filasDim; indexFila++){
                dato = datos[indexFila][indexColumna];
                Salida.salidaPorDefecto(dato + " ");
            }
            Salida.salidaPorDefecto("\n");
        }

    }

    // 8. Este metodo transpone la matriz
    public void transpuesta(){
        int filas2 = columnasDim;
        int columnas2 = filasDim;

        Object datos2[][] = new Object[filas2][columnas2];

        // Recorremos cada valor y lo insertamos intercambiando la fila por la columna
        for (int indexFila = 0; indexFila < filasDim; indexFila++){

            for (int indexColumna = 0; indexColumna < columnasDim; indexColumna++){
                datos2[indexColumna][indexFila] = datos[indexFila][indexColumna];
            }
        }

        // Reasignamos
        datos = datos2;
        columnasDim = columnas2;
        filasDim = filas2;
    }

    // 9. Este metodo inicializa todas las casillas de la matriz 2D con un valor especificado
    public void rellenar(Object valor){

        // Recorremos la matriz y le colocamos el valor
        for (int indexFila = 0; indexFila < filasDim; indexFila++){

            for (int indexColumna = 0; indexColumna < columnasDim; indexColumna++){
                datos[indexFila][indexColumna] = valor;
            }
        }
    }

    // 10. Este metodo devuelve un clon del arreglo 2D actual
    public Arreglo2D clonar(){
        // Creamos un arr2d nuevo
        Arreglo2D arr2 = new Arreglo2D(filasDim, columnasDim);

        // Lo copiamos
        for (int indexFila = 0; indexFila < filasDim; indexFila++){

            for (int indexColumna = 0; indexColumna < columnasDim; indexColumna++){

                arr2.cambiar(
                        indexFila,
                        indexColumna,
                        datos[indexFila][indexColumna]
                );
            }
        }

        return arr2;
    }

    // ----------- Second test
    // 11. Este metodo inidca si una matriz es igual a otra
    public boolean esIgual(Arreglo2D matriz2){
        // Validar si son de las mismas dimensiones
        if (matriz2.obtenerRenglones() == obtenerRenglones() &&
            matriz2.obtenerColumnas() == obtenerColumnas()){ // Mismas dimensiones

            Object obj1, obj2;

            for (int indexFila = 0; indexFila < filasDim; indexFila++){

                for (int indexColumna = 0; indexColumna < columnasDim; indexColumna++){
                    // Checamos dato por dato, si alguno no es igual retornamos falso
                    obj1 = datos[indexFila][indexColumna];
                    obj2 = matriz2.obtener(indexFila, indexColumna);
                    if (obj1.toString().equalsIgnoreCase(obj2.toString()) == false){
                        return false;
                    }
                }
            }
            return true;

        } else {
            return false;
        }
    }

    // 12. Este metodo convierte la matriz actual en un vectorColumna con los datos y filas especificadas
    public boolean vectorColumna(int filas, Object info){
        if (filas > 0){ // Es por lo menos una fila y no es negativo el numero
            columnasDim = 1;
            filasDim = filas;

            Object datos2[][] = new Object[filasDim][columnasDim];
            datos = datos2;

            rellenar(info);

            return true;
        } else {
            return false;
        }
    }

    // 13. Este metodo convierte la matriz actual en un vectorRenglon con los datos y columnas especificadas
    public boolean vectorRenglone(int columnas, Object info){
        if (columnas > 0){ // Es por lo menos una columna y no es negativo el numero
            columnasDim = columnas;
            filasDim = 1;

            Object datos2[][] = new Object[filasDim][columnasDim];
            datos = datos2;

            rellenar(info);

            return true;
        } else {
            return false;
        }
    }

    // 14. Este metodo crea/redimensiona/substituye la tabla actual por la pasada como argumento
    public boolean redefinir(Arreglo2D matriz2){
        columnasDim = matriz2.obtenerColumnas();
        filasDim = matriz2.obtenerRenglones();

        datos = matriz2.getDatos();
        return true;
    }

    public Object[][] getDatos() {
        return datos;
    }

    // 15. Este metodo agrega un renglon nuevo y vacio al final de la tabla
    public boolean agregarRenglon(Arreglo arr){
        if (arr.capacidad() <= columnasDim){ // Si cabe aunque no complete to do el renglon
            filasDim++;
            Object datos2[][] = new Object[filasDim][columnasDim];

            // Copiamos lo mismitos datos que ya tenía la tabla original
            for (int indexFila = 0; indexFila < filasDim - 1; indexFila++){

                for (int indexColumna = 0; indexColumna < columnasDim; indexColumna++){
                    datos2[indexFila][indexColumna] = datos[indexFila][indexColumna];
                }
            }

            // Agregamos el ultimo renglon
            for (int indexColumna = 0; indexColumna < arr.capacidad(); indexColumna++){
                datos2[filasDim - 1][indexColumna] = arr.obtener(indexColumna);
            }

            // Reasignamos
            datos = datos2;
            return true;
        } else {
            return false;
        }
    }

    // 16. Este metodo agrega una columna nueva y vacia al final de la tabla
    public boolean agregarColumna(Arreglo arr){
        if (arr.capacidad() <= filasDim){ // Si cabe aunque no complete to do el renglon
            columnasDim++;
            Object datos2[][] = new Object[filasDim][columnasDim];

            // Copiamos lo mismitos datos que ya tenía la tabla original
            for (int indexFila = 0; indexFila < filasDim; indexFila++){

                for (int indexColumna = 0; indexColumna < columnasDim - 1; indexColumna++){
                    datos2[indexFila][indexColumna] = datos[indexFila][indexColumna];
                }
            }

            // Agregamos los datos a la ultima columna
            for (int indexFila = 0; indexFila < arr.capacidad(); indexFila++){
                datos2[indexFila][columnasDim - 1] = arr.obtener(indexFila);
            }

            // Reasignamos
            datos = datos2;
            return true;
        } else {
            return false;
        }
    }

    // 20. Este metodo retorna la matriz en forma de un vector columna
    public Arreglo2D aVectorColumna(){
        int columnas2, filas2;
        columnas2 = 1;
        filas2 = filasDim * columnasDim;
        Arreglo2D datos2 = new Arreglo2D(filas2, columnas2);

        // Llenar este nuevo vector
        int filaDatos2 = 0;

        for (int indexColumna = 0; indexColumna < columnasDim; indexColumna++){

            for (int indexFila = 0; indexFila < filasDim; indexFila++){
                datos2.cambiar(
                        filaDatos2,
                        0,
                        datos[indexFila][indexColumna]
                );

                filaDatos2++;
            }
        }

        return datos2;
    }

    // 21. Este metodo retorna la matriz en forma de un vector renglon
    public Arreglo2D aVectorRenglon(){
        int columnas2, filas2;
        columnas2 = filasDim * columnasDim;
        filas2 = 1;
        Arreglo2D datos2 = new Arreglo2D(filas2, columnas2);

        // Llenar este nuevo vector
        int columnaDatos2 = 0;

        for (int indexFila = 0; indexFila < filasDim; indexFila++){

            for (int indexColumna = 0; indexColumna < columnasDim; indexColumna++){
                datos2.cambiar(
                        0,
                        columnaDatos2,
                        datos[indexFila][indexColumna]
                );

                columnaDatos2++;
            }
        }

        return datos2;
    }

    // 22. Este metodo quita la primer o ultima columna segun se indique en el TipoColumna
    public boolean quitarColumna(TipoColumna tipoCol){
        if (tipoCol.getCodigo() == TipoColumna.IZQUIERDA.getCodigo()){
            return eliminarColumna(0); // Eliminamos la izquierda
        } else {
            return eliminarColumna(columnasDim - 1); // La de la derecha
        }
    }


    // 23. Este metodo quita el primer o último renglon según se indique en el TipoRenglon
    public boolean quitarRenglon(TipoRenglon tipoRenglon){
        if (tipoRenglon.getCodigo() == TipoRenglon.SUPERIOR.getCodigo()){
            return eliminarRenglon(0); // Eliminamos el superior
        } else {
            return eliminarRenglon(filasDim - 1); // Eliminamos el inferior
        }
    }

    // 24. Este metodo elimina el renglon indicado
    public boolean eliminarRenglon(int fila){
        if (esFilaValida(fila) == true){

            // Creamos una nueva tabla
            filasDim--;
            Object datos2[][] = new Object[filasDim][columnasDim];

            // Recorremos toda la tabla pero nos saltamos esa fila que eliminaremos
            int offset = 0;



            for (int indexFila = 0; indexFila < filasDim + 1; indexFila++){
                if (indexFila == fila){ // Nos saltamos esa fila y el offset lo aumentamos
                    // para indicar que ahora estan desfazadas las columnas por 1 columna
                    offset++;
                    continue;
                }
                for (int indexColumna = 0; indexColumna < columnasDim; indexColumna++){
                    datos2[indexFila - offset][indexColumna] = datos[indexFila][indexColumna];
                }
            }

            datos = datos2;
            return true;
        } else {
            return false;
        }
    }

    // 25. Este metodo elimina la columna indicada
    public boolean eliminarColumna(int columna){
        if (esColumnaValida(columna) == true){

            // Creamos una nueva tabla
            columnasDim--;
            Object datos2[][] = new Object[filasDim][columnasDim];

            // Recorremos toda la tabla pero nos saltamos esa columna que eliminaremos
            int offset = 0;

            for (int indexColumna = 0; indexColumna < columnasDim + 1; indexColumna++){
                if (indexColumna == columna){ // Nos saltamos esa columna y el offset lo aumentamos
                    // para indicar que ahora estan desfazadas las columnas por 1 columna
                    offset++;
                    continue;
                }

                for (int indexFila = 0; indexFila < filasDim; indexFila++){
                    datos2[indexFila][indexColumna - offset] = datos[indexFila][indexColumna];
                }
            }

            datos = datos2;
            return true;
        } else {
            return false;
        }
    }
}








