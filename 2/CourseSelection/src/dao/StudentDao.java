package dao;
import entity.IEntity;
import entity.Student;
import entity.Course;

import java.util.HashMap;
import java.util.Scanner;

public class StudentDao implements IDao {

	private static StudentDao instance;
	private HashMap<String, Student> students;
	private Student student;
	public StudentDao() {
		setStudents(new HashMap<String, Student>());
		student = new Student();
		
		student.setStudentNo("184805034"); 
		student.setStudentName("张三");
		student.setStudentGender("男");
		student.setStudentPassword("123456");
		student.setStudentAge(20);
		student.setStudentDepartment("软件学院");
		getStudents().put(student.getStudentNo(), student);
	}
	public static StudentDao getInstance() {
		if(instance == null) {
			synchronized(StudentDao.class) {
				if(instance == null) {
					instance = new StudentDao();
					return instance;
				}
			}
		}
		return instance;
	}
	@Override
	public void insert(IEntity entity) {
		// TODO Auto-generated method stub
		Student st = (Student)entity;
		getStudents().put(st.getStudentNo(), st);
	}

	@Override
	public void delete() { //删除
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入学号：");
		String studentNo = scanner.nextLine();
		String firstPassword = scanner.nextLine();
		StudentDao st=StudentDao.getInstance();
		Student sd= (Student) getEntity(studentNo);
		if(sd == null){
			System.out.println("用户不存在");
		}else {
			if(firstPassword.equals(sd.getStudentPassword())){
		    students.remove(studentNo);
			System.out.println("注销成功！");
		    }
		}
	}

	@Override
	public void update() { 
		// TODO Auto-generated method stub

	}

	@Override
	public HashMap<String, IEntity> getAllEntities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IEntity getEntity(String Id) {
		// TODO Auto-generated method stub		
		return getStudents().get(Id);
	}
	public void printDetail(String Id) {
		Course course1 = (Course)getEntity(Id);
		System.out.println("查询结果是:	课程编号: "
		+course1.getCourseNo()
		+" 	课程名称: "
		+course1.getCourseName()
		+"	课程成绩: "
		+course1.getCourseGrade());
	}
	@Override
	public void update(IEntity entity) {
		// TODO Auto-generated method stub
		
	}
	public HashMap<String, Student> getStudents() {
		return students;
	}
	public void setStudents(HashMap<String, Student> students) {
		this.students = students;
	}

}
