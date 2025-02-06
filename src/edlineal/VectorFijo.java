package edlineal;

// Esta interfaz maneja los métodos particulares de memoria estática
public interface VectorFijo extends ListaDatos{
    public boolean lleno();
    public int capacidad();
    public int cantidad();
    public Object obtener(int indice);
    public boolean modificar(int indice, Object valor);
    public boolean modificarLista(Arreglo indicesBusqueda, Arreglo valoresNuevos);
    public boolean redimensionar(int maximo);
    public Object quitar(int indice);
}