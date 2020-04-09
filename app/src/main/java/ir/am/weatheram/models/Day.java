package ir.am.weatheram.models;

public class Day {
    private Double maxtemp_c;
    private Double maxtemp_f;
    private Double mintemp_c;
    private Double mintemp_f;
    private Double avgtemp_c;
    private Double avgtemp_f;
    private Double maxwind_kph;
    private Condition condition;

    public String getMaxtemp_c(){
        return maxtemp_c.toString();
    }
    public void setMaxtemp_c(Double input){
        this.maxtemp_c = input;
    }
    public String getMaxtemp_f(){
        return maxtemp_f.toString();
    }
    public void setMaxtemp_f(Double input){
        this.maxtemp_f = input;
    }
    public String getMintemp_c(){
        return mintemp_c.toString();
    }
    public void setMintemp_c(Double input){
        this.mintemp_c = input;
    }
    public String getMintemp_f(){
        return mintemp_f.toString();
    }
    public void setMintemp_f(Double input){
        this.mintemp_f = input;
    }
    public String getAvgtemp_c(){
        return avgtemp_c.toString();
    }
    public void setAvgtemp_c(Double input){
        this.avgtemp_c = input;
    }
    public String getAvgtemp_f(){
        return avgtemp_f.toString();
    }
    public void setAvgtemp_f(Double input){
        this.avgtemp_f = input;
    }
    public String getMaxwind_kph(){
        return maxwind_kph.toString();
    }
    public void setMaxwind_kph(Double input){
        this.maxwind_kph = input;
    }
    public Condition getCondition(){
        return condition;
    }
    public void setCondition(Condition input){
        this.condition = input;
    }
}
