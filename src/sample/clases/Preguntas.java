package sample.clases;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

public class Preguntas {

    public ArrayList<Pregunta> listadoPreguntas = new ArrayList<Pregunta>();
    private String questionFile;
    private String answerFile;
    private int answersRead;

    public Preguntas(String questionFile, String answerFile) {
        this.questionFile = questionFile;
        this.answerFile = answerFile;
        readPreguntas();
    }


    public Pregunta getPregunta(int index) {

        return listadoPreguntas.get(index);

    }

    //Funcion para leer las preguntas de nuestros archivos de texto
    private void readPreguntas() {


        Scanner questionIn = null, answerIn = null;
        String pregunta, respuesta;

        //Se crean los flujos.
        /******NOTA: LOS .TXT NO DEBEN TENER LINEAS NULAS******/
        try {

            questionIn = new Scanner(new File(questionFile));
            answerIn = new Scanner(new File(answerFile));

            while (questionIn.hasNextLine()) {
                pregunta = questionIn.nextLine();
                respuesta = answerIn.nextLine();
                listadoPreguntas.add(new Pregunta(pregunta, new Respuesta(respuesta)));
                answersRead++;
            }


        } catch (Exception e) {
            System.out.println("Algo salio mal!!!" + e.getCause() + e.getMessage());
            e.printStackTrace();
        } finally {
            if (questionIn != null)
                questionIn.close();

            if (answerIn != null)
                answerIn.close();


            //System.out.println("preguntas leidas =" + answersRead);
        }
    }


    public int getAnswersRead(){return this.answersRead;}
}
