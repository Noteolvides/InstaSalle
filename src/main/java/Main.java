import JsonClasses.Post;
import JsonClasses.User;
import Sort.Quick;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class Main {

    public static Comparator<Post> comparatorPublishedAsedent = new Comparator<Post>() {
        public int compare(Post o1, Post o2) {
            return o1.getPublished().compareTo(o2.getPublished());
        }
    };
    public static Comparator<Post> comparatorPublishedDescendent = new Comparator<Post>() {
        public int compare(Post o1, Post o2) {
            return o2.getPublished().compareTo(o1.getPublished());
        }
    };

    public static void main(String[] args) throws FileNotFoundException {

        Gson gson = new GsonBuilder().create();
        User[] infomacionUsuarios = gson.fromJson(new FileReader("xs_dataset.json"), User[].class);
        Quick quick = new Quick();
        List<Post> posts = new ArrayList<Post>();


        for (User i:infomacionUsuarios) {
            posts.addAll(i.getPosts());
        }
        quick.QuickSort(posts,comparatorPublishedAsedent);
        for (int i = 0; i < posts.size() ; i++) {
            System.out.println(posts.get(i).getPublished());
    }
    }
}
