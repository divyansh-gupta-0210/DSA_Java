package LLDPractise.TrafficSignal;

import LLDPractise.TrafficSignal.Intersection.*;
import LLDPractise.TrafficSignal.Signal.State.*;
import LLDPractise.TrafficSignal.Strartegy.EmergencyTimingStrategy;

public class TrafficController {

    private static TrafficController instance;
    private Intersection intersection;

    public TrafficController(){}

    public static TrafficController getInstance(){
        if(instance == null){
            instance = new TrafficController();
        }
        return instance;
    }

    public void setIntersection(Intersection intersection){
        this.intersection = intersection;
    }

    public void startTrafficControl(){

//        while (true) {
//            for (Road road : intersection.getRoads()) {
//
//                TrafficSignal signal = road.getTrafficSignal();
//                signal.printCurrentState();
//                printIntersectionState();
//                try {
//                    Thread.sleep(signal.getDuration() * 10L);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//
//                signal.nextState();
//            }
//        }
        while (true) {
            for (Road activeRoad : intersection.getRoads()) {
                // Set active road to GREEN, others to RED
                for (Road road : intersection.getRoads()) {
                    if (road == activeRoad) {
                        road.getTrafficSignal().setCurrentState(new GreenState());
                    } else {
                        road.getTrafficSignal().setCurrentState(new RedState());
                    }
                }
                printIntersectionState();
                try {
                    Thread.sleep(activeRoad.getTrafficSignal().getDuration() * 10L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                // Set active road to YELLOW
                activeRoad.getTrafficSignal().setCurrentState(new YellowState());
                printIntersectionState();
                try {
                    Thread.sleep(activeRoad.getTrafficSignal().getDuration() * 10L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void printIntersectionState() {
        System.out.println("===== Intersection Status =====");
        for (Road road : intersection.getRoads()) {
            System.out.println(road.getRoadId() +" -> " + road.getTrafficSignal().getCurrentState().getStateName());
        }
    }

    public void handleEmergency(String roadId){
        for(Road road : intersection.getRoads()){
            if(road.getRoadId().equals(roadId)){
                road.getTrafficSignal().setTimingStrategy(new EmergencyTimingStrategy());
                road.getTrafficSignal().setCurrentState(new GreenState());
            }
        }
    }

}
