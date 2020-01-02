package biz;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
	  		
	  		System.out.println("你输入的课程已经存在!");
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
				System.out.println("查找的课程不存在!");
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
			System.out.println("课程删除成功");
			save();
			}
			else{
				System.out.println("课程不存在");
		}		
    	 MainUI2.show();
	}
    public void save() {
		courseDao=CourseDao.getInstance();
	    courseDao.update();
	}

    public static void show(){
		System.out.println("课程信息如下：");
		FileReader reader = null;
        BufferedReader breader = null;
        try {
            reader = new FileReader("course.txt");
            breader = new BufferedReader(reader);
            String temp = "";
            while ((temp=breader.readLine())!=null) {
                System.out.println(temp);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            breader.close();
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
}	

