import Comparators.*;
import JsonClasses.*;
import Sort.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javafx.geometry.Pos;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Gson gson = new GsonBuilder().create();
        User[] infomacionUsuarios = gson.fromJson(new FileReader("xs_dataset.json"), User[].class);
        menu(infomacionUsuarios, args);
    }

    private static void menu(User[] infomacionUsuarios, String[] args) {
        int sort = Integer.parseInt(args[0]);
        int segons = Integer.parseInt(args[1]);
        int user = 0;
        List<Double> loc = new ArrayList<Double>();
        if (segons == 2) {
            //loc.add((double) Float.parseFloat(args[2]));
            loc.add(0.0);
            loc.add(0.0);
            //loc.add((double) Float.parseFloat(args[3]));
        }
        if (segons == 3) {
            user = Integer.parseInt(args[2]);
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
                System.out.println(posts);
                break;
            case 2:
                System.out.println("\tUbicacion:");
                Location l = new Location(loc);
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
        switch (sort) {
            case 1:
                System.out.println("Merge Sort");
                Merge m = new Merge();
                m.MergeSort(posts, c);
                break;
            case 2:
                System.out.println("Quick Sort");
                Quick q = new Quick();
                q.QuickSort(posts, c);
                break;
            case 3:
                System.out.println("Selection Sort");
                Selection s = new Selection();
                s.SelectionSort(posts, c);
                break;
            case 4:
                System.out.println("Radix Sort");
                Radix r = new Radix();
                r.RadixSort(posts, c);
                break;
            default:
                System.out.println("Error! La opcion introducida no existe!");
                break;
        }
    }
}