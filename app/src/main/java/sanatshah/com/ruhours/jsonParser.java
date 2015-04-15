package sanatshah.com.ruhours;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.ArrayList;

/**
 * Created by sunny on 4/15/15.
 */
class jsonParser extends AsyncTask<URL, Void, String> {


    String line;


    public jsonParser(String campus, String gym, String sport){



        doInBackground();


    }

    protected String doInBackground(URL...urls){

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


        onPostExecute(json);

        return "Success";

    }


    protected void  onPostExecute(JSONObject j){

        try {
            line = j.get("id").toString();
        } catch (JSONException e){


        }

    }






    public String timeOpen(){



        return line;
    }

}
