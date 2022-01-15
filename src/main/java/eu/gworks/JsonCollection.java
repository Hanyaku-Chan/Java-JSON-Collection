package eu.gworks;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;

public class JsonCollection {

    private JsonObject data = new JsonObject();

    public void construct() {
    }

    public String get(String key) {
        if(data.has(key)) {
            return data.get(key).getAsString();
        }
        return null;
    }

    public void set(String key, String value) {
        if(key == null || value == null) return;
        if(data.has(key)) data.remove(key);
        data.addProperty(key, value);
    }

    public void delete(String key) {
        if(key == null) return;
        if(data.has(key)) data.remove(key);
    }

    public void save(String path) {
        String jsonString = data.toString();
        try {
            File myObj = new File(path);
            if (myObj.createNewFile()) {
                ObjectMapper mapper = new ObjectMapper();
                Object json = mapper.readValue(jsonString, Object.class);
                mapper.writerWithDefaultPrettyPrinter().writeValueAsString(json);
            } else {
                ObjectMapper mapper = new ObjectMapper();
                Object json = mapper.readValue(jsonString, Object.class);
                FileWriter myWriter = new FileWriter(path);
                myWriter.write(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(json));
                myWriter.close();
            }
          } catch (IOException e) { return; }
    }

    public void load(String path) {
        String json = "";
        try {
            File myObj = new File(path);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
              json = json + " " + myReader.nextLine();
            }
            myReader.close();
            data = com.google.gson.JsonParser.parseString(json).getAsJsonObject();
          } catch (FileNotFoundException e) { return; }
    }

    public JsonObject getJson() {
        return data;
    }

}