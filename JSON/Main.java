package main; 
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.net.HttpURLConnection;
//import java.net.URL;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


//package HttpURLConnection;
//import java.net.*;
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




//public class Main {
//    public static void main(String[] args) throws ParseException{
//        HttpURLConnection newConnection = null;
//            try{      
//              URL url = new URL("https://fcc-weather-api.glitch.me/api/current?lat=40.6676287&lon=-111.8641045");
//              newConnection = (HttpURLConnection) url.openConnection();
//
//              BufferedReader in = new BufferedReader(new InputStreamReader(newConnection.getInputStream()));
//              String jsonString = in.readLine();
//
//              JSONParser parser_1 = new JSONParser();
//              JSONObject initialJSON = (JSONObject) parser_1.parse(jsonString);
//
//              System.out.println("Initial JSON data: \n" + jsonString + "\n");
//              
//              JSONParser parser_2 = new JSONParser();
//              JSONObject weatherDetails = (JSONObject) parser_2.parse(initialJSON.get("main").toString());
//              
//              //weather details
//              System.out.println("Get weather details:");
//              System.out.println("Temp: " + weatherDetails.get("temp"));
//              System.out.println("Temp min: " + weatherDetails.get("temp_min"));
//              System.out.println("Temp max: " + weatherDetails.get("temp_max"));
//              System.out.println("Humidity: " + weatherDetails.get("humidity"));
//              System.out.println("Pressure: " + weatherDetails.get("pressure"));
//              
//              // change weather details
//              weatherDetails.remove("temp");
//              weatherDetails.remove("temp_min");
//              weatherDetails.remove("temp_max");
//              weatherDetails.remove("humidity");
//              weatherDetails.remove("pressure");
//              
//              weatherDetails.put("temp", 10);
//              weatherDetails.put("temp_min", 1);
//              weatherDetails.put("temp_max", 20);
//              weatherDetails.put("humidity", 50);
//              weatherDetails.put("pressure", 920);              
//              
//              System.out.println("\nChange weather datails: \n" + weatherDetails);
//
//            }
//            catch (IOException e){
//                System.out.println("Status: Exception \n" + e);
//            }
//            finally{
//                if (newConnection != null) {
//                    newConnection.disconnect();
//                }
//            }
//    }
//    
//}
    



