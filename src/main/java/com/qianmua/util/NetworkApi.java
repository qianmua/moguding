package com.qianmua.util;

import okhttp3.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class NetworkApi {
    private static MediaType mediaType = MediaType.parse("application/json;charset=utf-8");
    private static OkHttpClient sHttpClient = new OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .build();
    public static void request(String  requestContent,String url,String token, final CallRequest callRequest) {

        final RequestBody requestBody = RequestBody.create(mediaType, requestContent);
        //要访问的地址
//"";
        //构建Request
        Request request = new Request.Builder()
                .url(url)
                //这是刚刚新鲜出炉的请求体
                .post(requestBody)
                .addHeader("Authorization", token)
                .build();


        sHttpClient.newCall(request).enqueue(new Callback() {
            public void onFailure(Call call, IOException e) {
                System.out.println(" 出错了 出错信息 ：" + e.getMessage());

            }

            public void onResponse(Call call, Response response) throws IOException {
                callRequest.success(response.body().string());
            }
        });
    }


}


