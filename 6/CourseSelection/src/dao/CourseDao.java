package dao;
import entity.Course;
import entity.IEntity;
import entity.Student;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.*;
/*import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;*/

import biz.CourseBiz;

public class CourseDao implements IDao {
	private static CourseDao instance;
	private HashMap<String, IEntity> courses;
	private Course course;
	private FileInputStream fs;
    private FileOutputStream fos;
    
	private CourseDao() {
		courses = new HashMap<String, IEntity>();
		course = new Course();
		getCoursesFormInputStream("course.txt");

	}
	public void getCoursesFormInputStream(String isName){
	   	 try {
	   		    FileInputStream fs=new FileInputStream(isName);
				byte[] content=new byte[1024];
				int i=0;
				int conInteger=0;
				while(true) {
					try {
						conInteger=fs.read();
					} catch (IOException e) {
						e.printStackTrace();
					}
					if(-1==conInteger) {
						break;
					}else if('\r'==(char)conInteger||'\n'==(char)conInteger) {
						try {
							this.processCourseString(new String(content,"GBK").trim());
						} catch (UnsupportedEncodingException e) {
							e.printStackTrace();
						}
						i=0;
					}else {
						content[i]=(byte)conInteger;
						i++;
					}
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
	    }	
	
	private void processCourseString(String courseString) {
		String[] courseFields=courseString.split(",");
   	 	Course course = new Course();
   	 	course.setCourseNo(courseFields[0]);
   	 	course.setCourseName(courseFields[1]);
   	    course.setCourseGrade(Integer.parseInt(courseFields[2]));
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
		Set<String> courseSet=courses.keySet();
	   	 StringBuffer courseStringBuffer=new StringBuffer();
	   	 for(String courseNo:courseSet) {
	   		 Course course=(Course)courses.get(courseNo);
				String uString = course.getCourseNo()+","
						+course.getCourseName()+","+
						course.getCourseGrade()+"\r\n";
				courseStringBuffer.append(uString);
	   	 }
	   	 putCoursesToFile(courseStringBuffer.toString(),"course.txt");
	}
	
	private void putCoursesToFile(String uString,String osName){
   	 	try {
   	 		fos=new FileOutputStream(osName);
   	 	} catch (FileNotFoundException e) {
   	 		e.printStackTrace();
   	 	}
   	 	try {
   	 		fos.write(uString.getBytes("GBK"));
   	 	} catch (UnsupportedEncodingException e) {
   	 		e.printStackTrace();
   	 	} catch (IOException e) {
   	 		e.printStackTrace();
   	 	}
    }
	
	@Override
	public void insert(IEntity entity) {
		// TODO Auto-generated method stub
		Course co = (Course)entity;
		courses.put(co.getCourseNo(), co);
		System.out.println("课程添加成功！");
		System.out.println("课程添加后的信息显示: ");
		CourseBiz courseBiz = new CourseBiz();
		courseBiz.save();
		Set keySet = courses.keySet();
		Iterator it = keySet.iterator();
		while(it.hasNext()){
			String key = (String) it.next();
			Course course = (Course) courses.get(key);
			System.out.println(key+":	"
			+course.getCourseNo()
			+"	"+course.getCourseName()
			+"	"+course.getCourseGrade());
		}

	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		

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
	@Override
	public IEntity getEntity(int s) {
		// TODO Auto-generated method stub
		return null;
	}
	public Map<String, IEntity> show(){
		return courses;
	}

}
