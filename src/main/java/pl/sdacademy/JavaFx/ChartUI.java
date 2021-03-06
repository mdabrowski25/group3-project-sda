package pl.sdacademy.JavaFx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.Axis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import pl.sdacademy.apiCore.ApiDataProvider;
import pl.sdacademy.apiCore.WorldCoronaPeople;
import pl.sdacademy.entity.Country;
import pl.sdacademy.entity.CovidDao;
import pl.sdacademy.entity.DbCovidDao;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class ChartUI extends VBox {
    private DbCovidDao dbCovidDao = new DbCovidDao();
    private CovidDao covidDao;
    private Integer globalTotalConfirmed = dbCovidDao.getCurrentWorldData().getTotal_cases();
    private Integer globalTotalDeaths = dbCovidDao.getCurrentWorldData().getTotal_deaths();

    private LocalDate dateFrom;
    private LocalDate dateTo;

    public ChartUI() {
        this.covidDao = covidDao;

        HBox listBox = new HBox();
        List<Country> countries = dbCovidDao.getCountries();
        List<String> countriesName = countries.stream().map(Country::getName).collect(Collectors.toList());
        ObservableList<String> data = FXCollections.observableList(countriesName);

        DatePicker datePickerFrom = new DatePicker();
        DatePicker datePickerTo = new DatePicker();

        Button buttonShow = new Button("Pokaz wykres");


        ObservableList<XYChart.Data> dataList = FXCollections.observableArrayList(
                new XYChart.Data(0, 0),
                new XYChart.Data<>(50, 50)

        );
        ObservableList<XYChart.Series> seriesList = FXCollections.observableArrayList();
        seriesList.add(new XYChart.Series("Example", dataList));

        Axis xAxis = new NumberAxis();
        Axis yAxis = new NumberAxis();
        LineChart chart = new LineChart(xAxis, yAxis, seriesList);

        this.getChildren().add(new Label("Wykres"));
        this.getChildren().add(new Label("Aktualnie zarazonych na swiecie"));
        this.getChildren().add(new Label(globalTotalConfirmed.toString()));
        this.getChildren().add(new Label("Laczna liczba zgonow na swiecie"));
        this.getChildren().add(new Label(globalTotalDeaths.toString()));
        this.getChildren().add(new Label("Wybierz kraj:"));
        listBox.getChildren().add(new ListView<String>(data));
        listBox.setPrefHeight(200.0);
        this.getChildren().add(listBox);
        this.getChildren().add(new Label("Wybierz zakres dat"));
        this.getChildren().add(datePickerFrom);
        this.getChildren().add(datePickerTo);
        buttonShow.setOnAction(action -> {
            dateFrom = datePickerFrom.getValue();
            dateTo = datePickerFrom.getValue();
        });
        this.getChildren().add(buttonShow);
        this.getChildren().add(chart);
    }

}
