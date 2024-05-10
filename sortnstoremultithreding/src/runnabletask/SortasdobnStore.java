package runnabletask;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.HashMap;

import com.app.core.Student;

public class SortasdobnStore implements Runnable {
	
	private HashMap<String,Student> map;
	private String filename;
	
	public SortasdobnStore(HashMap<String,Student> map,String filename) 
	{
		this.map = map;
		this.filename = filename;
	}
	
	@Override
	public void run() {
		try(PrintWriter pw = new PrintWriter(new FileWriter(filename)))
		{
			System.out.println(getClass()+ " " + Thread.currentThread() + "Started ");
			map.values().stream().sorted(Comparator.comparing(Student::getDob)).forEach(s->pw.println(s));
			System.out.println("Data Successfully Written.");
		}
		catch (Exception e) {
			System.out.println(getClass()+ " " + Thread.currentThread() + "exec ");
			System.out.println(e);
			e.printStackTrace();
		}
		System.out.println(getClass()+ " " + Thread.currentThread() + "over ");
	}

}
