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
	  		
	  		System.out.println("你输入的课程已经存在!");
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
		  		
		  		System.out.println("你要修改的课程与来课程名称相同!");
		  		
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
				System.out.println("查找的课程不存在!");
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
			System.out.println("课程删除成功");
			}
			else{
				System.out.println("课程不存在");
		}		
    	 MainUI2.show();
	}

}
