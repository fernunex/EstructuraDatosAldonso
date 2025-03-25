package registros.audio;

import java.io.*;
import java.time.chrono.MinguoDate;

import edlineal.Arreglo;
import edlineal.ArregloNumerico;
import registros.audio.wavfile.*;

import static tools.funciones.Casting.*;

public class AudioFileRecord {
    private long numFrames;  //numero de tramas, número de muestras totales del archivo por canal
    private long sampleRate; //numero de muestras por segundo a la que se discretiza la señal
    private int numChannels; //número de canales
    private double[] buffer; //audio original
    private double[] buffer2; //audio modificado
    private String archivo;   //nombre de archivo dado por el usuario
    private WavFile wavFileR; //apuntador de archivo leido
    private WavFile wavFileW;  //apuntador de archivo a escribir
    private String nomArchivo; //nombre archivo (uno.wav)
    private String nomRuta;    //ruta donde esta guardado el archivo (/home)
    private int validBits;     //bits usados para la discretización
    private ArregloNumerico bufferArr; // audio modificado de tipo ArregloNumerico

    public AudioFileRecord(String archivo) {
        this.archivo = archivo;
        // Abre el archivo wav y asigna parámetros a las variables
        try {
            File file = new File(archivo);
            wavFileR = WavFile.openWavFile(file);
            nomArchivo = file.getName();
            nomRuta = file.getParent();
        } catch (Exception e) {

        }
        numChannels = wavFileR.getNumChannels();
        numFrames = wavFileR.getNumFrames();
        sampleRate = wavFileR.getSampleRate();
        validBits=wavFileR.getValidBits();
    }

    // Metodos acoplados
    public void leerAudio() {
        try {

            // Muestra datos del archivo
            wavFileR.display();

            // Crea buffer de origen y de temporal
            buffer = new double[(int) numFrames * numChannels];
            //buffer2 = new double[buffer.length];

            //tramas leidas
            int framesRead;

            // Lee tramas totales
            framesRead = wavFileR.readFrames(buffer, (int) numFrames);

            // Recorrer todas las tramas del archivo y guardarlas en el arreglo.
            //for (int s = 0; s < framesRead * numChannels; s++) {
            //    buffer2[s] = buffer[s];
            //}

            // Creamos el Arreglo Numerico y lo guardamos ahi
            bufferArr = new ArregloNumerico(buffer.length);

            bufferArr.guardarDatos(double2object(buffer));

            // Cierra archivo
            wavFileR.close();
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public void escribirAudio() {
        try {

            //Crear el apuntador al archivo para guardar datos del temporal
            File file = new File(nomRuta + "/2_" + nomArchivo);

            // Creamos un nuevo archivo de audio con los mismos datos que el original
            wavFileW = WavFile.newWavFile(file, numChannels, numFrames, validBits, sampleRate);

            // Escribimos los frames o muestras totales del temporal

                // Extraemos el audio modificado
                buffer2 = object2double(bufferArr.leerArreglo());

            wavFileW.writeFrames(buffer2, (int) numFrames);
            // Cerramos el archivo
            wavFileW.close();
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public ArregloNumerico getBufferArr(){
        return this.bufferArr;
    }



    // Modificadores del audio

    // Este metodo aplica un preenfasis al audio
    public void preEnfasis(double alpha){
        ArregloNumerico arr2 = new ArregloNumerico(bufferArr.capacidad());

        double muestra_n, muestra_n_anterior;
        muestra_n = (double) bufferArr.obtener(0);
        arr2.poner(muestra_n);

        for (int indexMuestra = 1; indexMuestra < bufferArr.capacidad(); indexMuestra++){
            muestra_n = (double) bufferArr.obtener(indexMuestra);
            muestra_n_anterior = (double) bufferArr.obtener(indexMuestra - 1);

            arr2.poner(muestra_n + (muestra_n_anterior * alpha));
        }

        bufferArr = arr2;

    }

    // Este metodo le aumenta el volumen al audio
    public void subirVolumen(int intensidad){
        bufferArr.porEscalar((1 + ((double) intensidad)/100));
    }

    // Este metodo le disminuye el volumen al audio
    public void bajarVolumen(int intensidad){
        bufferArr.porEscalar((1 - ((double) intensidad)/100));
    }

    // Este metodo acelera el audio 1x (igual), 2x, 3x, etc
    public void acelerarAudio(int incremento){
        int currentIndex = 0;

        // Redondeo hacia abajo
        int cantidadMuestras = bufferArr.cantidad()/incremento;
        double sumaMuestras, promedioMuestras;

        ArregloNumerico audioAcelerado = new ArregloNumerico(cantidadMuestras);

        for (int indexMuestra = 0; indexMuestra <= cantidadMuestras - incremento; indexMuestra++){
            // Sumamos las muestras segun su aceleracion
            // 2x = 2 muestras / 2 (para obtener su promedio)
            sumaMuestras = 0;
            for (int indexNextMues = 0; indexNextMues < incremento; indexNextMues++){
                sumaMuestras += (double) bufferArr.obtener(currentIndex + indexNextMues);

                currentIndex++;
            }

            promedioMuestras = sumaMuestras / incremento;
            audioAcelerado.poner(promedioMuestras);
        }

        bufferArr = audioAcelerado;
        System.out.println(bufferArr.getCapacidad());
    }

    // Este metodo realentiza el audio 2x, 4x, 8x, etc
    public void retrasarAudio(int decremento){
        int vecesEjecutar = decremento / 2;
        ArregloNumerico audioDecrementado;
        int capacidadActual, capacidadNueva;
        double promedio, muestra, muestra_next;

        for (int indexVeces = 0; indexVeces < vecesEjecutar; indexVeces++){
            capacidadActual = bufferArr.capacidad();
            capacidadNueva = (capacidadActual * 2) - 1;

            audioDecrementado = new ArregloNumerico(capacidadNueva);

            for (int indexMuestra = 0; indexMuestra < capacidadActual - 1; indexMuestra++){
                // Le sacamos el promedio de la muestra n y n+1
                muestra = (double) bufferArr.obtener(indexMuestra);
                muestra_next = (double) bufferArr.obtener(indexMuestra + 1);
                promedio = (muestra + muestra_next) / 2;

                audioDecrementado.poner(muestra);
                audioDecrementado.poner(promedio);
            }

            // Ponemos la ultima muestra en el audioDecrementado
            muestra = (double) bufferArr.obtener(capacidadActual - 1);
            audioDecrementado.poner(muestra);
            bufferArr = audioDecrementado;
            numFrames = bufferArr.capacidad();
        }
    }

    // Este metodo invierte el audio en el eje x
    public void invertirAudioX(){
        bufferArr.invertir();
    }

    // Este metodo invierte el audio en el eje y
    public void invertirAudioY(){
        bufferArr.porEscalar(-1);
    }

    // Este metodo calcula la energia del audio
    public double calcularEnergia(){
        double energia = 0;
        double muestra;

        for (int indexMuestra = 0; indexMuestra < bufferArr.capacidad(); indexMuestra++){
            muestra = (double) bufferArr.obtener(indexMuestra);
            energia += Math.pow(muestra, 2);
        }

        return energia;
    }

    // Este metodo retorna el promedio de las muestras positivas y negativas por separado
    // En la posicion 0 guarda las muestras positivas y en la posicion 1 las negativas.
    public ArregloNumerico promedioMuestrasSilencio(){
        int muestrasPositivas = 0;
        int muestrasNegativas = 0;
        double sumaPositivas = 0.0;
        double sumaNegativas = 0.0;
        double muestra;

        for (int indexMuestra = 0; indexMuestra < bufferArr.capacidad(); indexMuestra++){
            muestra = (double) bufferArr.obtener(indexMuestra);

            // Ademas de ser menores a 0.5 y mayores a -0.5 para disminuir los outliers
            if (muestra >= 0 && muestra < 0.6){ // Es positiva
                sumaPositivas += muestra;
                muestrasPositivas++;
            } else { // Es negativa
                if (muestra > -0.6) {
                    sumaNegativas += muestra;
                    muestrasNegativas++;
                }
            }
        }

        ArregloNumerico promedios = new ArregloNumerico(2);
        promedios.poner(sumaPositivas/muestrasPositivas);
        promedios.poner(sumaNegativas/muestrasNegativas);

        return promedios;
    }

    // Este metodo elimina los silencios del audio
    // Tomaremos como silencio los siguientes valores sacados de un audio silencioso y promediando
    // sus ondas negativas y positivas
    //Promedio Positivo: 0.25
    //Promedio Negativo: -0.4
    public void eliminarSilencio(){
        double promedioPositivo = 0.25;
        double promedioNegativo = -0.4;
        double muestra;

        ArregloNumerico audio2 = new ArregloNumerico(bufferArr.capacidad());

        int conteoMuestrasSonido = 0;

        for (int indexMuestra = 0; indexMuestra < bufferArr.capacidad(); indexMuestra++){
            muestra = (double) bufferArr.obtener(indexMuestra);

            if (muestra >= 0 && muestra > promedioPositivo){ // si cataloga como no silencio
                audio2.poner(muestra);
                conteoMuestrasSonido++;
            } else {
                if (muestra < promedioNegativo){ // si catalogo como no silencio
                    audio2.poner(muestra);
                    conteoMuestrasSonido++;
                }
            }
        }

        audio2.redimensionar(conteoMuestrasSonido);
        numFrames = conteoMuestrasSonido;
        bufferArr = audio2;

    }


}
