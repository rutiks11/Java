package tester;

import static utils.StudentCollectionUtils.populateList;
import static utils.StudentCollectionUtils.populateMap;

import java.util.HashMap;
import java.util.Scanner;

import com.app.core.Student;

import runnabletask.SortGPAnstore;
import runnabletask.SortasdobnStore;

public class Tester {

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {
			HashMap<String, Student> studentMap = new HashMap<>(populateMap(populateList()));
			
			System.out.println("Enter FileName to Store the Data :: ");
			Thread t1 = new Thread(new SortasdobnStore(studentMap, sc.next()), "DOB");
			System.out.println("Enter FileName to Store the data :: ");
			Thread t2 = new Thread(new SortGPAnstore(studentMap, sc.next()), "GPA");

			t1.start();
			t2.start();

			t1.join();
			t2.join();
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}
}
