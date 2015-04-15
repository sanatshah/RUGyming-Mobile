package sanatshah.com.ruhours;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class searchGymTimes extends ActionBarActivity {

    public static final String Campus_Picked =
            "com.sanatshah.sunny.ruhours.picked_campus";
    public static final String Gym_Picked =
            "com.sanatshah.sunny.ruhours.picked_gym";
    public static final String Sport_picked =
            "com.sanatshah.sunny.ruhours.picked_sport";

    private String campus;
    private String gym;
    private String sport;


    private TextView test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_gym_times);


        campus = getIntent().getStringExtra(Campus_Picked);
        gym = getIntent().getStringExtra(Gym_Picked);
        sport = getIntent().getStringExtra(Sport_picked);
        
        test=(TextView)findViewById(R.id.Test);


        jsonParser search=new jsonParser(campus,gym,sport);

        test.setText(search.timeOpen());





    }



}
