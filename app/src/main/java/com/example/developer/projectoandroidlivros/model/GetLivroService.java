package com.example.developer.projectoandroidlivros.model;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GetLivroService {

        @GET("volumes")
        Call<Books> getListLivro(@Query("q") String tema);
    }




