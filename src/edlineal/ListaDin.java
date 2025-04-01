package edlineal;

import edlineal.auxiliares.Nodo;
import entradasalida.Salida;

public class ListaDin implements ListaDatos{
    protected Nodo primero;
    protected Nodo ultimo;

    public ListaDin(){
        this.primero = null;
        this.ultimo = null;
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

    @Override
    public Object quitar() {
        return null;
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
}
