package view;

import java.util.Scanner;

import biz.SCBiz;

public class AddCourse {
	public static void show() {
		System.out.println("进入正选！");
		System.out.println("请输入学号：");
		Scanner scanner = new Scanner(System.in);
		String studentNo = scanner.nextLine();
		System.out.println("请输入课程编号：");
		String courseNo = scanner.nextLine();
		System.out.println("请输入课程名称：");
		String courseName = scanner.nextLine();
		SCBiz sc = new SCBiz();
		sc.Courseadd(studentNo,courseNo, courseName);
		
	}

}
