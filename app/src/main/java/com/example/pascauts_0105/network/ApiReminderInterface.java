package com.example.pascauts_0105.network;


import com.example.pascauts_0105.BuildConfig;
import com.example.pascauts_0105.model.EntertainmentItem;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiReminderInterface {
    @GET("/3/discover/{tipe}?api_key="+ BuildConfig.TMDB_API_KEY+"&")
    Call<EntertainmentItem> getReminder(@Path("tipe") String tipe, @Query("primary_release_date.gte") String tgl, @Query("primary_release_date.lte") String tgl2);
}
