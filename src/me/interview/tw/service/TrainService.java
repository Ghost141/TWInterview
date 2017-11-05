package me.interview.tw.service;

import me.interview.tw.model.Route;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Train service.
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 11/5/17
 */
public class TrainService {
    private static final int FROM = 0;
    private static final int TO = 1;
    private static final int DIS = 2;
    private static final String NO_SUCH_ROUTE = "NO SUCH ROUTE";

    private Map<Character, Set<Route>> adjacentMap;

    public TrainService() {
        adjacentMap = new HashMap<>();
    }

    /**
     * Init the data.
     * @param graph adjacent table of graph.
     */
    public void init(List<String> graph) {
        for (String s : graph) {
            char from = s.charAt(FROM);
            char to = s.charAt(TO);
            Integer dis = Integer.valueOf(s.substring(DIS));
            Route route = new Route(from, to, dis);
            adjacentMap.computeIfAbsent(from, (c -> new HashSet<>())).add(route);
        }
    }

    /**
     * Number of trips between given start location and end location with maximum number stops.
     * @param start start location.
     * @param end end location.
     * @param maximumStops max stops we can make.
     * @return number of trips or an error message.
     */
    public String numberOfTripsWithMaxStops(Character start, Character end, int maximumStops) {
        return "";
    }

    /**
     * Number of trips between given start location and end location with stops we have to make.
     * @param start start location.
     * @param end end location.
     * @param stops stops we should make.
     * @return number of trips or an error message.
     */
    public String numberOfTripsWithExactStops(Character start, Character end, int stops) {
        return "";
    }

    /**
     * Shortest distance between given location.
     * @param start start location.
     * @param end end location.
     * @return distance of an error message.
     */
    public String shortestRouteBetweenPath(Character start, Character end) {
        return "";
    }

    /**
     * Number of different routes between given location with a distance less than given limit.
     * @param start start location.
     * @param end end location
     * @param maxDistance max distance along the route.
     * @return number of routes or an error message.
     */
    public String numberOfDifferentRoutesLessThanDistance(Character start, Character end, int maxDistance) {
        return "";
    }

    /**
     * Return the distance of given path.
     * @param path given path.
     * @return distance or error message.
     */
    public String getDistance(String path) {
        int res = calculateDistance(path);
        if (res < 0) return NO_SUCH_ROUTE;
        else return String.valueOf(res);
    }

    /**
     * Calculate the given path.
     * @param path given path.
     * @return distance. -1 indicates there is no such route.
     */
    private int calculateDistance(String path) {
        int res = 0;
        String[] routeList = path.split("-");
        for (int i = 0; i < routeList.length - 1; i++) {
            char from = routeList[i].charAt(0);
            char to = routeList[i + 1].charAt(0);
            Set<Route> neighbors = adjacentMap.get(from);
            if (!neighbors.stream().map(Route::getDestination).collect(Collectors.toSet()).contains(to)) return -1;
            for (Route route : neighbors) {
                if (route.getDestination().equals(to)) {
                    res += route.getDistance();
                    break;
                }
            }
        }
        return res;
    }
}
