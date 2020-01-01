package view;

import java.util.Scanner;

import dao.StudentDao;
import entity.Student;

public class zhuxiao {
	public static void show() {
		Scanner scanner;
		StudentDao da=new StudentDao();
		String studentNo;
		scanner = new Scanner(System.in);
		System.out.println("请输入学号：");
		studentNo = scanner.nextLine();
		System.out.println("请输入密码：");
		String firstPassword = scanner.nextLine();
		StudentDao st=StudentDao.getInstance();
		Student sd= (Student) st.getEntity(studentNo);
		
		if(firstPassword.equals(sd.getStudentPassword())){
			da.students.remove(studentNo);
			System.out.println("注销成功！");
		}
			
	}

}
