package LLDPractise.TrafficSignal;

import LLDPractise.TrafficSignal.Emergency.EmergencyHandler;
import LLDPractise.TrafficSignal.Intersection.Intersection;
import LLDPractise.TrafficSignal.Intersection.Road;
import LLDPractise.TrafficSignal.Strartegy.NormalTimingStrategy;

public class TrafficSignalMain {
    public static void main(String[] args) {

        TrafficSignal signal1 = new TrafficSignal(new NormalTimingStrategy());
        TrafficSignal signal2 = new TrafficSignal(new NormalTimingStrategy());
        TrafficSignal signal3 = new TrafficSignal(new NormalTimingStrategy());
        TrafficSignal signal4 = new TrafficSignal(new NormalTimingStrategy());

        Road road1 = new Road("Road-A", signal1);
        Road road2 = new Road("Road-B", signal2);
        Road road3 = new Road("Road-C", signal1);
        Road road4 = new Road("Road-D", signal2);

        Intersection intersection = new Intersection();
        intersection.addRoad(road1);
        intersection.addRoad(road2);
        intersection.addRoad(road3);
        intersection.addRoad(road4);

        TrafficController controller = TrafficController.getInstance();
        controller.setIntersection(intersection);

//        EmergencyHandler emergencyHandler = new EmergencyHandler();
//        new Thread(() -> {
//            try{
//                Thread.sleep(15000);
//                emergencyHandler.detectEmergency("Road-A");
//            }
//            catch (InterruptedException ex){
//                ex.printStackTrace();
//            }
//        }).start();

        controller.startTrafficControl();
    }

}
