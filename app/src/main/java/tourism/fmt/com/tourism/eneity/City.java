package tourism.fmt.com.tourism.eneity;/**
 * Created by hasee-pc on 2016/3/28.
 */

import com.alibaba.fastjson.annotation.JSONField;

/**
 * User:FMT
 * Email:1105896230@qq.com
 * DATA:2016/3/28
 * Time:21:46 
 *
 */
public class City {
    @JSONField(name="cityId")
    private String cityId;
    @JSONField(name="cityName")
    private String cityName;

    public String getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    @JSONField(name="provinceId")
    private String provinceId;
}
