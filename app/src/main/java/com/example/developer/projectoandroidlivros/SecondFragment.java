package com.example.developer.projectoandroidlivros;


import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.developer.projectoandroidlivros.adapter.ListLivroAdapter;
import com.example.developer.projectoandroidlivros.model.GetBookService;
import com.example.developer.projectoandroidlivros.model.Livro;
import com.example.developer.projectoandroidlivros.model.Livros;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SecondFragment extends Fragment {

    private View view;
    private ListView lvLivros;


    public SecondFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.activity_main, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        lvLivros  = (ListView) view.findViewById(R.id.listLivros);
        final Livros livros = new Livros();

        Retrofit retrofit = new Retrofit.
                Builder().
                addConverterFactory(GsonConverterFactory.create()).
                baseUrl("https://www.googleapis.com/books/v1/volumes/").build();

        GetBookService bookService = retrofit.create(GetBookService.class);

        Call<List<Livro>> livrosCall = bookService.getListLivro();

        livrosCall.enqueue(new Callback<List<Livro>>() {
            @Override
            public void onResponse(Call<List<Livro>> call, Response<List<Livro>> response) {
                if (response.isSuccessful()){
                    Log.d("RETROFIT","OK");


                    livros.livros = response.body();

                    ListLivroAdapter listLivroAdapter = new ListLivroAdapter(getActivity(),livros.livros);

                    lvLivros.setAdapter(listLivroAdapter);

                }else{
                    Log.d("RETROFIT","NAO OK");
                }
            }

            @Override
            public void onFailure(Call<List<Livro>> call, Throwable t) {
                Log.d("RETROFIT","FAIL");
                Log.d("RETROFIT",t.getMessage());


            }
        });

/*            lvLivros.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SecondFragment secondFragment = new SecondFragment();
                Bundle bundle = new Bundle();
                bundle.putString("id",livros.livros.get(position).getId());
                secondFragment.setArguments(bundle);
                getActivity().getFragmentManager().beginTransaction().replace(R.id.rvLivros, secondFragment, "detail").addToBackStack(null).commit();








            }
        });
*/


    }
}
















