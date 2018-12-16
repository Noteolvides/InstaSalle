package Sort;

import Comparators.Comparators;
import JsonClasses.Post;
import java.util.List;

/**
 *
 */
public class Selection {
    /**Variable Comparators para comparar con diferentes criterios sin tener
     * modificar el algorismo al completo, gracias a la utilizacion de un a interface*/
    private Comparators<Post> c;

    /** Constructor vacio */
    public Selection() {
    }

    /**
     * Metodo que llama al meotodo de ordenacion pasando los parametros
     * @param a Lista de Posts
     * @param c Comparador
     */
    public void SelectionSort(List<Post> a, Comparators<Post> c){
        this.c = c;
        Selection(a,a.size());
    }

    /**
     * Metodo que implementa el SelectionSort
     * @param a Lista de Posts
     * @param n Tamaño de la lista
     */
    private void Selection(List<Post> a, int n){
        int minim;
        Post aux;

        for(int i = 0; i < n-1; i++) {
            minim = i;
            for (int j = i + 1; j < n; j++) {
                if (this.c.compare(a.get(j),a.get(minim)) < 0){
                    minim = j;
                }
            }
            aux = a.get(minim);
            a.set(minim, a.get(i));
            a.set(i, aux);
        }
    }
}

