package edlineal.auxiliares;

public class Nodo {
    // Todos los objetos se guardan en el heap.
    protected Object dato;
    protected Nodo ligaDer;

    public Nodo(Object valor){
        this.dato = valor;
        ligaDer = null;
    }

    public Object getDato() {
        return dato;
    }

    public void setDato(Object dato) {
        this.dato = dato;
    }

    public Nodo getLigaDer() {
        return ligaDer;
    }

    public void setLigaDer(Nodo ligaDer) {
        this.ligaDer = ligaDer;
    }

    @Override
    public String toString(){
        return dato.toString();
    }
}
