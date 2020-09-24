package pl.sdacademy.JavaFx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {

        VBox vBox = new VBox();

        Button button = new Button("Przycisk do klikania");
        button.setOnAction(event -> {
            VBox vBox1 = new VBox();
            TextField textField = new TextField("Pole do wypelnienia");
            vBox1.getChildren().add(textField);
            if (textField.equals("haha")){
                Scene scene3 = new Scene(vBox1, 200, 200);
                Stage stage2 = new Stage();
                stage2.setScene(scene3);
                stage2.show();
                HBox hBox1 = new HBox();
                hBox1.getChildren().add(new Label("hahahhaha!!"));
            }
            Scene scene2 = new Scene(vBox1, 200, 200);
            Stage stage1 = new Stage();
            stage1.setScene(scene2);
            stage1.show();
        });
        HBox hBox = new HBox();
        hBox.getChildren().add(new Label("Kliknij!!!"));
        hBox.getChildren().add(button);

        vBox.getChildren().add(hBox);


        Scene scene = new Scene(vBox, 800, 600);
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }

}