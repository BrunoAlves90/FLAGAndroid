package com.example.developer.projectoandroidlivros.model;

public class Livro {

    private String  id;
    private String NomeLivro;
    private String  DataLivro;
    private String DescLivro;
    private String imageUrl;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNomeLivro() {
        return NomeLivro;
    }

    public void setNomeLivro(String nomeLivro) {
        NomeLivro = nomeLivro;
    }

    public String getDataLivro() {
        return DataLivro;
    }

    public void setDataLivro(String dataLivro) {
        DataLivro = dataLivro;
    }

    public String getDescLivro() {
        return DescLivro;
    }

    public void setDescLivro(String descLivro) {
        DescLivro = descLivro;
    }

    public String getImageUrl() {
        return imageUrl;
    }


}

