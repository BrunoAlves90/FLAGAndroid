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

import com.example.developer.projectoandroidlivros.R;
import com.example.developer.projectoandroidlivros.model.Book;
import com.example.developer.projectoandroidlivros.model.Books;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Callback;

public class ListLivroAdapter extends RecyclerView.Adapter<ListLivroAdapter.LivroViewHolder> implements ListAdapter {

    private Context context;
    private List<Book> livroList;
    public static SetOnClickListLivro setOnClickListLivro;



    public ListLivroAdapter(Context context, List<Book> livroList, SetOnClickListLivro setOnClickListLivro)
    {
        this.context = context;
        this.livroList = livroList;
        this.setOnClickListLivro = setOnClickListLivro;
    }



    @Override
    public void registerDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }

    @Override
    public int getViewTypeCount() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean areAllItemsEnabled() {
        return false;
    }

    @Override
    public boolean isEnabled(int position) {
        return false;
    }

    public static class LivroViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView tvNome;
        TextView tvLivroData;
        TextView tvLivroDetails;
        ImageView ivLivro;

        CardView cardView;


        public LivroViewHolder(@NonNull View itemView) {

            super(itemView);
            cardView = (CardView) itemView.findViewById(R.id.cvItem);
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

            livroViewHolder.tvNome.setText(livroList.get(position).getTitulo());
            livroViewHolder.tvLivroData.setText(livroList.get(position).getData());
            livroViewHolder.tvLivroDetails.setText(livroList.get(position).getDescricao());
            Picasso.get().load(livroList.get(position).getThumbnail()).into(livroViewHolder.ivLivro);

        }


        public int getItemCount() {

            return livroList.size();
        }
    }







