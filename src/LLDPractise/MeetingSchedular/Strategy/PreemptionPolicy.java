package LLDPractise.MeetingSchedular.Strategy;

import LLDPractise.MeetingSchedular.Entites.Meeting;
import LLDPractise.MeetingSchedular.Entites.User;

public class PreemptionPolicy implements IPreemptionPolicy {
    @Override
    public boolean canPreempt(User requester, Meeting existingMeeting) {
        return requester.getRolePriority() > existingMeeting.getPriority();
    }

}
