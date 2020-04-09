package ir.am.weatheram.models;

public class Forecastday {
    private String date;
    private Day day;
    private Astro astro;

    public String getDate(){
        return date;
    }
    public void setDate(String input){
        this.date = input;
    }
    public Day getDay(){
        return day;
    }
    public void setDay(Day input){
        this.day = input;
    }
    public Astro getAstro(){
        return astro;
    }
    public void setAstro(Astro input){
        this.astro = input;
    }
}
