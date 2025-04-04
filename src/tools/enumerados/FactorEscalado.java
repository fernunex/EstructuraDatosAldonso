package tools.enumerados;

public enum FactorEscalado {
    CUADRUPLE(1), TRIPLE (2), DOBLE(3), MITAD(4), TERCIO(5),
    CUARTO(6);

    private final int codigo;

    FactorEscalado(int codigo){
        this.codigo = codigo;
    }

    public int getCodigo(){
        return codigo;
    }
}
