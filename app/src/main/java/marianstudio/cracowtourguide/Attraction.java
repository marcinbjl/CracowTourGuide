package marianstudio.cracowtourguide;

public class Attraction {

    private String mName;
    private String mDescription;
    private String[] mOpeningHours = null;
    private int mImageResourceId;

    public Attraction(int imageResourceId, String name, String description, String[] openingHours) {
        mName = name;
        mDescription = description;
        mOpeningHours = openingHours;
        mImageResourceId = imageResourceId;
    }

    public Attraction(int imageResourceId, String name, String description) {
        mName = name;
        mDescription = description;
        mImageResourceId = imageResourceId;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }

    public String getName() {
        return mName;
    }

    public String getDescription() {
        return mDescription;
    }

    public String[] getOpeningHours() {
        return mOpeningHours;
    }

    public boolean hasTimeInfo() {
        return mOpeningHours != null;
    }

}