package com.example.developer.projectoandroidlivros.adapter;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.developer.projectoandroidlivros.R;
import com.example.developer.projectoandroidlivros.model.Livro;
import com.squareup.picasso.Picasso;

import java.util.List;


public class ListLivroAdapter extends BaseAdapter {

    private Context context;
    private List<Livro> livroList;


    public ListLivroAdapter(Context context, List<Livro> livroList) {
        this.context = context;
        this.livroList = livroList;

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
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_livro,parent,false);

        ImageView ivlivro = (ImageView) view.findViewById(R.id.ivLivroDetail);
        TextView tvLivroNome = (TextView) view.findViewById(R.id.tvLivroNome);
        TextView tvLivroData = (TextView) view.findViewById(R.id.tvLivroData);
        TextView tvLivroDetails = (TextView) view.findViewById(R.id.tvLivroDetails);


        tvLivroNome.setText(livroList.get(position).getNomeLivro());
        tvLivroData.setText(livroList.get(position).getDataLivro());
        tvLivroDetails.setText(livroList.get(position).getDescLivro());
        Picasso.get().load(livroList.get(position).getImageUrl()).into(ivlivro);




        return view;




    }
}


