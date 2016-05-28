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

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

public class ItemTouchHelperCallback extends ItemTouchHelper.SimpleCallback {
    /**
     * The adapter to be notified about the changes
     */
    private ItemTouchHelperAdapter mAdapter;

    public ItemTouchHelperCallback(int dragDirs, int swipeDirs, ItemTouchHelperAdapter adapter) {
        super(dragDirs, swipeDirs);
        mAdapter = adapter;
    }

    /**
     * Returns the default drag directions used across all the app's adapters
     *
     * @return the default directions of drag
     */
    public static int getDefaultDragDirs() {
        return ItemTouchHelper.UP | ItemTouchHelper.DOWN;
    }

    /**
     * Returns the default swipe directions used across all the app's adapters
     *
     * @return the default directions of swipes
     */
    public static int getDefaultSwipeDirs() {
        return ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT;
    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        // Move the item from the current position (viewHolder) to the target position in which is now (target)
        mAdapter.onItemMove(viewHolder.getAdapterPosition(), target.getAdapterPosition());

        return true;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
        // Remove the item that was swiped
        mAdapter.onItemSwipe(viewHolder.getAdapterPosition());
    }
}
