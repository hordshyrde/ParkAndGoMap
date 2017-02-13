/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapping;

/**
 *
 * @author hpollmann2
 */
public class Polyline {

    private final String line;

    Polyline() {
        this.line = "                var line = new google.maps.Polyline({\n"
                + "                    path: [\n"
                + "                        new google.maps.LatLng(40.8207920510018, -96.69815719127655),\n"
                + "                        new google.maps.LatLng(40.81695159072377, -96.69815719127655)\n"
                + "                    ],\n"
                + "                    strokeColor: \"#FF0000\",\n"
                + "                    strokeOpacity: 1.0,\n"
                + "                    strokeWeight: 5,\n"
                + "                    map: map\n"
                + "                });\n"
                + "            }\n";
    }

}
