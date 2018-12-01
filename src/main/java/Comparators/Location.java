package Comparators;

import JsonClasses.Post;

import java.util.Comparator;

public class Location implements Comparator<Post> {
    private int x;
    public Location(int x) {
        this.x = x;
    }

    public int compare(Post o1, Post o2) {
        System.out.println(this.x);
        return o2.getPublished().compareTo(o1.getPublished());
    }
}
