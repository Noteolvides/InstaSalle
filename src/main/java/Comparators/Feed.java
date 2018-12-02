package Comparators;

import JsonClasses.Post;
import JsonClasses.User;
import JsonClasses.UserConnections;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Feed implements Comparator<Post> {
    private class informationOfLlikeness{
        public informationOfLlikeness(String name, float getPercentajeTotal) {
            this.name = name;
            this.getPercentajeTotal = getPercentajeTotal;
        }

        public String name;
        public float getPercentajeTotal;
    }
    private List<UserConnections> connections;
    private User[] infomacionUsuarios;
    private List<Post> posts = new ArrayList<Post>();
    private float[] likelihood = new float[11];
    private List<informationOfLlikeness> informationOfLlikenesses = new ArrayList<informationOfLlikeness>();

    public void getInformation(){
        int a;
        int likes = 0;
        int comments = 0;

        for (UserConnections i: connections) {
            a = Integer.parseInt(i.getUsername().replace("user",""));
            likes += i.getLikes();
            comments += i.getComments();
            posts.addAll(infomacionUsuarios[a].getPosts());
        }

        float h;
        for (UserConnections i:connections){
            h = (float)((float)i.getLikes()/likes + (float)i.getComments()/comments)*100/2;
            informationOfLlikenesses.add(new informationOfLlikeness(i.getUsername(),h));
        }

        for (Post i : posts) {
            if (i.getLiked_by().contains(infomacionUsuarios[0].getUsername())){
                likelihood[i.getCategory()] += 1.0;
            }
        }
        for (int i = 0; i < likelihood.length; i++) {
            likelihood[i] = (likelihood[i]*100)/likes;
        }
        posts.sort(new Comparator<Post>() {
            public int compare(Post o1, Post o2) {
                Float likelihoodO2 = likelihood[o2.getCategory()];
                Float likelihoodO1 = likelihood[o1.getCategory()];
                return likelihoodO2.compareTo(likelihoodO1);
            }
        });
        System.out.println(posts);
    }


    public Feed(List<UserConnections> connections,User[] infomacionUsuarios) {
        this.connections = connections;
        this.infomacionUsuarios = infomacionUsuarios;
    }

    public int compare(Post o1, Post o2) {
        Float likelihoodO2 = likelihood[o2.getCategory()];
        Float likelihoodO1 = likelihood[o1.getCategory()];
        return likelihoodO2.compareTo(likelihoodO1);
    }
}
