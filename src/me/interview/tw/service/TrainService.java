package me.interview.tw.service;

import me.interview.tw.model.Route;

import java.util.*;

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
    private static final int DIS = 1;
    private Map<Character, Set<Route>> adjacentMap;

    public TrainService() {
        adjacentMap = new HashMap<>();
    }

    public void init(List<String> graph) {
        for (String s : graph) {
            char from = s.charAt(FROM);
            char to = s.charAt(TO);
            Integer dis = Integer.valueOf(s.substring(DIS));
            Route route = new Route(from, to, dis);
            adjacentMap.computeIfAbsent(from, (c -> new HashSet<>())).add(route);
        }
    }


}
