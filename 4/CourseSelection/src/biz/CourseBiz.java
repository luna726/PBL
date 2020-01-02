package biz;

import java.util.HashMap;

import dao.CourseDao;
import entity.Course;
import entity.IEntity;
import view.MainUI2;

public class CourseBiz {
	CourseDao courseDao;
	private  Course course;
	private HashMap<String, IEntity> courses;
	
	public void addCourse(String courseNo, String courseName, int courseGrade) {

		courseDao = CourseDao.getInstance();
		//course = (Course) courseDao.getEntity(courseNo);
		courses = courseDao.getAllEntities();
		CourseDao cd =CourseDao.getInstance();
		Course co= (Course) cd.getEntity(courseNo);
		if(co!=null) {
	  		
	  		System.out.println("������Ŀγ��Ѿ�����!");
			MainUI2.show();
		}else {
			course = new Course();
			course.setCourseNo(courseNo);
			course.setCourseName(courseName);
			course.setCourseGrade(courseGrade);
			courseDao.insert(course);
			MainUI2.show();
		}
	}
	public void modifyCourse(String courseNo, String oldcourseName, String newcourseName ,int newcourseGrade) {
		courseDao = CourseDao.getInstance();
		Course course2 = (Course)courseDao.getEntity(courseNo);
		  	if(oldcourseName.equals(newcourseName)) {
		  		
		  		System.out.println("��Ҫ�޸ĵĿγ������γ�������ͬ!");
		  		
			}else {
				course2.setCourseName(newcourseName);
				course2.setCourseGrade(newcourseGrade);
				courseDao.update(course2);
			}
		  	MainUI2.show();
	}
	public void findCourse(String courseNo) {
		courseDao = CourseDao.getInstance();
		courses = courseDao.getAllEntities();
		CourseDao cd =CourseDao.getInstance();
		Course co= (Course) cd.getEntity(courseNo);
		  	if(co!=null) {
				 courseDao.printDetail(courseNo);
			}else {
				System.out.println("���ҵĿγ̲�����!");
			}
		 
			  MainUI2.show();
	}
    public void removeCourse(String courseNo){
    	courseDao=courseDao.getInstance();
    	courses = courseDao.getAllEntities();
    	
    	CourseDao cd=CourseDao.getInstance();
		Course co = (Course) cd.getEntity(courseNo);	
    	if(co!=null){
			courses.remove(courseNo);
			System.out.println("�γ�ɾ���ɹ�");
			}
			else{
				System.out.println("�γ̲�����");
		}		
    	 MainUI2.show();
	}

}
