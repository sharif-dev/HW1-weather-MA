package ir.am.weatheram;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import ir.am.weatheram.models.Feature;
import ir.am.weatheram.models.MapboxResult;
import ir.am.weatheram.models.WeatherResult;
import ir.am.weatheram.utils.NetUtils;


public class SelectFragment extends Fragment {
    private List<Feature> currentSearchMatchFeatures;
    private String searchQuery;
    private CountDownTimer searchCountDown = new CountDownTimer(500, 500) {
        @Override
        public void onTick(long millisUntilFinished) {
        }

        @Override
        public void onFinish() {
            if (searchQuery != null && !searchQuery.equals("")) {
                new Handler().post(new Runnable() {
                    @Override
                    public void run() {
                        sendSearchRequest(searchQuery);
                        Objects.requireNonNull(getView()).findViewById(R.id.progress_bar).setVisibility(View.VISIBLE);
                    }
                });
            }
        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_select, container, false);
        setSearchTextHandlers(view);
        return view;
    }

    private void setSearchTextHandlers(View view) {
        final AutoCompleteTextView searchText = view.findViewById(R.id.search_text);
        searchText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                searchCountDown.cancel();
                if (s != null && !s.toString().equals("")) {
                    searchQuery = s.toString();
                    searchCountDown.start();
                } else {
                    currentSearchMatchFeatures = new ArrayList<>();
                }
            }
        });
    }

    private void sendSearchRequest(String s) {
        final RequestQueue requestQueue = Volley.newRequestQueue(Objects.requireNonNull(getContext()));
        StringRequest stringRequest = new StringRequest(
                Request.Method.GET,
                NetUtils.getMapBoxReverseUrl(s),
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        MapboxResult result = new Gson().fromJson(response, MapboxResult.class);
                        List<Feature> searchMatchFeatures = result.getFeatures();
                        setupSuggestionsAdapter(searchMatchFeatures);
                        currentSearchMatchFeatures = searchMatchFeatures;
                        Objects.requireNonNull(getView()).findViewById(R.id.progress_bar).setVisibility(View.GONE);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                        Objects.requireNonNull(getView()).findViewById(R.id.progress_bar).setVisibility(View.GONE);
                    }
                });
        requestQueue.add(stringRequest);
    }

    private void setupSuggestionsAdapter(List<Feature> searchMatchFeatures) {
        AutoCompleteTextView searchTextView = Objects.requireNonNull(getView()).findViewById(R.id.search_text);
        List<String> searchResultPlaces = new ArrayList<>();
        for (Feature feature : searchMatchFeatures) {
            searchResultPlaces.add(feature.getPlaceName());
        }
        ArrayAdapter<String> searchResultsAdapter = new ArrayAdapter<>(
                Objects.requireNonNull(getContext()),
                android.R.layout.simple_list_item_1,
                searchResultPlaces);
        searchTextView.setAdapter(searchResultsAdapter);
        searchTextView.showDropDown();
        searchTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                List<Double> cityLatLong = currentSearchMatchFeatures.get((int) id).getGeometry().getCoordinates();
                final RequestQueue requestQueue = Volley.newRequestQueue(Objects.requireNonNull(getContext()));
                StringRequest stringRequest = new StringRequest(
                        Request.Method.GET,
                        NetUtils.getWeatherReverseUrl(cityLatLong.get(1), cityLatLong.get(0)),
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                WeatherResult result = new Gson().fromJson(response, WeatherResult.class);
                                Objects.requireNonNull(getView()).findViewById(R.id.progress_bar).setVisibility(View.GONE);
                                setupDetailFragment(result);
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                                Objects.requireNonNull(getView()).findViewById(R.id.progress_bar).setVisibility(View.GONE);
                            }
                        });
                requestQueue.add(stringRequest);
            }
        });
    }

    private void setupDetailFragment(WeatherResult result) {
        final FragmentTransaction fragmentTransaction = Objects.requireNonNull(getFragmentManager()).beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, new DetailFragment(result));
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

}
