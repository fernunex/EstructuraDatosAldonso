package edlineal.auxiliares;

public class NodoClaveValor {
    protected Object clave;
    protected Object valor;
    protected NodoClaveValor ligaDer;

    public NodoClaveValor(Object clave, Object valor) {
        this.clave = clave;
        this.valor = valor;
        this.ligaDer = null;
    }

    @Override
    public String toString(){
        return clave.toString();
    }

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

    public NodoClaveValor getLigaDer() {
        return ligaDer;
    }

    public void setLigaDer(NodoClaveValor ligaDer) {
        this.ligaDer = ligaDer;
    }
}
