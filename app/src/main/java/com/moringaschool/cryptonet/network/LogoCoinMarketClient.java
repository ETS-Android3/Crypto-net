package com.moringaschool.cryptonet.network;

import static com.moringaschool.cryptonet.Constant.BASE_URL;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LogoCoinMarketClient {
    private static Retrofit retrofit = null;

    public static InfoMarketCapApi getClient2() {
        if (retrofit == null) {
            OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .addInterceptor(new Interceptor() {
                        @Override
                        public Response intercept(Chain chain) throws IOException {
                            Request newRequest = chain.request().newBuilder()
                                    .addHeader("X-CMC_PRO_API_KEY","808fcef5-084a-4e05-80fb-e41ac516b10a")
                                    .build();
                            return chain.proceed(newRequest);
                        }
                    })
                    .build();

            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create()) // json - Pojo
                    .build();
        }
        return retrofit.create(InfoMarketCapApi.class);//making request start!
    }


}
