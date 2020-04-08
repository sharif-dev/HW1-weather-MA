package ir.am.weatheram.utils;

public class NetUtils {
    private static String getMapBoxToken() {
        return "pk.eyJ1IjoidGhlcmVhbGFrMTIiLCJhIjoiY2s3c3lwNHo1MGt0MTNmc2ZzZWkwZWp6OSJ9.uzk7rvCfGQsFxPWeRu8p2w";
    }

    public static String getMapBoxReverseUrl(String query) {
        return "https://api.mapbox.com/geocoding/v5/mapbox.places/" + query + ".json?access_token=" + getMapBoxToken();
    }

    private static String getWeatherKey() {
        return "b739463956254791965141917200604";
    }

    public static String getWeatherReverseUrl(Double latitude, Double longitude) {
        return "http://api.weatherapi.com/v1/forecast.json?key=" + getWeatherKey() + "&q=" + latitude + "," + longitude + "&days=7";
    }
}
