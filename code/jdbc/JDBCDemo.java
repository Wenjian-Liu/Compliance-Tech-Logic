package com.wenjian.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * JDBC快速入门
 */
public class JDBCDemo {

	public static void main(String[] args) throws Exception {
		//1. 注册驱动
		Class.forName("com.mysql.cj.jdbc.Driver");

		//2. 获取连接
		String url = "jdbc:mysql://127.0.0.1:3306/db1";
		String username = "root";
		String password = "1234";
		Connection conn = DriverManager.getConnection(url, username, password);

		//3. 定义sql
		//String sql = "create table user(id int, name varchar(20))";
		//String sql = "insert into user values(1, 'wenjian')";  //1

		//3. 定义查询sql
		String sql = "select * from user";

		//4. 获取执行sql的对象
		Statement stmt = conn.createStatement();

		//5. 执行sql
		//int count = stmt.executeUpdate(sql);

		//System.out.println("创建表成功！返回值：" + count);

		//5. 执行sql并接受结果集
		ResultSet rs = stmt.executeQuery(sql);

		//6. 处理结果，遍历rs中的所有数据
		// 6.1 光标项下移动一行，并且判断当前行是否有数据
		while (rs.next()) {
			//6.2 获取数据  getXxx()
			int id = rs.getInt("id");
			String name = rs.getString("name");
			System.out.println("从数据库抓取到数据：编号 = " + id + "，姓名 = " + name);
		}

		//7. 释放资源
		rs.close();
		stmt.close();
		conn.close();
	}
}
