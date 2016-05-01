package tourism.fmt.com.tourism.eneity;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Created by Administrator on 2016/5/1.
 */
public class JingDiang {
    @JSONField(name="title")
    private String title;
    @JSONField(name="grade")
    private String grade;
    @JSONField(name="price_min")
    private String price_min;
    @JSONField(name="comm_cnt")
    private String comm_cnt;
    @JSONField(name="cityId")
    private String cityId;
    @JSONField(name="address")
    private String address;

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getPrice_min() {
        return price_min;
    }

    public void setPrice_min(String price_min) {
        this.price_min = price_min;
    }

    public String getComm_cnt() {
        return comm_cnt;
    }

    public void setComm_cnt(String comm_cnt) {
        this.comm_cnt = comm_cnt;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    @JSONField(name="sid")

    private String sid;
    @JSONField(name="imgurl")
    private String imgurl;
}
