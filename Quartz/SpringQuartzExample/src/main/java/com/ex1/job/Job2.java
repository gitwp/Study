package com.ex1.job;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.ex1.task.SchedualTask2;

public class Job2 extends QuartzJobBean {
	private SchedualTask2 task;
	 
	public void setSchedualTask2(SchedualTask2 task) {
		this.task = task;
	}
	@Override
	protected void executeInternal(JobExecutionContext context)
			throws JobExecutionException {
		task.printMe();
	}

}
