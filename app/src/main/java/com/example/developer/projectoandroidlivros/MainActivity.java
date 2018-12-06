package com.example.developer.projectoandroidlivros;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.developer.projectoandroidlivros.adapter.ListLivroAdapter;
import com.example.developer.projectoandroidlivros.model.Book;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListLivroAdapter listLivroAdapter;
    private RecyclerView rvLivros;
    private RecyclerView.LayoutManager layoutManager;
    FragmentManager manager;
    FragmentTransaction transaction;
    private List<Book> books;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvLivros = (RecyclerView) findViewById(R.id.rvLivros);
        layoutManager = new LinearLayoutManager(this);
        rvLivros.setLayoutManager(layoutManager);
        rvLivros.setAdapter(listLivroAdapter);
        manager = getFragmentManager();
        transaction = manager.beginTransaction();
        transaction.add(R.id.rvLivros, new SecondFragment());
        transaction.commit();



    }

}




