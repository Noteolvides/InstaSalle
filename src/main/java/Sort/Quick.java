package Sort;

import JsonClasses.Post;

import java.util.ArrayList;
import java.util.List;


public class Quick {
    /*
    public static void main(String[] args) {
        ArrayList<E> aux;
        aux.sort();
    }
*/
    public void QuickSort(List<Post> a){
        Sort(a,0,a.size()-1);
    }
    private void Sort(List<Post> a, int i, int j) {
        if (i < j) {
            int[] aux = particio(a, i, j);
            Sort(a, i, aux[1]);
            Sort(a, aux[0], j);
        }
    }


    private int[] particio(List<Post> a, int i, int j) {
        int mig, pivot;
        int[] aux = new int[]{i,j};
        Post tmp;
        mig = (i + j) / 2;
        //pivot = a.get(mig).getPublished();

        while (aux[0] <= aux[1]) {
            while (a.get(aux[0]).compareTo(a.get(mig)) < 0) {
                aux[0] = aux[0] + 1;
            }
            while (a.get(aux[1]).compareTo(a.get(mig)) > 0) {
                aux[1] = aux[1] - 1;
            }
            if (aux[0] < aux[1]) {
                tmp = a.get(aux[0]);
                a.set(aux[0],a.get(aux[1]));
                a.set(aux[1],tmp);
                aux[0] = aux[0] + 1;
                aux[1] = aux[1] - 1;
            }
            if (aux[0] == aux[1]) {
                aux[0] = aux[0] + 1;
                aux[1] = aux[1] - 1;
            }
        }
        return aux;
    }
}
