package com.franciszabala.clocks;

public class MiliClock implements IClock{
	
	private long startTime = 0;
	private long stopTime  = 0;

	@Override
	public long startClock() {
		// TODO Auto-generated method stub
		startTime = System.currentTimeMillis();
		return startTime;
	}

	@Override
	public long stopClock() {
		// TODO Auto-generated method stub
		stopTime = System.currentTimeMillis();
		return stopTime - startTime;
	}

}
