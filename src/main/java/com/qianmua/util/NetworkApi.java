package com.qianmua.util;

import okhttp3.*;

import java.io.IOException;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

public class NetworkApi {

    private static final MediaType mediaType = MediaType.parse("application/json;charset=utf-8");

    private static final OkHttpClient sHttpClient = new OkHttpClient.Builder()
                                                            .connectTimeout(30, TimeUnit.SECONDS)
                                                            .readTimeout(30, TimeUnit.SECONDS)
                                                            .writeTimeout(30, TimeUnit.SECONDS)
                                                            .build();


    public static void request(
            String requestContent,
            String url,
            String token,
            final CallRequest callRequest) {


        final RequestBody requestBody = RequestBody.create(mediaType, requestContent);

        Request request = new Request.Builder()
                .url(url)
                //这是刚刚新鲜出炉的请求体
                .post(requestBody)
                .addHeader("Authorization", token)
                .build();

        sHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                System.out.println(" callback err : " + e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
//                Objects.requireNonNull(response.body());
                ResponseBody body = Optional.ofNullable(response.body()).orElse(null);
                callRequest.success(body == null ? null : body.string() );
            }
        });
    }


}


