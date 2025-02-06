package registros.ventas;

import edlineal.Arreglo;

public class GestorTienda {
    protected String nombre;
    protected Arreglo notasVenta;
    protected Arreglo vendedores;


    public GestorTienda(String nombre, int cantNotas, int cantVendedores){
        this.nombre = nombre;
        this.notasVenta = new Arreglo(cantNotas);
        this.vendedores = new Arreglo(cantVendedores);
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

    public boolean agregarNota(Cliente cliente, String fecha, int cantArtVendidos){
        // Ahorita ya tengo el cliente, la fecha
        // voy a obtener internamenete el folio y el vendedor
        Vendedor vendedorTemp = (Vendedor) vendedores.obtener(0);
        if (vendedorTemp == null){
            return false;
        }

        int cantidadNotasExistentes = this.notasVenta.cantidad();
        int folioTemp = 0;
        NotaVenta notaTemp;


        if(cantidadNotasExistentes == 0){ // no hay notas
            folioTemp = 1;
        } else { // si hay notas
            // obtener la nota de arriba
            notaTemp =(NotaVenta) this.notasVenta.obtener((cantidadNotasExistentes - 1));
            folioTemp = notaTemp.getFolio() + 1;
        }


        NotaVenta notaNueva = new NotaVenta(cantArtVendidos, cliente, vendedorTemp, fecha, folioTemp);

        int retorno = notasVenta.poner(notaNueva);
        if (retorno < 0){ // error
            return false;
        } else {
            return true;
        }
    }

    public boolean agregarArticuloNota(int folio, Articulo artComprado, int cant){
        // Encontrar la nota que tenga el folio proporcionado
        int posicionBusqueda = (int) this.notasVenta.buscar(folio);

        if (posicionBusqueda < 0){
            return false;
        } else {
            //Extraer la nota
            NotaVenta notaTemp = (NotaVenta) this.notasVenta.obtener(posicionBusqueda);
            // Usamos el metodo de agregar ARticulo de una nota
            return notaTemp.agregarArticulo(artComprado, cant);
        }
    }

    public void imprimirNota(int folio){
        // Primero encontrar la nota
        int posicionNota = (int) this.notasVenta.buscar(folio);

        if (posicionNota >= 0){ // Puedo impirmirla porque existe
            // Obtenela
            NotaVenta notaTemp = (NotaVenta) this.notasVenta.obtener(posicionNota);
            // Imprimirla
            notaTemp.imprimirNota();
        } else {
            return;
        }
    }
}
