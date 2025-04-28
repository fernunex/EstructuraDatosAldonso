package edlineal;


/* Esta interfaz maneja los métodos para memoria estática y dinámica */
public interface ListaDatos {
    public boolean vacia();

    public Integer poner(Object valor);
    public Object buscar(Object valor);
    public void imprimir();
    public void imprimirDes();
    public Object quitar();
    public Object quitar(Object valor);
    public boolean esIgual(ListaDatos lista2);
    public boolean
    modificar(Object valorViejo, Object valorNuevo, int numVeces);
    public Arreglo buscarValores(Object valor);
    public void vaciar();
    public boolean agregarLista(ListaDatos lista2);
    public void invertir();
    public int contar(Object valor);
    public boolean borrarLista(ListaDatos lista2);
    public void rellenar(Object valor, int cantidad);
    public ListaDatos clonar();
    public ListaDatos subLista(int indiceInicial, int indiceFinal);
    public boolean substituir(ListaDatos lista2);
    public ListaDatos arregloDesordenado();
    public boolean esSublista(ListaDatos lista2);
    public boolean modificarLista(ListaDatos lista2, ListaDatos lista2Nuevos);
    public boolean retenerLista(ListaDatos lista2);
    public boolean poner(int indice, Object valor);
    public void rellenar(Object valor);

    public Object verFinal();
    public Object verInicio(); // Muestra quien esta en el inicio

    // ListaDin
    public Integer ponerInicio(Object valor);
    public void iniciaIterador();
    public boolean iteradorValido();
    public Object obtenerIterador();
    public void moverIterador();

}
