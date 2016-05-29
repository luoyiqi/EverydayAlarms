package io.github.spaceisstrange.everydayalarms.adapters;

/*
 * Made with <3 by Fran González (spaceisstrange)
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 3
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import io.github.spaceisstrange.everydayalarms.R;
import io.github.spaceisstrange.everydayalarms.adapters.helpers.ItemTouchHelperAdapter;
import io.github.spaceisstrange.everydayalarms.adapters.holders.AlarmHolder;
import io.github.spaceisstrange.everydayalarms.model.Alarm;

public class AlarmsAdapter extends RecyclerView.Adapter<AlarmHolder>
                           implements ItemTouchHelperAdapter {
    /**
     * List of alarms
     */
    List<Alarm> mAlarms;

    public AlarmsAdapter() {
        mAlarms = new ArrayList<>();
    }

    /**
     * Adds an alarm into the list of alarms
     *
     * @param alarm to add to the list
     */
    public void addAlarm(Alarm alarm) {
        mAlarms.add(alarm);
        notifyItemInserted(mAlarms.size() - 1);
    }

    /**
     * Removes an alarm from the list
     *
     * @param position of the alarm to remove
     */
    public void removeAlarm(int position) {
        mAlarms.remove(position);
        notifyItemRemoved(position);
    }

    /**
     * Removes an alarm from the list given the alarm itself
     *
     * @param alarm to be removed from the list
     */
    public void removeAlarm(Alarm alarm) {
        int position = mAlarms.indexOf(alarm);
        removeAlarm(position);
    }

    /*
    IMPLEMENTATIONS
     */
    @Override
    public AlarmHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        // Inflate the view and return a holder from it
        View v = inflater.inflate(R.layout.list_item_alarm, parent, false);
        return new AlarmHolder(v);
    }

    @Override
    public void onBindViewHolder(AlarmHolder holder, int position) {
        holder.bindAlarm(mAlarms.get(position));
    }

    @Override
    public int getItemCount() {
        return mAlarms.size();
    }

    @Override
    public void onItemMove(int fromPosition, int toPosition) {
        // Swap the elements to accommodate the change of the item and notify the change to the adapter
        Collections.swap(mAlarms, fromPosition, toPosition);
        notifyItemMoved(fromPosition, toPosition);
    }

    @Override
    public void onItemSwipe(int position) {
        removeAlarm(position);
    }
}
