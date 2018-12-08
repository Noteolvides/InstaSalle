package Comparators;

import JsonClasses.Post;

import java.util.Comparator;

public class Descendent implements Comparators<Post> {
    
    public Descendent() {
    }
    public int getValue(Post o1){
        return o1.getPublished();
    }
    public int compare(Post o1, Post o2) {
        return o2.getPublished().compareTo(o1.getPublished());
    }
}
