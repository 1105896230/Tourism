package tourism.fmt.com.tourism.eneity;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Created by Administrator on 2016/5/1.
 */
public class Future {
    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getWeahter() {
        return weahter;
    }

    public void setWeahter(String weahter) {
        this.weahter = weahter;
    }

    public String getFa() {
        return fa;
    }

    public void setFa(String fa) {
        this.fa = fa;
    }

    public String getFb() {
        return fb;
    }

    public void setFb(String fb) {
        this.fb = fb;
    }

    public String getWind() {
        return wind;
    }

    public void setWind(String wind) {
        this.wind = wind;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @JSONField(name="temperature")
    private String temperature;
    @JSONField(name="weather")
    private String weahter;
    @JSONField(name="fa")
    private String fa;
    @JSONField(name="fb")
    private String fb;
    @JSONField(name="wind")
    private String wind;
    @JSONField(name="week")
    private String week;
    @JSONField(name="data")
    private String data;
}
