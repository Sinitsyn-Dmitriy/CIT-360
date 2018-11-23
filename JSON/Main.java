package main; 
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.*;



/**
 *
 * @author dmitriysinitsyn
 */

public class Main {
    public static void main(String[] args){
        try {
            JSONParser userParser = new JSONParser();
            JSONObject userJson = (JSONObject) userParser.parse(new FileReader("src/main/user.json"));
            
            System.out.println("User JSON: \n" + userJson + "\n");
            
            userJson.put("class", "CIT 360");
            
            System.out.println("Modified User JSON: \n" + userJson);
            
        } 
        catch (IOException | ParseException e) {
        }
    }
}


