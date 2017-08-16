package digitalhouse.android.a0317moacns1c_02.Adapters;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.text.Layout;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import digitalhouse.android.a0317moacns1c_02.Model.Media.ImageListItem;
import digitalhouse.android.a0317moacns1c_02.R;

/**
 * Created by Pablo on 25/05/2017.
 */

public class ImageListRecyclerAdapter extends Adapter {
    private Context context;
    private List<ImageListItem> imgList;
    private View.OnClickListener onClickListener;
    private Integer width;
    private Boolean headerMode = false;

    public ImageListRecyclerAdapter(List<ImageListItem> personList, Context context, View.OnClickListener onClickListener) {
        this.context = context;
        this.imgList = personList;
        this.onClickListener = onClickListener;
        Display display = ((Activity)context).getWindowManager().getDefaultDisplay();
        Point size = new Point();
        try {
            display.getRealSize(size);
        } catch (NoSuchMethodError err) {
            display.getSize(size);
        }
        width = size.x;
    }

    public void setHeaderMode() {
        this.headerMode = true;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View cellView = inflater.inflate(R.layout.cell_image_list, parent, false);
        cellView.setOnClickListener(onClickListener);

        // ajustar tamaño de celda si el ancho de la lista es menor al ancho de la pantalla (si esta en modo encabezado)
        FrameLayout cellLayout = (FrameLayout) cellView.findViewById(R.id.frameLayoutImageListCell);
        Integer cellWidth = cellLayout.getLayoutParams().width;
        Integer listWidth = imgList.size() * cellWidth;
        if (listWidth<width && headerMode) {
            FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(width/imgList.size(), cellLayout.getLayoutParams().height);
            cellLayout.setLayoutParams(lp);
        }
        ImageViewHolder imgViewHolder = new ImageViewHolder(cellView);
        return imgViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ImageListItem img = imgList.get(position);
        ImageViewHolder imgHolder = (ImageViewHolder) holder;
        imgHolder.title.setText(img.getTitle());
        imgHolder.subtitle.setText(img.getSubtitle());
        Picasso.with(context).load(img.getImageURL()).fit().centerCrop().into(imgHolder.picture);
        imgHolder.view.setTag(position);
        if (img.getTitle()==null) imgHolder.title.setHeight(0);
        if (img.getSubtitle()==null) imgHolder.subtitle.setHeight(0);
    }

    @Override
    public int getItemCount() {
        return imgList.size();
    }

    private class ImageViewHolder extends RecyclerView.ViewHolder {
        private View view;
        private ImageView picture;
        private TextView title;
        private TextView subtitle;
        private ImageViewHolder(View view) {
            super(view);
            this.view = view;
            picture = (ImageView) view.findViewById(R.id.imageViewCreditsPicture);
            title = (TextView) view.findViewById(R.id.textViewCreditsName);
            subtitle = (TextView) view.findViewById(R.id.textViewCreditsCharacter);
        }
    }
}
