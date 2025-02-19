package edlineal;

public class ArregloNumerico extends Arreglo{


    public ArregloNumerico(int tamanio) {
        super(tamanio);
    }

    // Sobreescribiendo los metodos del Arreglo para que funcione el ArregloNumerico
    // Este medodo agrega un numero al final del arreglo, es decir a la arriba de los demas. Tambien retorna
    // el indice de donde lo coloco
    @Override
    public Integer poner(Object valor) {
        if (isNumero(valor) == true){
            return super.poner(valor);
        } else {
            return -1;
        }
    }

    // Este metodo retorna true si el valor pasado es una instancia de Number, falso de otra forma.
    private boolean isNumero(Object valor){
        if (valor instanceof Number){
            return true;
        } else {
            return false;
        }
    }

    @Override
    // Este metodo busca un valor numerico en el arreglo y retorna el indice de donde esta
    public Object buscar(Object valor) {
        if (isNumero(valor) == true){
            return super.buscar(valor);
        } else {
            return -1;
        }
    }

    @Override
    // Este metodo busca un valor numerico pasado por parametro
    // en el arreglo y si lo encuentra entonces lo va a quitar y retornar.
    public Object quitar(Object valor) {
        if (isNumero(valor) == true){
            return super.quitar(valor);
        } else {
            return null;
        }
    }

    @Override
    // Modifica el vlaorViejo por el valorNuevo una cantidad "numVeces"
    public boolean modificar(Object valorViejo, Object valorNuevo, int numVeces) {
        if ((isNumero(valorViejo) == true) && isNumero(valorNuevo) == true){
            return super.modificar(valorViejo, valorNuevo, numVeces);
        } else {
            return false;
        }
    }

    @Override
    // Este metodo regresa un arreglo de indices donde se encuentran los valores numéricos que sean iguales a "valor"
    public Arreglo buscarValores(Object valor) {
        if (isNumero(valor) == true){
            return super.buscarValores(valor);
        } else {
            return null;
        }
    }

    // Este metodo cuenta las ocurrencias del "valor" en el arreglo actual y regresa la cantidad
    @Override
    public int contar(Object valor) {
        if (isNumero(valor) == true){
            return super.contar(valor);
        } else {
            return 0;
        }
    }

    // Este metodo rellena una "cantidad" de "valores" en el arreglo
    // Estos deben de caber en el arreglo o no se llevara acabo.
    @Override
    public void rellenar(Object valor, int cantidad) {
        if (isNumero(valor) == true){
            super.rellenar(valor, cantidad);
        }
    }

    // Este metodo insertara en la posicion indice el contenido del valor
    @Override
    public boolean poner(int indice, Object valor) {
        if (isNumero(valor) == true){
            return super.poner(indice, valor);
        } else {
            return false;
        }
    }

    // Este metodo rellena el arreglo con el valor numerico especificado
    @Override
    public void rellenar(Object valor) {
        if (isNumero(valor) == true){
            super.rellenar(valor);
        } else {
            return;
        }
    }

    // Este metodo modifica el valor que se encuentra en el "indice" indicado por el "valor" nuevo
    // Retorna true si hizo el cambio, y falso de otra manera.
    @Override
    public boolean modificar(int indice, Object valor) {
        if (isNumero(valor) == true){
            return super.modificar(indice, valor);
        } else {
            return false;
        }
    }

    // Metodos auxiliares ------------------------------------------------------------------------

    // Este metodo castea un valor del arreglo actual a un numerico
    private double convertir2Double(Object value){
        return Double.parseDouble(value.toString());
    }

    // Este metodo extrae por indice un objeto del arreglo actual y lo devuelve en double
    private Double obtenerDouble(int indice){
        Object valueObj = datos[indice];
        Double valorNum = convertir2Double(valueObj);
        return valorNum;
    }

    // Aquí comienzan los metodos de la práctica -------------------------

    // Este metodo le suma un escalar indicado a cada numero del arreglo actual.
    public boolean sumarEscalar(Number escalar){
        if (vacia() == true){
            return false;
        } else {
            Double valorEscalar = convertir2Double(escalar);
            Double valorActual;
            for (int indexSuma = 0; indexSuma <= indiceSuperior; indexSuma++){
                valorActual = obtenerDouble(indexSuma);
                datos[indexSuma] = valorActual + valorEscalar;
            }
            return true;
        }
    }

    // Este metodo multiplica cada elemento del arreglo actual por el escalar indicado.
    public boolean porEscalar(Number escalar){
        if (vacia() == true){
            return false;
        } else {
            Double valorEscalar = convertir2Double(escalar);

            for (int indexMult = 0; indexMult <= indiceSuperior; indexMult++){
                Double valorActual = obtenerDouble(indexMult);
                datos[indexMult] = valorActual * valorEscalar;
            }
            return true;
        }
    }

    // Este metodo le suma a cada posicion del arreglo actual la posicion correspondiente de lista2
    // es decir, posicion1 + posicion1 de ambos arreglos.
    public boolean sumar(ArregloNumerico lista2){
        // Validar dimensiones
        if (indiceSuperior == lista2.getIndiceSuperior()){ // Son del mismo tamanio
            Double valorLista, valorActual;
            for (int indexSuma = 0; indexSuma <= indiceSuperior; indexSuma++){
                valorActual = obtenerDouble(indexSuma);
                valorLista = lista2.obtenerDouble(indexSuma);
                datos[indexSuma] = valorActual + valorLista;
            }
            return true;
        } else {
            return false;
        }


    }

    // Este metodo multiplica el elemento de la posicion1 del arreglo actual por el elemento de la
    // posicion1 de lista2
    public boolean multiplicar(ArregloNumerico lista2){
        // Validar dimensiones
        if (indiceSuperior == lista2.getIndiceSuperior() && vacia() == false){ // Son del mismo tamanio
            Double valorLista, valorActual;
            for (int indexMult = 0; indexMult <= indiceSuperior; indexMult++){
                valorActual = obtenerDouble(indexMult);
                valorLista = lista2.obtenerDouble(indexMult);
                datos[indexMult] = valorActual * valorLista;
            }
            return true;
        } else {
            return false;
        }
    }

    // Este metodo eleva a la potencia "escalar" cada valor numerico del arreglo actual
    public boolean aplicarPotencia(Number escalar){
        if (vacia() == true){
            return false;
        } else {
            Double valorEscalar = convertir2Double(escalar);

            for (int indexPower = 0; indexPower <= indiceSuperior; indexPower++){
                Double valorActual = obtenerDouble(indexPower);
                datos[indexPower] = Math.pow(valorActual, valorEscalar);
            }
            return true;
        }
    }

    // Este metodo eleva a la potencia indicada en lista2 a cada valor numerico del arreglo
    // segun su posicion correspondiente en el arreglo actual y lista2.
    public boolean aplicarPotencia(ArregloNumerico listaEscalares){
        // Validar dimensiones
        if (indiceSuperior == listaEscalares.getIndiceSuperior() && vacia() == false){ // Son del mismo tamanio
                                                                                        // y no esta vacia
            Double valorLista, valorActual;
            for (int indexPower = 0; indexPower <= indiceSuperior; indexPower++){
                valorActual = obtenerDouble(indexPower);
                valorLista = listaEscalares.obtenerDouble(indexPower);
                datos[indexPower] = Math.pow(valorActual, valorLista);
            }
            return true;
        } else {
            return false;
        }
    }

    // Este metodo retorna un double que es el producto escalar resultante del arreglo actual
    // con lista2. Si no es posible realizar el calculo, retorna null
    public Double productoEscalar(ArregloNumerico lista2){
        // Validar dimensiones
        if (indiceSuperior == lista2.getIndiceSuperior() && vacia() == false){ // Son del mismo tamanio
            Double valorLista, valorActual;
            Double escalar = 0.0;

            for (int indexProduct = 0; indexProduct <= indiceSuperior; indexProduct++){
                valorActual = obtenerDouble(indexProduct);
                valorLista = lista2.obtenerDouble(indexProduct);
                escalar = escalar + valorActual * valorLista;
            }
            return escalar;
        } else {
            return null;
        }
    }
}








