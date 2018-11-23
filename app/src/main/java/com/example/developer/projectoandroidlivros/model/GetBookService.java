package com.example.developer.projectoandroidlivros.model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetBookService {

        @GET(".")
        Call<List<Livro>> getListLivro();
    }




