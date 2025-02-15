package registros.terminos;

import entradasalida.Salida;

public class Subtermino {
    private String subtermino;
    private String paginas;

    public Subtermino(String subtermino, String paginas) {
        this.subtermino = subtermino;
        this.paginas = paginas;
    }

    // Este metodo imprime el subtermino
    public void imprimir(){
        Salida.salidaPorDefecto("\t" + subtermino + ", " + paginas + "\n");
    }

    @Override
    public String toString(){
        return subtermino;
    }
}
