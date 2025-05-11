package edlineal;

import edlineal.auxiliares.NodoClaveValor;
import ednolineal.Arreglo2D;
import entradasalida.Salida;

public class ListaDinClave implements ListaDatos{
    protected NodoClaveValor primero;
    protected NodoClaveValor ultimo;
    protected NodoClaveValor iterador;

    public ListaDinClave() {
        this.primero = null;
        this.ultimo = null;
    }


    // a)
    // Este metodo inserta un nodo al final de la lista, si ya se encuentra una
    // ocurrencia con la misma clave, entonces remplaza el valro
    public boolean poner(Object clave, Object valor){
        if (vacia() == true) {
            NodoClaveValor nuevo = new NodoClaveValor(clave, valor);
            primero = nuevo;
            ultimo = nuevo;
            return true;
        } else {
            NodoClaveValor buscado = buscarNodo(clave);
            if (buscado != null){ // ya existe
                buscado.setValor(valor);
                return true;
            } else {
                NodoClaveValor nuevo = new NodoClaveValor(clave, valor);
                ultimo.setLigaDer(nuevo);
                ultimo = nuevo;
                nuevo.setLigaDer(null);
                return true;
            }
        }
    }

    // b)
    // Este metodo remueve un nodo buscado por su clave
    @Override
    public Object quitar(Object clave) {
        NodoClaveValor sombra = null;
        iniciaIterador();
        while (iteradorValido()){
            sombra = iterador;
            moverIterador();
            if (iterador.getClave().toString().equalsIgnoreCase(clave.toString())){
                break;
            }
        }

        if (iteradorValido()){ // lo encontramos
            if (iterador == primero){
                primero = iterador.getLigaDer();
            } else if (iterador == ultimo) {
                ultimo = sombra;
                ultimo.setLigaDer(null);
            } else { // Esta enmedio de dos nodos
                sombra.setLigaDer(iterador.getLigaDer());
            }
            return obtenerIterador();
        } else { // No lo encontramos
            return null;
        }
    }

    // c)
    // Este metodo remueve un nodo buscado por su valor
    public Object quitarContenido(Object valor){
        NodoClaveValor sombra = null;
        iniciaIterador();
        while (iteradorValido()){
            sombra = iterador;
            moverIterador();
            if (iterador.getValor().toString().equalsIgnoreCase(valor.toString())){
                break;
            }
        }

        if (iteradorValido()){ // lo encontramos
            if (iterador == primero){
                primero = iterador.getLigaDer();
            } else if (iterador == ultimo) {
                ultimo = sombra;
                ultimo.setLigaDer(null);
            } else { // Esta enmedio de dos nodos
                sombra.setLigaDer(iterador.getLigaDer());
            }
            return obtenerIterador();
        } else { // No lo encontramos
            return null;
        }
    }

    // d)
    // Este metodo busca un nodo buscado por su clave y devuelve su contenido
    @Override
    public Object buscar(Object clave) {
        iniciaIterador();
        while (iteradorValido()){
            if (iterador.getClave().toString().equalsIgnoreCase(clave.toString())){ // lo encontro
                return obtenerIterador();
            }
            moverIterador();
        }
        return null; // solo si no lo encuentra
    }

    // e)
    // Este metodo busca un nodo buscado por su valor y devuelve su contenido
    public Object buscarContenido(Object valor){
        iniciaIterador();
        while (iteradorValido()){
            if (iterador.getValor().toString().equalsIgnoreCase(valor.toString())){ // lo encontro
                return obtenerIterador();
            }
            moverIterador();
        }
        return null; // solo si no lo encuentra
    }

    // Este metodo busca un nodo por su valor y lo retorna
    protected NodoClaveValor buscarNodoContenido(Object valor){
        iniciaIterador();
        while (iteradorValido()){
            if (iterador.getValor().toString().equalsIgnoreCase(valor.toString())){ // lo encontro
                return iterador;
            }
            moverIterador();
        }
        return null; // solo si no lo encuentra
    }

    // Este metodo busca un nodo por su clave
    protected NodoClaveValor buscarNodo(Object clave){
        iniciaIterador();
        while (iteradorValido()){
            if (iterador.getClave().toString().equalsIgnoreCase(clave.toString())){ // lo encontro
                return iterador;
            }
            moverIterador();
        }
        return null; // solo si no lo encuentra
    }

    // f)
    // Este metodo cambia un nodo por su valor viejo a uno nuevo, primero busca un match con la clave y despues actualiza
    public boolean cambiar(Object clave, Object valor){
        NodoClaveValor buscado = buscarNodo(clave);
        if (buscado != null){
            buscado.setValor(valor);
            return true;
        } else {
            return false;
        }
    }

    // f)
    // Este metodo cambia un nodo por su valor viejo a uno nuevo, primero busca un match con el valor viejo y lo remplaza
    public boolean cambiarValor(Object valorViejo, Object valorNuevo){
        NodoClaveValor buscado = buscarNodoContenido(valorViejo);
        if (buscado != null){
            buscado.setValor(valorNuevo);
            return true;
        } else {
            return false;
        }
    }

    // g)
    // Este metodo imprime la lista
    @Override
    public void imprimir() {
        if (vacia() == true){
            Salida.salidaPorDefecto("null");
        } else {
            iniciaIterador();
            while (iteradorValido()){
                Salida.salidaPorDefecto(
                        "(" + iterador.getClave() + ")(" + iterador.getValor() + ") --> "
                );
                moverIterador();
            }
            Salida.salidaPorDefecto("null");
        }
    }

    // h)
    // Este metodo imprime las claves de la lista
    public void imprimirClaves() {
        if (vacia() == true){
            Salida.salidaPorDefecto("null");
        } else {
            iniciaIterador();
            while (iteradorValido()){
                Salida.salidaPorDefecto(
                        "(" + iterador.getClave() + ") --> "
                );
                moverIterador();
            }
            Salida.salidaPorDefecto("null");
        }
    }

    // i)
    // Este metodo imprime los valores de la lista
    public void imprimirValores() {
        if (vacia() == true){
            Salida.salidaPorDefecto("null");
        } else {
            iniciaIterador();
            while (iteradorValido()){
                Salida.salidaPorDefecto(
                        "(" + iterador.getValor() + ") --> "
                );
                moverIterador();
            }
            Salida.salidaPorDefecto("null");
        }
    }

    // j)
    // Este metodo retorna un Arreglo con unos Arreglos paralelos con su clave y valor en dos Arreglos
    public Arreglo aListaEstatica(){
        Arreglo lisRes = new Arreglo(2);
        int cantidadElementos = cantidad();
        Arreglo claves = new Arreglo(cantidadElementos);
        Arreglo valores = new Arreglo(cantidadElementos);

        iniciaIterador();
        while (iteradorValido()){
            claves.poner(iterador.getClave());
            valores.poner(iterador.getValor());
            moverIterador();
        }

        lisRes.poner(claves);
        lisRes.poner(valores);
        return lisRes;
    }

    // k)
    // Este metodo retorna una ListaDin con unas ListasDin paralelas con su clave y valor en dos ListasDin
    public ListaDin aListaDinamica(){
        ListaDin lisRes = new ListaDin();
        ListaDin claves = new ListaDin();
        ListaDin valores = new ListaDin();

        iniciaIterador();
        while (iteradorValido()){
            claves.poner(iterador.getClave());
            valores.poner(iterador.getValor());
            moverIterador();
        }

        lisRes.poner(claves);
        lisRes.poner(valores);
        return lisRes;
    }

    // l)
    // Este metodo coloca en la primer columna de la matriz las claves y en la segunda los valores
    public Arreglo2D aMatriz2D(){
        int cantidadElementos = cantidad();
        Arreglo2D mat = new Arreglo2D(cantidadElementos,2);

        int fila = 0;
        iniciaIterador();
        while (iteradorValido()){
            mat.cambiar(fila, 0, iterador.getClave());
            mat.cambiar(fila, 1, obtenerIterador());
            fila++;
            moverIterador();
        }

        return mat;
    }

    // m)
    @Override
    public void vaciar() {
        primero = null;
        ultimo = null;
    }

    // n)
    // Retorna el contenido del objeto buscao por su clave
    public Object obtener(Object clave){
        return buscar(clave);
    }

    // o)
    // Indica si la lista actual esta vacia
    @Override
    public boolean vacia() {
        if (primero == null){
            return true;
        } else {
            return false;
        }
    }

    // p)
    // Este metodo agrega una ListaDinClave a la actual solo si no se repiten las claves, si se repiten entonces
    // no agrega nada y retorna falso
    public boolean agregarLista(ListaDinClave lista2){
        // Checamos si se repiten
        lista2.iniciaIterador();
        while (lista2.iteradorValido()){
            if (buscar(lista2.iterador.getClave()) != null){ // Encontro uno igual
                return false;
            }
            lista2.moverIterador();
        }

        // No hay repetidos
        lista2.iniciaIterador();
        while (lista2.iteradorValido()){
            poner(lista2.iterador.getClave(), lista2.obtenerIterador());
            lista2.moverIterador();
        }
        return true;
    }

    // q)
    // Este metodo indica la cantidad de elementos en la lista dinamica
    public int cantidad(){
        int cant = 0;
        iniciaIterador();
        while (iteradorValido()){
            cant++;
            moverIterador();
        }
        return cant;
    }

    // r)
    // Este metodo agrega unos arreglos paralelos a la lista actual
    public boolean agregarArreglo(Arreglo arregloClaves, Arreglo arregloValores){
        // Checamos que no se repitan
        for (int arrIndex = 0; arrIndex < arregloClaves.capacidad(); arrIndex++){
            if (buscar(arregloClaves.obtener(arrIndex)) != null){ // Encontro uno igual
                return false;
            }
        }

        // No se repiten, entonces agregamos
        for (int arrIndex = 0; arrIndex < arregloClaves.capacidad(); arrIndex++){
            poner(arregloClaves.obtener(arrIndex),
                    arregloValores.obtener(arrIndex));
            }
        return true;
    }

    // s)
    // Este metodo agrega a la lista actual dos listas paralelas con las clave y sus valores solo si no se encuentran
    // en la actual
    public boolean agregarListaDinamicas(ListaDin claves, ListaDin valores){
        // Checamos que no haya claves repetidas
        claves.iniciaIterador();
        while (claves.iteradorValido()){
            if (buscar(claves.obtenerIterador()) != null){ // Encontro uno igual
                return false;
            }
            claves.moverIterador();
        }

        // No hay repetidos
        claves.iniciaIterador();
        valores.iniciaIterador();
        while (claves.iteradorValido()){
            poner(claves.obtenerIterador(),
                    valores.obtenerIterador());
            claves.moverIterador();
            valores.moverIterador();
        }
        return true;
    }

    // t)
    // Este metodo agrega una matriz en la cual su primer columna contiene las claves y en el segunda contiene
    // los valores a la lista acutal solo si no hay claves repetidas.
    public boolean agregarMatriz2D(Arreglo2D matriz){
        if (matriz.obtenerColumnas() != 2){ // No se puede agregar la matriz
            return false;
        } else {
            // Checamos is hay repetidos
            for (int indexFila = 0; indexFila < matriz.obtenerRenglones(); indexFila++){
                if (buscar(matriz.obtener(indexFila, 0)) != null){ // Encontro uno igual
                    return false;
                }
            }

            // No se repiten, entonces agregamos
            for (int indexFila = 0; indexFila < matriz.obtenerRenglones(); indexFila++){
                poner(matriz.obtener(indexFila,0),
                        matriz.obtener(indexFila, 1));
            }
            return true;
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

    // Retorna  el valor del iterador o del nodo
    @Override
    public Object obtenerIterador() {
        if (iteradorValido() == true){
            return iterador.getValor();
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



    @Override
    public Integer poner(Object valor) {
        return 0;
    }





    @Override
    public void imprimirDes() {

    }

    @Override
    public Object quitar() {
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
        return null;
    }

    @Override
    public Integer ponerInicio(Object valor) {
        return 0;
    }
}
