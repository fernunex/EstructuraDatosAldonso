package registros.audio;

import java.io.*;

import edlineal.ArregloNumerico;
import registros.audio.wavfile.*;

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

    // Funciones auxiliares
    private Object[] double2object(double arr[]){
        Object[] datosObjeto = new Object[arr.length];

        for (int indexBuffer = 0; indexBuffer < datosObjeto.length; indexBuffer++) {
            datosObjeto[indexBuffer] = arr[indexBuffer];
        }

        return datosObjeto;
    }

    private double[] object2double(Object arr[]){
        double[] datosDouble = new double[arr.length];

        for (int indexBuffer = 0; indexBuffer < datosDouble.length; indexBuffer++) {
            datosDouble[indexBuffer] = Double.parseDouble(arr[indexBuffer] + "");
        }
        return datosDouble;
    }

    private double object2double(Object obj){
        return (double) obj;
    }

    // Modificadores del audio

    // Este metodo le aumenta el volumen al audio
    public void subirVolumen(int intensidad){
        bufferArr.porEscalar((1 + ((double) intensidad)/100));

//        for (int indexMuestra = 0; indexMuestra < bufferArr.getCapacidad(); indexMuestra++){
//            double actual = object2double(bufferArr.obtener(indexMuestra));
//
//            bufferArr.modificar(indexMuestra, actual * (1 + ((double) intensidad)/100));
//        }
    }

    // Este metodo le disminuye el volumen al audio
    public void bajarVolumen(int intensidad){
        bufferArr.porEscalar((1 - ((double) intensidad)/100));
//        for (int indexMuestra = 0; indexMuestra < bufferArr.getCapacidad(); indexMuestra++){
//            double actual = object2double(bufferArr.obtener(indexMuestra));
//
//            bufferArr.modificar(indexMuestra, actual * (1 - ((double) intensidad)/100));
//
//        }
    }


}
