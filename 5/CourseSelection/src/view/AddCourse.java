package view;

import java.util.Scanner;

import biz.SCBiz;

public class AddCourse {
	public static void show() {
		System.out.println("������ѡ��");
		System.out.println("������ѧ�ţ�");
		Scanner scanner = new Scanner(System.in);
		String studentNo = scanner.nextLine();
		System.out.println("������γ̱�ţ�");
		String courseNo = scanner.nextLine();
		System.out.println("������γ����ƣ�");
		String courseName = scanner.nextLine();
		SCBiz sc = new SCBiz();
		sc.Courseadd(studentNo,courseNo, courseName);
		
	}

}
