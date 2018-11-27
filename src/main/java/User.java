import java.util.ArrayList;

public class User {
    private String username;
    private float followers;
    private float follows;
    ArrayList < UserConections > connections = new ArrayList < UserConections > ();
    ArrayList < Post > posts = new ArrayList < Post > ();
    ArrayList < Integer > likedPosts = new ArrayList < Integer > ();
    ArrayList < Integer > commentedPosts = new ArrayList< Integer >();

    public void setUsername(String username) {
        this.username = username;
    }

    public void setFollowers(float followers) {
        this.followers = followers;
    }

    public void setFollows(float follows) {
        this.follows = follows;
    }

    public ArrayList<UserConections> getConnections() {
        return connections;
    }

    public void setConnections(ArrayList<UserConections> connections) {
        this.connections = connections;
    }

    public ArrayList<Post> getPosts() {
        return posts;
    }

    public void setPosts(ArrayList<Post> posts) {
        this.posts = posts;
    }

    public ArrayList<Integer> getLikedPosts() {
        return likedPosts;
    }

    public void setLikedPosts(ArrayList<Integer> likedPosts) {
        this.likedPosts = likedPosts;
    }

    public ArrayList<Integer> getCommentedPosts() {
        return commentedPosts;
    }

    public void setCommentedPosts(ArrayList<Integer> commentedPosts) {
        this.commentedPosts = commentedPosts;
    }
}
