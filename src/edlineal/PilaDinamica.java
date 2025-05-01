package edlineal;

import entradasalida.Salida;

public class PilaDinamica implements LoteDatos{
    protected ListaDin pila;

    public PilaDinamica() {
        this.pila = new ListaDin();
    }

    // Indica si esta vacia la pila
    @Override
    public boolean vacio() {
        return pila.vacia();
    }

    // India si esta llena la pila
    // Al ser dinámica jamás se llenará a menos que se acabe la RAM
    @Override
    public boolean lleno() {
        return false;
    }

    // Coloca un elemento en la pila
    // Arriba de la pila, claro esta
    @Override
    public boolean poner(Object valor) {
        int ponido = pila.poner(valor);

        if (ponido == 0){ // Fue posible agregarlo a la pila
            return true;
        } else { // Se saturo la RAM y no fue posible agregarla
            return false;
        }
    }

    // Devuelve el elemento que este hasta arriba en la pila
    // Como debe de ser
    @Override
    public Object quitar() {
        return pila.quitar();
    }

    // Este metodo imprime la pila en orden
    // El elemento que aparece al inicio es el primer elemento en salir
    @Override
    public void imprimir() {
        PilaDinamica pila2 = new PilaDinamica();

        // La pila actual la guardamos en pila2 para que quede al reves
        pila.iniciaIterador();
        while (pila.iteradorValido()){
            pila2.poner(pila.obtenerIterador());
            pila.moverIterador();
        }

        // Imprimimos la pila2
        while (pila2.verTope() != null){
            Salida.salidaPorDefecto(pila2.quitar() + "\n");
        }
    }

    @Override
    public Object verTope() {
        return pila.verFinal();
    }
}
