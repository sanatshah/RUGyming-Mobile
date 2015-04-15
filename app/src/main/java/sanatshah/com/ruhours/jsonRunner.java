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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


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

         if((campus.equals("Busch")) || (campus.equals("Livingston"))) {
             JSONObject y = json.getJSONObject(campus + " Campus");
             JSONObject z = y.getJSONObject(gym);
             JSONObject k = z.getJSONObject("meetingareas");
             JSONObject l = k.getJSONObject(sport);

             DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
             Date date = new Date();
             String p = dateFormat.format(date);
             System.out.println(dateFormat.format(date));

             if (p.charAt(4) == '0') {

                 p = p.substring(0, 3) + p.substring(5, p.length());
             }

             if (p.charAt(0) == '0') {
                 p = p.substring(1, p.length());
             }

             System.out.println(p);
             p.replaceAll("/", "\\\\/");


             String x = l.getString(p);
             setTime(x);
             //String s=p.toString();
             System.out.println(x);


             caller.onBackgroundTaskCompleted(x);

         } else if (campus.equals("College Avenue")){

             JSONObject y = json.getJSONObject(campus + " Campus");

             JSONObject l= null;
             JSONObject z=null;

             if (gym.equals("Rutgers Fitness Center (Easton Ave Gym)")) {
                 z = y.getJSONObject(gym);
                 JSONObject k = z.getJSONObject("meetingareas");
                  l= k.getJSONObject("Hours");

             } else if (gym.equals("College Avenue Gym")) {

                     z = y.getJSONObject(gym);



                 JSONObject k = z.getJSONObject("meetingareas");

                 if (sport.equals("Main Gym")) {
                     sport=sport+" ";
                     l = k.getJSONObject(sport);
                 } else {
                     l = k.getJSONObject(sport);
                 }
             }

             DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
             Date date = new Date();
             String p = dateFormat.format(date);
             System.out.println(dateFormat.format(date));

             if (p.charAt(4) == '0') {

                 p = p.substring(0, 3) + p.substring(5, p.length());
             }

             if (p.charAt(0) == '0') {
                 p = p.substring(1, p.length());
             }

             System.out.println(p);
             p.replaceAll("/", "\\\\/");


             String x = l.getString(p);
             setTime(x);
             //String s=p.toString();
             System.out.println(x);


             caller.onBackgroundTaskCompleted(x);


             System.out.println("In CAC");


         } else {
             if (campus.equals("Cook/Douglass")) {
                 JSONObject y = json.getJSONObject(campus + " Campus");
                 JSONObject z = null;
                 JSONObject l = null;
                 if (gym.equals("Cook/Douglass Recreation Center")) {
                     z = y.getJSONObject(gym);
                     JSONObject k = z.getJSONObject("meetingareas");

                     if ((sport.equals("Fitness Center") || (sport.equals("Gym Annex") || (sport.equals("Racquet Sports"))))) {
                         sport = sport + " ";
                     }
                     l = k.getJSONObject(sport);

                 } else {

                     throw new JSONException("Error");


                 }


                 DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
                 Date date = new Date();
                 String p = dateFormat.format(date);
                 System.out.println(dateFormat.format(date));

                 if (p.charAt(4) == '0') {

                     p = p.substring(0, 3) + p.substring(5, p.length());
                 }

                 if (p.charAt(0) == '0') {
                     p = p.substring(1, p.length());
                 }

                 System.out.println(p);
                 p.replaceAll("/", "\\\\/");


                 String x = l.getString(p);
                 setTime(x);
                 //String s=p.toString();
                 System.out.println(x);


                 caller.onBackgroundTaskCompleted(x);


             }
         }


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


