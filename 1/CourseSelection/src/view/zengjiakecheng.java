package view;

import java.util.Scanner;

import biz.CourseBiz;

//���ӿγ�
public class zengjiakecheng {
	
	public static void show() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("������γ̱�ţ�");
		String courseNo = scanner.nextLine();
		System.out.println("������γ����ƣ�");
		String courseName = scanner.nextLine();
		System.out.println("������γ�ѧ�֣�");
		String courseGrade = scanner.nextLine();
		CourseBiz sc = new CourseBiz();
		
	}

}
