import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) {
        Gson gson = new GsonBuilder().create();
        InfoJson informacion = gson.fromJson(new FileReader("src//s_dataset.json"), InfoJson.class);
        System.out.println(informacion);
    }
}
