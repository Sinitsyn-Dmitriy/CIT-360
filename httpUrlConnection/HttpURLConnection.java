package HttpURLConnection;
import java.net.*;
import java.io.*;



/**
 *
 * @author dmitriysinitsyn
 */

public class Main {
    public static void main(String[] args) throws Exception{
        try{
            URL myUrl = new URL("http://www.byui.edu");
            HttpURLConnection conn = (HttpURLConnection) 
            myUrl.openConnection();

            System.out.println("Response: " +
                                        conn.getContentType());

            if(conn.getContentType() != null){
                        System.out.println("You connected!");

            }
            else{
                System.out.println("Connection failed");
            }
        }
        catch(IOException e)
        {
            System.err.format("error: \n", e);
        }
    }
}
    



