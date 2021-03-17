package com.scnu.modleItem;

public class Parameter {

	private String collegeName;
	private String collegeId;
	private String job;
	private String basicPerformance;
	private String titleValue;
	private String studentValue;
	private String collegeLW;
	private String jobManagePerformance;

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getJob() {
		return job;
	}

	public void setBasicPerformance(String basicPerformance) {
		this.basicPerformance = basicPerformance;
	}

	public String getBasicPerformance() {
		return basicPerformance;

	}

	public void setTitleValue(String titleValue) {
		this.titleValue = titleValue;
	}

	public String getTitleValue() {
		return titleValue;
	}

	public String getStudentValue() {
		return studentValue;
	}

	public void setStudentValue(String studentValue) {
		this.studentValue = studentValue;
	}

	public void setcollegeLW(String collegeLW) {
		this.collegeLW = collegeLW;
	}

	public String getCollegeLW() {
		return collegeLW;
	}

	public void setJobManagePerformance(String jobManagePerformance) {
		this.jobManagePerformance = jobManagePerformance;
	}

	public String getJobManagePerformance() {
		return jobManagePerformance;
	}

	public String[] getJobWage() {
		String[] a = job.split(","); // ����,������,��ʦ,����,Ժ��/���,��Ժ��/�����,ϵ\��\��������,ϵ\��\���ĸ�����,����
		return a;
	}

	public String[] getBasicPerformanceWage() {
		String[] a = basicPerformance.split(","); // ����,������,��ʦ,����,Ժ��/���,��Ժ��/�����,ϵ\��\��������,ϵ\��\���ĸ�����,����
		return a;
	}

	public String[] getTitleValueWage() {
		String[] a = titleValue.split(","); // ����,������,��ʦ,����,����
		return a;
	}

	public String[] getJobManagePerformanceWage() {
		String[] a = jobManagePerformance.split(","); // Ժ��/���,��Ժ��/�����,ϵ\��\��������,ϵ\��\���ĸ�����,����
		return a;
	}

	public String getCollegeId() {
		return collegeId;
	}

	public void setcollegeId(String collegeId) {
		this.collegeId = collegeId;
	}

}
