package com.junkycoders.popularmoviesappstage1;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.*;
import com.squareup.picasso.Picasso;

public class DetailedActivity extends AppCompatActivity {

    ImageView posterImageView;
    TextView movieName;
    TextView movieDate;
    TextView movieRate;
    TextView movieOverview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed);

        posterImageView = (ImageView)findViewById(R.id.posterImg);
        movieName = (TextView)findViewById(R.id.movieName);
        movieDate = (TextView)findViewById(R.id.movieReleaseDate);
        movieRate = (TextView)findViewById(R.id.movieRate);
        movieOverview = (TextView)findViewById(R.id.movieDescripation);


        Intent intent = getIntent();

        if(intent.getExtras()!=null) {

            String poster_url = intent.getStringExtra("urlImage");
            String originalName = intent.getStringExtra("name");
            String date = intent.getStringExtra("date");
            String rate = intent.getStringExtra("rate");
            String overview = intent.getStringExtra("overview");

            Picasso.get().load("http://image.tmdb.org/t/p/w185//" + poster_url).into(posterImageView);
            movieName.setText(originalName);
            movieDate.setText(date);
            movieRate.setText(rate+"/10");
            movieOverview.setText(overview);


        }
    }
}
