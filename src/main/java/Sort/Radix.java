package Sort;

import Comparators.Descendent;
import JsonClasses.Post;
import JsonClasses.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//Solo ordena por ubicacion
public class Radix {
    public static void main(String[] args) throws FileNotFoundException {
        Gson gson = new GsonBuilder().create();
        User[] infomacionUsuarios = gson.fromJson(new FileReader("xs_dataset.json"), User[].class);
        Descendent d = new Descendent();
        Radix r = new Radix();
        r.RadixSort(infomacionUsuarios[0].getPosts(),d);
        for (Post i:infomacionUsuarios[0].getPosts()) {
            System.out.println(i.getPublished());
        }
    }
    private Comparator<Post> c;

    public Radix() {
    }

    public void RadixSort(List<Post> a, Comparator<Post> c){
        this.c = c;
        sort(a,a.size()-1);
    }
    private Post maxValue(List<Post> a, int n){
        Post max = a.get(0);

        for (int i = 1; i < n;i++){
            if (this.c.compare(a.get(i),max) > 0){
                max = a.get(i);
            }
        }
        return max;
    }

    private void countSort(List<Post> a, int n, int exp){
        Post[] resultat = new Post[n];
        int counter[] = new int[n];

        for (int i = 0; i < n; ++i){
            counter[(a.get(i).getPublished() / exp) % 10]++;
        }
        for (int i = 1; i < n; ++i){
            counter[i] += counter[i - 1];
        }

        for (int i = n - 1; i>= 0; i--){
            resultat[counter[(a.get(i).getPublished()/exp)%10] -1]= a.get(i);
            counter[(a.get(i).getPublished()/exp)%10]--;
        }

        for (int i = 0; i < n; ++i){
            a.set(i, resultat[i]);
        }
    }

    private void sort(List<Post> a, int n){
        int m = maxValue(a, n).getPublished();

        for (int exp = 1; m/exp > 0; exp *= 10){
            countSort(a, n, exp);
        }
    }
}