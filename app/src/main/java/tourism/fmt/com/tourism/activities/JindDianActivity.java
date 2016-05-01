package tourism.fmt.com.tourism.activities;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import tourism.fmt.com.tourism.ApplicationConstant;
import tourism.fmt.com.tourism.R;
import tourism.fmt.com.tourism.adapters.WeatherAdapter;
import tourism.fmt.com.tourism.eneity.Future;
import tourism.fmt.com.tourism.eneity.JindDiangDetail;
import tourism.fmt.com.tourism.eneity.JingDiang;
import tourism.fmt.com.tourism.eneity.ToDay;
import tourism.fmt.com.tourism.net.HttpNet;
import tourism.fmt.com.tourism.net.HttpUrlConstant;

public class JindDianActivity extends AppCompatActivity {

    TextView tv;
    TextView tv2;
    ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jind_dian);
        Intent intent = getIntent();
        String sid = intent.getStringExtra("sid");
        tv= (TextView) findViewById(R.id.textView8);
        tv2= (TextView) findViewById(R.id.textView9);
        iv= (ImageView) findViewById(R.id.imageView2);
        getDatas(sid);
    }
    private JindDiangDetail jingDiang;
    private void getDatas(String sid){

        String s="http://apis.haoservice.com/lifeservice/travel/GetScenery?sid="+sid+"&key="+ ApplicationConstant.APPKEY;
        HttpNet.HttpGet(s, new HttpNet.HttpNetInterface() {
            @Override
            public void onSuccess(String response) {
                try {
                    JSONObject object=new JSONObject(response);
                    JSONArray future = object.getJSONArray("result");
                    List<JindDiangDetail> futures = com.alibaba.fastjson.JSONArray.parseArray(future.toString(), JindDiangDetail.class);
                    if (future!=null){
                        jingDiang=futures.get(0);
                        mHandler.sendEmptyMessage(200);
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }
    Handler mHandler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            Glide.with(JindDianActivity.this).load(jingDiang.getImg()).into(iv);
            tv2.setText(jingDiang.getTitle());
            tv.setText(jingDiang.getReferral());
        }
    };
}
