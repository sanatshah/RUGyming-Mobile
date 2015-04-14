package sanatshah.com.ruhours;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class searchGymTimes extends ActionBarActivity {

    public static final String Campus_Picked =
            "com.sanatshah.sunny.ruhours.picked_campus";

    private String campus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_gym_times);


        campus = getIntent().getStringExtra(campus);

        

    }



}
