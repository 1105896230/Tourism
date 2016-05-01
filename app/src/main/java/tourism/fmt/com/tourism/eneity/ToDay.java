package tourism.fmt.com.tourism.eneity;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Created by Administrator on 2016/5/1.
 */
public class ToDay {
    @JSONField(name="city")
    private String city;
    @JSONField(name="date_y")
    private String date_y;
    @JSONField(name="week")
    private String week;
    @JSONField(name="temperature")
    private String temperature;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDate_y() {
        return date_y;
    }

    public void setDate_y(String date_y) {
        this.date_y = date_y;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getWind() {
        return wind;
    }

    public void setWind(String wind) {
        this.wind = wind;
    }

    public String getDressing_index() {
        return dressing_index;
    }

    public void setDressing_index(String dressing_index) {
        this.dressing_index = dressing_index;
    }

    public String getDressing_advice() {
        return dressing_advice;
    }

    public void setDressing_advice(String dressing_advice) {
        this.dressing_advice = dressing_advice;
    }

    @JSONField(name="weather")
    private String weather;
    @JSONField(name="wind")
    private String wind;
    @JSONField(name="dressing_index")
    private String dressing_index;
    @JSONField(name="dressing_advice")
    private String dressing_advice;

}
