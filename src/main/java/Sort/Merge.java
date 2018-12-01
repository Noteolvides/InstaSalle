package Sort;

import JsonClasses.Post;

import java.util.List;

public class Merge {
    private static List<Post> ordenaMerge(List<Post> a, Integer i, Integer j){
        Integer mig;

        if (i>=j){
            return a;
        }
        if (i < j){
            mig = (i+j)/2;
            a = ordenaMerge(a, i, mig);
            a = ordenaMerge(a,mig+1, j);
            a = MergeSort(a, i, mig, j);
        }
        return a;
    }

    public static List<Post> MergeSort(List<Post> a, Integer i, Integer mig, Integer j){
        List<Post> b = null;
        Integer k1, k2, cursor, kr;

        k1 = i;
        k2 = mig+1;
        cursor = 1;

        while (k1<=mig && k2<=j){
            if(a.get(k1).getId() <= a.get(k2).getId()){
                b.set(cursor, a.get(k1));
                k1++;
                cursor++;
            }
            if(a.get(k1).getId() > a.get(k2).getId()){
                b.set(cursor, a.get(k2));
                k2++;
                cursor++;
            }
        }
        while (k1<=mig){
            b.set(cursor, a.get(k1));
            k1++;
            cursor++;
        }
        while (k2<=j){
            b.set(cursor, a.get(k2));
            k2++;
            cursor++;
        }
        cursor = 1;
        kr = i;

        while (kr<=j){
            a.set(kr, b.get(cursor));
            kr++;
            cursor++;
        }

        return a;
    }
}