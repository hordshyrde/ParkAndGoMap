
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.model.LatLng;
import java.sql.Time;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import mapping.Map;
import mapping.Marker;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import textSearch.Address;
import textSearch.StreetExtractor;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author hpollmann2
 */
public class TweetMapManager {

    private static final Logger LOGGER = LoggerFactory.getLogger(TweetMapManager.class);
    private static final LocalTime STARTTIME = LocalTime.of(8, 0);
    private static final LocalTime ENDTIME = LocalTime.of(18, 0);
    private static final int WEEKEND = DayOfWeek.SATURDAY.getValue();
    private static final LocalTime DURATION = LocalTime.of(0, 30);

    public static void main(String[] args) {
        

        TwitterFactory tf = new TwitterFactory();
        Twitter twitter = tf.getInstance();
        String searchStr = "#ParkandGoUNL";
        Query query = new Query(searchStr);

        GeoApiContext context = new GeoApiContext().setApiKey("AIzaSyArz1NljiDpuOriFWalOerYEdHOyi8ow8Y");
        List<Marker> markers = new LinkedList<>();
        StreetExtractor se = new StreetExtractor();
        LocalTime now = LocalTime.now();

        while (true) {
            DayOfWeek today = LocalDate.now().getDayOfWeek();
            if (today.getValue() < WEEKEND) {
                if (now.isAfter(STARTTIME) && now.isBefore(ENDTIME)) {

                    // Send API request to execute a search with the given query.
                    QueryResult results = null;
                    try {
                        results = twitter.search(query);
                    } catch (TwitterException ex) {
                        LOGGER.warn(ex.getMessage());
                    }

                    // Display search results.
                    if (results != null) {
                        results.getTweets().stream().forEach((Status status) -> {
                            try {

                                Date created = status.getCreatedAt();
                                String text = status.getText();
                                LOGGER.info(status.getText());
                                LatLng location;
                                if (status.getGeoLocation() != null) {
                                    location = new LatLng(status.getGeoLocation().getLatitude(),
                                            status.getGeoLocation().getLongitude());
                                } else {
                                    String modified = text.replace("#ParkAndGoUNL", "");
                                    List<Address> address = se.find(modified);
                                    
                                    location = GeocodingApi.geocode(context,
                                            address.get(0).getAddress()).await()[0].geometry.location;
                                }
                                String id = UUID.randomUUID().toString().substring(0, 8);
                                Marker m = new Marker(location, "m" + id, text, created);
                                markers.add(m);
                            } catch (Exception ex) {
                                LOGGER.warn(ex.getMessage());
                            }

                        });
                    }
                    if (!markers.isEmpty()) {
                        Marker m = markers.get(markers.size() - 1);

                        if (m.getTimestamp().getTime() < Time.valueOf(now.minusMinutes(30)).getTime()) {
                            DailyLogs.addMarkerToLog(m, today);
                            markers.remove(m);
                        }
                    }
                    Map map = new Map(markers);
                    map.create();
                } else {
                    //wait 5 hours
                    try {
                        LOGGER.info("Sleeping 5 hours");
                        Thread.sleep((long) 1.8e+7);
                    } catch (InterruptedException ex) {
                        LOGGER.warn(ex.getMessage());
                    }
                }

                now = LocalTime.now();
            } else {
                try {
                    //Wait a day
                    LOGGER.info("Sleeping 1 day");
                    Thread.sleep((long) 8.64e+7);
                } catch (InterruptedException ex) {
                    LOGGER.warn(ex.getMessage());
                }
            }
            try {
                LOGGER.info("Successful Loop, Resting");
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                LOGGER.warn(ex.getMessage());
            }
        }
    }
}
