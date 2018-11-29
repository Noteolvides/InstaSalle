package Sort;

public class Merge {
    public static Integer[] ordenaMerge(Integer[] a, Integer i, Integer j){
        Integer mig;

        if (i>=j){
            return a;
        }
        if (i<j){
            mig = (i+j)/2;
            a = ordenaMerge(a, i, mig);
            a = ordenaMerge(a,mig+1, j);
            a = merge(a, i, mig, j);
        }
        return a;
    }

    public static Integer[] merge(Integer[]a, Integer i, Integer mig, Integer j){
        Integer[] b;
        Integer k1, k2, cursor, kr;

        k1 = i;
        k2 = mig+1;
        cursor = 1;

        while (k1<=mig && k2<=j){
            if(a[k1]<=a[k2]){
                b[cursor] = a[k1];
                k1++;
                cursor++;
            }
            if(a[k1]>a[k2]){
                b[cursor] = a[k2];
                k2++;
                cursor++;
            }
        }
        while (k1<=mig){
            b[cursor] = a[k1];
            k1++;
            cursor++;
        }
        while (k2<=j){
            b[cursor] = a[k2];
            k2++;
            cursor++;
        }
        cursor = 1;
        kr = i;

        while (kr<=j){
            a[kr] = b[cursor];
            kr++;
            cursor++;
        }

        return a;
    }
}