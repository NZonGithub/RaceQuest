//package com.noudzandbergen.hva;
//
//import processing.core.PApplet;
//import processing.core.PImage;
//
//public class AtlasPacking extends PApplet {
//
//	private PImage atlas;
//
//	@Override
//	public void settings() {
//		size(1280, 720);
//	}
//
//	@Override
//	public void setup() {
//		atlas = loadImage("res/atlas.png");
//		AtlasUtil.splitByAlpha(atlas);
//	}
//
//	public static void main(String[] args) {
//		AtlasPacking packing = new AtlasPacking();
//		runSketch(new String[]{packing.getClass().getName()}, packing);
//	}
//
//}
