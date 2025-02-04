package edlineal;

/* Interfaze para memoria estática y dinámica */
public interface ListaDatos {
    public boolean vacia();
    public Integer poner(Object valor);
    public Object buscar(Object valor);
    public void imprimir();
    public void imprimirDes();
    public Object quitar();
    public Object quitar(Object valor);
}
