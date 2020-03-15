package ir.am.weatheram;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.Observable;
import androidx.databinding.ObservableBoolean;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {
    private ObservableBoolean hasInternetAccess = new ObservableBoolean(false);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hasInternetAccess.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable sender, int propertyId) {
                if (hasInternetAccess.get()) {
                    setupSelectFragment();
                } else {
                    // TODO: 3/15/20 Now open the next page with saved data.
                }
            }
        });
        checkForConnection();
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
