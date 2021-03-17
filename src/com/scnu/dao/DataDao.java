package com.scnu.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class DataDao {

	String[][] t_data = null;

	public String[][] get_t_datas(String sql) {

		List<String> list = new ArrayList<>();

		Vector<Vector<String>> vectors = new Vector<>();
		try {
			vectors = BaseDao.selectAll(sql, list);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}

		int rows = vectors.size();
		int i = 0;
		t_data = new String[rows][6];
		for (Vector<String> x : vectors) {
			for (int j = 0; j < 6; j++) {
				t_data[i][j] = x.get(j);
			}
			i++;
		}

		return t_data;
	}
}
