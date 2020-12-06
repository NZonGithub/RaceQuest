package com.noudzandbergen.hva.racequest.util;

public class Ticker {

	public float time, interval;

	public Ticker(float rate) {
		this.interval = 1/rate;
	}

	public void step() {
		time += 1;
	}

	public void stepBy(float delta) {
		time += delta;
	}

	public float getInterval() {
		return interval;
	}

	public void setInterval(float interval) {
		this.interval = interval;
	}

	public float getRate() {
		return 1 / interval;
	}

	public void setRate(float rate) {
		interval = 1/rate;
	}

	public boolean poll() {
		if (time < interval) return false;
		time -= interval;
		return true;
	}

}
