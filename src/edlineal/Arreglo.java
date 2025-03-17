package edlineal;

import entradasalida.Salida;

public class Arreglo implements VectorFijo{

    protected int capacidad;
    protected Object datos[];
    protected int indiceSuperior;

    public Arreglo(int tamanio){
        this.capacidad = tamanio;
        this.datos = new Object[this.capacidad];
        this.indiceSuperior = -1;
    }

    @Override
    public boolean vacia() {
        if (indiceSuperior == -1){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Integer poner(Object valor) {
        if (this.lleno() == false){
            this.indiceSuperior++;
            datos[this.indiceSuperior] = valor;
            return indiceSuperior;
        } else {
            return -1;
        }
    }

    @Override
    public Object buscar(Object valor) {
        int recorredor = 0;
        while (recorredor <= this.indiceSuperior &&
                valor.toString().equalsIgnoreCase(datos[recorredor].toString()) == false ){
            recorredor++;
        }

        if (recorredor > this.indiceSuperior){
            return -1;
        } else {
            return recorredor;
        }
    }

    @Override
    public void imprimir() {
        int posicion;
        for (posicion = 0; posicion <= this.indiceSuperior; posicion++){
            Salida.salidaPorDefecto(datos[posicion] + "\n");
        }
    }

    @Override
    public void imprimirDes() {
        int posicion;
        for (posicion = this.indiceSuperior; posicion >= 0; posicion--){
            Salida.salidaPorDefecto(datos[posicion] + "\n");
        }
    }

    @Override
    public Object quitar() {
        if (this.vacia() == false){
            Object datoExtraido;
            datoExtraido = datos[this.indiceSuperior];
            this.indiceSuperior--;
            return datoExtraido;
        } else {
            return null;
        }
    }

    @Override
    public Object quitar(Object valor) {
        int posicion = (int) buscar(valor);

        if (posicion >= 0){
            Object respaldo = this.datos[posicion];

            for (int modificacion = posicion; modificacion <= indiceSuperior - 1; modificacion++){
                datos[modificacion] = datos[modificacion + 1];
            }

            this.indiceSuperior--;
            return respaldo;
        } else {
            return null;
        }
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public Object[] getDatos() {
        return datos;
    }

    public void setDatos(Object[] datos) {
        this.datos = datos;
    }

    public int getIndiceSuperior() {
        return indiceSuperior;
    }

    public void setIndiceSuperior(int indiceSuperior) {
        this.indiceSuperior = indiceSuperior;
    }

    // Este metodo compara dos listas, si son exactamente iguales retorna verdadero
    // de otra manera, falso.
    @Override
    public boolean esIgual(ListaDatos lista2) {
        if (esUnArreglo((lista2)) == false){
            return false;
        } else {
            Arreglo arreglo2 = convertirToArreglo(lista2);

            if ((this.indiceSuperior != arreglo2.getIndiceSuperior()) == true){
                return false;
            } else {
                for (int indexComparar = 0; indexComparar < this.indiceSuperior; indexComparar++){
                    if (this.obtener(indexComparar).toString().equalsIgnoreCase(arreglo2.obtener(indexComparar).toString()) == false){
                        return false;
                    }
                }
                return true;
            }
        }
    }

    // Este metodo retorna verdadero si val1 y val2 son iguales, falso de otra manera.
    private boolean objetosSonIguales(Object val1, Object val2){
        if (val1.toString().equalsIgnoreCase(val2.toString()) == true){
            return true;
        } else {
            return false;
        }
    }

    // Modifica el vlaorViejo por el valorNuevo una cantidad "numVeces"
    @Override
    public boolean modificar(Object valorViejo, Object valorNuevo, int numVeces) {
        boolean modificado = false;
        int indiceSigVal = 0;

        while (indiceSigVal <= this.indiceSuperior && numVeces > 0){
            if (objetosSonIguales(valorViejo, this.obtener(indiceSigVal))){
                modificado = true;
                modificar(indiceSigVal, valorNuevo);
                numVeces--;
            }
            indiceSigVal++;
        }
        return  modificado;
    }

    // Este metodo regresa un arreglo de indices donde se encuentran los valores que sean iguales a "valor"
    @Override
    public Arreglo buscarValores(Object valor) {
        Arreglo indices = new Arreglo(this.indiceSuperior);
        int objetosEncontrados = 0;
        for (int indiceBusqueda = 0; indiceBusqueda <= this.indiceSuperior; indiceBusqueda++){
            if (objetosSonIguales(obtener(indiceBusqueda), valor) == true){
                objetosEncontrados++;
                indices.poner(indiceBusqueda);
            }
        }

        if (objetosEncontrados == 0){
            return null;
        } else {
            indices.redimensionar(objetosEncontrados);
            return indices;
        }
    }

    // Este metodo vacia la lista
    @Override
    public void vaciar() {
        this.indiceSuperior = -1;
    }

    // Este metodo concatena list2 a la lista actual.
    @Override
    public boolean agregarLista(ListaDatos lista2) {
        if (esUnArreglo(lista2) == true) {
            Arreglo arrConcat = convertirToArreglo(lista2);
            // Validar que la lista2 cabe en el arreglo actual
            if (((this.capacidad - this.indiceSuperior) >= arrConcat.getIndiceSuperior()) == true) {
                for (int indexConcat = 0; indexConcat <= arrConcat.getIndiceSuperior(); indexConcat++) {
                    poner(arrConcat.obtener(indexConcat));
                }
            } else {
                return false;
            }

        }
        return false;
    }

    // Este metodo invierte el orden de los elementos del arreglo
    @Override
    public void invertir() {
        if (vacia() == false){
            int indexAuxSup = this.indiceSuperior;
            int indexAuxInf = 0;
            int numeroPasos = (indexAuxSup + 1) / 2;
            Object datoAux;

            for (int paso = 0; paso < numeroPasos; paso++){
//                datoAux = obtener(indexAuxSup);
                datoAux = datos[indexAuxSup];
//                modificar(indexAuxSup, obtener(indexAuxInf));
                datos[indexAuxSup] = datos[indexAuxInf];
//                modificar(indexAuxInf, datoAux);
                datos[indexAuxInf] = datoAux;

                indexAuxSup--;
                indexAuxInf++;
            }
        }
        return;
    }

    // Este metodo cuenta las ocurrencias del "valor" en el arreglo actual y regresa la cantidad
    @Override
    public int contar(Object valor) {
        int contador = 0;

        for (int indexBuscador = 0; indexBuscador <= this.indiceSuperior; indexBuscador++){
            if (objetosSonIguales(obtener(indexBuscador), valor) == true){
                contador++;
            }
        }

        return contador;
    }

    // Elimina cada elemento de la lista2 que se encuentre en la lista actual.
    // Regresa true si hubo modificaciones, falso de otra manera.
    @Override
    public boolean borrarLista(ListaDatos lista2) {
        if (esUnArreglo(lista2) == true){
            Arreglo arreglo2 = convertirToArreglo(lista2);
            if ((this.vacia() || arreglo2.vacia()) == false){
                boolean flagCambios = false;
                Arreglo indicesIguales;

                // Ahora si borramos aquellos que coincidan TODOS
                for (int indexElemento = 0; indexElemento <= this.indiceSuperior; indexElemento++){
                    indicesIguales = arreglo2.buscarValores(obtener(indexElemento));

                    if(indicesIguales != null){
                        int offset = 0;

                        for (int indexBorrar = 0; indexBorrar <= indicesIguales.getIndiceSuperior(); indexBorrar++){
                            arreglo2.quitar((int) indicesIguales.obtener(indexBorrar) - offset);
                            offset++;
                        }
                        flagCambios = true;
                    }
                }
                return flagCambios;
            }
        }
        return false;
    }

    // Este metodo rellena una "cantidad" de "valores" en el arreglo
    // Estos deben de caber en el arreglo o no se llevara acabo.
    @Override
    public void rellenar(Object valor, int cantidad) {
        if (this.espacioDisponible() >= cantidad){
            while ((lleno() == false && cantidad > 0) == true){
                poner(valor);
            }
        }
        return;

    }

    // Este metodo regresa un clon de la lista actual
    @Override
    public ListaDatos clonar() {
        Arreglo arreglo2 = new Arreglo(this.capacidad);
        if (vacia() == false){
            for (int indexClone = 0; indexClone <= this.indiceSuperior; indexClone++){
                arreglo2.poner(obtener(indexClone));
            }
        }
        return (ListaDatos) arreglo2;
    }

    // Este metodo retorna una sublista de la lista actual
    @Override
    public ListaDatos subLista(int indiceInicial, int indiceFinal) {
        if (indicesValidos(indiceInicial, indiceFinal) == true){
            Arreglo arr2 = new Arreglo(indiceFinal - indiceInicial + 1);

            for (int indexSub = indiceInicial; indiceInicial <= indiceFinal; indiceInicial++){
                arr2.poner(obtener(indiceInicial));
            }
            return (ListaDatos) arr2;
        }
        return null;
    }

    // Este metodo subsituye completamente la lista actual por la lista2
    @Override
    public boolean substituir(ListaDatos lista2) {
        if (esUnArreglo(lista2)){
            Arreglo arrSubs = convertirToArreglo(lista2);
            this.datos = arrSubs.getDatos();
            this.capacidad = arrSubs.getCapacidad();
            this.indiceSuperior = arrSubs.getIndiceSuperior();

            return true;
        }
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

    // Este metodo insertara en la posicion indice el contenido del valor
    @Override
    public boolean poner(int indice, Object valor) {
        if (lleno() == true){ // Ya esta lleno no podemos insertar nada mas
            return false;
        }
        for (int indexMove = indiceSuperior; indexMove >= indice; indexMove--){
            datos[indexMove + 1] = datos[indexMove];
        }
        //Insertar el dato
        datos[indice] = valor;
        indiceSuperior = indiceSuperior + 1;

        return true;
    }

    @Override
    public void rellenar(Object valor) {

    }

    // Este metodo indica si los indices inicial y final son validos
    private boolean indicesValidos(int indexIni, int indexFin){
        if ((indexIni < indexFin) == true && (indexFin <= this.indiceSuperior) == true){
            return true;
        } else {
            return false;
        }
    }

    // Retorna la cantidad de espacios disponibles en el arreglo
    private int espacioDisponible(){
        return this.capacidad - (this.indiceSuperior + 1);
    }

    // Este metodo redimensiona un arreglo de tamaño n a tamaño m.
    // Trunca el arreglo si m < n, o deja espacios vacios si m > n
    @Override
    public boolean redimensionar(int maximo){
        if ((maximo > 0) == true){
            Arreglo arregloRedim = new Arreglo(maximo);
            int indexColocar = 0;

            while (arregloRedim.lleno() == false && indexColocar <= this.indiceSuperior){
                arregloRedim.poner(this.obtener(indexColocar));
                indexColocar++;
            }
            this.indiceSuperior = indexColocar - 1;
            this.capacidad = maximo;
            this.datos = arregloRedim.getDatos();
            return true;

        } else {
            return false;
        }

    }

    // Este metodo remueve el elemento en el indice especificado y lo retorna.
    // Devuelve null si no lo encuentra
    @Override
    public Object quitar(int indice) {
        if (validaPosicion(indice) == true){
            Object respaldo = obtener(indice);

            for (int modificacion = indice; modificacion < indiceSuperior; modificacion++){
//                modificar(modificacion, obtener(modificacion +1));
                datos[modificacion] = datos[modificacion + 1];
            }

            this.indiceSuperior--;
            return respaldo;

        } else {
            return null;
        }
    }

    // Este metodo modifica el valor que se encuentra en el "indice" indicado por el "valor" nuevo
    // Retorna true si hizo el cambio, y falso de otra manera.
    @Override
    public boolean modificar(int indice, Object valor){
        if (validaPosicion(indice) == true){
            this.datos[indice] = valor;
            return true;
        } else {
            return false;
        }
    }

    // Este metodo modifica los valores del arreglo usando un arreglo de indices
    // y coloca valores nuevos especificados en un arreglo de valores nuevos
    @Override
    public boolean modificarLista(Arreglo indicesBusqueda, Arreglo valoresNuevos) {
        // Validando los indices
        for (int indexValida = 0; indexValida <= indicesBusqueda.getIndiceSuperior(); indexValida++){
            if (validaPosicion((int) indicesBusqueda.obtener(indexValida)) == false){
                return false;
            }
        }

        // Modificando los valores
        int indexCambio;
        for (int contadorIndex = 0; contadorIndex <= indicesBusqueda.getIndiceSuperior(); contadorIndex++){
            indexCambio = (int) indicesBusqueda.obtener(contadorIndex);
            modificar(indexCambio, valoresNuevos.obtener(contadorIndex));
        }

        return true;
    }

    // Metodo que hace un cast de ListaDatos a Arreglo
    private Arreglo convertirToArreglo(ListaDatos list){
        return (Arreglo) list;
    }

    // Este metodo comprueba si la lista pasada es una instancia de Arreglo
    // Retorna true si lo es, falso si no.
    private boolean esUnArreglo(ListaDatos lista2){
        if ((lista2 instanceof Arreglo) == true){
            return true;
        } else {
            return false;
        }

    }

    @Override
    public boolean lleno() {
        if (indiceSuperior == (capacidad - 1) ){
            return true;
        } else {
            return false;
        }
    }

    //Me dice el tamaño del arreglo
    @Override
    public int capacidad() {
        return this.capacidad;
    }

    // Me dice cuántos datos hay en el arreglo
    @Override
    public int cantidad() {
        return this.indiceSuperior + 1;
    }

    private boolean validaPosicion(int indice){
        if (indice >= 0 && indice <= this.indiceSuperior){
            // si es válido
            return true;
        } else {
            //no es válido
            return false;
        }
    }

    // Este metodo (acento da error) me retorna el elemento de la posición indicada
    @Override
    public Object obtener(int indice) {
        if (validaPosicion(indice) == true){
            //si existe esa posición
            return datos[indice];
        } else{
            //no existe la posición
            return null;
        }
    }

    // Este metodo retorna un Arreglo con la sublista de los elementos indicados en el
    // arreglo listaIndices.
    public Arreglo subLista(ArregloNumerico listaIndices){
        // Validar todos los indices
        if (vacia() == false){

            // Validando los indices
            for (int indexIndice = 0; indexIndice <= listaIndices.getIndiceSuperior(); indexIndice++){
                if (validarIndice(listaIndices.obtenerDouble(indexIndice).intValue()) == false){ // Encontro un indice
                                                                                                // inválido
                    return null;
                }
            }

            // Si llega hasta aqui, entonces todos los indices son validos.
            Arreglo subArreglo = new Arreglo(listaIndices.getIndiceSuperior() + 1);

            for (int indexIndice = 0; indexIndice <= listaIndices.getIndiceSuperior(); indexIndice++){
                subArreglo.poner(obtener(listaIndices.obtenerDouble(indexIndice).intValue()));
            }
            return subArreglo;
        } else { // esta vacia, entonces no podemos hacer mucho
            return null;
        }
    }


    // Este metodo retorna true si el indice pasado como argumento es valido en el arreglo actual
    // falso de otra manera.
    protected boolean validarIndice(int indice){
        if (indice >= 0 && indice <= indiceSuperior){
            return true;
        } else {
            return false;
        }
    }

}
