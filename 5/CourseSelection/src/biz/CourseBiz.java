package biz;

import java.util.HashMap;

import dao.CourseDao;
import dao.StudentDao;
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
			save();
		}
	}
	
	public Course findCourse(String courseNo) {
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
			return co;
	}
    public void removeCourse(String courseNo){
    	courseDao=courseDao.getInstance();
    	courses = courseDao.getAllEntities();
    	
    	CourseDao cd=CourseDao.getInstance();
		Course co = (Course) cd.getEntity(courseNo);	
    	if(co!=null){
			courses.remove(courseNo);
			System.out.println("�γ�ɾ���ɹ�");
			save();
			}
			else{
				System.out.println("�γ̲�����");
		}		
    	 MainUI2.show();
	}
    public void save() {
		courseDao=CourseDao.getInstance();
	    courseDao.update();
	}

}
