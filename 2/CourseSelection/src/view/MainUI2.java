package view;

import java.util.Scanner;

public class MainUI2 {
	
	
	private static Scanner scanner;

	public static void show() {
		// TODO Auto-generated method stub
		System.out.println("1-�γ̲�ѯ��2-���ӿγ̣�3-ɾ���γ̣�0-�˳�");
		scanner = new Scanner(System.in);
		
		String option = scanner.nextLine();
		switch (option) {
			case "1":
				CourseFind.show();
				break;
			case "2":
				CourseAdd.show();
				break;
			case "3":
				CourseRemove.show();
				break;
			case "0":
				//System.out.println("�˳��ɹ���");
				MainUI.show();
		}
	}

}
