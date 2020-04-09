package ir.am.weatheram.models;


import java.util.List;

public class Forecast {
    private List<Forecastday> forecastday;

    public List<Forecastday> getForecastday(){
        return forecastday;
    }
    public void setForecastday(List<Forecastday> input){
        this.forecastday = input;
    }
}
