package view;

import java.util.Scanner;

import biz.CourseBiz;

public class CourseFind {
	public static void show(){
	    Scanner scanner = new Scanner(System.in);
		System.out.println("������Ҫ���ҵĿγ̱�ţ�");
		String courseNo = scanner.nextLine();
		CourseBiz cs = new CourseBiz();
		cs.findCourse(courseNo);
	}

}
