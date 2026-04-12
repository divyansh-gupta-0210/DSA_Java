package LLDPractise.MeetingSchedular.Strategy;

import LLDPractise.MeetingSchedular.Entites.Meeting;
import LLDPractise.MeetingSchedular.Entites.User;

public interface IPreemptionPolicy {
    boolean canPreempt(User requester, Meeting existingMeeting);
}
