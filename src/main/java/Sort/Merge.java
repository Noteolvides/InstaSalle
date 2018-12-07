package Sort;

import JsonClasses.Post;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


//Error


public class Merge {
    /*
    public static void main(String[] args) throws FileNotFoundException {
        Gson gson = new GsonBuilder().create();
        User[] infomacionUsuarios = gson.fromJson(new FileReader("xs_dataset.json"), User[].class);
        Merge m = new Merge();
        m.MergeSort(infomacionUsuarios[0].getPosts(),new Descendent());
        System.out.println(infomacionUsuarios[0].getPosts());
    }
    */
   private Comparator<Post> c;

    public Merge() {
    }

    public void MergeSort(List<Post> a, Comparator c){
        this.c = c;
        ordenaMerge(a, 0, a.size()-1);
    }

    private void ordenaMerge(List<Post> a, int i, int j){
        if (i < j){
            int mig = (i + j) / 2;
            ordenaMerge(a, i, mig);
            ordenaMerge(a,mig+1, j);
            merge(a, i, mig, j);
        }
    }

    private void merge(List<Post> a, int i, int mig, int j){
        int n1 = mig - i + 1;
        int n2 = j - mig;
        List<Post> A = new ArrayList<Post>();
        List<Post> B = new ArrayList<Post>();
        for (int k = 0; k < n1; k++) {
            A.add(a.get(i+k));
        }
        for (int t = 0; t < n2; t++) {
            B.add(a.get(mig + 1 + t));
        }
        int k1 = 0,k2 = 0;
        int cursor = i;
        while (k1 < n1 && k2 < n2){
            if (this.c.compare(A.get(k1),B.get(k2)) <= 0){
                a.set(cursor,A.get(k1));
                k1++;
            }else{
                a.set(cursor,B.get(k2));
                k2++;
            }
            cursor++;
        }
        while (k1 < n1){
            a.set(cursor,A.get(k1));
            k1++;
            cursor++;
        }
        while (k2 < n2){
            a.set(cursor,B.get(k2));
            k2++;
            cursor++;
        }
    }
}