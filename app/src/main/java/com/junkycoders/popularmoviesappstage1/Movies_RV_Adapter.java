package com.junkycoders.popularmoviesappstage1;

import android.content.Context;
import android.view.*;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;


public class Movies_RV_Adapter extends RecyclerView.Adapter<Movies_RV_Adapter.Movies_RV_ViewHolder> {


    Context context;
    Movie data;
    private final Movies_RV_AdapterOnClickHandler mClickHandler;


    public interface Movies_RV_AdapterOnClickHandler {
        void onClick(Movie data , int position);
    }

    public Movies_RV_Adapter(Context context , Movie data , Movies_RV_AdapterOnClickHandler mClickHandler){

        this.context = context;
        this.data = data;
        this.mClickHandler = mClickHandler;
    }

    @NonNull
    @Override
    public Movies_RV_ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflator = LayoutInflater.from(context);
        View myOwenView = inflator.inflate(R.layout.item_row , parent , false);

        return new Movies_RV_ViewHolder(myOwenView);
    }

    @Override
    public void onBindViewHolder(@NonNull Movies_RV_ViewHolder holder, int position) {


        Picasso.get().load("http://image.tmdb.org/t/p/w185//"+data.getImage().get(position)).into(holder.moviesPoster);

    }

    @Override
    public int getItemCount() {
        return data.getImage().size();
    }

    public class Movies_RV_ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView moviesPoster;

        public Movies_RV_ViewHolder(@NonNull View itemView) {
            super(itemView);

            moviesPoster = (ImageView)itemView.findViewById(R.id.imageViewPoster);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {


            mClickHandler.onClick(data , getAdapterPosition());

        }
    }
}
