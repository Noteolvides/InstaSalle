import JsonClasses.User;
import Sort.Quick;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Gson gson = new GsonBuilder().create();
        User[] infomacionUsuarios = gson.fromJson(new FileReader("xs_dataset.json"), User[].class);
        Quick quick = new Quick();
        //System.out.println(infomacionUsuarios[0].getPosts());
        quick.QuickSort(infomacionUsuarios[0].getPosts());
        for (int i = 0; i < infomacionUsuarios[0].getPosts().size() ; i++) {
            System.out.println(infomacionUsuarios[0].getPosts().get(i).getPublished());
        }
    }
}
