package edlineal;

import entradasalida.Salida;

public class ColaDinamica implements LoteDatos{
    protected ListaDin cola;

    public ColaDinamica() {
        cola = new ListaDin();
    }

    // Indica si la cola esta vacía
    @Override
    public boolean vacio() {
        return cola.vacia();
    }

    // Indica si la cola esta llena
    @Override
    public boolean lleno() {
        return false;
    }

    // Elemeto ingresado en la cola.
    // Coloca un elemento al inicio de la lista dinámica, ya que los elementos
    // removidos de la cola son los que están hasta el final de la lista dinámica
    @Override
    public boolean poner(Object valor) {
        int ponido = cola.ponerInicio(valor);
        if (ponido == 0){ // Fue posible colocarlo en la cola
            return true;
        } else { // No fue posible colocarlo en la cola
            return false;
        }
    }

    // Devuelve el siguiente elemento en salir de la cola respetando el FIFO.
    // Remueve el último elemento de la lista dinámica.
    @Override
    public Object quitar() {
        return cola.quitar();
    }

    // Imprime la cola en el orden en el que saldrán los elementos de la cola
    @Override
    public void imprimir() {
        ListaDin colaBackup = new ListaDin();

        // Guardando la cola en otra cola e imprimiendola
        while (cola.vacia() == false){
            colaBackup.ponerInicio(cola.verFinal()); // Agregamos el elemento que va a imprimirse a la cola backup
            Salida.salidaPorDefecto(quitar() + "\n");
        }

        // Reasignamos el backup
        cola = colaBackup;
    }

    @Override
    public Object verTope() {
        return null;
    }
}
