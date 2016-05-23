package io.github.spaceisstrange.everydayalarms.fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import io.github.spaceisstrange.everydayalarms.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class AlarmsFragment extends Fragment {

    public AlarmsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_alarms, container, false);
    }
}
