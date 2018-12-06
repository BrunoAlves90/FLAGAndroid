package com.example.developer.projectoandroidlivros.adapter;


import android.app.Activity;
import android.content.Context;
import android.database.DataSetObserver;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.example.developer.projectoandroidlivros.MainActivity;
import com.example.developer.projectoandroidlivros.R;
import com.example.developer.projectoandroidlivros.model.Book;
import com.example.developer.projectoandroidlivros.model.Books;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Callback;

public class ListLivroAdapter extends RecyclerView.Adapter<ListLivroAdapter.LivroViewHolder> {

    private Context context;
    private List<Book> livroList;
    public static SetOnClickListLivro setOnClickListLivro;



    public ListLivroAdapter(Context context, List<Book> livroList, SetOnClickListLivro setOnClickListLivro)
    {
        this.context = context;
        this.livroList = livroList;
        this.setOnClickListLivro = setOnClickListLivro;
    }



    public static class LivroViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView tvNome;
        TextView tvLivroData;
        TextView tvLivroDetails;
        ImageView ivLivro;



        public LivroViewHolder( View itemView) {

            super(itemView);
            ivLivro = (ImageView) itemView.findViewById(R.id.ivLivro);
            tvNome = (TextView) itemView.findViewById(R.id.tvLivroNome);
            tvLivroData = (TextView) itemView.findViewById(R.id.tvLivroData);
            tvLivroDetails = (TextView) itemView.findViewById(R.id.tvLivroDetails);
        }

        @Override
        public void onClick(View v) {
            setOnClickListLivro.setBookItemClick(this.getLayoutPosition());


        }
    }




        public LivroViewHolder onCreateViewHolder( ViewGroup viewGroup, int i) {
            View view = LayoutInflater.from(context).inflate(R.layout.item,viewGroup,false);

            LivroViewHolder livroViewHolder = new LivroViewHolder(view);

            return livroViewHolder;
        }

        public void onBindViewHolder( LivroViewHolder livroViewHolder, int position) {

            livroViewHolder.tvNome.setText(livroList.get(position).getTitle());
            livroViewHolder.tvLivroData.setText(livroList.get(position).getPublishedDate());
            livroViewHolder.tvLivroDetails.setText(livroList.get(position).getDescription());

        }


        public int getItemCount() {

            return livroList.size();
        }
    }







