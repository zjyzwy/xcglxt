package com.scnu.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import com.scnu.modleItem.Parameter;
import com.scnu.modleItem.User;

public class ParameterDao {

	private Parameter parameter = null;

	public Parameter getParameter(String unitName) {
		List<String> list = new ArrayList<>();
		list.add(unitName);
		Vector<String> v = null;
		String sql = "select * from parameter where collegeName =?";
		try {
			v = BaseDao.select(sql, list);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (v != null) {
			parameter = new Parameter();
			parameter.setcollegeId(v.get(0));
			parameter.setCollegeName(v.get(1));
			parameter.setJob(v.get(2));
			parameter.setBasicPerformance(v.get(3));
			parameter.setTitleValue(v.get(4));
			parameter.setStudentValue(v.get(5));
			parameter.setcollegeLW(v.get(6));
			parameter.setJobManagePerformance(v.get(7));
		}

		return parameter;
	}

	public int updateParameter(Parameter parameter) {
		List<String> list = new ArrayList<>();
		list.add(parameter.getJob());
		list.add(parameter.getBasicPerformance());
		list.add(parameter.getTitleValue());
		list.add(parameter.getStudentValue());
		list.add(parameter.getCollegeLW());
		list.add(parameter.getJobManagePerformance());

		list.add(parameter.getCollegeId());
		System.out.println(parameter.getCollegeId());
		String sql1 = "job=?,basicPerformance=?,titleValue=?,studentValue=?,collegeLW=?,jobManagePerformance=?";
		String sql = "update parameter set " + sql1 + "where collegeId=?";
		int updateCount = 0;
		try {
			updateCount = BaseDao.update(sql, list);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return updateCount;
	}

}
