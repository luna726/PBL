package dao;
import entity.IEntity;
import entity.Student;
import entity.Course;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class StudentDao implements IDao {

	private static StudentDao instance;
	private HashMap<String, IEntity> students;
	private Student student;
	private FileInputStream fs;
    private FileOutputStream fos;
    
	public StudentDao() {
		students = new HashMap<String,IEntity>();
		student = new Student();
		getUsersFromInputStream("C:\\Users\\DELL\\Desktop\\java大作业\\5\\CourseSelection\\student.txt");
	}
	
	private void getUsersFromInputStream(String isName) {
		try {
			FileInputStream fs = new FileInputStream(isName);
			byte[] content = new byte[1024];
			int i=0;
			int conInteger=0;
			while(true) {
				try {
					conInteger = fs.read();
				} catch (IOException e) {
					e.printStackTrace();
				}
				if(conInteger==-1) {
					break;
				}
				else if((char)conInteger=='\r'||(char)conInteger=='\n'){
					try {
						this.processUserString(new String(content,"GBK").trim());
						i=0;
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
					i=0;
				}
				else {
					content[i]=(byte)conInteger;
					i++;
				}
			}	
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	public void processUserString(String userString) {
		String[] userFileds=userString.split(",");
		Student st=new Student();
		st.setStudentNo(userFileds[0]);
		st.setStudentName(userFileds[1]);
		st.setStudentAge(Integer.parseInt(userFileds[2]));
		st.setStudentGender(userFileds[3]);
		st.setStudentPassword(userFileds[4]);
		st.setStudentDepartment(userFileds[5]);
		
		students.put(st.getStudentNo(), st);
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
	
	public void addUser(Student st) {
		students.put(st.getStudentNo(),st);
	}

	@Override
	public void insert(IEntity entity) {
		// TODO Auto-generated method stub
		Student st = (Student)entity;
		students.put(st.getStudentNo(), st);
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
		Set<String> studentSet=students.keySet();
	   	 StringBuffer uStringBuffer=new StringBuffer();
	   	 for(String studentNo:studentSet) {
	   		 Student st=(Student)students.get(studentNo);
				String uString = st.getStudentNo()+","
						+st.getStudentName()+","+
						st.getStudentAge()+","+
						st.getStudentGender()+","+
						st.getStudentPassword()+","+
						st.getStudentDepartment()+"\r\n";
				uStringBuffer.append(uString);
	   	 }
	   	 putStudentsToFile(uStringBuffer.toString(),"C:\\Users\\DELL\\Desktop\\java大作业\\5\\CourseSelection\\student.txt");
	    }
	
	private void putStudentsToFile(String uString,String osName){
   	 	try {
			fos=new FileOutputStream(osName);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   	 	try {
			fos.write(uString.getBytes("GBK"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
    }


	@Override
	public HashMap<String, IEntity> getAllEntities() {
		// TODO Auto-generated method stub
		return students;
	}

	@Override
	public IEntity getEntity(String Id) {
		// TODO Auto-generated method stub		
		return students.get(Id);
	}
	public void printDetail(String Id) {
		Course course1 = (Course)getEntity(Id);
		System.out.println("查询结果是:	课程编号: "
		+course1.getCourseNo()
		+"课程名称: "
		+course1.getCourseName()
		+"课程成绩: "
		+course1.getCourseGrade());
	}
}
