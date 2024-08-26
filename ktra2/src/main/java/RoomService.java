import java.util.ArrayList;

public class RoomService {
    ArrayList<Room> rooms = new ArrayList<>();

    public RoomService() {
        rooms.add(new Room("2", "Thường", "1", true));
        rooms.add(new Room("1", "VIP", "2", false));
    }

    public ArrayList<Room> getAll() {
        return rooms;
    }

    public void add(Room room) {
        rooms.add(room);
    }
}
