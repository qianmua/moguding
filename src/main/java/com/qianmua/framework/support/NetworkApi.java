package com.qianmua.framework.support;

import com.qianmua.util.LogUtils;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;

import java.io.IOException;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Slf4j
public final class NetworkApi {

    private NetworkApi() { }

    private static final MediaType mediaType = MediaType.parse("application/json;charset=utf-8");

    /**
     * http client
     */
    private static final OkHttpClient sHttpClient = new OkHttpClient.Builder()
                                                            .connectTimeout(30, TimeUnit.SECONDS)
                                                            .readTimeout(30, TimeUnit.SECONDS)
                                                            .writeTimeout(30, TimeUnit.SECONDS)
                                                            .build();

    public static void request(
            String requestContent,
            String url,
            String token,
            final CallRequestBack callRequestBack) {

        final RequestBody requestBody = RequestBody.create(mediaType, requestContent);

        Request request = new Request.Builder()
                .url(url)
                //这是刚刚新鲜出炉的请求体
                .post(requestBody)
                .addHeader("Authorization", token)
                .build();

        Callback callback = new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                LogUtils.logEvent(log , "call back" , e.getMessage());
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                ResponseBody body = Optional.ofNullable(response.body()).orElse(null);
                callRequestBack.success(body == null ? null : body.string());
            }
        };
        sHttpClient.newCall(request).enqueue(callback);
    }


}


