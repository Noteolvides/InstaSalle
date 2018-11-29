package JsonClasses;


import java.util.List;

public class Post{
    private Integer id;
    private Integer published;
    private List<Double> location;
    private String category;
    private List<String> liked_by;
    private List<String> commented_by;

    @Override
    public String toString() {
        return "\n\tPost{" +
                "\n\t\tid=" + id +
                "\n\t\t\t, published=" + published +
                "\n\t\t\t, location=" + location +
                "\n\t\t\t, category='" + category + '\'' +
                "\n\t\t\t, liked_by=" + liked_by +
                "\n\t\t\t, commented_by=" + commented_by +
                '}';
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPublished() {
        return published;
    }

    public void setPublished(Integer published) {
        this.published = published;
    }

    public List<Double> getLocation() {
        return location;
    }

    public void setLocation(List<Double> location) {
        this.location = location;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<String> getLiked_by() {
        return liked_by;
    }

    public void setLiked_by(List<String> liked_by) {
        this.liked_by = liked_by;
    }

    public List<String> getCommented_by() {
        return commented_by;
    }

    public void setCommented_by(List<String> commented_by) {
        this.commented_by = commented_by;
    }

}
