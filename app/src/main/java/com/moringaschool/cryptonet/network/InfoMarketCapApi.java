package com.moringaschool.cryptonet.network;

import com.moringaschool.cryptonet.model2.SearchResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface InfoMarketCapApi {
    @GET("cryptocurrency/info")
    Call <SearchResponse> getInfoData(
            @Query("slug") String slug
    );

}
