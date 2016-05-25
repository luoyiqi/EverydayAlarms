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

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import io.github.spaceisstrange.everydayalarms.R;

public class FragmentSwitcher {
    /**
     * Switch to the next specified fragment
     *
     * @param fragment to switch to
     * @param fragmentManager to perform the transaction
     */
    public static void switchTo(Fragment fragment, FragmentManager fragmentManager) {
        // Begin the transaction into the new fragment
        fragmentManager.beginTransaction()
                .replace(R.id.fragment, fragment)
                .commit();
    }
}
