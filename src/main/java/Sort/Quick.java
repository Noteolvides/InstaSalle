package Sort;
import Comparators.Comparators;
import JsonClasses.Post;
import java.util.List;


public class Quick {
    /**Variable Comparators para comparar con diferentes criterios sin tener
     * modificar el algorismo al completo, gracias a la utilizacion de un a interface*/
    private Comparators<Post> c;

    /**
     * Metodo que llama a el algorismo de ordenacion pasando los parametros
     * @param a Lista de Posts
     * @param c Comparador
     */
    public void QuickSort(List<Post> a, Comparators<Post> c){
        this.c = c;
        Sort(a,0,a.size() - 1);
    }

    /**
     * Metodo de llamadas recursivas que dividen la lista y ordenan estas divisiones
     * @param a Lista de Posts
     * @param i Primera posicion de la lista (0)
     * @param j Ultima posicion de la lista
     */
    private void Sort(List<Post> a, int i, int j) {
        //Se comprueba el caso no trivial
        if (i < j) {
            //se hacen las divisiones de la lista
            int[] aux = particio(a, i, j);
            //Se hace la ordenacion por el lado izquierdo
            Sort(a, i, aux[1]);
            //Se hace la ordenacion por el lado derecho
            Sort(a, aux[0], j);
        }
    }

    /**
     * Metodo que ordena la division de la lista.
     * @param a Lista de Posts
     * @param i Primera posicion de la division
     * @param j Ultima posicion de la division
     * @return Devuelve los nuevos parametros de division
     */
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
