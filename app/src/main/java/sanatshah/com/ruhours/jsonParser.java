package sanatshah.com.ruhours;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

/**
 * Created by sunny on 4/15/15.
 */
public class jsonParser {

    ArrayList<String> listItems;

    public jsonParser(String campus, String gym, String sport){





    }


    public ArrayList<String> fetchTwitterPublicTimeline() {


        listItems = new ArrayList<String>();

        try {
            URL gyms = new URL(
                    "https://rumobile.rutgers.edu/1/gyms.txt");
            URLConnection tc = gyms.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(tc
                    .getInputStream()));

            String line;
            while ((line = in.readLine()) != null) {
                JSONArray ja = new JSONArray(line);
               // System.out.println(line);
                for (int i = 0; i < ja.length(); i++) {
                    JSONObject jo = (JSONObject) ja.get(i);
                    listItems.add(jo.getString("text"));
                }
            }
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block e.printStackTrace(); } catch
        } catch (IOException e) { // TODO Auto-generated catch block
            // e.printStackTrace();
        } catch (JSONException e) { // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return listItems;
    }



    public String timeOpen(){



        return listItems.get(0);
    }

}
