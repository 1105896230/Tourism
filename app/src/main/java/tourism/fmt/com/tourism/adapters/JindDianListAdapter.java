package tourism.fmt.com.tourism.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import tourism.fmt.com.tourism.R;
import tourism.fmt.com.tourism.eneity.JingDiang;

/**
 * Created by Administrator on 2016/5/1.
 */
public class JindDianListAdapter extends BaseAdapter {
    public JindDianListAdapter(Context mContext, List<JingDiang> mList) {
        this.mContext = mContext;
        this.mList = mList;
    }

    private Context mContext;
    private List<JingDiang> mList;
    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view=null;
        JingDiang jingDiang = mList.get(position);
        if (convertView!=null){
            view=convertView;
        }else {
            view= LayoutInflater.from(mContext).inflate(R.layout.jingdian_list_item,parent,false);
        }
        Holder tag = (Holder) view.getTag();
        if (tag==null){
            tag=new Holder();
            tag.tx= (TextView) view.findViewById(R.id.textView4);
            tag.tx2= (TextView) view.findViewById(R.id.textView5);
            tag.tx3= (TextView) view.findViewById(R.id.textView6);
            tag.tx4= (TextView) view.findViewById(R.id.textView7);
            tag.imageView= (ImageView) view.findViewById(R.id.imageView);
            view.setTag(tag);
        }
        tag.tx.setText(jingDiang.getTitle());
        tag.tx2.setText(jingDiang.getGrade());
        tag.tx3.setText("最低价格为"+jingDiang.getPrice_min());
        tag.tx4.setText(jingDiang.getAddress());
        Glide.with(mContext).load(jingDiang.getImgurl()).into(tag.imageView);

        return view;
    }

    class Holder{
        TextView tx;
        TextView tx2;
        TextView tx3;
        TextView tx4;
        ImageView imageView;
    }
}
