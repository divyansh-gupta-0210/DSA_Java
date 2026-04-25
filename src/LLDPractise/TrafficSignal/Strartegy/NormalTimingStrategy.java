package LLDPractise.TrafficSignal.Strartegy;

public class NormalTimingStrategy implements TimingStrategy{

    @Override
    public int getDuration(String signalState) {
        switch (signalState) {
            case "GREEN":
                return 300;
            case "YELLOW":
                return 350;
            case "RED":
                return 300;
            default:
                return 10;
        }
    }
}
