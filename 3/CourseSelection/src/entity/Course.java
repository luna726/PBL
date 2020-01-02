package entity;

public class Course implements IEntity {
	private String courseNo;  //课程编号
	private String courseName;//课程名字
	private int courseGrade;//学分
	public String getCourseNo() {
		return courseNo;
	}
	public void setCourseNo(String courseNo) {
		this.courseNo = courseNo;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public int getCourseGrade() {
		return courseGrade;
	}
	public void setCourseGrade(int courseGrade) {
		this.courseGrade = courseGrade;
	}
	
	
}
