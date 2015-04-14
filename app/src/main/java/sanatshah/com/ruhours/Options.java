package sanatshah.com.ruhours;

import android.content.res.Resources;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.lang.reflect.Method;


public class Options extends ActionBarActivity implements AdapterView.OnItemSelectedListener {

    private static final String TAG = "Options";
    private Spinner spinner;
    private Spinner spinner1;
    private Spinner spinner2;
    ArrayAdapter<CharSequence> adapterCampus;
    private String campus;
    private String gym;
    private  String[] x;
    private Method method;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);


        spinner= (Spinner)findViewById(R.id.campus_options);
        ArrayAdapter<CharSequence> adapter= ArrayAdapter.createFromResource(this,R.array.campus_array,android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);





    }

    private void campusSelected(){

        spinner1= (Spinner)findViewById(R.id.gym_options);
        Log.d(TAG, "In campusSelected() and campus= "+campus+"l");
        if (campus.equals("Busch")) {


            adapterCampus= ArrayAdapter.createFromResource(this, R.array.busch_gyms, android.R.layout.simple_spinner_dropdown_item);
            adapterCampus.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner1.setAdapter(adapterCampus);
            sportSelect();
        } else if(campus.equals("Livingston")) {

            adapterCampus = ArrayAdapter.createFromResource(this, R.array.livingston_gyms, android.R.layout.simple_spinner_dropdown_item);
            adapterCampus.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner1.setAdapter(adapterCampus);
            sportSelect();

        } else if(campus.equals("Cook/Douglass")){

            adapterCampus = ArrayAdapter.createFromResource(this, R.array.cook_douglass_gyms, android.R.layout.simple_spinner_dropdown_item);
            adapterCampus.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner1.setAdapter(adapterCampus);
            sportSelect();


        } else if (campus.equals("College Ave")){

            adapterCampus = ArrayAdapter.createFromResource(this, R.array.collegeave_gyms, android.R.layout.simple_spinner_dropdown_item);
            adapterCampus.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner1.setAdapter(adapterCampus);
            sportSelect();


        }



    }

    private void sportSelect(){

        spinner2= (Spinner)findViewById(R.id.sport_options);
        Log.d(TAG, "In campusSelected() and campus= "+campus+"l");
        if (campus.equals("Busch")) {


            adapterCampus= ArrayAdapter.createFromResource(this, R.array.busch_sport, android.R.layout.simple_spinner_dropdown_item);
            adapterCampus.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner2.setAdapter(adapterCampus);
        } else if(campus.equals("Livingston")) {

            adapterCampus = ArrayAdapter.createFromResource(this, R.array.livingston_gyms, android.R.layout.simple_spinner_dropdown_item);
            adapterCampus.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner2.setAdapter(adapterCampus);

        } else if(campus.equals("Cook/Douglass")){

            adapterCampus = ArrayAdapter.createFromResource(this, R.array.cook_douglass_gyms, android.R.layout.simple_spinner_dropdown_item);
            adapterCampus.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner2.setAdapter(adapterCampus);


        } else if (campus.equals("College Ave")){

            adapterCampus = ArrayAdapter.createFromResource(this, R.array.collegeave_gyms, android.R.layout.simple_spinner_dropdown_item);
            adapterCampus.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner2.setAdapter(adapterCampus);


        }


    }

    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {


       if (spinner.getId()==parent.getId()) {
           //campus spinner

           String campusSpinner = (String) parent.getItemAtPosition(pos);
           campus=campusSpinner;


           campusSelected();

       }


    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback

    }



}
