package LLDPractise.TrafficSignal.Emergency;

import LLDPractise.TrafficSignal.TrafficController;

public class EmergencyHandler {

    public void detectEmergency(String roadId){
        System.out.println("Emergency detected at road : " + roadId);
        TrafficController.getInstance().handleEmergency(roadId);
    }
}
