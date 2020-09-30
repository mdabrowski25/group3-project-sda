package pl.sdacademy.JavaFx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
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
        ChartUI chartUI = new ChartUI(new JdbcCovidDao(getConnectionToProject_Covid()));
        Scene scene = new Scene(chartUI, 800, 600);
        mainUI.addButtonAction();
        stage.setScene(scene);
        stage.setTitle("project_covid-19");
        stage.show();

    }
    private static Connection getConnectionToProject_Covid() {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUser("root");
        dataSource.setPassword("123456");
        dataSource.setDatabaseName("project_covid-19");
        try {
            dataSource.setServerTimezone("UTC");
            return dataSource.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
      return null;
    }

    public static void main(String[] args) {
        launch();
    }

}