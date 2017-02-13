
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mapping.Map;
import mapping.Marker;
import textSearch.Address;
import textSearch.StreetExtractor;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author hpollmann2
 */
public class MapDemo {

    public static void main(String[] args) throws TwitterException, IOException, Exception {

        TwitterFactory tf = new TwitterFactory();
        Twitter twitter = tf.getInstance();
        boolean flag = true;
        // Ask the user for a search string.
        String searchStr = "ParkandGoUNL";

        // Create a Query object.
        Query query = new Query(searchStr);

        // Send API request to execute a search with the given query.
        QueryResult result = twitter.search(query);

        // Display search results.
        result.getTweets().stream().forEach((Status status) -> {
            System.out.println("\n" + status.getText() + status.getCreatedAt());
        });

        if (flag) {

            GeoApiContext context = new GeoApiContext().setApiKey("AIzaSyArz1NljiDpuOriFWalOerYEdHOyi8ow8Y");
            List<Marker> markers = new ArrayList<>();
            Marker e = new Marker(GeocodingApi.geocode(context,
                    "616 North 16th Street, Lincoln, Nebraska, USA").await()[0].geometry.location,
                    "marker1", "KKG", new Date());
            markers.add(e);

            StreetExtractor se = new StreetExtractor();
            List<Address> address = se.find("Park and Go 601 North 16th Street");
            address.forEach(((Address a) -> {

                try {
                    Marker m = new Marker(GeocodingApi.geocode(context,
                            a.getAddress()).await()[0].geometry.location,
                            "marker0", "A Tweet", new Date());
                    markers.add(m);
                } catch (Exception ex) {
                    Logger.getLogger(MapDemo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }));

            Map map = new Map(markers);
            map.create();
        }
    }
}
