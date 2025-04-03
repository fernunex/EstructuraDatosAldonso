package edlineal.auxiliares;

public class NodoABuscar {
    protected Nodo anterior;
    protected Nodo encontrado;

    public NodoABuscar(Nodo anterior, Nodo encontrado) {
        this.anterior = anterior;
        this.encontrado = encontrado;
    }

    public Nodo getAnterior() {
        return anterior;
    }

    public void setAnterior(Nodo anterior) {
        this.anterior = anterior;
    }

    public Nodo getEncontrado() {
        return encontrado;
    }

    public void setEncontrado(Nodo encontrado) {
        this.encontrado = encontrado;
    }
}