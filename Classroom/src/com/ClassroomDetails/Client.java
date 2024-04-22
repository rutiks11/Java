package com.ClassroomDetails;

public class Client {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Classroom carr[];
		carr =  new Classroom[2];
		
		ClassroomUtility.acceptClassroomDetails(carr);
		ClassroomUtility.displayClassroomDetails(carr);
	}

}
