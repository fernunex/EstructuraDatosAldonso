package tools.enumerados;

public enum TipoPrioridad {
    INC(1), DEC (2);

    private final int codigo;

    TipoPrioridad(int codigo){
        this.codigo = codigo;
    }

    public int getCodigo(){
        return codigo;
    }
}
