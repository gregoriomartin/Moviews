package digitalhouse.android.a0317moacns1c_02.Fragments;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.yarolegovich.discretescrollview.DiscreteScrollView;
import com.yarolegovich.discretescrollview.transform.Pivot;
import com.yarolegovich.discretescrollview.transform.ScaleTransformer;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import digitalhouse.android.a0317moacns1c_02.Activities.ImageViewActivity;
import digitalhouse.android.a0317moacns1c_02.Adapters.MultimediaRecyclerAdapter;
import digitalhouse.android.a0317moacns1c_02.Adapters.PageIndicator;
import digitalhouse.android.a0317moacns1c_02.Helpers.ImageHelper;
import digitalhouse.android.a0317moacns1c_02.Model.Media.Video;
import digitalhouse.android.a0317moacns1c_02.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MediaListFragment extends Fragment implements View.OnClickListener {

    public static final String MEDIA_URLS_KEY = "mediaContainer";
    private Unbinder unbinder;

    private List<String> URLs;

    @BindView(R.id.multimedia_recycler_view) protected DiscreteScrollView mRecyclerView;
    @BindView(R.id.linearLayourMediaListPageIndicator) protected LinearLayout pageIndicatorContainer;

    public MediaListFragment() {
        // Required empty public constructor
    }

    public static MediaListFragment newInstance(ArrayList<String> URLs){
        MediaListFragment fragment = new MediaListFragment();
        Bundle args = new Bundle();
        args.putStringArrayList(MEDIA_URLS_KEY, URLs);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        if(getArguments() != null){
            URLs = getArguments().getStringArrayList(MEDIA_URLS_KEY);
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_media_list, container, false);
        unbinder = ButterKnife.bind(this, view);

        MultimediaRecyclerAdapter mAdapter = new MultimediaRecyclerAdapter(view.getContext(),
                URLs, this);


        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setItemTransformer(new ScaleTransformer.Builder()
                .setMaxScale(1.00f)
                .setMinScale(0.6f)
                .setPivotX(Pivot.X.CENTER) // CENTER is a default one
                .setPivotY(Pivot.Y.BOTTOM) // CENTER is a default one
                .build());
        mRecyclerView.setOffscreenItems(3);
        final PageIndicator pageIndicator = new PageIndicator(pageIndicatorContainer, URLs.size());
        mRecyclerView.addOnItemChangedListener(new DiscreteScrollView.OnItemChangedListener<RecyclerView.ViewHolder>() {
            @Override
            public void onCurrentItemChanged(@Nullable RecyclerView.ViewHolder viewHolder, int adapterPosition) {
                pageIndicator.setPage(adapterPosition);
            }
        });


        SnapHelper snapHelper = new LinearSnapHelper();
        snapHelper.attachToRecyclerView(mRecyclerView);

        return view;
    }

    @Override
    public void onDestroy() {
        unbinder.unbind();
        super.onDestroy();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.multimedia_recycler_image_view:
                onTrailerClick(view);
                break;
            default:
                break;
        }
    }

    private void onTrailerClick(View view){
        String URL = (String) view.getTag();
        if(URL.contains("youtube")) {
            URL = Video.thumbnailToVideoURL(URL);
            Intent playVideoIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(URL));
            startActivity(playVideoIntent);
        } else {
            Intent intent = new Intent(getContext(), ImageViewActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString(ImageViewActivity.IMAGE_PATH_KEY, ImageHelper.getImagePathFromFullURL(URL));
            bundle.putBoolean(ImageViewActivity.LANDSCAPE_KEY, true);
            intent.putExtras(bundle);
            startActivity(intent);
        }
    }
}
