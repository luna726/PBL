package view;

import java.util.Scanner;

public class MainUI3 {
	public static void show() {
		System.out.println("1-��ѯ��ѡ�����2-ѡ�Σ�3-��ѡ��0-�˳�");
		Scanner scanner = new Scanner(System.in);
		String option = scanner.nextLine();
		switch (option) {
			case "1":
				FindCourse.show();
				break;
			case "2":
				AddCourse.show();
				break;
			case "3":
				RemoveCourse.show();
				break;
			
			case "0":
				//System.out.println("�˳��ɹ���");
				MainUI2.show();
		}
	}
	

}
