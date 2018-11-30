package com.example.developer.projectoandroidlivros.model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GetDetailBook {

    @GET("{id}")
    Call<List<Livro>> getDetailBook(@Path("id") String id);
}
