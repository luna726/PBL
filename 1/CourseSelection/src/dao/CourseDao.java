package dao;
import entity.Course;
import entity.IEntity;
import entity.Student;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class CourseDao implements IDao {
	private static CourseDao instance;
	private HashMap<String, Course> courses;
	private Course course;
	private CourseDao() {
		courses = new HashMap<String, Course>();
		course = new Course();
		course.setCourseNo("1");
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
		return null;
	}

	@Override
	public IEntity getEntity(String Id) {
		// TODO Auto-generated method stub
		return null;
	}
	public void printDetail(String courseNo) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

}
