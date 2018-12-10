package Sort;

import Comparators.Comparators;
import JsonClasses.Post;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


/**
 * La classe Merge implementa el algorismo de ordenacion MergeSort
 * junto con un atributo Comparator.
 */
public class Merge {
    /** Variable Comparators para comparar con diferentes criterios sin tener
     * modificar el algorismo al completo, gracias a la utilizacion de un a interface
     * */

    private Comparators<Post> c;

    /**
     * Constructor vacio
     **/
    public Merge() {
    }

    /**
     * Metodo que llama al mergesort pasando los parametros necessarios para realizarlo
     * @param a Lista de Posts
     * @param c Comparador
     */
    public void MergeSort(List<Post> a, Comparators c){
        this.c = c;
        ordenaMerge(a, 0, a.size()-1);
    }

    /**
     * Metodo de llamadas recursivas para hacer la ordenacion, mediante la division de la
     * lista hasta llegar al caso trivial donde solo hay un elemento.
     * @param a Lista de Posts
     * @param i Primera posicio de la llista (0)
     * @param j Ultima posicio de la llista
     */
    private void ordenaMerge(List<Post> a, int i, int j){
        //Se comprueba el caso no trivial
        if (i < j){
            //Calcula la mitad de la division de la lista
            int mig = (i + j) / 2;
            //Llamada recursiva mitad izquierda
            ordenaMerge(a, i, mig);
            //Llamada recursiva mitad derecha
            ordenaMerge(a,mig+1, j);
            //Llamada que ordena la division
            merge(a, i, mig, j);
        }
    }

    /**
     * Ordenacion de la division de la lista.
     * @param a Lista de Posts
     * @param i Primera posicion de la division
     * @param mig Mitad de la division
     * @param j Ultima posicion de la division
     */
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