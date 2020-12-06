package com.noudzandbergen.hva.tetris;

import processing.core.PVector;

public class Util {

	public static Rectangle fit(float width, float height, float containerWidth, float containerHeight, boolean contain) {
		float ratio = width / height;
		float containerRatio = containerWidth / containerHeight;
		float targetWidth;
		float targetHeight;

		if (contain ? (ratio > containerRatio) : (ratio < containerRatio)) {
			targetWidth = containerWidth;
			targetHeight = targetWidth / ratio;
		} else {
			targetHeight = containerHeight;
			targetWidth = targetHeight * ratio;
		}

		return new Rectangle(
				(containerWidth-targetWidth)/2,
				(containerHeight-targetHeight)/2,
				targetWidth,
				targetHeight
		);
	}

	/**
	 * Method to shrink a size to match an aspect ratio
	 * @param size The dimensions that you want to shrink
	 * @param aspectRatio The target aspect ratio of size
	 */
	public static void shrink(PVector size, float aspectRatio) {
		float sizeAR = size.x / size.y;

		if (sizeAR > aspectRatio) size.x *= aspectRatio / sizeAR;
		else size.y *= sizeAR / aspectRatio;
	}

}
