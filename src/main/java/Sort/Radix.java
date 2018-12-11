package Sort;

import Comparators.Comparators;
import JsonClasses.Post;
import java.util.Collections;
import java.util.List;

/**
 *
 */
public class Radix {
    /**Variable Comparators para comparar con diferentes criterios sin tener
     * modificar el algorismo al completo, gracias a la utilizacion de un a interface*/
    private Comparators<Post> c;

    /** Constructor vacio */
    public Radix() {
    }

    /**
     * Metodo que llama al meotodo de ordenacion pasando los parametros
     * @param a Lista de Post
     * @param c Comparador
     */
    public void RadixSort(List<Post> a, Comparators<Post> c){
        this.c = c;
        sort(a,a.size());
    }

    private Post maxValue(List<Post> a, int n){
        Post max = a.get(0);

        for (int i = 1; i < n; i++){
            if (this.c.compare(a.get(i),max) < 0){
                max = a.get(i);
            }
        }
        return max;
    }

    /**
     * Metodo que implementa el CountSort
     * @param a Lista de Posts
     * @param n Tamaño de la lista
     * @param exp Numero digito a comparar
     */
    private void countSort(List<Post> a, int n, int exp){
        Post[] resultat = new Post[n];
        int counter[] = new int[n];
        int i;
        for (i = 0; i < n; i++){
            counter[((c.getValue(a.get(i))) / exp) % 10]++;
        }
        for (i = 1; i < n; i++){
            counter[i] += counter[i - 1];
        }

        for (i = n - 1; i >= 0; i--){
            resultat[counter[((c.getValue(a.get(i))) / exp) % 10] -1]= a.get(i);
            counter[((c.getValue(a.get(i))) / exp) % 10]--;
        }

        for (i = 0; i < n; i++){
            a.set(i, resultat[i]);
        }
    }

    private void sort(List<Post> a, int n){
        Post max = maxValue(a,n);
        for (int exp = 1; c.getValue(max)/exp > 0; exp *= 10){
            countSort(a, n, exp);
        }
    }
}