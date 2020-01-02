package view;

import java.util.Scanner;

import biz.CourseBiz;
import biz.StudentBiz;

//增加课程
public class CourseAdd {
	
	public static void show() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入课程编号：");
		String courseNo = scanner.nextLine();
		System.out.println("请输入课程名称：");
		String courseName = scanner.nextLine();
		System.out.println("请输入课程学分：");
		int courseGrade = scanner.nextInt();
		CourseBiz sc = new CourseBiz();
		sc.addCourse(courseNo, courseName, courseGrade);
		
	}
	

}
