package next.com.sampleapp;

public class Store {

    public static Store instance=null;

    public static Store getInstance() {
        if (instance == null) {
            instance = new Store();
        }
        return instance;
    }

    public static String BASE_URL="http://mynext.nexttechnosolutions.com/";

}
