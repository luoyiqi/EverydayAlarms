package io.github.spaceisstrange.everydayalarms.fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import io.github.spaceisstrange.everydayalarms.R;
import io.github.spaceisstrange.everydayalarms.adapters.AlarmsAdapter;
import io.github.spaceisstrange.everydayalarms.adapters.helpers.ItemTouchHelperCallback;
import io.github.spaceisstrange.everydayalarms.model.Alarm;

/**
 * A placeholder fragment containing a simple view.
 */
public class AlarmsFragment extends Fragment {
    /**
     * The adapter of the recycler view
     */
    private AlarmsAdapter mAlarmsAdapter;
    /**
     * Views of the fragment
     */
    private RecyclerView mRvAlarmList;

    public static AlarmsFragment newInstance() {
        return new AlarmsFragment();
    }

    /*
    SETTERS
     */
    public void addAlarm(Alarm alarm) {
        mAlarmsAdapter.addAlarm(alarm);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_alarms, container, false);

        // Setup the recycler view
        mRvAlarmList = (RecyclerView) v.findViewById(R.id.fragment_alarms_rv_alarm_list);
        mAlarmsAdapter = new AlarmsAdapter();
        mRvAlarmList.setAdapter(mAlarmsAdapter);
        mRvAlarmList.setLayoutManager(new LinearLayoutManager(getActivity()));

        // Create a callback to be used by the touch helper
        ItemTouchHelper.Callback callback = new ItemTouchHelperCallback(
                ItemTouchHelperCallback.getDefaultDragDirs(),
                ItemTouchHelperCallback.getDefaultSwipeDirs(),
                mAlarmsAdapter
        );

        // Attach the touch helper to the Recycler View
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(callback);
        itemTouchHelper.attachToRecyclerView(mRvAlarmList);

        return v;
    }
}
