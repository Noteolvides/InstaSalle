package Sort;

import java.util.ArrayList;

public class Quick {
    public Integer[] QuickSort(Integer[] a, Integer i, Integer j) {
        Integer s, t;

        if (i >= j) {
            return a;
        }
        if (i < j) {
            a = particio(a, i, j);
            a = QuickSort(a, i, t);
            a = QuickSort(a, s, j);
        }
        return a;
    }


    //Falta corregir els returns
    private Integer[] particio(Integer[] a, Integer i, Integer j) {
        Integer mig, pivot, tmp, s, t;

        s = i;
        t = j;
        mig = (i + j) / 2;
        pivot = a[mig];

        while (s <= t) {
            while (a[s] < pivot) {
                s++;
            }
            while (a[t] > pivot) {
                t++;
            }
            if (s < t) {
                tmp = a[s];
                a[s] = a[t];
                a[t] = tmp;
                s++;
                t--;
            }
            if (s == t) {
                s++;
                t--;
            }
            if (s > t) {

            }
        }

        return a;
    }
}
