package tourism.fmt.com.tourism.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;

import com.amap.api.maps.AMap;
import com.amap.api.maps.MapView;
import com.amap.api.maps.model.MyTrafficStyle;

import tourism.fmt.com.tourism.R;
import tourism.fmt.com.tourism.activities.PoiKeywordSearchActivity;


public class DaoHangFragment extends Fragment implements View.OnClickListener, AdapterView.OnItemSelectedListener
{

    private AMap aMap;
    private MapView mapView;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_dao_hang, container, false);

        mapView = (MapView)inflate. findViewById(R.id.map);
        mapView.onCreate(savedInstanceState);// 此方法必须重写

        Button btn= (Button) inflate.findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), PoiKeywordSearchActivity.class);
                startActivity(intent);
            }
        });
        init(inflate);
        return inflate;
    }

    /**
     * 初始化AMap对象
     */
    private void init(View view) {
        if (aMap == null) {
            aMap = mapView.getMap();
        }
        CheckBox traffic = (CheckBox)view.findViewById(R.id.traffic);
        traffic.setOnClickListener(this);

        CheckBox buildings = (CheckBox)view. findViewById(R.id.building);
        buildings.setOnClickListener(this);

        CheckBox maptext = (CheckBox) view.findViewById(R.id.maptext);
        maptext.setOnClickListener(this);

        Spinner spinner = (Spinner) view.findViewById(R.id.layers_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                getActivity(), R.array.layers_array,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        MyTrafficStyle myTrafficStyle = new MyTrafficStyle();
        myTrafficStyle.setSeriousCongestedColor(0xff92000a);
        myTrafficStyle.setCongestedColor(0xffea0312);
        myTrafficStyle.setSlowColor(0xffff7508);
        myTrafficStyle.setSmoothColor(0xff00a209);
        aMap.setMyTrafficStyle(myTrafficStyle);
    }

    /**
     * 方法必须重写
     */
    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();

    }

    /**
     * 方法必须重写
     */
    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    /**
     * 方法必须重写
     */
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }

    /**
     * 方法必须重写
     */
    public void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    public void onItemSelected(AdapterView<?> parent, View view, int position,
                               long id) {
        if (aMap != null) {
            setLayer((String) parent.getItemAtPosition(position));
        }
    }

    /**
     * 选择矢量地图/卫星地图/夜景地图事件的响应
     */
    private void setLayer(String layerName) {
        if (layerName.equals(getString(R.string.normal))) {
            aMap.setMapType(AMap.MAP_TYPE_NORMAL);// 矢量地图模式
        } else if (layerName.equals(getString(R.string.satellite))) {
            aMap.setMapType(AMap.MAP_TYPE_SATELLITE);// 卫星地图模式
        }
        else if(layerName.equals(getString(R.string.night_mode))){
            aMap.setMapType(AMap.MAP_TYPE_NIGHT);//夜景地图模式
        } else if(layerName.equals(getString(R.string.navi_mode))){
            aMap.setMapType(AMap.MAP_TYPE_NAVI);//导航模式
        }
    }

    public void onNothingSelected(AdapterView<?> parent) {
    }

    /**
     * 对选择是否显示交通状况事件的响应
     */
    public void onClick(View v) {
        if (v.getId() == R.id.traffic) {
            aMap.setTrafficEnabled(((CheckBox) v).isChecked());// 显示实时交通状况
        } else if (v.getId() == R.id.building) {
            aMap.showBuildings(((CheckBox) v).isChecked());// 显示3D 楼块
        } else if (v.getId() == R.id.maptext) {
            aMap.showMapText(((CheckBox) v).isChecked());// 显示底图文字
        }
    }
}
