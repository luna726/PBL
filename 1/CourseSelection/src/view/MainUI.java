package view;

import java.util.Scanner;

//������ ��ѧ��ѡ��ϵͳ����
public class MainUI {
	private static Scanner scanner;

	public static void show() {
		System.out.println("1-ע�᣻2-�޸����룻3-ѡ�Σ�4-��¼��5-ע����0-�˳�");
		scanner = new Scanner(System.in);
		String option = scanner.nextLine();
		switch (option) {
		case "1":
			RegisterUI.show();
			break;
		case "2":
			ModifyPasswordUI.show();
			break;
		case "3":
			MainCourse.show();
			break;
		case "4":
			LoginUI.show();
		case "5":
			zhuxiao.show();
		case "0":
			//System.out.println("�˳��ɹ���");
			MainUI.show();
		}
	}
}