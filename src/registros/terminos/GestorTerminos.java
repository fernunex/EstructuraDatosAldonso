package registros.terminos;

import edlineal.ArregloOrdenado;
import entradasalida.Entrada;
import entradasalida.Salida;
import tools.enumerados.TipoOrdenamiento;

public class GestorTerminos {
    private ArregloOrdenado terminos;
    private String nombre;
    private int cantidadTerminos;
    private int cantidadSubterminos;

    public GestorTerminos(String nombre, int cantidadTerminos, int cantidadSubterminos) {
        this.nombre = nombre;
        this.cantidadTerminos = cantidadTerminos;
        this.cantidadSubterminos = cantidadSubterminos;

        this.terminos = new ArregloOrdenado(cantidadTerminos, TipoOrdenamiento.INC);
    }

    // Este metodo agrega un termino a los terminos
    public boolean agregarTermino(String termino, String paginas){
        int retorno = (int) terminos.poner(new Termino(termino, paginas));
        if (retorno > 0){
            return true;
        } else {
            return false;
        }
    }

    // Este metodo agrega un subtermino a un termino
    public boolean agregarSubtermino(String termino, String subtermino, String paginas){
        Termino term = encontrarTermino(termino);

        if (term != null){
            return term.agregarSubtermino(subtermino, paginas);
        } else {
            return false;
        }

    }

    // Este metodo retorna un termino si lo encontro o un null si no
    private Termino encontrarTermino(String termino){
        int posTermino = (int) terminos.buscar(termino);

        if (posTermino > 0){ // Si lo encontro
            posTermino = posTermino - 1;
            Termino term = (Termino) terminos.obtener(posTermino);
            return term;

        } else { // No lo encontro
            return null;
        }
    }

    // Este metodo imprime un termino indicado
    public void imprimirTermino(String termino){
        Termino term = encontrarTermino(termino);

        if (term != null){
            term.imprimir();
        } else {
            Salida.salidaPorDefecto("El término: " + termino +" No se encuentra en el indice de términos\n");
        }
    }

    // Este metodo imprime todos los terminos habidos y por haber
    public void imprimirTodos(){

        for (int indexTermino = 0; indexTermino <= terminos.getIndiceSuperior(); indexTermino++){
            Termino term = (Termino) terminos.obtener(indexTermino);
            term.imprimir();
        }

    }

    // Este metodo pide los datos para agregar un termino y sus subterminos hasta que el usuario lo indique
    public void insertarTerminoConsola(){
        String termNombre, paginas, subTermNombre, paginaSubterm;

        Salida.salidaPorDefecto("Introduce el nombre del término: ");
        termNombre = Entrada.terminalCadenas();
        Salida.salidaPorDefecto("Introduce el número de páginas: ");
        paginas = Entrada.terminalCadenas();
        agregarTermino(termNombre, paginas);

        while (true){
            Salida.salidaPorDefecto("Introduce el nombre del subtérmino (o deja en blanco para terminar): ");
            subTermNombre = Entrada.terminalCadenas();
            if (subTermNombre.isBlank() == true){
                break;
            }
            Salida.salidaPorDefecto("Introduce el número de páginas: ");
            paginaSubterm = Entrada.terminalCadenas();
            agregarSubtermino(termNombre, subTermNombre, paginaSubterm);
        }

        Salida.salidaPorDefecto("¡Término guardado exitosamente!");
    }

    // Este metodo consulta un subtermino y lo imprime si es que lo encuentra
    public void imprimirSubtermino(String subtermino){

        Termino term;
        Subtermino subterm;
        int indexTermino = 0;

        while (indexTermino <= terminos.getIndiceSuperior()){
            term = (Termino) terminos.obtener(indexTermino);
            subterm = encontrarSubtermino(term.getTermino(), subtermino);

            if (subterm != null){
                subterm.imprimir();
                return;
            }
            indexTermino++;
        }
        Salida.salidaPorDefecto("El subtérmino: " + subtermino +" No se encuentra en el indice de términos\n");

    }

    // Este metodo retorna un subtermino si lo encuentra, si no, retorna un null
    private Subtermino encontrarSubtermino(String termino, String subtermino){
        Termino term = encontrarTermino(termino);

        if (term != null){
            Subtermino subterm = term.buscarSubtermino(subtermino);
            if (subterm != null){ // Si lo encontro
                return subterm;

            } else { // No lo encontro
                return null;
            }
        } else {
            return null;
        }
    }

    // Este metodo imprime un rango del indice
    public void imprimirRango(String letraInicial, String letraFinal){
        int indexInicial = (int) terminos.buscar(letraInicial);
        indexInicial = Math.abs(indexInicial) - 1; // Obtenemos el positivo y le restamos uno. No sabemos si es positivo
        // o no, pero asi de que lo es lo es
        int indexFinal;

        char letraCharFinal = letraFinal.charAt(0);
        if (letraCharFinal == 'Z'){ // Imprimir hasta la z. Es decir, hasta el final
            indexFinal = terminos.getIndiceSuperior();
        } else {
            letraCharFinal = (char) (letraCharFinal + 1); // Siguiente letra. A -> B, o R -> S
            letraFinal = letraCharFinal + "";
            indexFinal = (int) terminos.buscar(letraFinal);
            indexFinal = Math.abs(indexFinal) - 1;

        }

        for (int indexPrint = indexInicial; indexPrint < indexFinal; indexPrint++){
            Termino term = (Termino) terminos.obtener(indexPrint);
            term.imprimir();
        }
    }
}
