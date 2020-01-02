package view;

import java.util.Scanner;

public class MainUI2 {
	
	
	private static Scanner scanner;

	public static void show() {
		// TODO Auto-generated method stub
		System.out.println("1-课程查询；2-增加课程；3-删除课程；0-退出");
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
				//System.out.println("退出成功！");
				MainUI.show();
		}
	}

}
