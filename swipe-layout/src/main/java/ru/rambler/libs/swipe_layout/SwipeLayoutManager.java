package ru.rambler.libs.swipe_layout;

import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


public class SwipeLayoutManager
{
	private Map<String, WeakReference<SwipeLayout>> layouts = Collections.synchronizedMap(new HashMap<String, WeakReference<SwipeLayout>>());

	private final Object syncObject = new Object();

	private boolean openOnlyOne;

	public SwipeLayoutManager()
	{
		this(false);
	}

	public SwipeLayoutManager(boolean openOnlyOne)
	{
		this.openOnlyOne = openOnlyOne;
	}

	public void bind(SwipeLayout swipeLayout, String id)
	{
		layouts.put(id, new WeakReference<>(swipeLayout));

		swipeLayout.setOnSwipeListener(new SwipeLayout.SimpleSwipeListener() {
			@Override
			public void onBeginSwipe(SwipeLayout swipeLayout, boolean moveToRight)
			{
				if (openOnlyOne)
					closeOthers(swipeLayout, true);
			}
		});
	}

	public void closeAll(boolean animate)
	{
		synchronized (syncObject)
		{
			for (WeakReference<SwipeLayout> layoutRef: layouts.values())
			{
				SwipeLayout layout = layoutRef.get();
				if (layout != null)
					reset(layout, animate);
			}
		}
	}

	public void closeLayout(SwipeLayout layout, boolean animate)
	{
		synchronized (syncObject)
		{
			reset(layout, animate);
		}
	}

	public void closeLayout(String id, boolean animate)
	{
		synchronized (syncObject)
		{
		WeakReference<SwipeLayout> layoutRef = layouts.get(id);
			if (layoutRef != null)
			{
				SwipeLayout layout = layoutRef.get();
				if (layout != null)
					reset(layout, animate);
			}
		}
	}

	public void closeOthers(SwipeLayout excludedLayout, boolean animate)
	{
		synchronized (syncObject)
		{
			for (WeakReference<SwipeLayout> layoutRef: layouts.values())
			{
				SwipeLayout layout = layoutRef.get();
				if (layout != excludedLayout)
					reset(layout, animate);
			}
		}
	}

	private void reset(SwipeLayout layoutToClose, boolean animate)
	{
		if (animate) layoutToClose.animateReset();
		else layoutToClose.reset();
	}

	public void setOpenOnlyOne(boolean openOnlyOne)
	{
		this.openOnlyOne = openOnlyOne;
	}

	public boolean isOpenOnlyOne()
	{
		return openOnlyOne;
	}
}
