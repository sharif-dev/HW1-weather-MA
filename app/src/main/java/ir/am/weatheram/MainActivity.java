package ir.am.weatheram;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.Observable;
import androidx.databinding.ObservableBoolean;
import androidx.fragment.app.FragmentTransaction;

import com.google.gson.Gson;

import java.util.Map;
import java.util.Objects;
import java.util.Set;

import ir.am.weatheram.models.WeatherResult;

public class MainActivity extends AppCompatActivity {
    private ObservableBoolean hasInternetAccess = new ObservableBoolean(false);
    SharedPreferences mPrefs;

    public void setResult(WeatherResult res){
//        SharedPreferences.Editor prefsEditor = mPrefs.edit();
//        Gson gson = new Gson();
//        String json = gson.toJson(res);
//        prefsEditor.putString("Result", json);
//        prefsEditor.apply();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mPrefs = PreferenceManager.getDefaultSharedPreferences(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hasInternetAccess.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable sender, int propertyId) {
                if (hasInternetAccess.get()) {
                    setupSelectFragment();
                } else {
//                    Gson gson = new Gson();
//                    String json = mPrefs.getString("Result", "");
//                    WeatherResult result = gson.fromJson(json, WeatherResult.class);
//                    setupDetailFragment(result);
                }
            }
        });
        checkForConnection();
    }

    private void setupDetailFragment(WeatherResult result) {
        final FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, new DetailFragment(result));
        fragmentTransaction.commit();
    }

    private void setupSelectFragment() {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, new SelectFragment());
        fragmentTransaction.commit();
    }


    private void checkForConnection() {
        new InternetCheck(new InternetCheck.Consumer() {
            @Override
            public void accept(Boolean hasInternet) {
                if (!hasInternet) {
                    Toast.makeText(getApplicationContext(),
                            "No internet access :(",
                            Toast.LENGTH_SHORT).show();
                    hasInternetAccess.set(false);
                } else {
                    hasInternetAccess.set(true);
                }
            }
        });
    }
}
