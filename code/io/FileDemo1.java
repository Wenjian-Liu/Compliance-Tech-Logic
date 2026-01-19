package com.itheima.demo1file;

import java.io.File;
import java.io.IOException;

public class FileDemo1 {
	public static void main(String[] args) {
		// 目标：创建File对象代表文件（文件/目录），搞清楚其提供的对文件进行操作的方法
		// 1. 创建File对象，去获取某个文件的信息
		File f1 = new File("D:\\resource\\a.jpg");
//		File f1 = new File("D:/resource/a.jpg");

		System.out.println(f1.length());  // 字节个数
		System.out.println(f1.getName());
		System.out.println(f1.isFile());
		System.out.println(f1.isDirectory());

		// 2. 可以使用相对路径定义文件对象
		// 只要带盘符的都称之为：绝对路径
		// 相对路径：不带盘符，默认是到你的idea工程下直接寻找文件的。一般用来找工程下的文件的
		File f2 = new File("day03-file-io\\src\\liu01.txt");
		System.out.println(f2.length());
		System.out.println(f2.getAbsoluteFile());  // 获取绝对路径

		// 3. 创建对象代表不存在的文件路径
//		File f3 = new File("D:\\Java\\abc.txt");
//		System.out.println(f3.exists());
//		System.out.println(f3.createNewFile());

		// 4. 创建对象代表不存在的目录路径
		File f4 = new File("D:\\Java\\abc");
		System.out.println(f4.mkdir());  // mkdir只能创建一级文件夹

		File f5 = new File("D:\\Java\\abc\\abc");
		System.out.println(f5.mkdirs());

		// 5. 创建File对象代表存在的文件，删除文件
		File f6 = new File("D:\\Java\\abc.txt");
		System.out.println(f6.delete());

		// 6. 创建File对象代表存在的文件夹，删除
		File f7 = new File("D:\\Java\\abc");
		System.out.println(f7.delete());  // 只能删除空文件夹，不能删除非空文件夹

		// 7. 可以获取某个目录下的全部一级文件名称
		File f8 = new File("D:\\Resource");
		String[] names = f8.list();
		for (String name : names) {
			System.out.println(name);
		}

		// 8. 可以获取某个目录下的全部一级文件对象
		File f9 = new File("D:\\Resource");
		File[] files = f9.listFiles();
		for (File file : files) {
			System.out.println(file.getAbsoluteFile());  // 获取绝对路径
		}
	}
}
