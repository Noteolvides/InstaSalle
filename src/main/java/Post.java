import java.util.ArrayList;

public class Post {
    private float id;
    private Integer published;
    ArrayList< Float > location = new ArrayList < Float > ();
    private String category;

    public float getId() {
        return id;
    }

    public void setId(float id) {
        this.id = id;
    }

    public Integer getPublished() {
        return published;
    }

    public void setPublished(Integer published) {
        this.published = published;
    }

    public ArrayList<Float> getLocation() {
        return location;
    }

    public void setLocation(ArrayList<Float> location) {
        this.location = location;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public ArrayList<String> getLiked_by() {
        return liked_by;
    }

    public void setLiked_by(ArrayList<String> liked_by) {
        this.liked_by = liked_by;
    }

    public ArrayList<String> getCommented_by() {
        return commented_by;
    }

    public void setCommented_by(ArrayList<String> commented_by) {
        this.commented_by = commented_by;
    }

    ArrayList < String > liked_by = new ArrayList < String > ();
    ArrayList < String > commented_by = new ArrayList < String > ();
}
