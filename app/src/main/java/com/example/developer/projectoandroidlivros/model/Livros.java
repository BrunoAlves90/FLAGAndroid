package com.example.developer.projectoandroidlivros.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Livros {

    @SerializedName("items")
    @Expose
    public List<Livro> livros;



}
