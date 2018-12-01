import java.util.ArrayList;
import java.util.List;

public class Haversine {
    /*
    public static void main(String[] args) {
        Haversine h = new Haversine();
        List<Double> p1 = new ArrayList<Double>();
        List<Double> p2 = new ArrayList<Double>();
        p1.add(41.3854363);
        p1.add(2.1730605);
        p2.add(40.5489391);
        p2.add(14.2135486);
        System.out.println(h.calculDist(p1,p2));
    }
*/
    public Haversine() {
    }

    private final int RADIUS_EARTH = 6371;

    private double haversin(double theta){
        return Math.pow(Math.sin(theta/2),2);
    }

    private double calculDist(List<Double> p1, List<Double> p2){
        Double teta1 = Math.toRadians(p1.get(0));
        Double teta2  = Math.toRadians(p2.get(0));


        double distLati = Math.toRadians(p2.get(0) - p1.get(0));
        double distLong = Math.toRadians(p2.get(1) - p1.get(1));

        double a = haversin(distLati) + Math.cos(teta1) * Math.cos(teta2) * haversin(distLong);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        double d =  RADIUS_EARTH * c;
        return d;
    }
}
