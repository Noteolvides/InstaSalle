package Comparators;

import JsonClasses.Post;

public interface Comparators<Post> {
    public int compare(Post o1, Post o2);
    public int getValue(Post o1);
}
