package Sort;

import Comparators.Comparators;
import Comparators.Descendent;
import JsonClasses.Post;
import JsonClasses.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class Selection {
    public static void main(String[] args) throws FileNotFoundException {
        Gson gson = new GsonBuilder().create();
        User[] infomacionUsuarios = gson.fromJson(new FileReader("xs_dataset.json"), User[].class);
        Descendent d = new Descendent();
        Selection r = new Selection();
        r.SelectionSort(infomacionUsuarios[0].getPosts(),d);
        for (Post i:infomacionUsuarios[0].getPosts()) {
            System.out.println(i.getPublished());
        }
    }
    private Comparators<Post> c;

    public Selection() {
    }

    public void SelectionSort(List<Post> a, Comparators<Post> c){
        this.c = c;
        Selection(a,a.size());
    }

    private void Selection(List<Post> a, int n){
        int minim;
        Post aux;

        for(int i = 0; i < n-1; i++) {
            minim = i;
            for (int j = i + 1; j < n; j++) {
                if (this.c.compare(a.get(j),a.get(minim)) < 0){
                    minim = j;
                }
            }
            aux = a.get(minim);
            a.set(minim, a.get(i));
            a.set(i, aux);
        }
    }
}

