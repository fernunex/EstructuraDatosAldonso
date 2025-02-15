package edlineal;

import tools.comunbase.ManipuladorObjetos;
import tools.enumerados.TipoOrdenamiento;

import java.util.Random;

public class ArregloOrdenado extends Arreglo {
    private TipoOrdenamiento orden;

    public ArregloOrdenado(int tamanio, TipoOrdenamiento orden) {
        super(tamanio);
        this.orden = orden;
    }

    // Este metodo substituye lista2 a el arreglo actual si cumple con el orden
    // es decir, si esta en orden INC o DEC
    @Override
    public boolean substituir(ListaDatos lista2){
        boolean inc = true;
        boolean dec = true;

        Arreglo arr2 = (Arreglo) lista2;

        // Test INC
        for (int indexTest = 0; indexTest < arr2.getIndiceSuperior(); indexTest++){
            if (ManipuladorObjetos.compararObjetos(arr2.getDatos()[indexTest],
                    arr2.getDatos()[indexTest + 1]) >= 0){ // No es INC
                inc = false;
                break;
            }
        }

        if (inc == false){
            // Test DEC
            for (int indexTest = 0; indexTest < arr2.getIndiceSuperior(); indexTest++){
                if (ManipuladorObjetos.compararObjetos(arr2.getDatos()[indexTest],
                        arr2.getDatos()[indexTest + 1]) <= 0){ // No es DEC
                    dec = false;
                    break;
                }
            }
        }

        if (inc == false && dec == false){ // No es ni increamento ni decremento
            return false;
        } else if (inc == true) { // Esta en Incremento
            orden = TipoOrdenamiento.INC;
        } else { // Esta en decremento
            orden = TipoOrdenamiento.DEC;
        }
        datos = arr2.getDatos();
        indiceSuperior = arr2.getIndiceSuperior();
        capacidad = arr2.getCapacidad();
        return true;
    }

    // Este metodo trata de insertar un elemento en el indice especificado
    // si es posible entonces retorna true, si no, false
    @Override
    public boolean poner(int indice, Object valor){
        int retorno = (int) buscar(valor);
        retorno = (retorno * -1) - 1;
        if (retorno == indice){
            return super.poner(indice, valor);
        } else {
            return false;
        }

    }

    // Este metodo solo deja en la lista actual aquellos que se encuentren en lista2
    @Override
    public boolean retenerLista(ListaDatos lista2){
        Arreglo arr2 = (Arreglo) lista2;
        boolean modificado = false;

        for (int indexEliminar = 0; indexEliminar <= indiceSuperior; indexEliminar++){
            int retorno = (int) arr2.buscar(datos[indexEliminar]);
            if (retorno < 0){ // No se encuentra
                quitar(indexEliminar);
                indexEliminar--;
                modificado = true;
            }
        }
        return modificado;
    }


    // Este metodo invierte el orden del arreglo de INCREMENTO a DECREMENTO o viceversa
    @Override
    public void invertir(){
        super.invertir();
        if (orden == TipoOrdenamiento.INC){
            orden = TipoOrdenamiento.DEC;
        } else {
            orden = TipoOrdenamiento.INC;
        }
    }

    // Este metodo modifica los valores de lista2 con los valores de lista2Nuevos si
    // se encuentran en la lista actual
    @Override
    public boolean modificarLista(ListaDatos lista2, ListaDatos lista2Nuevos){
        Arreglo arr2 = (Arreglo) lista2;
        Arreglo arr2Nuevos = (Arreglo) lista2Nuevos;
        boolean modificado = false;

        for (int indexCambio = 0; indexCambio <= arr2.getIndiceSuperior(); indexCambio++){
            int retorno = (int) buscar(arr2.getDatos()[indexCambio]);
            if (retorno > 0){ // Si se encuentra
                arr2.getDatos()[indexCambio] = arr2Nuevos.getDatos()[indexCambio];
                modificado = true;
            }
        }
        return modificado;
    }

    // Este metodo valida si lista2 es una sublista o subconjunto de la lista actual
    @Override
    public boolean esSublista(ListaDatos lista2){
        if (esUnArregloOrdenado(lista2) == false){
            return false;
        }
        // Continua si es un arreglo.
        ArregloOrdenado arr2 = (ArregloOrdenado) lista2;
        int primerIndex = (int) buscar(arr2.getDatos()[0]);
        if (primerIndex < 0){ // no esta el primero, entonces no es sublista
            return false;
        }else { // si esta el primero
            //Validar las dimensiones
            int disponible = (indiceSuperior + 1) - primerIndex;
            if (disponible < arr2.getIndiceSuperior() + 1){ // No cabe la sublista es mayor que la restante actual
                return false;
            } else {
                // Validar cada elemento restante
                int valorRetorno;
                for (int valorArr2 = 0; valorArr2 <= arr2.getIndiceSuperior(); valorArr2++){
                    valorRetorno = (int) buscar(arr2.getDatos()[valorArr2]);
                    if (valorRetorno < 0){ // No se encuentra en el arreglo, por lo tanto salimos
                        return false;
                    }
                }
                return true; // Si todos estan entonces es sublista
            }
        }
    }


    // Este metodo agrega una lista2 al arreglo actual y retorna true si lo logro
    // o false si no lo logro.
    public boolean agregarLista(ListaDatos lista2){
        if (esUnArregloOrdenado(lista2) == false){
            return false;
        }
        // Si es un arreglo continua
        ArregloOrdenado arreglo2 = (ArregloOrdenado) lista2;
        int espacioDisponible = capacidad - (indiceSuperior + 1);

        if (espacioDisponible < (arreglo2.getIndiceSuperior() + 1) ){// No cabe
            return false; // Nos salimos
        }
        // Si continua es porque si cabe
        // Validar que no haya repetidos
        int valorRetorno;
        for (int valorArr2 = 0; valorArr2 <= arreglo2.getIndiceSuperior(); valorArr2++){
            valorRetorno = (int) buscar(arreglo2.getDatos()[valorArr2]);
            if (valorRetorno > 0){ // Ya se encuentra en el arreglo actual
                return false;
            }
        }
        // Si continua es porque ningun elemento del arreglo2 se encuentra en el actual
        // Insertamos esos valores aqui.
        for (int valorArr2 = 0; valorArr2 <= arreglo2.getIndiceSuperior(); valorArr2++){
            poner(arreglo2.getDatos()[valorArr2]);
        }
        return true;

    }

    // Este metodo devuelve true si lista2 es un ArregloOrdenado
    // falso de otra manera
    private boolean esUnArregloOrdenado(ListaDatos lista2){
        if ((lista2 instanceof ArregloOrdenado) == true){
            return true;
        } else {
            return false;
        }
    }


    // Este metodo retorna un Arreglo desordenado con los datos del arreglo actual
    @Override
    public ListaDatos arregloDesordenado(){
        Arreglo arregloDesordenado = (Arreglo) super.clonar();
        Random generadorRandom = new Random();
        Object[] datosDesordenado = arregloDesordenado.getDatos();
        int randomIndex;
        Object aux;

        for (int indexSwap = 0; indexSwap < indiceSuperior; indexSwap++){
            randomIndex = generadorRandom.nextInt(indiceSuperior + 1);
            aux = datosDesordenado[indexSwap];
            datosDesordenado[indexSwap] = datosDesordenado[randomIndex];
            datosDesordenado[randomIndex] = aux;
        }

        return (ListaDatos) arregloDesordenado;
    }

    // Este metodo elimina un elemento del arreglo por valor.
    // Si lo encuentra lo elimina y lo retorna, si no, retorna un null
    @Override
    public Object quitar(Object valor){
        int indexQuitar = (int) buscar(valor);

        if (indexQuitar > 0){ // si lo encontro
            Object val = quitar(indexQuitar - 1);
            return val;
        } else { // No lo encontro
            return null;
        }
    }

    // Este metodo modifica el elemento que se encuentre en el indice indicado y
    // reorganiza el arreglo si es necesario
    @Override
    public boolean modificar(int indice, Object valor){
        Object retorno = quitar(indice);
        if (retorno != null){
            poner(valor);
            return true;
        } else {
            return false;
        }
    }


    // Este metodo inserta un valor en el arreglo actual y lo mantiene ordenado dependiendo de
    // la estructura de ordenamiento.
    public Integer poner(Object valor) {
        if (lleno() == false) { // hay espacio
            int posicionEncontrado = (int) buscar(valor);
            if (posicionEncontrado < 0) { //no existe
                posicionEncontrado = posicionEncontrado * (-1);
                posicionEncontrado = posicionEncontrado - 1;

                for (int posMod = (indiceSuperior + 1); posMod >= (posicionEncontrado + 1); posMod--) {
                    datos[posMod] = datos[posMod - 1];
                }

                datos[posicionEncontrado] = valor;
                indiceSuperior++;
                return posicionEncontrado;
            } else { // Sí existe
                return -1;
            }
        } else { // no hay espacio
            return -1;
        }
    }


    // Este metodo retorna un positivo con la posicion + 1 donde se encuentra el objeto que se busca
    // o un negativo si no se encontro pero deberia ir ahi al convertirlo en positivo
    @Override
    // saber si esa un objeto o no en un arreglo ordenado i para cuando el objeto no esta en la posicion donde deberia ir o esta
    public Object buscar(Object valor) {
        int posicionB = 0;
        while ((posicionB <= indiceSuperior)) {
            if(orden == TipoOrdenamiento.INC){
                if((ManipuladorObjetos.compararObjetos(valor, datos[posicionB]) > 0) == false){
                    break;
                }
            } else {
                if((ManipuladorObjetos.compararObjetos(valor, datos[posicionB]) < 0) == false){
                    break;
                }
            }
            // original > 0
            posicionB++;
        }
        if (posicionB > indiceSuperior || (ManipuladorObjetos.compararObjetos(valor, datos[posicionB]) == 0) == false) {
            // original < 0
            return (posicionB + 1) * -1; //no se encontro
        } else {
            return posicionB + 1; //si se encontro
        }
    }

    // Sobreescribiendo los metodos del padre para que no afecten a esta clase
    @Override
    public ListaDatos clonar() {
        return null;
    }

    // Este metodo
    @Override
    public void rellenar(Object valor) {
        super.vaciar();
        if (valor instanceof Number){
            if (capacidad < Math.abs((int) valor)){ // El valor es mas grande que la capacidad
                return;
            } else {
                // Entonces si cabe y continuamos
                int valorArgumento = (int) valor;
                if (valorArgumento < 0){ // El valor es negativo, entonces debemos subir
                    for (int valorPoner = valorArgumento; valorPoner <= -1; valorPoner++){

                        poner(valorPoner);
                    }
                } else { // El valor es positivo, por lo tanto debemos bajar
                    for (int valorPoner = valorArgumento; valorPoner >= 1; valorPoner--){
                        poner(valorPoner);
                    }
                }

            }
        } else if (valor instanceof Character) {
            char valorArgumento = (char) valor;
            if (capacidad < (valorArgumento - 'A')){// No cabe
                return;
            } else {
                for (int valorPoner = valorArgumento; valorPoner >= 'A'; valorPoner--){
                    poner((char) valorPoner);
                }
            }
        } else {
            poner(valor);
        }
    }

    @Override
    public void vaciar() {
    }

    @Override
    public boolean esIgual(ListaDatos lista2) {
        return false;
    }
}
