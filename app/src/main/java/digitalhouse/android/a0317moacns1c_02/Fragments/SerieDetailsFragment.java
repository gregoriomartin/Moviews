package digitalhouse.android.a0317moacns1c_02.Fragments;


import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import digitalhouse.android.a0317moacns1c_02.Controller.GenreController;
import digitalhouse.android.a0317moacns1c_02.Controller.RateController;
import digitalhouse.android.a0317moacns1c_02.Helpers.ImageHelper;
import digitalhouse.android.a0317moacns1c_02.Model.General.Network;
import digitalhouse.android.a0317moacns1c_02.Model.Series.Serie;
import digitalhouse.android.a0317moacns1c_02.R;

public class SerieDetailsFragment extends Fragment {
    public static final String SERIE_KEY = "serie";

    @BindView(R.id.imageViewSDBackDrop) protected ImageView backdrop;
    @BindView(R.id.textViewSDTitle) protected TextView title;
    @BindView(R.id.textViewSDGenres) protected TextView genres;
    @BindView(R.id.textViewSDOnTheAir) protected TextView onTheAir;
    @BindView(R.id.textViewSDNetworkCont) protected TextView network;
    @BindView(R.id.textViewSDLaunchCont) protected TextView launchDate;
    @BindView(R.id.textViewSDSeasonsCont) protected TextView numberOfSeasons;
    @BindView(R.id.textViewSDChaptersCont) protected TextView numberOfChapters;
    @BindView(R.id.imageViewPoster) protected ImageView poster;
    @BindView(R.id.textViewSDSummary) protected TextView textViewSummary;
    @BindView(R.id.collapsing_toolbar) CollapsingToolbarLayout collapsingToolbar;
    @BindView(R.id.toolbar) Toolbar toolbar;

    private Unbinder unbinder;
    private Serie serie;


    public SerieDetailsFragment() {
        // Required empty public constructor
    }

    public static SerieDetailsFragment newInstance(Serie serie) {
        SerieDetailsFragment fragment = new SerieDetailsFragment();
        Bundle args = new Bundle();
        args.putSerializable(SERIE_KEY, serie);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            serie = (Serie)getArguments().getSerializable(SERIE_KEY);
        }
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_serie_details, container, false);

        unbinder = ButterKnife.bind(this, view);
        startRatingsFragment();
        setUpSummary();
        setUpImages();
        setUpTitleAndGenres();
        setUpInfo();
        startMediaListFragment();
        startCastListFragment();
        setUpCollapsingToolbar();
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                getActivity().onOptionsItemSelected(item);
                return true;
        }
        return false;
    }

    private void setUpTitleAndGenres(){
        title.setText(serie.getName() + " (" + serie.getYear() + ") ");
        genres.setText(GenreController.getInstance()
                .getGenresString(serie.getGenres(), " | "));
        if(!serie.getStatus().equals("Returning Series"))
            onTheAir.setVisibility(View.GONE);
    }

    private void setUpImages(){
        String url = ImageHelper.getPosterURL(serie.getBackDropPath(), 4);
        Picasso.with(getContext()).load(url).fit().centerCrop().into(backdrop);
    }

    private void setUpInfo(){
        String networks = Network.getNetworksInString(serie.getNetworks(), ", ");
        network.setText(networks);
        launchDate.setText(serie.getFirstAirDate());
        numberOfSeasons.setText(serie.getNumberOfSeasons());
        numberOfChapters.setText(serie.getNumberOfEpisodes());
        String url = ImageHelper.getPosterURL(serie.getPosterPath(), 2);
        Glide.with(this).load(url).into(poster);
    }

    private void setUpSummary(){
        textViewSummary.setText(serie.getOverview());
    }

    private void setUpCollapsingToolbar(){
        collapsingToolbar.setContentScrimColor(ContextCompat.getColor(getContext(), R.color.colorPrimary));
        collapsingToolbar.setTitle(serie.getName());
        collapsingToolbar.setCollapsedTitleTextAppearance(R.style.CollapsedToolbar);
        collapsingToolbar.setExpandedTitleTextAppearance(R.style.ExpandedToolbar);
        collapsingToolbar.setTitleEnabled(true);
        if (toolbar != null)
        {
            ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
            ActionBar actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
            if (actionBar != null)
            {
                actionBar.setDisplayHomeAsUpEnabled(true);
            }
        }
    }

    private void startRatingsFragment(){
        RateFragment rateFragment = RateController.instanceRateFragment(serie);
        getChildFragmentManager()
                .beginTransaction()
                .add(R.id.framelayoutSDRatings, rateFragment)
                .commit();
    }

    private void startMediaListFragment(){
        ArrayList<String> URLs;
        URLs = serie.getVideoContainer().getYouTubeThumbnailURLs();
        URLs.addAll(serie.getImagesContainer().getURLsList());
        MediaListFragment mediaListFragment = MediaListFragment.newInstance(URLs);
        getChildFragmentManager()
                .beginTransaction()
                .add(R.id.frameLayoutSDMedia, mediaListFragment)
                .commit();
    }

    private void startCastListFragment(){
        ImageListFragment imageListFragment = ImageListFragment.newInstance(
                serie.getCredits().getImageListItems(), "Casting");
        getChildFragmentManager()
                .beginTransaction()
                .add(R.id.frameLayoutSDCasting, imageListFragment)
                .commit();
    }

}
