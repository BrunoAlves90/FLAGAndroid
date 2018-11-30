package com.example.developer.projectoandroidlivros;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.example.developer.projectoandroidlivros.adapter.ListLivroAdapter;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvLivros;
    private RecyclerView.LayoutManager layoutManager;
    android.app.FragmentManager manager;
    android.app.FragmentTransaction transaction;
    private ListLivroAdapter adapter;
    private List<String> livros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager = getFragmentManager();
        transaction = manager.beginTransaction();

        transaction.add(R.id.rvLivros, new SecondFragment());

        transaction.commit();


    }

}












    /*
    FragmentManager manager;
    FragmentTransaction transaction;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        manager = getFragmentManager();
        transaction = manager.beginTransaction();

        transaction.add(R.id.rvLivros, new SecondFragment());


        transaction.commit();


    }
}
*/