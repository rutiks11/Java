package com.app.taskmanager;

import java.time.LocalDate;

public class TaskManager {
// taskId, taskName, description, taskDate, status, active.
	private static int idgenerated;
	private int taskid;
	private String taskname;
	private String description;
	private LocalDate date;
	private Status status;
	private boolean active;
	
	public TaskManager(String taskname, String description, LocalDate date) {
		super();
		this.taskid = ++idgenerated;
		this.taskname = taskname;
		this.description = description;
		this.date = date;
		this.status = Status.PROGRESS;
		this.active = true;
	}

	static 
	{
		idgenerated =0;
	}
	
	public String getTaskname() {
		return taskname;
	}

	public void setTaskname(String taskname) {
		this.taskname = taskname;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public boolean equals()
	{
		return false;
	}
	@Override
	public String toString() {
		return "TaskManager [taskid=" + taskid + ", taskname=" + taskname + ", description=" + description + ", date="
				+ date + ", status=" + status + ", active=" + active + "]";
	}
	
}
