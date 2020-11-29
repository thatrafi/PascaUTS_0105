package com.example.pascauts_0105.network;




import com.example.pascauts_0105.BuildConfig;
import com.example.pascauts_0105.model.EntertainmentItem;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;



public interface ApiInterface {
    @GET("/3/{tipe}/popular?api_key="+ BuildConfig.TMDB_API_KEY +"&")
    Call<EntertainmentItem> getEntertainment(@Path("tipe") String tipe, @Query("language") String lang);
}
