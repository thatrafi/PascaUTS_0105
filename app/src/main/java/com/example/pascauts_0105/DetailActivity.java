package com.example.pascauts_0105;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.pascauts_0105.adapter.EntertainmentAdapter;
import com.example.pascauts_0105.entity.EntertainmentEntity;
import com.example.pascauts_0105.model.Entertainment;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {
    public final static String DETAIL_KEY = "detail";
    public final static String DETAIL_Lang = "lang";
    public final static String FLAG = "flag";
    public static final String EXTRA_STATE = "EXTRA_STATE";
    // view
    private TextView title,date,desc;
    private ImageView img;
    private RatingBar ratingBar;

    private Entertainment entertainment;
    private EntertainmentAdapter adapter;
    private ArrayList<EntertainmentEntity> ent,enttv,entmv;
    private boolean tag = false;
    private int iddelete;
    private int flag;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        title = findViewById(R.id.titledet);
        date = findViewById(R.id.date);
        desc = findViewById(R.id.descdet);
        img = findViewById(R.id.imageView2);
        ratingBar = findViewById(R.id.ratdet);
        entmv = new ArrayList<>();
        enttv = new ArrayList<>();
        // db
        /*helper = EntertainmentHelper.getInstance(getApplicationContext());
        helper.open();*/

        //------------
        adapter = new EntertainmentAdapter(this);
        //=--------------=//
        entertainment = getIntent().getParcelableExtra(DETAIL_KEY);
        flag = getIntent().getIntExtra(FLAG,0);
        if(flag == 0){
            title.setText(entertainment.getTitle_movie());
            date.setText(entertainment.getDate());
        }else if(flag ==1){
            title.setText(entertainment.getTitle_tv());
            date.setText(entertainment.getFirstair());
        }else{
            title.setText("-");
        }
        desc.setText(entertainment.getDesc());
        Glide.with(getApplicationContext()).load("https://image.tmdb.org/t/p/w500/"+entertainment.getImg()).into(img);
        ratingBar.setRating(entertainment.getRating());
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList(EXTRA_STATE,adapter.getEntitiy());
    }


}