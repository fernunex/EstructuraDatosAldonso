package edlineal;

import edlineal.auxiliares.Nodo;
import edlineal.auxiliares.NodoABuscar;
import ednolineal.Arreglo2D;
import entradasalida.Salida;

public class ListaDin implements ListaDatos{
    protected Nodo primero;
    protected Nodo ultimo;

    protected Nodo iterador;

    public ListaDin(){
        this.primero = null;
        this.ultimo = null;

        this.iterador = null;
    }


    // Este metodo checa si esta vacia la lista
    @Override
    public boolean vacia() {
        if (primero == null){
            return true;
        } else {
            return false;
        }
    }

    // Este metodo agrega un nodo al inicio de la lista
    @Override
    public Integer ponerInicio(Object valor) {

        Nodo nuevoNodo = new Nodo(valor); // Paso de crear el espacio de memoria

        // Validar si existe un error en memoria llena.
        if (nuevoNodo != null){

            if (vacia() == true){ // Esta vacia, por lo tanto sera el principio y el final
                this.primero = nuevoNodo;
                this.ultimo = nuevoNodo;
            } else {
                nuevoNodo.setLigaDer(this.primero);
                this.primero = nuevoNodo;
            }
            return 0;
        } else { // error no hay memoria
            return -1;
        }
    }

    @Override
    public void iniciaIterador() {
        iterador = primero;
    }

    @Override
    public boolean iteradorValido() {
        if (iterador == null){
            return false;
        } else {
            return true;
        }
    }

    @Override
    public Object obtenerIterador() {
        if (iteradorValido() == true){
            return iterador.getDato();
        } else {
            return null;
        }
    }

    @Override
    public void moverIterador() {
        if (iteradorValido() == true){
            iterador = iterador.getLigaDer();
        }
    }

    // Este metodo inserta un elemento al final de la lista
    @Override
    public Integer poner(Object valor) {
        Nodo nuevoNodo = new Nodo(valor);

        // Verificamos memoria
        if (nuevoNodo != null){
            if (vacia() == true){ // a) Esta vacia, por lo tanto primero y ultimo son lo mismo
                primero = nuevoNodo;
                ultimo = nuevoNodo;
            } else { // b) Ahora el ultimo actual apunta a nuevoNodo y se convierte en el ultimo
                ultimo.setLigaDer(nuevoNodo);
                ultimo = nuevoNodo;
            }
            return 0;
        } else { // error memoria
            return -1;
        }

    }

    @Override
    public Object buscar(Object valor) {
        return null;
    }

    // Este metodo imprime la lista.
    @Override
    public void imprimir() {
        Nodo temporal = primero;
        Object info;

        while (temporal != null){
            info = temporal.getDato();
            Salida.salidaPorDefecto(info + " --> ");
            temporal = temporal.getLigaDer();
        }
        Salida.salidaPorDefecto("null");
    }

    // Este metodo imprime en orden inverso la ListaDinamica
    @Override
    public void imprimirDes() {
        PilaDinamica miPila = new PilaDinamica();

        iniciaIterador();
        while (iteradorValido()){ // Mientras haya nodos
            miPila.poner(obtenerIterador());
            moverIterador();
        }

        // Imprimimos la pila simplemente
        miPila.imprimir();
    }

    // Este metodo busca un nodo
    public NodoABuscar buscarNodo(Object valor){
        Nodo anterior = primero;
        Nodo encontrado = primero;

        while (encontrado != null &&
                valor.toString().equalsIgnoreCase(encontrado.getDato().toString()) == false) {
            anterior = encontrado;
            encontrado = encontrado.getLigaDer();
        }

        if (encontrado != null){ // Encontro algo
            return new NodoABuscar(anterior, encontrado);
        } else { // Si no encontro nada, regreso null
            return null;
        }



    }

    // Este metodo elimina el elemento del final
    @Override
    public Object quitar(){
        if (vacia() == false){
            Object respaldo = ultimo.getDato();
            if (primero == ultimo){
                primero = null;
                ultimo = null;
            } else {
                NodoABuscar busqueda = buscarNodo(ultimo.getDato());
                busqueda.getAnterior().setLigaDer(null);
                ultimo = busqueda.getAnterior();
            }
            return respaldo;
        } else {
            return null;
        }
    }

    // Busca un elemento en la lista y me lo regresa
    public Object buscarObjeto(Object valor){
        NodoABuscar nodoBuscado = buscarNodo(valor);
        if (nodoBuscado != null){
            return nodoBuscado.getEncontrado().getDato();
        } else {
            return null;
        }
    }

    // Métodos de la práctica ----------------------------------------------------

    // Este metodo devuelve todas las occurencias de un valor dado.
    public ListaDin encontrarLista(Object valor){
        ListaDin listaEncontrados = new ListaDin();

        iniciaIterador();
        while (iteradorValido()){
            if ((obtenerIterador()).toString().equalsIgnoreCase(valor.toString())){
                listaEncontrados.poner(obtenerIterador());
            }
            moverIterador();
        }

        return listaEncontrados;
    }

    // Este metodo devuelve una lista estatica de la lista dinámica actual
    public Arreglo aListaEstatica(){
        Arreglo arr = new Arreglo(noElementos());

        // Llenando el arreglo
        iniciaIterador();
        while (iteradorValido()){
            arr.poner(obtenerIterador());
            moverIterador();
        }

        return arr;
    }

    // Este metodo cuenta cuantos elementos hay en la lista dinamica actual
    private int noElementos(){
        int num = 0;
        iniciaIterador();
        while (iteradorValido()){
            num++;
            moverIterador();
        }
        return num;
    }


    // Este metodo devuelve un arreglo con todos los elementos de la lista dinámica actual
    // excepto aquellos que sean indicados en el arreglo de elementos a descartar
    public Arreglo aListaEstatica(Arreglo elementosADescartar){
        Arreglo arr = new Arreglo(noElementos());
        int elementosAdded = 0;

        iniciaIterador();
        while (iteradorValido()){
            if ((int) elementosADescartar.buscar(obtenerIterador()) == -1){ // No se encuentra en elementosADescartar
                arr.poner(obtenerIterador());
                elementosAdded++;
            }
            moverIterador();
        }

        arr.redimensionar(elementosAdded); // Lo redimensionamos a los elementos que finalmenete sí fueron añadidos
        return arr;
    }

    // Este metodo convierte la lista dinámica actual a una matriz 2D con un numero de filas y columnas indicadas
    public Arreglo2D aMatriz2D(int filas, int columanas){
        // 1. Validar dimensiones
        if (filas > 0 && columanas > 0){ // Dimensiones válidas
            Arreglo2D arr2d = new Arreglo2D(filas, columanas, null);

            iniciaIterador();
            for (int filasIndex = 0; filasIndex < filas; filasIndex++){
                for (int colIndex = 0; colIndex < columanas; colIndex++){
                    if (iteradorValido()){
                        arr2d.cambiar(filasIndex, colIndex, obtenerIterador());
                        moverIterador();
                    } else { // El arreglo 2d esta inicializado con nulos. Si ya no hay datos en la lista dinámica
                        // simplemente retornamos
                        return arr2d;
                    }
                }
            }
            return arr2d;

        } else {
            return null;
        }
    }


    @Override
    public Object quitar(Object valor) {
        return null;
    }

    public Object quitar(int indice){
        if (vacia() == true){
            return null;
        } else {
            if (indice == 0){
                primero = primero.getLigaDer();
            } else {
                iniciaIterador();
                while (indice > 1 && iteradorValido()){
                    indice--;
                    moverIterador();
                }

                // Si encontramos el indice indicado
                if (indice == 1){ // Estamos en uno al anterior del indice a remover
                    if (iterador.getLigaDer().getLigaDer() == null){ //El que vamos a quitar es el último
                        Nodo backup = iterador.getLigaDer();
                        iterador.setLigaDer(null);
                        ultimo = iterador;
                        return backup.getDato();
                    } else {// No es el último, hay uno intermedio
                        Nodo backup = iterador.getLigaDer();
                        iterador.setLigaDer(iterador.getLigaDer().getLigaDer());
                        return backup.getDato();
                    }
                } else { // No exite ese indice
                    return null;
                }
            }
        }
        return null;
    }

    @Override
    public boolean esIgual(ListaDatos lista2) {
        iniciaIterador();
        lista2.iniciaIterador();

        while (iteradorValido() && lista2.iteradorValido()){
            if (obtenerIterador().toString().equalsIgnoreCase(lista2.obtenerIterador().toString()) == false){
                // Son diferentes, entonces terminamos
                return false;
            }
            moverIterador();
            lista2.moverIterador();
        }

        if (iteradorValido() == lista2.iteradorValido()){// Si ambos iteradores terminaron a la vez
            // entonces son igualitas
            return true;
        } else { // Uno aun tiene datos
            return false;
        }

    }

    // Este metodo modifia un valorViejo por uno nuevo una cantidad indicada de veces
    @Override
    public boolean modificar(Object valorViejo, Object valorNuevo, int numVeces) {
        iniciaIterador();
        boolean flag = false;
        while (numVeces > 0 && iteradorValido()){
            if (obtenerIterador().toString().equalsIgnoreCase(valorViejo.toString())){
                iterador.setDato(valorNuevo);
                flag = true;
                numVeces--;
            }
            moverIterador();
        }
        return flag;
    }

    // Este metodo cambia un elemento en el indice indicado por un valor indicado
    public boolean cambiar(int indice, Object valor){
        iniciaIterador();
        int indexCurrent = 0;
        while (iteradorValido() && indexCurrent != indice){
            moverIterador();
            indexCurrent++;
        }

        if (indexCurrent == indice){ // Si es posible acceder o existe ese indice
            iterador.setDato(valor);
            return true;
        }
        return false; // No existe ese indice en la lista actual.
    }

    // Este metodo obtiene un objeto que se encuentra en el indice indicado
    public Object obtener(int indice){
        iniciaIterador();
        int indexCurrent = 0;
        while (iteradorValido() && indexCurrent != indice){
            moverIterador();
            indexCurrent++;
        }

        if (indexCurrent == indice){ // Si es posible acceder o existe ese indice
            return obtenerIterador();
        }
        return null; // No existe ese indice en la lista actual.
    }


    @Override
    public Arreglo buscarValores(Object valor) {
        return null;
    }

    // Este metodo vacia la lista dinamica actual
    @Override
    public void vaciar() {
        primero = null;
        ultimo = null;
    }

    // Este metodo agrega una lista de datos al final de la lista actual
    @Override
    public boolean agregarLista(ListaDatos lista2) {
        if (lista2.vacia() == true){ // lista2 esta vacia, por lo que no se agrego nada a la lista actual
            return false;
        } else { // Si hay elementos a agregar
            while (lista2.vacia() == false){
                poner(lista2.quitar());
            }
            return true;
        }
    }

    // Este metodo invierte la lista dinamica actual
    @Override
    public void invertir() {
        PilaDinamica pila = new PilaDinamica();

        iniciaIterador();
        while (iteradorValido()){
            pila.poner(obtenerIterador());
            moverIterador();
        }

        vaciar(); // vaciamos la lista actual
        while (pila.vacio() == false){
            poner(pila.quitar());
        }
    }

    // Este metodo cuenta cuantos objetos "valor" se encuentra en la lista dinamica
    // todas las ocurrencias
    @Override
    public int contar(Object valor) {
        int ocurrencias = 0;
        iniciaIterador();
        while (iteradorValido()){
            if (obtenerIterador().toString().equalsIgnoreCase(valor.toString())){
                ocurrencias++;
            }
            moverIterador();
        }

        return ocurrencias;
    }

    @Override
    public boolean borrarLista(ListaDatos lista2) {
        return false;
    }

    // Este medood agrega a la lista una n cantidad de valores valor a la lista
    // Esta no vacia la lista, solo hace un append de esa cantidad de valores
    @Override
    public void rellenar(Object valor, int cantidad) {
        while (cantidad > 0){
            poner(valor);
            cantidad--;
        }
    }

    // Este metodo retorna una ListaDin clonada de la actual
    @Override
    public ListaDatos clonar() {
        ListaDin listaClon = new ListaDin();

        iniciaIterador();
        while (iteradorValido()){
            listaClon.poner(obtenerIterador());
            moverIterador();
        }

        return listaClon;
    }

    @Override
    public ListaDatos subLista(int indiceInicial, int indiceFinal) {
        return null;
    }

    @Override
    public boolean substituir(ListaDatos lista2) {
        return false;
    }

    @Override
    public ListaDatos arregloDesordenado() {
        return null;
    }

    @Override
    public boolean esSublista(ListaDatos lista2) {
        return false;
    }

    @Override
    public boolean modificarLista(ListaDatos lista2, ListaDatos lista2Nuevos) {
        return false;
    }

    @Override
    public boolean retenerLista(ListaDatos lista2) {
        return false;
    }

    @Override
    public boolean poner(int indice, Object valor) {
        return false;
    }

    @Override
    public void rellenar(Object valor) {

    }

    @Override
    public Object verFinal() {
        if (ultimo != null){
            return ultimo.getDato();
        } else {
            return null;
        }
    }

    @Override
    public Object verInicio() {
        if (primero != null){
            return primero.getDato();
        } else {
            return null;
        }
    }


}
