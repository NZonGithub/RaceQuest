package com.noudzandbergen.hva.racequest.util;

import processing.core.PImage;

import java.util.ArrayList;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class AtlasUtil {

	public static ArrayList<PImage> getSprites(PImage atlas, ArrayList<ImageBounds> bounds) {

		return bounds.stream()
				.map(bound -> atlas.get(bound.x, bound.y, bound.width, bound.height))
				.collect(Collectors.toCollection(ArrayList::new));
	}

	public static ArrayList<ImageBounds> generateBounds(int startX, int startY, int endX, int endY, int stepX, int stepY, int w, int h) {

		ArrayList<ImageBounds> bounds = new ArrayList<>();
		for (int y = startY; y < endY; y += stepY) {
			for (int x = startX; x < endX; x += stepX) {
				bounds.add(new ImageBounds(x, y, w, h));
			}
		}
		return bounds;
	}

	public static class ImageBounds {

		public int x, y, width, height;

		public ImageBounds(int x, int y, int width, int height) {
			this.x = x;
			this.y = y;
			this.width = width;
			this.height = height;
		}

		@Override
		public String toString() {
			return new StringJoiner(", ", ImageBounds.class.getSimpleName() + "[", "]")
					.add("x=" + x)
					.add("y=" + y)
					.add("w=" + width)
					.add("h=" + height)
					.toString();
		}
	}

//	public static ArrayList<PImage> splitByAlpha(PImage img) {
//
//		img.loadPixels();
//		img = img.copy();
//
//		PImage tar = new PImage(img.width, img.height, img.format);
//
//		int continueIndex;
//
//		ArrayList<PImage> sprites = new ArrayList<>();
//
//		for (int i = 0; i < img.pixels.length; i++) {
//			int c = img.pixels[i];
//			int alpha = c >>> 24;
//			if (alpha > 127) {
//				sprites.add(selectNonAlpha(img, i));
//			}
//		}
//	}
//
//
//	public static PImage selectNonAlpha(PImage src, int index) {
//		// TODO: replace flood-fill with some sort of line-fill for efficiency.
//		//  Line fill is however a lot harder to implement, especially if it's supposed to go 8 ways
//
//	}

}
