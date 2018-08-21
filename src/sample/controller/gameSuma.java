package sample.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import sample.clases.Quiz;

import java.util.TimerTask;
import java.util.Timer;

public class gameSuma {

    @FXML
    private Label maintittlelabel;

    @FXML
    private Label indicelabel;

    @FXML
    private Label sumalabel;

    @FXML
    private JFXTextField answertextfield;

    @FXML
    private Label indicelabel1;

    @FXML
    private Label timelabel;

    @FXML
    private JFXButton clearbutton;

    @FXML
    private JFXButton SUBMITBUTTON;

    /********ATRIBUTOS PRIVADOS**********/
    private int interval;
    private int tiempoSelected;
    private String rangoSelected;
    private static int preguntasSelected;
    private int pregunta_actual = 1;
    private Timer timer;
    private Quiz quiz;
    private static int wrong = 0;
    protected static boolean alive=false;
    /********FIN ATRIBUTOS PRIVADOS*********/


    @FXML
    public void initialize() {

        iniciadatos();
        setTimer();
        imprimePregunta();
    }

    public static void setWrong(int wrong) {
        gameSuma.wrong = wrong;
    }

    public static boolean isAlive() {
        return alive;
    }

    private void juega() {

        SUBMITBUTTON.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                setTimer();
                evaluaRespuesta();
                answertextfield.clear();
                imprimePregunta();
                gameStatus();

            }
        });

        answertextfield.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode().equals(KeyCode.ENTER)) {
                    setTimer();
                    evaluaRespuesta();
                    answertextfield.clear();
                    imprimePregunta();
                    gameStatus();
                }
                if (event.getCode().equals(KeyCode.BACK_SPACE)) {
                    answertextfield.clear();
                }
            }
        });

        clearbutton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                answertextfield.clear();
            }
        });

    }

    private void setTimer() {

        if (timer != null) {  //si existe un timer anterior lo cancela y crea uno nuevo.
            timer.cancel();
        }

        interval = tiempoSelected; //renueva el intervalo en cada llamada a la funcion.
        timer = new Timer();

        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                if (interval > 0) {
                    Platform.runLater(() -> timelabel.setText(Integer.toString(interval)));
                    Platform.runLater(() -> juega());
                    Platform.runLater(()->gameStatus());
                    interval--;
                } else {
                    timer.cancel();
                    setTimer();
                    answertextfield.clear();
                    Platform.runLater(()->imprimePregunta());
                    wrong++;
                }

            }
        }, 1000, 1000);


    }


    private void iniciadatos() {
        preguntasSelected = Integer.valueOf(AdditionController.getPreguntasSelected().trim());
        rangoSelected = AdditionController.getRangoSelected();
        String s = AdditionController.geTiempoSelected().trim();
        alive=true;
        gameResta.alive=false;
        gameMultiplicacion.alive=false;
        gameDivision.alive=false;

        System.out.println("caneda " + s);


        switch (s) {
            case "5 seg":
                interval = tiempoSelected = 5 + 1;
                break;
            case "15 seg":
                interval = tiempoSelected = 15 + 1;
                break;
            case "30 seg":
                interval = tiempoSelected = 30 + 1;
                break;

            case "Ilimitado":
                interval = tiempoSelected = 100;
                break;
        }


        switch (rangoSelected) {
            case "0-5":
                maintittlelabel.setText("SUMA : 0-5");
                quiz = new Quiz("preguntassuma0-5.txt", "respuestassuma0-5.txt");
                break;
            case "0-10":
                maintittlelabel.setText("SUMA : 0-10");
                quiz = new Quiz("preguntassuma0-10.txt", "respuestassuma0-10.txt");
                break;
            case "11-20":
                maintittlelabel.setText("SUMA : 11-20");
                quiz = new Quiz("preguntassuma11-20.txt", "respuestassuma11-20.txt");
                break;

            case "20-50":
                maintittlelabel.setText("SUMA : 20-50");
                quiz = new Quiz("preguntassuma20-50.txt", "respuestassuma20-50.txt");
                break;
        }


    }

    private void setIndiceLabel() {
        indicelabel.setText("Pregunta " + (pregunta_actual++) + " de " + preguntasSelected);
    }


    private void imprimePregunta() {
        sumalabel.setText(quiz.getPreguntaRandom());
        setIndiceLabel();
    }

    private void evaluaRespuesta() {
        String answer = answertextfield.getText();
        String correctAnswer = quiz.getRespuestaRandom();

        if (!answer.equals(correctAnswer)) {
            wrong++;
            System.out.println("mal contestada");
        } else {
            System.out.println("contestaste bien");
        }
    }


    private void gameStatus() {
        if ((pregunta_actual-1) > preguntasSelected ) {
            timer.cancel(); //se detiene el reloj
            //Aqui ira la nueva view donde se muestran los resultados.
            System.out.println("tus aciertos son:" + (preguntasSelected - wrong));
            System.out.println("tu errores:" + wrong);
            goResults();
        }
    }

    public static int getWrong() {
        return wrong;
    }

    public static int getPreguntasSelected(){
        return preguntasSelected;
    }


    private void goResults() {

        try {

            Parent root = FXMLLoader.load(getClass().getResource("/sample/vistas/resultados.fxml"));
            Stage Stage = new Stage();
            Stage.setResizable(false);
            Stage.setTitle("hello world");
            Stage.setScene(new Scene(root, 1280, 768));
            Stage.show();

        } catch (Exception exception) {
            System.out.println("Algo salio mal cargando goresults de gamesuma!" + exception.getMessage());
            exception.printStackTrace();
        } finally {
            Stage oldScene = (Stage) answertextfield.getScene().getWindow();
            oldScene.hide();
        }

    }


}
