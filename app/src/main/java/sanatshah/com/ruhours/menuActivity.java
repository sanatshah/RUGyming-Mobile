package sanatshah.com.ruhours;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class menuActivity extends ActionBarActivity {

    private Button mGym;
    private Button mLib;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        mGym=(Button)findViewById(R.id.gym_Button);

        mGym.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent i = new Intent(menuActivity.this, Options.class);
                startActivity(i);
            }
        });

    }



}
