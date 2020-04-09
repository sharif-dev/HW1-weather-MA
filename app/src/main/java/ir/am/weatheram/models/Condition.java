package ir.am.weatheram.models;

public class Condition {
    private String text;
    private String icon;

    public String getText(){
        return text;
    }
    public void setText(String input){
        this.text = input;
    }
    public String getIcon(){
        return icon;
    }
    public void setIcon(String input){
        this.icon = input;
    }
}
