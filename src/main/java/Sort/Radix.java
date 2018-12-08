package Sort;

import Comparators.Comparators;
import Comparators.Ascendent;
import JsonClasses.Post;
import JsonClasses.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Collections;
import java.util.List;

//Solo ordena por ubicacion
public class Radix {
    public static void main(String[] args) throws FileNotFoundException {
        Gson gson = new GsonBuilder().create();
        User[] infomacionUsuarios = gson.fromJson(new FileReader("xs_dataset.json"), User[].class);
        Ascendent d = new Ascendent();
        Radix r = new Radix();
        r.RadixSort(infomacionUsuarios[0].getPosts(),d);
        for (Post i:infomacionUsuarios[0].getPosts()) {
            System.out.println(i.getPublished());
        }
    }
    private Comparators<Post> c;

    public Radix() {
    }

    public void RadixSort(List<Post> a, Comparators<Post> c){
        this.c = c;
        sort(a,a.size());
    }
    private Post maxValue(List<Post> a, int n){
        Post max = a.get(0);

        for (int i = 1; i < n; i++){
            if (this.c.compare(a.get(i),max) > 0){
                max = a.get(i);
            }
        }
        return max;
    }

    private void countSort(List<Post> a, int n, int exp){
        Post[] resultat = new Post[n];
        int counter[] = new int[n];
        int i;
        for (i = 0; i < n; i++){
            counter[((c.getValue(a.get(i))) / exp) % 10]++;
        }
        for (i = 1; i < n; i++){
            counter[i] += counter[i - 1];
        }

        for (i = n - 1; i >= 0; i--){
            resultat[counter[((c.getValue(a.get(i))) / exp) % 10] -1]= a.get(i);
            counter[((c.getValue(a.get(i))) / exp) % 10]--;
        }

        for (i = 0; i < n; i++){
            a.set(i, resultat[i]);
        }
    }

    private void sort(List<Post> a, int n){
        Post m = maxValue(a, n);
        for (int exp = 1; c.getValue(m)/exp > 0; exp *= 10){
            countSort(a, n, exp);
        }
        Collections.reverse(a);
    }
}