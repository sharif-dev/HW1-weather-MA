package ir.am.weatheram.models;

public class WeatherResult {
    private Location location;
    private Current current;
    private Forecast forecast;
    private Alert alert;

    public Location getLocation(){
        return location;
    }
    public void setLocation(Location input){
        this.location = input;
    }
    public Current getCurrent(){
        return current;
    }
    public void setCurrent(Current input){
        this.current = input;
    }
    public Forecast getForecast(){
        return forecast;
    }
    public void setForecast(Forecast input){
        this.forecast = input;
    }
    public Alert getAlert(){
        return alert;
    }
    public void setAlert(Alert input){
        this.alert = input;
    }
}
