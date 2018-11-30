package com.example.developer.projectoandroidlivros.model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GetLivroService {

        @GET("volumes?")
        Call<Livros> getListLivro(@Query("q") String assunto);
    }




