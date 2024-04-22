package com.ClassroomDetails;

public class Teacher 
{
	public int tid;
	public String name;
	public Designation desg;
	
	public Teacher(int tid,String name, Designation desg)
	{
		this.tid = tid;
		this.name = name;
		this.desg = desg;	
	}
	
	@Override
	public String toString()
	{
		return "TeacherID : "+ this.tid + "Teacher_Name :" + this.name + "Designation " + this.desg;
	}
}
