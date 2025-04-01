package edlineal;

public class ListaDin implements ListaDatos{
    protected Nodo primero;
    protected Nodo ultimo;


    // Este metodo checa si esta vacia la lista
    @Override
    public boolean vacia() {
        return false;
    }

    @Override
    public Integer poner(Object valor) {
        return 0;
    }

    @Override
    public Object buscar(Object valor) {
        return null;
    }

    @Override
    public void imprimir() {

    }

    @Override
    public void imprimirDes() {

    }

    @Override
    public Object quitar() {
        return null;
    }

    @Override
    public Object quitar(Object valor) {
        return null;
    }

    @Override
    public boolean esIgual(ListaDatos lista2) {
        return false;
    }

    @Override
    public boolean modificar(Object valorViejo, Object valorNuevo, int numVeces) {
        return false;
    }

    @Override
    public Arreglo buscarValores(Object valor) {
        return null;
    }

    @Override
    public void vaciar() {

    }

    @Override
    public boolean agregarLista(ListaDatos lista2) {
        return false;
    }

    @Override
    public void invertir() {

    }

    @Override
    public int contar(Object valor) {
        return 0;
    }

    @Override
    public boolean borrarLista(ListaDatos lista2) {
        return false;
    }

    @Override
    public void rellenar(Object valor, int cantidad) {

    }

    @Override
    public ListaDatos clonar() {
        return null;
    }

    @Override
    public ListaDatos subLista(int indiceInicial, int indiceFinal) {
        return null;
    }

    @Override
    public boolean substituir(ListaDatos lista2) {
        return false;
    }

    @Override
    public ListaDatos arregloDesordenado() {
        return null;
    }

    @Override
    public boolean esSublista(ListaDatos lista2) {
        return false;
    }

    @Override
    public boolean modificarLista(ListaDatos lista2, ListaDatos lista2Nuevos) {
        return false;
    }

    @Override
    public boolean retenerLista(ListaDatos lista2) {
        return false;
    }

    @Override
    public boolean poner(int indice, Object valor) {
        return false;
    }

    @Override
    public void rellenar(Object valor) {

    }

    @Override
    public Object verFinal() {
        return null;
    }
}
