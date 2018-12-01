package Comparators;

import JsonClasses.Post;

import java.util.Comparator;

public class Location implements Comparator<Post> {
    private int x;
    public Location(int x) {
        this.x = x;
    }

    public int compare(Post o1, Post o2) {
        return o2.getId().compareTo(o1.getId());
    }
}
