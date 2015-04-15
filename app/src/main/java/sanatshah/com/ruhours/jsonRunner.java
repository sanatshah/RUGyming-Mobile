package sanatshah.com.ruhours;

import android.os.AsyncTask;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;

/**
 * Created by sunny on 4/15/15.
 */
public class jsonRunner extends AsyncTask<URL, String, JSONObject> {


    private JSONObject x;
    protected JSONObject doInBackground(URL...urls){

        JSONObject json=null;
        try {

            String x = "https://graph.facebook.com/19292868552";
            InputStream is=new URL(x).openStream();
            // JSONObject json = readJsonFromUrl("https://graph.facebook.com/19292868552");


            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));

            StringBuilder sb = new StringBuilder();
            int cp;
            while ((cp = rd.read()) != -1) {
                sb.append((char) cp);
            }

            String jsonText=sb.toString();
            json = new JSONObject(jsonText);





            System.out.println(json.toString());


            is.close();
        }
        catch (IOException e){


        } catch (JSONException e){


        }





        return json;

    }

    protected void onPostExecute(JSONObject json){

        try {
            System.out.println(json.get("id"));
        } catch (JSONException e){


        }

    }







}


