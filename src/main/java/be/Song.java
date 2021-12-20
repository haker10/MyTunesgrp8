package be;

public class Song {
    private String artist;
    private int id;
    private int time;
    private String title;
    private String category;

    public Song(int id, String s, String artist, String title, String category, int time){
        this.id = id;
        this.artist = artist;
        this.title = title;
        this.category = category;
        this.time = time;
    }
    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
