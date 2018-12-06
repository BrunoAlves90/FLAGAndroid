package com.example.developer.projectoandroidlivros.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Books extends VolumeInfo {

    @SerializedName("items")
    @Expose
    public List<Book> books;



}
