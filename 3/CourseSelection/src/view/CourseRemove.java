package view;

import java.util.Scanner;

import biz.CourseBiz;
import dao.CourseDao;
import entity.Course;

public class CourseRemove {
	public static void show(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("������γ̵ı�ţ�");
		String courseNo = scanner.nextLine();
		
		CourseBiz coursebiz=new CourseBiz();
		coursebiz.removeCourse(courseNo);		
	}	

}
