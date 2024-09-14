package vn.edu.usth.weather;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import vn.edu.usth.weather.WeatherAndForeCastFragment.WeatherAndForecastFragmentHanoi;
import vn.edu.usth.weather.WeatherAndForeCastFragment.WeatherAndForecastFragmentParis;
import vn.edu.usth.weather.WeatherAndForeCastFragment.WeatherAndForecastFragmentTokyo;

public class HomeFragmentPagerAdapter extends FragmentPagerAdapter {
    private final String[] titles = new String[]{"HÀ NỘI, VIỆT NAM","PARI, PHÁP","TOKYO, NHẬT BẢN"};
    public HomeFragmentPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0 : return new WeatherAndForecastFragmentHanoi();
            case 1 : return new WeatherAndForecastFragmentParis();
            case 2 : return new WeatherAndForecastFragmentTokyo();
        }
        return new Fragment();
    }

    @Override
    public int getCount() {
        return titles.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
