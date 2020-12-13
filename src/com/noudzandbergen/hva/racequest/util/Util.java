package com.noudzandbergen.hva.racequest.util;

import java.util.List;
import java.util.function.Supplier;

public class Util {

	public static <T> T getRandomItem(List<T> list) {
		return list.get((int) (Math.random() * list.size()));
	}

	public static <T> T getRandomItem(T[] list) {
		return list[(int) (Math.random() * list.length)];
	}

	public static <T> T tryOr(Supplier<T> supplier, T alt) {
		try {
			return supplier.get();
		} catch (Throwable err) {
			return alt;
		}
	}

}
