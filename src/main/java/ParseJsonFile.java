import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ParseJsonFile {

    public static void main(String[] args) {

        FileReader fileReader = null;
        BufferedReader in = null;
        try {
            fileReader = new FileReader("sales.json");
            in = new BufferedReader(fileReader);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Gson gson = new Gson();
        ArrayList<Sale> list = new ArrayList<>();

        String jsonString = null;


        try {
            while ((jsonString = in.readLine()) != null) {
                Sale saleObject = gson.fromJson(jsonString, Sale.class);
                list.add(saleObject);
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}