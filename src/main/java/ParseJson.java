import com.google.gson.internal.bind.util.ISO8601Utils;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ParseJson {
    public static void main(String[] args)
    {

        FileReader fileReader = null;
        try {
            fileReader = new FileReader("sales_array.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        JsonReader reader = new JsonReader(fileReader);
        // we call the handle object method to handle the full json object. This
        // implies that the first token in JsonToken.BEGIN_OBJECT, which is
        // always true.
        try {
            //handleObject(reader);
            handleArray(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handleObject(JsonReader reader) throws IOException
    {
        reader.beginObject();
        while (reader.hasNext()) {
            JsonToken token = reader.peek();
            if (token.equals(JsonToken.BEGIN_ARRAY))
                handleArray(reader);
            else if (token.equals(JsonToken.END_OBJECT)) {
                reader.endObject();
                return;
            } else
                handleNonArrayToken(reader, token);
        }

    }

    public static void handleArray(JsonReader reader) throws IOException
    {
        reader.beginArray();
        while (true) {
            JsonToken token = reader.peek();
            if (token.equals(JsonToken.END_ARRAY)) {
                reader.endArray();
                break;
            } else if (token.equals(JsonToken.BEGIN_OBJECT)) {
                handleObject(reader);
            } else if (token.equals(JsonToken.END_OBJECT)) {
                reader.endObject();
            } else
                handleNonArrayToken(reader, token);
        }
    }

    public static void handleNonArrayToken(JsonReader reader, JsonToken token) throws IOException
    {
        double sumbeauty=0,varbeauty=0;
        double sumkids=0,varkids=0;
        double sumbaby=0,varbaby=0;
        double sumind=0,varind=0;
        double sumsport=0,varsport=0;
        double summovi=0,varmovi=0;
        double sumtoy=0,vartoy=0;
        double sumcloth=0,varcloth=0;
        double sumtool=0,vartool=0;
        double summusi=0,varmusi=0;

        String department = "";
        if (token.equals(JsonToken.STRING))
            department = reader.nextString();
            if (department == "Beauty")
                varbeauty = reader.nextDouble();
                sumbeauty = sumbeauty+varbeauty;
                if (token.equals(JsonToken.NUMBER))
                    varbeauty = reader.nextDouble();
                    else reader.skipValue();

        if (token.equals(JsonToken.STRING))
            department = reader.nextString();
            if (department == "Kids")
                varkids = reader.nextDouble();
                varkids = sumkids+varkids;
                if (token.equals(JsonToken.NUMBER))
                    varkids = reader.nextDouble();
                    else reader.skipValue();

        if (token.equals(JsonToken.STRING))
            department = reader.nextString();
            if (department == "Baby")
                varbaby = reader.nextDouble();
                varbaby = sumbaby+varbaby;
                if (token.equals(JsonToken.NUMBER))
                    varbaby = reader.nextDouble();
                    else reader.skipValue();

        System.out.println(sumbeauty);
        System.out.println(sumkids);
        System.out.println(sumbaby);
    }

}