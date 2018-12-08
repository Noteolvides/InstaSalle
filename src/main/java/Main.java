import Comparators.*;
import JsonClasses.*;
import Sort.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javafx.geometry.Pos;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Gson gson = new GsonBuilder().create();
        User[] infomacionUsuarios = gson.fromJson(new FileReader("xs_dataset.json"), User[].class);
        int sort = Integer.parseInt(args[0]);
        int segons = Integer.parseInt(args[1]);
        int user = 0;
        if (segons == 3){
            user = Integer.parseInt(args[2]);
        }

        menu(sort, segons, infomacionUsuarios,user);
    }

    private static void menu(int sort, int segons, User[] infomacionUsuarios,int user){
        switch(sort) {
            case 1:
                System.out.println("Merge Sort:");
                menu2(sort, segons, infomacionUsuarios,user);
                break;
            case 2:
                System.out.println("Quick Sort:");
                menu2(sort, segons, infomacionUsuarios,user);
                break;
            case 3:
                System.out.println("Selection Sort:");
                menu2(sort, segons, infomacionUsuarios,user);
                break;
            case 4:
                System.out.println("Radix Sort:");
                menu2(sort, segons, infomacionUsuarios,user);
                break;
            default:
                System.out.println("Error! La opcion introducida no existe!");
                break;
        }
    }

    private static void menu2(int sort, int segons, User[] infomacionUsuarios,int user){
        switch(segons) {
            case 1:
                System.out.println("\tAscendente:");
                Ascendent a = new Ascendent();
                switch(sort) {
                    case 1:
                        Merge m = new Merge();
                        m.MergeSort(infomacionUsuarios[0].getPosts(),a);
                        break;
                    case 2:
                        Quick q = new Quick();
                        q.QuickSort(infomacionUsuarios[0].getPosts(),a);
                        break;
                    case 3:
                        Selection s = new Selection();
                        s.SelectionSort(infomacionUsuarios[0].getPosts(),a);
                        break;
                    case 4:
                        Radix r = new Radix();
                        r.RadixSort(infomacionUsuarios[0].getPosts(),a);
                        break;
                    default:
                        System.out.println("Error! La opcion introducida no existe!");
                        break;
                }
                System.out.println(infomacionUsuarios[0].getPosts());
                break;
            case 2:
                System.out.println("\tUbicacion:");
                List<Double> loc = new ArrayList<Double>();
                loc.add(0.0);
                loc.add(0.0);
                Location l = new Location(loc);
                switch(sort) {
                    case 1:
                        Merge m = new Merge();
                        m.MergeSort(infomacionUsuarios[0].getPosts(),l);
                        break;
                    case 2:
                        Quick q = new Quick();
                        q.QuickSort(infomacionUsuarios[0].getPosts(),l);
                        break;
                    case 3:
                        Selection s = new Selection();
                        s.SelectionSort(infomacionUsuarios[0].getPosts(),l);
                        break;
                    case 4:
                        Radix r = new Radix();
                        r.RadixSort(infomacionUsuarios[0].getPosts(),l);
                        break;
                    default:
                        System.out.println("Error! La opcion introducida no existe!");
                        break;
                }
                System.out.println(infomacionUsuarios[0].getPosts());
                break;
            case 3:
                System.out.println("\tCombinacion de prioridades:");
                Feed f = new Feed(infomacionUsuarios,user);
                List<Post> posts = f.getInformation();
                switch(sort) {
                    case 1:
                        Merge m = new Merge();
                        m.MergeSort(posts,f);
                        break;
                    case 2:
                        Quick q = new Quick();
                        q.QuickSort(posts,f);
                        break;
                    case 3:
                        Selection s = new Selection();
                        s.SelectionSort(posts,f);
                        break;
                    case 4:
                        Radix r = new Radix();
                        r.RadixSort(posts,f);
                        break;
                    default:
                        System.out.println("Error! La opcion introducida no existe!");
                        break;
                }
                System.out.println(posts);
                break;
            default:
                System.out.println("\tError! La opcion introducida no existe!");
                break;
        }
    }
}
