package LLDPractise.TrafficSignal;

import LLDPractise.TrafficSignal.Signal.State.RedState;
import LLDPractise.TrafficSignal.Signal.State.SignalState;
import LLDPractise.TrafficSignal.Strartegy.TimingStrategy;

public class TrafficSignal {
    private SignalState currentState;
    private TimingStrategy timingStrategy;

    public TrafficSignal(TimingStrategy timingStrategy){
        this.currentState = new RedState();
        this.timingStrategy = timingStrategy;
    }

    public void nextState(){
        currentState.next(this);
    }

    public void printCurrentState(){
        System.out.println("Signal State: " + currentState.getStateName());
    }

    public int getDuration(){
        return timingStrategy.getDuration(currentState.getStateName());
    }

    public void setCurrentState(SignalState currentState){
        this.currentState = currentState;
    }

    public SignalState getCurrentState(){
        return currentState;
    }

    public void setTimingStrategy(TimingStrategy timingStrategy){
        this.timingStrategy = timingStrategy;
    }

}
