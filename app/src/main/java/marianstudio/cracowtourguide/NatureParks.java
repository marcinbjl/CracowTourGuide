package marianstudio.cracowtourguide;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class NatureParks extends Fragment {

    public NatureParks() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.list_view, container, false);

        //String arrays with time info where position 1 is Sunday and 7 Saturday
        String[] plantyParkOpeningHours = getResources().getStringArray(R.array.planty_park_opening_hours);
        String[] zooOpeningHours = getResources().getStringArray(R.array.zoo_opening_hours);
        String[] jordanParkOpeningHours = getResources().getStringArray(R.array.jordan_park_opening_hours);
        String[] botanicGardenOpeningHours = getResources().getStringArray(R.array.botanic_garden_opening_hours);
        String[] lemGardenOpeningHours = getResources().getStringArray(R.array.lem_garden_opening_hours);

        // Create a list of words
        final ArrayList<Attraction> attractions = new ArrayList<Attraction>();

        attractions.add(new Attraction(R.drawable.planty_park, getString(R.string.planty_park_name), getString(R.string.planty_park_dscription), plantyParkOpeningHours));
        attractions.add(new Attraction(R.drawable.zoo, getString(R.string.zoo_name), getString(R.string.zoo_description), zooOpeningHours));
        attractions.add(new Attraction(R.drawable.jordan_park, getString(R.string.jordan_park_name), getString(R.string.jordan_park_description), jordanParkOpeningHours));
        attractions.add(new Attraction(R.drawable.botanic_garden, getString(R.string.botanic_garden_name), getString(R.string.botanic_garden_description), botanicGardenOpeningHours));
        attractions.add(new Attraction(R.drawable.zakrzowek_lake, getString(R.string.zakrzowek_lake_name), getString(R.string.zakrzowek_lake_description)));
        attractions.add(new Attraction(R.drawable.lem_garden, getString(R.string.lem_garden_name), getString(R.string.lem_garden_description), lemGardenOpeningHours));
        attractions.add(new Attraction(R.drawable.wolski_forest, getString(R.string.wolski_forest_name), getString(R.string.wolski_forest_description)));

        AttractionAdapter adapter = new AttractionAdapter(getActivity(), attractions);
        ListView listView = (ListView) rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);

        return rootView;
    }
}
