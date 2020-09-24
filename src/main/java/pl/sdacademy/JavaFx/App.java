package pl.sdacademy.JavaFx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {

        MainUI mainUI = new MainUI();
        mainUI.makeVbox();
        Scene scene = new Scene(mainUI, 800, 600);
        stage.setScene(scene);
        stage.setTitle("project_covid-19");
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }

}