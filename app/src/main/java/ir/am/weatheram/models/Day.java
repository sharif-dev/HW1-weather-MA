package ir.am.weatheram.models;

public class Day {
    private int maxtempC;
    private int maxtempF;
    private int mintempC;
    private int mintempF;
    private int avgtempC;
    private int avgtempF;
    private int maxwindKph;
    private Condition condition;

    public String getMaxtempC(){
        return String.valueOf(maxtempC);
    }
    public void setMaxtempC(Double input){
        this.maxtempC = input.intValue();
    }
    public int getMaxtempF(){
        return maxtempF;
    }
    public void setMaxtempF(Double input){
        this.maxtempF = input.intValue();
    }
    public String getMintempC(){
        return String.valueOf(mintempC);
    }
    public void setMintempC(Double input){
        this.mintempC = input.intValue();
    }
    public String getMintempF(){
        return String.valueOf(mintempF);
    }
    public void setMintempF(Double input){
        this.mintempF = input.intValue();
    }
    public int getAvgtempC(){
        return avgtempC;
    }
    public void setAvgtempC(Double input){
        this.avgtempC = input.intValue();
    }
    public int getAvgtempF(){
        return avgtempF;
    }
    public void setAvgtempF(Double input){
        this.avgtempF = input.intValue();
    }
    public int getMaxwindKph(){
        return maxwindKph;
    }
    public void setMaxwindKph(Double input){
        this.maxwindKph = input.intValue();
    }
    public Condition getCondition(){
        return condition;
    }
    public void setCondition(Condition input){
        this.condition = input;
    }
}
