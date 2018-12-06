package com.example.developer.projectoandroidlivros;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;



public class MainActivity extends AppCompatActivity {

    android.app.FragmentManager manager;
    android.app.FragmentTransaction transaction;


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




