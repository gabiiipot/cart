package com.gaby.tutorial.javaee.ejb;

import javax.ejb.Remote;
import javax.ejb.Timer;

@Remote
public interface MyTimer {

	public void createTimer(long intervalDuration);
	
	public void timeout(Timer timer);
}
