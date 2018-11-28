import JsonClasses.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Gson gson = new GsonBuilder().create();
        User infomacionUsuarios = gson.fromJson(new FileReader("src//s_dataset.json"), User.class);
        System.out.println(infomacionUsuarios);
    }
}
