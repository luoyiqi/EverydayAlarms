package io.github.spaceisstrange.everydayalarms.adapters.helpers;

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

public interface ItemTouchHelperAdapter {
    /**
     * This will be called whenever an item is moved in a list. Notice that this will be called
     * whenever an item changes fromPosition toPosition and not when the user drops the item
     *
     * @param fromPosition in which the item was taken
     * @param toPosition in which the item was moved
     */
    void onItemMove(int fromPosition, int toPosition);

    /**
     * This will be called whenever an item is "swiped" like a notification
     *
     * @param position of the item that has been swiped
     */
    void onItemSwipe(int position);
}
