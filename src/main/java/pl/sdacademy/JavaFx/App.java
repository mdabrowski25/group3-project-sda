package pl.sdacademy.JavaFx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pl.sdacademy.entity.DummyCovidDao;
import pl.sdacademy.entity.JdbcCovidDao;
import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) throws Exception{

        MainUI mainUI = new MainUI();
        mainUI.makeVbox();
        ChartUI chartUI = new ChartUI(new DummyCovidDao());
        Scene scene = new Scene(chartUI, 800, 600);
        mainUI.addButtonAction();
        stage.setScene(scene);
        stage.setTitle("project_covid-19");
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }

}