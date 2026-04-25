package LLDPractise.TrafficSignal.Signal.State;

import LLDPractise.TrafficSignal.TrafficSignal;

public class RedState implements SignalState{

    @Override
    public void next(TrafficSignal signal) {
        signal.setCurrentState(new GreenState());
    }

    @Override
    public String getStateName() {
        return "RED";
    }
}
