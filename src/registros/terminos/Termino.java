package registros.terminos;

import edlineal.ArregloOrdenado;
import entradasalida.Salida;
import tools.enumerados.TipoOrdenamiento;

public class Termino {
    private String termino;
    private ArregloOrdenado subterminos;
    private String paginas;

    public Termino(String termino, String paginas) {
        this.paginas = paginas;
        this.termino = termino;

        // Inicialmente colocamos que solo se puedan 5 subterminos para acortar el constructor
        subterminos = new ArregloOrdenado(5, TipoOrdenamiento.INC);
    }

    // Este metodo agrega un subtermino
    public boolean agregarSubtermino(String nombre, String paginas){
        int retorno = (int) subterminos.poner(new Subtermino(nombre, paginas));

        if (retorno > 0){
            return true;
        } else {
            return false;
        }
    }

    // Este metodo imprime el termino y sus subterminos
    public void imprimir(){
        Salida.salidaPorDefecto(termino + ", " + paginas + "\n");

        for (int indexSubtermino = 0; indexSubtermino <= subterminos.getIndiceSuperior(); indexSubtermino++){
            Subtermino sub = (Subtermino) subterminos.getDatos()[indexSubtermino];
            sub.imprimir();
        }

    }

    // Este metodo retorna un subtermino so lo encuentra, si no, entonces retorna un null
    public Subtermino buscarSubtermino(String subtermino){
        int posSubTermino = (int) subterminos.buscar(subtermino);

        if (posSubTermino > 0){ // Si lo encontro
            posSubTermino = posSubTermino - 1;
            Subtermino subterm = (Subtermino) subterminos.obtener(posSubTermino);
            return subterm;

        } else { // No lo encontro
            return null;
        }
    }

    public String getPaginas() {
        return paginas;
    }

    public void setPaginas(String paginas) {
        this.paginas = paginas;
    }

    public String getTermino() {
        return termino;
    }

    public void setTermino(String termino) {
        this.termino = termino;
    }

    @Override
    public String toString(){
        return this.termino;
    }
}
