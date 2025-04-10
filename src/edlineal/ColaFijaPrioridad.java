package edlineal;

import edlineal.auxiliares.DatoPrioridad;
import tools.enumerados.TipoPrioridad;

public class ColaFijaPrioridad implements LoteDatos{
    protected int elementosEspera;
    protected int capacidad;
    protected DatoPrioridad datos[];
    protected boolean elMayorPrimero;

    public ColaFijaPrioridad(int capacidad, TipoPrioridad tipo) {
        this.capacidad = capacidad;
        datos = new DatoPrioridad[capacidad];
        elementosEspera = 0;

        if (TipoPrioridad.INC == tipo){ // Primero salen los de menor prioridad
            elMayorPrimero = false;
        } else { // Primero salen los de menor prioridad
            elMayorPrimero = true;
        }
    }

    // Indica si la cola de priordad esta vacia
    @Override
    public boolean vacio() {
        if (elementosEspera == 0){
            return true;
        } else {
            return false;
        }
    }

    // Indica si la cola de prioridad esta llena
    @Override
    public boolean lleno() {
        if (capacidad == elementosEspera){
            return true;
        } else {
            return false;
        }
    }

    // Coloca un elemento en la cola de prioridad al final
    // Recibe un objeto de tipo DatoPrioridad
    @Override
    public boolean poner(Object valor) {
        if (valor instanceof DatoPrioridad){ // Es necesario que sea DatoPrioridad
            if (lleno() == false){ // Aun no se llena, todavia le cabe
                elementosEspera++;
                datos[elementosEspera - 1] = (DatoPrioridad) valor;
                return true;
            } else { // Esta lleno y ya no le cabe mas
                return false;
            }
        } else {
            return false;
        }
    }

    // Este metodo devuelve el siguiente dato prioridad en salir
    @Override
    public Object quitar() {
        if (vacio() == false){ // Hay algo que enviar
            int indexSiguiente = encontrarSiguente();
            DatoPrioridad backupDato = datos[indexSiguiente];

            // Reestructuracion del los datos en espera
            for (int indexElemento = indexSiguiente; indexElemento < elementosEspera - 1; indexElemento++){
                datos[indexElemento] = datos[indexElemento + 1];
            }
            elementosEspera--;
            return backupDato;
        } else { // No hay nada que enviar
            return null;
        }
    }

    // Este metodo retorna cual es el siguiente elemento en salir
    private int encontrarSiguente(){
        if (vacio() == false){
            int indexSiguiente = 0;
            DatoPrioridad currentDato, nextDato;
            for (int indexElemento = 1; indexElemento < elementosEspera; indexElemento++){
                currentDato = datos[indexSiguiente];
                nextDato = datos[indexElemento];

                if (elMayorPrimero == true){ // Primero salen los de mayor prioridad. Valor mas grande
                    if (currentDato.getPrioridad() < nextDato.getPrioridad()){
                        indexSiguiente = indexElemento;
                    }
                } else { // El mas chiquito sale primero
                    if (currentDato.getPrioridad() > nextDato.getPrioridad()){
                        indexSiguiente = indexElemento;
                    }
                }
            }
            return indexSiguiente;
        } else { // Si esta vacia, entonces retornamos un -1 para indicar eso
            return -1;
        }
    }

    @Override
    public void imprimir() {

    }

    @Override
    public Object verTope() {
        return null;
    }
}
