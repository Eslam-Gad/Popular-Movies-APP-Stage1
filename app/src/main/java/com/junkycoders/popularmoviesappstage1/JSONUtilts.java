package com.junkycoders.popularmoviesappstage1;

import org.json.*;

import java.util.ArrayList;

public class JSONUtilts {


    public static Movie getMovieObject(String JSONString) throws JSONException{

        ArrayList<String> image = new ArrayList<>();
        ArrayList<String> originalName = new ArrayList<>();
        ArrayList<String> realeaseDate = new ArrayList<>();
        ArrayList<String> rate = new ArrayList<>();
        ArrayList<String> overview = new ArrayList<>();

        JSONObject Jsonobject ;
        JSONArray json_arr;
        JSONObject jo;


        try {


            Jsonobject = new JSONObject(JSONString);
            json_arr = new JSONArray(Jsonobject.getString("results"));
            for(int i = 0 ; i <json_arr.length();i++) {
                jo = (JSONObject) json_arr.get(i);
                image.add(jo.getString("poster_path"));
                originalName.add(jo.getString("original_title"));
                realeaseDate.add(jo.getString("release_date"));
                rate.add(jo.getString("vote_average"));
                overview.add(jo.getString("overview"));

            }


        }catch (JSONException ex){

            throw ex;
        }

        Movie movie = new Movie();


        movie.setImage(image);
        movie.setOriginalName(originalName);
        movie.setRate(rate);
        movie.setRealeaseDate(realeaseDate);
        movie.setOverview(overview);

        return movie;
    }

}
