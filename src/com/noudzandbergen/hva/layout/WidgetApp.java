package com.noudzandbergen.hva.layout;

import processing.core.PApplet;

public class WidgetApp extends PApplet {

	private Widget widget;
	private Context context = new Context(this);

	public WidgetApp(Widget widget) {
		this.widget = widget;
	}

	@Override
	public void draw() {
//		widget.fit(context, );
	}

	public static void wrap(Widget widget) {
		WidgetApp app = new WidgetApp(widget);
		runSketch(new String[]{app.getClass().getName()}, app);
	}

}
