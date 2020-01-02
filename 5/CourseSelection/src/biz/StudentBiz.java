package biz;

import dao.StudentDao;
import entity.IEntity;
import entity.Student;
import view.MainUI;

public class StudentBiz {
	static StudentDao studentDao;
	private Student student;
	//��¼
	public void login(String studentNo, String studentPassword) {

		studentDao = StudentDao.getInstance();
		student = (Student) studentDao.getEntity(studentNo);
		if (student == null) {
			System.out.println("�û�������");
			return;
		} else if (student.getStudentPassword().equals(studentPassword)) {
			System.out.println("��¼�ɹ�");
			MainUI.show();
		} else {
			System.out.println("���벻��ȷ");
			MainUI.show();
		}

	}
	//ע�ᣬҵ���߼�ʵ��
	public void register(String studentNo, 
						String studentName, 
						String studentGender, 
						int studentAge, 
						String studentDepartment, 
						String firstPassword, 
						String secondPassword) {
		if(firstPassword.equals(secondPassword)) {//�����һ������������ڶ������
			student = new Student();
			student.setStudentNo(studentNo);
			student.setStudentName(studentName);
			student.setStudentAge(studentAge);
			student.setStudentDepartment(studentDepartment);
			student.setStudentPassword(firstPassword);
			
			studentDao = StudentDao.getInstance();
			studentDao.insert(student);
			System.out.println("ע��ɹ���");
			save();
			MainUI.show();
		}else {
			System.out.println("ע��ʧ�ܣ�������ע�ᣡ");
			MainUI.show();
		}
	}
	public void save() {
		studentDao=StudentDao.getInstance();
	    studentDao.update();
	}
}
