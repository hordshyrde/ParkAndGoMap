
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.DayOfWeek;
import java.util.ArrayList;
import mapping.Marker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author hpollmann2
 */
public class DailyLogs {

    private static final Logger LOGGER = LoggerFactory.getLogger(DailyLogs.class);
    private static final Gson GSON = new Gson();

    public static ArrayList<Marker> getMarkerHistory(DayOfWeek day) {

        String filename = "MarkerHistory-" + day.toString() + ".json";
        ArrayList<Marker> markers = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            reader.lines().forEach((marker) -> {
                Marker m = GSON.fromJson(marker, Marker.class);
                markers.add(m);
            });

        } catch (FileNotFoundException ex) {
            LOGGER.warn(ex.getMessage());
        } catch (IOException ex) {
            LOGGER.warn(ex.getMessage());
        }

        LOGGER.debug("{} files loaded from {}'s log", markers.size(), day.toString());
        return markers;
    }

    public static void addMarkerToLog(Marker marker, DayOfWeek day) {

        String filename = "MarkerHistory-" + day.toString() + ".json";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            String json = GSON.toJson(marker);
            try {
                writer.append(json + "\n");
            } catch (IOException ex) {
                LOGGER.error(ex.toString());
            }
            writer.flush();
        } catch (IOException ex) {
            LOGGER.warn(ex.getMessage());
        }
    }
}


/*

new Handler().postDelayed(new Runnable() {
public void run () {
    // Do delayed stuff!
}
}, 5000L); //5 seconds delay 

*/
