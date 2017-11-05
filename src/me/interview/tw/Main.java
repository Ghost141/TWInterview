package me.interview.tw;

import me.interview.tw.service.TrainService;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        TrainService service = new TrainService();
        ArrayList<String> graph = new ArrayList<>();
        graph.add("AB5");
        graph.add("BC4");
        graph.add("CD8");
        graph.add("DC8");
        graph.add("DE6");
        graph.add("AD5");
        graph.add("CE2");
        graph.add("EB3");
        graph.add("AE7");
        service.init(graph);
    }
}
