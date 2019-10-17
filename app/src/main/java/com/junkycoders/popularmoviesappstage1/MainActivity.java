package com.junkycoders.popularmoviesappstage1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.*;
import android.content.Intent;
import android.os.*;
import android.view.*;
import android.widget.*;

public class MainActivity extends AppCompatActivity implements Movies_RV_Adapter.Movies_RV_AdapterOnClickHandler {

    RecyclerView moviesList ;
    Movies_RV_Adapter movies_adapter;
    private ProgressBar mLoadingIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLoadingIndicator = (ProgressBar) findViewById(R.id.pb_loading_indicator);
        moviesList = (RecyclerView)findViewById(R.id.MoviesList);

         /*Check internet connection*/
        ConnectivityManager ConnectionManager=(ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo=ConnectionManager.getActiveNetworkInfo();
        if(networkInfo != null && networkInfo.isConnected()==true ) {

            /* pass string paramter to specify API query */
            new FetchMovieTask("popular").execute();

        } else
        {
            Toast.makeText(MainActivity.this, "Network Not Available", Toast.LENGTH_LONG).show();
            mLoadingIndicator.setVisibility(View.INVISIBLE);
        }
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){

            /*API query depend on popularty
            *
            *
            * */

            case R.id.sort_popularity:new FetchMovieTask("popular").execute();
            break;


            /*API query depend on Rate
             *
             *
             * */
            case R.id.sort_rate :new FetchMovieTask("rate").execute();
            break;
        }

        return super.onOptionsItemSelected(item);
    }

    /* Layout Manager of My custum Recyclerview

    with my custum model data paramter that have JSON data

    */

    public  void loadDate(Movie data){

        movies_adapter = new Movies_RV_Adapter(this, data , this);
        moviesList.setAdapter(movies_adapter);
        moviesList.hasFixedSize();
        moviesList.setLayoutManager(new GridLayoutManager(this, 2));
    }


    /* get data from internet by async thread */
    public class FetchMovieTask extends AsyncTask<String, Void, Movie> {

        String sortingType;

        public FetchMovieTask(String sortingType){
            this.sortingType = sortingType;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mLoadingIndicator.setVisibility(View.VISIBLE);
        }

        @Override
        protected Movie doInBackground(String... params) {

            try {
                /* get JSON String from movieDB */
                String jsonMovieResponse = GetDataFromInternet
                        .getResponseFromHttpUrl(sortingType);

                /*return object with JSON data*/
                return JSONUtilts.getMovieObject(jsonMovieResponse);

            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }


        @Override
        protected void onPostExecute(Movie s) {
            super.onPostExecute(s);

            if(s!=null){
            mLoadingIndicator.setVisibility(View.INVISIBLE);
            loadDate(s);
            }else
            {
                mLoadingIndicator.setVisibility(View.INVISIBLE);
                Toast.makeText(MainActivity.this , "Failed to get data from internet \n please try again.",Toast.LENGTH_LONG).show();
            }

        }
    }


    /* Recyclerview press handuler
    *
    * open new details screen
    *
    *  */

    @Override
    public void onClick(Movie data , int position) {
        Intent intent = new Intent(MainActivity.this , DetailedActivity.class);
        intent.putExtra("urlImage" , data.getImage().get(position));
        intent.putExtra("name" , data.getOriginalName().get(position));
        intent.putExtra("date" , data.getRealeaseDate().get(position));
        intent.putExtra("rate" , data.getRate().get(position));
        intent.putExtra("overview" , data.getOverview().get(position));
        startActivity(intent);
    }

}
