package com.junkycoders.popularmoviesappstage1;

import java.util.ArrayList;

public class Movie {

    private ArrayList<String> image;
    private ArrayList<String> originalName;
    private ArrayList<String> realeaseDate;
    private ArrayList<String> rate;
    private ArrayList<String> overview;


    public ArrayList<String> getOverview() {
        return overview;
    }

    public void setOverview(ArrayList<String> overview) {
        this.overview = overview;
    }

    public ArrayList<String> getRate() {
        return rate;
    }

    public void setRate(ArrayList<String> rate) {
        this.rate = rate;
    }

    public ArrayList<String> getRealeaseDate() {
        return realeaseDate;
    }

    public void setRealeaseDate(ArrayList<String> realeaseDate) {
        this.realeaseDate = realeaseDate;
    }


    public ArrayList<String> getOriginalName() {
        return originalName;
    }

    public void setOriginalName(ArrayList<String> originalName) {
        this.originalName = originalName;
    }


    public ArrayList<String> getImage() {
        return image;
    }

    public void setImage(ArrayList<String> image) {
        this.image = image;
    }


}
