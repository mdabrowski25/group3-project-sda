package pl.sdacademy.JavaFx;

import javafx.application.Application;
import javafx.scene.Scene;
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