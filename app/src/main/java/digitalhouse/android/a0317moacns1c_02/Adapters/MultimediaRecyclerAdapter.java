package digitalhouse.android.a0317moacns1c_02.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import digitalhouse.android.a0317moacns1c_02.R;

/**
 * Created by Gregorio Martin on 28/5/2017.
 */

public class MultimediaRecyclerAdapter extends RecyclerView.Adapter<MultimediaRecyclerAdapter.ViewHolder> {

    private Context context;
    private List<String> mDataSet;
    private View.OnClickListener listener;

    public MultimediaRecyclerAdapter(Context context, List<String> myDataSet, View.OnClickListener listener){
        this.context = context;
        mDataSet = myDataSet;
        this.listener = listener;
    }

    @Override
    public MultimediaRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        LayoutInflater inflater = LayoutInflater.from(context);
        View cellView = inflater.inflate(R.layout.cell_multimedia_list, parent, false);
        ViewHolder viewHolder = new ViewHolder(cellView);

        // Aquí podemos definir tamaños, márgenes, paddings
        // ...

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position){
        // - obtenemos un elemento del dataset según su posición
        // - reemplazamos el contenido de los views según tales datos

        Picasso picasso = Picasso.with(context);
        View v = holder.itemView.findViewById(R.id.imageViewPlayButton);
        holder.picture.setOnClickListener(listener);
        String URL = mDataSet.get(position);
        picasso.load(URL)
                .fit()
                .centerCrop()
                .into(holder.picture);
        if(isYouTubeURL(URL))
        {
            v.setVisibility(View.VISIBLE);
            holder.picture.setTag(URL);
        }
        else
        {
            holder.picture.setTag(URL);
            v.setVisibility(View.GONE);
        }

    }

    // Método que define la cantidad de elementos del RecyclerView
    // Puede ser más complejo en RecyclerViews que implementar filtros o búsquedas
    @Override
    public int getItemCount() {
        return mDataSet.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView picture;

        public ViewHolder(View v){
            super(v);
            picture = (ImageView) itemView.findViewById(R.id.multimedia_recycler_image_view);
        }
    }

    private boolean isYouTubeURL(String URL){
        return URL.contains("youtube");
    }
}
