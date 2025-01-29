package edlineal;

public class Arreglo implements VectorFijo{
    protected int capacidad;
    protected Object datos[];
    protected int indiceSuperior = -1;

    public boolean vacia() {
        if (indiceSuperior == -1){
            return true;
        } else {
            return false;
        }
    }
}
