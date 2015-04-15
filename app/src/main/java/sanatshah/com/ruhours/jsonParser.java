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

    public jsonParser(String campus, String gym, String sport){

       x =new jsonRunner(campus,gym,sport);


        x.execute();

    }







    public String timeOpen(){

        line=x.returnTime();

        System.out.println(x.returnTime());

        return line;
    }

}
