package LLDPractise.TrafficSignal.Signal.State;

import LLDPractise.TrafficSignal.TrafficSignal;

public class YellowState implements SignalState{
    @Override
    public void next(TrafficSignal signal) {
        signal.setCurrentState(new RedState());
    }

    @Override
    public String getStateName() {
        return "YELLOW";
    }
}
