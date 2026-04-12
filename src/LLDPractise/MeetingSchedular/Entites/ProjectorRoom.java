package LLDPractise.MeetingSchedular.Entites;

public class ProjectorRoom extends MeetingRoom{
    public ProjectorRoom(String id, int capacity){
        super(id, capacity);
    }

    @Override
    public boolean canBook(User user, int participants){
        return participants <= capacity;
    }
}
