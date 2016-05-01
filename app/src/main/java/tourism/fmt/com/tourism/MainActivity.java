package tourism.fmt.com.tourism;

import android.app.Application;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.alibaba.fastjson.JSONArray;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.internal.Platform;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import tourism.fmt.com.tourism.adapters.CommonPagerAdapter;
import tourism.fmt.com.tourism.eneity.City;
import tourism.fmt.com.tourism.fragments.TransLateFragmen;
import tourism.fmt.com.tourism.fragments.WeatherFragment;
import tourism.fmt.com.tourism.net.HttpNet;
import tourism.fmt.com.tourism.net.HttpUrlConstant;
import tourism.fmt.com.tourism.utils.TourismLog;

public class MainActivity extends AppCompatActivity {

    private ViewPager mVp;
    private List<Fragment> fragmentList;

    private List<City> mlist;
    CommonPagerAdapter adapter =
            new CommonPagerAdapter(getSupportFragmentManager(), fragmentList);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getDatas();

    }

    private void  init(){
        mVp= (ViewPager) findViewById(R.id.vp_FindFragment_pager);

        fragmentList=   new LinkedList<Fragment>();

        initFragments();
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
            public void onSuccess(String response) throws JSONException {
                JSONObject jsonObject=new JSONObject(response);
                org.json.JSONArray result = jsonObject.getJSONArray("result");
                mlist=JSONArray.parseArray(result.toString(),City.class);
                //选择宁波
                checkCity();
            }
        });
    }

    private Handler mHandler =new Handler(){
        @Override
        public void handleMessage(Message msg) {
            init();
        }
    };

    private void checkCity(){
       for (City city:mlist){
           if (city.getCityName().equals("宁波")){
               ApplicationConstant.mCitys=city;
           }
       }
        mHandler.sendEmptyMessage(20);
    }



}
