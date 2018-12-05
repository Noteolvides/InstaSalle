package Sort;

import JsonClasses.Post;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
public class Radix {
    private Comparator<Post> c;

    public Radix() {
    }

    public void RadixSort(List<Post> a, Comparator<Post> c){
        this.c = c;
        Radix(a,a.size()-1);
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

    private void Sort(List<Post> a, int n, int exp){
        List<Post> resultat = new ArrayList<Post>();
        int counter[] = new int[10];
        Arrays.fill(counter,0);

        for (int i = 0; i < n; i++){
            counter[(a.get(i).getId()/exp)%10]++;
        }
        for (int i = 1; i < 10; i++){
            counter[i] += counter[i - 1];
        }

        for (int i = n; i>= 0; i--){
            resultat.set(counter[(a.get(i).getId()/exp)%10 -1], a.get(i));
            counter[(a.get(i).getId()/exp)%10]--;
        }

        for (int i = 0; i < n; i++){
            a.set(i, resultat.get(i));
        }
    }

    private void Radix(List<Post> a, int n){
        Post m = maxValue(a, n);

        for (int exp = 1; m.getId()/exp > 0; exp *= 10){
            Sort(a, n, exp);
        }
    }
}*/