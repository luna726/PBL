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
		System.out.println("--------------所有课程信息------------------");
		for (IEntity course : courses.values()) {
			System.out.println("课程编号:"+((Course) course).getCourseNo()+",课程名称:"+((Course) course).getCourseName()+",课程学分:"+((Course) course).getCourseGrade());
		}
		
		Scanner in = new Scanner(System.in);
		System.out.println("请输入所选课程编号");
	    String courseNo = in.next();
		Course entity = (Course)courseDao.getEntity(courseNo);
		if (entity == null){
			System.out.println("所选课程不存在");
			MainUI2.show();
		}else{
			int s = Integer.parseInt(courseNo);
			SC sc = (SC) scDao.getEntity(id);
			Student student = (Student) studentDao.getEntity(id);
			String[] ke={"计算机网络","计算机操作系统","计算机应用","大学物理","线性代数","离散数学"};
			try{
				File file = new File("sc.txt");                                  // 建立一个file对象，参数就是你想访问文件的路径
				BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
				List list =new ArrayList();                                         //定义一个集合存放每一行的字符串
				while(true){
				    String str=br.readLine();                                       //读取文件当中的一行
				    if(str==null) break;                                            //如果读取的是空，也就是文件读取结束 跳出循环
				    int index=str.indexOf(student.getStudentName());                                       //看此行的是否为用户信息
				    if(index != -1){
				    	int index1=str.indexOf(ke[s-1]);                                  //查找是否有所选课程 不包含返回值>=0		        
				    	System.out.println(index1);
				    	if(index1>0){  
				    	    System.out.println("选课失败，该课程" + ke[s-1] + "已选!");                 //如果包含就返回，选课失败
				    	   // return;
				    	    SCBiz.selection(id);
				        }
				        else{
				        	System.out.println(ke[s-1] + "选课成功！");
				    	    str=str+","+ke[s-1];                                           //不包含则选课成功，将所选课程加入文件中                                               
				        }
				    }
				    list.add(str);                                                   //把修改之后的str放到集合当中
				}
			br.close();
			PrintWriter pw=new PrintWriter(file);                               //建立一个输出流，把东西写入文件
			for(int i=0;i<list.size();i++){
				String str =(String)list.get(i);                                //从集合当中取出字符串
				pw.println(str);                                                //把该字符串写入文件当中
				}
			pw.close();
			} catch (Exception e){
			       e.printStackTrace();
			   }
			MainUI2.show();
		}
	}
		

}