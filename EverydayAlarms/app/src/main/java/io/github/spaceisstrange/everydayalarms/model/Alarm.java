package io.github.spaceisstrange.everydayalarms.model;

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

import java.io.Serializable;
import java.util.Calendar;

import io.github.spaceisstrange.everydayalarms.model.enums.Day;

public class Alarm implements Serializable {
    /**
     * The id of the alarm
     */
    private int mId;
    /**
     * The day of the alarm
     */
    private Day mDay;
    /**
     * The time of the alarm
     */
    private Calendar mTime;
    /**
     * Indicates whether the alarm is active or not
     */
    private boolean mActive;
    /**
     * Indicates whether the alarm will vibrate or not
     */
    private boolean mVibrationOn;
    /**
     * Indicates the volume of the alarm, between 0 and 100
     */
    private int mVolume;

    public Alarm(int id, Day day, Calendar time, boolean active, boolean vibrationOn, int volume) {
        mId = id;
        mDay = day;
        mTime = time;
        mActive = active;
        mVibrationOn = vibrationOn;
        mVolume = volume;
    }

    /*
    SETTERS
     */
    public void setId(int id) {
        mId = id;
    }

    public void setDay(Day day) {
        mDay = day;
    }

    public void setTime(Calendar time) {
        mTime = time;
    }

    public void setActive(boolean active) {
        mActive = active;
    }

    public void setVibrationOn(boolean vibrationOn) {
        mVibrationOn = vibrationOn;
    }

    public void setVolume(int volume) {
        mVolume = volume;
    }

    /*
    GETTERS
     */
    public int getId() {
        return mId;
    }

    public Day getDay() {
        return mDay;
    }

    public String getHourString() {
        String time = String.valueOf(mTime.get(Calendar.HOUR_OF_DAY));
        time += ":";
        time += String.valueOf(mTime.get(Calendar.MINUTE));
        return time;
    }

    public Calendar getTime() {
        return mTime;
    }

    public boolean isActive() {
        return mActive;
    }

    public boolean isVibrationOn() {
        return mVibrationOn;
    }

    public int getVolume() {
        return mVolume;
    }
}
