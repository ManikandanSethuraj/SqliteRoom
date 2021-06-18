package app.manny.sqliteroom.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utility {

    private static final String TAG = "Utility";

    public static String getCurrentTimeStamp(){
        try {

            SimpleDateFormat dateFormat = new SimpleDateFormat("MMM-yyyy"); //MUST USE LOWERCASE 'y'. API 23- can't use uppercase
            String currentDateTime = dateFormat.format(new Date()); // Find todays date

            return currentDateTime;
        } catch (Exception e) {
            e.printStackTrace();

            return null;
        }
    }
}
