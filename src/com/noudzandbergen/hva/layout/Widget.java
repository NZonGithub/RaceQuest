package com.noudzandbergen.hva.layout;

import processing.core.PGraphics;
import processing.core.PVector;

public class Widget {

//	public PVector fit(Context context, PVector sizeAvailable) {
//		return sizeAvailable;
//	}

	PVector minSize = new PVector();

	void calcMinSize() {

	}

	public PVector getMinimumSize() {
		return minSize;
	}

	public void draw(Context context, PGraphics g) {

	}

//	public static class Placed {
//
//		private final Widget widget;
//		private final PVector size;
//
//		public Placed(Widget widget, PVector size) {
//			this.widget = widget;
//			this.size = size;
//		}
//
//		public Widget getWidget() {
//			return widget;
//		}
//
//		public PVector getSize() {
//			return size;
//		}
//	}
}
