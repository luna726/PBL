package view;

import java.util.Scanner;

import biz.StudentBiz;
import dao.StudentDao;
import entity.IEntity;
import entity.Student;

//修改密码
public class ModifyPasswordUI {
	public static void show() {
		Scanner scanner;
		String studentNo;
		/*String studentPassword;
		StudentBiz studentBiz;*/
		
		scanner = new Scanner(System.in);
		System.out.println("请输入学号：");
		studentNo = scanner.nextLine();
		System.out.println("请输入原始密码：");		
		String firstPassword = scanner.nextLine();
		
		StudentDao st=StudentDao.getInstance();
		Student sd= (Student)st.getEntity(studentNo);
		
		//String pwd = getStudentPassword("");
		
		if(firstPassword.equals(sd.getStudentPassword())){
			//System.out.println("继续：");			
			System.out.println("请输入新密码：");
			String secondPassword = scanner.nextLine();
			System.out.println("请再次输入新密码：");
		    String thirdPassword = scanner.nextLine();
		    if (secondPassword.equals(thirdPassword)){
			    System.out.println("修改密码成功");
				sd.setStudentPassword(secondPassword);
			    MainUI.show();
			    StudentBiz studentBiz = new StudentBiz();
			    studentBiz.save();
		    }
		    else{
			    System.out.println("密码错误");
			    MainUI.show();
		    }	
		}else {
			System.out.println("原始密码错误！");
		}
		
	}
}
