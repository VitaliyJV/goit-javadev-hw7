package HTTP;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Request.Builder;
import com.squareup.okhttp.Response;

import java.io.IOException;

public class UtilClass {

public static int getRequestStatus(String url) {

    OkHttpClient client = new OkHttpClient();
    Builder builder = new Builder();
    builder.url(url);
    Request request = builder
            .build();
    Response response = null;
    try {
        response = client.newCall(request).execute();
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
    return response.code();

    }

}
