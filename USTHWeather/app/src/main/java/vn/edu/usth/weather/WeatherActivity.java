package vn.edu.usth.weather;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;
import android.graphics.Color;
import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class WeatherActivity extends AppCompatActivity {
    public static final String TAG = "Weathering";
    public static final String NETWORK_RESPONSE_KEY = "NETWORK_RESPONSE_KEY";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_weather);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Log.i(TAG, "onCreate");
        ViewPager pager = findViewById(R.id.pager);
        HomeFragmentPagerAdapter adapter = new HomeFragmentPagerAdapter(getSupportFragmentManager());
        pager.setAdapter(adapter);
        TabLayout tablayout = findViewById(R.id.tab_layout);
        tablayout.setupWithViewPager(pager);
        MediaPlayer mediaPlayer = MediaPlayer.create(this,R.raw.musicfile);
        mediaPlayer.start();
        initToolBar();
        requestNetwork();
    }

    private void requestNetwork() {
        final Handler handler = new Handler(Looper.getMainLooper()) {
            @Override

            public void handleMessage(@NonNull Message msg) {
                String content = msg.getData().getString(NETWORK_RESPONSE_KEY);
                Toast.makeText(getApplicationContext(), content, Toast.LENGTH_SHORT).show();
            }
        };

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Bundle mBundle = new Bundle();
                mBundle.putString(NETWORK_RESPONSE_KEY, "Request Network....");
                Message msg = new Message();
                msg.setData(mBundle);
                handler.sendMessage(msg);
            }
        });
        thread.start();
    }

    private void initToolBar() {
        Toolbar toolbar = findViewById(R.id.weather_toolbar);
        toolbar.inflateMenu(R.menu.weather_menu);
        toolbar.setTitle(R.string.app_name);
        toolbar.setTitleTextColor(Color.WHITE);
        toolbar.setOnMenuItemClickListener(item -> {
            int itemMenuId = item.getItemId();
            if (itemMenuId == R.id.ic_refresh) {
                Toast.makeText(this, "Refreshing process...", Toast.LENGTH_SHORT).show();
                return true;
            } else if (itemMenuId == R.id.ic_menu) {
                Intent intent = new Intent(this, PrefActivity.class);
                startActivity(intent);
                return true;
            } else {
                Toast.makeText(this, "Not found menu item", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }

    @Override
    protected void onStart()    {
        super.onStart();
        Log.i(TAG, "onStart");
    }

    @Override
    protected void onResume()    {
        super.onResume();
        Log.i(TAG, "onResume");
    }

    @Override
    protected void onPause()    {
        super.onPause();
        Log.i(TAG, "onPause");
    }

    @Override
    protected void onStop()    {
        super.onStop();
        Log.i(TAG, "onStop");
    }

    @Override
    protected void onDestroy()    {
        super.onDestroy();
        Log.i(TAG, "onDestroy");
    }
}

