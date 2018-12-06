package com.example.developer.projectoandroidlivros.model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GetDetailLivro {

    @GET(".}")
    Call<List<Book>> getDetailBook(@Path("id") String id);
}

