package LLDPractise.MeetingSchedular.Entites;

public class TimeSlot {
    public long start;
    public long end;

    public TimeSlot(long start, long end){
        this.start = start;
        this.end = end;
    }

    public boolean overLaps(TimeSlot other){
        return !(this.end <= other.start || this.start >= other.end);
    }

}

