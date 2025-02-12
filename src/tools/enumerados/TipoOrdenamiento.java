package tools.enumerados;

public enum TipoOrdenamiento {
    INC(1), DEC (2);

    private final int codigo;

    TipoOrdenamiento(int codigo){
        this.codigo = codigo;
    }

    public int getCodigo(){
        return codigo;
    }
}
