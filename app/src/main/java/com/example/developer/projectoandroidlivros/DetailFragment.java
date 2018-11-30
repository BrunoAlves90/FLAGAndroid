package com.example.developer.projectoandroidlivros;

import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.developer.projectoandroidlivros.model.GetDetailBook;
import com.example.developer.projectoandroidlivros.model.Livro;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DetailFragment extends Fragment {

    private View view;
    private ImageView ivLivro;
    private TextView tvLivroNomeDetail;
    private TextView tvLivroDataDetail;
    private TextView tvLivroDescDetail;


    public DetailFragment() {

    }


    public View onCreateView(LayoutInflater inflater, ViewGroup rvLivros, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_details, rvLivros, false);
        return view;
    }


    public void onActivityCreated( Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        String id = getArguments().getString("id");
        Retrofit retrofit = new Retrofit.
                Builder().
                baseUrl("https://www.googleapis.com/books/v1/volumes?").
                addConverterFactory(GsonConverterFactory.create()).
                build();

        GetDetailBook detailBook = retrofit.create(GetDetailBook.class);

        Call<List<Livro>> livroCall = detailBook.getDetailBook(id);

        livroCall.enqueue(new Callback<List<Livro>>() {
            public void onResponse(Call<List<Livro>> call, Response<List<Livro>> response) {
                if (response.isSuccessful()) {
                    Log.d("Retrofit", "ok");

                    prepareView(response.body().get(0));
                } else {
                    Log.d("Retrofit", "FAIL");
                }
            }

            public void onFailure(Call<List<Livro>> call, Throwable t) {
                Log.d("RETROFIT", "FAIL");

            }
        });


    }

    private void prepareView(Livro livro) {

    ivLivro = view.findViewById(R.id.ivLivro);
    tvLivroNomeDetail = view.findViewById(R.id.tvLivroNomeDetail);
    tvLivroDataDetail = view.findViewById(R.id.tvLivroDataDetail);
    tvLivroDescDetail = view.findViewById(R.id.tvLivroDescDetail);


        Picasso.get().load(livro.getThumbnail()).into(ivLivro);
        tvLivroNomeDetail.setText(livro.getTitle());
        tvLivroDataDetail.setText(livro.getPublishedDate());
        tvLivroDescDetail.setText(livro.getDescription());

    }






}
