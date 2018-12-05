import Comparators.*;
import JsonClasses.*;
import Sort.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Gson gson = new GsonBuilder().create();
        User[] infomacionUsuarios = gson.fromJson(new FileReader("xs_dataset.json"), User[].class);
        List<UserConnections> connections =  infomacionUsuarios[0].getConnections();
        Integer sort = Integer.parseInt(args[0]);
        Integer segons = Integer.parseInt(args[1]);
        //Feed f = new Feed(connections,infomacionUsuarios);
        //f.getInformation();
        List<Double> loc = new ArrayList<Double>();
        loc.add(0.0);
        loc.add(0.0);

        //Location a = new Location(loc);

        menu(sort, segons, infomacionUsuarios);
    }

    public static void menu(int sort, int segons, User[] infomacionUsuarios){
        switch(sort) {
            case 1:
                System.out.println("Merge Sort:");
                menu2(segons, infomacionUsuarios);
                break;
            case 2:
                System.out.println("Quick Sort:");
                menu2(segons, infomacionUsuarios);
                break;
            case 3:
                System.out.println("Selection Sort:");
                menu2(segons, infomacionUsuarios);
                break;
            case 4:
                System.out.println("Radix Sort:");
                menu2(segons, infomacionUsuarios);
                break;
            default:
                System.out.println("Error! La opcion introducida no existe!");
                break;
        }
    }

    public static void menu2(int segons, User[] infomacionUsuarios){
        switch(segons) {
            case 1:
                System.out.println("\tAscendente:");
                Ascendent a = new Ascendent();
               /* Quick q = new Quick();
                q.QuickSort(infomacionUsuarios[0].getPosts(),a);*/
               /* Merge m = new Merge();
                m.MergeSort(infomacionUsuarios[0].getPosts(),a);*/
                /*Radix r = new Radix();
                r.RadixSort(infomacionUsuarios[0].getPosts(),a);*/
                Selection s = new Selection();
                s.SelectionSort(infomacionUsuarios[0].getPosts(),a);
                System.out.println(infomacionUsuarios[0].getPosts());
                break;
            case 2:
                System.out.println("\tUbicacion:");
                break;
            case 3:
                System.out.println("\tCombinacion de prioridades:");
                break;
            default:
                System.out.println("\tError! La opcion introducida no existe!");
                break;
        }
    }
}
