package Sort;
import Comparators.Comparators;
import JsonClasses.Post;
import java.util.List;


public class Quick {
    private Comparators<Post> c;

    public void QuickSort(List<Post> a, Comparators<Post> c){
        this.c = c;
        Sort(a,0,a.size() - 1);
    }
    private void Sort(List<Post> a, int i, int j) {
        if (i < j) {
            int[] aux = particio(a, i, j);
            Sort(a, i, aux[1]);
            Sort(a, aux[0], j);
        }
    }

    private int[] particio(List<Post> a, int i, int j) {
        int mig;
        int[] aux = new int[]{i,j};
        Post tmp;
        mig = ((i + j) / 2);
        Post pivot = a.get(mig);

        while (aux[0] <= aux[1]) {
            while (this.c.compare(a.get(aux[0]),pivot) < 0) {
                aux[0]++;
            }
            while (this.c.compare(a.get(aux[1]),pivot) > 0) {
                aux[1]--;
            }
            if (aux[0] < aux[1]) {
                tmp = a.get(aux[0]);
                a.set(aux[0],a.get(aux[1]));
                a.set(aux[1],tmp);
                aux[0]++;
                aux[1]--;
            }else{
                if (aux[0] == aux[1]) {
                    aux[0]++;
                    aux[1]--;
                }
            }
        }
        return aux;
    }
}
