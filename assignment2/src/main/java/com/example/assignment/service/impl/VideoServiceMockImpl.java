package com.example.assignment.service.impl;

import com.example.assignment.entity.Favorite;
import com.example.assignment.entity.Video;
import com.example.assignment.service.VideoService;

import java.util.ArrayList;
import java.util.List;

public class VideoServiceMockImpl implements VideoService {
    List<Video> movieList = new ArrayList<Video>() {{
        add(new Video("t52kogxS5Uk", "Bắp ngô trái cây ngon ngọt, ăn luôn mà không cần luộc"));
        add(new Video("ZbXoAHaoy5c", "Kỹ sư thiết kế vi mạch Việt Nam vươn tầm quốc tế"));
        add(new Video("1b2I6VmRqtw", "Tranh cãi về xu thế làm việc từ xa sau đại dịch"));
    }};

    @Override
    public Video findVideo(String id) {
        for (Video m : movieList) {
            if (m.getId().equals(id)) return m;
        }
        return null;
    }

    @Override
    public void add(Video v) {
        if (v.getId().isEmpty()) {
            throw new RuntimeException("Id cannot be blank");
        }
        if (findVideo(v.getId()) != null) {
            throw new RuntimeException("Movie with id '" + v.getId() + "' already exists");
        }
        movieList.add(v);
    }

    @Override
    public void update(Video v) {
        if (findVideo(v.getId()) == null) {
            throw new RuntimeException("Movie with id '" + v.getId() + "' does not exist");
        }
        for (int i = 0; i < movieList.size(); i++) {
            if (movieList.get(i).getId().equals(v.getId())) {
                movieList.set(i, v);
            }
        }
    }

    @Override
    public void delete(String id) {
        int index = -1;
        for (int i = 0; i < movieList.size(); i++) {
            if (movieList.get(i).getId().equals(id)) {
                index = i;
                break;
            }
        }
        if (index >= 0) movieList.remove(index);
    }

    @Override
    public ArrayList<Video> getAll() {
        return (ArrayList<Video>) movieList;
    }

    @Override
    public ArrayList<Video> search(String keyword) {
        List<Video> items = new ArrayList<>();
        for (Video v : movieList) {
            if (v.getTitle() == null) continue;
            if (v.getTitle().toLowerCase().contains(keyword.toLowerCase())) {
                items.add(v);
            }
        }
        return (ArrayList<Video>) items;
    }

    @Override
    public ArrayList<Video> searchFavorite(String userId, String keyword) {
        ArrayList<Video> items = new ArrayList<>();
        for (Video m : movieList) {
            if (m.getTitle() == null) continue;
            if (m.getTitle().toLowerCase().contains(keyword.toLowerCase())) {
                items.add(m);
            }
        }
        return items;
    }

    @Override
    public ArrayList<Video> listFavorite(String userId) {
        return null;
    }

    @Override
    public String getIDByEmail(String email) {
        return null;
    }

    @Override
    public void addListLike(String id, String username) {

    }

    @Override
    public void deleteListLike(String idVideo, String username) {

    }

    @Override
    public ArrayList<Favorite> listLike(String id) {
        return null;
    }
}
