package com.example.developer.projectoandroidlivros;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.developer.projectoandroidlivros.model.Book;
import com.example.developer.projectoandroidlivros.model.GetDetailLivro;
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
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://www.googleapis.com/books/v1/volumes/").
                addConverterFactory(GsonConverterFactory.create()).
                build();

        GetDetailLivro detailLivro = retrofit.create(GetDetailLivro.class);

        Call<List<Book>> livroCall = detailLivro.getDetailBook(" ");


        livroCall.enqueue(new Callback<List<Book>>() {
            public void onResponse(Call<List<Book>> call, Response<List<Book>> response) {
                if (response.isSuccessful()) {
                    Log.d("RETROFIT", "OK");

                    prepareView(response.body().get(0));
                } else {
                    Log.d("RETROFIT", "NOTOK");
                }
            }

            public void onFailure(Call<List<Book>> call, Throwable t) {
                Log.d("RETROFIT", "FAIL");

            }
        });


    }

    private void prepareView(Book book) {

    ivLivro = (ImageView) view.findViewById(R.id.ivLivro);
    tvLivroNomeDetail = (TextView) view.findViewById(R.id.tvLivroNomeDetail);
    tvLivroDataDetail = (TextView) view.findViewById(R.id.tvLivroDataDetail);
    tvLivroDescDetail = (TextView) view.findViewById(R.id.tvLivroDescDetail);


        //Picasso.get().load(book.getThumbnail()).into(ivLivro);
        tvLivroNomeDetail.setText(book.getTitle());
        tvLivroDataDetail.setText(book.getPublishedDate());
        tvLivroDescDetail.setText(book.getDescription());

    }

}
