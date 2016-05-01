package tourism.fmt.com.tourism.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * Created by Administrator on 2016/4/30.
 */
public class  CommonPagerAdapter extends FragmentStatePagerAdapter {

    /**
     * 利用List结合存储需要显示的Fragment，
     */
    private List<Fragment> fragments;

    private String[] titles = {"天气"};

    /**
     * @param fm FragmentManager，代表 Fragment 创建之后存储在哪里，由谁管理
     */
    public CommonPagerAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);

        this.fragments = fragments;

    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }

    @Override
    public int getCount() {
        int ret = 0;
        if (fragments != null) {
            ret = fragments.size();
        }
        return ret;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }
}
