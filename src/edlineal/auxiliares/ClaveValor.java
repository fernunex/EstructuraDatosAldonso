package edlineal.auxiliares;

public class ClaveValor {
    private Object clave;
    private Object valor;

    public Object getClave() {
        return clave;
    }

    public void setClave(Object clave) {
        this.clave = clave;
    }

    public Object getValor() {
        return valor;
    }

    public void setValor(Object valor) {
        this.valor = valor;
    }

    @Override
    public String toString(){
        return clave.toString();
    }
}
