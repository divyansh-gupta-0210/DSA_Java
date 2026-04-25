package LLDPractise.TrafficSignal.Intersection;

import LLDPractise.TrafficSignal.TrafficSignal;

public class Road {

    private String roadId;
    private TrafficSignal trafficSignal;

    public Road(String roadId, TrafficSignal trafficSignal){
        this.roadId = roadId;
        this.trafficSignal = trafficSignal;
    }

    public String getRoadId(){
        return roadId;
    }

    public TrafficSignal getTrafficSignal() {
        return trafficSignal;
    }
}
