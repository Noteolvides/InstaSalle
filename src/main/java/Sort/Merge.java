package Sort;

import JsonClasses.Post;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/*
public class Merge {
   private Comparator<Post> c;

    public Merge() {
    }

    public void MergeSort(List<Post> a, Comparator c){
        this.c = c;
        ordenaMerge(a, 0, a.size()-1);
    }

    private void ordenaMerge(List<Post> a, int i, int j){
        if (i < j){
            System.out.println("\ni" + i + "j" + j);
            int mig = (i + j) / 2;
            System.out.println("\nmig =" + mig);
            ordenaMerge(a, i, mig);
            ordenaMerge(a,mig+1, j);
            Sort(a, i, mig, j);
        }
    }

    private void Sort(List<Post> a, int i, int mig, int j){
        List<Post> b = new ArrayList<Post>();
        int k1, k2, cursor, kr;

        k1 = i;
        k2 = mig+1;
        cursor = 1;

        while (k1<=mig && k2<=j){
            if(this.c.compare(a.get(k1),a.get(k2)) <= 0){
                b.set(cursor, a.get(k1));
                k1++;
                cursor++;
            }
            if(this.c.compare(a.get(k1),a.get(k2)) > 0){
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
    }
}*/