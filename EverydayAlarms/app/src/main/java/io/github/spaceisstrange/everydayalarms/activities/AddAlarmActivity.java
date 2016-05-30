package io.github.spaceisstrange.everydayalarms.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import io.github.spaceisstrange.everydayalarms.R;
import io.github.spaceisstrange.everydayalarms.fragments.AddAlarmFragment;
import io.github.spaceisstrange.everydayalarms.util.FragmentSwitcher;

public class AddAlarmActivity extends AppCompatActivity {
    /**
     * Views of the activity
     */
    private AddAlarmFragment mAddAlarmFragment;
    private FloatingActionButton mFabDone;

    public static final String ALARM_NAME = "createdAlarm";
    public static final int ADD_ALARM_REQUEST = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_alarm);

        // Setup the toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Switch to the AlarmFragment fragment
        mAddAlarmFragment = AddAlarmFragment.newInstance();
        FragmentSwitcher.switchTo(mAddAlarmFragment, getSupportFragmentManager());

        mFabDone = (FloatingActionButton) findViewById(R.id.fab);
        mFabDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get the alarm created and return it via intent
                Intent createdAlarmIntent = new Intent();
                createdAlarmIntent.putExtra(ALARM_NAME, mAddAlarmFragment.getAlarmCreated());
                setResult(Activity.RESULT_OK, createdAlarmIntent);
                finish();
            }
        });
    }
}
