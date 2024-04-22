package com.ClassroomDetails;

public class Classroom 
{
	private int rid;
	private String name;
	private Teacher t1;
	
	public Classroom(int rid, String name, Teacher t1)
	{
		this.rid = rid;
		this.name = name;
		this.t1 = t1;
	}
	
	@Override
	public String toString()
	{
		return "\nRoomID : " + this.rid + "\nRoomName " + this.name + t1.toString();
	}
}
