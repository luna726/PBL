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
		System.out.println("������ѧ�ţ�");
		studentNo = scanner.nextLine();
		System.out.println("���������룺");
		String firstPassword = scanner.nextLine();
		StudentDao st=StudentDao.getInstance();
		Student sd= (Student) st.getEntity(studentNo);
		
		if(firstPassword.equals(sd.getStudentPassword())){
			da.students.remove(studentNo);
			System.out.println("ע���ɹ���");
		}
			
	}

}
