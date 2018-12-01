import Comparators.Location;
import JsonClasses.Post;
import JsonClasses.User;
import Sort.Quick;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Gson gson = new GsonBuilder().create();
        User[] infomacionUsuarios = gson.fromJson(new FileReader("xs_dataset.json"), User[].class);
        Quick quick = new Quick();
        List<Post> posts = new ArrayList<Post>();

        for (User i:infomacionUsuarios) {
            posts.addAll(i.getPosts());
        }
        ArrayList<Double> location = new ArrayList<Double>();
        location.add(41.3854363);
        location.add(2.1730605);
        quick.QuickSort(posts,new Location(location));
        for (int i = 0; i < posts.size() ; i++) {
            System.out.println(posts.get(i).getId());
        }
    }
}
