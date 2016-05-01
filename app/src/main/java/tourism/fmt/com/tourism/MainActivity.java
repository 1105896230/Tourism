package tourism.fmt.com.tourism;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.squareup.okhttp.Response;
import com.squareup.okhttp.internal.Platform;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import tourism.fmt.com.tourism.adapters.CommonPagerAdapter;
import tourism.fmt.com.tourism.fragments.TransLateFragmen;
import tourism.fmt.com.tourism.fragments.WeatherFragment;
import tourism.fmt.com.tourism.net.HttpNet;
import tourism.fmt.com.tourism.net.HttpUrlConstant;
import tourism.fmt.com.tourism.utils.TourismLog;

public class MainActivity extends AppCompatActivity {

    private ViewPager mVp;
    private List<Fragment> fragmentList;

    CommonPagerAdapter adapter =
            new CommonPagerAdapter(getSupportFragmentManager(), fragmentList);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mVp= (ViewPager) findViewById(R.id.vp_FindFragment_pager);

        fragmentList=   new LinkedList<Fragment>();

        initFragments();

        getDatas();
    }

    private void initFragments() {
        WeatherFragment weatherFragment=new WeatherFragment();
        TransLateFragmen fragmen=new TransLateFragmen();
        fragmentList.add(weatherFragment);
        fragmentList.add(fragmen);
        CommonPagerAdapter adapter =
                new CommonPagerAdapter(getSupportFragmentManager(), fragmentList);
        mVp.setAdapter(adapter);

    }

    private void  getDatas(){
        HttpNet.HttpGet(HttpUrlConstant.HttpUrlGetCityList, new HttpNet.HttpNetInterface() {
            @Override
            public void onSuccess(String response) {

            }
        });
    }



}
