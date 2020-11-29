package com.example.pascauts_0105.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.pascauts_0105.R;
import com.example.pascauts_0105.entity.EntertainmentEntity;
import com.example.pascauts_0105.model.Entertainment;

import java.util.ArrayList;
import java.util.List;

public class EntertainmentAdapter extends RecyclerView.Adapter<EntertainmentAdapter.ListViewHolder> {
    private final Context context;
    private List<Entertainment> entertainmentList;
    private ArrayList<EntertainmentEntity> entitiy;
    private boolean flag;


    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public void setEntertainmentList(List<Entertainment> entertainmentList) {
        this.entertainmentList = entertainmentList;
        notifyDataSetChanged();
    }



    public ArrayList<EntertainmentEntity> getEntitiy() {
        return entitiy;
    }

    public void setEntitiy(ArrayList<EntertainmentEntity> entitiy) {
        this.entitiy = entitiy;
        notifyDataSetChanged();
    }

    public EntertainmentAdapter(Context context) {
        this.context = context;
    }



    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_entertainment,parent,false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        if(flag){
            holder.title.setText(entertainmentList.get(position).getTitle_movie());
            holder.date.setText(entertainmentList.get(position).getDate());
        }else{
            holder.title.setText(entertainmentList.get(position).getTitle_tv());
            holder.date.setText(entertainmentList.get(position).getFirstair());
        }
        holder.desc.setText(entertainmentList.get(position).getDesc());
        Glide.with(context).load("https://image.tmdb.org/t/p/w500/"+entertainmentList.get(position).getImg()).into(holder.img);
        holder.ratbar.setRating(entertainmentList.get(position).getRating());


    }

    @Override
    public int getItemCount() {
        return entertainmentList.size();
    }

     class ListViewHolder extends RecyclerView.ViewHolder {
        TextView title,desc,date;
        ImageView img;
        RatingBar ratbar;
        ListViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            desc = itemView.findViewById(R.id.descdet);
            date = itemView.findViewById(R.id.date);
            img = itemView.findViewById(R.id.imageView);
            ratbar = itemView.findViewById(R.id.ratingBar);
        }
    }


}
