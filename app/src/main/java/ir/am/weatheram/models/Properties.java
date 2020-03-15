
package ir.am.weatheram.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Properties {

    @SerializedName("landmark")
    @Expose
    private Boolean landmark;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("category")
    @Expose
    private String category;
    @SerializedName("wikidata")
    @Expose
    private String wikidata;

    public Boolean getLandmark() {
        return landmark;
    }

    public void setLandmark(Boolean landmark) {
        this.landmark = landmark;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getWikidata() {
        return wikidata;
    }

    public void setWikidata(String wikidata) {
        this.wikidata = wikidata;
    }

}
