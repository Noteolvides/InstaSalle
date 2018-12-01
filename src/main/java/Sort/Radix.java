package Sort;

import JsonClasses.Post;
import javafx.geometry.Pos;

import java.util.Arrays;
import java.util.List;

/*
public class Radix {
    private static Post maxValue(List<Post> a, int n){
        Post max = a.get(0);
        for (int i = 1; i < n;i++){
            if (a.get(i).getId() > max.getId()){
                max = a.get(i);
            }
        }
        return max;
    }

    private static void sort(List<Post> a, int n, int exp){
        List<Post> resultat = null;
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

    public static void RadixSort(List<Post> a, int n){
        Post m = maxValue(a, n);

        for (int exp = 1; m.getId()/exp > 0; exp *= 10){
            sort(a, n, exp);
        }
    }
}*/