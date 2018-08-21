package sample.clases;

import java.util.HashSet;
import java.util.Iterator;

public class Quiz {

    public String materia = null;
    protected Preguntas questions = null;
    protected HashSet<Integer> randomNum = null;
    protected Iterator ite;
    private int tope;

    public Quiz(String preguntasTXT, String respuestaTXT, int gameQuestion) {
        this(null, preguntasTXT, respuestaTXT, gameQuestion);
        questions = new Preguntas(preguntasTXT, respuestaTXT);
        this.randomNum = randomQuestionIndex(gameQuestion, questions.getAnswersRead());
        this.ite = randomNum.iterator();
        tope = -1;
    }

    public Quiz(String preguntasTXT, String respuestaTXT) {
        questions = new Preguntas(preguntasTXT, respuestaTXT);
        tope = -1;
    }



    public Quiz(String materia, String preguntasTXT, String respuestaTXT, int gameQuestion) {
        this.materia = materia;
        questions = new Preguntas(preguntasTXT, respuestaTXT);
        this.randomNum = randomQuestionIndex(gameQuestion, questions.getAnswersRead());
        this.ite = randomNum.iterator();
        tope = -1;
    }

    public String getPreguntaRandom() {
        //pop();
        return questions.getPregunta(++tope).getEnunciado();
    }


    public String getRespuestaRandom() {
            return questions.getPregunta(tope).getRespuesta().getOpcionTexto();

    }



    private HashSet<Integer> randomQuestionIndex(int preguntasJuego, int numPreguntasDisponibles) {
        HashSet<Integer> randomNum = new HashSet<Integer>(preguntasJuego);
        do {
            randomNum.add((int) (Math.random() * ((numPreguntasDisponibles - 2) + 1)) + 1);
        } while (randomNum.size() != preguntasJuego);
        return randomNum;
    }

   /* private void pop() {
        tope = ((Integer) ite.next()).intValue();
    }
*/


}
