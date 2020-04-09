package ir.am.weatheram.models;

public class Astro {
    private String sunrise;
    private String sunset;

    public String getSunrise(){
        return sunrise;
    }
    public void setSunrise(String input){
        this.sunrise = input;
    }
    public String getSunset(){
        return sunset;
    }
    public void setSunset(String input){
        this.sunset = input;
    }
}
