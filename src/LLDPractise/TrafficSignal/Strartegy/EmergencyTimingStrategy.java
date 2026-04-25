package LLDPractise.TrafficSignal.Strartegy;

public class EmergencyTimingStrategy implements TimingStrategy{

    @Override
    public int getDuration(String getName){
        if("GREEN".equals(getName)){
            return 60;
        }
        return 5;
    }

}
