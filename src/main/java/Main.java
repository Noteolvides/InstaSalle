import Comparators.*;
import JsonClasses.*;
import Sort.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Gson gson = new GsonBuilder().create();
        User[] infomacionUsuarios = gson.fromJson(new FileReader("xs_dataset.json"), User[].class);
        List<UserConnections> connections =  infomacionUsuarios[0].getConnections();
        Scanner sc = new Scanner(System.in);
        int sort = sc.nextInt();
        int segons = sc.nextInt();
        //Feed f = new Feed(connections,infomacionUsuarios);
        //f.getInformation();
        List<Double> loc = new ArrayList<Double>();
        loc.add(0.0);
        loc.add(0.0);

        //Location a = new Location(loc);
        Ascendent a = new Ascendent();
        Quick q = new Quick();
        q.QuickSort(infomacionUsuarios[0].getPosts(),a);
        System.out.println(infomacionUsuarios[0].getPosts());
        menu(sort, segons);
    }

    public static void menu(int sort, int segons){
        switch(sort) {
            case 1:
                System.out.println("Merge Sort:");
                menu2(segons);
                break;
            case 2:
                System.out.println("Quick Sort:");
                menu2(segons);
                break;
            case 3:
                System.out.println("Selection Sort:");
                menu2(segons);
                break;
            case 4:
                System.out.println("Radix Sort:");
                menu2(segons);
                break;
            default:
                System.out.println("Error! La opcion introducida no existe!");
                break;
        }
    }

    public static void menu2(int segons){
        switch(segons) {
            case 1:
                System.out.println("Ascendente:");
                break;
            case 2:
                System.out.println("Ubicacion:");
                break;
            case 3:
                System.out.println("Combinacion de prioridades:");
                break;
            default:
                System.out.println("Error! La opcion introducida no existe!");
                break;
        }
    }
}
