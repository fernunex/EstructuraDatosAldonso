package ednolineal;

import edlineal.ArregloNumerico;
import tools.enumerados.TipoLogaritmo;
import tools.enumerados.TipoOrdenamiento;

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
    public Integer obtener(int fila, int col) {
        return (int) super.obtener(fila, col);
    }

    // Este metodo guarda solo numeros en el arreglo 2d numerico en la posicion indicada
    @Override
    public boolean cambiar(int fila, int col, Object valor) {
        if (valor instanceof Number){
            return super.cambiar(fila, col, valor);
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


    // Punto 9
    // Este metodo le suma a la matriz actual una recibida por argumentos
    public boolean sumar(Arreglo2DNumerico matriz2){
        if (filasDim == matriz2.obtenerRenglones() && columnasDim == matriz2.obtenerColumnas()){

            for (int indexFila = 0; indexFila < filasDim; indexFila++){
                for (int indexCol = 0; indexCol < columnasDim; indexCol++){
                    cambiar(indexFila, indexCol, obtener(indexFila, indexCol) + matriz2.obtener(indexFila, indexCol));
                }
            }
            return true;
        } else {
            return false;
        }
    }

    protected boolean esCuadrada(){
        if (filasDim == columnasDim){
            return true;
        } else {
            return false;
        }
    }

    // Punto 10
    // Este metodo le aplica una potencia especificada a cada elemento de la matriz
    public boolean aplicarPotencia(Number escalar){

        double exponente = (double) escalar;

        if (columnasDim > 0 && filasDim > 0){ // Tiene elementos la matriz

            for (int indexFila = 0; indexFila < filasDim; indexFila++){ // Recorremos cada elemento
                for (int indexCol = 0; indexCol < columnasDim; indexCol++){
                    cambiar(indexFila, indexCol,
                            Math.pow(obtener(indexFila, indexCol), exponente) // Aplicamos la potencia
                    );
                }
            }
            return true;
        }{
            return false;
        }
    }


    // Punto 11
    // Este metodo le aplica un logaritmo especificado a cada uno de los elementos
    public boolean aplicarLogaritmo(TipoLogaritmo tipoLogaritmo){
        // Verificar que no contenga 0s la matriz
        for (int indexFila = 0; indexFila < filasDim; indexFila++){
            for (int indexCol = 0; indexCol < columnasDim; indexCol++){
                if (obtener(indexFila, indexCol) == 0){
                    return false; // Hay un cero entonces terminamos el metodo
                }
            }
        }

        // Recorremos todos los elementos y le aplicamos el logaritmo correspondiente
        for (int indexFila = 0; indexFila < filasDim; indexFila++){
            for (int indexCol = 0; indexCol < columnasDim; indexCol++){

                if (TipoLogaritmo.NATURAL == tipoLogaritmo){
                    cambiar(indexFila, indexCol,
                            Math.log(obtener(indexFila, indexCol))
                    ); // Aplicamos el logaritmo
                } else if (TipoLogaritmo.BASE_2 == tipoLogaritmo) {
                    // Aplicamos la regla del logaritmo de cambio de base
                    cambiar(indexFila, indexCol,
                            Math.log(obtener(indexFila, indexCol)) / Math.log(2.0)
                    ); // Aplicamos el logaritmo
                } else if (TipoLogaritmo.BASE_10 == tipoLogaritmo) {
                    cambiar(indexFila, indexCol,
                            Math.log10(obtener(indexFila, indexCol))
                    ); // Aplicamos el logaritmo
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    // Punto 12
    // Este metodo convierte en matriz diagonal la matriz actual solo si es cuadrada y le agrega el contenido especificado.
    public boolean matrizDiagonal(Number contenido){
        if (columnasDim > 0 && filasDim > 0){
            if (esCuadrada() == true){
                rellenar(0.0); // La inicializamos con zeros

                for (int indexFila = 0; indexFila < filasDim; indexFila++){ // Recorremos cada elemento de la diagonal
                    cambiar(indexFila, indexFila, contenido); // le colocamos el contenido
                }
                return true;

            } else { // Si no es cuadrada no jala
                return false;
            }
        } else {
            return false;
        }
    }

    // Punto 13
    // Este metodo comprueba si una matriz es diagonal superior. Es decir, todos los elementos bajo la diagonal deben ser
    // cero. Si no es cuadrada retorna falso
    public boolean esDiagonalSuperior(){
        if (esCuadrada() == true){
            int columnasDeep = 1;
            for (int indexFila = 1; indexFila < filasDim; indexFila++){
                for (int indexColumna = 0; indexColumna < columnasDeep; indexColumna++){
                    if (obtener(indexFila, indexColumna) != 0.0){
                        return false; // Encontro uno que no es cero. Termina el metodo
                    }
                }
                columnasDeep++;
            }
            return true; // No encontro alguno que fuera diferente de 0

        } else {
            return false;
        }
    }

    // Punto 14
    // Este metodo comprueba si una matriz es diagonal inferior. Es decir, todos los elementos arriba de la diagonal deben ser
    // cero. Si no es cuadrada retorna falso
    public boolean esDiagonalInferior(){
        if (esCuadrada() == true){
            int columnasDeep = 1;
            for (int indexFila = 0; indexFila - 1 < filasDim; indexFila++){
                for (int indexColumna = columnasDeep; indexColumna < columnasDim; indexColumna++){
                    if (obtener(indexFila, indexColumna) != 0.0){
                        return false; // Encontro uno que no es cero. Termina el metodo
                    }
                }
                columnasDeep++;
            }
            return true; // No encontro alguno que fuera diferente de 0

        } else {
            return false;
        }
    }


    // Punto 15
    // Este metodo aplica la potencia de una matriz elevada a un exponente
    public boolean potencia(int exponente){
        if (esCuadrada()){
            Arreglo2D matrizClon = super.clonar();
            Arreglo2DNumerico matrizNumCol = new Arreglo2DNumerico(1,1);
            matrizNumCol.redefinir(matrizClon);

            for (int numItera = 1; numItera < exponente; numItera++){
                multiplicar(matrizNumCol);
            }
            return true;

        } else {
            return false;
        }
    }

    // Punto 16
    // Este metodo redimensiona la matriz sumado por columanas de dos en dos.
    public boolean doblarRenglones(){
        if (columnasDim <= 1){ // Debe haber mas de 1 columna para poder doblar
            return false;
        }

        int dobladoColumns = Math.ceilDiv(columnasDim, 2); // Retorna la division entre 2 redondeando hacia arriba

        boolean esPar;
        if ((columnasDim % 2) == 0){
            esPar = true;
        } else {
            esPar = false;
        }

        Arreglo2DNumerico arrDoblado = new Arreglo2DNumerico(filasDim, dobladoColumns);
        int indexInsert = 0; // Lleva el registro de en cual columna del arrDoblado se insertara la columna

        double datoColum1, datoColum2; // Guardaran los datos de la columna n y n+1 al realizar la suma

        dobladoColumns--; // Para corregir el indice en arreglos ya que empiezan en 0
        for (int indexCol = 0; indexCol < columnasDim; indexCol += 2){
            if ((esPar == false) && (indexCol == dobladoColumns || (indexCol + 1) == dobladoColumns)){
                if (indexCol == dobladoColumns){ // Lo pasamos directo y restamos 1 a indexCol ya que no se fusionaron 2 columnas
                    for (int indexFila = 0; indexFila < filasDim; indexFila++){
                        arrDoblado.cambiar(indexFila, indexInsert, obtener(indexFila, indexCol));
                    }
                    indexInsert++;
                    indexCol--;
                } else { // Realizamos la suma de la col y col + 2, despues insertamos la col + 1
                    for (int indexFila = 0; indexFila < filasDim; indexFila++){ // Col + (col + 2)
                        datoColum1 = obtener(indexFila, indexCol);
                        datoColum2 = obtener(indexFila, indexCol + 2);
                        arrDoblado.cambiar(indexFila, indexInsert, datoColum1 + datoColum2);
                    }
                    indexInsert++;

                    for (int indexFila = 0; indexFila < filasDim; indexFila++){// Insertamos la columna col + 1
                        arrDoblado.cambiar(indexFila, indexInsert, obtener(indexFila, indexCol + 1));
                    }
                    indexInsert++;
                    indexCol++;
                }
            } else { // Si es par, entonces simplemente iteramos cada columna, sumamos la columna n + columna (n+1) e insertamos
                for (int indexFila = 0; indexFila < filasDim; indexFila++){ // Col + (col + 1)
                    datoColum1 = obtener(indexFila, indexCol);
                    datoColum2 = obtener(indexFila, indexCol + 1);
                    arrDoblado.cambiar(indexFila, indexInsert, datoColum1 + datoColum2);
                }
                indexInsert++;
            }
        }
        redefinir(arrDoblado);
        return true;
    }

    // Punto 17
    // Este metodo redimnsiona la matriz sumando por filas de dos en dos.
    public boolean doblarColumnas(){
        if (filasDim <= 1){ // Debe haber mas de 1 fila para poder doblar
            return false;
        }

        int dobladoFilas = Math.ceilDiv(filasDim, 2); // Retorna la division entre 2 redondeando hacia arriba

        boolean esPar;
        if ((filasDim % 2) == 0){
            esPar = true;
        } else {
            esPar = false;
        }

        Arreglo2DNumerico arrDoblado = new Arreglo2DNumerico(dobladoFilas, columnasDim);
        int indexInsert = 0; // Lleva el registro de en cual fila del arrDoblado se insertara la fila

        double datoColum1, datoColum2; // Guardaran los datos de la columna n y n+1 al realizar la suma

        dobladoFilas--; // Para corregir el indice en arreglos ya que empiezan en 0
        for (int indexFila = 0; indexFila < filasDim; indexFila += 2){
            if ((esPar == false) && (indexFila == dobladoFilas || (indexFila + 1) == dobladoFilas)){
                if (indexFila == dobladoFilas){ // Lo pasamos directo y restamos 1 a indexFila ya que no se fusionaron 2 filas
                    for (int indexCol = 0; indexCol < columnasDim; indexCol++){
                        arrDoblado.cambiar(indexInsert, indexCol, obtener(indexFila, indexCol));
                    }
                    indexInsert++;
                    indexFila--;
                } else { // Realizamos la suma de la fila y fila + 2, despues insertamos la fila + 1
                    for (int indexCol = 0; indexCol < columnasDim; indexCol++){ // fila + (fila + 2)
                        datoColum1 = obtener(indexFila, indexCol);
                        datoColum2 = obtener(indexFila + 2, indexCol);
                        arrDoblado.cambiar(indexInsert, indexCol, datoColum1 + datoColum2);
                    }
                    indexInsert++;

                    for (int indexCol = 0; indexCol < columnasDim; indexCol++){// Insertamos la fila + 1
                        arrDoblado.cambiar(indexInsert, indexCol, obtener(indexFila + 1, indexCol));
                    }
                    indexInsert++;
                    indexFila++;
                }
            } else { // Si es par, entonces simplemente iteramos cada fila, sumamos la fila n + fila (n+1) e insertamos
                for (int indexCol = 0; indexCol < columnasDim; indexCol++){ // fila + (fila + 1)
                    datoColum1 = obtener(indexFila, indexCol);
                    datoColum2 = obtener(indexFila + 1, indexCol);
                    arrDoblado.cambiar(indexInsert, indexCol, datoColum1 + datoColum2);
                }
                indexInsert++;
            }
        }
        redefinir(arrDoblado);
        return true;
    }

}
