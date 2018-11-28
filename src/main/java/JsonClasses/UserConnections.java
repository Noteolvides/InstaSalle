package JsonClasses;

public class UserConnections {
    private String username;
    private Integer since;
    private Integer visits;
    private Integer likes;
    private Integer comments;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getSince() {
        return since;
    }

    public void setSince(Integer since) {
        this.since = since;
    }

    public Integer getVisits() {
        return visits;
    }

    public void setVisits(Integer visits) {
        this.visits = visits;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setComments(Integer comments) {
        this.comments = comments;
    }

    public Integer getComments() {
        return comments;
    }

}
