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
    private Map<Character, Set<Route>> adjacentMap;

    public TrainService() {
        adjacentMap = new HashMap<>();
    }

    /**
     * Init the data.
     * @param graph
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
     * Return the distance of given path.
     * @param path given path.
     * @return distance or error message.
     */
    public String getDistance(String path) {
        int res = calculateDistance(path);
        if (res < 0) return "NO SUCH ROUTE";
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
