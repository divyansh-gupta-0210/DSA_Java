package LLDPractise.TrafficSignal.Signal.State;

import LLDPractise.TrafficSignal.TrafficSignal;

public interface SignalState {

    void next(TrafficSignal signal);
    String getStateName();

}
