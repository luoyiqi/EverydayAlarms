package io.github.spaceisstrange.everydayalarms.activities;

import android.app.Activity;
import android.content.Intent;
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
    private AlarmsFragment mAlarmsFragment;
    private FloatingActionButton mFabAddAlarm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarms);

        // Setup the toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Switch to the AlarmFragment fragment
        mAlarmsFragment = AlarmsFragment.newInstance();
        FragmentSwitcher.switchTo(mAlarmsFragment, getSupportFragmentManager());

        mFabAddAlarm = (FloatingActionButton) findViewById(R.id.fab);
        mFabAddAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Open the AddAlarmActivity and wait for it to return a created alarm
                Intent addAlarmIntent = new Intent(view.getContext(), AddAlarmActivity.class);
                startActivityForResult(addAlarmIntent, AddAlarmActivity.ADD_ALARM_REQUEST);
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == AddAlarmActivity.ADD_ALARM_REQUEST) {
            if (resultCode == Activity.RESULT_OK) {
                // Get the created alarm from the intent and add it to the list
                Alarm createdAlarm = (Alarm) data.getSerializableExtra(AddAlarmActivity.ALARM_NAME);
                mAlarmsFragment.addAlarm(createdAlarm);
            }
        }
    }
}
