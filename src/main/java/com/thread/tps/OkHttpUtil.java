package com.thread.tps;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class OkHttpUtil {

    private static OkHttpClient okHttpclient = null;

    static {
        okHttpclient = new OkHttpClient();
        okHttpclient.setConnectTimeout(3, TimeUnit.SECONDS);
    }

    public static String run(String url) throws Exception {
        Request request = new Request.Builder().url(url).build();
        Response response = okHttpclient.newCall(request).execute();
        if (!response.isSuccessful()) {
            throw new IOException("Unexpected code " + response);
        }
        return response.body().string();

    }
}
