package com.noudzandbergen.hva.layout;

import processing.core.PVector;

import java.util.ArrayList;

public abstract class MultiChildWidget extends Widget {
	protected ArrayList<Widget> children;

	public MultiChildWidget(ArrayList<Widget> children) {
		this.children = children;
	}
}
