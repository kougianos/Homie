package utils;

import java.util.List;

import entities.Student;

public class UtilityMethods {
	
	public static String createJSON(List<Student> students)
	{
		String array = "[]";
		if (students != null)
		{
			array = "[";
			for (Student s: students)
			{
				array = array + jsonStudent(s) + ","; 
			}
			array = array + "]";
		}
		return array;
	}
	
	private static String jsonStudent(Student student)
	{
		String stud = null;
		if (student != null)
		{
			stud = "{" + "\"lname\":" + "\"" + student.getLname() +"\"}";
		}
		
		return stud;
	}

}
