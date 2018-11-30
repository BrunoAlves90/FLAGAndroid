package com.example.developer.projectoandroidlivros;


import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.developer.projectoandroidlivros.adapter.ListLivroAdapter;
import com.example.developer.projectoandroidlivros.adapter.SetOnClickListBook;
import com.example.developer.projectoandroidlivros.model.GetLivroService;
import com.example.developer.projectoandroidlivros.model.Livro;
import com.example.developer.projectoandroidlivros.model.Livros;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SecondFragment extends Fragment implements SetOnClickListBook {
    private View view;
    private RecyclerView listLivro;
    private RecyclerView.LayoutManager layoutManager;
    private Livros livros;
    private String assunto;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup rvLivros, Bundle savedInstanceState) {
        view = LayoutInflater.from(rvLivros.getContext()).inflate(R.layout.fragment_, rvLivros, false);

        return view;

    }

        public void onActivityCreated(Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);

            listLivro = view.findViewById(R.id.listLivros);
            listLivro.setHasFixedSize(true);
            layoutManager = new LinearLayoutManager(getActivity());
            listLivro.setLayoutManager(layoutManager);

            livros = new Livros();

            Retrofit retrofit = new Retrofit.
                    Builder().
                    addConverterFactory(GsonConverterFactory.create()).
                    baseUrl("https://www.googleapis.com/books/v1/").build();
            GetLivroService livroService = retrofit.create(GetLivroService.class);


            Call<Livros> livrosCall = livroService.getListLivro("android");

        livrosCall.enqueue(new Callback<Livros>() {
            @Override
            public void onResponse(Call<Livros> call, Response<Livros> response) {
                if (response.isSuccessful()) {
                    Log.d("RETROFIT", "OK");


                    livros = response.body();

                    ListLivroAdapter listLivroAdapter = new ListLivroAdapter(getActivity(), livros.livros,SecondFragment.this);

                    listLivro.setAdapter(listLivroAdapter);

                } else {
                    Log.d("RETROFIT", "NAO OK");
                }
            }

            @Override
            public void onFailure(Call<Livros> call, Throwable t) {
                Log.d("RETROFIT", "FAIL");
                Log.d("RETROFIT", t.getMessage());


            }
        });

    }

    @Override
    public void setBookItemClick(int position) {
        DetailFragment detailFragment = new DetailFragment();
        Bundle bundle = new Bundle();
        bundle.putString("{id}", livros.livros.get(position).getId());
        detailFragment.setArguments(bundle);
        getActivity().getFragmentManager().beginTransaction().replace(R.id.rvLivros,detailFragment,"detail").addToBackStack(null).commit();


    }
}














