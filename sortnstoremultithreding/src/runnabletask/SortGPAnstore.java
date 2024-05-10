package runnabletask;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.HashMap;

import com.app.core.Student;
import com.app.core.Subject;

public class SortGPAnstore implements Runnable {
	
	private HashMap<String,Student> map;
	private String filename;
	
	public SortGPAnstore(HashMap<String,Student> map,String filename) 
	{	
		System.out.println("In Constructor of SORTGpa");
		this.map = map;
		this.filename = filename;
	}
	
	@Override
	public void run() {
		try(PrintWriter pw = new PrintWriter(new FileWriter(filename)))
		{
			System.out.println(getClass()+ " " + Thread.currentThread() + "Started ");
			map.values().stream().filter(s->s.getSubject()==Subject.JAVA).sorted(Comparator.comparing(Student::getGpa)).forEach(s->pw.println(s));
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
