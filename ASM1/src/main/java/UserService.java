import model.User;

import java.util.ArrayList;
import java.util.Arrays;

public class UserService {
    ArrayList<User> listUser = new ArrayList<>();

    public UserService() {
        listUser.add(new User("nva", "123", "nva@gmail.com", "Nguyễn Văn A", true));
        listUser.add(new User("nvb", "456", "nvb@gmail.com", "Nguyễn Văn B", false));
    }
    public ArrayList<User> getAll() {
        return listUser;
    }
    public User findID(String id){
        for (int i = 0; i < listUser.size(); i++) {
            if (listUser.get(i).getId().equalsIgnoreCase(id)){
                return listUser.get(i);
            }
        }
        return null;
    }
    public void add(User user){
        listUser.add(user);
    }
    public void update(User user){
        for (User u:listUser) {
            if (u.getId().equalsIgnoreCase(user.getId())){
                listUser.set(listUser.indexOf(u),user);
            }
        }
    }
    public void delete(String id){
        for (int i = 0; i < listUser.size(); i++) {
            if (listUser.get(i).getId().equalsIgnoreCase(id)){
                listUser.remove(i);
            }
        }
        System.out.println(listUser);
    }
}

//  for (int i = 0; i < listUser.size(); i++) {
//            User user1 = listUser.get(i);
//            if (user1.getId().equals(user.getId())) {
//                // Cập nhật các trường cần thiết
//                user1.setEmail(user.getEmail());
//                user1.setFullname(user.getFullname());
//                user1.setAdmin(user.isAdmin());
//
//                // Các trường khác vẫn giữ nguyên
//
//                listUser.set(i, user1);
//                System.out.println("Cập nhật thành công user: " + user1);
//                break;
//            }
//        }