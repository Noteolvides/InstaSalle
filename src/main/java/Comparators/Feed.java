package Comparators;

import JsonClasses.Post;
import JsonClasses.User;
import JsonClasses.UserConnections;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Feed implements Comparator<Post> {
    private List<UserConnections> connections;
    private User[] infomacionUsuarios;
    private List<Post> posts = new ArrayList<Post>();
    private float[] likelihood = new float[11];

    public void getInformation(){
        int a;
        int likes = 0;

        for (UserConnections i: connections) {
            a = Integer.parseInt(i.getUsername().replace("user",""));
            likes += i.getLikes();
            posts.addAll(infomacionUsuarios[a].getPosts());
        }

        for (Post i : posts) {
            if (i.getLiked_by().contains(infomacionUsuarios[0].getUsername())){
                likelihood[i.getCategory()] += 1.0;
            }
        }
        for (int i = 0; i < likelihood.length; i++) {
            likelihood[i] = (likelihood[i]*100)/likes;
        }
    }



    public Feed(List<UserConnections> connections,User[] infomacionUsuarios) {
        this.connections = connections;
        this.infomacionUsuarios = infomacionUsuarios;
    }

    public int compare(Post o1, Post o2) {
        return 0;
    }
}
