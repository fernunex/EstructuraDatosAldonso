    package tools.matematicas;
    
    import edlineal.ListaDin;
    import edlineal.ListaDinNumerica;
    import edlineal.auxiliares.ClaveValor;
    import entradasalida.Salida;
    
    // Esta es una calculadora estadistica
    // Calcula pearson media, moda, desviacion, etc (aún no esta completa)
    public class CalcEstadistica {
    
        // Calcula la media de la lista numerica actual
        static public double calcularMedia(ListaDinNumerica x){
            double suma = x.calcularSumatoria();
            return suma / x.noElementos();
        }
    
        // Este metodo calcula la correlacion de pearson r
        static public double coeficientRPearson(ListaDinNumerica x, ListaDinNumerica y){
            double sumatoriaX = x.calcularSumatoria();
            double sumatoriaY = y.calcularSumatoria();
    
            ListaDinNumerica x_y = ((ListaDinNumerica) x.clonar());
            x_y.multiplicarPorLista(y);
    
            double sumatoriaX_Y = x_y.calcularSumatoria();
    
            int n = x.noElementos();
    
            ListaDinNumerica xSquared = ((ListaDinNumerica) x.clonar());
            xSquared.elevarAPotencia(2);
            ListaDinNumerica ySquared = ((ListaDinNumerica) y.clonar());
            ySquared.elevarAPotencia(2);
    
            double sumatoriaSquaX = xSquared.calcularSumatoria();
            double sumatoriaSquaY = ySquared.calcularSumatoria();
    
            double numerator = n*(sumatoriaX_Y)-(sumatoriaX*sumatoriaY);
            double den1 = n*(sumatoriaSquaX) - (sumatoriaX*sumatoriaX);
            double den2 = n*(sumatoriaSquaY) - (sumatoriaY*sumatoriaY);
            double denominator = Math.sqrt(den1*den2);
    
            return numerator/denominator;
        }
    
        // Este metodo interpreta un valor del Coeficiente de Pearson
        static public String interpreteCoefPearson(double coef){
            coef = round(coef, 1); // 1
            if (coef == 0.0){
                return "Ninguna correlación";
            } else if (coef == 1.0) {
                return "Correlación positiva perfecta";
            }else if (coef > 0.0 && coef < 1.0) {
                return "Correlación positiva";
            }else if (coef == -1.0) {
                return "Correlación negativa perfecta";
            }else{
                return "Correlación negativa";
            }
        }
    
        // Este metodo interpreta un valor del Coeficiente de Pearson
        static public String interpreteAsociacion(double coef){
            coef = round(coef, 1); // 1
            if (coef == 0.0){
                return "Asociación nula";
            } else if (coef >= 0.9) {
                return "Asociación muy alta";
            }else if (coef >= 0.7) {
                return "Asociación alta";
            }else if (coef >= 0.5) {
                return "Asociación moderada";
            }else if (coef >= 0.3) {
                return "Asociación mediana";
            }else if (coef >= 0.1) {
                return "Asociación pequeña";
            }else{
                //https://youtu.be/QckIzHC99Xc
                return "Asociación nula";
            }
        }
    
        // Este metodo redondea un double a una cantidad de decimales especificada
        static public double round(double valor, int decimales){
            double escalador = Math.pow(10, decimales);
            double redondeado = Math.round(valor * escalador) / escalador;
            return redondeado;
        }
    
        // Este metodo calcula la covarianza muestral de dos set de datos
        static public double covarianza(ListaDinNumerica x, ListaDinNumerica y){
            double meanX = calcularMedia(x);
            double meanY = calcularMedia(y);
    
            int N = x.noElementos();
    
            x.restarEscalar(meanX); // x - x_mean
            y.restarEscalar(meanY); // y - y_mean
    
            x.multiplicarPorLista(y); // x * y ya con la diferencia de las medias
    
            return x.calcularSumatoria() / (N - 1);
        }
    
        // Este metodo calcula la desviacion estandar de una variable
        static public double desviacionSTD(ListaDinNumerica x){
            double meanX = calcularMedia(x);
            ListaDinNumerica x_minusMean = (ListaDinNumerica) x.clonar();
            x_minusMean.restarEscalar(meanX);
            x_minusMean.elevarAPotencia(2);
            int N = x_minusMean.noElementos();
    
            return Math.sqrt(x_minusMean.calcularSumatoria() / N);
        }
    
        // Este metodo calcula el coeficiente de Pearson Poblacional
        static public double pearsonPoblacional(ListaDinNumerica x, ListaDinNumerica y){
            double cov = covarianza(
                    (ListaDinNumerica) x.clonar(),
                    (ListaDinNumerica) y.clonar()
            );
    
            double devStdX = desviacionSTD(
                    (ListaDinNumerica) x.clonar()
            );
    
            double devStdY = desviacionSTD(
                    (ListaDinNumerica) y.clonar()
            );
    
            return cov / (devStdX * devStdY);
        }
    
        // Este metodo segmenta un par de valores por el la primer lista
        static public ListaDin segmentarListas(ListaDinNumerica discretas, ListaDinNumerica valores){
            ListaDin lisSegmentada = new ListaDin();
    
            ClaveValor tupla, buscado;
            long clave;
            double valor;
    
            discretas.iniciaIterador();
            valores.iniciaIterador();
            int i = 0;
            while (discretas.iteradorValido()){
                clave = Math.round(((double) discretas.obtenerIterador()));
                valor = (double) valores.obtenerIterador();
    //            System.out.println(clave);
    
    
                buscado = (ClaveValor) lisSegmentada.buscarObjeto(clave);
                if (buscado == null){ // No esiste
                    tupla = new ClaveValor();
                    tupla.setClave(clave);
                    ListaDinNumerica lisSeg = new ListaDinNumerica();
                    lisSeg.poner(valor);
                    tupla.setValor(lisSeg);
                    lisSegmentada.poner(tupla);
                } else { // Si existe, entonces hacemos un append
                    ((ListaDinNumerica)(buscado.getValor())).poner(valor);
                }
                discretas.moverIterador();
                valores.moverIterador();
            }
    //        lisSegmentada.imprimir();
    
            return lisSegmentada;
        }
    
        // Este metodo imprime los minimos y maximos para una variable discretizada
        static public void imprimirMinMax(ListaDinNumerica listaDiscretizar, ListaDinNumerica valores){
            ListaDin discretizada = segmentarListas(listaDiscretizar, valores);
    
            discretizada.iniciaIterador();
            while (discretizada.iteradorValido()){ // Iteramos sobre las tuplas
    
                ClaveValor tupla = (ClaveValor) discretizada.obtenerIterador(); // Extraemos la tupla
                ListaDinNumerica valoresTupla = (ListaDinNumerica) tupla.getValor(); // Extraemos la lista de valores
    
    
                Salida.salidaPorDefecto("El precio minimo y máximo para las casas con "
                        + tupla.getClave() + " habitaciones es " + round(min(valoresTupla), 2)
                        + "k y " + round(max(valoresTupla), 2) +
                        "k\n");
    
                discretizada.moverIterador();
            }
        }
    
    
        // Segmenta los valores de la lista a discretizar 7.2 -> 7, 4.6 -> 5 y a eso le asigna los valores que
        // caigan en esas casillas 7 -> [4.2,4.9, 10.12, ...]
        static public void imprimirPromedios(ListaDinNumerica listaDiscretizar, ListaDinNumerica valores){
            ListaDin discretizada = segmentarListas(listaDiscretizar, valores);
    
            discretizada.iniciaIterador();
            while (discretizada.iteradorValido()){ // Iteramos sobre las tuplas
    
                ClaveValor tupla = (ClaveValor) discretizada.obtenerIterador(); // Extraemos la tupla
                ListaDinNumerica valoresTupla = (ListaDinNumerica) tupla.getValor(); // Extraemos la lista de valores
    
    
                Salida.salidaPorDefecto("El costo promedio de las casas con "
                + tupla.getClave() + " habitaciones es " + round(calcularMedia(valoresTupla), 2)
                + "k\n");
    
                discretizada.moverIterador();
            }
        }
    
        // Este metodo encuentra el minimo en una ListaDinNumerica
        static public Double min(ListaDinNumerica numbers){
            if (numbers.vacia() == true){
                return null;
            } else {
                double min = (double) numbers.verInicio();
                numbers.iniciaIterador();
                while (numbers.iteradorValido()){
                    if (min > (double) numbers.obtenerIterador()){
                        min = (double) numbers.obtenerIterador();
                    }
                    numbers.moverIterador();
                }
                return min;
            }
        }
    
        // Este metodo encuentra el maximo en una ListaDinNumerica
        static public Double max(ListaDinNumerica numbers){
            if (numbers.vacia() == true){
                return null;
            } else {
                double max = (double) numbers.verInicio();
                numbers.iniciaIterador();
                while (numbers.iteradorValido()){
                    if (max < (double) numbers.obtenerIterador()){
                        max = (double) numbers.obtenerIterador();
                    }
                    numbers.moverIterador();
                }
                return max;
            }
        }
    
        // Este metodo calcula el Coeficiente de Pearson muestral
        static public Double pearsonMuestral(ListaDinNumerica x, ListaDinNumerica y){
            if (x.vacia() || y.vacia()){
                return null;
            } else {
                double x_mean = calcularMedia(x);
                double y_mean = calcularMedia(y);
    
                ListaDinNumerica x_minus_mean = (ListaDinNumerica) x.clonar();
                x_minus_mean.restarEscalar(x_mean);
                ListaDinNumerica y_minus_mean = (ListaDinNumerica) y.clonar();
                y_minus_mean.restarEscalar(y_mean);
    
                ListaDinNumerica x_y_mul = (ListaDinNumerica) x_minus_mean.clonar();
                x_y_mul.multiplicarPorLista(y_minus_mean);
                double numerator = x_y_mul.calcularSumatoria();
    
    
                ListaDinNumerica x_minus_mean_squared = (ListaDinNumerica) x_minus_mean;
                x_minus_mean_squared.elevarAPotencia(2);
                ListaDinNumerica y_minus_mean_squared = (ListaDinNumerica) y_minus_mean;
                y_minus_mean_squared.elevarAPotencia(2);
    
                double denominator = x_minus_mean_squared.calcularSumatoria() * y_minus_mean_squared.calcularSumatoria();
                denominator = Math.sqrt(denominator);
    
                return numerator/denominator;
            }
        }
    
    
    }
