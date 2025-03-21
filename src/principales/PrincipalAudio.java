package principales;

import edlineal.ArregloNumerico;
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
    }
}
