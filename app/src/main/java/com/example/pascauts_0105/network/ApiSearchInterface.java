package com.example.pascauts_0105.network;



import com.example.pascauts_0105.BuildConfig;
import com.example.pascauts_0105.model.EntertainmentItem;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiSearchInterface {
    @GET("/3/search/{tipe}?api_key="+ BuildConfig.TMDB_API_KEY+"&")
    Call<EntertainmentItem> getKeyword(@Path("tipe") String tipe, @Query("language") String lang, @Query("query") String key);
}
