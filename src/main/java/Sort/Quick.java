package Sort;

import JsonClasses.Post;

import java.util.List;

public class Quick {
    public Quick() {
    }
    public void QuickSort(List<Post> a){
        QuickSort2(a,0,a.size()-1);
    }
    private void QuickSort2(List<Post> a, int lowIndex , int highIndex){
        if(lowIndex < highIndex){
            int t = partition(a,lowIndex,highIndex);
            QuickSort2(a,lowIndex,t-1);
            QuickSort2(a,t+1,highIndex);
        }
    }
    private int partition(List<Post> a,int lowIndex,int HighIndex){
        int pivot = a.get(HighIndex).getPublished();
        int i = lowIndex - 1;
        Post aux;
        for (int j = lowIndex; j < HighIndex ; j++) {
            if (a.get(j).getPublished() <= pivot){
                i++;
                aux = a.get(i);
                a.set(i,a.get(j));
                a.set(j,aux);
            }
        }
        aux = a.get(i + 1);
        a.set(i + 1,a.get(HighIndex));
        a.set(HighIndex,aux);
        return i+1;
    }
}
