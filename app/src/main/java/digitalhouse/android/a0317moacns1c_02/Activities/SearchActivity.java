package digitalhouse.android.a0317moacns1c_02.Activities;

import android.content.Intent;
import android.os.Parcelable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import java.io.Serializable;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import digitalhouse.android.a0317moacns1c_02.APIs.TMDB.TMDBClient;
import digitalhouse.android.a0317moacns1c_02.Adapters.SearchPagerAdapter;
import digitalhouse.android.a0317moacns1c_02.Callbacks.ResultListener;
import digitalhouse.android.a0317moacns1c_02.Model.General.ListItem;
import digitalhouse.android.a0317moacns1c_02.Model.Person.PersonDetails;
import digitalhouse.android.a0317moacns1c_02.Model.Requests.MovieSearchRequest;
import digitalhouse.android.a0317moacns1c_02.Fragments.ItemListFragment;
import digitalhouse.android.a0317moacns1c_02.Model.Requests.PersonSearchRequest;
import digitalhouse.android.a0317moacns1c_02.Model.Requests.SerieSearchRequest;
import digitalhouse.android.a0317moacns1c_02.R;
import digitalhouse.android.a0317moacns1c_02.Controller.SearchController;

public class SearchActivity extends AppCompatActivity implements ItemListFragment.ItemClickeable {

    public static final String SEARCH_ACTIVITY_QUERY_TAG = "query";
    public static final String SEARCH_ACTION_TAG = "search_action";

    public enum SEARCH_TYPE implements Serializable{
        MOVIES, SERIES, ACTORS
    }

    private static Integer currentTab;
    private SearchPagerAdapter adapter;

    @BindView(R.id.toolbar_editText) protected EditText searchEditText;
    @BindView(R.id.search_act_toolbar) protected Toolbar toolbar;
    @BindView(R.id.tab_layout) protected TabLayout tabLayout;
    @BindView(R.id.view_pager) protected ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        ButterKnife.bind(this);

        Intent intent = getIntent();
        if(intent.hasExtra(SEARCH_ACTION_TAG))
        {
            Integer default_value = 0;
            currentTab = intent.getIntExtra(SEARCH_ACTION_TAG, default_value);
        }

        if(intent.hasExtra(SEARCH_ACTIVITY_QUERY_TAG)){
            String query = intent.getStringExtra(SEARCH_ACTIVITY_QUERY_TAG);
            searchEditText.setText(query);
            onButtonSearchPressed(query);
        }

        tabLayout.addTab(tabLayout.newTab().setText("Movies"));
        tabLayout.addTab(tabLayout.newTab().setText("Series"));
        tabLayout.addTab(tabLayout.newTab().setText("People"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        setSupportActionBar(toolbar);

        loadViewPager();
    }


    private void loadViewPager() {
        adapter = new SearchPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                currentTab = viewPager.getCurrentItem();
                switch (currentTab){
                    case 1:
                        searchEditText.setHint("Search series...");
                        break;
                    case 2:
                        searchEditText.setHint("Search people...");
                        break;
                    case 0:
                    default:
                        searchEditText.setHint("Search movies...");
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager.setCurrentItem(currentTab);

    }

    //Mas adelate voy a agregar todas las opciones de busqueda, por eso los diferentes requests
    private void onButtonSearchPressed(String query){
        // buscar movies
        MovieSearchRequest movieSearchRequest = new MovieSearchRequest(query);
        SearchController.getInstance().searchMovies(movieSearchRequest, new ResultListener<ArrayList<ListItem>>() {
            @Override
            public void finish(ArrayList<ListItem> movieList) {
                ItemListFragment itemListFragment = new ItemListFragment();
                Bundle bundle = new Bundle();
                bundle.putParcelableArrayList(ItemListFragment.ITEM_LIST_KEY, movieList);
                itemListFragment.setArguments(bundle);
                adapter.getFragments().set(0, itemListFragment);
                adapter.notifyDataSetChanged();
            }
        });
        // buscar series
        SerieSearchRequest serieSearchRequest = new SerieSearchRequest(query);
        SearchController.getInstance().searchSeries(serieSearchRequest, new ResultListener<ArrayList<ListItem>>() {
            @Override
            public void finish(ArrayList<ListItem> serieList) {
                ItemListFragment itemListFragment = new ItemListFragment();
                Bundle bundle = new Bundle();
                bundle.putParcelableArrayList(ItemListFragment.ITEM_LIST_KEY, serieList);
                itemListFragment.setArguments(bundle);
                adapter.getFragments().set(1, itemListFragment);
                adapter.notifyDataSetChanged();
            }
        });
        // buscar gente
        PersonSearchRequest personSearchRequest = new PersonSearchRequest(query);
        SearchController.getInstance().searchPeople(personSearchRequest, new ResultListener<ArrayList<ListItem>>() {
            @Override
            public void finish(ArrayList<ListItem> personList) {
                ItemListFragment itemListFragment = new ItemListFragment();
                Bundle bundle = new Bundle();
                bundle.putParcelableArrayList(ItemListFragment.ITEM_LIST_KEY, personList);
                itemListFragment.setArguments(bundle);
                adapter.getFragments().set(2, itemListFragment);
                adapter.notifyDataSetChanged();
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_search:
                if(!TextUtils.isEmpty(searchEditText.getText()))
                    onButtonSearchPressed(searchEditText.getText().toString());
                return true;
            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.searchmenu, menu);
        return true;
    }

    @Override
    public void onClick(ListItem listItem) {
        if (listItem.getType().equals("movie")) {
            Bundle bundle = new Bundle();
            bundle.putInt(MovieDetailsActivity.MOVIE_ID_KEY, listItem.getId());
            Intent intent = new Intent(this, MovieDetailsActivity.class);
            intent.putExtras(bundle);
            startActivity(intent);
        }
        if (listItem.getType().equals("serie")) {

        }
        if (listItem.getType().equals("person")) {
            Bundle bundle = new Bundle();
            bundle.putInt(PersonDetailsActivity.PERSON_ID_KEY, listItem.getId());
            Intent intent = new Intent(this, PersonDetailsActivity.class);
            intent.putExtras(bundle);
            startActivity(intent);
        }
    }
}
