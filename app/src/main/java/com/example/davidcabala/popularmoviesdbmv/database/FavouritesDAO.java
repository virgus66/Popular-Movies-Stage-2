package com.example.davidcabala.popularmoviesdbmv.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface FavouritesDAO {

    @Query("SELECT * FROM favourites ORDER BY id")
    List<FavouriteMovie> getAllFavourites();

    @Insert
    void insertFavourite(FavouriteMovie favouriteMovie);

    @Delete
    void deleteFavourite(FavouriteMovie favouriteMovie);
}
