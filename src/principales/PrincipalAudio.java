package principales;

import edlineal.ArregloNumerico;
import entradasalida.Salida;
import entradasalida.archivos.ArchivoTextoD;
import registros.audio.AudioFileRecord;

public class PrincipalAudio {
    public static void main(String[] args) {
        String PATH_AUDIOS = "/home/fernunex/Documents/Uni/4_sem/EstructuraDatos/ed_aldonso_2025/src/media/audio/";
        String PATH_TXT_AUDIOS = "/home/fernunex/Documents/Uni/4_sem/EstructuraDatos/ed_aldonso_2025/src/media/audio/archivosTexto/";

        // Metodo 1 - 4
        AudioFileRecord miAudio;
        miAudio = new AudioFileRecord(
                PATH_AUDIOS +
                "prueba.wav");
        miAudio.leerAudio();

        // Metodo 5 pre-enfasis -------------------------//
        miAudio.preEnfasis(0.95);

        ArregloNumerico miAudioArr;
        miAudioArr = miAudio.getBufferArr();

        miAudio.escribirAudio();
        ArchivoTextoD.escribir(miAudioArr,
                PATH_TXT_AUDIOS +
                        "pruebaEnfasis.txt");


        // Metodo 6 Subir Volumen -------------------------
//        miAudio.subirVolumen(50);
//
//        ArregloNumerico miAudioArr;
//        miAudioArr = miAudio.getBufferArr();
//
//        miAudio.escribirAudio();
//        ArchivoTextoD.escribir(miAudioArr,
//                PATH_TXT_AUDIOS +
//                        "pruebaSubir.txt");

        // Metodo 7 Bajar Volumen --------------------------
//        miAudio.bajarVolumen(80);
//
//        ArregloNumerico miAudioArr;
//        miAudioArr = miAudio.getBufferArr();
//
//        miAudio.escribirAudio();
//        ArchivoTextoD.escribir(miAudioArr,
//                PATH_TXT_AUDIOS +
//                        "pruebaBajar.txt");

//        Metodo 9 Acelerar audio --------------------------
//        miAudio.acelerarAudio(2);
//
//        ArregloNumerico miAudioArr;
//        miAudioArr = miAudio.getBufferArr();
//
//        miAudio.escribirAudio();
//        ArchivoTextoD.escribir(miAudioArr,
//                PATH_TXT_AUDIOS +
//                        "pruebaAcelerado.txt");

        //        Metodo 10 Decrementar audio --------------------------
//        miAudio.retrasarAudio(2);
//
//        ArregloNumerico miAudioArr;
//        miAudioArr = miAudio.getBufferArr();
//
//        miAudio.escribirAudio();
//        ArchivoTextoD.escribir(miAudioArr,
//                PATH_TXT_AUDIOS +
//                        "pruebaRetrasado.txt");

        //        Metodo 12 Invertir audio X --------------------------
//        miAudio.invertirAudioX();
//
//        ArregloNumerico miAudioArr;
//        miAudioArr = miAudio.getBufferArr();
//
//        miAudio.escribirAudio();
//        ArchivoTextoD.escribir(miAudioArr,
//                PATH_TXT_AUDIOS +
//                        "pruebaInvertidoX.txt");

        //        Metodo 13 Invertir audio Y --------------------------
//        miAudio.invertirAudioY();
//
//        ArregloNumerico miAudioArr;
//        miAudioArr = miAudio.getBufferArr();
//
//        miAudio.escribirAudio();
//        ArchivoTextoD.escribir(miAudioArr,
//                PATH_TXT_AUDIOS +
//                        "pruebaInvertidoY.txt");

        //        Metodo 14 energia de un audio --------------------------
//        AudioFileRecord vocal1, vocal2, vocal3, vocal4, vocal5;
//        miAudio = new AudioFileRecord(
//                PATH_AUDIOS +
//                        "prueba.wav");
//        miAudio.leerAudio();

//        ArregloNumerico miAudioArr;
//        miAudioArr = miAudio.getBufferArr();

//        miAudio.escribirAudio();
//        ArchivoTextoD.escribir(miAudioArr,
//                PATH_TXT_AUDIOS +
//                        "pruebaEnergia.txt");


//      Obteniendo los promedios del silencio
//        AudioFileRecord miAudio;
//        miAudio = new AudioFileRecord(
//                PATH_AUDIOS +
//                        "silencio2.wav");
//        miAudio.leerAudio();
//        ArregloNumerico promediosSilencio =
//                miAudio.promedioMuestrasSilencio();
//
//        Salida.salidaPorDefecto("" +
//                "Promedio Positivo: " +
//                (double) promediosSilencio.obtener(0)
//         + "\n");
//        Salida.salidaPorDefecto("" +
//                "Promedio Negativo: " +
//                (double) promediosSilencio.obtener(1)
//        );

//        ArregloNumerico miAudioArr;
//        miAudioArr = miAudio.getBufferArr();

//        ArchivoTextoD.escribir(miAudioArr,
//                PATH_TXT_AUDIOS +
//                        "silencio3.txt");


        //        Metodo 11 Eliminar silencio --------------------------
//        miAudio.eliminarSilencio();
//
//        ArregloNumerico miAudioArr;
//        miAudioArr = miAudio.getBufferArr();
//
//        miAudio.escribirAudio();
//        ArchivoTextoD.escribir(miAudioArr,
//                PATH_TXT_AUDIOS +
//                        "pruebaSinSilencio.txt");


        //        Metodo 14 energia de un audio --------------------------
        // Calculando la energia de la vocal a, pero se utilizara
        // el mismo codigo para calcular el de todas las vocales
        AudioFileRecord vocal1, vocal2, vocal3, vocal4, vocal5;
        String PATH_VOLCALES = PATH_AUDIOS + "vocales/";
        vocal1 = new AudioFileRecord(PATH_VOLCALES + "u1.wav");
        vocal2 = new AudioFileRecord(PATH_VOLCALES + "u2.wav");
        vocal3 = new AudioFileRecord(PATH_VOLCALES + "u3.wav");
        vocal4 = new AudioFileRecord(PATH_VOLCALES + "u4.wav");
        vocal5 = new AudioFileRecord(PATH_VOLCALES + "u5.wav");

        vocal1.leerAudio();
        vocal2.leerAudio();
        vocal3.leerAudio();
        vocal4.leerAudio();
        vocal5.leerAudio();

        Salida.salidaPorDefecto("5 Muestras de la " +
                "energía de la vocal a: \n");
        Salida.salidaPorDefecto(vocal1.calcularEnergia()
                + "\n");
        Salida.salidaPorDefecto(vocal2.calcularEnergia()
                + "\n");
        Salida.salidaPorDefecto(vocal3.calcularEnergia()
                + "\n");
        Salida.salidaPorDefecto(vocal4.calcularEnergia()
                + "\n");
        Salida.salidaPorDefecto(vocal5.calcularEnergia()
                + "\n");


    }
}
