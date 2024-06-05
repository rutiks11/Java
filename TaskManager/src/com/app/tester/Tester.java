package com.app.tester;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static com.app.utils.TaskUtils.*;

import com.app.taskmanager.TaskManager;

public class Tester {
	public static void main(String args[])
	{
		List<TaskManager> tasklist = new ArrayList<TaskManager>(populatetasks());
		boolean exit =false;
		
		try(Scanner sc= new Scanner(System.in))
		{
			while(!exit)
			{
				try
				{	
					System.out.println("Enter the Choice :: \n1.Add Task \n5.Display Task");
					switch (sc.nextInt()) {
					case 1:
						System.out.println("Enter Task Details ");
						AddTask(sc.next(),sc.next(),sc.next(),tasklist);
						break;
					
					case 5:
						System.out.println("Task List");
						tasklist.forEach(s->System.out.println(s));
						break;
						
					default:
						break;
					}
				}
				catch (Exception e) {
					System.out.println("In catch Block");
					sc.nextLine();
				}
			}
		}
	}
}
