package edlineal.auxiliares;

public class DatoPrioridad {
    private Object dato;
    private int prioridad;

    // Recibe un dato y su prioridad
    public DatoPrioridad(Object dato, int prioridad) {
        this.dato = dato;
        this.prioridad = prioridad;
    }

    public Object getDato() {
        return dato;
    }

    public void setDato(Object dato) {
        this.dato = dato;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }
}
