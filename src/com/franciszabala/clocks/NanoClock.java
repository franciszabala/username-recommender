package com.franciszabala.clocks;

public class NanoClock implements IClock {
	
	private long startTime = 0;
	private long stopTime  = 0;

	@Override
	public long startClock() {
		// TODO Auto-generated method stub
		startTime = System.nanoTime();
		return startTime;
	}

	@Override
	public long stopClock() {
		// TODO Auto-generated method stub
		stopTime = System.nanoTime();
		return stopTime - startTime;
	}

}
