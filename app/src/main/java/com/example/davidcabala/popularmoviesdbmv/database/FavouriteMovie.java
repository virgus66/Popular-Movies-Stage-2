package com.example.davidcabala.popularmoviesdbmv.database;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName="favourites")
public class FavouriteMovie {

    @PrimaryKey
    private int id;
    private String title;
    private String poster_url;

    @Ignore
    public FavouriteMovie(String title, String poster_url) {
        this.title      = title;
        this.poster_url = poster_url;
    }

    public FavouriteMovie(int id, String title, String poster_url) {
        this.id         = id;
        this.title      = title;
        this.poster_url = poster_url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPoster_url() {
        return poster_url;
    }

    public void setPoster_url(String poster_url) {
        this.poster_url = poster_url;
    }
}
