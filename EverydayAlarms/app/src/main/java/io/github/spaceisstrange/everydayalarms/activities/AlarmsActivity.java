package io.github.spaceisstrange.everydayalarms.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.Calendar;

import io.github.spaceisstrange.everydayalarms.R;
import io.github.spaceisstrange.everydayalarms.fragments.AlarmsFragment;
import io.github.spaceisstrange.everydayalarms.model.Alarm;
import io.github.spaceisstrange.everydayalarms.util.FragmentSwitcher;

public class AlarmsActivity extends AppCompatActivity {
    /**
     * Views of the activity
     */
    private FloatingActionButton mFabAddAlarm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarms);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Switch to the AlarmFragment fragment
        final AlarmsFragment alarmsFragment = AlarmsFragment.newInstance();
        FragmentSwitcher.switchTo(alarmsFragment, getSupportFragmentManager());

        mFabAddAlarm = (FloatingActionButton) findViewById(R.id.fab);
        mFabAddAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO: Change this for a normal alarm
                alarmsFragment.addAlarm(new Alarm(1234,
                        "Hola",
                        null,
                        Calendar.getInstance(),
                        true,
                        true));
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_alarms, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
