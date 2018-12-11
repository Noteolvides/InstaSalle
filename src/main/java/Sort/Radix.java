package Sort;

import Comparators.Comparators;
import JsonClasses.Post;
import java.util.Collections;
import java.util.List;

//Solo ordena por ubicacion
public class Radix {
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
            if (this.c.compare(a.get(i),max) < 0){
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
        Post max = maxValue(a,n);
        for (int exp = 1; c.getValue(max)/exp > 0; exp *= 10){
            countSort(a, n, exp);
        }
    }
}