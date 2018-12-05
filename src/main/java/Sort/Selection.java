package Sort;

import JsonClasses.Post;

import java.util.Comparator;
import java.util.List;

public class Selection {
    private Comparator<Post> c;

    public Selection() {
    }

    public void SelectionSort(List<Post> a, Comparator<Post> c){
        this.c = c;
        Sort(a,a.size()-1);
    }

    public void Sort(List<Post> a, int n){
        int minim;
        Post aux;

        for(int i = 0; i < n-1; i++) {
            minim = i;
            for (int j = i + 1; j < n; j++) {
                if (this.c.compare(a.get(i),a.get(minim)) < 0){
                    minim = j;
                }
            }
            aux = a.get(minim);
            a.set(minim, a.get(i));
            a.set(i, aux);
        }
    }
}

