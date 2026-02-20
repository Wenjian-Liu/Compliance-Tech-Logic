package com.wenjian.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * JDBC快速入门
 */
public class JDBCSelectAll {

	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		String url = "jdbc:mysql://127.0.0.1:3306/db1";
		String username = "root";
		String password = "1234";
		Connection conn = DriverManager.getConnection(url, username, password);

		//1. 定义一个List集合，准备准给所有的User对象
		List<User> list = new ArrayList<>();

		//2. 准备sql
		String sql = "select * from user";

		//3. 使用PreparedStatement
		PreparedStatement pstmt = conn.prepareStatement(sql);

		//4. 执行sql并接受结果集
		ResultSet rs = pstmt.executeQuery();

		//5. 处理结果集
		while (rs.next()) {
			//5.1 获取每一行的数据
			int id = rs.getInt("id");
			String name = rs.getString("name");

			//5.2 把这行数据封装进User对象里
			User user = new User();
			user.setId(id);
			user.setName(name);

			//5.3 把装好的对象放入List集合
			list.add(user);
		}

		//6. 打印集合
		System.out.println(list);

		//7. 释放资源
		rs.close();
		pstmt.close();
		conn.close();
	}
}