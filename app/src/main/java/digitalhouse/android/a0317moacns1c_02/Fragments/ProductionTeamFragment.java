package digitalhouse.android.a0317moacns1c_02.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import digitalhouse.android.a0317moacns1c_02.Model.Credits.Crew;
import digitalhouse.android.a0317moacns1c_02.R;

public class ProductionTeamFragment extends Fragment {
    @BindView(R.id.textViewMDDirecting) TextView textViewDirecting;
    @BindView(R.id.textViewMDWriting) TextView textViewWriting;
    private Unbinder unbinder;

    public static final String CREW_LIST_KEY = "crewList";
    private List<Crew>  crewList;

    public ProductionTeamFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param crewList lista de productos y actores
     * @return A new instance of fragment ProductionTeamFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProductionTeamFragment newInstance(ArrayList<Crew> crewList) {
        ProductionTeamFragment fragment = new ProductionTeamFragment();
        Bundle args = new Bundle();
        args.putParcelableArrayList(CREW_LIST_KEY, crewList);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            crewList = getArguments().getParcelableArrayList(CREW_LIST_KEY);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_production_team, container, false);
        unbinder = ButterKnife.bind(this, view);
        String direction = "";
        String writing = "";
        for (Crew person : crewList) {
            switch (person.getDepartment()) {
                case "Directing":
                    direction += person.getName() + " (" + person.getJob() + ") \r\n";
                    break;
                case "Writing":
                    writing += person.getName() + " (" + person.getJob() + ") \r\n";
                    break;
            }
        }
        textViewDirecting.setText(direction);
        textViewWriting.setText(writing);
        return  view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
