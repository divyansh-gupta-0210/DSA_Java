package LLDPractise.MeetingSchedular.Entites;

public class NormalRoom extends MeetingRoom{
    public NormalRoom(String id, int capacity){
        super(id, capacity);
    }

    @Override
    public boolean canBook(User user, int participants){
        return participants <= capacity;
    }
}
