package tourism.fmt.com.tourism.eneity;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Created by Administrator on 2016/5/1.
 */
public class JindDiangDetail {
    @JSONField(name="title")
    private String title;
    @JSONField(name="referral")
    private String referral;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReferral() {
        return referral;
    }

    public void setReferral(String referral) {
        this.referral = referral;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @JSONField(name="img")
    private String img;
}
