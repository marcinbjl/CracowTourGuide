package marianstudio.cracowtourguide;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class Nightlife extends Fragment {

    public Nightlife() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.list_view, container, false);

        //String arrays with time info where position 1 is Sunday and 7 Saturday
        String[] krawlCracowOpeningHours = getResources().getStringArray(R.array.krawl_cracow_opening_hours);
        String[] baccartOpeningHours = getResources().getStringArray(R.array.baccart_opening_hours);
        String[] baroqueOpeningHours = getResources().getStringArray(R.array.baroque_opening_hours);
        String[] zetpeteOpeningHours = getResources().getStringArray(R.array.zetpete_opening_hours);
        String[] drukarniaOpeningHours = getResources().getStringArray(R.array.drukarnia_opening_hours);
        String[] aferaOpeningHours = getResources().getStringArray(R.array.afera_opening_hours);

        // Create a list of words
        final ArrayList<Attraction> attractions = new ArrayList<Attraction>();

        attractions.add(new Attraction(R.drawable.krawl_cracow, getString(R.string.krawl_cracow_name), getString(R.string.krawl_cracow_description), krawlCracowOpeningHours));
        attractions.add(new Attraction(R.drawable.night_tram, getString(R.string.tram_party_name), getString(R.string.night_tram_description)));
        attractions.add(new Attraction(R.drawable.baccart_club, getString(R.string.baccart_name), getString(R.string.baccart_club_description), baccartOpeningHours));
        attractions.add(new Attraction(R.drawable.baroque, getString(R.string.baroque_name), getString(R.string.baroque_description), baroqueOpeningHours));
        attractions.add(new Attraction(R.drawable.zetpete, getString(R.string.zetpete_name), getString(R.string.zetpete_description), zetpeteOpeningHours));
        attractions.add(new Attraction(R.drawable.drukarnia, getString(R.string.drukarnia_name), getString(R.string.drukarnia_description), drukarniaOpeningHours));
        attractions.add(new Attraction(R.drawable.forty_kleparz, getString(R.string.forty_kleparz_name), getString(R.string.forty_kleparz_description)));
        attractions.add(new Attraction(R.drawable.afera_club, getString(R.string.afera_club_name), getString(R.string.afera_club_description), aferaOpeningHours));

        AttractionAdapter adapter = new AttractionAdapter(getActivity(), attractions);
        ListView listView = (ListView) rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);

        return rootView;
    }
}
