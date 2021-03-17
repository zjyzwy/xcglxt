package com.scnu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import com.scnu.modleItem.Payoff;
import com.scnu.modleItem.User;

public class PayoffDao {
	private Payoff payoff;
	private static Connection con;
	private static PreparedStatement pstm;

	public Vector<String> getPayoff(String userId, String termTime) {
		Vector<String> payoff = new Vector<>();
		ResultSet res;
		String sql = "select * from payoff where userId ='" + userId + "' and termTime ='" + termTime + "'";
		con = new DbConnector().getConnection();
		try {
			pstm = con.prepareStatement(sql);
			res = pstm.executeQuery();
			if (res.next()) {
				payoff.add(res.getString("userId"));
				payoff.add(res.getString("termTime"));
				payoff.add(res.getString("jobWage"));
				payoff.add(res.getString("basicPerformanceWage"));
				payoff.add(res.getString("lessonWage"));
				payoff.add(res.getString("jobManageWage"));
				payoff.add(res.getString("jobSubsidy"));
				payoff.add(res.getString("overtimeWage"));
				payoff.add(res.getString("subOrAddWage"));
				payoff.add(res.getString("fullTime"));
				payoff.add(res.getString("openTime"));
				payoff.add(res.getString("phoenixTime"));
				payoff.add(res.getString("adultTime"));
				payoff.add(res.getString("jobSubsidies"));
				payoff.add(res.getString("phoneSubsidies"));
				payoff.add(res.getString("lifeSubsidies"));
				payoff.add(res.getString("festivalSubsidies"));
				payoff.add(res.getString("overtimeSubsidies"));
				payoff.add(res.getString("temporarySubsidy"));
				payoff.add(res.getString("other"));
				payoff.add(res.getString("allWage"));
				payoff.add(res.getString("description"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return payoff;

	}

	public Vector<Vector<String>> getmTAO_StatePayoff(String termTime) {

		Vector<Vector<String>> vectors = new Vector<>();
		String sql = "select * from payoff where userId in(select userId from user where mTAO_State='专任教师') and termTime='"
				+ termTime + "'";

		con = new DbConnector().getConnection();
		try {
			pstm = con.prepareStatement(sql);
			ResultSet resultSet = pstm.executeQuery();
			ResultSetMetaData rmd = resultSet.getMetaData();
			int col = rmd.getColumnCount();

			while (resultSet.next()) {
				Vector<String> vector = new Vector<>();
				for (int i = 1; i <= col; i++) {
					vector.add(resultSet.getString(i));
				}
				vectors.add(vector);
			}
			resultSet.close();
			pstm.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vectors;
	}

	public int addPayoff(Payoff payoff) {
		List<String> list = new ArrayList<>();

		list.add(payoff.getUserId());
		list.add(payoff.getTermTime());
		list.add(payoff.getJobWage());
		list.add(payoff.getBasicPerformanceWage());
		list.add(payoff.getLessonWage());
		list.add(payoff.getJobManageWage());
		list.add(payoff.getJobSUbsidy());
		list.add(payoff.getOvertimeWage());
		list.add(payoff.getSubOrAddWage());
		list.add(payoff.getFullTime());
		list.add(payoff.getOpenTime());
		list.add(payoff.getPhoenixTime());
		list.add(payoff.getAdultTime());
		list.add(payoff.getJobSubsidies());
		list.add(payoff.getPhoneSubsidies());
		list.add(payoff.getLifeSubsidies());
		list.add(payoff.getFestivalSubsidies());
		list.add(payoff.getOvertimeSubsidies());
		list.add(payoff.getTemporarySubsidy());
		list.add(payoff.getOther());
		list.add(payoff.getAllwage());
		list.add(payoff.getDescription());

		String sql1 = "userId,termTime,jobWage,basicPerformanceWage,lessonWage,jobManageWage,jobSUbsidy,overtimeWage,subOrAddWage,fullTime,openTime,phoenixTime,adultTime,jobSubsidies,phoneSubsidies,lifeSubsidies,festivalSubsidies,overtimeSubsidies,temporarySubsidy,other,allwage,description";
		String sql = "insert into payoff(" + sql1 + ") values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

		return BaseDao.insert(sql, list);
	}

	public int updatePayoff(Payoff payoff) {
		int updateCount = 0;
		List<String> list = new ArrayList<>();
		con = new DbConnector().getConnection();
		list.add(payoff.getJobWage());
		list.add(payoff.getBasicPerformanceWage());
		list.add(payoff.getLessonWage());
		list.add(payoff.getJobManageWage());
		list.add(payoff.getJobSUbsidy());
		list.add(payoff.getOvertimeWage());
		list.add(payoff.getSubOrAddWage());
		list.add(payoff.getFullTime());
		list.add(payoff.getOpenTime());
		list.add(payoff.getPhoenixTime());
		list.add(payoff.getAdultTime());
		list.add(payoff.getJobSubsidies());
		list.add(payoff.getPhoneSubsidies());
		list.add(payoff.getLifeSubsidies());
		list.add(payoff.getFestivalSubsidies());
		list.add(payoff.getOvertimeSubsidies());
		list.add(payoff.getTemporarySubsidy());
		list.add(payoff.getOther());
		list.add(payoff.getAllwage());
		list.add(payoff.getDescription());

		list.add(payoff.getUserId());
		list.add(payoff.getTermTime());

		String sql1 = "jobWage=?,basicPerformanceWage=?,lessonWage=?,jobManageWage=?,jobSUbsidy=?,overtimeWage=?,subOrAddWage=?,fullTime=?,openTime=?,phoenixTime=?,adultTime=?,jobSubsidies=?,phoneSubsidies=?,lifeSubsidies=?,festivalSubsidies=?,overtimeSubsidies=?,temporarySubsidy=?,other=?,allwage=?,description=?";
		String sql = "update payoff set " + sql1 + " where userId=? and termTime=?";

		try {
			updateCount = BaseDao.update(sql, list);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return updateCount;
	}

	private Payoff creatPayoff(Vector<String> v) {
		Payoff payoff = new Payoff();
		payoff.setUserId(v.get(0));
		payoff.setTermTime(v.get(1));
		payoff.setJobWage(v.get(2));
		payoff.setBasicPerformanceWage(v.get(3));
		payoff.setLessonWage(v.get(4));
		payoff.setJobManageWage(v.get(5));
		payoff.setJobSUbsidy(v.get(6));
		payoff.setOvertimeWage(v.get(7));
		payoff.setSubOrAddWage(v.get(8));
		payoff.setFullTime(v.get(9));
		payoff.setOpenTime(v.get(10));
		payoff.setPhoenixTime(v.get(11));
		payoff.setAdultTime(v.get(12));
		payoff.setJobSubsidies(v.get(13));
		payoff.setPhoneSubsidies(v.get(14));
		payoff.setLifeSubsidies(v.get(15));
		payoff.setFestivalSubsidies(v.get(16));
		payoff.setOvertimeSubsidies(v.get(17));
		payoff.setTemporarySubsidy(v.get(18));
		payoff.setOther(v.get(19));
		payoff.setAllwage(v.get(20));
		payoff.setDescription(v.get(21));
		return payoff;
	}
}
