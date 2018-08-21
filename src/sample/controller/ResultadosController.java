package sample.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ResultadosController {

    @FXML
    private Label maintittlelabel;

    @FXML
    private Label indicelabel;

    @FXML
    private Label label;

    @FXML
    private Label label1;

    @FXML
    private Label aciertoslabel;

    @FXML
    private Label erroreslabel;

    @FXML
    private JFXButton homeButton;


    public void initialize() {
        cargaDatos();

        homeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                goHome();
            }
        });





    }


    private void goHome() {
        try {

            Parent root = FXMLLoader.load(getClass().getResource("/sample/vistas/menu.fxml"));
            Stage Stage = new Stage();
            Stage.setResizable(false);
            Stage.setTitle("hello world");
            Stage.setScene(new Scene(root, 1280, 768));
            Stage.show();

        } catch (Exception exception) {
            System.out.println("Algo salio mal cargando menu!" + exception.getMessage());
        } finally {
            Stage oldstage = (Stage) homeButton.getScene().getWindow();
            oldstage.hide();
        }
    }

    private void cargaDatos() {
        boolean suma = gameSuma.isAlive();
        boolean resta = gameResta.isAlive();
        boolean mul = gameMultiplicacion.isAlive();
        boolean div = gameDivision.isAlive();

        if (suma){
            System.out.println("juego anterior suma");
            aciertoslabel.setText(String.valueOf(gameSuma.getPreguntasSelected() - gameSuma.getWrong()));
            erroreslabel.setText(String.valueOf(gameSuma.getWrong()));


        }
        else  if (resta){
            System.out.println("juego anterior resta");
            aciertoslabel.setText(String.valueOf(gameResta.getPreguntasSelected() - gameResta.getWrong()));
            erroreslabel.setText(String.valueOf(gameResta.getWrong()));
        }

        else if (mul){
            System.out.println("juego anterior mul");
            aciertoslabel.setText(String.valueOf(gameMultiplicacion.getPreguntasSelected() - gameMultiplicacion.getWrong()));
            erroreslabel.setText(String.valueOf(gameMultiplicacion.getWrong()));
        }
        else if(div) {
            System.out.println("juego anterior div");
            aciertoslabel.setText(String.valueOf(gameDivision.getPreguntasSelected() - gameDivision.getWrong()));
            erroreslabel.setText(String.valueOf(gameDivision.getWrong()));
        }
        else {
            System.out.println("no entro en ninguno");
        }


            gameSuma.setWrong(0);
            gameMultiplicacion.setWrong(0);
            gameDivision.setWrong(0);
            gameResta.setWrong(0);


    }
}
