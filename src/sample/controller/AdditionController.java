package sample.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.collections.ObservableList;
import javafx.beans.value.ChangeListener;

public class AdditionController {

    @FXML
    private Label maintittle;

    @FXML
    private JFXButton startbutton;

    @FXML
    private Label rangolabel;

    @FXML
    private Label preguntaslabel;

    @FXML
    private Label tiempolabel;


    @FXML
    private ImageView tiempoimage;

    @FXML
    private ImageView preguntasimage;

    @FXML
    private ImageView rangoimage;

    @FXML
    private JFXComboBox<String> rangocombobox;

    @FXML
    private JFXComboBox<String> preguntascombobox;

    @FXML
    private JFXComboBox<String> tiempocombobox;

    @FXML
    private ImageView backimage;


    /****   ATRIBUTOS INTERNOS ****/
    private static String rangeSelected;
    private static String questionsSelected;
    private static String timeSelected;
    /*** FIN ATRIBUTOS INTERNOS ***/

    public static String getRangoSelected() {
        return rangeSelected;
    }

    public static String geTiempoSelected() {
        return timeSelected;
    }

    public static String getPreguntasSelected() {
        return questionsSelected;
    }


    public static AdditionController getInstance() {
        return new AdditionController();
    }

    @FXML
    public void initialize() {
        //Limpiando las etiquetas de los combobox.
        rangocombobox.getItems().removeAll(rangocombobox.getItems());
        preguntascombobox.getItems().removeAll(preguntascombobox.getItems());
        tiempocombobox.getItems().removeAll(tiempocombobox.getItems());

        //añadiendo etiquetas a los combox.
        rangocombobox.getItems().addAll("0-5", "0-10", "11-20", "20-50");
        preguntascombobox.getItems().addAll("10", "20", "30");
        tiempocombobox.getItems().addAll("5 seg", "15 seg", "30 seg", "Ilimitado");

        //definiendo type and size de la letra.
        rangocombobox.setStyle("-fx-font: 30px \"Serif\";");
        preguntascombobox.setStyle("-fx-font: 30px \"Serif\";");
        tiempocombobox.setStyle("-fx-font: 30px \"Serif\";");

        //combobox rango
        rangocombobox.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                if (!rangocombobox.getSelectionModel().isEmpty()) {
                    rangeSelected = rangocombobox.getSelectionModel().getSelectedItem();
                }

            }
        });

        //combobox preguntas
        preguntascombobox.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                if (!preguntascombobox.getSelectionModel().isEmpty())
                    questionsSelected = preguntascombobox.getSelectionModel().getSelectedItem();
            }
        });

        //combobox tiempo
        tiempocombobox.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                if (!tiempocombobox.getSelectionModel().isEmpty())
                    timeSelected = tiempocombobox.getSelectionModel().getSelectedItem();
            }
        });

        //boton jugar
        startbutton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (!rangocombobox.getSelectionModel().isEmpty())
                    if (!preguntascombobox.getSelectionModel().isEmpty())
                        if (!tiempocombobox.getSelectionModel().isEmpty())
                            playGame();

            }
        });


    }

    public void goBackMenu(MouseEvent e) {

        try {

            Parent root = FXMLLoader.load(getClass().getResource("/sample/vistas/menu.fxml"));
            Stage Stage = new Stage();
            Stage.setResizable(false);
            Stage.setTitle("hello world");
            Stage.setScene(new Scene(root, 1280, 768));
            Stage.show();

        } catch (Exception exception) {
            System.out.println("Algo salio mal cargando playsuma!" + exception.getMessage());
        } finally {
            backimage.getScene().getWindow().hide();
        }
    }


    //funcion para ir al quiz
    private void playGame() {
        try {

            Parent root = FXMLLoader.load(getClass().getResource("/sample/vistas/gameSuma.fxml"));
            Stage Stage = new Stage();
            Stage.setResizable(false);
            Stage.setTitle("hello world");
            Stage.setScene(new Scene(root, 1280, 768));
            Stage.show();

        } catch (Exception exception) {
            System.out.println("Algo salio mal cargando playsuma!" + exception.getMessage());
            exception.printStackTrace();
        } finally {
            backimage.getScene().getWindow().hide();
        }

    }


}
