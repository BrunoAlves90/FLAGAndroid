package com.example.developer.projectoandroidlivros.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Book {




    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("titulo")
    @Expose
    private String titulo;
    @SerializedName("data")
    @Expose
    private String data;
    @SerializedName("descrição")
    @Expose
    private String descricao;
    @SerializedName("Thumbnail")
    @Expose
    private Integer Thumbnail;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getThumbnail() {
        return Thumbnail;
    }

    public void setThumbnail(Integer thumbnail) {
        Thumbnail = thumbnail;
    }
}





