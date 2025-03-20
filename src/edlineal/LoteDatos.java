package edlineal;

public interface LoteDatos {

    public boolean vacio();
    public boolean lleno();
    public boolean poner(Object valor); // Solo me interesa si lo pude poner o no. No donde
    public Object quitar();
    public void imprimir(); // Este es solo educativo. No deberiamos de poder verlos,
                            // no deberia existir.
    public Object verTope(); // El tope es el final

}
