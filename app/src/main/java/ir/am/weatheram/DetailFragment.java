package ir.am.weatheram;

import android.graphics.drawable.Icon;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import ir.am.weatheram.models.WeatherResult;



public class DetailFragment extends Fragment implements View.OnClickListener{

    public WeatherResult result;
    private TextView date;
    private TextView sunrise;
    private TextView sunset;
    private TextView condition;
    private TextView minTemp;
    private TextView maxTemp;
    private TextView avgTemp;
    private TextView wind;
    private ImageView icon;
    private ArrayList<ToggleButton> buttons = new ArrayList<>();

    DetailFragment(WeatherResult result) {
        this.result = result;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        final TextView city_name = view.findViewById(R.id.loc_name);
        city_name.setText(result.getLocation().getName());
        setupLayout(view);
        buttons.get(0).setChecked(true);
        updateWeather(0, view);
        return view;
    }

    private void setupLayout(View view) {
        date = view.findViewById(R.id.day_date);
        sunrise = view.findViewById(R.id.day_sunrise);
        sunset = view.findViewById(R.id.day_sunset);
        condition = view.findViewById(R.id.condition);
        icon = view.findViewById(R.id.icon);
        avgTemp = view.findViewById(R.id.avg);
        minTemp = view.findViewById(R.id.min);
        maxTemp = view.findViewById(R.id.max);
        wind = view.findViewById(R.id.wind);
        buttons.add((ToggleButton) view.findViewById(R.id.tog0));
        buttons.add((ToggleButton) view.findViewById(R.id.tog1));
        buttons.add((ToggleButton) view.findViewById(R.id.tog2));
        buttons.add((ToggleButton) view.findViewById(R.id.tog3));
        buttons.add((ToggleButton) view.findViewById(R.id.tog4));
        buttons.add((ToggleButton) view.findViewById(R.id.tog5));
        buttons.add((ToggleButton) view.findViewById(R.id.tog6));
        for (ToggleButton button:buttons
             ) {
            button.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.tog0:
                if (!buttons.get(0).isChecked()){
                    updateWeather(0, v);
                }
                break;

            case R.id.tog1:
                if (!buttons.get(1).isChecked()){
                    updateWeather(1, v);
                }
                break;

            case R.id.tog2:
                if (!buttons.get(2).isChecked()){
                    updateWeather(2, v);
                }
                break;

            case R.id.tog3:
                if (!buttons.get(3).isChecked()){
                    updateWeather(3, v);
                }
                break;

            case R.id.tog4:
                if (!buttons.get(4).isChecked()){
                    updateWeather(4, v);
                }
                break;

            case R.id.tog5:
                if (!buttons.get(5).isChecked()){
                    updateWeather(5, v);
                }
                break;


            case R.id.tog6:
                if (!buttons.get(6).isChecked()){
                    updateWeather(6, v);
                }
                break;

            default:
                break;
        }
    }

    private void updateWeather(int dayNumber, View view) {
        for (ToggleButton button :
                buttons) {
            if (button.isChecked())
                button.setChecked(false);
        }
        buttons.get(dayNumber).setChecked(true);
        date.setText(result.getForecast().getForecastday().get(dayNumber).getDate());
        sunrise.setText(result.getForecast().getForecastday().get(dayNumber).getAstro().getSunrise());
        sunset.setText(result.getForecast().getForecastday().get(dayNumber).getAstro().getSunset());
        condition.setText(result.getForecast().getForecastday().get(dayNumber).getDay().getCondition().getText());
        //Picasso.with(icon.getContext()).load(R.string.url + result.getForecast().getForecastday().get(dayNumber).getDay().getCondition().getIcon()).into(icon);
        Glide.with(icon.getContext()).load(R.string.url + result.getForecast().getForecastday().get(dayNumber).getDay().getCondition().getIcon()).error(R.drawable.ic_launcher_foreground).centerCrop().into(icon);
        //minTemp.setText(result.getForecast().getForecastday().get(dayNumber).getDay().getMintempC() + R.string.celsius + result.getForecast().getForecastday().get(dayNumber).getDay().getMintempF() + R.string.fahrenheit);
        //maxTemp.setText(result.getForecast().getForecastday().get(dayNumber).getDay().getMaxtempC() + R.string.celsius + result.getForecast().getForecastday().get(dayNumber).getDay().getMaxtempF() + R.string.fahrenheit);
        //wind.setText(result.getForecast().getForecastday().get(dayNumber).getDay().getMaxwindKph() + R.string.windSpeed);
        //avgTemp.setText(result.getForecast().getForecastday().get(dayNumber).getDay().getAvgtempC() + R.string.celsius + result.getForecast().getForecastday().get(dayNumber).getDay().getAvgtempF() + R.string.fahrenheit);
    }

}
