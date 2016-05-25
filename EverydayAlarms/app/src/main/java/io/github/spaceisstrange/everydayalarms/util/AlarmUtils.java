package io.github.spaceisstrange.everydayalarms.util;

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

public class AlarmUtils {
    /**
     * Returns the days from the millis specified
     *
     * @param alarmTime in milliseconds
     * @return the number of days in the specified millis
     */
    public static long getDaysFromMillis(long alarmTime) {
        return alarmTime / (1000 * 60 * 60 * 24);
    }

    /**
     * Returns the hours from the millis specified
     *
     * @param alarmTime in milliseconds
     * @return the number of hours in the specified millis
     */
    public static long getHoursFromMillis(long alarmTime) {
        long days = getDaysFromMillis(alarmTime);
        return alarmTime / (1000 * 60 * 60) - (days * 24);
    }

    /**
     * Returns the minutes from the millis specified
     *
     * @param alarmTime in milliseconds
     * @return the number of minutes in the specified millis
     */
    public static long getMinutesFromMillis(long alarmTime) {
        long days = getDaysFromMillis(alarmTime);
        long hours = getHoursFromMillis(alarmTime);
        return alarmTime / (1000 * 60) - (days * 24 * 60) - (hours * 60);
    }

    /**
     * Returns the seconds from the millis specified
     *
     * @param alarmTime in milliseconds
     * @return the number of seconds in the specified millis
     */
    public static long getSecondsFromMillis(long alarmTime) {
        long days = getDaysFromMillis(alarmTime);
        long hours = getHoursFromMillis(alarmTime);
        long minutes = getMinutesFromMillis(alarmTime);
        return alarmTime / (1000) - (days * 24 * 60 * 60) - (hours * 60 * 60) - (minutes * 60);
    }
}
