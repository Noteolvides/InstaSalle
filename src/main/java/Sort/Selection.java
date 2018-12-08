package Sort;

import Comparators.Comparators;
import JsonClasses.Post;

import java.util.Comparator;
import java.util.List;

public class Selection {
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

