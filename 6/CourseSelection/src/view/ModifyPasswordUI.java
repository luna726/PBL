package view;

import java.util.Scanner;

import biz.StudentBiz;
import dao.StudentDao;
import entity.IEntity;
import entity.Student;

//�޸�����
public class ModifyPasswordUI {
	public static void show() {
		Scanner scanner;
		String studentNo;
		/*String studentPassword;
		StudentBiz studentBiz;*/
		
		scanner = new Scanner(System.in);
		System.out.println("������ѧ�ţ�");
		studentNo = scanner.nextLine();
		System.out.println("������ԭʼ���룺");		
		String firstPassword = scanner.nextLine();
		
		StudentDao st=StudentDao.getInstance();
		Student sd= (Student)st.getEntity(studentNo);
		
		//String pwd = getStudentPassword("");
		
		if(firstPassword.equals(sd.getStudentPassword())){
			//System.out.println("������");			
			System.out.println("�����������룺");
			String secondPassword = scanner.nextLine();
			System.out.println("���ٴ����������룺");
		    String thirdPassword = scanner.nextLine();
		    if (secondPassword.equals(thirdPassword)){
			    System.out.println("�޸�����ɹ�");
				sd.setStudentPassword(secondPassword);
			    MainUI.show();
			    StudentBiz studentBiz = new StudentBiz();
			    studentBiz.save();
		    }
		    else{
			    System.out.println("�������");
			    MainUI.show();
		    }	
		}else {
			System.out.println("ԭʼ�������");
		}
		
	}
}
