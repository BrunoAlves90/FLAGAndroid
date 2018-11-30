package com.example.developer.projectoandroidlivros.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.developer.projectoandroidlivros.R;
import com.example.developer.projectoandroidlivros.model.Livro;
import com.squareup.picasso.Picasso;

import java.util.List;


public class ListLivroAdapter extends RecyclerView.Adapter<ListLivroAdapter.LivroViewHolder>  {

    private Context context;
    private List<Livro> livros;
    public static SetOnClickListBook setOnClickListBook;





    public ListLivroAdapter(Context context, List<Livro> livros, SetOnClickListBook setOnClickListBook)
    {
        this.context = context;
        this.livros = livros;
        ListLivroAdapter.setOnClickListBook = setOnClickListBook;
    }


    public static class LivroViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        ImageView ivLivro;
        TextView tvLivroNome;
        TextView tvLivroData;
        TextView tvLivroDetail;

        public LivroViewHolder(View itemView) {
            super(itemView);
            ivLivro = itemView.findViewById(R.id.ivLivro);
            tvLivroNome = itemView.findViewById(R.id.tvLivroNome);
            tvLivroData = itemView.findViewById(R.id.tvLivroData);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            setOnClickListBook.setBookItemClick(this.getLayoutPosition());
        }
    }


        public LivroViewHolder onCreateViewHolder (ViewGroup viewGroup, int i)
        {
            View view = LayoutInflater.from(context).inflate(R.layout.item, viewGroup, false);
            LivroViewHolder bookViewHolder = new LivroViewHolder(view);
            return bookViewHolder;

        }


        public void onBindViewHolder( LivroViewHolder bookViewHolder, int position)
        {
            bookViewHolder.tvLivroNome.setText(livros.get(position).getTitle());
            bookViewHolder.tvLivroData.setText(livros.get(position).getPublishedDate());
            bookViewHolder.tvLivroDetail.setText(livros.get(position).getDescription());
            Picasso.get().load(livros.get(position).getThumbnail()).into(bookViewHolder.ivLivro);

        }

        public int getItemCount() {
            return livros.size();
        }



    }





