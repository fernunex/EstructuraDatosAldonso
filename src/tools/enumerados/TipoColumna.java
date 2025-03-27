package tools.enumerados;

public enum TipoColumna {
    IZQUIERDA(1), DERECHA (2);

    private final int codigo;

    TipoColumna(int codigo){
        this.codigo = codigo;
    }

    public int getCodigo(){
        return codigo;
    }
}
