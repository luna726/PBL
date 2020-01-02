package dao;
import entity.Course;
import entity.IEntity;
import entity.Student;
import java.util.*;
/*import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;*/

public class CourseDao implements IDao {
	private static CourseDao instance;
	private HashMap<String, IEntity> courses;
	private Course course;
	private CourseDao() {
		courses = new HashMap<String, IEntity>();
		course = new Course();
		course.setCourseNo("01");
		course.setCourseName("数学");
		course.setCourseGrade(20);
		
		courses.put(course.getCourseNo(), course);

	}
	public static CourseDao getInstance() {
		if(instance == null) {
			synchronized(CourseDao.class) {
				if(instance == null) {
					instance = new CourseDao();
					return instance;
				}
			}
		}
		return instance;
	}
	
	@Override
	public void insert(IEntity entity) {
		// TODO Auto-generated method stub
		Course co = (Course)entity;
		courses.put(co.getCourseNo(), co);
		System.out.println("课程添加成功！");
		System.out.println("课程添加后的信息显示: ");
		Set keySet = courses.keySet();
		Iterator it = keySet.iterator();
		while(it.hasNext()){
			String key = (String) it.next();
			Course course = (Course) courses.get(key);
			System.out.println(key+":	"+course.getCourseNo()+"	"+course.getCourseName()+"	"+course.getCourseGrade());
		}

	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		

	}

	@Override
	public void update(IEntity entity) {
		// TODO Auto-generated method stub
		Course cs2 =(Course)entity;
		courses.put(cs2.getCourseNo(),cs2);
		System.out.println("课程修改成功！");
		System.out.println("课程修改后的信息显示: ");
		Set keySet = courses.keySet();
		Iterator it = keySet.iterator();
		while(it.hasNext()){
			String key = (String) it.next();
			Course course = (Course) courses.get(key);
			System.out.println(key+":	"+course.getCourseNo()+"	"+course.getCourseName()+"	"+course.getCourseGrade());
		}

	}

	@Override
	public HashMap<String, entity.IEntity> getAllEntities() {
		// TODO Auto-generated method stub
		return courses;
	}

	@Override
	public IEntity getEntity(String Id) {
		// TODO Auto-generated method stub
		
		//return null;
		return courses.get(Id);
	}
	public void printDetail(String courseNo) {
		// TODO Auto-generated method stub
		Course course1 = (Course)getEntity(courseNo);
		System.out.println("查询结果:课程编号: "
		+course1.getCourseNo()
		+" 	课程名称: "+course1.getCourseName()
		+"	课程成绩: "+course1.getCourseGrade());
	}
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	

}
