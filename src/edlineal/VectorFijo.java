package edlineal;

// Esta interfaz maneja los métodos particulares de memoria estática
public interface VectorFijo extends ListaDatos{
    public boolean lleno();
    public int capacidad();
    public int cantidad();
    public Object obtener(int indice);

}