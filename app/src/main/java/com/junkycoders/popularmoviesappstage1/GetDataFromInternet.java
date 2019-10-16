package com.junkycoders.popularmoviesappstage1;

import java.io.*;
import java.net.*;

public class GetDataFromInternet {


    static private String base_URL ="" ;


    public static String getResponseFromHttpUrl(String sortingType) throws IOException {

        if(sortingType.equals("popular")){
            base_URL =
                    "https://api.themoviedb.org/3/discover/movie?sort_by=popularity.desc&api_key=37789dc48bb9195cdca528bdbc31ce85";
        }else{
            base_URL =
                    "http://api.themoviedb.org/3/discover/movie?certification_country=US&certification=R&sort_by=vote_average.desc&api_key=37789dc48bb9195cdca528bdbc31ce85";
        }
        String JSONData = "";

            URL url = new URL(base_URL);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

            try {
            InputStream inputStream = urlConnection.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";

            while (line != null){

                line = br.readLine();
                JSONData = JSONData + line;

            }

           return JSONData;

        } finally {

            urlConnection.disconnect();
        }
    }

}
