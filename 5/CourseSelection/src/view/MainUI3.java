package view;

import java.util.Scanner;

public class MainUI3 {
	public static void show() {
		System.out.println("1-查询正选结果；2-选课；3-退选；0-退出");
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
				//System.out.println("退出成功！");
				MainUI2.show();
		}
	}
	

}
