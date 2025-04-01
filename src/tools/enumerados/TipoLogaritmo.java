package tools.enumerados;

public enum TipoLogaritmo {
    NATURAL(1), BASE_2 (2), BASE_10(3);

    private final int codigo;

    TipoLogaritmo(int codigo){
        this.codigo = codigo;
    }

    public int getCodigo(){
        return codigo;
    }
}
