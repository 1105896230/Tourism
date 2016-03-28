package tourism.fmt.com.tourism.utils;/**
 * Created by hasee-pc on 2016/3/28.
 */

import android.util.Log;

/**
 * User:FMT
 * Email:1105896230@qq.com
 * DATA:2016/3/28
 * Time:22:10 
 *
 */
public class TourismLog {
    private static final boolean isLog = true;

    private TourismLog() {

    }

    public static void e(String tag, String str) {
        if (isLog) {
            Log.e(tag, str);
        }
    }
}
