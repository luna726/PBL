package view;

import java.util.Scanner;

import biz.SCBiz;

public class RemoveCourse {
	public static void show() {
		System.out.println("���������ѧ�ţ�");
		Scanner scanner = new Scanner(System.in);
		String studentNo = scanner.nextLine();
		System.out.println("��������Ҫѡ��ɾ���Ŀγ̱�ţ�");
 	    String courseNumber = scanner.nextLine();
 	    System.out.println("��������Ҫɾ���Ŀγ̱�ŵĿγ����ƣ�");
 	    String courseName = scanner.nextLine();
 	    SCBiz scbiz = new SCBiz();
 	    scbiz.Deletecourse(studentNo, courseNumber, courseName);
	}

}
