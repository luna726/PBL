package biz;

import java.util.HashMap;

import dao.CourseDao;
import entity.Course;
import entity.IEntity;
import view.MainCourse;

public class CourseBiz {
	CourseDao courseDao;
	private  Course course;
	private HashMap<String, IEntity> courses;
	
	public void addCourse(String courseNo, String courseName, int courseGrade) {

		courseDao = CourseDao.getInstance();
		course = (Course) courseDao.getEntity(courseNo);
		if(courses.containsKey(courseNo)) {
	  		
	  		System.out.println("������Ŀγ��Ѿ�����!");
	  		System.out.println("�������Ҫѡ��ķ���: ");
			MainCourse.show();
		}else {
			course = new Course();
			course.setCourseNo(courseNo);
			course.setCourseName(courseName);
			course.setCourseGrade(courseGrade);
			courseDao.insert(course);
			MainCourse.show();
		}
	}
	public void modifyCourse(String courseNo, String oldcourseName, String newcourseName ,int newcourseGrade) {
		courseDao = CourseDao.getInstance();
		Course course2 = (Course)courseDao.getEntity(courseNo);
		  	if(oldcourseName.equals(newcourseName)) {
		  		
		  		System.out.println("��Ҫ�޸ĵĿγ������γ�������ͬ!");
		  		System.out.println("�������Ҫѡ��ķ���: ");
			}else {
				course2.setCourseName(newcourseName);
				course2.setCourseGrade(newcourseGrade);
				courseDao.update(course2);
			}
		  	MainCourse.show();
	}
	public void findCourse(String courseNo) {
		courseDao = CourseDao.getInstance();
		courses = courseDao.getAllEntities();
		  	if(courses.containsKey(courseNo)) {
		  	
				System.out.println("��Ҫ���ҵĿγ����ҵ�");
				 courseDao.printDetail(courseNo);
			}else {
				System.out.println("��Ҫ���ҵĿγ̲�����!");
			}
		  	System.out.println("�������Ĳ���:");
			  MainCourse.show();
	}
	 public void removeCourse(String courseNo, String courseName){
		 courseDao = CourseDao.getInstance();
		 Course course2 = (Course)courseDao.getEntity(courseNo);
		 if(course2!=null){
			 course2.setCourseName(null);
			 course2.setCourseNo(null);
			 courseDao.delete();
		 }else{
			 System.out.println("�γ��������");
		 }
		 MainCourse.show();

	   }
}
