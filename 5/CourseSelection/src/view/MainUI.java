package view;

import java.util.Scanner;

//主函数 、学生选课系统界面
public class MainUI {
	private static Scanner scanner;

	public static void show() {
		System.out.println("1-注册；2-修改密码；3-选课；4-登录；0-退出");
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
			MainUI2.show();
			break;
		case "4":
			LoginUI.show();
		case "0":
			//System.out.println("退出成功！");
			MainUI.show();
		}
	}
}