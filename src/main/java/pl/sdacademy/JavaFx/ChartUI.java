package pl.sdacademy.JavaFx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import pl.sdacademy.ApiDataProvider;
import pl.sdacademy.ApiObjectToEntityMapper;
import pl.sdacademy.CountryCoronaPeople;
import pl.sdacademy.WorldCoronaPeople;
import pl.sdacademy.entity.Country;
import pl.sdacademy.entity.CovidDao;

import java.time.LocalDate;
import java.util.List;

public class ChartUI extends VBox {

    ApiDataProvider<WorldCoronaPeople> apiDataProvider = new ApiDataProvider<>();
    WorldCoronaPeople worldCoronaPeople = apiDataProvider.get("https://api.thevirustracker.com/free-api?global=stats", WorldCoronaPeople.class);

    private Integer globalTotalConfirmed = worldCoronaPeople.getResult().getTotal_cases();
    private Integer globalTotalDeaths = worldCoronaPeople.getResult().getTotal_deaths();
    private CovidDao covidDao;
    private LocalDate dateFrom;
    private LocalDate dateTo;

    public ChartUI(CovidDao covidDao) {
        this.covidDao = covidDao;
        List<Country> countries = covidDao.getCountries();
        ObservableList<Country> data = FXCollections.observableList(countries);
        DatePicker datePickerFrom = new DatePicker();
        DatePicker datePickerTo = new DatePicker();
        Button buttonShow = new Button("Pokaz wykres");
        this.getChildren().add(new Label("Wykres"));
        this.getChildren().add(new Label("Aktualnie zarazonych na swiecie"));
        this.getChildren().add(new Label(globalTotalConfirmed.toString()));
        this.getChildren().add(new Label("Laczna liczba zgonow na swiecie"));
        this.getChildren().add(new Label(globalTotalDeaths.toString()));
        this.getChildren().add(new Label("Wybierz kraj:"));
        this.getChildren().add(new ListView<Country>(data));
        this.getChildren().add(new Label("Wybierz zakres dat"));
        this.getChildren().add(datePickerFrom);
        this.getChildren().add(datePickerTo);
        buttonShow.setOnAction(action -> {
            dateFrom = datePickerFrom.getValue();
            dateTo = datePickerFrom.getValue();
        });
        this.getChildren().add(buttonShow);
    }

}
