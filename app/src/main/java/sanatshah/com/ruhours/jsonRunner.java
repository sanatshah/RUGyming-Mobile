package sanatshah.com.ruhours;

import android.os.AsyncTask;
import android.widget.TextView;

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
    private String campus;
    private String gym;
    private String sport;
    public String time;



    jsonParser caller;

    public jsonRunner(String campus, String gym, String sport, jsonParser caller){
        this.campus=campus;
        this.gym=gym;
        this.sport=sport;
        this.time="Error";

        this.caller=caller;

    }



    private JSONObject json;
    protected JSONObject doInBackground(URL...urls){


        try {

            String x = "https://rumobile.rutgers.edu/1/gyms.txt";
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





            //System.out.println(json.toString());


            is.close();
        }
        catch (IOException e){


        } catch (JSONException e){


        }





        return json;

    }

    protected void onPostExecute(JSONObject json){


        try {
            System.out.println(json.names());
            //String x=json.getJSONObject("Busch Campus").getJSONObject("Sonny Werblin Recreation Center").getJSONObject("meetingareas").getJSONObject("Fitness Center").getString("3/15/2015");

            JSONObject y=json.getJSONObject("Busch Campus");
            JSONObject z=y.getJSONObject("Sonny Werblin Recreation Center");
            JSONObject k=z.getJSONObject("meetingareas");
            JSONObject l=k.getJSONObject("Fitness Center");
            String p="3/16/2015";
            p.replaceAll("/","\\\\/");

            String x=l.getString(p);
            setTime(x);
            //String s=p.toString();
             System.out.println(x);


            caller.onBackgroundTaskCompleted(x);


        } catch (JSONException e){
            System.out.println("JSONException thrown");

        }

    }

    public void setTime(String time){
        this.time=time;
    }

    public String returnTime(){

        return time;
    }








}


