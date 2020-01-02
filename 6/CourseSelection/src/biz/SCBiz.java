package biz;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;
import dao.*;
import entity.*;
import view.MainUI2;

public class SCBiz {
	public static void selection(String id){
		CourseDao courseDao = CourseDao.getInstance();
		StudentDao studentDao = StudentDao.getInstance();
		SCDao scDao = SCDao.getInstance();
		
		Map<String, IEntity> courses = courseDao.show();
		System.out.println("--------------���пγ���Ϣ------------------");
		for (IEntity course : courses.values()) {
			System.out.println("�γ̱��:"+((Course) course).getCourseNo()+",�γ�����:"+((Course) course).getCourseName()+",�γ�ѧ��:"+((Course) course).getCourseGrade());
		}
		
		Scanner in = new Scanner(System.in);
		System.out.println("��������ѡ�γ̱��");
	    String courseNo = in.next();
		Course entity = (Course)courseDao.getEntity(courseNo);
		if (entity == null){
			System.out.println("��ѡ�γ̲�����");
			MainUI2.show();
		}else{
			int s = Integer.parseInt(courseNo);
			SC sc = (SC) scDao.getEntity(id);
			Student student = (Student) studentDao.getEntity(id);
			String[] ke={"���������","���������ϵͳ","�����Ӧ��","��ѧ����","���Դ���","��ɢ��ѧ"};
			try{
				File file = new File("sc.txt");                                  // ����һ��file���󣬲���������������ļ���·��
				BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
				List list =new ArrayList();                                         //����һ�����ϴ��ÿһ�е��ַ���
				while(true){
				    String str=br.readLine();                                       //��ȡ�ļ����е�һ��
				    if(str==null) break;                                            //�����ȡ���ǿգ�Ҳ�����ļ���ȡ���� ����ѭ��
				    int index=str.indexOf(student.getStudentName());                                       //�����е��Ƿ�Ϊ�û���Ϣ
				    if(index != -1){
				    	int index1=str.indexOf(ke[s-1]);                                  //�����Ƿ�����ѡ�γ� ����������ֵ>=0		        
				    	System.out.println(index1);
				    	if(index1>0){  
				    	    System.out.println("ѡ��ʧ�ܣ��ÿγ�" + ke[s-1] + "��ѡ!");                 //��������ͷ��أ�ѡ��ʧ��
				    	   // return;
				    	    SCBiz.selection(id);
				        }
				        else{
				        	System.out.println(ke[s-1] + "ѡ�γɹ���");
				    	    str=str+","+ke[s-1];                                           //��������ѡ�γɹ�������ѡ�γ̼����ļ���                                               
				        }
				    }
				    list.add(str);                                                   //���޸�֮���str�ŵ����ϵ���
				}
			br.close();
			PrintWriter pw=new PrintWriter(file);                               //����һ����������Ѷ���д���ļ�
			for(int i=0;i<list.size();i++){
				String str =(String)list.get(i);                                //�Ӽ��ϵ���ȡ���ַ���
				pw.println(str);                                                //�Ѹ��ַ���д���ļ�����
				}
			pw.close();
			} catch (Exception e){
			       e.printStackTrace();
			   }
			MainUI2.show();
		}
	}
		

}