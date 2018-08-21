package sample.clases;

import java.util.ArrayList;

public class Pregunta {
protected String enunciado;     // El texto de la pregunta
protected Respuesta respuesta;

public Pregunta (String enunciado,Respuesta respuesta){
        this.enunciado=enunciado;
        this.respuesta=respuesta;
}


public Respuesta getRespuesta(){
        return respuesta;
}

public String getEnunciado(){
        return enunciado;
}

}
