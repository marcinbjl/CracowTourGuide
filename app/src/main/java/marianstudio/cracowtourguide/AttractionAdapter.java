package marianstudio.cracowtourguide;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;

public class AttractionAdapter extends ArrayAdapter<Attraction> {

    public AttractionAdapter(Context context, ArrayList<Attraction> attractions) {
        super(context, 0, attractions);
    }

    public String getTodaysOpeningHours(String[] attraction) {
        if (attraction.length == 1) {
            return attraction[0];

        } else {
            Calendar myDate = Calendar.getInstance();
            int dayOfWeek = myDate.get(Calendar.DAY_OF_WEEK);
            Log.v("Day", "day " + dayOfWeek);
            return attraction[dayOfWeek];
        }
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        ViewHolder holder = new ViewHolder();
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
            holder.nameTextView = (TextView) listItemView.findViewById(R.id.name);
            holder.descriptionTextView = (TextView) listItemView.findViewById(R.id.description);
            holder.timeTextView = (TextView) listItemView.findViewById(R.id.time);
            holder.timeInfoBar = (LinearLayout) listItemView.findViewById(R.id.time_info_bar);
            holder.clockIcon = (ImageView) listItemView.findViewById(R.id.clock_icon);
            holder.imageView = (ImageView) listItemView.findViewById(R.id.image);
            listItemView.setTag(holder);
        } else {
            holder = (ViewHolder) listItemView.getTag();
        }

        Attraction currentAttraction = getItem(position);

        holder.nameTextView.setText(currentAttraction.getName());
        holder.descriptionTextView.setText(currentAttraction.getDescription());

        if (currentAttraction.hasTimeInfo()) {
            holder.clockIcon.setImageResource(R.drawable.open);
            String timeInfo = getTodaysOpeningHours(currentAttraction.getOpeningHours());
            holder.timeTextView.setText(timeInfo);
            holder.timeInfoBar.setVisibility(View.VISIBLE);
        } else {
            holder.timeInfoBar.setVisibility(View.GONE);
        }
        holder.imageView.setImageResource(currentAttraction.getImageResourceId());

        return listItemView;
    }

    static class ViewHolder {
        TextView nameTextView;
        TextView descriptionTextView;
        TextView timeTextView;
        LinearLayout timeInfoBar;
        ImageView clockIcon;
        ImageView imageView;
    }
}