package me.interview.tw.model;

/**
 * Route class. It will store the from station, destination and distance between these two stations.
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 11/5/17
 */
public class Route {
    private Character from;
    private Character destination;
    private int distance;

    public Route(Character from, Character destination, int distance) {
        this.from = from;
        this.destination = destination;
        this.distance = distance;
    }

    public Character getFrom() {
        return from;
    }

    public void setFrom(Character from) {
        this.from = from;
    }

    public Character getDestination() {
        return destination;
    }

    public void setDestination(Character destination) {
        this.destination = destination;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
}
