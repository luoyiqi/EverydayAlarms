package io.github.spaceisstrange.everydayalarms.fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.Switch;

import java.util.Calendar;

import io.github.spaceisstrange.everydayalarms.R;
import io.github.spaceisstrange.everydayalarms.model.Alarm;
import io.github.spaceisstrange.everydayalarms.model.enums.Day;

/**
 * A placeholder fragment containing a simple view.
 */
public class AddAlarmFragment extends Fragment {

    /**
     * Views of the fragment
     */
    private LinearLayout mBtnAlarmTime;
    private LinearLayout mBtnAlarmRepetition;
    private LinearLayout mBtnAlarmMusic;
    private LinearLayout mBtnAlarmVibration;
    private Switch mSwAlarmVibration;
    private SeekBar mSbAlarmSound;

    public static AddAlarmFragment newInstance() {
        return new AddAlarmFragment();
    }

    /**
     * Creates the alarm based on the selected preferences from the user
     *
     * @return a new alarm based on what the user selected
     */
    public Alarm getAlarmCreated() {
        // TODO: Create a real alarm here
        return new Alarm(0, Day.FRIDAY, Calendar.getInstance(), true, true, 90);
    }

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

        // TODO: Set the action for every button

        return v;
    }
}
