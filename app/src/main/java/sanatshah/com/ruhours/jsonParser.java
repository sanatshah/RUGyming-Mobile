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
class jsonParser  {


    public String line;
    jsonRunner x;
    searchGymTimes curr;

    public jsonParser(String campus, String gym, String sport, searchGymTimes curr){
        this.curr=curr;
       x =new jsonRunner(campus,gym,sport, this);


        x.execute();


    }

    public String onBackgroundTaskCompleted(String x){

        line=x;
        System.out.println(line);
        curr.testSetter(line);
        return line;

    }







    public String timeOpen(){

        System.out.println("timOpen"+line);

        return line;
    }

}
