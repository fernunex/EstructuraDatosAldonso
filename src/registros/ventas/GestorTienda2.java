package registros.ventas;

import edlineal.Arreglo;
import edlineal.ListaDin;

public class GestorTienda2 {
    protected String nombre;
    protected ListaDin notasVenta;
    protected ListaDin vendedores;


    public GestorTienda2(String nombre){
        this.nombre = nombre;
        this.notasVenta = new ListaDin();
        this.vendedores = new ListaDin();
    }

    public boolean agregarVendedor(String nombre, String rfc, int numeroVendedor,
                                   String fechaNacimiento){
        Vendedor vendedorTemp = new Vendedor(nombre, rfc, numeroVendedor, fechaNacimiento);

        int retorno = vendedores.poner(vendedorTemp);

        if (retorno < 0){ //error
            return false;
        } else {
            return true;
        }
    }

    public boolean agregarNota(Cliente cliente, String fecha){
        // Ahorita ya tengo el cliente, la fecha
        // voy a obtener internamenete el folio y el vendedor

        Vendedor vendedorTemp = (Vendedor) vendedores.verInicio();
        if (vendedorTemp == null){
            return false;
        }

        int folioTemp = 0;
        NotaVenta2 notaTemp = (NotaVenta2) notasVenta.verFinal();


        if(notaTemp == null){ // no hay notas
            folioTemp = 1;
        } else { // si hay notas
            // obtener la nota de arriba
            folioTemp = notaTemp.getFolio() + 1;
        }

        NotaVenta2 notaNueva = new NotaVenta2(cliente, vendedorTemp, fecha, folioTemp);

        int retorno = notasVenta.poner(notaNueva);
        if (retorno < 0){ // error
            return false;
        } else {
            return true;
        }
    }

    public boolean agregarArticuloNota(int folio, Articulo artComprado, int cant){
        // Encontrar la nota que tenga el folio proporcionado
        NotaVenta2 notaTemp = (NotaVenta2) this.notasVenta.buscarObjeto(folio);

        if (notaTemp == null){ // Esa nota no está
            return false;
        } else { // Si está
            //Extraer la nota, ya se hizo arriba
            // Usamos el metodo de agregar ARticulo de una nota
            return notaTemp.agregarArticulo(artComprado, cant);
        }
    }

    public void imprimirNota(int folio){
        // Primero encontrar la nota
        NotaVenta2 notaTemp = (NotaVenta2) this.notasVenta.buscarObjeto(folio);

        if (notaTemp != null){ // Puedo impirmirla porque existe
            // Obtenela, hecha arriba
            // Imprimirla
            notaTemp.imprimirNota();
        } else {
            return;
        }
    }
}