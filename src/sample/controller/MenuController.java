package sample.controller;

import javafx.event.EventHandler ;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import sample.clases.Time;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class MenuController {

    @FXML
    private Label tittleimage;

    @FXML
    private ImageView sumaimage;

    @FXML
    private ImageView multiplicacionimage;

    @FXML
    private ImageView restaimage;

    @FXML
    private ImageView divisionimage;



    public void initialize() {


    }


    public void playSuma(MouseEvent e) {


        try {

            Parent root = FXMLLoader.load(getClass().getResource("/sample/vistas/Addition.fxml"));
            Stage Stage = new Stage();
            Stage.setResizable(false);
            Stage.setTitle("hello world");
            Stage.setScene(new Scene(root, 1280, 768));
            Stage.show();

        } catch (Exception exception) {
            System.out.println("Algo salio mal cargando playsuma!" + exception.getMessage());
        } finally {
            sumaimage.getScene().getWindow().hide();
        }


    }


    public void playResta(MouseEvent e) {


        try {

            Parent root = FXMLLoader.load(getClass().getResource("/sample/vistas/Substraction.fxml"));
            Stage Stage = new Stage();
            Stage.setResizable(false);
            Stage.setTitle("hello world");
            Stage.setScene(new Scene(root, 1280, 768));
            Stage.show();

        } catch (Exception exception) {
            System.out.println("Algo salio mal cargando playsuma!" + exception.getMessage());
        } finally {
            restaimage.getScene().getWindow().hide();
        }
    }


    public void playDivision(MouseEvent e) {


        try {

            Parent root = FXMLLoader.load(getClass().getResource("/sample/vistas/Division.fxml"));
            Stage Stage = new Stage();
            Stage.setResizable(false);
            Stage.setTitle("hello world");
            Stage.setScene(new Scene(root, 1280, 768));
            Stage.show();

        } catch (Exception exception) {
            System.out.println("Algo salio mal cargando playsuma!" + exception.getMessage());
        } finally {
            divisionimage.getScene().getWindow().hide();
        }
    }


    public void playMultiplicacion(MouseEvent e) {


        try {

            Parent root = FXMLLoader.load(getClass().getResource("/sample/vistas/Multiplication.fxml"));
            Stage Stage = new Stage();
            Stage.setResizable(false);
            Stage.setTitle("hello world");
            Stage.setScene(new Scene(root, 1280, 768));
            Stage.show();

        } catch (Exception exception) {
            System.out.println("Algo salio mal cargando MULTIPLICACION EN MENUCONTROLLER!" + exception.getMessage());
        } finally {
            multiplicacionimage.getScene().getWindow().hide();
        }
    }


}
