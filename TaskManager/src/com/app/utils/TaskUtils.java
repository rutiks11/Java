package com.app.utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.app.customexception.GlobalException;
import com.app.taskmanager.TaskManager;

public class TaskUtils {
	public static List<TaskManager> populatetasks()
	{
		List<TaskManager> list = new ArrayList<TaskManager>(Arrays.asList(
				new TaskManager("Assignment", "Complete JavaScript Assignment",LocalDate.parse("2024-05-12")),
				new TaskManager("Cleaning", "Workspace Cleaning",LocalDate.parse("2024-06-01")),
				new TaskManager("Project", "Project Completion",LocalDate.parse("2024-06-02")),
				new TaskManager("Grocery", "Buy essentials",LocalDate.parse("2024-06-15")),
				new TaskManager("Revision", "Start Revision Daily 30min",LocalDate.parse("2024-05-12")),
				new TaskManager("Communication", "Listening or speaking Activity",LocalDate.parse("2024-06-12")),
				new TaskManager("Aptitude", "Practice more examples",LocalDate.parse("2024-06-05"))
				));
		return list;
	}
	
	public static List<TaskManager> AddTask(String name,String desc,String date,List<TaskManager> list)throws GlobalException
	{
		LocalDate taskdate = LocalDate.parse(date);
		TaskManager task = new TaskManager(name, desc, taskdate);
		list.add(task);
		return list;
	}
}
