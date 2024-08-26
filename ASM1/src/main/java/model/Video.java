package model;

public class Video {
    private String Id;
    private String Title;
    private String Description;
    private Boolean Active;
    private String Poster;

    public Video() {
    }

    public Video(String id, String title, String description, Boolean active, String poster) {
        Id = id;
        Title = title;
        Description = description;
        Active = active;
        Poster = poster;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Boolean getActive() {
        return Active;
    }

    public void setActive(Boolean active) {
        Active = active;
    }

    public String getPoster() {
        return Poster;
    }

    public void setPoster(String poster) {
        Poster = poster;
    }
}
