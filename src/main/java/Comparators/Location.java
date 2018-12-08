package Comparators;

import JsonClasses.Post;

import java.util.Comparator;
import java.util.List;


public class Location implements Comparators<Post> {

    private final int RADIUS_EARTH = 6371;

    public double haversin(double theta){
        return Math.pow(Math.sin(theta/2),2);
    }

    public double calculDist(List<Double> p1, List<Double> p2){
        Double teta1 = Math.toRadians(p1.get(0));
        Double teta2  = Math.toRadians(p2.get(0));


        double distLati = Math.toRadians(p2.get(0) - p1.get(0));
        double distLong = Math.toRadians(p2.get(1) - p1.get(1));

        double a = haversin(distLati) + Math.cos(teta1) * Math.cos(teta2) * haversin(distLong);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        double d =  RADIUS_EARTH * c;

        return d;
    }

    private List<Double> location;

    public Location(List<Double> location) {
        this.location = location;
    }


    public int compare(Post o1, Post o2) {
       Double dist1 = calculDist(o1.getLocation(),location);
       Double dist2  = calculDist(o2.getLocation(),location);
       return dist1.compareTo(dist2);
    }

    public int getValue(Post o1) {
        return (int)(calculDist(o1.getLocation(),location)*100000);
    }

}
