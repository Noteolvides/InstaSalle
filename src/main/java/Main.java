import Comparators.*;
import JsonClasses.*;
import Sort.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args, int sort, int segons) throws FileNotFoundException {
        Gson gson = new GsonBuilder().create();
        User[] infomacionUsuarios = gson.fromJson(new FileReader("xs_dataset.json"), User[].class);
        List<UserConnections> connections =  infomacionUsuarios[0].getConnections();
        //Feed f = new Feed(connections,infomacionUsuarios);
        //f.getInformation();
        //Ascendent a = new Ascendent();
        //Quick q = new Quick();
        //q.QuickSort(infomacionUsuarios[0].getPosts(),a);
        //System.out.println(infomacionUsuarios[0].getPosts());
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
                System.out.println("AscendentE:");
                break;
            case 2:
                System.out.println("UbicacioN:");
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
