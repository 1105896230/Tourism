package tourism.fmt.com.tourism.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import tourism.fmt.com.tourism.ApplicationConstant;
import tourism.fmt.com.tourism.R;
import tourism.fmt.com.tourism.activities.JindDianActivity;
import tourism.fmt.com.tourism.adapters.JindDianListAdapter;
import tourism.fmt.com.tourism.adapters.WeatherAdapter;
import tourism.fmt.com.tourism.eneity.Future;
import tourism.fmt.com.tourism.eneity.JingDiang;
import tourism.fmt.com.tourism.eneity.ToDay;
import tourism.fmt.com.tourism.net.HttpNet;
import tourism.fmt.com.tourism.net.HttpUrlConstant;
import tourism.fmt.com.tourism.utils.TourismLog;

/**
 * A simple {@link Fragment} subclass.
 */
public class TransLateFragmen extends Fragment {


    public TransLateFragmen() {
        // Required empty public constructor
    }

    ListView mListView;
    JindDianListAdapter madapetr;
    private int page=1;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_trans_late, container, false);
        mListView= (ListView) inflate.findViewById(R.id.mList);
        getDatas();
        mListView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                switch (scrollState) {
                    // 当不滚动时
                    case AbsListView.OnScrollListener.SCROLL_STATE_IDLE:
                        // 判断滚动到底部
                        if (view.getLastVisiblePosition() == (view.getCount() - 1)) {

                        }
                        break;
                }
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

            }
        });
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent= new Intent(getActivity(), JindDianActivity.class);
                JingDiang jingDiang = jingDiangs.get(position);
                intent.putExtra("sid",jingDiang.getSid());
                startActivity(intent);
            }
        });
        return inflate;
    }

    private Handler mHandler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            mListView.setAdapter(madapetr);
        }
    };
    private List<JingDiang> jingDiangs;
    private void getDatas(){
         if(ApplicationConstant.mCitys!=null){
            final String JINGDIANLIST = "http://apis.haoservice.com/lifeservice/travel/scenery?pid="+ApplicationConstant.mCitys.getProvinceId()+"&cid="+ApplicationConstant.mCitys.getCityId()+"&page="+page+"&key="+ApplicationConstant.APPKEY;
             HttpNet.HttpGet(JINGDIANLIST, new HttpNet.HttpNetInterface() {



                 @Override
                 public void onSuccess(String response) {
                     try {
                         JSONObject object=new JSONObject(response);
                         JSONArray result = object.getJSONArray("result");
                         jingDiangs = com.alibaba.fastjson.JSONArray.parseArray(result.toString(), JingDiang.class);
                         madapetr=new JindDianListAdapter(getActivity(), jingDiangs);
                         mHandler.sendEmptyMessage(200);
                     } catch (JSONException e) {
                         e.printStackTrace();
                     }
                 }
             });
         }
    }


}
