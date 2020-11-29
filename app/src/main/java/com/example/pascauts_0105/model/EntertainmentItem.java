package com.example.pascauts_0105.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class EntertainmentItem {
    @SerializedName("results")
    public List<Entertainment> items;

    public EntertainmentItem(List<Entertainment> items) {
        this.items = items;
    }

    public List<Entertainment> getItems() {
        return items;
    }

}
