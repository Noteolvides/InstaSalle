import Comparators.*;
import JsonClasses.*;
import Sort.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Gson gson = new GsonBuilder().create();
        User[] infomacionUsuarios = gson.fromJson(new FileReader("xs_dataset.json"), User[].class);
        List<UserConnections> connections =  infomacionUsuarios[0].getConnections();
        //Feed f = new Feed(connections,infomacionUsuarios);
        //f.getInformation();
        Ascendent a = new Ascendent();
        Quick q = new Quick();
        q.QuickSort(infomacionUsuarios[0].getPosts(),a);
        System.out.println(infomacionUsuarios[0].getPosts());
    }
}
