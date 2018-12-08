package Comparators;

import JsonClasses.Post;

import java.util.Comparator;

public class Ascendent implements Comparators<Post> {
    public Ascendent() {
    }

    public int compare(Post o1, Post o2) {
        return o1.getPublished().compareTo(o2.getPublished());
    }

    public int getValue(Post o1){
        return o1.getPublished();
    }
}
