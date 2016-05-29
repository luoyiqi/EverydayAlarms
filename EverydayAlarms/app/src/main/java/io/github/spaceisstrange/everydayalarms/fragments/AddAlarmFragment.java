package io.github.spaceisstrange.everydayalarms.fragments;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

import io.github.spaceisstrange.everydayalarms.R;
import io.github.spaceisstrange.everydayalarms.dialogs.HourPickerDialog;
import io.github.spaceisstrange.everydayalarms.model.Alarm;
import io.github.spaceisstrange.everydayalarms.model.enums.Day;
import io.github.spaceisstrange.everydayalarms.util.AlarmUtils;

/**
 * A placeholder fragment containing a simple view.
 */
public class AddAlarmFragment extends Fragment implements TimePickerDialog.OnTimeSetListener {
    /**
     * The selected hour of the alarm
     */
    private int mAlarmHour;
    /**
     * The selected minute of the alarm
     */
    private int mAlarmMinute;
    /**
     * Views of the fragment
     */
    private LinearLayout mBtnAlarmTime;
    private LinearLayout mBtnAlarmRepetition;
    private LinearLayout mBtnAlarmMusic;
    private LinearLayout mBtnAlarmVibration;
    private Switch mSwAlarmVibration;
    private SeekBar mSbAlarmSound;
    private TextView mTvAlarmTime;

    /**
     * The tag of the dialogs to be shown
     */
    public static final String HOUR_PICKER_TAG = "hourPicker";

    public static AddAlarmFragment newInstance() {
        AddAlarmFragment alarmFragment = new AddAlarmFragment();
        alarmFragment.setAlarmTimeToNow();
        return alarmFragment;
    }

    /*
    METHODS
     */

    /**
     * Creates the alarm based on the selected preferences from the user
     *
     * @return a new alarm based on what the user selected
     */
    public Alarm getAlarmCreated() {
        // TODO: Create a real alarm here
        return new Alarm(0, Day.FRIDAY, mAlarmHour, mAlarmMinute, true, false, 100);
    }

    /**
     * Sets the current alarm time to right now
     */
    public void setAlarmTimeToNow() {
        Calendar calendar = Calendar.getInstance();
        mAlarmHour = calendar.get(Calendar.HOUR_OF_DAY);
        mAlarmMinute = calendar.get(Calendar.MINUTE);
    }

    /**
     * Updates the current time of the alarm
     */
    public void updateAlarmTime() {
        mTvAlarmTime.setText(getString(R.string.add_alarm_time_format, mAlarmHour, AlarmUtils.formatMinutes(mAlarmMinute)));
    }

    /*
    OVERRIDES
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_add_alarm, container, false);

        // Setup the LinearLayouts (buttons)
        mBtnAlarmTime = (LinearLayout) v.findViewById(R.id.fragment_add_alarm_btn_alarm_time);
        mBtnAlarmRepetition = (LinearLayout) v.findViewById(R.id.fragment_add_alarm_btn_alarm_repetition);
        mBtnAlarmMusic = (LinearLayout) v.findViewById(R.id.fragment_add_alarm_btn_alarm_music);
        mBtnAlarmVibration = (LinearLayout) v.findViewById(R.id.fragment_add_alarm_btn_alarm_vibration);
        mSwAlarmVibration = (Switch) v.findViewById(R.id.fragment_add_alarm_sw_alarm_vibration);
        mSbAlarmSound = (SeekBar) v.findViewById(R.id.fragment_add_alarm_sb_alarm_volume);
        mTvAlarmTime = (TextView) v.findViewById(R.id.fragment_add_alarm_tv_alarm_time);

        // Update the current time of the alarm time text view
        updateAlarmTime();

        // TODO: Set the action for every button

        // Set the action of the alarm time button
        mBtnAlarmTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HourPickerDialog.newInstance(AddAlarmFragment.this).show(getFragmentManager(), HOUR_PICKER_TAG);
            }
        });

        return v;
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        mAlarmHour = hourOfDay;
        mAlarmMinute = minute;
        updateAlarmTime();
    }
}
