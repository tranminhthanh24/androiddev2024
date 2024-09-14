package vn.edu.usth.weather.WeatherFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import vn.edu.usth.weather.R;

public class WeatherFragmentParis extends Fragment {

    public WeatherFragmentParis() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_weather_paris, container, false);
    }
}