package com.example.pascauts_0105.ui.main;

import android.util.Log;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.example.pascauts_0105.model.Entertainment;
import com.example.pascauts_0105.model.EntertainmentItem;
import com.example.pascauts_0105.network.ApiInterface;
import com.example.pascauts_0105.network.ApiSearchInterface;
import com.example.pascauts_0105.network.RetrofitClientInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PageViewModel extends ViewModel {

    private String a;
    private MutableLiveData<Integer> mIndex = new MutableLiveData<>();
    private MutableLiveData<List<Entertainment>> listenterMovie = new MutableLiveData<>();
    private MutableLiveData<List<Entertainment>> listenterTv = new MutableLiveData<>();
    private LiveData<String> mText = Transformations.map(mIndex, new Function<Integer, String>() {
        @Override
        public String apply(Integer input) {
            if(input ==0){
                a = " Hello aa";
            }else if(input==1){
                a = " hello bb";
            }
            return a+input;


        }
    });

    public void setIndex(int index) {
        mIndex.setValue(index);
    }

    public LiveData<String> getText() {
        return mText;
    }

    void setTv(final String Lang,final String keyword){
        if(keyword!=""){
            ApiSearchInterface service = RetrofitClientInstance.getRetrofitInstance().create(ApiSearchInterface.class);
            Call<EntertainmentItem> call;
            call = service.getKeyword("tv",Lang,keyword);
            call.enqueue(new Callback<EntertainmentItem>() {
                @Override
                public void onResponse(Call<EntertainmentItem> call, Response<EntertainmentItem> response) {
                    List<Entertainment> data = response.body().getItems();
                    listenterTv.postValue(data);
                }
                @Override
                public void onFailure(Call<EntertainmentItem> call, Throwable t) {
                    Log.d("onFailure",t.getMessage());
                }
            });
        }else{
            ApiInterface service = RetrofitClientInstance.getRetrofitInstance().create(ApiInterface.class);
            Call<EntertainmentItem> call;
            call = service.getEntertainment("tv",Lang);
            call.enqueue(new Callback<EntertainmentItem>() {
                @Override
                public void onResponse(Call<EntertainmentItem> call, Response<EntertainmentItem> response) {
                    List<Entertainment> data = response.body().getItems();
                    listenterTv.postValue(data);
                }
                @Override
                public void onFailure(Call<EntertainmentItem> call, Throwable t) {
                    Log.d("onFailure",t.getMessage());
                }
            });
        }

    }
    LiveData<List<Entertainment>> getTv(){
        return listenterTv;
    }
    void setMovie(final String Lang,final String keyword){
        if(keyword!=""){
            ApiSearchInterface service = RetrofitClientInstance.getRetrofitInstance().create(ApiSearchInterface.class);
            Call<EntertainmentItem> call;
            call = service.getKeyword("movie",Lang,keyword);
            call.enqueue(new Callback<EntertainmentItem>() {
                @Override
                public void onResponse(Call<EntertainmentItem> call, Response<EntertainmentItem> response) {
                    List<Entertainment> data = response.body().getItems();
                    listenterMovie.postValue(data);
                }
                @Override
                public void onFailure(Call<EntertainmentItem> call, Throwable t) {
                    Log.d("onFailure",t.getMessage());
                }
            });
        }else{
            ApiInterface service = RetrofitClientInstance.getRetrofitInstance().create(ApiInterface.class);
            Call<EntertainmentItem> call;
            call = service.getEntertainment("movie",Lang);
            call.enqueue(new Callback<EntertainmentItem>() {
                @Override
                public void onResponse(Call<EntertainmentItem> call, Response<EntertainmentItem> response) {
                    List<Entertainment> data = response.body().getItems();
                    listenterMovie.postValue(data);
                }
                @Override
                public void onFailure(Call<EntertainmentItem> call, Throwable t) {
                    Log.d("onFailure",t.getMessage());
                }
            });
        }

    }
    LiveData<List<Entertainment>> getMovie(){
        return listenterMovie;
    }
}