/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hpollmann2
 */
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.model.GeocodingResult;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import twitter4j.*;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;

/**
 * Twitter API Example. Demonstrates interaction with the Twitter API using the
 * twitter4j library.
 */
public class Demo {

    /**
     * Main method.
     *
     * @param args
     * @throws TwitterException
     */
    public static void main(String[] args) throws TwitterException, IOException {

        // The TwitterFactory object provides an instance of a Twitter object
        // via the getInstance() method. The Twitter object is the API consumer.
        // It has the methods for interacting with the Twitter API.
        TwitterFactory tf = new TwitterFactory();
        Twitter twitter = tf.getInstance();

        boolean keepItGoinFullSteam = true;
        do {
            // Main menu
            Scanner input = new Scanner(System.in);
            System.out.print("\n--------------------"
                    + "\nH. Home Timeline\nS. Search\nT. Tweet"
                    + "\n--------------------"
                    + "\nA. Get Access Token\nQ. Quit"
                    + "\n--------------------\n> ");
            String choice = input.nextLine();

            try {

                // Home Timeline
                if (choice.equalsIgnoreCase("H")) {

                    // Display the user's screen name.
                    User user = twitter.verifyCredentials();
                    System.out.println("\n@" + user.getScreenName() + "'s timeline:");

                    // Display recent tweets from the Home Timeline.
                    for (Status status : twitter.getHomeTimeline()) {
                        System.out.println("\n@" + status.getUser().getScreenName()
                                + ": " + status.getText());
                    }

                } // Search
                else if (choice.equalsIgnoreCase("S")) {

                    // Ask the user for a search string.
                    System.out.print("\nSearch: ");
                    String searchStr = input.nextLine();

                    // Create a Query object.
                    Query query = new Query(searchStr);

                    // Send API request to execute a search with the given query.
                    QueryResult result = twitter.search(query);

                    // Display search results.
                    result.getTweets().stream().forEach((Status status) -> {
                        System.out.println("\n@" + status.getUser().getName() + ": "
                                + status.getText());
                    });

                } // Tweet
                else if (choice.equalsIgnoreCase("T")) {

                    boolean isOkayLength = true;
                    String tweet;
                    do {
                        // Ask the user for a tweet.
                        System.out.print("\nTweet: ");
                        tweet = input.nextLine();

                        // Ensure the tweet length is okay.
                        if (tweet.length() > 140) {
                            System.out.println("Too long! Keep it under 140.");
                            isOkayLength = false;
                        }
                    } while (isOkayLength == false);

                    // Send API request to create a new tweet.
                    Status status = twitter.updateStatus(tweet);
                    System.out.println("Just tweeted: \"" + status.getText() + "\"");

                } // Get Access Token
                else if (choice.equalsIgnoreCase("A")) {

                    // First, we ask Twitter for a request token.
                    RequestToken reqToken = twitter.getOAuthRequestToken();
                    System.out.println("\nRequest token: " + reqToken.getToken()
                            + "\nRequest token secret: " + reqToken.getTokenSecret());

                    AccessToken accessToken = null;
                    while (accessToken == null) {

                        // The authorization URL sends the request token to Twitter in order
                        // to request an access token. At this point, Twitter asks the user
                        // to authorize the request. If the user authorizes, then Twitter
                        // provides a PIN.
                        System.out.print("\nOpen this URL in a browser: "
                                + "\n    " + reqToken.getAuthorizationURL() + "\n"
                                + "\nAuthorize the app, then enter the PIN here: ");
                        String pin = input.nextLine();
                        try {
                            // We use the provided PIN to get the access token. The access
                            // token allows this app to access the user's account without
                            // knowing his/her password.
                            accessToken = twitter.getOAuthAccessToken(reqToken, pin);
                        } catch (TwitterException te) {
                            System.out.println(te.getMessage());
                        }
                    }
                    System.out.println("\nAccess token: " + accessToken.getToken()
                            + "\nAccess token secret: " + accessToken.getTokenSecret()
                            + "\nSuccess!");

                } // Quit
                else if (choice.equalsIgnoreCase("Q")) {

                    keepItGoinFullSteam = false;
                    GeoApiContext context = new GeoApiContext().setApiKey("AIzaSyArz1NljiDpuOriFWalOerYEdHOyi8ow8Y");

                    System.out.println(GeocodingApi.geocode(context,
                            "Sigma Phi Epsilon, Lincoln, Nebraska, USA").await()[0].geometry.location.toString());
                    System.out.println(GeocodingApi.geocode(context,
                            "16th and R, Lincoln, Nebraska, USA").await()[0].geometry.location.toString());
                    File htmlFile = new File("map.html");
                    Desktop.getDesktop().browse(htmlFile.toURI());
                } // Bad choice
                else {

                    System.out.println("Invalid option.");
                }

            } catch (IllegalStateException ex) {
                System.out.println(ex.getMessage());
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }

        } while (keepItGoinFullSteam == true);
    }
}
