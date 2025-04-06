package principales;

import edlineal.ArregloOrdenado;
import menus.MenuEncriptador;
import registros.encriptador.EncriptadorTextoBasico;
import tools.enumerados.TipoOrdenamiento;

public class PrincipalEncripador {

    public static void main(String[] args) {
        MenuEncriptador miMenu =
                new MenuEncriptador();
        miMenu.execute();





//        ArregloOrdenado miOrdenado = new ArregloOrdenado(6, TipoOrdenamiento.INC);
//        miOrdenado.poner(4);
//        miOrdenado.poner(5);
//        miOrdenado.poner(11);
//        miOrdenado.poner(14);
//        miOrdenado.poner(17);
//        miOrdenado.poner(19);
//        miOrdenado.imprimir();

//        System.out.println("Esta en:" + miOrdenado.buscar(18));

//        String texto = "Curso de Informática";
//        System.out.println(EncriptadorTextoBasico.encriptar(texto, miOrdenado));
    }

}
