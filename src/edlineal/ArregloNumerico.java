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
    public Double obtener(int indice) {
        return (double) super.obtener(indice);
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
    protected Double obtenerDouble(int indice){
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

    // Este metodo calcula la norma L2 del arreglo actual
    public Double norma(){
        if ((vacia() == false)){
            Double norma = 0.0;
            Double valorActual;

            for (int indexPos = 0; indexPos <= indiceSuperior; indexPos++){
                valorActual = obtenerDouble(indexPos);
                norma = norma + Math.pow(valorActual, 2);
            }

            norma = Math.sqrt(norma);
            return norma;
        } else {
            return null;
        }
    }

    // Este metodo calcula la norma euclideana entre el arreglo actual y el
    // arreglo pasado por argumento
    public Double normaEuclideana(ArregloNumerico arreglo2){
        if ((vacia() == false) && (indiceSuperior == arreglo2.getIndiceSuperior())){
            Double normaEuc = 0.0;
            Double valorActual, valorLista;

            for (int indexPos = 0; indexPos <= indiceSuperior; indexPos++){
                valorActual = obtenerDouble(indexPos);
                valorLista = arreglo2.obtenerDouble(indexPos);
                normaEuc = normaEuc + Math.pow((valorLista - valorActual), 2);
            }

            normaEuc = Math.sqrt(normaEuc);
            return normaEuc;
        } else {
            return null;
        }
    }

    // Este metodo suma varias listas contenidas en el arreglo listas al arreglo actual
    public boolean sumarListaEstatica(Arreglo listas){
        if (vacia() == false){
            // Validar dimensiones de todas las listas a sumar
            ArregloNumerico arregloN;
            for (int indexLista = 0; indexLista <= listas.getIndiceSuperior(); indexLista++){
                arregloN = (ArregloNumerico) listas.obtener(indexLista);
                if (arregloN.getIndiceSuperior() != indiceSuperior){ // No son del mismo tamaño, no se
                                                                    // pueden sumar en mi metodo
                    return false;
                }
            }

            // Realizar la suma, si es que todas las listas pasaron el test de arriba
            for (int indexLista = 0; indexLista <= listas.getIndiceSuperior(); indexLista++){
                arregloN = (ArregloNumerico) listas.obtener(indexLista);
                sumar(arregloN);
            }
            return true;
        } else { // Si esta vacia, entonces no hay nada que sumar.
            return false;
        }
    }

    // Este metodo suma varios escalares al arreglo actual. Retorna true si lo realizó
    // exitosamente o false si no.
    public boolean sumarEscalares(ArregloNumerico escalares){
        if (vacia() == false){

            for (int indexEscalar = 0; indexEscalar <= escalares.getIndiceSuperior(); indexEscalar++){
                sumarEscalar(escalares.obtenerDouble(indexEscalar));
            }
            return true;
        } else { // esta vacia, entonces no podemos hacer mucho
            return false;
        }
    }

    // Este metodo suma valores del arreglo actual especificados por una lista de indices
    // en listaIndices
    public Double sumarIndices(ArregloNumerico listaIndices){
        if (vacia() == false){

            // Validando los indices
            for (int indexIndice = 0; indexIndice <= listaIndices.getIndiceSuperior(); indexIndice++){
                if (validarIndice(listaIndices.obtenerDouble(indexIndice).intValue()) == false){ // Encontro un indice inválido
                    return null;
                }
            }

            // Si llega hasta aqui, entonces todos los indices son validos.
            Double suma = 0.0;

            for (int indexIndice = 0; indexIndice <= listaIndices.getIndiceSuperior(); indexIndice++){
                suma = suma + obtenerDouble(listaIndices.obtenerDouble(indexIndice).intValue());
            }
            return suma;
        } else { // esta vacia, entonces no podemos hacer mucho
            return null;
        }
    }


    // Este metodo retorna un Arreglo con la sublista de los elementos indicados en el
    // arreglo listaIndices.
    @Override
    public Arreglo subLista(ArregloNumerico listaIndices){
        Arreglo subArreglo = super.subLista(listaIndices);
        if (subArreglo != null){
            return subArreglo;
        } else {
            return null;
        }
    }

    // Este metodo regresa un clon de la lista actual
    @Override
    public ListaDatos clonar() {
        ArregloNumerico arreglo2 = new ArregloNumerico(this.capacidad);
        if (vacia() == false){
            for (int indexClone = 0; indexClone <= this.indiceSuperior; indexClone++){
                arreglo2.poner(obtener(indexClone));
            }
        }
        return (ListaDatos) arreglo2;
    }

    // Este metodo retorna -1 si son linealmente dependientes, 1 si son linealmente independientes,
    // y 0 si hubo un error por dimensiones. Lo indicado seria retornar una excepcion.
    private int tipoLinealidad(Arreglo listaVectores){
        if (vacia() == false){
            // Validar Cantidad de vectores
            if (listaVectores.getIndiceSuperior() != indiceSuperior){ // La cantidad de vectores debe ser igual a la
                // de escalares
                return 0;
            }

            // Validar dimensiones de los vectores e ir calculando a la par, si hay un problema pues terminamos
            ArregloNumerico vectorClon, vectorTemp;
            vectorClon = (ArregloNumerico) ((ArregloNumerico) listaVectores.obtener(0)).clonar();
            vectorClon.porEscalar(obtenerDouble(0));

            for (int indexVectores = 1; indexVectores <= listaVectores.getIndiceSuperior(); indexVectores++){
                vectorTemp = (ArregloNumerico) ((ArregloNumerico) listaVectores.obtener(indexVectores)).clonar();
                if (vectorTemp.getIndiceSuperior() != indiceSuperior){ // No son del mismo tamaño, no se puede
                    // multiplicar y sumar los vectores.
                    return 0;
                }

                // Si es de la misma dimension, continuamos con el cálculo.
                vectorTemp.porEscalar(obtenerDouble(indexVectores));
                vectorClon.sumar(vectorTemp);
            }

            // Verificar si todos son ceros.
            for (int indexVClon = 0; indexVClon < indiceSuperior; indexVClon++){
                if (vectorClon.obtenerDouble(indexVClon) != 0.0){ // No son dependientes
                    return 1;
                }
            }

            // Si son dependientes
            return -1;


        } else {
            return 0; // Esta vacia, no se puede hacer nada. Aunque no seria retornar falso, mas bien un Error

        }
    }

    // Este metodo retorna TRUE si los vectores listaVectores son linealmente dependientes en consideracion
    // del conjunto de escalares del arreglo actual, FALSE de otra manera.
    public boolean sonLinealmenteDependientes(Arreglo listaVectores){
        if (tipoLinealidad(listaVectores) < 0){
            return true;
        } else {
            return false;
        }
    }

    // Este metodo retorna TRUE si los vectores listaVectores son linealmente independientes en consideracion
    // del conjunto de escalares del arreglo actual, FALSE de otra manera.
    public boolean sonLinealmenteIndependientes(Arreglo listaVectores){
        if (tipoLinealidad(listaVectores) > 0){
            return true;
        } else {
            return false;
        }
    }

    // Este metodo retorna TRUE si el vector actual es ortogonal al vector lista2, FALSO de otra manera
    public boolean esOrtogonal(ArregloNumerico lista2){
        if (vacia() == false && indiceSuperior == lista2.getIndiceSuperior()){

            ArregloNumerico clonArrActual = (ArregloNumerico) clonar();

            clonArrActual.multiplicar(lista2);

            // Sumar y checar si dio 0
            Double suma = 0.0;
            for (int indexSuma = 0; indexSuma <= indiceSuperior; indexSuma++){
                suma = suma + clonArrActual.obtenerDouble(indexSuma);
            }

            if (suma != 0){ // No es ortogonal
                return false;
            } else { // Es ortogonal
                return true;
            }
        } else { // esta vacia, entonces no podemos hacer mucho
            return false;
        }
    }

    // Este metodo retorna TRUE si el vecotr actual es paralelo al vector lista 2, FALSO de otra manera
    public boolean esParalelo(ArregloNumerico lista2){
        if (vacia() == false && indiceSuperior == lista2.getIndiceSuperior()){

            // Calcular el multiplo
            String multiploPrimero = String.format("%.4f", obtenerDouble(0) / lista2.obtenerDouble(0));
            String multiploTemporal;

            for (int indexMultiplo = 1; indexMultiplo <= indiceSuperior; indexMultiplo++){
                multiploTemporal = String.format("%.4f" ,obtenerDouble(indexMultiplo) / lista2.obtenerDouble(indexMultiplo));
                if (multiploPrimero.equalsIgnoreCase(multiploTemporal) == false){
                    return false;
                }
            }
            // Todos los multiplos son iguales
            return true;

        } else { // esta vacia, entonces no podemos hacer mucho
            return false;
        }
    }

}








