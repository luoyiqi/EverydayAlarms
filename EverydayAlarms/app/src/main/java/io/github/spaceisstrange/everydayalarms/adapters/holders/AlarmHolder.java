package io.github.spaceisstrange.everydayalarms.adapters.holders;

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
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;

import io.github.spaceisstrange.everydayalarms.R;
import io.github.spaceisstrange.everydayalarms.model.Alarm;

public class AlarmHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    /**
     * The alarm that we are binding into the holder
     */
    private Alarm mAlarm;
    /**
     * Views of the holder
     */
    private TextView mTvAlarmTime;
    private Switch mSwAlarmActive;

    public AlarmHolder(View itemView) {
        super(itemView);

        // Setup the views
        mTvAlarmTime = (TextView) itemView.findViewById(R.id.list_item_alarm_tv_alarm_time);
        mSwAlarmActive = (Switch) itemView.findViewById(R.id.list_item_alarm_sw_alarm_state);
    }

    public void bindAlarm(Alarm alarm) {
        mAlarm = alarm;

        // Set the hour of the alarm
        mTvAlarmTime.setText(mAlarm.getHourString());
        mSwAlarmActive.setChecked(mAlarm.isActive());
    }

    @Override
    public void onClick(View v) {
        // TODO: Complete the onClick method
    }
}
