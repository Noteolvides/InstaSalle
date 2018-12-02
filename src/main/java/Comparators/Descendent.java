package Comparators;

import JsonClasses.Post;

import java.util.Comparator;

public class Descendent implements Comparator<Post> {
    
    public Descendent() {
    }

    public int compare(Post o1, Post o2) {
        return o2.getPublished().compareTo(o1.getPublished());
    }
}
