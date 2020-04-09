package ir.am.weatheram.models;

public class Location {
    private String name;
    private String region;
    private String country;
    private Double lat;
    private Double lon;
    private String tzId;
    private int localtimeEpoch;
    private String localtime;

    public String getName(){
        return name;
    }
    public void setName(String input){
        this.name = input;
    }
    public String getRegion(){
        return region;
    }
    public void setRegion(String input){
        this.region = input;
    }
    public String getCountry(){
        return country;
    }
    public void setCountry(String input){
        this.country = input;
    }
    public Double getLat(){
        return lat;
    }
    public void setLat(Double input){
        this.lat = input;
    }
    public Double getLon(){
        return lon;
    }
    public void setLon(Double input){
        this.lon = input;
    }
    public String getTzId(){
        return tzId;
    }
    public void setTzId(String input){
        this.tzId = input;
    }
    public int getLocaltimeEpoch(){
        return localtimeEpoch;
    }
    public void setLocaltimeEpoch(int input){
        this.localtimeEpoch = input;
    }
    public String getLocaltime(){
        return localtime;
    }
    public void setLocaltime(String input){
        this.localtime = input;
    }
}
