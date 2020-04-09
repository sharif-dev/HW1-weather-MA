package ir.am.weatheram.models;

public class Current {
    private String lastUpdated;
    private int tempC;
    private int tempF;
    private Condition condition;
    private int windKph;
    private String windDir;
    private int uv;

    public String getLastUpdated(){
        return lastUpdated;
    }
    public void setLastUpdated(String input){
        this.lastUpdated = input;
    }
    public int getTempC(){
        return tempC;
    }
    public void setTempC(int input){
        this.tempC = input;
    }
    public int getTempF(){
        return tempF;
    }
    public void setTempF(int input){
        this.tempF = input;
    }
    public Condition getCondition(){
        return condition;
    }
    public void setCondition(Condition input){
        this.condition = input;
    }
    public int getWindKph(){
        return windKph;
    }
    public void setWindKph(int input){
        this.windKph = input;
    }
    public String getWindDir(){
        return windDir;
    }
    public void setWindDir(String input){
        this.windDir = input;
    }
    public int getUv(){
        return uv;
    }
    public void setUv(int input){
        this.uv = input;
    }
}
