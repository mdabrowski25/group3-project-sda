package pl.sdacademy.JavaFx.ChartExample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.Axis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Chart extends Application {
    //Przyklad sciagniety z
    // https://riptutorial.com/pl/javafx/example/28057/wykres-liniowy
    @Override
    public void start(Stage primaryStage) throws Exception{
        Pane root = new Pane();

        // Create empty series
        ObservableList<XYChart.Series> seriesList = FXCollections.observableArrayList();

        // Create data set for the first employee and add it to the series
        ObservableList<XYChart.Data> aList = FXCollections.observableArrayList(
                new XYChart.Data(0, 0),
                new XYChart.Data(2, 6),
                new XYChart.Data(4, 37),
                new XYChart.Data(6, 82),
                new XYChart.Data(8, 115)
        );
        seriesList.add(new XYChart.Series("Employee A", aList));

        // Create data set for the second employee and add it to the series
        ObservableList<XYChart.Data> bList = FXCollections.observableArrayList(
                new XYChart.Data(0, 0),
                new XYChart.Data(2, 43),
                new XYChart.Data(4, 51),
                new XYChart.Data(6, 64),
                new XYChart.Data(8, 92)
        );
        seriesList.add(new XYChart.Series("Employee B", bList));

        // Create axes
        Axis xAxis = new NumberAxis("Hours worked", 0, 8, 1);
        Axis yAxis = new NumberAxis("Lines written", 0, 150, 10);

        LineChart chart = new LineChart(xAxis, yAxis, seriesList);

        root.getChildren().add(chart);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
