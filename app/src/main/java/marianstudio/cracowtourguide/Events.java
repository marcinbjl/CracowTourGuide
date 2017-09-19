package marianstudio.cracowtourguide;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class Events extends Fragment {

    public Events() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.list_view, container, false);

        //String arrays with time info where position 1 is Sunday and 7 Saturday
        String[] liveMusicFestivalTime = getResources().getStringArray(R.array.live_music_festival_time);
        String[] netiaOffCameraTime = getResources().getStringArray(R.array.netia_off_camera_time);
        String[] jewishFestivalTime = getResources().getStringArray(R.array.jewish_festival_time);
        String[] wiankiFestivalTime = getResources().getStringArray(R.array.wianki_festival_time);
        String[] seaSongFestivalTime = getResources().getStringArray(R.array.sea_song_festival_time);
        String[] soupFestivalTime = getResources().getStringArray(R.array.soup_festival_time);
        String[] streetTheatherFestivalTime = getResources().getStringArray(R.array.street_theather_time);
        String[] photomonthTime = getResources().getStringArray(R.array.photomonth_time);

        // Create a list of words
        final ArrayList<Attraction> attractions = new ArrayList<Attraction>();

        attractions.add(new Attraction(R.drawable.live_music_festival, getString(R.string.live_music_festival_name), getString(R.string.live_music_festival_description), liveMusicFestivalTime));
        attractions.add(new Attraction(R.drawable.netia_off_camera, getString(R.string.netia_off_camera_name), getString(R.string.netia_off_camera_description), netiaOffCameraTime));
        attractions.add(new Attraction(R.drawable.jewish_culture_festival, getString(R.string.jewish_festival_name), getString(R.string.jewish_festival_description), jewishFestivalTime));
        attractions.add(new Attraction(R.drawable.wianki_festival, getString(R.string.wianki_festival_name), getString(R.string.wianki_festival_description), wiankiFestivalTime));
        attractions.add(new Attraction(R.drawable.sea_song_festival, getString(R.string.sea_song_festival_name), getString(R.string.sea_song_festival_description), seaSongFestivalTime));
        attractions.add(new Attraction(R.drawable.soup_festival, getString(R.string.soup_festival_name), getString(R.string.soup_festival_description), soupFestivalTime));
        attractions.add(new Attraction(R.drawable.street_theather_festival, getString(R.string.street_theather_name), getString(R.string.street_theather_description), streetTheatherFestivalTime));
        attractions.add(new Attraction(R.drawable.photomonth, getString(R.string.photomonth_name), getString(R.string.photomonth_description), photomonthTime));

        AttractionAdapter adapter = new AttractionAdapter(getActivity(), attractions);
        ListView listView = (ListView) rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);

        return rootView;
    }
}
