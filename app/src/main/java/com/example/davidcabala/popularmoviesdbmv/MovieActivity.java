package com.example.davidcabala.popularmoviesdbmv;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.davidcabala.popularmoviesdbmv.database.AppDatabase;
import com.example.davidcabala.popularmoviesdbmv.database.FavouriteMovie;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.List;

public class MovieActivity extends AppCompatActivity {

    private ImageView photo;
    private TextView title;
    private TextView release_date;
    private TextView vote_average;
    private TextView total_votes;
    private TextView overview;
    private AppDatabase mDB;
    private List<FavouriteMovie> favourites;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);
        mDB = AppDatabase.getInstance(getApplicationContext());


        Button favBtn = (Button) findViewById(R.id.fav_button);

        favourites = mDB.favouritesDao().getAllFavourites();
        //Log.d("------ id ------", favourites.size()+"" );
                for( FavouriteMovie movie : favourites ) {
                    Log.d("------ id ------",  movie.getId()+"" );
                    Log.d("------ title ------", movie.getTitle());
                    Log.d("------ poster ------", movie.getPoster_url());
                }

        favBtn.setOnClickListener(new View.OnClickListener() {
            int i = 7;
            @Override
            public void onClick(View view) {
                i++;
                Log.d("--------------", "KLIK "+i);
                FavouriteMovie movie = new FavouriteMovie(i,"title nb "+i,"http://url/"+i);
                mDB.favouritesDao().insertFavourite(movie);
            }
        });

        photo        = findViewById(R.id.movie_activity_imageView);
        title        = findViewById(R.id.movie_activity_title);
        release_date = findViewById(R.id.movie_activity_release);
        vote_average = findViewById(R.id.movie_activity_votes_av);
        total_votes  = findViewById(R.id.movie_activity_votes_total);
        overview     = findViewById(R.id.movie_activity_content);

        String incomingString = getIntent().getStringExtra("MOVIE_OBJECT");
        Gson gson = new Gson();
        Movie movie = gson.fromJson( incomingString, Movie.class );


        Picasso.get()
                .load( movie.getPosterPath() )
                .placeholder( R.mipmap.placeholder )
                .into( photo );

        title.setText( movie.getTitle() );
        release_date.setText( movie.getReleaseDate() );
        vote_average.setText( movie.getVoteAverage() );
        total_votes.setText( movie.getVoteCount() );
        overview.setText( movie.getOverview() );

        Log.d("---- == MOVIE J == ---", incomingString);

    }

    public void favouritesButtonClicked() {

    }
}
