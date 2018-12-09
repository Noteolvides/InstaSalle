import Comparators.*;
import JsonClasses.*;
import Sort.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Gson gson = new GsonBuilder().create();
        User[] infomacionUsuarios = gson.fromJson(new FileReader(args[0]), User[].class);
        menu(infomacionUsuarios, args);
    }

    private static void menu(User[] infomacionUsuarios, String[] args) {
        int sort = Integer.parseInt(args[1]);
        int segons = Integer.parseInt(args[2]);
        int user = 0;
        List<Double> loc = new ArrayList<Double>();
        if (segons == 2) {
            loc.add((double) Float.parseFloat(args[3]));
            loc.add((double) Float.parseFloat(args[4]));
        }
        if (segons == 3) {
            user = Integer.parseInt(args[3]);
        }

        ArrayList<Post> posts = new ArrayList<Post>();
        for (User i : infomacionUsuarios) {
            posts.addAll(i.getPosts());
        }
        switch (segons) {
            case 1:
                System.out.println("\tPublicacion:");
                Descendent d = new Descendent();
                menu2(posts, sort, d);
                Collections.reverse(posts);
                System.out.println(posts);
                break;
            case 2:
                System.out.println("\tUbicacion:");
                Location l = new Location(loc);
                l.preOrder(posts);
                menu2(posts, sort, l);
                System.out.println(posts);
                break;
            case 3:
                System.out.println("\tCombinacion de prioridades:");
                Feed f = new Feed(infomacionUsuarios, user);
                List<Post> postsUb = f.getInformation();
                menu2(postsUb, sort, f);
                System.out.println(postsUb);
        }
    }

    private static void menu2(List<Post> posts, int sort, Comparators<Post> c) {
        long start,end;
        switch (sort) {
            case 1:
                System.out.println("Merge Sort");
                Merge m = new Merge();
                start = System.currentTimeMillis();
                m.MergeSort(posts, c);
                end = System.currentTimeMillis();
                System.out.println(end-start);
                break;
            case 2:
                System.out.println("Quick Sort");
                Quick q = new Quick();
                start = System.currentTimeMillis();
                q.QuickSort(posts, c);
                end = System.currentTimeMillis();
                System.out.println(end-start);
                break;
            case 3:
                System.out.println("Selection Sort");
                Selection s = new Selection();
                start = System.currentTimeMillis();
                s.SelectionSort(posts, c);
                end = System.currentTimeMillis();
                System.out.println(end-start);
                break;
            case 4:
                System.out.println("Radix Sort");
                Radix r = new Radix();
                start = System.currentTimeMillis();
                r.RadixSort(posts, c);
                end = System.currentTimeMillis();
                System.out.println(end-start);
                break;
            default:
                System.out.println("Error! La opcion introducida no existe!");
                break;
        }
    }
}