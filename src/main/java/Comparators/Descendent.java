package Comparators;

import JsonClasses.Post;

public class Descendent {
    
    public Descendent() {
    }

    public int compare(Post o1, Post o2) {
        return o2.getPublished().compareTo(o1.getPublished());
    }
}
