package com.scnu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import com.scnu.modleItem.User;

public class TermTimeDao {
	String[] term = null;

	private static PreparedStatement pstm;
	private static Connection con;

	public String[] getTermInfo(String sql) {
		List<String> list = new ArrayList<>();

		Vector<String> vector = new Vector<>();

		try {
			vector = BaseDao.select(sql, list);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		int row = vector.size();
		int i = 0;
		term = new String[row];
		for (String x : vector) {
			term[i] = x;
			i++;
		}

		return term;
	}

	public Vector<String> getTermTimes() {
		ResultSet res;
		Vector<String> termTimes = new Vector<>();
		String sql = "select * from termtime";
		con = new DbConnector().getConnection();
		try {
			pstm = con.prepareStatement(sql);
			res = pstm.executeQuery();
			while (res.next()) {
				termTimes.add(res.getString("term"));
			}
			res.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			pstm.close();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}

		return termTimes;

	}

	public int addTerm(String str) {

		List<String> list = new ArrayList<>();
		list.add(str);
		String sql = "insert into termtime values (?)";

		return BaseDao.insert(sql, list);
	}

	public int addTermTime(String termTime) {
		List<String> list = new ArrayList<>();
		list.add(termTime);
		String sql = "insert into termTime(datetime) values (?)";
		return BaseDao.insert(sql, list);
	}

}
