package dao;
import java.io.*;
import java.util.*;
import entity.*;

public class SCDao implements IDao {
	
	private static SCDao instance;
	private HashMap<String, IEntity> scs;
	private SC sc;
	private FileInputStream fs;
    private FileOutputStream fos;
    
    private SCDao() {
    	scs = new HashMap<String,IEntity>();
		sc = new SC();
    	getSCFormInputStream("C:\\Users\\DELL\\Desktop\\java大作业\\5\\CourseSelection\\sc.txt");
    }

	private void getSCFormInputStream(String isName) {
		// TODO Auto-generated method stub
		try {
			fs=new FileInputStream(isName);
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
						this.processSCString(new String(content,"GBK").trim());
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
	
	private void putSCToFile(String uString,String osName){
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
	
	private void processSCString(String scString) {
		String[] scFields=scString.split(",");
   	 	SC sc = new SC();
   	 	sc.setStudentNo(scFields[0]);
   	 	sc.setCourseNo(scFields[1]);
   	 	sc.setGrade(Integer.parseInt(scFields[2]));
   	 	scs.put(sc.getStudentNo(), sc);
	}
	
	public static SCDao getInstance() {
   		if(instance == null) {
   			synchronized(SCDao.class) {
   				if(instance == null) {
   					instance = new SCDao();
   				}
   			}
   		}
   		return instance;
   	}
	

	@Override
	public void insert(IEntity entity) {
		// TODO Auto-generated method stub
		SC sc= (SC)entity;
   		scs.put(sc.getStudentNo(), sc);

	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub

	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		Set<String> scSet=scs.keySet();
	   	 StringBuffer scStringBuffer=new StringBuffer();
	   	 for(String studentNo:scSet) {
	   		 SC sc=(SC)scs.get(studentNo);
				String uString = sc.getStudentNo()+";"
						+sc.getCourseNo().toString()+";"+
						sc.getGrade()+"\r\n";
				scStringBuffer.append(uString);
	   	 }
	   	 putSCToFile(scStringBuffer.toString(),"C:\\Users\\DELL\\Desktop\\java大作业\\5\\CourseSelection\\sc.txt");
	   	 
	   	
   		scs.put(sc.getStudentNo(), sc);
	}
	
	
	

	@Override
	public HashMap<String, IEntity> getAllEntities() {
		// TODO Auto-generated method stub
		return scs;
	}

	@Override
	public IEntity getEntity(String Id) {
		// TODO Auto-generated method stub
		return scs.get(Id);
	}
}
