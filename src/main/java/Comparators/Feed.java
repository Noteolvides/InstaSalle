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

        @Override
        public String toString() {
            return "informationOfLlikeness{" +
                    "name='" + name + '\'' +
                    ", getPercentajeTotal=" + getPercentajeTotal +
                    '}';
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
            String username = i.getUsername();
            a = Integer.parseInt(username.replace("user",""));
            likes += i.getLikes();
            comments += i.getComments();
            List<Post> aux = infomacionUsuarios[a].getPosts();
            for (Post j: aux) {
                j.setCreator(username);
            }
            posts.addAll(aux);
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
            System.out.println(likelihood[i]);
        }
        posts.sort(new Comparator<Post>() {
            public int compare(Post o1, Post o2) {
                Integer likelihoodO2 = (int)likelihood[o2.getCategory()]*60*60*12 + o2.getPublished();
                Integer likelihoodO1 = (int)likelihood[o1.getCategory()]*60*60*12 + o1.getPublished();
                return likelihoodO2.compareTo(likelihoodO1);
            }
        });
        for (informationOfLlikeness i:informationOfLlikenesses) {
            System.out.println(i);
        }
        System.out.println(posts);
    }


    public Feed(List<UserConnections> connections,User[] infomacionUsuarios) {
        this.connections = connections;
        this.infomacionUsuarios = infomacionUsuarios;
    }

    public int compare(Post o1, Post o2) {
        float llikenessOfUser1 = 0;
        float llikenessOfUser2 = 0;
        for (informationOfLlikeness i : informationOfLlikenesses) {
            if(i.name == o1.getCreator()){
                llikenessOfUser1 = i.getPercentajeTotal;
                break;
            }
        }
        for (informationOfLlikeness i : informationOfLlikenesses) {
            if(i.name == o2.getCreator()){
                llikenessOfUser2 = i.getPercentajeTotal;
                break;
            }
        }
        Integer likelihoodO2 = (int)likelihood[o2.getCategory()]*60*60*12 + (int)llikenessOfUser1*60*60*12 + o2.getPublished();
        Integer likelihoodO1 = (int)likelihood[o1.getCategory()]*60*60*12 + (int)llikenessOfUser2*60*60*12 + o1.getPublished();
        return likelihoodO2.compareTo(likelihoodO1);
    }
}
