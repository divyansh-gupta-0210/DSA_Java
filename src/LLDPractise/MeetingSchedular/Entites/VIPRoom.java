package LLDPractise.MeetingSchedular.Entites;

public class VIPRoom extends MeetingRoom{
    public VIPRoom(String id, int capacity){
        super(id, capacity);
    }

    @Override
    public boolean canBook(User user, int participants){
        return participants <= capacity;
    }
}
