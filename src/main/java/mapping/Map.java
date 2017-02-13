/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapping;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author hpollmann2
 */
public class Map {

    private final String HTML;

    private List<Marker> markers;
    private List<Polyline> polylines;

    public Map(List<Marker> markers) {
        this.markers = markers;
        StringBuilder mapMaker = new StringBuilder("<!DOCTYPE html/* global google */>\n");
        mapMaker.append("\n<html>\n" + "    <head>\n"
                + "<title>Park and Go Map</title>\n"
                + "<meta http-equiv=\"refresh\" content=\"10\">\n"
                + "        <style>\n"
                + "            #map {\n"
                + "                height: 100%;\n"
                + "                width: 100%;\n"
                + "            }\n"
                + "        </style>\n"
                + "    </head>\n"
                + "    <body>\n"
                + "        <h3>Park and Go</h3>\n"
                + "        <div id=\"map\"></div>\n"
                + "        <script>\n"
                + "            function initMap() {\n"
                + "                var uluru = {lat: 40.819142, lng: -96.69854};\n"
                + "                var map = new google.maps.Map(document.getElementById('map'), {\n"
                + "                    zoom: 18,\n"
                + "                    center: uluru,\n"
                + "                    mapTypeId: 'satellite'\n"
                + "                });\n");
        if (!markers.isEmpty()) {
            markers.stream().forEach((Marker marker) -> {
                mapMaker.append(marker.getHTML());
            });
        }
        mapMaker.append("            }\n"
                + "        </script>\n"
                + "        <script async defer\n"
                + "                src=\"https://maps.googleapis.com/maps/api/js?key=AIzaSyAi2cfRb2wZ3675skWK8cQ1Jq5ZqfLNMDE&callback=initMap\">\n"
                + "        </script>\n"
                + "    </body>\n"
                + "</html>");
        this.HTML = mapMaker.toString();
    }

    public List<Marker> getMarkers() {
        return markers;
    }

    public void setMarkers(List<Marker> markers) {
        this.markers = markers;
    }

    public List<Polyline> getPolylines() {
        return polylines;
    }

    public void setPolylines(List<Polyline> polylines) {
        this.polylines = polylines;
    }

    public void create() {
        try (FileWriter writer = (new FileWriter("map.html"))) {
            writer.append(this.HTML);
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
