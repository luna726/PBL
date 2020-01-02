package biz;

import java.io.InputStream;
import java.util.*;
import dao.*;
import entity.*;
import view.MainUI2;

public class SCBiz {
	
	Course course;
	Student student;
	SC sc;
	CourseDao courseDao;
	StudentDao studentDao;
	SCDao scDao;
	CourseBiz courseBiz;
	StudentBiz studentBiz;
	SCBiz scBiz;
	private StringBuffer selectedCourses;
	private HashMap<String, IEntity> scs;
	private int AllGrade=0,ones=0;
	
	public void Courseadd(String studentNo, String courseNo, String courseName) {
		// TODO Auto-generated method stub
		scDao=SCDao.getInstance();
		sc=new SC();
		scs = scDao.getAllEntities();
		sc.setStudentNo(studentNo);
		sc.setCourseNo(courseNo);
		sc.setCourseName(courseName);
		scDao.insert(sc);
		System.out.println("正选成功！");
		System.out.println("正选结果:");
		scDao.update();
		save();
		MainUI2.show();
	}
	
	public void save() {
		scDao=SCDao.getInstance();
	    scDao.update();
	}

	public void Deletecourse(String studentNo, String courseNumber, String courseName) {
		// TODO Auto-generated method stub
		scDao = SCDao.getInstance();
        scs = scDao.getAllEntities();
		SC sc1 = new SC();
		sc1.setStudentNo(studentNo);
		sc1.setCourseNo(courseNumber);
		sc1.setCourseName(courseName);
		
		scDao.delete();
		System.out.println("退选成功！");
		System.out.println("退选后结果如下：");
		scDao.update();	
		MainUI2.show();
	}
	
}
