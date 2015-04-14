package sanatshah.com.ruhours;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.lang.reflect.Method;


public class Options extends ActionBarActivity implements AdapterView.OnItemSelectedListener {

    private static final String TAG = "Options";


    private Spinner spinnerCampus;
    private Spinner spinnerGyms;
    private Spinner spinnerSport;


    ArrayAdapter<CharSequence> adapterCampus;


    private String campus;
    private String gym;
    private String sport;

    private Button searchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);


        spinnerCampus= (Spinner)findViewById(R.id.campus_options);
        ArrayAdapter<CharSequence> adapter= ArrayAdapter.createFromResource(this,R.array.campus_array,android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCampus.setAdapter(adapter);


        campus="Busch";
        gym="Sonny Werblin Recreation Center";
        sport="Fitness Center";
        campusSelected();
        sportSelect();


        spinnerCampus.setOnItemSelectedListener(this);
        spinnerGyms.setOnItemSelectedListener(this);
        spinnerSport.setOnItemSelectedListener(this);

        searchButton = (Button)findViewById(R.id.search_Button);
        searchButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v){

                Intent i = new Intent(Options.this, searchGymTimes.class);
                i.putExtra(searchGymTimes.Campus_Picked,campus);

                startActivity(i);



        }
        });








    }

    private void campusSelected(){

        spinnerGyms= (Spinner)findViewById(R.id.gym_options);
        Log.d(TAG, "In campusSelected() and campus= "+campus+"l");
        if (campus.equals("Busch")) {


            adapterCampus= ArrayAdapter.createFromResource(this, R.array.busch_gyms, android.R.layout.simple_spinner_dropdown_item);
            adapterCampus.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinnerGyms.setAdapter(adapterCampus);

        } else if(campus.equals("Livingston")) {

            adapterCampus = ArrayAdapter.createFromResource(this, R.array.livingston_gyms, android.R.layout.simple_spinner_dropdown_item);
            adapterCampus.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinnerGyms.setAdapter(adapterCampus);


        } else if(campus.equals("Cook/Douglass")){

            adapterCampus = ArrayAdapter.createFromResource(this, R.array.cook_douglass_gyms, android.R.layout.simple_spinner_dropdown_item);
            adapterCampus.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinnerGyms.setAdapter(adapterCampus);



        } else if (campus.equals("College Ave")){

            adapterCampus = ArrayAdapter.createFromResource(this, R.array.collegeave_gyms, android.R.layout.simple_spinner_dropdown_item);
            adapterCampus.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinnerGyms.setAdapter(adapterCampus);



        }



    }

    private void sportSelect(){

        spinnerSport= (Spinner)findViewById(R.id.sport_options);
        Log.d(TAG, "In campusSelected() and campus= "+campus+"l");
        if (gym.equals("Sonny Werblin Recreation Center")) {


            adapterCampus= ArrayAdapter.createFromResource(this, R.array.busch_sport, android.R.layout.simple_spinner_dropdown_item);
            adapterCampus.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinnerSport.setAdapter(adapterCampus);
        } else if(gym.equals("Livingston Recreation Center")) {

            adapterCampus = ArrayAdapter.createFromResource(this, R.array.livingston_sport, android.R.layout.simple_spinner_dropdown_item);
            adapterCampus.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinnerSport.setAdapter(adapterCampus);

        } else if(gym.equals("Cook/Douglass Recreation Center")){

            adapterCampus = ArrayAdapter.createFromResource(this, R.array.cookdouglass_sport, android.R.layout.simple_spinner_dropdown_item);
            adapterCampus.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinnerSport.setAdapter(adapterCampus);


        } else if (gym.equals("Loree Gym")){

            adapterCampus = ArrayAdapter.createFromResource(this, R.array.loree_sport, android.R.layout.simple_spinner_dropdown_item);
            adapterCampus.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinnerSport.setAdapter(adapterCampus);


        }else if (gym.equals("College Avenue Gym")){

            adapterCampus = ArrayAdapter.createFromResource(this, R.array.collegeave_sport, android.R.layout.simple_spinner_dropdown_item);
            adapterCampus.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinnerSport.setAdapter(adapterCampus);


        } else if (gym.equals("Rutgers Fitness Center (Easton Ave Gym)")){

            adapterCampus = ArrayAdapter.createFromResource(this, R.array.eastonave_sport, android.R.layout.simple_spinner_dropdown_item);
            adapterCampus.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinnerSport.setAdapter(adapterCampus);

        }


    }

    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {


       if (spinnerCampus.getId()==parent.getId()) {
           String campusSpinner = (String) parent.getItemAtPosition(pos);
           campus=campusSpinner;
           campusSelected();
       }else if (spinnerGyms.getId()==parent.getId()){
           String gymsSpinner=(String) parent.getItemAtPosition(pos);
           gym = gymsSpinner;
           sportSelect();


       } else if (spinnerSport.getId()==parent.getId()) {

           String sportSpinner=(String) parent.getItemAtPosition(pos);
           sport=sportSpinner;
       }


    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback

    }



}
