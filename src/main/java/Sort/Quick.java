package Sort;

import JsonClasses.Post;

import java.util.List;


public class Quick {
    public void QuickSort(List<Post> a){
        Sort(a,0,a.size()-1);
    }
    private void Sort(List<Post> a, Integer i, Integer j) {
        Integer s = 0;
        Integer t = 0;
        if (i < j) {
            particio(a, i, j,s,t);
            Sort(a, i, t);
            Sort(a, s, j);
        }
    }


    private void particio(List<Post> a, Integer i, Integer j,Integer s,Integer t) {
        Integer mig, pivot;
        Post tmp;
        s = i;
        t = j;
        mig = (i + j) / 2;
        pivot = a.get(mig).getPublished();

        while (s <= t) {
            while (a.get(s).getPublished() < pivot) {
                s++;
            }
            while (a.get(t).getPublished() > pivot) {
                t++;
            }
            if (s < t) {
                tmp = a.get(s);
                a.set(s,a.get(t));
                a.set(t,tmp);
                s++;
                t--;
            }
            if (s.equals(t)) {
                s++;
                t--;
            }
        }
    }
}
