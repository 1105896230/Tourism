package tourism.fmt.com.tourism.net;/**
 * Created by hasee-pc on 2016/3/28.
 */

import tourism.fmt.com.tourism.ApplicationConstant;

/**
 * User:FMT
 * Email:1105896230@qq.com
 * DATA:2016/3/28
 * Time:21:57 
 *
 */
public class HttpUrlConstant {
    public static final String HttpUrl = "http://apis.haoservice.com/lifeservice/travel/cityList";

    public static final String HttpUrlGetCityList = HttpUrl + "?key=" + ApplicationConstant.APPKEY;

    public static final String WEATHER = "http://apis.haoservice.com/weather?cityname="+ApplicationConstant.mCity+"&key="+ApplicationConstant.WEATHER_KEY;

    private static final String TAT="HttpUrlConstant";
}
