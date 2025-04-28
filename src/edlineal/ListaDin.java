package edlineal;

import edlineal.auxiliares.Nodo;
import edlineal.auxiliares.NodoABuscar;
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

    @Override
    public void imprimirDes() {
        int cantidadElementos = 0;
        Nodo temporal = primero;

        while (temporal != null){
            cantidadElementos++;
            temporal = temporal.getLigaDer();
        }

        // ---------------
        temporal = primero;
        PilaFija pilaElementos = new PilaFija(cantidadElementos);
        while (temporal != null){
            pilaElementos.poner(temporal.getDato());
            temporal = temporal.getLigaDer();
        }

        pilaElementos.imprimir();
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



    @Override
    public Object quitar(Object valor) {
        return null;
    }

    @Override
    public boolean esIgual(ListaDatos lista2) {
        return false;
    }

    @Override
    public boolean modificar(Object valorViejo, Object valorNuevo, int numVeces) {
        return false;
    }

    @Override
    public Arreglo buscarValores(Object valor) {
        return null;
    }

    @Override
    public void vaciar() {

    }

    @Override
    public boolean agregarLista(ListaDatos lista2) {
        return false;
    }

    @Override
    public void invertir() {

    }

    @Override
    public int contar(Object valor) {
        return 0;
    }

    @Override
    public boolean borrarLista(ListaDatos lista2) {
        return false;
    }

    @Override
    public void rellenar(Object valor, int cantidad) {

    }

    @Override
    public ListaDatos clonar() {
        return null;
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
        return null;
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
