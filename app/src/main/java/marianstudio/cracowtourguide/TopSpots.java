package marianstudio.cracowtourguide;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class TopSpots extends Fragment {

    public TopSpots() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.list_view, container, false);

        //String arrays with time info where position 1 is Sunday and 7 Saturday
        String[] wawelCastleOpeningHours = getResources().getStringArray(R.array.wawel_castle_opening_hours);
        String[] clothHallOpeningHours = getResources().getStringArray(R.array.cloth_hall_opening_hours);
        String[] wawelCathedralOpeningHours = getResources().getStringArray(R.array.wawel_cathedral_opening_hours);
        String[] barbicanOpeningHours = getResources().getStringArray(R.array.barbican_opening_hours);
        String[] marysBasilicaOpeningHours = getResources().getStringArray(R.array.marys_basilica_opening_hours);
        String[] wieliczkaOpeningHours = getResources().getStringArray(R.array.wieliczka_opening_hours);
        String[] rynekUndergroundOpeningHours = getResources().getStringArray(R.array.rynek_underground_opening_hours);
        String[] aviationMuseumOpeningHours = getResources().getStringArray(R.array.aviation_museum_opening_haours);

        // Create a list of words
        final ArrayList<Attraction> attractions = new ArrayList<Attraction>();

        attractions.add(new Attraction(R.drawable.wawel_castle, getString(R.string.wawel_castle_name), getString(R.string.wawel_castle_description), wawelCastleOpeningHours));
        attractions.add(new Attraction(R.drawable.main_square, getString(R.string.main_square_name), getString(R.string.main_square_description)));
        attractions.add(new Attraction(R.drawable.cloth_hall, getString(R.string.cloth_hall_name), getString(R.string.cloth_hall_description), clothHallOpeningHours));
        attractions.add(new Attraction(R.drawable.wawel_cathedral, getString(R.string.wawel_cathedral_name), getString(R.string.wawel_cathedral_description), wawelCathedralOpeningHours));
        attractions.add(new Attraction(R.drawable.barbican, getString(R.string.barbican_name), getString(R.string.barbican_description), barbicanOpeningHours));
        attractions.add(new Attraction(R.drawable.marys_basilica, getString(R.string.st_marys_basilica_name), getString(R.string.marys_basilica_description), marysBasilicaOpeningHours));
        attractions.add(new Attraction(R.drawable.wieliczka, getString(R.string.wieliczka_name), getString(R.string.wieliczka_description), wieliczkaOpeningHours));
        attractions.add(new Attraction(R.drawable.rynek_underground, getString(R.string.rynek_underground_name), getString(R.string.rynek_underground_description), rynekUndergroundOpeningHours));
        attractions.add(new Attraction(R.drawable.aviation_museum, getString(R.string.aviation_museum_name), getString(R.string.aviation_museum_description), aviationMuseumOpeningHours));
        attractions.add(new Attraction(R.drawable.jewish_district, getString(R.string.jewish_district_name), getString(R.string.jewish_district_description)));

        AttractionAdapter adapter = new AttractionAdapter(getActivity(), attractions);
        ListView listView = (ListView) rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);

        return rootView;
    }
}
