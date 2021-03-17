package com.scnu.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import com.scnu.modleItem.Workload;

public class WorkloadEntryDao {

	Workload workload = null;

	public int addWorkload(Workload workload) {

		List<String> list = new ArrayList<>();
		list.add(workload.getTerm());
		list.add(workload.getUserID());
		list.add(workload.getUserName());
		list.add(workload.getFullTime());
		list.add(workload.getOpenTime());
		list.add(workload.getPhoenixTime());
		list.add(workload.getAdultTime());

		String sql1 = "term,userID,userName,fullTime,openTime,phoenixTime,adultTime";
		String sql = "insert into workload (" + sql1 + ") values (?,?,?,?,?,?,?)";

		return BaseDao.insert(sql, list);
	}

	public String[][] getWorkload(String userId) {
		List<String> list = new ArrayList<>();
		list.add(userId);
		Vector<Vector<String>> vectors = null;
		String sql = "select * from workload where userId=? ";
		try {
			vectors = BaseDao.selectAll(sql, list);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		int row = vectors.size();
		int i = 0;
		String[][] t_data = new String[row][7];
		for (Vector<String> x : vectors) {
			for (int j = 0; j < 7; j++) {
				t_data[i][j] = x.get(j);
			}
			i++;
		}
		return t_data;

	}

	public int updateWorkload(Workload workload) {
		List<String> list = new ArrayList<>();
		list.add(workload.getFullTime());
		list.add(workload.getOpenTime());
		list.add(workload.getPhoenixTime());
		list.add(workload.getAdultTime());

		list.add(workload.getTerm());
		list.add(workload.getUserID());
		list.add(workload.getUserName());

		String sql1 = " fullTime=?,openTime=?,phoenixTime=?,adultTime=? ";
		String sql = "update workload set " + sql1 + " where term=? and userId=? and userName=?";
		int updateCount = 0;
		try {
			updateCount = BaseDao.update(sql, list);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return updateCount;
	}

	public boolean existWorkload(String term, String userId) {
		List<String> list = new ArrayList<>();
		list.add(term);
		list.add(userId);
		Vector<String> v = null;
		String sql = "select * from workload where term=? and userId=?";
		try {
			v = BaseDao.select(sql, list);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		if (v.isEmpty()) {
			return false;
		} else {
			return true;
		}
	}

}
