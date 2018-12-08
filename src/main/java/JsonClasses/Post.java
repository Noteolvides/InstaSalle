package JsonClasses;


import java.util.List;

public class Post{
    private Integer id;
    private Integer published;
    private List<Double> location;
    private String category;
    private List<String> liked_by;
    private List<String> commented_by;
    private Integer newPublised;


    public Integer getNewPublised() {
        return newPublised;
    }

    public void setNewPublised(Integer newPublised) {
        this.newPublised = newPublised;
    }
    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    private String creator;

    public Post() {
    }

    @Override
    public String toString() {
        return "\nPost{" +
                "id=" + id +
                ", published=" + published +
                ", location=" + location +
                ", category='" + category + '\'' +
                ", liked_by=" + liked_by +
                ", commented_by=" + commented_by +
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

    public int getCategory() {
        if (category.equals("landscape")){
            return 0;
        }else if(category.equals("food")){
            return 1;
        }else if(category.equals("sports")){
            return 2;
        }else if(category.equals("style")){
            return 3;
        }else if(category.equals("animals")){
            return 4;
        }else if(category.equals("tv_shows")){
            return 5;
        }else if(category.equals("science_tech")){
            return 6;
        }else if(category.equals("music")){
            return 7;
        }else if(category.equals("travel")){
            return 8;
        }else if(category.equals("architecture")){
            return 9;
        }else if(category.equals("fitness")){
            return 10;
        }
        return 0;
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
