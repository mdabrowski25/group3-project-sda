package pl.sdacademy.JavaFx;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import pl.sdacademy.entity.CovidDao;

public class MainUI extends VBox {
    CovidDao covidDao;
    TextField textFieldMenu = new TextField("Menu glowne");
    TextField textFieldData = new TextField("Dane zaktualizowano XX.XX.XXXX");
    Button buttonUpdate = new Button("Aktualizuj dane");
    Button buttonShow = new Button("Wyswietl wykres");

    public MainUI(CovidDao covidDao) {
        this.covidDao = covidDao;
    }

    public MainUI() {
    }

    public void makeVbox() {
        textFieldMenu.setDisable(true);
        textFieldMenu.setStyle("-fx-opacity: 1;");
        textFieldData.setDisable(true);
        textFieldData.setStyle("-fx-opacity: 1;");
        this.getChildren().add(textFieldMenu);
        this.getChildren().add(textFieldData);
        this.getChildren().add(buttonUpdate);
        this.getChildren().add(buttonShow);
    }

    public void addButtonAction() {
        buttonUpdate.setOnAction(event -> {
            VBox vBox1 = new VBox();
            Scene scene2 = new Scene(vBox1, 200, 200);
            Stage stage1 = new Stage();
            stage1.setScene(scene2);
            stage1.show();
        });
    }

}
