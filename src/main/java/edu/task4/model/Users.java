package edu.task4.model;

import edu.task4.RestClient;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonValue;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

@XmlRootElement
public class Users {
    @XmlElement
    private final ArrayList<User> users = new ArrayList<>();

    RestClient client = new RestClient();

    public Users() {
        getDataFromJSON(getPath());
    }

    //get path to json file from accounting service
    public String getPath() {
        String path = "../Client/";
        path += client.getPath();
        return path;
    }

    public void getDataFromJSON(String PATH) {
        try {
            JSONParser parser = new JSONParser();
            JsonObject jo = (JsonObject) parser.parse(new FileReader(PATH));
            JsonArray usersArray = (JsonArray) jo.get("usersArray");
            for (JsonValue jsonValue : usersArray) {
                JsonObject next = (JsonObject) jsonValue;
                User user = new User(Integer.parseInt(next.get("id").toString()),
                        next.get("date").toString(),
                        next.get("text").toString(),
                        next.get("time").toString());
                users.add(user);
            }
        } catch (FileNotFoundException e) {
            ;
        } catch (IOException e) {
            ;
        } catch (ParseException e) {
            ;
        }
    }
}
