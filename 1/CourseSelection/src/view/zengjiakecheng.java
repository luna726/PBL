package view;

import java.util.Scanner;

import biz.CourseBiz;

//增加课程
public class zengjiakecheng {
	
	public static void show() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入课程编号：");
		String courseNo = scanner.nextLine();
		System.out.println("请输入课程名称：");
		String courseName = scanner.nextLine();
		System.out.println("请输入课程学分：");
		String courseGrade = scanner.nextLine();
		CourseBiz sc = new CourseBiz();
		
	}

}
