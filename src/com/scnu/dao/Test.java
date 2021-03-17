package com.scnu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		DbConnector dbc = new DbConnector();
		Connection con = dbc.getConnection();
		
		
		//测试时用于写入数据
		PreparedStatement pstm = null;
		String sql1 = "user_id,staff_id,pay,amount,payment_date,last_update";
		Date datetime = new Date();
		SimpleDateFormat temp = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String date1 = temp.format(datetime);
		Date date2 = new Date();
		long longTime = date2.getTime();
		Timestamp timestamp = new Timestamp(longTime);
		java.sql.Date sDate = null;
		  try {
			  SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		   java.util.Date date3 = sdf2.parse(date1);
		   sDate = new java.sql.Date(date3.getTime());
		  } catch (ParseException e) {
		   e.printStackTrace();
		  }
		String sql = "insert into payment (" + sql1 +") values(1,1,1,1,?,?)";
		try {
			pstm = con.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		for(int i=0;i<50;i++) {
			try {
				pstm.setDate(1, sDate);
				pstm.setTimestamp(2, timestamp);
				pstm.executeUpdate();
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
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
	}

}
