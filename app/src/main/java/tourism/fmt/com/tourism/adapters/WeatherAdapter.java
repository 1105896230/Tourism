package tourism.fmt.com.tourism.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import tourism.fmt.com.tourism.R;
import tourism.fmt.com.tourism.eneity.Future;

/**
 * Created by Administrator on 2016/5/1.
 */
public class WeatherAdapter extends BaseAdapter {
    private Context mContext;
    private List<Future> futures;

    public WeatherAdapter(Context mContext, List<Future> futures) {
        this.mContext = mContext;
        this.futures = futures;
    }

    @Override
    public int getCount() {
        return futures.size();
    }

    @Override
    public Object getItem(int position) {
        return futures.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Future future = futures.get(position);
        View inflate;
        if (convertView!=null){
            inflate=convertView;
        }else {
            inflate = LayoutInflater.from(mContext).inflate(R.layout.item_weather, parent, false);
        }
        Holder tag = (Holder) inflate.getTag();
        if (tag==null){
            tag=new Holder();
            tag.tx= (TextView) inflate.findViewById(R.id.textView);
            tag.tx2= (TextView) inflate.findViewById(R.id.textView2);
            tag.tx3= (TextView) inflate.findViewById(R.id.textView3);
            inflate.setTag(tag);
        }
        tag.tx.setText(future.getTemperature());
        tag.tx2.setText(future.getWeahter());
        tag.tx3.setText(future.getWeek());
        return inflate;
    }

    class Holder{
        TextView tx;
        TextView tx2;
        TextView tx3;
    }
}
