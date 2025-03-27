package tools.enumerados;

public enum TipoRenglon {
    SUPERIOR(1), INFERIOR (2);

    private final int codigo;

    TipoRenglon(int codigo){
        this.codigo = codigo;
    }

    public int getCodigo(){
        return codigo;
    }
}
