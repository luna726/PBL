package biz;

import java.io.InputStream;
import java.util.*;
import dao.*;
import entity.*;

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
	private HashMap<String,ArrayList> scs;
	private int AllGrade=0,ones=0;
	
	public void choice(Student student) {
		scDao=SCDao.getInstance();
		sc=new SC();
		sc=(SC) scDao.getEntity(student.getStudentNo());
		if(sc==null) {
			courseDao=CourseDao.getInstance();
			selectedCourses=new StringBuffer();
			scs=new HashMap<String,ArrayList>();//��new����
			Scanner scanner=new Scanner(System.in);
			System.out.println("�Ƿ����ѡ�Σ�1-�ǣ�0-�˳�");
			int num=scanner.nextInt();
			if(num==1) {
				courseBiz=new CourseBiz();
				//courseBiz.showAllCourse();
				while(true) {
					System.out.println("����������ѡ��γ̺�");
					Scanner kechenghao=new Scanner(System.in);
					String courseNo=kechenghao.nextLine();
					course=new Course();
					course = (Course) courseDao.getEntity(courseNo);
					if(course!=null) {
						selectedCourses.append(courseNo+",");
						AllGrade += course.getCourseGrade();
						System.out.println(course.getCourseName()+"ѡ��ɹ���");
						Scanner a=new Scanner(System.in);
						System.out.println("�Ƿ��������ѡ�Σ�1-�ǣ�0-�˳�");
						int b=scanner.nextInt();
						if(b!=1) {
							sc=new SC();
							sc.setStudentNo(student.getStudentNo());
							sc.setCourseNo(selectedCourses);
							sc.setGrade(AllGrade);
							scDao.insert(sc);
							break;
						}
					}else {
						System.out.println("����Ŀγ̺Ŵ������������룡");
					}
				}
				save();
			}else if(num==0) {
				return;
			}
		}else {
			courseDao=CourseDao.getInstance();
			selectedCourses=new StringBuffer();
			scs=new HashMap<String,ArrayList>();//��new����
			Scanner scanner=new Scanner(System.in);
			System.out.println("�Ƿ����ѡ�Σ�1-�ǣ�0-�˳�");
			int num=scanner.nextInt();
			if(num==1) {
				courseBiz=new CourseBiz();
				//courseBiz.showAllCourse();
				while(true) {
					System.out.println("����������ѡ��γ̺�");
					Scanner kechenghao=new Scanner(System.in);
					String courseNo=kechenghao.nextLine();
					course = (Course) courseDao.getEntity(courseNo);
					if(course!=null) {
						sc.getCourseNo().append(courseNo+",");
						sc.setGrade(sc.getGrade()+course.getCourseGrade());
						System.out.println(course.getCourseName()+"ѡ��ɹ���");
						Scanner a=new Scanner(System.in);
						System.out.println("�Ƿ��������ѡ�Σ�1-�ǣ�0-�˳�");
						int b=scanner.nextInt();
						if(b!=1) {
							scDao.insert(sc);
							break;
						}
					}else {
						System.out.println("����Ŀγ̺Ŵ������������룡");
					}
				}
				save();
			}else if(num==0) {
				return;
			}
		}
	}
	public void selectionResult(Student student) {
		scDao=SCDao.getInstance();
		sc=new SC();
		sc=(SC) scDao.getEntity(student.getStudentNo());
		courseBiz = new CourseBiz();
		course = new Course();
		int Grade=0;
		if(sc==null) {
			System.out.println(student.getStudentName()+"ͬѧ���㻹û��ѡ�Σ�");
		}else {
			String[] scFields=sc.getCourseNo().toString().split(",");
			//System.out.println(sc.getCourseNo().toString());//*****
			//System.out.println(scFields[0]);//*********
			System.out.println("��ѡ��Ŀ�Ŀ�ֱ��ǣ�");
			for(int i=0 ;i<scFields.length ;i++ ) {
				course = courseBiz.findCourse(scFields[i]);
				//System.out.println(course);//********
				Grade += course.getCourseGrade();
				ones++;
			}
			System.out.println(student.getStudentName()+"ͬѧ��ã���ѡ��"+ones+"�Ρ�"+"��"+Grade+"ѧ�֣�");
			Grade=0;
			ones=0;
		}
	}
	public void withdrawal(Student student) {
		scDao=SCDao.getInstance();
		sc=new SC();
		sc=(SC) scDao.getEntity(student.getStudentNo());
		
		if(sc==null) {
			System.out.println(student.getStudentName()+"ͬѧ���㻹û�н���ѡ�Σ������˿Ρ�������������Ĳ�����");
		}else {
			courseDao=CourseDao.getInstance();
			selectedCourses=new StringBuffer();
			scs=new HashMap<String,ArrayList>();//��new����
			Scanner scanner=new Scanner(System.in);
			System.out.println("�Ƿ������ѡ��1-�ǣ�0-�˳�");
			int num=scanner.nextInt();
			if(num==1) {
				while(true) {
					System.out.println("����������ѡ��γ̺�");
					Scanner kechenghao=new Scanner(System.in);
					String courseNo=kechenghao.nextLine();
					course = (Course) courseDao.getEntity(courseNo);
					StringBuffer stringcourse=new StringBuffer();
					if(course!=null) {
						String[] scFields=sc.getCourseNo().toString().split(",");
						for(int i=0;i<scFields.length;i++) {
							if(courseNo.equals(scFields[i])) {
								for(int j=i;j<scFields.length-1;i++) {
									scFields[j]=scFields[j+1];
								}
							}
							stringcourse.append(scFields[i]);
						}
						sc.setCourseNo(selectedCourses);
						sc.setGrade(AllGrade-course.getCourseGrade());
						scDao.insert(sc);
						System.out.println(course.getCourseName()+"��ѡ�ɹ���");
						Scanner a=new Scanner(System.in);
						System.out.println("�Ƿ����������ѡ��1-�ǣ�0-�˳�");
						int b=scanner.nextInt();
						if(b!=1) {
							break;
						}
					}else {
						System.out.println("����Ŀγ̺Ŵ������������룡");
					}
				}
				save();
			}else if(num==0) {
				return;
			}
		}
	}
	public void save() {
		scDao=SCDao.getInstance();
	    scDao.update();
	}
}
