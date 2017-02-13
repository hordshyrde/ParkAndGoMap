/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapping;

import com.google.maps.model.LatLng;
import java.util.Date;

/**
 *
 * @author hpollmann2
 */
public class Marker {

    private LatLng pin;
    private final String position;
    private final String name;
    private final String HTML;
    private final String tweet;
    private final Date timestamp;

    public Marker(LatLng pin, String name, String tweet, Date timestamp) {
        this.tweet = tweet;
        this.name = name;
        this.pin = pin;
        this.timestamp = timestamp;
        this.position = "{lat: " + pin.lat + ", lng: " + pin.lng + "}";
        this.HTML = "                var " + name + " = new google.maps.Marker({\n"
                + "                    position: " + position + ",\n"
                + "                    map: map,\n"
                + "                    title: \"" + tweet + " @" + timestamp.toString() + "\"\n"
                + "                });\n";
    }

    public LatLng getPin() {
        return pin;
    }

    public String getPosition() {
        return position;
    }

    public String getHTML() {
        return HTML;
    }

    public void setPin(LatLng pin) {
        this.pin = pin;
    }

    public String getName() {
        return name;
    }

    public String getTweet() {
        return tweet;
    }

    public Date getTimestamp() {
        return timestamp;
    }
    
    

}
