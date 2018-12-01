package Sort;

import JsonClasses.Post;

import java.util.Arrays;
import java.util.List;

public class Radix {
    private static Integer maxValue(int a[], int n){
        int max = a[0];
        for (int i = 1; i < n;i++){
            if (a[i] > max){
                max = a[i];
            }
        }
        return max;
    }

    private static void sort(int a[], int n, int exp){
        int resultat[] = new int[n];
        int counter[] = new int[10];
        Arrays.fill(counter,0);

        for (int i = 0; i < n; i++){
            counter[(a[i]/exp)%10]++;
        }
        for (int i = 1; i < 10; i++){
            counter[i] += counter[i - 1];
        }

        for (int i = n; i>= 0; i--){
            resultat[counter[(a[i]/exp)%10] - 1] = a[i];
            counter[(a[i]/exp)%10]--;
        }

        for (int i = 0; i < n; i++){
            a[i] = resultat[i];
        }
    }

    public static void RadixSort(int a[], int n){
        int m = maxValue(a, n);

        for (int exp = 1; m/exp > 0; exp *= 10){
            sort(a, n, exp);
        }
    }
}
