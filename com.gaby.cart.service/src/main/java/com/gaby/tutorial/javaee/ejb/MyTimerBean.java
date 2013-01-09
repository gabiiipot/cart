package com.gaby.tutorial.javaee.ejb;

import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerService;

@Stateless(mappedName="timer")
public class MyTimerBean implements MyTimer {
	
	private static final Logger logger = Logger.getLogger(MyTimer.class.getName());

	@Resource
	TimerService timerService;
	
	public void createTimer(long intervalDuration) {
		timerService.createTimer(intervalDuration, "Created new timer");
	}

	@Timeout
	public void timeout(Timer timer) {
		logger.info("Timeout occurred");
	}
}
