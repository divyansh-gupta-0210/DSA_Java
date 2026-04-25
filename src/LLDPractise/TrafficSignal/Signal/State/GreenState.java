package LLDPractise.TrafficSignal.Signal.State;

import LLDPractise.TrafficSignal.TrafficSignal;

public class GreenState implements SignalState{
    @Override
    public void next(TrafficSignal signal) {
        signal.setCurrentState(new YellowState());
    }

    @Override
    public String getStateName() {
        return "GREEN";
    }
}
