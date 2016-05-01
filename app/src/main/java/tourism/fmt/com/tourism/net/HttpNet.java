package tourism.fmt.com.tourism.net;/**
 * Created by hasee-pc on 2016/3/28.
 */

import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.json.JSONException;

import java.io.IOException;

/**
 * User:FMT
 * Email:1105896230@qq.com
 * DATA:2016/3/28
 * Time:21:55 
 *
 */
public class HttpNet {
    public static void HttpGet(String url, final HttpNetInterface netInterface) {
        OkHttpClient mOkHttpClient = new OkHttpClient();
//创建一个Request
        final Request request = new Request.Builder().url(url).build();
//new call
        Call call = mOkHttpClient.newCall(request);
//请求加入调度
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
            }

            @Override
            public void onResponse(final Response response) {
                try {
                    netInterface.onSuccess(response.body().string());
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public interface HttpNetInterface {
        void onSuccess(String response) throws JSONException;
    }
}
