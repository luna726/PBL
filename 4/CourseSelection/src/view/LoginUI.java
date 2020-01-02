package view;

import java.util.Scanner;

import biz.StudentBiz;

//进入系统、登录
public class LoginUI {	

	public static void show() {
		Scanner scanner;
		String studentName;
		String studentPassword;
		StudentBiz studentBiz;
		System.out.println("请输入学号：");
		scanner = new Scanner(System.in);
		studentName = scanner.nextLine();
		System.out.println("请输入密码：");
		studentPassword = scanner.nextLine();
		studentBiz = new StudentBiz();
		studentBiz.login(studentName, studentPassword);
		
	}
}
