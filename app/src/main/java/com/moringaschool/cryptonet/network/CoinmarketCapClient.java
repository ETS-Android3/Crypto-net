package com.moringaschool.cryptonet.network;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.moringaschool.cryptonet.Constant.BASE_URL;
import static com.moringaschool.cryptonet.Constant.CMC_PRO_API_KEY;

public class CoinmarketCapClient {
    private static Retrofit retrofit = null;
    public static CoinMarketCapApi getClient(){
        if (retrofit == null) {
            OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .addInterceptor(new Interceptor() {
                        @Override
                        public Response intercept(Chain chain) throws IOException {
                            Request newRequest = chain.request().newBuilder()
                            .addHeader("Authorization", CMC_PRO_API_KEY)
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

        return retrofit.create(CoinMarketCapApi.class);//making request start!
    }

}
