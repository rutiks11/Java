package com.ClassroomDetails;

import java.util.*;

public class ClassroomUtility {	
	
	public static void acceptClassroomDetails(Classroom arr[])
	{
		Scanner sc  = new Scanner(System.in);
		
		for(int icnt=0;icnt < arr.length; icnt++)
		{
			System.out.println("Enter ClassroomID");
			int rid = sc.nextInt();
			System.out.println("Enter Classname ");
			String name = sc.next();
			System.out.println("Enter TeacherID");
			int tid = sc.nextInt();
			System.out.println("Enter Teachername ");
			String tname = sc.next();
			System.out.println("Enter Correct Option :\n1.Proffessor\n2.Assistent Professor");
			int choice = sc.nextInt();
			
			Designation desg = null;
			
			switch(choice)
			{
				case 1:	
					desg = Designation.Prof;
					break;

				case 2:	
					desg = Designation.Asst_Prof;
					break;
			}
			
			Classroom sobj = new Classroom(rid, name, new Teacher(tid, tname, desg));
		}
	}
	
	public static void displayClassroomDetails(Classroom arr[])
	{
		for(int icnt=0; icnt<arr.length; icnt++)
		{
			System.out.println(arr[icnt]);
		}
	}
}
