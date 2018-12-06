package com.example.developer.projectoandroidlivros;


import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;


import com.example.developer.projectoandroidlivros.adapter.ListLivroAdapter;
import com.example.developer.projectoandroidlivros.model.Book;
import com.example.developer.projectoandroidlivros.model.GetLivroService;
import com.example.developer.projectoandroidlivros.model.Books;
import com.example.developer.projectoandroidlivros.adapter.ListLivroAdapter;
import com.example.developer.projectoandroidlivros.adapter.SetOnClickListLivro;






import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SecondFragment extends Fragment implements  SetOnClickListLivro{
    private View view;
    private RecyclerView listLivro;
    private RecyclerView.LayoutManager layoutManager;
    private Books books;
    private String assunto;


    public View onCreateView(LayoutInflater inflater, ViewGroup rvLivros, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_, rvLivros, false);

        return view;

    }


    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        listLivro = (RecyclerView) view.findViewById(R.id.listLivros);
        listLivro.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getActivity());
        listLivro.setLayoutManager(layoutManager);

        books = new Books();


        Retrofit retrofit = new Retrofit.
                Builder().
                addConverterFactory(GsonConverterFactory.create()).
                baseUrl("https://www.googleapis.com/books/v1/").build();

        GetLivroService livroService = retrofit.create(GetLivroService.class);


        Call<Books> livrosCall = livroService.getListLivro("android");

        livrosCall.enqueue(new Callback<Books>() {

            @Override
            public void onResponse(Call<Books> call, Response<Books> response) {

                if (response.isSuccessful()) {
                    Log.d("RETROFIT", "OK");


                    books = response.body();


                    ListLivroAdapter listlivroAdapter = new ListLivroAdapter(getActivity(), books.books, SecondFragment.this);

                    listLivro.setAdapter(listlivroAdapter);


                } else {
                    Log.d("RETROFIT", "OK");
                }

            }

            @Override
            public void onFailure(Call<Books> call, Throwable t) {
                Log.d("RETROFIT", "FAIL");
                Log.d("RETROFIT", t.getMessage());

            }

        });

    }

            @Override
            public void setBookItemClick(int position) {
                DetailFragment detailFragment = new DetailFragment();
                Bundle bundle = new Bundle();
                bundle.putInt("id", books.books.get(position).getId());
                detailFragment.setArguments(bundle);
                getActivity().getFragmentManager().beginTransaction().replace(R.id.rvLivros, detailFragment, "detail").addToBackStack(null).commit();
            }

    }






