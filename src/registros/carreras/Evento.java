package registros.carreras;

public class Evento {
    protected String nombre;
    protected String lugar;
    protected int anioFundacion;

    public Evento(String nombre, String lugar, int anioFundacion) {
        this.nombre = nombre;
        this.lugar = lugar;
        this.anioFundacion = anioFundacion;
    }

    @Override
    public String toString(){
        return nombre;
    }
}
